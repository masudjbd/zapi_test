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
public interface AttachmentApi {

	Response addAttachment(RequestSpecification basicAuth, String entityId, String entityType, String fileName);

	Response addAttachmentToStepResult(RequestSpecification basicAuth, String entityId, String entityType,
			String fileName);

	Response getAttachment(RequestSpecification basicAuth, String entityId, String entityType);

	Response getAttachmentById(RequestSpecification basicAuth, String attchmentId);

	Response getStepLevelAttachmentById(RequestSpecification basicAuth, String attchmentId);
	
	Response deleteAttachmentToStepResult(RequestSpecification basicAuth, String attchmentId);

	Response deleteAttachmentToExecution(RequestSpecification basicAuth, String attchmentId);
}
