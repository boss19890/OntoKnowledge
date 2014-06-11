package com.shenji.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

public class WriteLog {
	public void Write(String log,String className){
		try{
			BufferedReader bufReader = new BufferedReader(new FileReader(
					new WriteLog().getClass().getClassLoader().getResource("").toURI().getPath()+"log4j.properties"));
			String line = null;
			String[]path = new String[2];
			while ((line=bufReader.readLine())!=null) {
				line = line.trim();
				path = line.split("=");
				if(path[0]!=null&&path[0].equalsIgnoreCase("log4j.appender.LOGFILE.File")){
					//生成目录
					File file = new File(path[1]);
					if(!file.exists()){
						file.getParentFile().mkdirs();
					}
					break;
				}
			}
			bufReader.close();
			Logger logger = Logger.getLogger(className);
			logger.info(log);
		}
		catch (Exception e) {}
	}
}
