package com.thed.zephyr.api.jira;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author Created by niravshah on 11/9/16.
 */
public interface IssueApi {
    
	Response createIssue(RequestSpecification basicAuth, String payLoad);

    Response deleteIssue(RequestSpecification basicAuth, String issueKey);
}
