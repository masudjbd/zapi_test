/**
 * Created by manoj.behera on 17-Nov-2016.
 */
package com.thed.zephyr.api;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 17-Nov-2016
 *
 */
public interface TraceabilityApi {

	Response searchExecutionsByTest(RequestSpecification basicAuth,String testIdOrKey, int maxResult, int offset);

	Response searchExecutionsByRequirement(RequestSpecification basicAuth,String requirementIdOrKeyList);

	Response searchExecutionsByDefect(RequestSpecification basicAuth,String defectIdOrKey);

	Response searchDefectStatistics(RequestSpecification basicAuth,String defectIdOrKeyList);

	Response exportTraceability(RequestSpecification basicAuth, String payload);


}
