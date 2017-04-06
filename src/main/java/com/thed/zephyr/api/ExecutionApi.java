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
public interface ExecutionApi {

	
	Response addTestsToCycle(RequestSpecification basicAuth, String payLoad);

	Response getExecutionStatus(RequestSpecification basicAuth);

	Response getExecutionsByCycle(RequestSpecification basicAuth, Long projectId, Long versionId, String cycleId);

	Response getExecutionByExecutionId(RequestSpecification basicAuth, String executionId);

	Response deleteExecution(RequestSpecification basicAuth, String payload);

	Response bulkUpdateStatus(RequestSpecification basicAuth, String payLoad);

	Response bulkUpdateAssignee(RequestSpecification basicAuth, String payLoad);

	Response bulkUpdateDefects(RequestSpecification basicAuth, String payLoad);

	Response getDefectByExecution(RequestSpecification basicAuth, String executionId);

	Response getExecutionByIssue(RequestSpecification basicAuth, String issueId);

	Response getExecutionsSummaryBySprintAndIssueId(RequestSpecification basicAuth, String payLoad);

	Response exportExecution(RequestSpecification basicAuth, String payLoad);

	Response downloadExportedFile(String uri);

	Response bulkDeleteExecutions(RequestSpecification basicAuth, String payLoad);

	Response RefreshTheRemoteLinks(RequestSpecification basicAuth, String issueLinkTypeId);

	Response createExecution(RequestSpecification basicAuth, String payLoad);

	Response executeTest(RequestSpecification basicAuth, String id,	String payLoad);

	Response getExecutionsByCycleId(RequestSpecification basicAuth,	String cycleId);

	Response copyExecutions(RequestSpecification basicAuth, int cycleId, String payLoad);

	Response moveExecutions(RequestSpecification basicAuth, int cycleId1, String payLoad);

		

}
