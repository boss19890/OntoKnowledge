package com.shenji.train;

import java.util.Comparator;

import com.shenji.search.SearchBean;

public class SimilarityComparator<Object> implements Comparator<Object> {

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		SearchBean bean1=(SearchBean)o1;
		SearchBean bean2=(SearchBean)o2;
		if(bean1.getSimilarity()==bean2.getSimilarity())
			if(bean1.getScore()>bean2.getScore())
				return 0;
			else
				return 1;
		else if(bean1.getSimilarity()>bean2.getSimilarity())
			return 0;
		else
			return 1;
	}

}
