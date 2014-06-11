package com.shenji.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.shenji.common.Common;
import com.shenji.log.WriteLog;
import com.shenji.util.FileUse;

public class MySynonymDictTool {

	/**
	 * @param args
	 */
	private IndexWriter indexWriter=null;
	private Directory directory =null;
	
	public MySynonymDictTool(){	
	}
	public boolean initIndexWriter(File file){
		try {	
			this.directory =FSDirectory.open(file);
			Analyzer analyzer=new IKAnalyzer();
			indexWriter = new IndexWriter(directory, analyzer, IndexWriter.MaxFieldLength.UNLIMITED); 
			
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),MySynonymDictTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return false;
		}
		return true;
	}
	

	public void destroy(Directory directory) throws Exception {  
		//Directory directory = FSDirectory.open( new File(FAQIndexPath) );
		if(IndexWriter.isLocked(directory)){   
		     IndexWriter.unlock(directory);  
		 }  
	}  
	
	private boolean createFolder(File file){
		if(!file.exists()){
			file.mkdir();
			return true;
		}
		else
			return false;
	}
	public boolean createIndex(){
	    String orcName = "word";
	    String synonmName="syn";
        Analyzer analyzer = new IKAnalyzer();
        File file=new File(Common.indexPath+"/"+Common.mySynFolder);
        if(file.exists())
        	FileUse.DeleteFolder(Common.indexPath+"/"+Common.mySynFolder);
        if(!file.exists()){
        	boolean b=createFolder(file);
        	if(b==false)
        		return false;
        } 
        
        if(initIndexWriter(file)==false)
        	return false;
		try {
	        List<String[]> list_mainDict=readSynonmDict(Common.mySynonmDict);
	        List<String[]> list=list_mainDict;
	        for(int i=0;i<list.size();i++){
	        	  Document document = new Document();
	              document.add(new Field(orcName, list.get(i)[0].toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
	              for(int j=0;j<list.get(i).length;j++){
	            	  document.add(new Field(synonmName, list.get(i)[j].toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
	              }           
	              indexWriter.addDocument(document);
	        }
	        indexWriter.optimize();

		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),MySynonymDictTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
       finally{        	
			try {
		        if(indexWriter!=null){
		        	indexWriter.close();
		        }
				destroy(directory);			
				if(directory!=null)
					directory.close();
			} catch (Exception e) {
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),MySynonymDictTool.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} 
        }       
		return true;
	}
	
	
	public String getMySynonmWordsFromIndex(String word){	
		List<String> list=new ArrayList<String>();
		String result=null;
		MySynonymDict mySynonymDict=null;
		try {			
			File file=new File(Common.indexPath+"/"+Common.mySynFolder);
			mySynonymDict=new MySynonymDict(file);	
			String[] strings=mySynonymDict.getSynonyms(word);			
			for(int i=0;i<strings.length;i++){
				if(i==0){
					result=strings[0];
					continue;
				}
				result=result+"/"+strings[i];
			}
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),MySynonymDictTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		finally{
			if(mySynonymDict!=null)
				mySynonymDict.close();		
		}
		//System.err.println(result);
		return result;		
	}
	
	private List<String[]> readSynonmDict(String fileName){
		List<String[]> list=new ArrayList<String[]>();
		FileInputStream fileInputStream=null;
		InputStreamReader inputStreamReader=null;
		BufferedReader bufferedReader=null;
		String path;
		try {
			path = this.getClass().getClassLoader().getResource("").toURI().getPath();
			File file=new File(path+fileName);
			fileInputStream=new FileInputStream(file);
			inputStreamReader=new InputStreamReader(fileInputStream, "utf-8");
			bufferedReader=new BufferedReader(inputStreamReader);
			String str=null;
			while((str=bufferedReader.readLine())!=null){
				String[] strings=str.split(" ");
				//System.err.println(strings[0]);
				list.add(strings);
			}
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),MySynonymDictTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		finally{			
			try {
				if(fileInputStream!=null)
					fileInputStream.close();
				if(inputStreamReader!=null)
					inputStreamReader.close();
				if(bufferedReader!=null)
					bufferedReader.close();
			} catch (IOException e) {
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),MySynonymDictTool.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return list;
		
	}

	
	
	
	/*public void End() {
		try {
			if(indexWriter!=null){
				indexWriter.optimize();
				indexWriter.commit();				
				indexWriter.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long s=System.currentTimeMillis();
		MySynonymDictTool indexTool=new MySynonymDictTool();
		indexTool.createIndex();
		long b=System.currentTimeMillis();
		System.err.println(b-s);
		/*Set<String> set=new TreeSet<String>();
		set.add("吊死扶伤");
		set.add("东方时代");
		set.add("住方时代");
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext()){
			System.err.println(iterator.next());
		}*/

		

	}

}
