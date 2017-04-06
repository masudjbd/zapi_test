package com.thed.zephyr.service.jira.impl;

import com.thed.zephyr.service.jira.JiraApiService;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.jira.ComponentApi;
import com.thed.zephyr.api.jira.FilterApi;
import com.thed.zephyr.api.jira.IssueApi;
import com.thed.zephyr.api.jira.IssuelinkApi;
import com.thed.zephyr.api.jira.PriorityApi;
import com.thed.zephyr.api.jira.ProjectApi;
import com.thed.zephyr.api.jira.SprintApi;
import com.thed.zephyr.api.jira.UserApi;
import com.thed.zephyr.api.jira.VersionApi;
import com.thed.zephyr.util.RestUtils;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@Service("jiraService")
public class JiraApiServiceImpl implements JiraApiService {

	@Autowired
	private IssueApi issueApi;
	
	@Autowired
	private ProjectApi projectApi;
	
	@Autowired
	private VersionApi versionApi;
	
	@Autowired
	private ComponentApi componentApi;
	
	@Autowired
	private PriorityApi priorityApi;
	
	@Autowired
	private UserApi userApi;
	
	@Autowired
	private FilterApi jiraFilterApi;
	
	@Autowired
	private SprintApi sprintApi;
	
	@Autowired
	private IssuelinkApi issuelinkApi;

	/* (non-Javadoc)
	 * @see com.thed.zephyr.service.jira.JiraApiService#createIssue(com.jayway.restassured.specification.RequestSpecification, java.lang.String)
	 * @author Created by manoj.behera on 14-Nov-2016.
	 */
	@Override
	public Response createIssue(RequestSpecification basicAuth, String payLoad) {
		return issueApi.createIssue(basicAuth, payLoad);
	}
	@Override
	public List<String> createIssues(RequestSpecification basicAuth, String payLoad, int numberOfIssues) {
		JSONArray issueObjects = new JSONArray();
		List<String> list = new ArrayList<>();
		String payLoadCopy = payLoad;
		System.out.println("Started creation of "+numberOfIssues+" issues.");
		Object jsonObj = new JSONObject(payLoadCopy).get("fields");
		for(int i=1;i<=numberOfIssues; i++){
			
			JSONObject json = new JSONObject(jsonObj.toString());
			String issueSummary = json.get("summary").toString()+" "+i;
			
			json.remove("summary");
			json.put("summary", issueSummary);
			payLoad = json.toString();
			payLoad = new JSONObject().put("fields", json).toString();
			System.out.println(payLoad);
			Response response = issueApi.createIssue(basicAuth, payLoad);
			System.out.println(response.getBody().asString());
			Assert.assertTrue(validateCreateIssueApi( response), "Validated response successfully.");
			issueObjects.put(response.getBody().asString());
			list.add(response.getBody().asString());
			
			System.out.println("Issue created successfully : "+i);
		}
		return list;
	}
	
	@Override
	public boolean validateCreateIssueApi(Response response) {
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		RestUtils.ValidateStatusIs201(response);
		Assert.assertNotNull(JSONResponseBody.get("id"), "Created issue id is null.");
		Assert.assertNotNull(JSONResponseBody.get("key"), "Created issue key is null.");
		return true;
	}
	
	@Override
	public Response deleteIssue(RequestSpecification basicAuth, String issueKey) {
		return issueApi.deleteIssue(basicAuth, issueKey);
	}
	
	@Override
	public Response getProjects(RequestSpecification basicAuth) {
		return projectApi.getProjects(basicAuth);
	}
	
	@Override
	public Response getPriorities(RequestSpecification basicAuth) {
		return priorityApi.getPriorities(basicAuth);
	}
	
	@Override
	public Response getProjectMetadata(RequestSpecification basicAuth, Long projectId) {
		return projectApi.getProjectMetadata(basicAuth, projectId);
	}
	
	@Override
	public Response createProject(RequestSpecification basicAuth, String payLoad) {
		return projectApi.createProject(basicAuth, payLoad);
	}
	
	public boolean validateCreateProject(Response response) {
		RestUtils.ValidateStatusIs201(response);
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		Assert.assertNotNull(JSONResponseBody.get("id"), "Created project id is null.");
		Assert.assertNotNull(JSONResponseBody.get("key"), "Created project key is null.");
		return true;
	}
	
	@Override
	public Response createVersion(RequestSpecification basicAuth, String payLoad) {
		return versionApi.createVersion(basicAuth, payLoad);
	}
	
	@Override
	public boolean validateCreateVersion(Response response) {
		RestUtils.ValidateStatusIs201(response);
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		Assert.assertNotNull(JSONResponseBody.get("id"), "Created version id is null.");
		Assert.assertNotNull(JSONResponseBody.get("name"), "Created version name is null.");
		return true;
	}
	
	@Override
	public Response createComponent(RequestSpecification basicAuth, String payLoad) {
		return componentApi.createComponent(basicAuth, payLoad);
	}
	
	@Override
	public boolean validateCreateComponent(Response response) {
		RestUtils.ValidateStatusIs201(response);
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		Assert.assertNotNull(JSONResponseBody.get("id"), "Created component id is null.");
		Assert.assertNotNull(JSONResponseBody.get("name"), "Created component name is null.");
		return true;
		}
	
	@Override
	public Response createUser(RequestSpecification basicAuth, String payLoad) {
		return userApi.createUser(basicAuth, payLoad);
	}
	
	@Override
	public boolean validateCreateUser(Response response) {
		RestUtils.ValidateStatusIs201(response);
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		Assert.assertNotNull(JSONResponseBody.get("key"), "Created user key is null.");
		return true;
	}
	
	@Override
	public Response createFilter(RequestSpecification basicAuth, String payLoad) {
		return jiraFilterApi.createFilter(basicAuth, payLoad);
	}
	
	@Override
	public boolean validateCreateFilter(Response response) {
		RestUtils.ValidateStatusIs200(response);
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		Assert.assertNotNull(JSONResponseBody.get("id"), "Created filter id is null.");
		Assert.assertNotNull(JSONResponseBody.get("name"), "Created filter name is null.");
		return true;
	}
	
	@Override
	public Response createSprint(RequestSpecification basicAuth) {
		return sprintApi.createSprint(basicAuth);
	}
	
	@Override
	public Response linkIssueToSprint(RequestSpecification basicAuth, String payload) {
		return sprintApi.linkIssueToSprint(basicAuth, payload);
	}
	
	@Override
	public boolean validateCreateSprint(Response response) {
		RestUtils.ValidateStatusIs200(response);
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		Assert.assertNotNull(new JSONObject(response.body().asString()).get("id").toString());
		return true;
	}
	@Override
	public Response createIssueLink(RequestSpecification basicAuth,String payload) {
		return issuelinkApi.createIssueLink(basicAuth, payload);
	}
}
