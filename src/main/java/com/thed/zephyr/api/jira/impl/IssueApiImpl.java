package com.thed.zephyr.api.jira.impl;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.jira.IssueApi;
import org.springframework.stereotype.Service;

/**
 * @author manoj.behera
 *
 */
@Service("issueApi")
public class IssueApiImpl implements IssueApi {
	@Override
	public Response createIssue(RequestSpecification basicAuth, String payLoad){
		 String api = "/rest/api/2/issue";
		 Map<String, String> headers = new HashMap<String, String>();
		 headers.put("Content-Type", "application/json");
		 return basicAuth.headers(headers).body(payLoad).when().post(api);
	 }
	
	@Override
	public Response deleteIssue(RequestSpecification basicAuth, String issueKey){
		 String api = "/rest/api/2/issue/"+issueKey;
		 Map<String, String> headers = new HashMap<String, String>();
		 headers.put("deleteSubtasks", "true");
		 headers.put("Content-Type", "application/json");
		 return basicAuth.headers(headers).delete(api);
	 }
}
