package com.shenji.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.dic.Dictionary;

import com.shenji.common.Common;
import com.shenji.util.FileUse;

public class IKDictTool {

	/**
	 * @param args
	 */
	public int AddNewWords(String content) {
		if(content == null)
			return -1;
		BufferedWriter out = null;  
		
        try {  
        	int num = 0;
        	String path = this.getClass().getClassLoader().getResource("").toURI().getPath();
        	System.err.println(path);
        	
        	
            out = new BufferedWriter(new OutputStreamWriter(  
                    new FileOutputStream(path+Common.myDict, true),"UTF-8"));  
            String[] words = content.split("/");
            
            for(int i=0;i<words.length;i++)
            {
            	if(IKDict.ikDictSet.contains(words[i])){
            		continue;
            	}
            	if(words[i]!=null && !words[i].equals(""))
            	{
	            	out.write(words[i]);
	            	out.newLine();
	            	out.flush();
	            	num++;
	            	//this.newWordsList.add(words[i]);
            	}
            }
            //System.gc();
            out.close();  
            Dictionary.reset();
            IKDict.reset();
            return num;
        } catch (Exception e) {  
            e.printStackTrace();  
            return -2;
        }
        
	}
	
	public int modifyWords(String oldWord,String newWord){	
		for(int i=0;i<oldWord.toCharArray().length;i++){			
			String s=String.valueOf(oldWord.toCharArray()[i]);
			if(!FileUse.isChineseWord(s))
					return -1;
		}
		for(int j=0;j<newWord.toCharArray().length;j++){
			String s=String.valueOf(newWord.toCharArray()[j]);
			if(!FileUse.isChineseWord(s))
					return -2;
		}
		String myDictPath=null;
		String mainDictPath=null;
		String surnameDictPath;
		String quantifierDictPath;
		String suffixDictPath;
		String prepositionDictPath;
		String stopwordDictPath;
		try {
			myDictPath= this.getClass().getClassLoader().getResource("").toURI().getPath();
			mainDictPath=this.getClass().getResource(Dictionary.PATH_DIC_MAIN).toURI().getPath();
			surnameDictPath=this.getClass().getResource(Dictionary.PATH_DIC_MAIN).toURI().getPath();
			quantifierDictPath=this.getClass().getResource(Dictionary.PATH_DIC_QUANTIFIER).toURI().getPath();
			suffixDictPath=this.getClass().getResource(Dictionary.PATH_DIC_SUFFIX).toURI().getPath();
			prepositionDictPath=this.getClass().getResource(Dictionary.PATH_DIC_PREP).toURI().getPath();
			stopwordDictPath=this.getClass().getResource(Dictionary.PATH_DIC_STOP).toURI().getPath();						
			
			ArrayList<String> arrayList_myDict=FileUse.modify(myDictPath,Common.myDict, oldWord, newWord,FileUse.EQUALS_TYPE);
			FileUse.write(myDictPath, Common.myDict, arrayList_myDict);
			arrayList_myDict.clear();
			
			ArrayList<String> arrayList_mainDict=FileUse.modify(mainDictPath,null, oldWord, newWord,FileUse.EQUALS_TYPE);
			FileUse.write(mainDictPath, null, arrayList_mainDict);	
			arrayList_mainDict.clear();
			
			ArrayList<String> arrayList_surnameDictPath=FileUse.modify(surnameDictPath,null, oldWord, newWord,FileUse.EQUALS_TYPE);
			FileUse.write(surnameDictPath, null, arrayList_surnameDictPath);	
			arrayList_surnameDictPath.clear();
			
			ArrayList<String> arrayList_quantifierDictPath=FileUse.modify(quantifierDictPath,null, oldWord, newWord,FileUse.EQUALS_TYPE);
			FileUse.write(quantifierDictPath, null, arrayList_quantifierDictPath);	
			arrayList_quantifierDictPath.clear();
			
			ArrayList<String> arrayList_suffixDictPath=FileUse.modify(suffixDictPath,null, oldWord, newWord,FileUse.EQUALS_TYPE);
			FileUse.write(suffixDictPath, null, arrayList_suffixDictPath);	
			arrayList_suffixDictPath.clear();
			
			ArrayList<String> arrayList_prepositionDictPath=FileUse.modify(prepositionDictPath,null, oldWord, newWord,FileUse.EQUALS_TYPE);
			FileUse.write(prepositionDictPath, null, arrayList_prepositionDictPath);	
			arrayList_prepositionDictPath.clear();
			
			ArrayList<String> arrayList_stopwordDictPath=FileUse.modify(stopwordDictPath,null, oldWord, newWord,FileUse.EQUALS_TYPE);
			FileUse.write(stopwordDictPath, null, arrayList_stopwordDictPath);													
			arrayList_stopwordDictPath.clear();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}		
		System.err.println(myDictPath);
		System.err.println(mainDictPath);
		//
		Dictionary.reset();
		IKDict.reset();
		return 1;
	}
	
