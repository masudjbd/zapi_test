/**
 * Created by manoj.behera on 03-Dec-2016.
 */
package com.thed.zephyr.api.jira.impl;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.jira.PriorityApi;

/**
 * @author manoj.behera 03-Dec-2016
 *
 */
@Service("priorityApi")
public class PriorityApiImpl implements PriorityApi {
	@Override
	public Response getPriorities(RequestSpecification basicAuth){
		 String api = "/rest/api/2/priority";
		 return basicAuth.when().get(api);
	 }
}
