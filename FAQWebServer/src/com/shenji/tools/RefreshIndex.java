package com.shenji.tools;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.TermVector;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.wltea.analyzer.lucene.SynonymAnalyzer;
import org.wltea.analyzer.lucene.SynonymEngine;

import com.shenji.common.Common;
import com.shenji.filemanager.FileManager;
import com.shenji.log.WriteLog;

public class RefreshIndex {

	private Document doc = null;   
	private IndexWriter indexWriter = null;   
	private int[] index = null;
	
	public RefreshIndex(String index) {
		String[] in = index.split(";");
		this.index = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			this.index[i] = Integer.parseInt(in[i]);
		}
	}
	
	private String delHTMLTag(String htmlStr){ 
		
		htmlStr = htmlStr.replaceAll(".*?<body.*?>(.*?)","$1");			  // match body
		htmlStr = htmlStr.replaceAll("(?is)<script.*?>.*?</script>", ""); // remove javascript
		htmlStr = htmlStr.replaceAll("(?is)<style.*?>.*?</style>", "");   // remove css
		htmlStr = htmlStr.replaceAll("(?is)<.*?>", "");					  // remove all

        return htmlStr.trim(); //�����ı��ַ� 
    } 
	private String getQuestion(String htmlStr){
		org.jsoup.nodes.Document document=null;
		document =Jsoup.parse(htmlStr);
		Elements meta = document.select(".q"); 
		//System.out.println(meta.text());
		return meta.text();
	}
	
	private String getAnswer(String htmlStr){
		org.jsoup.nodes.Document document=null;
		document =Jsoup.parse(htmlStr);
		Elements meta = document.select(".a"); 
		//System.out.println(meta.text());
		return meta.text();
	}
	
	private void dealDir(File dir)
	{
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if(files[i].isDirectory())
				dealDir(files[i]);
            else
            	dealFile(files[i]);
		}
	}
	
	private String getName(File file)
	{
		try {
			String path = file.getCanonicalPath();
			path= path.replace("\\", "/");
			path = path.replace(Common.notesPath, "");
			path=path.substring(1, path.length());
			return path.replace('\\', '/');
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void dealFile(File file) {
		FileManager f = new FileManager();
		try {
			String html = f.read(file.getCanonicalPath(), "utf-8");
			
			String content = delHTMLTag(html);
			doc = new Document();   
			Field c = new Field("content", content, Field.Store.YES, Field.Index.ANALYZED, TermVector.NO);  
			doc.add(c);
			
			String question=getQuestion(html);
			Field q=new Field("question", question, Field.Store.YES, Field.Index.ANALYZED, TermVector.NO);
			doc.add(q);
			
			
			String answer=getAnswer(html);
			Field a=new Field("answer", answer, Field.Store.YES, Field.Index.ANALYZED, TermVector.NO);
			doc.add(a);
			
			Field p = new Field("path", getName(file), Field.Store.YES,Field.Index.NOT_ANALYZED);
			System.err.println(getName(file));
			doc.add(p);
			indexWriter.addDocument(doc);   
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),RefreshIndex.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void deleteDir(File file){ 
		if(file.exists()){ 
		    if(file.isFile()){ 
		    	file.delete(); 
		    	return;
		    }else if(file.isDirectory()){ 
		    	File files[] = file.listFiles(); 
		    	for(int i=0;i<files.length;i++){ 
		    		deleteDir(files[i]); 
		    	} 
			    file.delete(); 
		    } 
		}else{ 
		    System.out.println("文件不存在"+'\n'); 
		} 
	} 
	
	public int createIndex() {   
		Directory directory = null;   
		String[] searchDir = {Common.indexPath+"/"+Common.faqFolder,Common.indexPath+"/"+Common.learnFolder};
		File[] htmlDir = {new File(Common.notesPath+"/"+Common.faqFolder),new File(Common.notesPath+"/"+Common.learnFolder)};
		File indexFile = null;   
		Analyzer analyzer = null;   
		/** ����ҳ�滺�� */  
		int maxBufferedDocs = 500;  
		SynonymEngine engine=new SynonymDict(new File(Common.indexPath+"/"+Common.synFolder));
		for (int i = 0; i < index.length; i++) {
			try {
				indexFile = new File(searchDir[index[i]]);   
				if(indexFile.exists()) {   
					deleteDir(indexFile);
				}   
				indexFile.mkdir();   
				directory = FSDirectory.open(indexFile);   
				//analyzer = new IKAnalyzer(); 			
				analyzer=new SynonymAnalyzer(engine);				
				indexWriter = new IndexWriter(directory, analyzer, true, IndexWriter.MaxFieldLength.UNLIMITED);   
				indexWriter.setMaxBufferedDocs(maxBufferedDocs);   
			    dealDir(htmlDir[i]);
				indexWriter.optimize();   
				indexWriter.close();
				
			} catch(Exception e) {   
				WriteLog writeLog = new WriteLog();
				try {
					writeLog.Write(e.getMessage(),RefreshIndex.class.getName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				return -1;
			} 
			
		} 
		if(engine!=null)
			engine.close();
		return index.length;
	} 
	

}
