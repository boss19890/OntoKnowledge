package com.shenji.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.shenji.log.WriteLog;

public class ConfigurantionUtil {
	private Properties properties=null;
	private FileInputStream inputStream=null;
	private FileOutputStream outputStream=null;
	private File file;
	private String filepath;
	

	public ConfigurantionUtil(File file){
		try {
			this.file=file;
			inputStream =new FileInputStream(file);
			this.properties=new Properties();
			if(null!=inputStream){
				this.properties.load(inputStream);
			}			
		} catch (FileNotFoundException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),ConfigurantionUtil.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),ConfigurantionUtil.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		finally{
			try {
				if(inputStream!=null)
					inputStream.close();
			} catch (IOException e) {
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),ConfigurantionUtil.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}	
	}
	public HashMap<String,Integer> getValues(){
		HashMap map=new HashMap<String, String>();
		Enumeration en = this.properties.propertyNames();
        while (en.hasMoreElements()) {
        	String key = (String) en.nextElement();
            int Property = Integer.parseInt(this.properties.getProperty (key));
            map.put(key, Property);
           // System.out.println(key+Property);
        }
        return map;
	}
	
	public String getValue(String key){
		String value=null;
		if(this.properties.containsKey(key)){
			value=properties.getProperty(key);
		}
		return value;
	}
	
	public void clear(){
		this.properties.clear();
	}
	
	public void setValue(String key,String value){
		properties.setProperty(key, value);
	}
	
	public void savaFile(String description){
		try {
			outputStream=new FileOutputStream(file);
			properties.store(outputStream,description);
		} catch (FileNotFoundException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),ConfigurantionUtil.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),ConfigurantionUtil.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		finally{			
				try {
					if(outputStream!=null)
						outputStream.close();
				} catch (IOException e) {
					WriteLog writeLog = new WriteLog();
					try {
						writeLog.Write(e.getMessage(),ConfigurantionUtil.class.getName());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
		}
	}
	
	
}
