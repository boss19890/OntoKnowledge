package com.shenji.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.shenji.common.Common;
import com.shenji.log.WriteLog;
import com.shenji.search.SearchLogic;
import com.shenji.util.FileUse;

public class BusinessDict implements BusinessEngine {
	public static HashMap<String,Float> businessDictMap;
	private BusinessDict(){		
	}
	private static BusinessDict businessDict=new BusinessDict();
	static{
		businessDictMap=new HashMap<String,Float>();
		businessDict.loadBusinessDict();
	}
	public static synchronized BusinessDict getInstance(){
		return businessDict;
	}
	public float getWeight(String s) throws IOException {
		// TODO Auto-generated method stub	
		if(businessDictMap.get(s)!=null)
			return businessDictMap.get(s);
		else
			return -1;
	}
	private void loadBusinessDict(){
		try {
			String path = this.getClass().getClassLoader().getResource("").toURI().getPath();
			File file=new File(path+Common.businessDict);
			if(!file.exists())
				return;
			List<String> list=FileUse.read(file);
			for(String s:list){
				String[] strings=s.split(" ");
				businessDictMap.put(strings[0], Float.valueOf(strings[1]));
				//System.err.println(strings[0]+Float.valueOf(strings[1]));
			}
			
		} catch (URISyntaxException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),BusinessDict.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public static void reset(){
		businessDictMap.clear();
		businessDict.loadBusinessDict();
	}
	
	public int addNewBusinessWord(String word,float weight){
		String path;
		int result;
		try {
			path = this.getClass().getClassLoader().getResource("").toURI().getPath();
			File file=new File(path+Common.businessDict);
			String str=word+" "+weight;			
			result=FileUse.write(file, FileUse.add(file, str));
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),BusinessDict.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return -1;
		}
		reset();
		return result;	
	}
	
	public int modifyBusinessWord(String oldWord,String newWord,float newWeight){
		String path;
		int result;
		try {
			path = this.getClass().getClassLoader().getResource("").toURI().getPath();
			String str=newWord+" "+newWeight;			
			result=FileUse.write(path,Common.businessDict,FileUse.modify(path, Common.businessDict, oldWord, str, FileUse.CONTAINS_TYPE));
		} catch (URISyntaxException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),BusinessDict.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return -1;
		}
		reset();
		return result;	
	}
	
	public int deleteBusinessWord(String word){
		String[] words={word};
		String path;
		int result;
		try {
			path = this.getClass().getClassLoader().getResource("").toURI().getPath();		
			result=FileUse.write(path,Common.businessDict,FileUse.delete(path, Common.businessDict, words, FileUse.CONTAINS_TYPE));
		} catch (URISyntaxException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),BusinessDict.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return -1;
		}
		reset();
		return result;	
	}

	
	public String[] getListBusinessDict(){
		List<String> list=new ArrayList<String>();
		File file=null;
		try {
			file= new File(this.getClass().getClassLoader().getResource("").toURI().getPath()+Common.businessDict);						
			ArrayList<String> arrayList_myDict=FileUse.read(file);	
			for(String s:arrayList_myDict){
				
				String[] str=s.split(" ");
				String string=str[0]+"/"+str[1];
				list.add(string);
				//System.err.println(s);
			}
			arrayList_myDict.clear();						
		} catch (URISyntaxException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),BusinessDict.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}			
		return (String[])list.toArray(new String[list.size()]);
	}
	
	
	
	public static void main(String[] strings) throws IOException{
		long start=System.currentTimeMillis();
		System.err.println(BusinessDict.getInstance().getListBusinessDict());
		long end=System.currentTimeMillis();
		System.err.println("time:"+(end-start));
		
	}
	

}
