package com.thed.zephyr.api.jira.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.jira.FilterApi;

@Service("jiraFilterApi")
public class FilterApiImpl implements FilterApi{
	public Response createFilter(RequestSpecification basicAuth, String payLoad){
		 String api = "/rest/api/2/filter";
		 Map<String, String> headers = new HashMap<String, String>();
		 headers.put("Content-Type", "application/json");
		 return basicAuth.headers(headers).body(payLoad).when().post(api);
	 }
}
