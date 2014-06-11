package com.shenji.services;

import org.apache.axis2.AxisFault;

import com.shenji.common.Common;

import cn.sjxx.knowledge.GetUserReasonerTreeXml;
import cn.sjxx.knowledge.OntologyStub;
import cn.sjxx.knowledge.SimpleReasoning;

public class GetTreeXML {
	public boolean OntologyState = "true".equalsIgnoreCase(Common.OntologyState);
	public String getTreeXMLString(String[]words) {
		if(!OntologyState){
			return null;
		}
		try{
			OntologyStub stub = new OntologyStub(Common.OntologyIp);
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(8000);
			GetUserReasonerTreeXml getUserReasonerTreeXml = new GetUserReasonerTreeXml();
			getUserReasonerTreeXml.setWords(words);
			String result = stub.getUserReasonerTreeXml(getUserReasonerTreeXml).get_return();
			return result;
		}catch(Exception e){
//			e.printStackTrace();
			return null;
		}
	}
}
