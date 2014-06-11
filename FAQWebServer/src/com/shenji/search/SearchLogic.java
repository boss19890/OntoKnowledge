package com.shenji.search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

import org.apache.axis2.databinding.types.soapencoding.Array;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.TermVector;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;
import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.wltea.analyzer.lucene.SynonymAnalyzer;
import org.wltea.analyzer.lucene.SynonymEngine;

import cn.sjxx.knowledge.OntologyStub;

import com.shenji.DBManager.DBManager;
import com.shenji.DBManager.DBUserManager;
import com.shenji.DBManager.DBUtil;
import com.shenji.common.Common;
import com.shenji.filemanager.FileManager;
import com.shenji.log.WriteLog;
import com.shenji.searchThread.SearchThread;
import com.shenji.searchWay.AllSearch;
import com.shenji.services.FileNameBean;
import com.shenji.services.GetFileXML;
import com.shenji.services.GetTreeXML;
import com.shenji.services.ReasonerService;
import com.shenji.services.SearchNonBusinessMatching;
import com.shenji.services.SearchPatternMatching;
import com.shenji.tools.BusinessDict;
import com.shenji.tools.IKDict;
import com.shenji.tools.IKDictTool;
import com.shenji.tools.AllSynonmDict;
import com.shenji.tools.MySynonymDictTool;
import com.shenji.tools.RefreshIndex;
import com.shenji.tools.SynonmIndexTool;
import com.shenji.tools.SynonymDict;
import com.shenji.train.DecisionSystem;
import com.shenji.train.FAQControl;
import com.shenji.train.QAControl;
//import com.sun.org.apache.bcel.internal.generic.NEW;
import com.shenji.util.FileUse;
import com.shenji.util.StringMatching;



/**
 * webServices接口清单类
 * @author sj
 *
 */
public class SearchLogic {
	//全局锁（词典等文件互斥操作）
	private static final Object LOCK = SearchLogic.class;
	//返回最大的结果数
	public static int maxResult = 200;
	//更多标签前显示结果数
	public static int showResult=20;
	//最大显示字数
	public static int maxTestShow = 200;
	//权重(未启用)
	//private static double[] weight = { 0.5, 0.3, 0.2 };
	//网页分割线
	public static double[] cutLine = { 0.95, 0.8, 0.7, 0.5, 0.3, 0};

	// private static ArrayList<String> newWordsList=new ArrayList<String>();;
	
