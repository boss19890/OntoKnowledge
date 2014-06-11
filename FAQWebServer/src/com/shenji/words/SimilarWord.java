package com.shenji.words;

import java.util.List;

import com.shenji.DBManager.DBUtil;

public class SimilarWord {
	private static double a = 0.65, b = 0.8, c = 0.9, d = 0.96, e = 0.5, f = 0.1; 
	private static double PI=3.1415926;
	public double getSimilar(String word1,String word2){
		double maxSimilar=0.1;
		String wordCodeStr1=SimilarWordDict.getInstance().getWordCode(word1);
		String wordCodeStr2=SimilarWordDict.getInstance().getWordCode(word2);
		//词不存在
		if(wordCodeStr1==null||!wordCodeStr1.contains(";"))
			return -1;
		if(wordCodeStr2==null||!wordCodeStr2.contains(";"))
			return -2;
		String[] wordCode1=wordCodeStr1.split(";");
		String[] wordCode2=wordCodeStr2.split(";");
		for(String code1:wordCode1){
			if(code1==null||code1.length()<7)
				continue;
			for(String code2:wordCode2){
				if(code2==null||code2.length()<7)
					continue;
				double tempSimilar=getSimilarByCode(code1, code2);
				if(tempSimilar>maxSimilar)
					maxSimilar=tempSimilar;
			}
		}
		return maxSimilar;
	}
	
	private double getSimilarByCode(String wordCode1,String wordCode2){
		double similar=0.0;
		int n=1;
		int k=0;
		char[] ch1=wordCode1.toCharArray();
		char[] ch2=wordCode2.toCharArray();
		
		if(ch1[0]!=ch2[0])
			return similar;
		if(ch1[1]!=ch2[1]){
			k=Math.abs(ch1[1]-ch2[1]);
			n=SimilarWordDict.getInstance().TreeBranchNum(String.valueOf(ch1[0]), 1);
			similar=a*Math.cos(n*PI/180)*((double)(n-k+1)/n);
			return similar;
		}
		String s1=wordCode1.substring(2, 4);
		String s2=wordCode2.substring(2, 4);
		if(!s1.endsWith(s2)){
			k=Math.abs(Integer.valueOf(s1)-Integer.valueOf(s2));
			n=SimilarWordDict.getInstance().TreeBranchNum(wordCode1.substring(0,2), 2);
			similar=b*Math.cos(n*PI/180)*((double)(n-k+1)/n);
			return similar;
		}
		if(ch1[4]!=ch2[4]){
			k=Math.abs(ch1[4]-ch2[4]);
			n=SimilarWordDict.getInstance().TreeBranchNum(wordCode1.substring(0,4), 1);
			similar=c*Math.cos(n*PI/180)*((double)(n-k+1)/n);
			return similar;
		}
		s1=wordCode1.substring(5, 7);
		s2=wordCode2.substring(5, 7);
		if(!s1.endsWith(s2)){
			k=Math.abs(Integer.valueOf(s1)-Integer.valueOf(s2));
			n=SimilarWordDict.getInstance().TreeBranchNum(wordCode1.substring(0,5), 2);
			similar=d*Math.cos(n*PI/180)*((double)(n-k+1)/n);
			return similar;
		}	
		return 1.0;
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		System.out.println("Similar----------:"+new SimilarWord().getSimilar("男人", "鲤鱼"));
		long end=System.currentTimeMillis();
		System.err.println("time-------------:"+(end-start));
		
	}

}
