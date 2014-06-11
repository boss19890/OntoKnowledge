package org.wltea.analyzer.lucene;

import java.io.IOException;

public interface SynonymEngine {
	 //定义同义词字典
	String[] getSynonyms(String s) throws IOException;
	public void close();
}
