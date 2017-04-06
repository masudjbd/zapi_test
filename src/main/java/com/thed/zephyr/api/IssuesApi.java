/**
 * Created by manoj.behera on 14-Nov-2016.
 */
package com.thed.zephyr.api;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
public interface IssuesApi {

	Response getissue(RequestSpecification basicAuth, String query,String currentJQL, String currentIssueKey, long currentProjectId);

	Response getdefaultIssue(RequestSpecification basicAuth);

	
}
