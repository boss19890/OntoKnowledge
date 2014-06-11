package com.shenji.train;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.wltea.analyzer.lucene.SynonymEngine;

import com.shenji.common.Common;
import com.shenji.search.SearchBean;
import com.shenji.tools.IKDict;
import com.shenji.tools.MySynonymDict;
import com.shenji.tools.MySynonymDictTool;

public class MaxAndMyDictStrategy extends Strategy {

	

	/**
	 * @param args
	 */
	private SynonymEngine engine=new MySynonymDict(new File(Common.indexPath+"/"+Common.mySynFolder));
	
	public List<SearchBean> setSimilarity(List<SearchBean> result,List<String> matchList, Set<String> maxMatchSet) {
		double qaProportion = Common.qaProportion;
		List<String> inIkDictList = new ArrayList<String>();
		for(String s:matchList){
			if(IKDict.isInIkDict(s.trim()))
				inIkDictList.add(s.trim());
		}
		double num = inIkDictList.size();
		for(SearchBean searchBean:result){
			double similarity=0;
			String answer=searchBean.getAnswer();
			String question = searchBean.getQuestion();
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
			
			similarity=similarity/num+searchBean.getScore();
			searchBean.setSimilarity(similarity);
		}
		if(engine!=null)
			engine.close();
		return result;
	}

}
