package com.shenji.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.wltea.analyzer.lucene.SynonymEngine;

import com.shenji.DBManager.DBManager;
import com.shenji.common.Common;
import com.shenji.search.SearchLogic;
import com.shenji.tools.IKDict;
import com.shenji.tools.MySynonymDict;
import com.shenji.tools.SynonymDict;
import com.shenji.train.FAQControl;
import com.shenji.util.StringMatching;

public class SearchNonBusinessMatching {
	/*private static HashMap<String, String> commonFaqMap;
	static{
		DBManager dbManager = new DBManager();
		commonFaqMap=dbManager.getAllQA();
	}
	public static void resetCommonFaqMap(){
		commonFaqMap.clear();
		DBManager dbManager = new DBManager();
		commonFaqMap=dbManager.getAllQA();
	}*/	
	private static boolean isBusinessQuestion(String arg){
		boolean isBusiness=false;
		//同义词引擎
		SynonymEngine engine=null;
		File file=new File(Common.indexPath+"/"+Common.synFolder);
		engine=new SynonymDict(file);	
		//进行分词
		String ikStr=new SearchLogic().IKAnalysis(arg);
		String[] ikStrs=ikStr.split("/");
		for(String word:ikStrs){
			//词在自建词典中
			if(word.length()>1&&IKDict.isInIkDict(word))
				return true;
			try {
				//分的词的同义词在自建词典中
				String[] synStrs=engine.getSynonyms(word.toLowerCase());
				if(synStrs==null||synStrs.length==0)
					continue;
				for(String syn:synStrs){
					if(syn.length()>1&&IKDict.isInIkDict(syn))
						return true;
				}
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}	
		if(engine!=null)
			engine.close();
		return isBusiness;
	}
	public static String matching(String arg){
		String answer=null;
		HashMap<String, String> qaMap=null;
		List<String> commonAnwserList=new ArrayList<String>();
		if(isBusinessQuestion(arg))
			return null;
		//Iterator<Map.Entry<String, String>> iterator=SearchNonBusinessMatching.getCommonFaqMap().entrySet().iterator();
		try {
			DBManager dbManager = new DBManager();
			qaMap=dbManager.getAllQA();
			Iterator<Map.Entry<String, String>> iterator=qaMap.entrySet().iterator();
			double minEditDistance=0;
			while(iterator.hasNext()){
				Map.Entry<String, String> map=iterator.next();
				String q=map.getKey();
				if(q.startsWith("TY"))
					commonAnwserList.add(map.getValue());
				double editDistance=StringMatching.getDistanceSimilarity(arg, q);
				if(editDistance>minEditDistance){
					minEditDistance=editDistance;
					answer=map.getValue();
				}
			}
			if(minEditDistance==0){
				//要求写死在程序。。
				//answer=commonAnwserList.get(StringMatching.getRandomNum(commonAnwserList.size()));
				answer="用户您好，我是机器人。请输入关键字我可以帮助您查找问题答案。";
			}
		}
		finally{
			if(qaMap!=null)
				qaMap.clear();
			if(commonAnwserList!=null)
				commonAnwserList.clear();
		}
		return answer;
	} 
	
	
	
	public static void main(String[] str){
		sop(new SearchNonBusinessMatching().matching("坑爹"));
	}
	public static void sop(Object obj){
		System.out.println(obj);
	}
}
