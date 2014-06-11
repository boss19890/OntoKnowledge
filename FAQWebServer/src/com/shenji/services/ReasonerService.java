package com.shenji.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mozilla.javascript.tools.idswitch.FileBody;

import com.shenji.common.Common;
import com.shenji.log.WriteLog;
import com.shenji.search.SearchLogic;
import com.shenji.tools.SynonmIndexTool;

import cn.sjxx.knowledge.MultilayerReasoning;
import cn.sjxx.knowledge.OntologyStub;
import cn.sjxx.knowledge.SimpleReasoning;
import cn.sjxx.knowledge.InteractReasoning;

public class ReasonerService {
	public boolean OntologyState = "true".equalsIgnoreCase(Common.OntologyState);
	//反问用户
	public String result = null;
	public String getResult(){
		return result;
	}
	//知识图谱问题分类，把words或matchList作为参数传递过去，获得文件名列表fileNames
	public FileNameBean getFileName(String[]words){
		if(!OntologyState){
			return null;
		}
		FileNameBean fileNameBean = null;
		OntologyStub stub = null;
		String[] wordFile = null;
		List<String> wordsAndSynonmList = new ArrayList<String>();
		SynonmIndexTool indexTool=new SynonmIndexTool();
		try {
			//获得同义词
			if(words!=null&&words.length!=0){
				for(String word:words){
					String s = indexTool.getSynonmWordsFromIndex(word);
					if(s!=null&&s.length()!=0){
						String[]SynonmWords = s.split("/");
						if(SynonmWords!=null&&SynonmWords.length!=0){
							for(String SynonmWord:SynonmWords){
								wordsAndSynonmList.add(SynonmWord);
								}
							}
					}
					wordsAndSynonmList.add(word);
					}
				}
			int size = wordsAndSynonmList.size();
			String[]wordsAndSynonms = new String[size];
			for(int i = 0;i<size;i++){
				wordsAndSynonms[i] = wordsAndSynonmList.get(i);
			}
			stub = new OntologyStub(Common.OntologyIp);
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(8000);
			SimpleReasoning simpleReasoning = new SimpleReasoning();
			simpleReasoning.setWords(wordsAndSynonms);
			wordFile = stub.simpleReasoning(simpleReasoning).get_return();
			if(wordFile!=null&&wordFile.length!=0){
				fileNameBean = new FileNameBean();
				for(String s: wordFile){
					String[]ss = s.split("#");
					String fileName = ss[ss.length-1];
					int level = Integer.parseInt(ss[0]);
					if(fileNameBean.getLevel(fileName)<=0){
						fileNameBean.setFileLevelMap(fileName, level);
					}else{
						fileNameBean.setFileLevelMap(fileName, level+fileNameBean.getLevel(fileName));
					}
				}
			}
			return fileNameBean;
			}
		catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),ReasonerService.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return null;
		}
	}
	
	public FileNameBean getFileNameByReasoning(String[]words,String[]fileIdScoreSims,String type){
		if(!OntologyState){
			System.out.println("NULL");
			return null;
		}
		FileNameBean fileNameBean = null;
		OntologyStub stub = null;
		String[] wordFile = null;
		List<String> wordsAndSynonmList = new ArrayList<String>();
		SynonmIndexTool indexTool=new SynonmIndexTool();
		try {
			//获得同义词
			if(words!=null&&words.length!=0){
				for(String word:words){
					String s = indexTool.getSynonmWordsFromIndex(word);
					if(s!=null&&s.length()!=0){
						String[]SynonmWords = s.split("/");
						if(SynonmWords!=null&&SynonmWords.length!=0){
							for(String SynonmWord:SynonmWords){
								wordsAndSynonmList.add(SynonmWord);
								}
							}
					}
					wordsAndSynonmList.add(word);
					}
				}
			int size = wordsAndSynonmList.size();
			String[]wordsAndSynonms = new String[size];
			for(int i = 0;i<size;i++){
				wordsAndSynonms[i] = wordsAndSynonmList.get(i);
			}
			stub = new OntologyStub(Common.OntologyIp);
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(8000);
			if("1".equals(type)){
				InteractReasoning interactReasoning = new InteractReasoning();
				interactReasoning.setFaqList(fileIdScoreSims);
				interactReasoning.setWords(wordsAndSynonms);
				wordFile = stub.interactReasoning(interactReasoning).get_return();
				if(wordFile!=null&&wordFile.length!=0){
					if(wordFile[0]!=null){
						//message格式为<Exact#xxxx>xxxxx;<NAbstract#xxxx>xxxxx;<Abstract#xxxx>xxxxx
						String []message = wordFile[0].split(">");
						if(message!=null&&message.length==2){
							result=message[1];
						}
					}
					if(wordFile.length>1)
						fileNameBean = new FileNameBean();
					for(int i=1;i<wordFile.length;i++){
						String fileName = wordFile[i].split("#")[0];
						int level = 1;
						if(fileNameBean.getLevel(fileName)<=0){
							fileNameBean.setFileLevelMap(fileName, level);
						}else{
							fileNameBean.setFileLevelMap(fileName, level+fileNameBean.getLevel(fileName));
						}
					}
				}
			}else{
				MultilayerReasoning multilayerReasoning = new MultilayerReasoning();
				multilayerReasoning.setWords(wordsAndSynonms);
				multilayerReasoning.setFaqList(fileIdScoreSims);
				wordFile = stub.multilayerReasoning(multilayerReasoning).get_return();
				if(wordFile!=null&&wordFile.length!=0&&wordFile[0]!=null){
					fileNameBean = new FileNameBean();
					for(int i=0;i<wordFile.length;i++){
						try{
							String fileName = wordFile[i].split("#")[0];
							int level = 1;
							if(fileNameBean.getLevel(fileName)<=0){
								fileNameBean.setFileLevelMap(fileName, level);
							}else{
								fileNameBean.setFileLevelMap(fileName, level+fileNameBean.getLevel(fileName));
							}
						}catch (Exception e) {
							continue;
						}
					}
				}
			}
			return fileNameBean;
			}
		catch (Exception e) {
			e.printStackTrace();
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),ReasonerService.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return null;
		}
	}
	
	
	
	
	public static void main(String[]args){
		ReasonerService reasonerService= new ReasonerService();
		String [] a = {"网上电子报税","网上","电子报税","电子报","电子","报税","申报表","申报","报表","撤销","","",""};
		try {
			FileNameBean fileNameBean = reasonerService.getFileName(a);
			if(fileNameBean==null){
				System.out.println("cccccccccccccccc");
			}else{
				for(Object key:fileNameBean.getFileLevelMap().keySet()){
					System.out.println(key.toString()+":"+fileNameBean.getLevel(key.toString()));
				}
			}
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),ReasonerService.class.getName());
			} catch (Exception e1) {
				System.out.println("xxxxxxxxxx");
			}
		}

	}
	
}
