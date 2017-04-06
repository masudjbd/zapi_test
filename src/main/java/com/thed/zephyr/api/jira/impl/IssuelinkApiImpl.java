package com.thed.zephyr.api.jira.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.jira.IssuelinkApi;
/**
 * @author priyanka.bishi 02/08/17
 *
 */

	@Service("issuelinkApi")
	public class IssuelinkApiImpl implements IssuelinkApi {
		@Override
		public Response createIssueLink(RequestSpecification basicAuth, String payLoad){
			 String api = "/rest/api/2/issueLink";
			 Map<String, String> headers = new HashMap<String, String>();
			 headers.put("Content-Type", "application/json");
			 return basicAuth.headers(headers).body(payLoad).when().post(api);
		 }

}