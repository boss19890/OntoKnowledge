package com.shenji.services;

import cn.sjxx.knowledge.GetFaqReasonerTreeXml;
import cn.sjxx.knowledge.OntologyStub;

import com.shenji.common.Common;

public class GetFileXML {
	public boolean OntologyState = "true".equalsIgnoreCase(Common.OntologyState);
	public String getFileXMLString(String fileName){
		if(!OntologyState){
			return null;
		}
		try{
			OntologyStub stub = new OntologyStub(Common.OntologyIp);
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(8000);
			GetFaqReasonerTreeXml getFaqReasonerTreeXml = new GetFaqReasonerTreeXml();
			getFaqReasonerTreeXml.setIndividualName("faq_"+fileName);
			String[]results = stub.getFaqReasonerTreeXml(getFaqReasonerTreeXml).get_return();
			String result = "";
			if(results!=null&&results.length!=0){
				for(String s:results){
					result = result+s+"\n";
				}
			}
			return result;
		}catch(Exception e){
			return null;
		}
	}
}
