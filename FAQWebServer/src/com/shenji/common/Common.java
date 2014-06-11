package com.shenji.common;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import com.shenji.log.WriteLog;
import com.shenji.search.IniEditor;
import com.shenji.search.SearchLogic;

public class Common {
	/*public static final String configName="config.ini";
	public static final String systemName="system.ini";
	
	public static  String IP = "172.30.3.37:8088";
	public static  String notesName="test";
	//public static  String websPath ="http://172.30.3.37:8088/test";
	
	public static  String notesPath = "D:\\Program Files\\tomcat\\webapps\\test";
	public static  String indexPath = "D:\\Program Files\\tomcat\\Index";
	public static  String faqFolder ="faq";
	public static  String learnFolder ="learn";
	public static  String webFolder ="web";
	public static  String synFolder="synonm";
	public static  String mySynFolder="mySynonm";
	
	public static  String myDict="mydict.dic";
	public static  String businessDict="business.txt";
	public static  String synonmDict="synonmdict.txt";
	public static  String mySynonmDict="mySynonm.txt";
	*/
	public static final String configName="config.ini";
	public static final String systemName="system.ini";
	
		public static  String IPs ;
	public static  String IP ;
	public static String OntologyIp;
	public static String OntologyState;
	public static  String notesName;
	//public static  String websPath ="http://172.30.3.37:8088/test";
	
	public static  String notesPath ;
	public static  String indexPath ;
	public static  String faqFolder ;
	public static  String learnFolder ;
	public static  String webFolder ;
	public static  String synFolder;
	public static  String mySynFolder;
	
	public static  String myDict;
	public static  String businessDict;
	public static  String synonmDict;
	public static  String mySynonmDict;
	public static String dbIP;
	public static  String dbName;
	public static String user="root";
	public static String password="";
	static{
		IniEditor editor=new IniEditor();
		String path;
		try {
			path =editor.getClass().getClassLoader().getResource("").toURI().getPath();
			if(new File(path+systemName).exists()){
				editor.load(path+systemName);
				IP=editor.get("config", "IP");
				OntologyIp = editor.get("config", "OntologyIp");
				OntologyState= editor.get("config", "OntologyState");
				notesName=editor.get("config", "notesName");
				notesPath=editor.get("config", "notesPath");
				//notesPath=notesPath.replace("\\\\", "\\");
				indexPath=editor.get("config", "indexPath");
				//indexPath=indexPath.replace("\\\\", "\\");
				faqFolder=editor.get("config", "faqFolder");
				learnFolder=editor.get("config", "learnFolder");
				webFolder=editor.get("config", "webFolder");
				synFolder=editor.get("config", "synFolder");
				mySynFolder=editor.get("config", "mySynFolder");
				myDict=editor.get("config", "myDict");
				businessDict=editor.get("config", "businessDict");
				synonmDict=editor.get("config", "synonmDict");
				mySynonmDict=editor.get("config", "MySynonmDict");
				dbIP=editor.get("dbconfig", "dbIP");
				dbName=editor.get("dbconfig", "dbName");
				user=editor.get("dbconfig", "user");
				password=editor.get("dbconfig", "password");
				System.err.println(dbIP);
				System.err.println(dbName);
				System.err.println(user);
				System.err.println(password);
			}
		} catch (URISyntaxException e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),Common.class.getName());
		} 
	}
	/*public static String[] searchDir = {indexPath+"/"+faqFolder,
		indexPath+"/"+learnFolder,
		indexPath+"/"+webFolder};*/
	public static String[] searchDir = {indexPath+"/"+faqFolder};
	public static String webPath ="http://"+IP+"/"+notesName;
	public static String faqwebPath = "http://"+IP+"/axis2/test/faq";
	
	public static float maxMatchWeight=2;
	public static float myIkdictWeight=3;
	public static float qaProportion=3;
	//public static void main(String[] str){}
	public static void ResetParameters(){
		maxMatchWeight=2;
		myIkdictWeight=3;
		qaProportion=3;
		SearchLogic.maxResult=200;
		SearchLogic.maxTestShow=200;
		
	}
	
	
}
