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
public interface TeststepApi {

	Response getTestStepExecutionStatus(RequestSpecification basicAuth);

	Response createTeststep(RequestSpecification basicAuth, Long issueId, String payLoad);

	Response getTeststep(RequestSpecification basicAuth, Long issueId);

	Response getTeststepByID(RequestSpecification basicAuth, Long issueId, Long stepId);

	Response getTeststepForUpdatedSteps(RequestSpecification basicAuth, Long issueId, Long updatedstepId);

	Response deleteTestStep(RequestSpecification basicAuth, Long issueId, Long stepId);

	Response updatetestStep(RequestSpecification basicAuth, Long issueId, Long testStepId, String payLoad);

	Response cloneTeststep(RequestSpecification basicAuth, Long issueId, Long testStepId, String payLoad);

	Response moveTeststep(RequestSpecification basicAuth, Long issueId, Long testStepId, String payLoad);

	Response getTeststepByExecution(RequestSpecification basicAuth, Long executionsId, Long expand);

	
}
