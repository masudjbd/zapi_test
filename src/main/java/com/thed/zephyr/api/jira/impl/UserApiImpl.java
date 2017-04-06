/**
 * Created by manoj.behera on 03-Dec-2016.
 */
package com.thed.zephyr.api.jira.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.jira.ProjectApi;
import com.thed.zephyr.api.jira.UserApi;

/**
 * @author manoj.behera 03-Dec-2016
 *
 */
@Service("userApi")
public class UserApiImpl implements UserApi {
	public Response createUser(RequestSpecification basicAuth, String payLoad){
		 String api = "/rest/api/2/user";
		 Map<String, String> headers = new HashMap<String, String>();
		 headers.put("Content-Type", "application/json");
		 return basicAuth.headers(headers).body(payLoad).when().post(api);
	 }
}
