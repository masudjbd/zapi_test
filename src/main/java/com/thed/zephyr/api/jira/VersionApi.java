/**
 * Created by manoj.behera on 03-Dec-2016.
 */
package com.thed.zephyr.api.jira;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 03-Dec-2016
 *
 */
public interface VersionApi {

	Response getVersionsByProject(RequestSpecification basicAuth, Long projectId);
	
	Response createVersion(RequestSpecification basicAuth, String payLoad);

}
