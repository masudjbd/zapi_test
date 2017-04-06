/**
 * Created by manoj.behera on 21-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.JiraReportApi;

/**
 * @author manoj.behera 21-Nov-2016
 *
 */
@Service("jiraReportApi")
public class JiraReportApiImpl  implements JiraReportApi{
	@Override
	public Response getDashboardByName(RequestSpecification basicAuth, String query, int maxRecords) {
		String api = "/rest/zapi/latest/util/dashboard?query="+query+"&maxRecords="+maxRecords;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");		
		return basicAuth.headers(headers).when().get(api);
	}
	@Override
	public Response testCount(RequestSpecification basicAuth,String groupFld,Long projectId,Long versionId) {
		String api = "/rest/zapi/latest/test/count";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.queryParam("projectId", projectId).queryParam("versionId", versionId).queryParam("groupFld", groupFld).headers(headers).when().get(api);
	}
	
	public Response getExecutionCount(RequestSpecification basicAuth, Long projectId, String groupFld,String daysPrevious, String periodName) {
		String api = "/rest/zapi/latest/execution/count?projectId="+projectId+"&groupFld="+groupFld+ "&daysPrevious="+daysPrevious+"&periodName="+periodName;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).get(api);
	}
	
	public Response getExecutionCountGroupByUser(RequestSpecification basicAuth,
			Long projectId, Long versionId, String groupFld, String daysPrevious, String periodName) {
		String api = "/rest/zapi/latest/execution/count?projectId="+projectId+"&versionId="+versionId+"&groupFld="+groupFld+ "&daysPrevious="+daysPrevious+"&periodName="+periodName;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).get(api);
	}
	
	public Response getExecutionCountBySprint(RequestSpecification basicAuth, Long projectId, Long versionId, String groupFld) {
		String api = "/rest/zapi/latest/execution/count?projectId="+projectId+"&versionId="+versionId+"&groupFld="+groupFld;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).get(api);
	}

	public Response getExecutionCountAsBurndown(RequestSpecification basicAuth, Long projectId, Long versionId, String cycleId, String groupFld, String graphType) {
		String api = "/rest/zapi/latest/execution/count?projectId="+projectId+"&versionId="+versionId+"&groupFld="+groupFld+"&cycleId="+cycleId+"&graphType="+graphType;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).get(api);
	}
	
	public Response getExecutionCountAsSprintBurndown(
			RequestSpecification basicAuth, Long projectId, Long versionId, String sprintId, String groupFld, String graphType) {
		String api = "/rest/zapi/latest/execution/count?projectId="+10000+"&versionId="+10000+"&groupFld="+groupFld+"&sprintId="+sprintId+"&graphType="+graphType;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).get(api);
	}
	
	public Response getTopDefects(
			RequestSpecification basicAuth, Long projectId, Long versionId, Long issueStatuses) {
		String api = "/rest/zapi/latest/execution/topDefects?projectId="+projectId+"&versionId="+versionId+"&issueStatuses="+issueStatuses;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).get(api);
	}
	
}
