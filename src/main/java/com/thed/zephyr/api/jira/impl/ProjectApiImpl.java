/**
 * Created by manoj.behera on 03-Dec-2016.
 */
package com.thed.zephyr.api.jira.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.testng.Assert;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.util.RestUtils;
import com.thed.zephyr.api.jira.ProjectApi;

/**
 * @author manoj.behera 03-Dec-2016
 *
 */
@Service("projectApi")
public class ProjectApiImpl implements ProjectApi {
	@Override
	public Response getProjects(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/util/project-list";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}

	@Override
	public Response getProjectMetadata(RequestSpecification basicAuth, Long projectId) {
		String api = "/rest/zapi/latest/util/cycleCriteriaInfo?projectId=" + projectId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}

	@Override
	public Response createProject(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/api/2/project";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}

	public boolean validateCreateProjectApi(Response response) {
		RestUtils.ValidateStatusIs201(response);
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		Assert.assertNotNull(JSONResponseBody.get("id"), "Created project id is null.");
		Assert.assertNotNull(JSONResponseBody.get("key"), "Created project key is null.");
		return true;
	}
}
