package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.IssuesApi;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@Service("issuesApi")
public class IssuesApiImpl implements IssuesApi {
	@Override
	public Response getissue(RequestSpecification basicAuth, String query, String currentJQL, String currentIssueKey, long currentProjectId) {
//		String api = "/rest/zapi/latest/issues?query="+query+"&currentJQL="+currentJQL+"&currentIssueKey="+currentIssueKey+"&currentProjectId="+currentProjectId;
		String api = "rest/zapi/latest/issues";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("query", query);
		params.put("currentJQL", currentJQL);
		params.put("currentIssueKey", currentIssueKey);
		params.put("currentProjectId", currentProjectId);
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");		
		return basicAuth.queryParameters(params).when().get(api);

	}
	@Override
	public Response getdefaultIssue(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/issues/default";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);

	}
}
