package org.wltea.analyzer.lucene;

import java.io.IOException;
import java.util.Stack;

import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.AttributeSource;
import org.wltea.analyzer.dic.Dictionary;

import com.shenji.log.WriteLog;

public class SynonymFilter extends TokenFilter {
	 //用栈保存同义词集合
	private Stack<String> syninymStack;
	private SynonymEngine engine;
	//定义一个状态
	private AttributeSource.State current;
	//保存相应的词汇
	private TermAttribute termAttribute;
	private PositionIncrementAttribute positionIncrementAttribute;

	protected SynonymFilter(TokenStream input,SynonymEngine engine) {
		super(input);
		this.syninymStack=new Stack<String>();
		this.engine=engine;
		this.termAttribute=addAttribute(TermAttribute.class);
		this.positionIncrementAttribute=addAttribute(PositionIncrementAttribute.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean incrementToken() throws IOException {
		// TODO Auto-generated method stub
		if(syninymStack.size()>0){
			//将元素出栈,并获取同义词
			String syn=syninymStack.pop();
			//还原状态
			restoreState(current);
			termAttribute.setTermBuffer(syn);
			//设置位置为0,表示同义词
			positionIncrementAttribute.setPositionIncrement(0);
			return true;
		}
		if(!input.incrementToken()){
			return false;
		}
		 //如果该词中有同义词,捕获当前状态
		if(addAliasesToStack()){
			current=captureState();
		}
		
		return true;
	}
	
	private boolean addAliasesToStack(){
		String[] synonyms=null;
		try {
			synonyms = engine.getSynonyms(termAttribute.term());
		} catch (IOException e) {
			WriteLog writeLog = new WriteLog();
			try {
				writeLog.Write(e.getMessage(),SynonymFilter.class.getName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(synonyms==null)
			return false;
		for(String synonym:synonyms){
			syninymStack.push(synonym);
		}
		return true;
	}

}
