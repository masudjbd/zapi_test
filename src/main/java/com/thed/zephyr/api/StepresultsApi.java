/**
 * Created by manoj.behera on 15-Nov-2016.
 */
package com.thed.zephyr.api;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 15-Nov-2016
 *
 */
public interface StepresultsApi {

	Response getTeststepResults(RequestSpecification basicAuth, Long orderId);

	Response getTeststepResultsByExecutionId(RequestSpecification basicAuth, Long executionsId);

	Response updateTeststepResults(RequestSpecification basicAuth, Long stepResultId, String payLoad);

	Response getStepResultsDefects(RequestSpecification basicAuth, String stepResultId);

	Response getStepDefectsByExecution(RequestSpecification basicAuth, long executionId);

	Response createStepResultWithoutSettingStatus(RequestSpecification basicAuth, String executionId);

}
