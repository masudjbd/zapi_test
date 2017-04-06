/**
 * Created by manoj.behera on 14-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.Config;
import com.thed.zephyr.api.AttachmentApi;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@Service("attachmentApi")
public class AttachmentApiImpl implements AttachmentApi {

	@Override
	public Response addAttachment(RequestSpecification basicAuth, String entityId, String entityType, String fileName) {
		String api = "/rest/zapi/latest/attachment";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "multipart/form-data");
		headers.put("X-Atlassian-Token", "nocheck");
		File attachmentFile = new File(Config.getValue("attachmentPath") + fileName);
		return basicAuth.headers(headers).queryParam("entityId", entityId).queryParam("entityType", entityType)
				.multiPart(attachmentFile).when().post(api);
	}

	// Add attachment to execution (jpeg)
	@Override
	public Response addAttachmentToStepResult(RequestSpecification basicAuth, String entityId, String entityType,
			String fileName) {
		String api = "/rest/zapi/latest/attachment";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "multipart/form-data");
		headers.put("X-Atlassian-Token", "nocheck");
		File attachmentFile = new File(Config.getValue("attachmentPath") + fileName);
		return basicAuth.headers(headers).queryParam("entityId", entityId).queryParam("entityType", entityType)
				.multiPart(attachmentFile).when().post(api);
		//return basicAuth.headers(headers).multiPart(attachmentFile).when().post(api);
	}

	// Get attachments by execution id
	@Override
	public Response getAttachment(RequestSpecification basicAuth, String entityId, String entityType) {
		String api = "/rest/zapi/latest/attachment/attachmentsByEntity";

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Atlassian-Token", "nocheck");
		return basicAuth.headers(headers).queryParam("entityId", entityId).queryParam("entityType", entityType).when()
				.get(api);
	}

	@Override
	public Response getAttachmentById(RequestSpecification basicAuth, String attchmentId) {
		String api = "/rest/zapi/latest/attachment/" + attchmentId;

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Atlassian-Token", "nocheck");
		return basicAuth.headers(headers).queryParam("id", attchmentId).when().get(api);
	}

	// Get Steplevel attachment by passing attachment ID if attachment is of
	// different types
	@Override
	public Response getStepLevelAttachmentById(RequestSpecification basicAuth, String attchmentId) {
		String api = "/rest/zapi/latest/attachment/" + attchmentId;

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Atlassian-Token", "nocheck");
		return basicAuth.headers(headers).queryParam("id", attchmentId).when().get(api);
	}

	// Delete attachment to an execution
	@Override
	public Response deleteAttachmentToExecution(RequestSpecification basicAuth, String attchmentId) {
		String api = "/rest/zapi/latest/attachment/" + attchmentId;

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Atlassian-Token", "nocheck");
		return basicAuth.headers(headers).queryParam("id", attchmentId).when().delete(api);
	}

	// Delete attachment to a test step result
	@Override
	public Response deleteAttachmentToStepResult(RequestSpecification basicAuth, String attchmentId) {
		String api = "/rest/zapi/latest/attachment/" + attchmentId;

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Atlassian-Token", "nocheck");
		return basicAuth.headers(headers).queryParam("id", attchmentId).when().delete(api);
	}

}
