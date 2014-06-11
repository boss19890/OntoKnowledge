package com.shenji.searchThread;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;

import com.shenji.log.WriteLog;
import com.shenji.search.SearchBean;
import com.shenji.searchWay.BooleanSearch;


/**
 * 查询线程（带返回值）
 * @author sj
 * 
 */
public class SearchThread implements Callable<List<SearchBean>> {
	
	private String args;
	private String from;
	//或查询 结果词集
	private List<String> matchList = new ArrayList<String>();
	//和查询 结果词集（不能重复）
	private Set<String> maxMatchSet=new TreeSet<String>();
	private int maxTextShow = 200;
	//和查询
	public static int AND_SEARCH=0;
	//或查询
	public static int OR_SEARCH=1;
	public int searchType;
	private String type="1";
	/**
	 * 中文分词
	 */
	private void IKAnalysis() {
		matchList.clear();
		maxMatchSet.clear();
		try {
			StringReader reader = new StringReader(args); 
			//IK分词构造器
			IKSegmentation iks = new IKSegmentation(reader, false,args);
			Lexeme t;
			//中英文混分词典
			String[] chEnDict=iks.getChEnDict();
			//IK分词
			while ((t = iks.next()) != null) {
				String word = t.getLexemeText();
				if(word.length()==1){
					Pattern pattern=Pattern.compile("[a-zA-Z]");
					Matcher m=pattern.matcher(word);
					if (!m.find()) {
						matchList.add(word);
					}
				}else{
					matchList.add(word);
				}
			}
			for(String s:chEnDict){
				if(s.length()==1){
					Pattern pattern=Pattern.compile("[a-zA-Z]");
					Matcher m=pattern.matcher(s);
					if (!m.find()) {
						matchList.add(s);
					}
				}else{
					matchList.add(s);
				}
			}
			
			StringReader reader_max = new StringReader(args); 
			//IK分词构造器
			IKSegmentation iks_max= new IKSegmentation(reader_max, true);
			Lexeme t_max;
			//IK分词
			while ((t_max = iks_max.next()) != null) {
				String word =t_max.getLexemeText();
				//if(word.length()>1){
					maxMatchSet.add(word);
					//System.err.println(word);
				//}
			}
			for(String s:chEnDict){
				maxMatchSet.add(s);
			}
			
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),SearchThread.class.getName());
		}
	}
	
    /**
     * 构造函数
     * @param args 查询请求
     * @param from 来源
     * @param maxTextShow 最大文本显示
     * @param searchType 查询类型（并查询、或查询）
     */ 
    public SearchThread(String args,String from,int maxTextShow,int searchType) {
        this.args = args;
        this.from = from;
        this.maxTextShow = maxTextShow;
        this.searchType=searchType;
        //中文分词
        IKAnalysis();
    }
   
    public SearchThread(String args,String from,int maxTextShow,int searchType,String type) {
        this.args = args;
        this.from = from;
        this.maxTextShow = maxTextShow;
        this.searchType=searchType;
        this.type = type;
        //中文分词
        IKAnalysis();
    }
    
    /* (non-Javadoc)
     * 线程的执行体
     * @see java.util.concurrent.Callable#call()
     */
    @SuppressWarnings("unchecked")
	public List<SearchBean> call() throws Exception {
    	try {   
    		//构建布尔查询对象并返回结果
    		BooleanSearch booleanSearch = new BooleanSearch(matchList,maxTextShow,maxMatchSet,searchType);
			List<SearchBean> result = booleanSearch.getResult(args,from,type);
			String message = booleanSearch.getResult();
			if(message!=null&&!message.equals("")){
				SearchBean searchBean = new SearchBean();
				searchBean.setContent(message);
				searchBean.setSimilarity(100);
				searchBean.setAnswer("");
				searchBean.setPureContent("");
				searchBean.setQuestion("");
				searchBean.setScore(100);
				if(result==null){
					result = new ArrayList<SearchBean>();
				}
				result.add(0,searchBean);
			}
			return result;
		} catch (Exception e) { 
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),SearchThread.class.getName());
			return null;
		}   
	}

}
