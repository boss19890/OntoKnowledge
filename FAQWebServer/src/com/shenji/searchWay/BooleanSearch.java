package com.shenji.searchWay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.axis2.AxisFault;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.search.BooleanClause;
import org.wltea.analyzer.lucene.SynonymEngine;

import cn.sjxx.knowledge.OntologyStub;
import cn.sjxx.knowledge.SimpleReasoning;

import com.shenji.common.Common;
import com.shenji.log.WriteLog;
import com.shenji.search.DataBaseOpeare;
import com.shenji.search.SearchBean;
import com.shenji.search.SearchLogic;
import com.shenji.searchThread.MyComparator;
import com.shenji.searchThread.SearchThread;
import com.shenji.services.FileNameBean;
import com.shenji.services.ReasonerService;
import com.shenji.tools.BusinessDict;
import com.shenji.tools.IKDict;
import com.shenji.tools.MySynonymDict;
import com.shenji.util.StringMatching;


/**
 * 布尔查询
 * @author sj
 *
 */
public class BooleanSearch {

	private DataBaseOpeare helper = null;
	//LUCENE搜索引擎
	private Searcher searcher = null;
	private int maxTextShow = 200;
	private int searchDocNum=SearchLogic.maxResult;
	private List<String> matchList = null;
	private Set<String> maxMatchSet=null;
	private String[] simWords=null;
	private SynonymEngine engine_My=null;
	private SynonymEngine engine_Common=null;
	private List<Float> scoreList=new ArrayList<Float>(); 
	private String from;
	private int searchType;
	private String result = null;
	
	public String getResult(){
		return result;
	}
	/**
	 * 构造函数
	 * @param matchList 或查询 结果词集
	 * @param maxTextShow 最大查询显示
	 * @param maxMatchSet 和查询 结果词集（不能重复）
	 * @param searchType 查询方式
	 */
	public BooleanSearch(List<String> matchList,int maxTextShow,Set<String> maxMatchSet,int searchType)
	{
		if(searchType==SearchThread.AND_SEARCH){
			List<String> temp=new ArrayList<String>();
			for(String s:maxMatchSet)
				temp.add(s);
			this.matchList = temp;
			//temp.clear();
		}
		if(searchType==SearchThread.OR_SEARCH)
			this.matchList=	matchList;
		this.maxTextShow = maxTextShow;
		this.maxMatchSet = maxMatchSet;
		this.searchType=searchType;
		this.simWords=(String[])maxMatchSet.toArray(new String[maxMatchSet.size()]);
		//自建同义词
		File file=new File(Common.indexPath+"/"+Common.mySynFolder);
		if(file.exists())
			//我的同义词引擎
			this.engine_My=new MySynonymDict(file);
		//哈工大同义词林
		File file_common=new File(Common.indexPath+"/"+Common.synFolder);
		if(file_common.exists())
			//哈工大词林同义词引擎
			this.engine_Common=new MySynonymDict(file_common);
		
		/*9月5日删除 暂时去除数据库*/
       //helper = new MySqlHelper();
        //helper.OpenDatabase();
        /*----------------*/
	}
	
	/**
	 * 得到查询结果
	 * @param args 查询请求
	 * @param from 查询来源
	 * @return 结果集
	 * @throws Exception
	 */
	public List<SearchBean> getResult(String args,String from) throws Exception {
		return getResult(args, from, "1");
	}     

