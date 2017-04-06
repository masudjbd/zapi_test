/**
 * Created by manoj.behera on 17-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.TraceabilityApi;

/**
 * @author manoj.behera 17-Nov-2016
 *
 */
@Service("traceabilityApi")
public class TraceabilityApiImpl implements TraceabilityApi{
	public Response searchExecutionsByTest(RequestSpecification basicAuth, String testIdOrKey, int maxResult, int offset) {
		String api = "/rest/zapi/latest/traceability/executionsByTest?testIdOrKey="+testIdOrKey+"&maxRecords="+maxResult+"&offset="+offset;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
		
		public Response searchExecutionsByRequirement(RequestSpecification basicAuth,String requirementIdOrKeyList) {
			String api = "/rest/zapi/latest/traceability/testsByRequirement?requirementIdOrKeyList="+requirementIdOrKeyList;
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "application/json");
			return basicAuth.headers(headers).when().get(api);
		}
		
		public Response searchExecutionsByDefect(RequestSpecification basicAuth,String defectIdOrKey) {
			String api = "/rest/zapi/latest/traceability/executionsByDefect?defectIdOrKey="+defectIdOrKey;
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "application/json");
			return basicAuth.headers(headers).when().get(api);
		}
		
		public Response searchDefectStatistics(RequestSpecification basicAuth,String defectIdOrKeyList) {
			String api = "/rest/zapi/latest/traceability/defectStatistics?defectIdOrKeyList="+defectIdOrKeyList;
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "application/json");
			return basicAuth.headers(headers).when().get(api);
		}
		
		public Response exportTraceability(RequestSpecification basicAuth,String payload) {
			String api = "/rest/zapi/latest/traceability/export";
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "application/json");
			return basicAuth.headers(headers).body(payload).when().post(api);
		}
}
