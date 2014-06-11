package com.shenji.train;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.shenji.search.SearchBean;

abstract class Strategy {
	public abstract List<SearchBean> setSimilarity(List<SearchBean> result,List<String> matchList,Set<String> maxMatchSet);
}
