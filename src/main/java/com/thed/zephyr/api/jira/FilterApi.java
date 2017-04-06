package com.thed.zephyr.api.jira;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public interface FilterApi {
	Response createFilter(RequestSpecification basicAuth, String payLoad);
}
