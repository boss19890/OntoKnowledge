package com.shenji.tools;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.shenji.common.Common;
import com.shenji.log.WriteLog;
import com.shenji.util.FileUse;

public class IKDict {

	/**
	 * @param args
	 */
	
	public static Set<String> ikDictSet;
	public static Set<String> ikChEnDictSet;
	private IKDict(){		
	}
	private static IKDict ikDict=new IKDict();
	static{
		ikDictSet=new TreeSet<String>();
		ikChEnDictSet=new TreeSet<String>();
		ikDict.loadIkDict();
		//做一次就可以了、、以后注释掉吧
		RemoveDictDuplicate();
	}
	private static void RemoveDictDuplicate(){
		WriteLog writeLog=new WriteLog();
		String myDictPath = null;
		try {
			myDictPath = writeLog.getClass().getClassLoader().getResource("").toURI().getPath();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> list=new ArrayList<String>(ikDictSet);
		FileUse.write(myDictPath, Common.myDict, list);
		list.clear();
	}
	
	
	public static synchronized IKDict getInstance(){
		return ikDict;
	}
	public static boolean isInIkDict(String word){		
		if(ikDictSet.contains(word)){
			return true;
		}
		else
			return false;
		/*boolean flag=ikDictSet.add(word);
		if(flag){
			ikDictSet.remove(word);
			return false;
		}
		else
			return true; */
	}
	
	private void loadIkDict(){
		try {
			String path = this.getClass().getClassLoader().getResource("").toURI().getPath();
			File file=new File(path+Common.myDict);
			if(!file.exists())
				return;
			List<String> list=FileUse.read(file);
			for(String s:list){
				s=s.trim();
				ikDictSet.add(s);
				if(isChEnDict(s)){
					ikChEnDictSet.add(s);
					//System.err.println(s);
				}			
			}
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void reset(){
		ikDictSet.clear();
		ikChEnDictSet.clear();
		ikDict.loadIkDict();
	}
	
	private boolean isChEnDict(String s){
		boolean b=FileUse.isNotChineseWord(s);
		return b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IKDict.getInstance().reset();

	}

}
