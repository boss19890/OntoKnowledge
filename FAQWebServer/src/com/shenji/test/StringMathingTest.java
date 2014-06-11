package com.shenji.test;

import com.shenji.search.SearchLogic;
import com.shenji.util.StringMatching;

public class StringMathingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchLogic logic=new SearchLogic();
		System.out.println(logic.Search("在吗！！！" ));
	
	}
	private static void test1(){
		String[] words={"的","个","是他们的"};
		String str="我是他们的儿子啊";
		long start=System.currentTimeMillis();
		StringMatching matching=new StringMatching();
		
		System.err.println(matching.getInherentSimilarity(words, str));
		SearchLogic logic=new SearchLogic();
		System.err.println(logic.Search("我是不是增值税帅哥"));
		//System.out.println(logic.ListAllFaq());
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}

}
