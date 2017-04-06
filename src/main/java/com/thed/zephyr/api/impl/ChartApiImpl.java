/**
 * Created by manoj.behera on 21-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.ChartApi;

/**
 * @author manoj.behera 21-Nov-2016
 *
 */
@Service("chartApi")
public class ChartApiImpl  implements ChartApi{
	@Override
	public Response getTestCreated(RequestSpecification basicAuth, String projectKey, int daysPrevious, String periodName) {
		String api = "/rest/zapi/latest/zchart/testsCreated?projectKey="+projectKey+"&daysPrevious="+daysPrevious+"&periodName="+periodName;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	
	@Override
	public Response getIssueStatuses(RequestSpecification basicAuth, long projectId) {
		String api = "/rest/zapi/latest/zchart/issueStatuses?projectId="+projectId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
}