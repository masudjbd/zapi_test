package com.thed.zephyr.service.jira;

import java.util.List;

import org.json.JSONArray;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
public interface JiraApiService {
	/**
	 * @param basicAuth
	 * @return
	 * @author Created by manoj.behera on 23-Jan-2017.
	 */
	Response getProjects(RequestSpecification basicAuth);

	
	Response getProjectMetadata(RequestSpecification basicAuth, Long projectId);
	

    Response deleteIssue(RequestSpecification basicAuth, String issueKey);
    
	Response getPriorities(RequestSpecification basicAuth);
	
	boolean validateCreateIssueApi(Response response);
	List<String> createIssues(RequestSpecification basicAuth, String payLoad, int numberOfIssues);

	Response createProject(RequestSpecification basicAuth, String string);
	
	boolean validateCreateProject(Response response);

	Response createVersion(RequestSpecification basicAuth, String string);

	boolean validateCreateVersion(Response response);

	Response createComponent(RequestSpecification basicAuth, String string);


	boolean validateCreateComponent(Response response);


	Response createUser(RequestSpecification basicAuth, String string);


	boolean validateCreateUser(Response response);


	Response createFilter(RequestSpecification basicAuth, String string);


	boolean validateCreateFilter(Response response);


	Response createSprint(RequestSpecification basicAuth);


	boolean validateCreateSprint(Response response);


	Response createIssueLink(RequestSpecification basicAuth, String payload);


	Response linkIssueToSprint(RequestSpecification basicAuth, String payload);


	/**
	 * @param basicAuth
	 * @param payLoad
	 * @return
	 * @author Created by manoj.behera on 02-Mar-2017.
	 */
	Response createIssue(RequestSpecification basicAuth, String payLoad);

	
}
