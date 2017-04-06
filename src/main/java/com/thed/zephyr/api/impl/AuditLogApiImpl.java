/**
 * Created by manoj.behera on 24-Jan-2017.
 */
package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.AuditLogApi;

/**
 * @author manoj.behera 24-Jan-2017
 *
 */
@Service("auditLogApi")
public class AuditLogApiImpl implements AuditLogApi{
	@Override
	public Response getAuditLogs(RequestSpecification basicAuth, String entityType, int offset,int maxRecords) {
		String api = "/rest/zapi/latest/audit?entityType="+entityType+"&offset="+offset+"&maxRecords="+maxRecords;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).queryParam("entityType",entityType).queryParam("offset",offset).queryParam("maxRecords",maxRecords).when().get(api);
	}
	
	public Response getAuditByExecutionId(RequestSpecification basicAuth, int offset,int maxRecords, long executionId) {
		String api = "/rest/zapi/latest/audit?offset="+offset+"&maxRecords="+maxRecords+"&executionId="+executionId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}

	
}
