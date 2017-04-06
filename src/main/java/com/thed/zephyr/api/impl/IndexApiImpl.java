/**
 * Created by manoj.behera on 24-Jan-2017.
 */
package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.IndexApi;

/**
 * @author manoj.behera 24-Jan-2017
 *
 */
@Service("indexApi")
public class IndexApiImpl implements IndexApi {
	@Override
	public Response indexExecution(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/execution/indexAll";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().post(api);
	}
	@Override
	public Response indexStatus(RequestSpecification basicAuth, Long token) {
		String api = "/rest/zapi/latest/execution/indexStatus/" + token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.queryParam("token", token).headers(headers).when().get(api);
	}
}
