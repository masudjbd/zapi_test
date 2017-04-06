/**
 * Created by manoj.behera on 15-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.StepresultsApi;

/**
 * @author manoj.behera 15-Nov-2016
 *
 */
@Service("stepresultsApi")
public class StepresultsApiImpl implements StepresultsApi {
	@Override
	public Response getTeststepResults(RequestSpecification basicAuth, Long orderId) {
		String api = "/rest/zapi/latest/stepResult/"+orderId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	@Override
	public Response updateTeststepResults(RequestSpecification basicAuth, Long stepResultId, String payLoad) {
		String api = "/rest/zapi/latest/stepResult/" + stepResultId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}

	@Override
	public Response getStepResultsDefects(RequestSpecification basicAuth, String stepResultId) {
		String api = "/rest/zapi/latest/stepResult/" + stepResultId + "/defects";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).queryParam("stepResultId", stepResultId).when().get(api);
	}

	@Override
	public Response getStepDefectsByExecution(RequestSpecification basicAuth, long executionId) {
		String api = "/rest/zapi/latest/stepResult/stepDefects";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).queryParam("executionId", executionId).when().get(api);
	}

	@Override
	public Response createStepResultWithoutSettingStatus(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/stepResult";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}
	@Override
	public Response getTeststepResultsByExecutionId(RequestSpecification basicAuth, Long executionsId) {
		String api = "/rest/zapi/latest/stepResult?executionId="+executionsId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	
}
