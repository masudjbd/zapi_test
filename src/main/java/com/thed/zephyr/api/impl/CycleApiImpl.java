package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.CycleApi;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@Service("cycleApi")
public class CycleApiImpl implements CycleApi {
	@Override
	public Response createCycle(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/cycle";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}
	@Override
	public Response updateCycle(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/cycle";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}
	@Override
	public Response deleteCycle(RequestSpecification basicAuth, String cycleId) {
		String api = "/rest/zapi/latest/cycle/" + cycleId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).delete(api);
	}
	@Override
	public Response getCycles(RequestSpecification basicAuth, Long projectId) {
		String api = "/rest/zapi/latest/cycle?projectId="+projectId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);

	}
	@Override
	public Response getCycle(RequestSpecification basicAuth, String cycleId) {
		String api = "/rest/zapi/latest/cycle/" + cycleId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);

	}
	@Override
	public Response cyclesByVersionAndSprint(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/cycle/cyclesByVersionsAndSprint";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}
	@Override
	public Response cleanupSprint(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/cycle/cleanupSprints";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().post(api);
	}
	
	@Override
	public Response exportCycle(RequestSpecification basicAuth, String cycleId, Long versionId, Long projectId) {
		String api = "/rest/zapi/latest/cycle/"+cycleId+"/export?versionId="+versionId+"&projectId="+projectId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.when().get(api);
	}

}
