package com.shenji.searchThread;

import java.util.Comparator;

import com.shenji.search.SearchBean;


@SuppressWarnings("rawtypes")
public class MyComparator implements Comparator {

	/**
	 * ʵ��compare
	 */
	public int compare(Object o1, Object o2) {
		SearchBean p1 = (SearchBean) o1;
		SearchBean p2 = (SearchBean) o2;
		// 3�����ԵıȽ�
		if(p1.getScore()>p2.getScore())
			return -1;
		else if(p1.getScore()<p2.getScore())
			return 1;
		else
			return 0;
	}
}

