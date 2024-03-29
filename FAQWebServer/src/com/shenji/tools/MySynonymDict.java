package com.shenji.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.SynonymEngine;

import com.shenji.common.Common;
import com.shenji.log.WriteLog;
import com.shenji.search.SearchBean;

public class MySynonymDict implements SynonymEngine {
	private IndexSearcher indexSearcher;
	private Directory directory;
	private static String WORD="word";
	private static String SYNONM="syn";
	
	public MySynonymDict(File index){
		try {
			directory=FSDirectory.open(index);
			indexSearcher=new IndexSearcher(directory);
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),MySynonymDict.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}		
	}
	
	public void close(){
		try {
			if(indexSearcher!=null)
				indexSearcher.close();
			if(directory!=null)
				directory.close();
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),MySynonymDict.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public String[] getSynonyms(String word) throws IOException {
		// TODO Auto-generated method stub
		List<String> synList=new ArrayList<String>();
		Term term=new Term(WORD, word);
		TermQuery query=new TermQuery(term);
		TopDocs topDocs = indexSearcher.search(query, 20);
		if(topDocs==null)
			return null;
		ScoreDoc[] docs = topDocs.scoreDocs;
		for(ScoreDoc doc :docs){
			Document d = indexSearcher.doc(doc.doc);
			String[] values=d.getValues(SYNONM);
			for(int i=1;i<values.length;i++){
				synList.add(values[i]);
				//System.err.println(values[i]);
			}
		}
		//close();
		return synList.toArray(new String[0]);	
	}
	
	
	public static void main(String[] str){
		MySynonymDict dict=new MySynonymDict(new File(Common.indexPath+"\\"+Common.mySynFolder));
		try {
			String[] strings=dict.getSynonyms("增值税发票");
			for(String s:strings)
				System.out.println(s);
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),MySynonymDict.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		finally{
			dict.close();
		}
	}

}