	public int deleteWords(String[] words){
		String myDictPath=null;
		/*String mainDictPath;
		String surnameDictPath;
		String quantifierDictPath;
		String suffixDictPath;
		String prepositionDictPath;
		String stopwordDictPath;*/
		try {
			myDictPath= this.getClass().getClassLoader().getResource("").toURI().getPath();
			/*9月12号添加  删词只在自建词库删除*/
			/*mainDictPath=this.getClass().getResource(Dictionary.PATH_DIC_MAIN).toURI().getPath();
			surnameDictPath=this.getClass().getResource(Dictionary.PATH_DIC_MAIN).toURI().getPath();
			quantifierDictPath=this.getClass().getResource(Dictionary.PATH_DIC_QUANTIFIER).toURI().getPath();
			suffixDictPath=this.getClass().getResource(Dictionary.PATH_DIC_SUFFIX).toURI().getPath();
			prepositionDictPath=this.getClass().getResource(Dictionary.PATH_DIC_PREP).toURI().getPath();
			stopwordDictPath=this.getClass().getResource(Dictionary.PATH_DIC_STOP).toURI().getPath();		*/				
			//System.err.println(myDictPath);
			//System.err.println(mainDictPath);
			
			ArrayList<String> arrayList_myDict=FileUse.delete(myDictPath,Common.myDict, words,FileUse.EQUALS_TYPE);
			FileUse.write(myDictPath, Common.myDict, arrayList_myDict);
			arrayList_myDict.clear();
			
			/*ArrayList<String> arrayList_mainDict=FileUse.delete(mainDictPath,null, words,FileUse.EQUALS_TYPE);
			FileUse.write(mainDictPath, null, arrayList_mainDict);	
			arrayList_mainDict.clear();
			
			ArrayList<String> arrayList_surnameDictPath=FileUse.delete(surnameDictPath,null, words,FileUse.EQUALS_TYPE);
			FileUse.write(surnameDictPath, null, arrayList_surnameDictPath);	
			arrayList_surnameDictPath.clear();
			
			ArrayList<String> arrayList_quantifierDictPath=FileUse.delete(quantifierDictPath,null, words,FileUse.EQUALS_TYPE);
			FileUse.write(quantifierDictPath, null, arrayList_quantifierDictPath);	
			arrayList_quantifierDictPath.clear();
			
			ArrayList<String> arrayList_suffixDictPath=FileUse.delete(suffixDictPath,null,words,FileUse.EQUALS_TYPE);
			FileUse.write(suffixDictPath, null, arrayList_suffixDictPath);	
			arrayList_suffixDictPath.clear();
			
			ArrayList<String> arrayList_prepositionDictPath=FileUse.delete(prepositionDictPath,null,words,FileUse.EQUALS_TYPE);
			FileUse.write(prepositionDictPath, null, arrayList_prepositionDictPath);	
			arrayList_prepositionDictPath.clear();
			
			ArrayList<String> arrayList_stopwordDictPath=FileUse.delete(stopwordDictPath,null,words,FileUse.EQUALS_TYPE);
			FileUse.write(stopwordDictPath, null, arrayList_stopwordDictPath);													
			arrayList_stopwordDictPath.clear();*/
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		Dictionary.reset();
		IKDict.reset();
		return 1;
	}
	
	
	public String searchMyAllAboutWords(){
		List<String> list=new ArrayList<String>();
		File myDictFile=null;
		try {
			myDictFile= new File(this.getClass().getClassLoader().getResource("").toURI().getPath()+Common.myDict);						
			ArrayList<String> arrayList_myDict=FileUse.read(myDictFile);	
			for(String s:arrayList_myDict){
				list.add(s);
			}
			arrayList_myDict.clear();						
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str=null;
		for(int i=0;i<list.size();i++){
			if(str==null){
				str=list.get(0);
				continue;
			}
			str=str+"/"+list.get(i);
		}
		return str;
		
	}
	public String searchAllAboutWords(String word){
		List<String> list=new ArrayList<String>();
		File myDictFile=null;
		File mainDictFile=null;
		File surnameDictFile;
		File quantifierDictFile;
		File suffixDictFile;
		File prepositionDictFile;
		File stopwordDictFile;
		try {
			myDictFile= new File(this.getClass().getClassLoader().getResource("").toURI().getPath()+Common.myDict);
			mainDictFile=new File(this.getClass().getResource(Dictionary.PATH_DIC_MAIN).toURI().getPath());
			surnameDictFile=new File(this.getClass().getResource(Dictionary.PATH_DIC_MAIN).toURI().getPath());
			quantifierDictFile=new File(this.getClass().getResource(Dictionary.PATH_DIC_QUANTIFIER).toURI().getPath());
			suffixDictFile=new File(this.getClass().getResource(Dictionary.PATH_DIC_SUFFIX).toURI().getPath());
			prepositionDictFile=new File(this.getClass().getResource(Dictionary.PATH_DIC_PREP).toURI().getPath());
			stopwordDictFile=new File(this.getClass().getResource(Dictionary.PATH_DIC_STOP).toURI().getPath());						
			
			ArrayList<String> arrayList_myDict=FileUse.read(myDictFile, word);	
			for(String s:arrayList_myDict){
				list.add(s);
			}
			arrayList_myDict.clear();
			
			ArrayList<String> arrayList_mainDict=FileUse.read(mainDictFile, word);
			for(String s:arrayList_mainDict){
				list.add(s);
			}
			arrayList_mainDict.clear();			
			
			ArrayList<String> arrayList_surnameDictPath=FileUse.read(surnameDictFile, word);
			for(String s:arrayList_surnameDictPath){
				list.add(s);
			}
			arrayList_surnameDictPath.clear();		
			
			ArrayList<String> arrayList_quantifierDictPath=FileUse.read(quantifierDictFile, word);
			for(String s:arrayList_quantifierDictPath){
				list.add(s);
			}
			arrayList_quantifierDictPath.clear();	
			
			ArrayList<String> arrayList_suffixDictPath=FileUse.read(suffixDictFile,word);
			for(String s:arrayList_suffixDictPath){
				list.add(s);
			}
			arrayList_suffixDictPath.clear();				
			
			ArrayList<String> arrayList_prepositionDictPath=FileUse.read(prepositionDictFile,word);
			for(String s:arrayList_prepositionDictPath){
				list.add(s);
			}
			arrayList_prepositionDictPath.clear();		
			
			ArrayList<String> arrayList_stopwordDictPath=FileUse.read(stopwordDictFile,word);	
			for(String s:arrayList_stopwordDictPath){
				list.add(s);
			}
			arrayList_stopwordDictPath.clear();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		String result=null;
		for(String s:list){
			if(result==null){
				result=s;
				continue;
			}			
			result=result+"/"+s;
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IKDictTool dictTool=new IKDictTool();
		int s=dictTool.deleteWords(new String[]{"知道"});
		//for(String str:s){
			System.out.println(s);
		//}
  	}

}
