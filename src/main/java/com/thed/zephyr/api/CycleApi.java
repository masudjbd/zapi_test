package com.thed.zephyr.api;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
public interface CycleApi {

	Response createCycle(RequestSpecification basicAuth, String payLoad);

	Response updateCycle(RequestSpecification basicAuth, String payLoad);

	Response deleteCycle(RequestSpecification basicAuth, String cycleId);

	Response getCycles(RequestSpecification basicAuth, Long projectId);

	Response getCycle(RequestSpecification basicAuth, String cycleId);

	Response cyclesByVersionAndSprint(RequestSpecification basicAuth, String payLoad);

	Response cleanupSprint(RequestSpecification basicAuth);

	Response exportCycle(RequestSpecification basicAuth, String cycleId, Long versionId, Long projectId);

		
}
