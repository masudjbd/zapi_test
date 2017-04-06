/**
 * Created by manoj.behera on 21-Nov-2016.
 */
package com.thed.zephyr.api;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 21-Nov-2016
 *
 */
public interface ChartApi {

	Response getTestCreated(RequestSpecification basicAuth, String projectKey,int daysPrevious, String periodName);

	Response getIssueStatuses(RequestSpecification basicAuth, long projectId);


	
}