	/**
	 * 得到查询结果
	 * @param args 查询请求
	 * @param from 查询来源
	 * @param type 搜索类型：1为交互搜索；2为过滤搜索；3为普通搜索
	 * @return 结果集
	 * @throws Exception
	 */
	public List<SearchBean> getResult(String args,String from,String type) throws Exception {   
		try {   
			List<SearchBean> result = addHits2List(search(from),type);
			if(searcher!=null)
				searcher.close();
			/*if(helper!=null)
				helper.CloseMySql();*/
			return result;
		} catch(Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),BooleanSearch.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}   
			if(searcher!=null)
				searcher.close();
			/*if(helper!=null)
				helper.CloseMySql();*/
			return new ArrayList<SearchBean>();
		}
		finally{
			//关闭两类同义词引擎
			if(engine_My!=null)
				engine_My.close();
			if(engine_Common!=null)
				engine_Common.close();
		}
	}
	
	/**
	 * 关键词、同义词标记
	 * @param str HTML文本
	 * @return HTML文本
	 */
	private String markContent(String str)
	{
		for(String s:matchList)
		{			//if()
			String[] strings=null;
			try {
				str = str.replace(s, "<em>"+s+"</em>");
				if(engine_My!=null)
					if((strings=engine_My.getSynonyms(s))!=null){					
						for(int i=0;i<strings.length;i++){
							str = str.replace(strings[i],"<em>"+strings[i]+"</em>");
						}
					}
				if(engine_Common!=null){
					if((strings=engine_Common.getSynonyms(s))!=null){
						for(int i=0;i<strings.length;i++){
							str =str.replace(strings[i], "<b>"+strings[i]+"</b>");
						}
					}
				}
			} catch (IOException e) {
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),BooleanSearch.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return str;
	}
	
	/*private int getScore(String url) {
		String which;
		if(url.indexOf(Common.faqFolder)>-1)
			which = Common.faqFolder;
		else if(url.indexOf(Common.webFolder)>-1)
			which = Common.webFolder;
		else {
			which = Common.learnFolder;
		}
        String sql = "select * from "+which+" where A= '"+url+"'; ";
        try {
        	return helper.SearchInt(sql);
        }catch (Exception e){
           e.printStackTrace();
           return 0;
        }
	}*/
	
	/**
	 * lucene Document结果集再处理
	 * @param list lucene Document集
	 * @return 所需的结果集（SearchBean）
	 * @throws IOException 
	 * @throws  
	 * @throws RemoteException 
	 */
	
/*	private List<SearchBean> addHits2List(List<Document> list)
	{
		String[] words = (String[])matchList.toArray(new String[matchList.size()]);	
		List<String> fileNames = new ArrayList<String>();
		//知识图谱问题分类，把words或matchList作为参数传递过去，获得文件名列表fileNames，还没调用
		
		List<SearchBean> listBean = new ArrayList<SearchBean>();   
		int count=0;
		int showCount=0;
		for(Document doc:list)
		{
			SearchBean bean = new SearchBean();   
			String content = doc.get("content");
			String dealContent=content;
			bean.setPureContent(dealContent);		
			//显示最大文本
			content = content.substring(0,content.length()>maxTextShow?maxTextShow:content.length());		
			String question=doc.get("question");
			String answer=doc.get("answer");
			bean.setQuestion(question);
			bean.setAnswer(answer);
			String path = doc.get("path");
			//获得htm文件名
			String fileName = path.split("/")[1]; 
			path = Common.webPath+"/"+path;
			(9月22日前)问题答案非分开
			//bean.setContent("<a href=\""+path+"\">"+content+"</a>");
			(9��5�����)��һ����ע�͵��ģ���ʱȥ����������ݿ���������
			//bean.setScore(getScore(path));
			//构造FAQ内容
			if(from==Common.searchDir[0]){
				String mycontent=null;
				mycontent="<div class=\"q\">"+question+"</div><div class=\"a\">"+"<font size=\"2.5\">"+answer+"</font><br></div>";	
				mycontent=markContent(mycontent);
				bean.setContent("<a href=\""+path+"\">"+mycontent+"</a>");
			}
			//可以不看
			else{
				content = markContent(content);
				bean.setContent("<a href=\""+path+"\">"+content+"</a>");
			}
			
			(9月23日去除)去除加粗与斜体
			String dealContent=content.replace("<em>", "");
			dealContent=dealContent.replace("</em>", "");
			dealContent=dealContent.replace("<i>", "");
			dealContent=dealContent.replace("</i>", "");
			
			//相似度
			double similarity=StringMatching.getInherentSimilarity(simWords, dealContent);
			float score = scoreList.get(count);
			count++;
			//如果不在知识图谱的分类里，相似度、评分降低
			if(!fileNames.contains(fileName)){
				similarity = similarity*0.7;
				score = score*(float)0.7;
			}
			bean.setSimilarity(similarity);
			bean.setScore(score);
			//System.out.println(scoreList.get(count));
			showCount++;
			listBean.add(bean);   
		}
		return listBean;
	}*/
	
	private List<SearchBean> addHits2List(List<Document> list){
		return addHits2List(list,"1");
	}
	
	/**
	 * @param type 搜索类型：1为交互搜索；2为过滤搜索；3为普通搜索
	 */
	@SuppressWarnings("unchecked")
	private List<SearchBean> addHits2List(List<Document> list,String type) 
	{
		int count=0;
		List<SearchBean> tmplistBean = new ArrayList<SearchBean>();
		Map<String, String> contentNameMap = new HashMap<String, String>();
		for(Document doc:list)
		{
			SearchBean bean = new SearchBean();   
			String content = doc.get("content");
			String dealContent=content;
			bean.setPureContent(dealContent);		
			//显示最大文本
			content = content.substring(0,content.length()>maxTextShow?maxTextShow:content.length());		
			String question=doc.get("question");
			String answer=doc.get("answer");
			bean.setQuestion(question);
			bean.setAnswer(answer);
			String path = doc.get("path");
			//获得htm文件名,不包括后缀名
			String fileName = path.split("[/.]")[1];
			path = Common.webPath+"/"+path;
			//构造FAQ内容
			if(from==Common.searchDir[0]){
				content="<div class=\"q\">"+question+"</div><div class=\"a\">"+"<font size=\"2.5\">"+answer+"</font><br></div>";	
				content = markContent(content);
				content="<a href=\""+path+"\">"+content+"</a>";
				bean.setContent(content);
			}
			//可以不看
			else{
				content = markContent(content);
				content = "<a href=\""+path+"\">"+content+"</a>";
				bean.setContent(content);
			}
			
			//相似度
			double similarity=StringMatching.getInherentSimilarity(simWords, dealContent);
			float score = scoreList.get(count);
			count++;
			bean.setSimilarity(similarity);
			bean.setScore(score);
			tmplistBean.add(bean);
			contentNameMap.put(content, fileName);
		}
		if("1".equals(type)){
			return interMultilayerSearch(tmplistBean,contentNameMap,type);
		}
		if("2".equals(type)){
			return interMultilayerSearch(tmplistBean,contentNameMap,type);
		}
		if("3".equals(type)){
			Collections.sort(tmplistBean,new MyComparator());
			return tmplistBean;
		}
		return null;
		
	}
	
	
	@SuppressWarnings("unchecked")
	private List<SearchBean> interMultilayerSearch(List<SearchBean> tmplistBean,Map<String, String> contentNameMap,String type){
		List<SearchBean> listBean = new ArrayList<SearchBean>();
		List<String>fileNameList = new ArrayList<String>();
		String[] words = (String[])matchList.toArray(new String[matchList.size()]);
		Collections.sort(tmplistBean,new MyComparator());
		//fileIdScoreSim:元素格式为：fileId#score#similary
		int size = 0;
		if("1".equals(type)&&tmplistBean.size()>=30){
			size = 30;
		}else{
			size = tmplistBean.size();
		}
		String[]fileIdScoreSims = new String[size];
		for(int i = 0;i<tmplistBean.size()&&i<size;i++){
			//获得文件Id
			String fileIdScoreSim = contentNameMap.get(tmplistBean.get(i).getContent());
			fileNameList.add(fileIdScoreSim);
			fileIdScoreSim = fileIdScoreSim + "#" + tmplistBean.get(i).getScore();
			List<String> inIkDictList = new ArrayList<String>();
			for(String s:matchList){
				if(IKDict.isInIkDict(s.trim()))
					inIkDictList.add(s.trim());
			}
			double num = inIkDictList.size();
			String question = tmplistBean.get(i).getQuestion();
			String answer = tmplistBean.get(i).getAnswer();
			double similarity=0;
			double qaProportion = Common.qaProportion;
			String answerMatch = "_";
			String questionMatch = "_";
			for(String s:inIkDictList){
				if((!answerMatch.contains(s))&&answer.contains(s)){
					similarity += 0.1*qaProportion;
					answerMatch = answerMatch+"_"+s;
				}
				if((!questionMatch.contains(s))&&question.contains(s)){
					similarity += 1;
					questionMatch = questionMatch+"_"+s;
				}
			}	
			similarity = similarity/num;
			fileIdScoreSim = fileIdScoreSim + "#" + similarity;
			fileIdScoreSims[i] = fileIdScoreSim;
		}
		
		ReasonerService rs = new ReasonerService();
		FileNameBean fileNameBean = rs.getFileNameByReasoning(words,fileIdScoreSims,type);
		result = rs.getResult();
		//在知识图谱里
		if(fileNameBean!=null){
			Map<String, Integer> fileLevelMap = fileNameBean.getFileLevelMap();
			for (String key : fileLevelMap.keySet())
			{
		    	 int level = fileLevelMap.get(key);
		    	 int contain = fileNameList.indexOf(key);
		    	 if(contain==-1){
		    		 BufferedReader bufReader = null;
		    		 String notesPath = Common.notesPath;
		    		 String fileNamePath = notesPath+"/faq/"+key+".htm";
		    		 try {
//						 bufReader = new BufferedReader(new FileReader(fileNamePath));
						 FileInputStream inputStream=new FileInputStream(new File(fileNamePath));
					     InputStreamReader inputStreamReader=new InputStreamReader(inputStream, "UTF-8");
					     bufReader = new BufferedReader(inputStreamReader);
			    	     String s = null;
			    	     String question = "";
			    	     String answer = "";
			    	     if((s=bufReader.readLine())!=null){
			    	    	 String s1 = s.split("<div class=\"q\">")[1];
			    	         String[] ss = s1.split("</div><br><div class=\"a\">");
			    	         question = ss[0];
			    	         answer = ss[1].split("</div>")[0];
			    	     }
			    		 SearchBean bean = new SearchBean();   
			    		 bean.setPureContent(question+"\n"+answer);
			 		 	 bean.setQuestion(question);
						 bean.setAnswer(answer);
						 bean.setSimilarity(0.2*level);
						 bean.setScore((float)0.2*level);
			    		 String mycontent="<div class=\"q\">"+question+"</div><div class=\"a\">"+"<font size=\"2.5\">"+answer+"</font><br></div>";	
						 mycontent=markContent(mycontent);
						 bean.setContent("<a href=\""+Common.webPath+"/faq/"+key+".htm"+"\">"+mycontent+"</a>");
			    		 listBean.add(bean);
					} catch (Exception e) {
						WriteLog writeLog = new WriteLog();
						try {
							writeLog.Write(e.getMessage(),BooleanSearch.class.getName());
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
		    	     finally{
		    	    	 if(bufReader!=null)
							try {
								bufReader.close();
							} catch (IOException e) {}
		    	     }
		    	 }else{
		    		 SearchBean bean = tmplistBean.get(contain);
		    		 bean.setScore(bean.getScore()*level);
		    		 bean.setSimilarity(bean.getSimilarity()*level);
		    		 listBean.add(bean);
		    	 }
		     }
			return listBean;
		}else{
			Collections.sort(tmplistBean,new MyComparator());
			return tmplistBean;
		}
	}
	
	
	
	/**
	 * lucene搜索
	 * @param from 查询来源（索引）
	 * @return Lucene Document集
	 */
	private List<Document> search(String from){
		this.from=from;
		//布尔查询向量
		String[] filedValues = (String[])matchList.toArray(new String[matchList.size()]);
		//查询字段（域）
		String filedKey = "content";
		String QfiledKey="question";
		String AfiledKey="answer";
		ArrayList<Document> arrayList=null;
		IndexReader reader=null; 
		Directory dir=null;
		try {
			File file = new File(from);
			//判断索引目录存在长度不为0
			if(file.isDirectory() && file.listFiles().length == 0)
				return new ArrayList<Document>();
			//打开索引目录
			dir=FSDirectory.open(file);
			reader=IndexReader.open(dir);
			searcher=new IndexSearcher(reader);
			BooleanQuery booleanQuery=new BooleanQuery();
			for(int i=0;i<filedValues.length;i++){
				float weight=1;			
				//业务词典设置权重
				float weight_bussiness=BusinessDict.getInstance().getWeight(filedValues[i]);
				if(weight_bussiness!=-1){
					weight=weight*weight_bussiness;
				}
				//最长匹配词典设置权重
				boolean isPutIn=maxMatchSet.add(filedValues[i]);
				if(isPutIn)
					maxMatchSet.remove(filedValues[i]);
				else
					weight=weight*Common.maxMatchWeight;
				//自建词典设置权重
				if(IKDict.isInIkDict(filedValues[i]))
					weight=weight*Common.myIkdictWeight*filedValues[i].length();
				
				//FAQ查询
				if(from==Common.searchDir[0]){
					Term term_q=null;									
					term_q=new Term(QfiledKey, filedValues[i]);
					Query query_q=new TermQuery(term_q);
					query_q.setBoost(weight);	
					
					Term term_a=new Term(AfiledKey, filedValues[i]);
					Query query_a=new TermQuery(term_a);
					query_a.setBoost(weight/Common.qaProportion);
					//System.err.println(filedValues[i]+":"+query.getBoost());
					if(searchType==SearchThread.AND_SEARCH){
						Occur occur=BooleanClause.Occur.MUST; 
						booleanQuery.add(query_q,occur);
					}
					else if(searchType==SearchThread.OR_SEARCH){
						Occur occur=BooleanClause.Occur.SHOULD;
						booleanQuery.add(query_q,occur);
						booleanQuery.add(query_a,occur);
					}
				}
				//其他查询，可以不看
				else{
					Term term=null;									
					term=new Term(filedKey, filedValues[i]);
					Query query=new TermQuery(term);
					query.setBoost(weight);	
					if(searchType==SearchThread.AND_SEARCH){
						Occur occur=BooleanClause.Occur.MUST;
						booleanQuery.add(query,occur);
					}
					else if(searchType==SearchThread.OR_SEARCH){
						Occur occur=BooleanClause.Occur.SHOULD;
						booleanQuery.add(query,occur);
					}
				}
			}						
			TopDocs topDocs=searcher.search(booleanQuery,searchDocNum);
			ScoreDoc [] docs=topDocs.scoreDocs;
			System.err.println("共找到："+topDocs.totalHits);
			arrayList=new ArrayList<Document>();
			for(ScoreDoc doc: docs){
				Document d=searcher.doc(doc.doc);
				//System.err.println(doc.score);
				scoreList.add(doc.score);
				arrayList.add(d);
			}
			//System.err.println("共找到："+arrayList.size());
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),BooleanSearch.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} 
		finally{       
			try {
				if(reader!=null)
					reader.close();
				if(dir!=null)
					dir.close();
			} catch (Exception e) {
				e.printStackTrace();
			}  
		} 
		return arrayList;  
	} 
	
	/*9月23日注释掉*/
/*	private List<Document> search(String from){
		String[] filedValues = (String[])matchList.toArray(new String[matchList.size()]);
		String filedKey = "content";
		ArrayList<Document> arrayList=null;
		IndexReader reader=null; 
		Directory dir=null;
		try {
			File file = new File(from);
			if(file.isDirectory() && file.listFiles().length == 0)
				return new ArrayList<Document>();
			dir=FSDirectory.open(file);
			reader=IndexReader.open(dir);
			searcher=new IndexSearcher(reader);
			BooleanQuery booleanQuery=new BooleanQuery();
			for(int i=0;i<filedValues.length;i++){
				float weight=1;
				Term term=null;									
				term=new Term(filedKey, filedValues[i]);
				Query query=new TermQuery(term);
				//业务词典设置权重
				float weight_bussiness=BusinessDict.getInstance().getWeight(filedValues[i]);
				if(weight_bussiness!=-1){
					weight=weight*weight_bussiness;
				}
				//最长匹配词典设置权重
				boolean isPutIn=maxMatchSet.add(filedValues[i]);
				if(isPutIn)
					maxMatchSet.remove(filedValues[i]);
				else
					weight=weight*Common.maxMatchWeight;
				//自建词典设置权重
				if(IKDict.isInIkDict(filedValues[i]))
					weight=weight*Common.myIkdictWeight*filedValues[i].length();
				
				query.setBoost(weight);
				//System.err.println(filedValues[i]+":"+query.getBoost());
				Occur occur=BooleanClause.Occur.SHOULD;
				booleanQuery.add(query,occur);
			}
			
			
			TopDocs topDocs=searcher.search(booleanQuery,searchDocNum);
			ScoreDoc [] docs=topDocs.scoreDocs;
			System.err.println("共找到："+topDocs.totalHits);
			arrayList=new ArrayList<Document>();
			for(ScoreDoc doc: docs){
				Document d=searcher.doc(doc.doc);
				//System.err.println(doc.score);
				scoreList.add(doc.score);
				arrayList.add(d);
			}
			System.err.println("共找到："+arrayList.size());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally{       
			try {
				if(reader!=null)
					reader.close();
				if(dir!=null)
					dir.close();
			} catch (Exception e) {
				e.printStackTrace();
			}  
		} 
		return arrayList;  
	} */
}


