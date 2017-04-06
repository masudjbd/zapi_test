/**
 * Created by manoj.behera on 14-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.ZqlApi;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@Service("zqlApi")
public class ZqlApiImpl implements ZqlApi {
	@Override
	public Response getClauses(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/zql/clauses";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	@Override
	public Response executeSearch(RequestSpecification basicAuth, String zqlQuery) {
		String api = "/rest/zapi/latest/zql/executeSearch?zqlQuery="+zqlQuery;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	@Override
	public Response autoCompleteZQLJson(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/zql/autocompleteZQLJson";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	
	public Response getZqlAutocompleteApi(RequestSpecification basicAuth, String fieldName, String fieldValue) {
		String api = "/rest/zapi/latest/zql/autocomplete?fieldName="+fieldName+"&fieldValue="+fieldValue;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}

}