	static{
		loadConfig();
	}
	private static void loadConfig(){
		IniEditor config = new IniEditor();
		try {
			String path = SearchLogic.class.getClassLoader().getResource("")
					.toURI().getPath();
			config.load(path + "config.ini");
			maxResult = Integer.parseInt(config.get("config", "MaxResult"));
			maxTestShow = Integer.parseInt(config.get("config", "MaxTextShow"));
			Common.maxMatchWeight=Float.parseFloat(config.get("config", "maxMatchWeight"));
			Common.myIkdictWeight=Float.parseFloat(config.get("config", "myIkdictWeight"));
			Common.qaProportion=Float.parseFloat(config.get("config", "qaProportion"));
		    //这里只启用FAQ，故只有weight暂时无效
			/*weight[0] = Double.parseDouble(config.get("config", "Faq"));
			weight[1] = Double.parseDouble(config.get("config", "Learn"));
			weight[2] = Double.parseDouble(config.get("config", "Web"));*/
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),SearchLogic.class.getName());
		}
	}
	
	/**
	 * 构造函数
	 */
	public SearchLogic() {}

	/**
	 * 修改Config配置文件
	 * @param maxResult 最大的结果数
	 * @param maxTextShow 最大显示字数
	 * @param faq faq权重
	 * @param learn learn权重
	 * @param web web权重
	 * @return
	 */
	/*public int SetConfig(String maxResult, String maxTextShow, String maxMatchWeight,
			String myIkdictWeight, String qaProportion) {
		IniEditor config = new IniEditor();
		try {
			String path = SearchLogic.class.getClassLoader().getResource("")
					.toURI().getPath();
			config.load(path+"config.ini");
			config.set("config", "MaxResult", maxResult);
			config.set("config", "MaxTextShow", maxTextShow);
			config.set("config", "maxMatchWeight", maxMatchWeight);
			config.set("config", "myIkdictWeight", myIkdictWeight);
			config.set("config", "qaProportion", qaProportion);
			config.save(path+"config.ini");
			return 1;
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SearchLogic.class.getName());
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return -1;
		}
	}*/
	
	public int SetConfig(int maxResult, int maxTextShow, float maxMatchWeight,
			float myIkdictWeight, float qaProportion) {	
		if(maxResult==-1&&maxTextShow==-1&&maxMatchWeight==-1&&myIkdictWeight==-1&&qaProportion==-1){
			Common.ResetParameters();
			maxMatchWeight=Common.maxMatchWeight;
			myIkdictWeight=Common.myIkdictWeight;
			qaProportion=Common.qaProportion;
			maxResult=SearchLogic.maxTestShow;
			maxTextShow=SearchLogic.maxTestShow;	
			return saveConfig(maxResult, maxTextShow, maxMatchWeight, myIkdictWeight, qaProportion);
		}	
		if(maxResult<0||maxTextShow<0||maxMatchWeight<1||myIkdictWeight<1||qaProportion<1)
			return -2;
		else{
			int reFlag=saveConfig(maxResult, maxTextShow, maxMatchWeight, myIkdictWeight, qaProportion);
			if(reFlag>0){
				this.loadConfig();
			}
			return reFlag;
		}
	}
	private int saveConfig(int maxResult, int maxTextShow, float maxMatchWeight,
			float myIkdictWeight, float qaProportion){
		IniEditor config = new IniEditor();
		try {
			String path = SearchLogic.class.getClassLoader().getResource("")
					.toURI().getPath();
			config.load(path+"config.ini");
			config.set("config", "MaxResult", Integer.toString(maxResult));
			config.set("config", "MaxTextShow", Integer.toString(maxTextShow));
			config.set("config", "maxMatchWeight", Float.toString(maxMatchWeight));
			config.set("config", "myIkdictWeight", Float.toString(myIkdictWeight));
			config.set("config", "qaProportion", Float.toString(qaProportion));
			config.save(path+"config.ini");
			return 1;
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),SearchLogic.class.getName());
			return -1;
		}
	}

	/**
	 * 查看配置文件
	 * @return 配置文件字符串
	 */
	public String GetConfig() {
		IniEditor config = new IniEditor();
		String result = "";
		try {
			String path = SearchLogic.class.getClassLoader().getResource("")
					.toURI().getPath();
			config.load(path+"config.ini");
			result += config.get("config", "MaxResult") + ";";
			result += config.get("config", "MaxTextShow") + ";";
			result += config.get("config", "maxMatchWeight") + ";";
			result += config.get("config", "myIkdictWeight") + ";";
			result += config.get("config", "qaProportion");
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),SearchLogic.class.getName());
		}
		return result;
	}

	/*
	 * public String Search(String args) { int taskSize = 3; ExecutorService
	 * pool = Executors.newCachedThreadPool(); List<Future<List<SearchBean>>>
	 * list = new ArrayList<Future<List<SearchBean>>>(); List<SearchBean> result
	 * = new ArrayList<SearchBean>(); for (int i = 0; i < taskSize; i++) {
	 * Callable<List<SearchBean>> c = new
	 * SearchThread(args,Common.searchDir[i],maxTestShow); //
	 * ִ�����񲢻�ȡFuture���� Future<List<SearchBean>> f = pool.submit(c);
	 * list.add(f); } // �ر��̳߳�
	 * 
	 * try{ for (Future<List<SearchBean>> f : list) { //
	 * ��Future�����ϻ�ȡ����ķ���ֵ�������������̨ List<SearchBean> subList
	 * =f.get(); for (SearchBean s : subList) { result.add(s); } }
	 * DecisionSystem system=new DecisionSystem(args);
	 * system.customSort(result);
	 * 
	 * 
	 * int len = result.size()>maxResult?maxResult:result.size(); StringBuilder
	 * html = new StringBuilder(
	 * "<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><head><title>Search</title>"
	 * );
	 * html.append("<style>em{font-style:normal;color:#cc0000}</style></head><body>"
	 * ); //String[] r = new String[len]; //System.out.println(len); int i = 0;
	 * 9月5日添加：添加分割线 int cutLineFlag=0; int cutLineCount=0; double
	 * frontSimilarity=cutLine[0]; if(len==0) html.append("<div>无法找到答案！</div>");
	 * for(int j=0;j<result.size();j++) { SearchBean bean=result.get(j);
	 * if(j!=0) frontSimilarity=result.get(j-1).getSimilarity();
	 * html.append("<div>"+bean.getContent()+"</div><br>");
	 * if((cutLineFlag<cutLine.length
	 * &&bean.getSimilarity()>=cutLine[cutLineFlag])
	 * ||bean.getSimilarity()>frontSimilarity ){ //cutLineCount++; } else{ {
	 * html.append(
	 * "<div style=\"text-align:center; vertical-align:middle; line-height:24px\">以上相关度大于"
	 * +cutLine[cutLineFlag]+"</div>"); html.append(
	 * "<hr width=100% size=1 color=#00ffff style=\"border:1 dashed #00ffff\">"
	 * ); //cutLineCount=0; } cutLineFlag++; }
	 * if(j==(len-1)&&cutLineFlag!=(cutLine.length-1)){ html.append(
	 * "<div style=\"text-align:center; vertical-align:middle; line-height:24px\">以上相关度大于"
	 * +cutLine[cutLineFlag]+"</div>"); html.append(
	 * "<hr width=100% size=1 color=#00ffff style=\"border:1 dashed #00ffff\">"
	 * ); } if(cutLineFlag>=cutLine.length) break; ------------
	 * //System.out.println(bean.getScore()); i++; if(i==len) break; }
	 * html.append("</body></html>"); pool.shutdown(); return html.toString();
	 * }catch(Exception e){ e.printStackTrace(); return null; } }
	 */
	
	/**
	 * 搜索（带问答对数）
	 * @param args 搜索的关键词或句子
	 * @param number 需要返回的问答对数
	 * @return 问答对，偶数为问，单数为答，一一对应
	 */
	private String[] Search_numFAQ(String args,int number){
		String[] reFlag=new String[number*2];
		try{		
			int count=0;
			String xml=this.SearchFAQWithNum(args);
			org.jsoup.nodes.Document doc=Jsoup.parse(xml);
			Iterator iterator=doc.select("a").iterator();	
			while(iterator.hasNext()){
				Element em=(Element) iterator.next();
				if(count>=number*2)
				{
					break;
				}
				String url=em.attr("href");
				String[] result=copeOneHtml(url);
				if(result==null||result.length==0)
					continue;
				reFlag[count]=result[0];
				count++;
				reFlag[count++]=result[1];
			}		
		}
		catch(Exception e){
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),SearchLogic.class.getName());
			return null;
		}
		if(reFlag[1]==null)
			return null;
		else
			return reFlag;
	}
	
	public String[] Search_numWithUrl(String args,int number){
		String mattchingStr=null;
		if((mattchingStr=SearchPatternMatching.questionMatching(args))!=null){
			args=mattchingStr;
		}
		try{
			DBManager dbManager = new DBManager();
			String answer = dbManager.getAnswer(args);
			String[]s = new String[1];
			//如果从数据库中取得数据则返回长度为1的字符串数组
			if(answer!=null&&!answer.equals("")){
				s[0] = "答:"+answer;
				return s;
			}else{
				//非业务问题直接提取答案
				if((mattchingStr=SearchNonBusinessMatching.matching(args))!=null){
					s[0] = "答:"+mattchingStr;
					return s;
				}
			}
		}catch (Exception e) {
			return Search_numFAQWithUrl(args, number);
		}
		return Search_numFAQWithUrl(args, number);
	}
	
	private String[] Search_numFAQWithUrl(String args,int number){
		String[] reFlag=new String[number*3];
		try{		
			int count=0;
			String xml=this.SearchFAQWithNum(args);
			org.jsoup.nodes.Document doc=Jsoup.parse(xml);
			Iterator iterator=doc.select("a").iterator();	
			while(iterator.hasNext()){
				Element em=(Element) iterator.next();
				if(count>=number*3)
				{
					break;
				}
				String url=em.attr("href");
				String[] result=copeOneHtml(url);
				if(result==null||result.length==0)
					continue;
				reFlag[count++]=url;
				reFlag[count++]=result[0];
				reFlag[count++]=result[1];
			}		
		}
		catch(Exception e){
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),SearchLogic.class.getName());
			return null;
		}
		if(reFlag[1]==null)
			return null;
		else
			return reFlag;
	}
	
	private String SearchFAQWithNum(String args){
		return SearchFAQWithType(args,"2");
	}
	
	
	public String[] Search_num(String args,int number){
		String mattchingStr=null;
		if((mattchingStr=SearchPatternMatching.questionMatching(args))!=null){
			args=mattchingStr;
		}
		try{
			DBManager dbManager = new DBManager();
			String answer = dbManager.getAnswer(args);
			String[]s = new String[1];
			//如果从数据库中取得数据则返回长度为1的字符串数组
			if(answer!=null&&!answer.equals("")){
				s[0] = "答:"+answer;
				return s;
			}else{
				//非业务问题直接提取答案
				if((mattchingStr=SearchNonBusinessMatching.matching(args))!=null){
					s[0] = "答:"+mattchingStr;
					return s;
				}
			}
		}catch (Exception e) {
			return Search_numFAQ(args, number);
		}
		return Search_numFAQ(args, number);
	}
	
	
	
	
	private String[] copeOneHtml(String url) throws IOException{
		org.jsoup.nodes.Document doc=Jsoup.connect(url).get();
		String[] str=new String[2]; 
		try{
			String q=doc.getElementsByClass("q").get(0).html();
			String a=doc.getElementsByClass("a").get(0).html();
			str[0]=q;
			str[1]=a;
			return str;
		}
		catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),SearchLogic.class.getName());
			e.printStackTrace();
			return null;
		}	
	}
	
	/*public String[] Search_num(String args,int number){
		String[] reFlag=new String[number*2];
		try{
			
			String xml=this.Search(args);
			org.jsoup.nodes.Document doc=Jsoup.parse(xml);
			Iterator<Element> divqs=doc.getElementsByClass("q").iterator();
			Iterator<Element> divas=doc.getElementsByClass("a").iterator();
			int count=0;
			if(!divqs.hasNext()||!divas.hasNext())
				return null;
			int temp=1;
			while(divqs.hasNext()){
				if(temp>number)
					break;
				temp++;
				Element e=divqs.next();
				if(e!=null){
					reFlag[count]=e.html();
					count=count+2;
				}
				//System.err.println(e.text());
			}
			count=1;
			temp=1;
			while(divas.hasNext()){
				if(temp>number)
					break;
				temp++;
				Element e=divas.next();
				if(e!=null){
					reFlag[count]=e.html();
					count=count+2;
				}
				//System.err.println(e.text());
			}
		}
		catch(Exception e){
			//Logger logger=
			return null;
			
		}
		return reFlag;
	}*/

	/**
	 * 搜索（或搜索）
	 * @param args 搜索的关键词或句子（查询请求）
	 * @return HTML文本
	 */
	public String SearchFAQ(String args){
		return SearchFAQWithType(args,"3");
	}
	
	
	/**
	 * 搜索（或搜索）
	 * @param args 搜索的关键词或句子（查询请求）
	 * @param type 搜索类型：1为交互搜索；2为过滤搜索；3为普通搜索
	 * @return HTML文本
	 */
	public String SearchFAQWithType(String args,String type){
		args = args.toLowerCase();
		int taskSize = 3;
		//新建线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		//存放带返回值的线程列表
		List<Future<List<SearchBean>>> list = new ArrayList<Future<List<SearchBean>>>();
		//存放查询结果的结果集
		List<SearchBean> result = new ArrayList<SearchBean>();
		//开启Common.searchDir.length个线程
		for (int i = 0; i < Common.searchDir.length; i++) {
			//新建线程
			Callable<List<SearchBean>> c = new SearchThread(args,
					Common.searchDir[i], maxTestShow,SearchThread.OR_SEARCH,type);
			//提交带返回值的线程给线程池
			Future<List<SearchBean>> f = pool.submit(c);
			list.add(f);
		}
		try {
			for (Future<List<SearchBean>> f : list) {
				//阻塞方法，得到线程中的结果
				List<SearchBean> subList = f.get();
				//讲该线程查询结果添加到结果集中
				for (SearchBean s : subList) {
					result.add(s);
				}
			}
			//打分评测系统
			DecisionSystem system = new DecisionSystem(args);
			//添加分割线
			String html = system.cutlineSortWithType(result,type);
			//关闭线程池
			pool.shutdown();
			return html;
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),SearchLogic.class.getName());
			return null;
		}
	}
	
	
	public String Search(String args) {
		return SearchWithType(args,"1");
	}
	
	
	public static void main(String[]args){
		
		SearchLogic searchLogic = new SearchLogic();
//		System.out.println(searchLogic.SearchFAQWithType("发票出错", "1"));
		System.out.println(System.currentTimeMillis());
		System.out.println(searchLogic.IKAnalysisAndSyn("网上电子报税软件开票中申报出错怎么办"));
		System.out.println(System.currentTimeMillis());
	}
	
	/** 带搜索类型搜索
	 * @param args 搜索的关键词或句子（查询请求）
	 * @param type 搜索类型：1为交互搜索；2为过滤搜索；3为普通搜索
	 */
	public String SearchWithType(String args,String type){
		String mattchingStr=null;
		if((mattchingStr=SearchPatternMatching.questionMatching(args))!=null){
			args=mattchingStr;
		}
		try{
			//搜索数据库
			DBManager dbManager = new DBManager();
			String answer = dbManager.getAnswer(args);
			if(answer!=null&&!answer.equals("")){
				return "答:"+answer;
			}else{
				//非业务问题直接提取答案
				if((mattchingStr=SearchNonBusinessMatching.matching(args))!=null){
					return "答:"+mattchingStr;
				}
				return SearchFAQWithType(args, type);
			}
		}catch (Exception e) {
			return SearchFAQWithType(args,type);
		}
	}
	
	
	/**
	 * 搜索（和搜索）
	 * @param args 搜索的关键词或句子
	 * @return HTML文本
	 */
	public String Search_and(String args) {
		args = args.toLowerCase();
		int taskSize = 3;
		ExecutorService pool = Executors.newCachedThreadPool();
		List<Future<List<SearchBean>>> list = new ArrayList<Future<List<SearchBean>>>();
		List<SearchBean> result = new ArrayList<SearchBean>();
		
		for (int i = 0; i < Common.searchDir.length; i++) {
			Callable<List<SearchBean>> c = new SearchThread(args,
					Common.searchDir[i], maxTestShow,SearchThread.AND_SEARCH);
			Future<List<SearchBean>> f = pool.submit(c);
			list.add(f);
		}
		try {
			for (Future<List<SearchBean>> f : list) {
				List<SearchBean> subList = f.get();
				for (SearchBean s : subList) {
					result.add(s);
				}
			}
			DecisionSystem system = new DecisionSystem(args);
			String html = system.cutlineSort(result);
			pool.shutdown();
			return html;
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SearchLogic.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return null;
		}
	}
	
	/**
	 * 列出所有的FAQ
	 * @return HTML文本
	 */
	public String ListAllFaq() {
		StringBuilder html = new StringBuilder(
				"<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><head><title>Search</title>");
		html.append("<style>em{font-style:normal;color:#cc0000}</style></head><body>");
		try {
			List<SearchBean> result = new AllSearch()
					.getResult(Common.searchDir[0]);
			for (SearchBean bean : result) {
				html.append("<div>" + bean.getContent() + "</div><br>");
			}
			return html.toString();
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SearchLogic.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			html.append("<div>FAQ为空!</div>");
		}
		html.append("</body></html>");
		return html.toString();
	}

	/*
	 * public String[] WebSearch(String str) {
	 * 
	 * String urlStr[] = CatchURL.GetURL(str); int taskSize = urlStr.length;
	 * ExecutorService pool = Executors.newFixedThreadPool(taskSize);
	 * List<Future<String>> list = new ArrayList<Future<String>>(); String[]
	 * result = new String[taskSize]; for (int i = 0; i < taskSize; i++) {
	 * Callable<String> c = new WebSearchThread(urlStr[i]); //
	 * ִ�����񲢻�ȡFuture���� Future<String> f = pool.submit(c); list.add(f); } //
	 * �ر��̳߳� pool.shutdown(); int i=0; for (Future<String> f : list) {
	 * if(f==null) result[i++] = null; else try { result[i++] = f.get(); } catch
	 * (Exception e) { e.printStackTrace(); } } return result;
	 * 
	 * }
	 */ 
	/**
	 * 中文分词
	 * @param str 需要被处理的句子
	 * @return 分词结果字符串（以‘/’分割）
	 */
	public String IKAnalysis(String str) {
		return IKAnalysisWithCon(str,false);
	}
	
	public String IKAnalysisMax(String str){
		String result = IKAnalysisWithCon(str,true);
		if(result!=null&&result.length()!=0){
			int position = -1;
			String [] fencis = result.split("/");
			String maxFencis = "";
			String pre = "";
			for(String fenci:fencis){
				int p = str.indexOf(fenci);
				while(p<=position){
					fenci = fenci.substring(1);
					if(fenci==null||fenci.length()==0)
						break;
					p = str.indexOf(fenci);
				}
				if(fenci!=null&&fenci.length()!=0){
					position = p+fenci.length()-1;
					maxFencis = maxFencis+fenci+"/";
				}
			}
			return maxFencis;
		}
		return null;
	}
	
	public String IKAnalysisWithCon(String str,boolean condition){

		str = str.trim().toLowerCase();
		StringBuffer sb = new StringBuffer();
		try {
			StringReader reader = new StringReader(str);
			/* 9锟斤拷9锟斤拷锟睫改ｏ拷锟筋长锟街词革拷为锟斤拷锟斤拷执锟?*/
			IKSegmentation iks = new IKSegmentation(reader, condition,str);
			Lexeme t;
			while ((t = iks.next()) != null) {
				sb.append(t.getLexemeText() + "/");
			}
			String[] chEnDict=iks.getChEnDict();
			for(String s:chEnDict)
				sb.append(s+"/");
			sb.delete(sb.length() - 1, sb.length());
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SearchLogic.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		// System.out.println(sb.toString());
		return sb.toString();
	
	}
	
	//获得分词和分词的同义词
	public String IKAnalysisAndSyn(String str){
		return IKAnalysisAndSynWithCon(str,false);
	}

	//最大分词、同义词
	public String IKAnalysisAndSynMax(String str){
		return IKAnalysisAndSynWithCon(str,true);
	}
	
	private String IKAnalysisAndSynWithCon(String str,boolean isMax){
		String fenci;
		if(isMax){
			fenci = IKAnalysisMax(str);
		}else{
			fenci = IKAnalysis(str);
		}
		String []fencis = fenci.split("/");
		List<String>list =  Arrays.asList(fencis);;
		String result = "";
		SynonmIndexTool indexTool=new SynonmIndexTool();
		for(String word:list){
			result = result+word+"/";
			String syns = indexTool.getSynonmWordsFromIndex(word);
			if(syns!=null&&syns.length()!=0){
				result = result+syns+"/";
			}
		}
		return result;
	}
	
	
	/**
	 * 修改分词库单词
	 * @param oldWord 旧单词
	 * @param newWord 新单词
	 * @return 1成功 小于1失败
	 */
	public int modifyWords(String oldWord, String newWord) {
		oldWord = oldWord.trim().toLowerCase();
		newWord = newWord.trim().toLowerCase();
		DBManager dbManager = new DBManager();
		String operation = "修改分词库单词";
		String parameter = "新分词："+newWord+";原来分词："+oldWord;
		dbManager.ModifyLog(operation, parameter);
		synchronized (LOCK) {
			return new IKDictTool().modifyWords(oldWord, newWord);
		}
	}

	/**
	 * 删除分词库单词
	 * @param words 单词组
	 * @return 1成功 小于1失败
	 */
	public int deleteWords(String[] words) {
		DBManager dbManager = new DBManager();
		String operation = "删除分词库单词";
		String parameter = "删除的分词：";
		for(String word:words)
			parameter = parameter+word+";";
		dbManager.ModifyLog(operation, parameter);
		synchronized (LOCK) {
			return new IKDictTool().deleteWords(words);
		}
	}

	/**
	 * 添加分词库单词
	 * @param content 新单词
	 * @return 1成功 小于1失败
	 */
	public int AddNewWords(String content) {
		content = content.trim().toLowerCase();
		DBManager dbManager = new DBManager();
		String operation = "添加分词库单词";
		String parameter = "添加的分词："+content;
		dbManager.ModifyLog(operation, parameter);
		synchronized (LOCK) {
			return new IKDictTool().AddNewWords(content);
		}
	}

	/**
	 * 【暂时无用】反馈
	 * @param url url地址
	 * @param count 评分
	 * @return
	 */
	public int FeedBack(String url, String count) {
		DBUtil dataBaseUtil = new DBUtil();
		DataBaseOpeare dataBaseOpeare = new DataBaseOpeare(
				dataBaseUtil.getConnection());
		int result=0;
		if (url.indexOf(Common.faqFolder) > -1)
			result=dataBaseOpeare.modify(url,Common.faqFolder,count);
		else if (url.indexOf(Common.webFolder) > -1)
			result=dataBaseOpeare.modify(url,Common.webFolder,count);
		else
			result=dataBaseOpeare.modify(url,Common.learnFolder,count);
		dataBaseOpeare.close();
		dataBaseUtil.close();
		return result;
	}

	/*
	 * public int deleteDialogue(String url){
	 * 
	 * }
	 */

	/*public void AddNewDialogue(String str, String id) {
		SynonymEngine engine = null;
		StringBuilder sb = new StringBuilder();
		sb.append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		sb.append("<head><title>Search</title></head><body>");
		sb.append(str.replace("\n", "<br>"));
		sb.append("</body></html>");
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		String path = Common.notesPath + "\\" + Common.learnFolder + "\\"
				+ year + "\\" + month + "\\" + day;
		try {
			File localPath = new File(path);
			if (!localPath.exists())
				localPath.mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileManager f = new FileManager();
		String fileName = f.getStringMD5String(str);
		if (fileName == null)
			return;
		if (!f.write(sb.toString(), path + "\\" + fileName + ".htm", "UTF-8"))
			return;
		try {
			Directory directory = FSDirectory
					.open(new File(Common.searchDir[1]));
			engine = new SynonymDict(new File(Common.indexPath + "\\"
					+ Common.synFolder));
			Analyzer analyzer = new SynonymAnalyzer(engine);
			IndexWriter writer = new IndexWriter(directory, analyzer,
					IndexWriter.MaxFieldLength.UNLIMITED);
			writer.setMaxBufferedDocs(500);
			Document doc = new Document();
			Field c = new Field("content", str, Field.Store.YES,
					Field.Index.ANALYZED, TermVector.NO);
			doc.add(c);
			Field p = new Field("path", (path.replace(Common.notesPath + "\\",
					"")).replace('\\', '/') + "/" + fileName + ".htm",
					Field.Store.YES, Field.Index.NOT_ANALYZED, TermVector.NO);
			// Field p = new Field("path", (path.replace(Common.notesPath,
			// "")).replace('\\', '/')+fileName+".htm",
			// Field.Store.YES,Field.Index.NOT_ANALYZED,TermVector.NO);
			doc.add(p);
			writer.addDocument(doc);
			writer.optimize();
			writer.commit();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (engine != null)
				engine.close();
		}
	}*/

	/**
	 * 添加新的FAQ
	 * @param question 问题租
	 * @param answer 答案组
	 * @return 1成功 小于1失败
	 */
	public int AddNewFAQ(String question[], String answer[]) {
		if (question.length == 0)
			return 0;
		FAQControl c = null;
		int num = 0;
		try{
			c = new FAQControl();
			if (!c.CreateIndexPath())
				return 0;
			//System.err.println(question.length + ":::" + answer.length + "");
			for (int i = 0; i < question.length; i++) {

				if (i < answer.length && answer[i] == null)
					continue;
				c.AddIndex(question[i].toLowerCase(), answer[i].toLowerCase());
				num++;
			}
		}catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SearchLogic.class.getName()+":AddNewFAQ");
			} catch (Exception e1) {}
		}finally{
			if(c!=null){
				c.End();
			}
		}
		return 1;
	}

	/**
	 * 【暂时无用，待修改】添加新的FAQ（带权重）
	 * @param question 问题租
	 * @param answer 答案组
	 * @param boost 权重
	 * @return 1成功 小于1失败
	 */
	public int AddNewFAQWithBoost(String question[], String answer[],
			float boost) {
		if (question.length == 0)
			return 0;
		FAQControl c = new FAQControl();
		if (!c.CreateIndexPath())
			return 0;
		int num = 0;
		//System.err.println(question.length + ":::" + answer.length + "");
		for (int i = 0; i < question.length; i++) {

			if (i < answer.length && answer[i] == null)
				continue;
			c.AddIndex(question[i].toLowerCase(), answer[i].toLowerCase(), boost);
			num++;
		}
		c.End();
		return 1;
	}

	/**
	 * 删除FAQ
	 * @param url url地址组
	 * @return 1成功 小于1失败
	 */
	public int deleteFAQ(String url[]) {
		if (url == null)
			return 0;
		int num = 0;
		FAQControl c = null;
		try{
			c = new FAQControl();
			if (!c.CreateIndexPath())
				return 0;

			for (int i = 0; i < url.length; i++) {
				if (url[i] == null)
					continue;
				c.deleteIndex(url[i]);
				num++;
			}
		}catch(Exception e){}
		finally{
			if(c!=null){
				c.End();
			}
		}
		return num;
	}

	/**
	 * 修改FAQ
	 * @param url url地址组
	 * @param q 问题组
	 * @param a 答案组
	 * @return 1成功 小于1失败
	 */
	public int ChangeFAQ(String url[], String q[], String a[]) {
		if (url == null)
			return 0;
		FAQControl c = null;
		int num = 0;
		try{
			c = new FAQControl();
			if (!c.CreateIndexPath())
				return 0;
			for (int i = 0; i < url.length; i++) {
				if (url[i] == null || q[i] == null || a[i] == null)
					continue;
				c.ModifyIndex(url[i], q[i].toLowerCase(), a[i].toLowerCase());
				num++;
			}
		}catch (Exception e) {}
		finally{
			if(c!=null){
				c.End();
			}
		}
		return num;
	}

	/**
	 * 【暂时无用，待修改】修改FAQ
	 * @param url url地址组
	 * @param q 问题组
	 * @param a 答案组
	 * @param boost 权重
	 * @return 1成功 小于1失败
	 */
	public int ChangeFAQWithBoost(String url[], String q[], String a[],
			float boost) {
		if (url == null)
			return 0;
		FAQControl c = new FAQControl();
		if (!c.CreateIndexPath())
			return 0;
		int num = 0;
		for (int i = 0; i < url.length; i++) {
			if (url[i] == null || q[i] == null || a[i] == null)
				continue;
			c.ModifyIndex(url[i], q[i].toLowerCase(), a[i].toLowerCase(), boost);
			num++;
		}
		c.End();
		return num;
	}

	/**
	 * 重建索引
	 * @param index 传入0即可
	 * @return 1成功 小于1失败
	 */
	public int RebuildIndex(String index) {
		DBManager dbManager = new DBManager();
		String operation = "重建索引";
		dbManager.ModifyLog(operation, operation);
		synchronized (LOCK) {
			new MySynonymDictTool().createIndex();
			new SynonmIndexTool().createIndex();
			return new RefreshIndex(index).createIndex();
		}
	}

    
	/**
	 * 得到词库中某个词的相关词（如报税，相关词：网上报税、报税服务等）
	 * @param word 词
	 * @return 相关词字符串（以'/'分割）
	 */
	public String getAboutWords(String word) {
		return new IKDictTool().searchAllAboutWords(word.toLowerCase());
	}

	/**
	 * 得到词库中所有自建单词
	 * @return 相关词字符串（以'/'分割）
	 */
	public String getMyAllWords() {
		return new IKDictTool().searchMyAllAboutWords();
	}

	/**
	 * 添加带权重的自建词
	 * @param word 词
	 * @param weight 权重
	 * @return 1成功 小于1失败
	 */
	public int addNewBusinessWord(String word, float weight) {
		DBManager dbManager = new DBManager();
		String operation = "添加带权重的自建词";
		String parameter = "自建词："+word+";权重："+weight;
		dbManager.ModifyLog(operation, parameter);
		synchronized (LOCK) {
			return BusinessDict.getInstance().addNewBusinessWord(word.toLowerCase(), weight);
		}
	}

	/** 
	 * 修改带权重的自建词
	 * @param oldWord 旧词
	 * @param newWord 新词
	 * @param newWeight 权重
	 * @return 1成功 小于1失败
	 */
	public int modifyBusinessWord(String oldWord, String newWord,
			float newWeight) {
		DBManager dbManager = new DBManager();
		String operation = "修改带权重的自建词";
		String parameter = "新自建词："+newWord+";旧自建词："+oldWord+";新权重："+newWeight;
		dbManager.ModifyLog(operation, parameter);
		synchronized (LOCK) {
			return BusinessDict.getInstance().modifyBusinessWord(oldWord.toLowerCase(), newWord.toLowerCase(),
					newWeight);
		}
	}

	/**
	 * 删除带权重的自建词
	 * @param word 词
	 * @return 1成功 小于1失败
	 */
	public int deleteBusinessWord(String word) {
		DBManager dbManager = new DBManager();
		String operation = "删除带权重的自建词";
		String parameter = "删除的自建词："+word;
		dbManager.ModifyLog(operation, parameter);
		synchronized (LOCK) {
			return BusinessDict.getInstance().deleteBusinessWord(word);
		}
	}
	
	
	/**
	 * 查询带权重的自建词
	 * @param word 词
	 * @return >0成功 -1无
	 */
	public float getBusinessWord(String word) {
		synchronized (LOCK) {
			try {
				return BusinessDict.getInstance().getWeight(word.toLowerCase());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		}
	}

	/**
	 * 得到带权重的词的词表
	 * @return 词表组
	 */
	public String[] getListBusinessDict() {
		return BusinessDict.getInstance().getListBusinessDict();
	}

	/**
	 * 添加同义词
	 * @param word 词
	 * @param synonmWords 同义词组
 	 * @return 1成功 小于1失败
	 */
	public int addNewSynonmWord(String word, String[] synonmWords) {
		String fc = IKAnalysis(word);
		String[]words = fc.split("/");
		boolean isOneWord = false;
		for(String s:words){
			if(s.length()==word.length())
				isOneWord = true;
		}
		if(!isOneWord){
			AddNewWords(word);
		}
		for(int i = 0;i < synonmWords.length;i++){
			synonmWords[i] = synonmWords[i].toLowerCase().trim();
			String syfc = IKAnalysis(synonmWords[i]);
			String[] syfcs = syfc.split("/");
			boolean b = false;
			for(String s:syfcs){
				if(s.length()==synonmWords[i].length())
					b = true;
			}
			if(!b){
				AddNewWords(synonmWords[i]);
			}
		}
		DBManager dbManager = new DBManager();
		String operation = "添加同义词";
		String parameter = word+"：";
		for(String s:synonmWords)
			parameter = parameter+s+"/";
		dbManager.ModifyLog(operation, parameter);
		synchronized (LOCK) {
			AllSynonmDict dict = new AllSynonmDict();
			return dict.addNewSynonmWord(word.toLowerCase(), synonmWords);
		}
	}

	/**
	 * 修改同义词
	 * @param word 词
	 * @param newSynonmWords 新的同义词组（如果旧的里有则不替换）
	 * @return 1成功 小于1失败
	 */
	public int modifySynonmWord(String word, String[] newSynonmWords) {
		String fc = IKAnalysis(word);
		String[]words = fc.split("/");
		boolean isOneWord = false;
		for(String s:words){
			if(s.length()==word.length())
				isOneWord = true;
		}
		if(!isOneWord){
			AddNewWords(word);
		}
		for(int i = 0;i < newSynonmWords.length;i++){
			newSynonmWords[i] = newSynonmWords[i].toLowerCase().trim();
			String syfc = IKAnalysis(newSynonmWords[i]);
			String[] syfcs = syfc.split("/");
			boolean b = false;
			for(String s:syfcs){
				if(s.length()==newSynonmWords[i].length())
					b = true;
			}
			if(!b){
				AddNewWords(newSynonmWords[i]);
			}
		}
		DBManager dbManager = new DBManager();
		String operation = "修改同义词";
		String parameter = word+"：";
		for(String s:newSynonmWords)
			parameter = parameter+s+"/";
		dbManager.ModifyLog(operation, parameter);
		synchronized (LOCK) {
			AllSynonmDict dict = new AllSynonmDict();
			return dict.modifySynonmWord(word.toLowerCase(), newSynonmWords);
		}
	}

	// 去除接口
	/*
	 * public String[] getMySynonmDictList(){ MySynonmDict dict=new
	 * MySynonmDict(); return dict.getMySynonmDictList(); }
	 */

	/**
	 * 得到同义词
	 * @param word 词
	 * @return 同义词字符串（以'/'分割）
	 */
	public String getSynonmWords(String word) {
		word = word.toLowerCase();
		AllSynonmDict dict = new AllSynonmDict();
		return dict.getSynonmWords(word);
	}

	/**
	 * 句子中查看哪些词在自建词典中
	 * @param word 句子
	 * @return 句子中在自建词典中的词
	 */
	public String getNowMyWord(String word) {
		word = word.toLowerCase();
		StringBuffer sb = new StringBuffer();
		String result = IKAnalysis(word);
		String[] strs = result.split("/");
		Set<String> mySet = new TreeSet<String>();
		for (String s : strs) {
			if (IKDict.isInIkDict(s)) {
				if (mySet.add(s))
					sb.append(s + "/");
			}
		}
		mySet.clear();
		if (sb.length() != 0)
			sb.delete(sb.length() - 1, sb.length());
		return sb.toString();
	}
	

	/**	 
	 * 查看这个词是在自建词典中
	 * @param word 词
	 * @return >=0在自建词典中 -1不在
	 */
	public float isInMyWord(String word) {
		word = word.toLowerCase();
		float reFlag;
		if(IKDict.isInIkDict(word)){
			reFlag=this.getBusinessWord(word);
			if(reFlag==-1)
				return 0;//在自建词典中但是不在带权重业务词典中
			else
				return reFlag;//返回权重
		}
		return -1;
	}
	
	public boolean isInOntology(String word){
		word = word.toLowerCase();
		String[] words = {word};
		ReasonerService rs = new ReasonerService();
		if(rs.getFileName(words)!=null)
			return true;
		else
			return false;
	}
	
	
	/**
	 * 【未启用】添加对话
	 * @param str
	 * @param sessionid
	 * @return
	 */
	public int AddNewDialogue(String str,String sessionid){
		int b=new QAControl().AddNewDialogue(sessionid, str);
		return b;
	}
	
	/**
	 * 【未启用】追加评分
	 * @param sessionid
	 * @param score
	 * @param scorer
	 * @return
	 */
	public int addScore(String sessionid,int score,String scorer){
		int b=new QAControl().addScore(sessionid,score,scorer);
		return b;
	}
	
	//获得常用语
	public String getAnswer(String Question){
		Question = Question.trim();
		DBManager dbManager = new DBManager();
		return dbManager.getAnswer(Question);
	}
	
	//增加常用语
    public int addQA(String Question,String Answer){
    	Question = Question.trim();
    	Answer = Answer.trim();
    	DBManager dbManager = new DBManager();
		return dbManager.addQA(Question, Answer);
    }
	
  //删除常用语
    public int delQA(String Question){
    	Question = Question.trim();
    	DBManager dbManager = new DBManager();
		return dbManager.delQA(Question);
    }
    
  //修改常用语
    public int modifyQA(String Question,String Answer){
    	Question = Question.trim();
    	Answer = Answer.trim();
    	DBManager dbManager = new DBManager();
		return dbManager.modifyQA(Question, Answer);
    }
    
    public String[][] getAllQA(){  
    	HashMap<String, String> qaMap;
    	DBManager dbManager = new DBManager();
		qaMap=dbManager.getAllQA();
		Iterator<Map.Entry<String, String>> iterator=qaMap.entrySet().iterator();
		String[][] reStrs=new String[qaMap.size()][2];
		int count=0;
		while(iterator.hasNext()){
			Map.Entry<String, String> map=iterator.next();
			reStrs[count][0]=map.getKey();
			reStrs[count][1]=map.getValue();
			count++;
		}
		return reStrs;
    }
    
    public int login(String userName,String passWord){
    	DBUserManager dbUserManager=null;
    	int reFlag=-2;
    	try{
    		dbUserManager=new DBUserManager();
    		reFlag=dbUserManager.Login(userName, passWord);   		
    	}catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),DBManager.class.getName());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    	finally{
    		if(dbUserManager!=null)
    			dbUserManager.close();
    	}
    	return reFlag;
    	
    }
    
    //返回一个句子的所有分词和它们的同义词
    public String[] getWordsAndSyn(String str){
    	String wordString = IKAnalysis(str);
    	if(wordString==null||wordString.length()==0)
    		return null;
    	String [] words = wordString.split("/");
    	List<String> list = new ArrayList<String>();
    	SynonmIndexTool indexTool=new SynonmIndexTool();
    	for(String word:words){
    		list.add(word);
    		String []syns = indexTool.getSynonmWords(word);
    		if(syns!=null&&syns.length!=0){
    			for(String syn:syns){
    				list.add(syn);
    			}
    		}
    	}
    	String[]wordsAndSyn = new String[list.size()];
    	list.toArray(wordsAndSyn);
    	return wordsAndSyn;
    }
    
    //获得问题的分类，目前只是返回xml字符串
    public String getXMLString(String question){
    	String[]wordsAndSyn = getWordsAndSyn(question);
    	List<String>myWordList = new ArrayList<String>();
    	if(wordsAndSyn!=null){
    		for(String word:wordsAndSyn){
    			if(isInMyWord(word)>=0){
    				myWordList.add(word);
    			}
    		}
    		String[] myWords = new String[myWordList.size()];
    		myWordList.toArray(myWords);
    		GetTreeXML getTreeXML = new GetTreeXML();
    		return getTreeXML.getTreeXMLString(myWords);
    	}
    	return null;
    }
    
    //通过文件名获得文件的分类(xml字符串)
    public String getFileXMLString(String fileName){
    	GetFileXML getFileXML = new GetFileXML();
    	return getFileXML.getFileXMLString(fileName);
    }
    
}