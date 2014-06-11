package com.shenji.train;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.shenji.search.SearchBean;

public class StrategeFactory {
	public static String COSTOM="costom";
	private Strategy strategy;
	private List<SearchBean> result;
	private List<String> matchList;
	private Set<String> maxMatchSet;
	public StrategeFactory(String str,List<SearchBean> result,List<String> matchList,Set<String> maxMatchSet){
		if(str.equals(COSTOM)){
			strategy=new MaxAndMyDictStrategy();
		}
		this.matchList=matchList;
		this.maxMatchSet=maxMatchSet;
		this.result=result;
	}
	public List<SearchBean> getSortList(){
		SimilarityComparator<Object> comparator=new SimilarityComparator<Object>();
		List<SearchBean> list=strategy.setSimilarity(result,matchList, maxMatchSet);
		if(list!=null){
			Collections.sort(list,comparator);
		}
		/*for(SearchBean bean:list)
			System.out.println(bean.getContent()+":"+bean.getSimilarity());*/
		return list;
	}
}
