package com.shenji.test;

import com.shenji.search.SearchLogic;

public class LockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchLogic logic=new SearchLogic();
		logic.RebuildIndex("0");
		/*logic.addNewSynonmWord("我是", new String[]{"我不是"});
		logic.addNewSynonmWord("我是", new String[]{"我不是"});
		logic.addNewSynonmWord("我是", new String[]{"我不是"});
		logic.addNewSynonmWord("我是", new String[]{"我不是"});
		logic.RebuildIndex("0");
		logic.addNewSynonmWord("我是", new String[]{"我不是"});
		logic.addNewSynonmWord("我是", new String[]{"我不是"});*/

	}

}
