/**
 * Created by manoj.behera on 14-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

import com.thed.zephyr.api.ExecutionApi;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@Service("filterApi")
public class ExecutionApiImpl implements ExecutionApi {
	
	@Override
	public Response createExecution(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/execution";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}
	
	@Override
	public Response addTestsToCycle(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/execution/addTestsToCycle/";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}

	@Override
	public Response getExecutionsByCycle(RequestSpecification basicAuth, Long projectId, Long versionId, String cycleId) {
		String api = "rest/zapi/latest/execution?projectId="+projectId+"&versionId="+versionId+"&cycleId="+Integer.parseInt(cycleId)+"&offset=0&limit=10";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");		
		return basicAuth.headers(headers).get(api);
	}

	@Override
	public Response getExecutionByExecutionId(RequestSpecification basicAuth, String executionId) {
		String api = "/rest/zapi/latest/execution/" + executionId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).get(api);
	}
	
	@Override
	public Response getExecutionsByCycleId(RequestSpecification basicAuth, String cycleId) {
		String api = "/rest/zapi/latest/execution?cycleId="+cycleId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).get(api);
	}
	
	@Override
	public Response executeTest(RequestSpecification basicAuth, String id, String payLoad) {
		String api = "/rest/zapi/latest/execution/"+id+"/execute";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}

	@Override
	public Response deleteExecution(RequestSpecification basicAuth, String executionId) {
		String api = "/rest/zapi/latest/execution/"+executionId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).delete(api);
	}

	@Override
	public Response getExecutionStatus(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/util/testExecutionStatus";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}

	@Override
	public Response bulkUpdateStatus(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/execution/updateBulkStatus";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}

	@Override
	public Response bulkUpdateAssignee(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/execution/bulkAssign";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}

	@Override
	public Response bulkUpdateDefects(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/execution/updateWithBulkDefects";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}

	@Override
	public Response getDefectByExecution(RequestSpecification basicAuth, String executionId) {
		String api = "/rest/zapi/latest/execution/"+executionId+"/defects";		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");		
		return basicAuth.headers(headers).when().get(api);
	}

	@Override
	public Response getExecutionByIssue(RequestSpecification basicAuth, String issueId) {
		String api = "/rest/zapi/latest/execution/executionsByIssue?issueIdOrKey="+issueId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.queryParam("issueIdOrKey", issueId).headers(headers).when().get(api);
	}

	@Override
	public Response getExecutionsSummaryBySprintAndIssueId(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/execution/executionSummariesBySprintAndIssue";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");		
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}

	//
	@Override
	public Response exportExecution(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/execution/export";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}

	@Override
	public Response downloadExportedFile(String uri) {
		String api = "/rest/zapi/latest/execution/export/exportAttachment";
		// Map<String, String> headers = new HashMap<String, String>();
		// headers.put("Content-Type", "application/json");
		System.out.println(uri);
		return given().get(uri);
		// return basicAuth.headers(headers).queryParam("fileName",
		// fileName).when().post(api);
	}

	@Override
	public Response bulkDeleteExecutions(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/execution/deleteExecutions";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().delete(api);
	}
	@Override
	public Response RefreshTheRemoteLinks(RequestSpecification basicAuth, String issueLinkTypeId) {
		String api = "/rest/zapi/latest/execution/refreshRemoteLinks";		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).queryParam("issueLinkTypeId",issueLinkTypeId).when().post(api);
	}
	
	@Override
	public Response copyExecutions(RequestSpecification basicAuth, int cycleId1, String payLoad) {
		String api = "/rest/zapi/latest/cycle/"+cycleId1+"/copy";		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}

	@Override
	public Response moveExecutions(RequestSpecification basicAuth, int cycleId1, String payLoad) {
		String api = "/rest/zapi/latest/cycle/"+cycleId1+"/move";		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}
}
