package com.thed.zephyr.api.jira.impl;

/**
 * @author priyanka.bishi 28-Dec-2016
 *
 */
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.jira.SprintApi;
@Service("sprintApi")
public class SprintApiImpl implements SprintApi{
	public Response createSprint(RequestSpecification basicAuth) {
		String api = "/rest/greenhopper/1.0/sprint/1";
		 Map<String, String> headers = new HashMap<String, String>();
		 headers.put("Content-Type", "application/json");
		 return basicAuth.headers(headers).when().post(api);
	}
	
	public Response linkIssueToSprint(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/greenhopper/1.0/sprint/rank";
		 Map<String, String> headers = new HashMap<String, String>();
		 headers.put("Content-Type", "application/json");
		 return basicAuth.headers(headers).body(payLoad).when().put(api);
	}
}
