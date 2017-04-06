package com.thed.zephyr.api.jira;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author Created by priyanka.bishi on 02/08/17.
 */

public interface IssuelinkApi {

	Response createIssueLink(RequestSpecification basicAuth, String payLoad);

}
