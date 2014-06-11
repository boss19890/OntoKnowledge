package com.shenji.tools;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.shenji.common.Common;
import com.shenji.log.WriteLog;
import com.shenji.util.FileUse;

public class BusinessTool {

	/**
	 * @param args
	 */
	
	
	private boolean createFile(){
		String path;
		try {
			path = this.getClass().getClassLoader().getResource("").toURI().getPath();
			File file=new File(path+Common.businessDict);
			if(!file.exists()){
				file.createNewFile();
				return true;
			}
			else
				return false;
		} catch (URISyntaxException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),BusinessTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),BusinessTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return true;
	}
	public boolean addNewWord(String word,float weight){
		try {
			String path = this.getClass().getClassLoader().getResource("").toURI().getPath();
			File file=new File(path+Common.businessDict);
			if(!file.exists()){
				createFile();
			}			
			String s=word+" "+weight;
			ArrayList<String> list=new ArrayList<String>();
			list.add(s);				
			FileUse.write(path, Common.businessDict, list);			
		} catch (URISyntaxException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),BusinessTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return false;
		}
		return true;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BusinessTool businessTool=new BusinessTool();
		businessTool.addNewWord("fsdf", 100);
	}

}
