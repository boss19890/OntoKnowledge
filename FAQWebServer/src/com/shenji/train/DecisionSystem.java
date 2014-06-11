package com.shenji.train;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;
import org.wltea.analyzer.lucene.SynonymEngine;

import com.shenji.log.WriteLog;
import com.shenji.search.SearchBean;
import com.shenji.search.SearchLogic;
import com.shenji.tools.SynonmIndexTool;

public class DecisionSystem {

	/**
	 * @param args
	 */
	private List<String> matchList = new ArrayList<String>();
	private Set<String> maxMatchSet=new TreeSet<String>();
	private String more="<a href=\"#\" onclick=\"display('hide')\"> <font size=\"5\"><center>更多/隐藏</center></font> </a>";
	private String javascript="<script type=\"text/javascript\" laguage=\"javascript\">" +
			"function display(y){$(y).style.display=($(y).style.display==\"none\")?\"\":\"none\";}" +
			" function $(s){return document.getElementById(s);} " +
			" function scroll(){ alert(0); window.scrollTo(0,document.body.scrollHeight); alert(1);} " +
			//window.scrollTo(0,1000);
//			" document.getElementById('hide').onclick=function(){var cha=(document.body.scrollHeight-document.body.clientHeight)/2;scroll(0,cha.toFixed(0));}"+
			"</script> ";
	
	
	public DecisionSystem(String args){
		initIkMatchResult(args);
	}
	public List<SearchBean> customSort(List<SearchBean> list){
		StrategeFactory factory=new StrategeFactory(StrategeFactory.COSTOM,list,matchList, maxMatchSet);		
		return factory.getSortList();
	}
	
	public String cutlineSortWithType(List<SearchBean> list,String type){
		List<SearchBean> result = null;
		if("3".equals(type)){
			result=customSort(list);
		}else{
			result = list;
		}
		int len = result.size()>SearchLogic.maxResult?SearchLogic.maxResult:result.size();
		StringBuilder html = new StringBuilder("<html>"+javascript+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><head><title>Search</title>");
		html.append("<style>em{font-style:normal;color:#cc0000}</style></head><body>");
		//String[] r = new String[len];
		//System.out.println(len);
		int i = 0;   
		/*9月5日添加：添加分割线*/
		int cutLineFlag=0;
		int cutLineCount=0;
		double frontSimilarity=SearchLogic.cutLine[0];
		if(len==0)
			html.append("<div>无法找到答案！</div>");
		//html.append(more);
		for(int j=0;j<result.size();j++) {
			SearchBean bean=result.get(j);
			if(j!=0)
				frontSimilarity=result.get(j-1).getSimilarity();	
			html.append("<div>"+bean.getContent()+"</div><br>");
			if((cutLineFlag<SearchLogic.cutLine.length						
						&&bean.getSimilarity()>=SearchLogic.cutLine[cutLineFlag])
						||bean.getSimilarity()>frontSimilarity
							){				
				//cutLineCount++;
			}			
			else{
				{
					html.append("<div style=\"text-align:center; vertical-align:middle; line-height:24px\">以上相关度大于"+SearchLogic.cutLine[cutLineFlag]+"</div>");
					html.append("<hr width=100% size=1 color=#00ffff style=\"border:1 dashed #00ffff\">");
					//cutLineCount=0;
				}				
				cutLineFlag++;				
			}
			if(j==(len-1)&&cutLineFlag<=(SearchLogic.cutLine.length-1)){
				html.append("<div style=\"text-align:center; vertical-align:middle; line-height:24px\">以上相关度大于"+SearchLogic.cutLine[cutLineFlag]+"</div>");
				html.append("<hr width=100% size=1 color=#00ffff style=\"border:1 dashed #00ffff\">");
			}
			if(cutLineFlag>=SearchLogic.cutLine.length)
				break;
			/*------------*/
			//System.out.println(bean.getScore());
			i++;   
			if(i==len)
				break;
			if(j==SearchLogic.showResult){
				html.append(more);
				html.append("<div id=\"hide\" style=\"display:none\">");
			}
		}	
		if(result.size()>=SearchLogic.showResult){
			html.append("</div>");
		}
		
		html.append("</body></html>");
		
		return html.toString();
	}
	public String cutlineSort(List<SearchBean> list){
		//type="3"表示不排序
		return cutlineSortWithType(list, "3");
	}
	
	private void initIkMatchResult(String args){
		StringReader reader = new StringReader(args); 
		IKSegmentation iks = new IKSegmentation(reader, false);
		Lexeme t;
		try {
			while ((t = iks.next()) != null) {
				String word = t.getLexemeText();
				if(word.length()>1)
					this.matchList.add(word);
			}
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),DecisionSystem.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		StringReader reader_max = new StringReader(args); 
		IKSegmentation iks_max= new IKSegmentation(reader_max, true);
		Lexeme t_max;
		try {
			while ((t_max = iks_max.next()) != null) {
				String word =t_max.getLexemeText();
				if(word.length()>1){
					this.maxMatchSet.add(word);
					//System.err.println(word);
				}
			}
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),DecisionSystem.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	

}
