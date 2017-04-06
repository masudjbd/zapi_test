/**
 * Created by manoj.behera on 16-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.JobProgressApi;

/**
 * @author manoj.behera 16-Nov-2016
 *
 */
@Service("jobProgressApi")
public class JobProgressAPiImpl implements JobProgressApi{

	@Override
	public Response jobProgress(RequestSpecification basicAuth, String jobProgressToken) {
		String api = "rest/zapi/latest/execution/jobProgress/"+jobProgressToken;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");		
		return basicAuth.headers(headers).when().get(api);
	}
}
