package com.shenji.test;

import com.shenji.search.SearchLogic;

public class ScoreTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchLogic logic=new SearchLogic();
		String test="网上认证中，我的软件报错";
		System.out.println(logic.SearchFAQ(test));
	}

}
