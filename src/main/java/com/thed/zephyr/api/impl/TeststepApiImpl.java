/**
 * Created by manoj.behera on 14-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.TeststepApi;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@Service("teststepApi")
public class TeststepApiImpl implements TeststepApi {
	@Override
	public Response getTestStepExecutionStatus(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/util/teststepExecutionStatus";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	@Override
	public Response createTeststep(RequestSpecification basicAuth, Long issueId, String payLoad) {
		String api = "/rest/zapi/latest/teststep/" + issueId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}

	@Override
	public Response getTeststep(RequestSpecification basicAuth, Long issueId1) {
		String api = "/rest/zapi/latest/teststep/" + issueId1;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}

	@Override
	public Response getTeststepByID(RequestSpecification basicAuth, Long issueId1, Long stepId) {
		String api = "/rest/zapi/latest/teststep/" + issueId1 + "/" + stepId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	@Override
	public Response getTeststepForUpdatedSteps(RequestSpecification basicAuth, Long issueId,
			Long updatedstepId) {
		String api = "/rest/zapi/latest/teststep/" + issueId + "/" + updatedstepId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	@Override
	public Response updatetestStep(RequestSpecification basicAuth, Long issueId2, Long testStepId,
			String payLoad) {
		String api = "/rest/zapi/latest/teststep/"+ issueId2+ "/"+testStepId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
		
	}

	@Override
	public Response deleteTestStep(RequestSpecification basicAuth, Long issueId, Long stepId) {
		String api = "/rest/zapi/latest/teststep/" + issueId + "/" + stepId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).delete(api);
	}
	@Override
	public Response cloneTeststep(RequestSpecification basicAuth, Long issueId2, Long testStepId,
			String payLoad1) {
		String api = "/rest/zapi/latest/teststep/"+issueId2+"/clone/"+testStepId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad1).when().post(api);
	}
	@Override
	public Response moveTeststep(RequestSpecification basicAuth, Long issueId, Long testStepId, String payLoad) {
		String api = "/rest/zapi/latest/teststep/" + issueId + "/" + testStepId + "/move";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}
	@Override
	public Response getTeststepByExecution(RequestSpecification basicAuth, Long executionsId, Long expand) {
		String api = "/rest/zapi/latest/stepResult";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		System.out.println(api);
		return basicAuth.queryParam("executionId", executionsId).queryParam("expand", expand).headers(headers).when()
				.get(api);
	}
}
