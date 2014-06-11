package com.shenji.services;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shenji.log.WriteLog;
import com.shenji.search.SearchLogic;
import com.shenji.tools.ConfigurantionUtil;
import com.shenji.util.FileUse;


public class SearchPatternMatching {
	private static String patternMatchingFileName="patternMatching.properties";
	private static HashMap<String, Integer> patternMap;
	static{
		try {
			String path = new FileUse().getClass().getClassLoader().getResource("").toURI().getPath();
			File file=new File(path+patternMatchingFileName);
			if(!file.exists())
				file.createNewFile();
			patternMap=new HashMap<String, Integer>();
			ConfigurantionUtil configurantionUtil=new ConfigurantionUtil(file);
			patternMap=configurantionUtil.getValues();			
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SearchPatternMatching.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} 
	}
	
	public static String questionMatching(String arg){
		Iterator<Map.Entry<String, Integer>> iterator=patternMap.entrySet().iterator();
		String resultStr=null;
		while(iterator.hasNext()){
			Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) iterator.next();
			String matcher=entry.getKey();
			int strategyType=entry.getValue();
			PatternMatchingStrategy strategy=new PatternMatchingStrategy(strategyType);
			resultStr=strategy.getResult(arg, matcher);
			if(resultStr!=null&&resultStr.length()>0){
				arg=resultStr;
//				if(strategyType>200){
//					break;
//				}
			}	
		} 	
		return arg;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
