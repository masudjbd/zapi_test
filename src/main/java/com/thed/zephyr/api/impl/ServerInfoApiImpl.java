/**
 * Created by manoj.behera on 14-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.ServerInfoApi;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@Service("serverInfoApi")
public class ServerInfoApiImpl implements ServerInfoApi {
	@Override
	public Response getSystemInfo(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/systemInfo";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	@Override
	public Response getModuleInfo(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/moduleInfo";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	@Override
	public Response getLicenseInfo(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/license";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	@Override
	public Response getProjects(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/util/project-list";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	
	@Override
	public Response getVersionsByProject(RequestSpecification basicAuth, Long projectId ) {
		String api = "/rest/zapi/latest/util/versionBoard-list?projectId="+projectId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	
	@Override
	public Response getProjectMetadata(RequestSpecification basicAuth, Long projectId ) {
		String api = "/rest/zapi/latest/util/cycleCriteriaInfo?projectId="+projectId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
}
