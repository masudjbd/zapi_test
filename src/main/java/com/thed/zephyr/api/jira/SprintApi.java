package com.thed.zephyr.api.jira;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author priyanka.bishi 28-Dec-2016
 */
public interface SprintApi {
	public Response createSprint(RequestSpecification basicAuth);

	public Response linkIssueToSprint(RequestSpecification basicAuth, String payload);
}
