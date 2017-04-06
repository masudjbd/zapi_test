package com.thed.zephyr.api.jira.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.jira.ComponentApi;

@Service("componentApi")
public class ComponentApiImpl implements ComponentApi{
	public Response createComponent(RequestSpecification basicAuth, String payLoad){
		 String api = "/rest/api/2/component";
		 Map<String, String> headers = new HashMap<String, String>();
		 headers.put("Content-Type", "application/json");
		 return basicAuth.headers(headers).body(payLoad).when().post(api);
	 }
}
