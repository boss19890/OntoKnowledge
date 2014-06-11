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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.TermVector;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.wltea.analyzer.lucene.SynonymAnalyzer;
import org.wltea.analyzer.lucene.SynonymEngine;

import com.shenji.common.Common;
import com.shenji.filemanager.FileManager;
import com.shenji.log.WriteLog;
import com.shenji.util.FileUse;

public class SynonmIndexTool {

	/**
	 * @param args
	 */
	//这两个是哈工大同义词库进行处理的远文件
	private String hgdSynonmDict="synonm.txt";
	private String codeSynonmDict="synonm_new.txt";	
	private IndexWriter indexWriter=null;
	private Directory directory;
	
	public SynonmIndexTool(){	
	}
	public boolean initIndexWriter(File file){ 
		try {	
			this.directory = FSDirectory.open(file);
			destroy(directory);
			Analyzer analyzer=new IKAnalyzer();
			indexWriter = new IndexWriter(directory, analyzer, IndexWriter.MaxFieldLength.UNLIMITED);  
		} catch (Exception e) {
			try {
				if(indexWriter!=null){
		        	indexWriter.close();
		        }
				destroy(directory);						
				if(directory!=null)
					directory.close();
				WriteLog writeLog = new WriteLog();
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			}catch (Exception e1) {}
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
			file.mkdirs();
			return true;
		}
		else
			return false;
	}
	/*
	 * synonmWords:新增的同义词
	 * newSynonWords:新增之后全部的同义词(包括旧的同义词)
	 */
	public boolean addIndex(String word,String[] synonmWords,String[]newSynonWords){
	    String orcName = "word";
	    String synonmName="syn";
        if(synonmWords==null||synonmWords.length==0)
        	return true;
    	String[][] words= new String[synonmWords.length][];
		for(int i = 0;i<synonmWords.length;i++){
			String[] s = getSynonmWords(synonmWords[i]);
			if(s!=null){
				words[i] = new String[s.length];
				for(int j = 0;j<s.length;j++)
					words[i][j] = s[j];
			}else{
				words[i] = new String[0];
			}
		}
		File file=new File(Common.indexPath+"/"+Common.synFolder);
        if(initIndexWriter(file)==false)
        	return false;
    	try {
			indexWriter.deleteDocuments(new Term(orcName,word));
		}catch (IOException e) {
			e.printStackTrace();
		}
        try{
        	for(int k = 0;k<synonmWords.length;k++){
    			indexWriter.deleteDocuments(new Term(orcName,synonmWords[k]));
    			Document doc1 = new Document();
    	        doc1.add(new Field(orcName, synonmWords[k].toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
    	        doc1.add(new Field(synonmName, synonmWords[k].toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
    	        for(String syn:words[k]){
    	        	if(!word.equalsIgnoreCase(syn))
    	        		doc1.add(new Field(synonmName, syn.toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
    	        }
    	        doc1.add(new Field(synonmName, word.toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
    	        indexWriter.addDocument(doc1);
            }
        	Document doc2 = new Document();
	        doc2.add(new Field(orcName, word.toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
	        doc2.add(new Field(synonmName, word.toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
	        for(String syn:newSynonWords){
	        	doc2.add(new Field(synonmName, syn.toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
	        }
	        indexWriter.addDocument(doc2);
	        indexWriter.optimize();
	        return true;

        }catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return false;
		}
        finally{        	
			try {
				if(indexWriter!=null){
		        	indexWriter.close();
		        }
				destroy(directory);						
				if(directory!=null)
					directory.close();
			}catch (Exception e) {
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
        }  
	}
	
	public boolean modifyIndex(String word,String[]oldSynonmWords,String[]newSynonWords){
	    String orcName = "word";
	    String synonmName="syn";
		File file=new File(Common.indexPath+"/"+Common.synFolder);
		initIndexWriter(file);
		List<String> synonmWordslList = new ArrayList<String>();
		List<String> oldSynonmWordsList = Arrays.asList(oldSynonmWords);
		List<String> newSynonmWordsList = Arrays.asList(newSynonWords);
		List<String> delList = new ArrayList<String>();
		for(String syn:newSynonWords){
			if(!oldSynonmWordsList.contains(syn)){
				synonmWordslList.add(syn);
			}
		}
		try{
			for(String syn:oldSynonmWords){
				if(!newSynonmWordsList.contains(syn)){
					String[] synWords = getSynonmWords(syn);
					if(synWords==null)
						continue;
					indexWriter.deleteDocuments(new Term(orcName,syn));
					Document doc = new Document();
			        doc.add(new Field(orcName, syn.toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
			        doc.add(new Field(synonmName, syn.toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
					for(String synWord:synWords){
						if(!synWord.equalsIgnoreCase(word)){
							doc.add(new Field(synonmName, synWord.toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
						}
					}
					indexWriter.addDocument(doc);
				}
			}
			indexWriter.optimize();
		}catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return false;
		}
        finally{
			try {
				if(indexWriter!=null){
		        	indexWriter.close();
		        }
				destroy(directory);						
				if(directory!=null)
					directory.close();
			}catch (Exception e) {
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
        }
		String[]synonmWords = new String[synonmWordslList.size()];
		synonmWordslList.toArray(synonmWords);
		return addIndex(word,synonmWords,newSynonWords);
	}
	
	
	public boolean createIndex() { 
	    String orcName = "word";
	    String synonmName="syn";
        Analyzer analyzer = new IKAnalyzer();
        File file=new File(Common.indexPath+"/"+Common.synFolder);
        if(file.exists()){
        	FileUse.deleteDirectory(Common.indexPath+"/"+Common.synFolder);
        	if(!file.exists())
        	{
        		System.err.println("删除文件夹成功！");
        	}
        	else
        	{
        		System.err.println("PROC FAILED");
        	}
        }
        	
       if(!file.exists()){
        	boolean b=createFolder(file);
        	System.err.println("创建文件夹成功！");
        	if(b==false)
        		return false;
        } 
        if(initIndexWriter(file)==false)
        	return false;
		try {
	        List<String[]> list_mainDict=readSynonmDict(Common.synonmDict);
	        List<String[]> list=list_mainDict;
	        List<String> nonSameList = new ArrayList<String>();
	        for(int i=0;i<list.size();i++){
	        	if(!nonSameList.contains(list.get(i)[0])){
	        		nonSameList.add(list.get(i)[0]);
		        	Document document = new Document();
		            document.add(new Field(orcName, list.get(i)[0].toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
		            for(int j=0;j<list.get(i).length;j++){
		            	document.add(new Field(synonmName, list.get(i)[j].toLowerCase(), Field.Store.YES, Field.Index.NOT_ANALYZED));
		            }
		            indexWriter.addDocument(document);
	        	}
	        }
	        indexWriter.optimize();
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
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
				
			}catch (Exception e) {
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
        }       
		return true;
	}
	/*public void AddIndex(String word,String[] synonmWords) {
		if(indexWriter==null)
			initIndexWriter();
		String orcName = "word";
		String synonmName="syn";
	    File file=new File(index_path+index_folder); 
	    try {		
		    Document document = new Document();
		    document.add(new Field(orcName, word, Field.Store.YES, Field.Index.NOT_ANALYZED));
		    for(String s:synonmWords){
		    	document.add(new Field(synonmName, s, Field.Store.YES, Field.Index.NOT_ANALYZED));
		    }		                  
		    indexWriter.addDocument(document); 
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public String[] getSynonmWords(String word){
		SynonymEngine engine=null;
		try {
			File file=new File(Common.indexPath+"/"+Common.synFolder);
			engine=new SynonymDict(file);
			String[] strings=engine.getSynonyms(word.toLowerCase());
			return strings;
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return null;
		}
		finally{
			if(engine!=null)
				engine.close();
		}
	}
	
	
	public String getSynonmWordsFromIndex(String word){
		
		String result=null;
		SynonymEngine engine=null;
		try {
			File file=new File(Common.indexPath+"/"+Common.synFolder);
			engine=new SynonymDict(file);
			String[] strings=engine.getSynonyms(word.toLowerCase());
			List<String> list = new ArrayList<String>();
			list.add(word);
			for(int i=0;i<strings.length;i++){
				if(i==0){
					list.add(strings[i]);
					result = strings[0];
				}else{
					if(!list.contains(strings[i])){
						list.add(strings[i]);
						result=result+"/"+strings[i];
					}
				}
				//同义词少于10个才进一步取同义词的同义词
				if(strings.length<10){
					String[] strings2 = engine.getSynonyms(strings[i].toLowerCase());
					for(int j = 0;j<strings2.length;j++){
						if(!list.contains(strings2[j])){
							list.add(strings2[j]);
							result = result+"/"+strings2[j];
						}
					}
				}
				
			}
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		finally{
			
			if(engine!=null)
				engine.close();
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
		} catch (URISyntaxException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
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
					writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return list;
		
	}

	
	private boolean writeHGDSynonmDict(){
		List<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
		List<SynonmBean> listBeans=new ArrayList<SynonmBean>();
		List<SynonmBean> listBeans_resutlt=new ArrayList<SynonmBean>();
		String path=null;
		File file=null;
		File newFile=null;
		FileInputStream fileInputStream=null;
		InputStreamReader inputStreamReader=null;
		BufferedReader bufferedReader=null;
		FileOutputStream fileOutputStream=null;
		OutputStreamWriter outputStreamWriter=null;
		BufferedWriter bufferedWriter=null;
		String str=null;
		try {
			path=this.getClass().getClassLoader().getResource("").toURI().getPath();
			file=new File(path+hgdSynonmDict);
			fileInputStream=new FileInputStream(file);
			inputStreamReader=new InputStreamReader(fileInputStream, "utf-8");
			bufferedReader=new BufferedReader(inputStreamReader);
			while((str=bufferedReader.readLine())!=null){
				ArrayList<String> arrayList=new ArrayList<String>();
				String[] strings=str.split(" ");
				for(String s:strings){
					arrayList.add(s);
					//System.err.print(s);
				}
				System.err.println();
				list.add(arrayList);
			}
			int size=list.size();
			for(int i=0;i<size;i++){
				String orcWord=list.get(i).get(0);
				for(int j=2;j<list.get(i).size();j++){
					if(!list.get(i).get(j).contains("="))
						continue;
					String orcCode=list.get(i).get(j);
					SynonmBean bean=new SynonmBean();					
					bean.setOrcWord(orcWord);
					System.out.println("orcWord:"+bean.getOrcWord());
					for(int k=0;k<size;k++){
						String synomWord=list.get(k).get(0);
						if(i==k)
							continue;
						for(int z=2;z<list.get(k).size();z++){
							String synonmCode=list.get(k).get(z);
							if(orcCode.equals(synonmCode)){
								bean.add(synomWord);
								System.out.println("synomWord:"+synomWord);
							}
						}
						
					}
					listBeans.add(bean);
				}
				
			}
			file=new File(path+codeSynonmDict);
			fileOutputStream=new FileOutputStream(file);
			outputStreamWriter=new OutputStreamWriter(fileOutputStream, "utf-8");
			bufferedWriter=new BufferedWriter(outputStreamWriter);
			for(int i=0;i<listBeans_resutlt.size();i++){
				SynonmBean bean=listBeans_resutlt.get(i);
				bufferedWriter.write(bean.getOrcWord()+" ");
				String [] synonmWords=(String[])listBeans_resutlt.get(i).getSynonmWords().toArray(new String[listBeans_resutlt.get(i).getSynonmWords().size()]);
				for(String s:synonmWords){
					bufferedWriter.write(s+" ");
				}
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();	
			
		/*StringBuilder builder=new StringBuilder();
		SynonmBean bean=null;
		for(int i=0;i<listBeans.size();i++){
			for(int j=0;j<listBeans.size();j++){
				if(i==j)
					continue;
				if(listBeans.get(i).get(0).equals(listBeans.get(j).get(0))){
					for(int k=1;k<listBeans.get(j).getSynonmWords().size();k++){
						listBeans.get(i).getSynonmWords().add(listBeans.get(j).get(k));
					}
					builder.append(j);
				}			
			}
			if(builder.indexOf(String.valueOf(i))!=-1){
				bean=listBeans.get(i);
				bufferedWriter.write(bean.getOrcWord()+" ");
				String [] synonmWords=(String[])listBeans.get(i).getSynonmWords().toArray(new String[listBeans.get(i).getSynonmWords().size()]);
				for(String s:synonmWords){
					bufferedWriter.write(s+" ");
				}
				bufferedWriter.newLine();
			}			
		}	
		bufferedWriter.flush();*/					
			
		} catch (URISyntaxException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
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
				if(fileOutputStream!=null)
					fileOutputStream.close();
				if(outputStreamWriter!=null)
					outputStreamWriter.close();
				if(bufferedWriter!=null)
					bufferedWriter.close();
			} catch (IOException e) {
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return true;
	}
	private void dellSynonDict(){
		String path;
		FileOutputStream fileOutputStream=null;
		OutputStreamWriter outputStreamWriter=null;
		BufferedWriter bufferedWriter=null;
		try {
			path = this.getClass().getClassLoader().getResource("").toURI().getPath();
			File file_in=new File(path+codeSynonmDict);
			File file_out=new File(path+Common.synonmDict);
			try {
				fileOutputStream=new FileOutputStream(file_out,true);
			} catch (Exception e) {
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			try {
				outputStreamWriter=new OutputStreamWriter(fileOutputStream, "utf-8");
			} catch (Exception e) {
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			bufferedWriter=new BufferedWriter(outputStreamWriter);				
			ArrayList<String> list=FileUse.read(file_in);
			
			StringBuilder builder=new StringBuilder();	
			//ArrayList<String> listResult=new ArrayList<String>();
			for(int i=0;i<list.size();i++){
				Set<String> set=new TreeSet<String>();
				String str=list.get(i).split(" ")[0]+" ";
				
				for(int m=1;m<list.get(i).split(" ").length;m++){
					set.add(list.get(i).split(" ")[m]);
				}
				for(int j=0;j<list.size();j++){
					if(i==j)
						continue;
					String stri=(list.get(i).split(" "))[0];
					String strj=(list.get(j).split(" "))[0];
					if(stri.equals(strj)){
						String[] strjs=list.get(j).split(" ");												
						for(int k=1;k<strjs.length;k++){
							set.add(strjs[k]);
						}
						builder.append(j);
					}			
				}							
				if(builder.indexOf(String.valueOf(i))==-1){
					Iterator<String> iterator=set.iterator();
					while(iterator.hasNext()){
						str=str+iterator.next()+" ";
					}
					System.out.println(str);
					bufferedWriter.write(str);
					bufferedWriter.newLine();
					bufferedWriter.flush();	
					
				}
				set.clear();
			}	
			
			
		} catch (URISyntaxException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} 
		finally{		
			try {				
				if(fileOutputStream!=null)
					fileOutputStream.close();
				if(outputStreamWriter!=null)
					outputStreamWriter.close();
				if(bufferedWriter!=null)
					bufferedWriter.close();
			} catch (IOException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}
	public void End() {
		try {
			if(indexWriter!=null){
				indexWriter.optimize();
				indexWriter.commit();				
				indexWriter.close();
			}
			
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonmIndexTool.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}


}
