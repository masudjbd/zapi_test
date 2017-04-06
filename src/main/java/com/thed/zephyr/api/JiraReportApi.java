/**
 * Created by manoj.behera on 21-Nov-2016.
 */
package com.thed.zephyr.api;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 21-Nov-2016
 *
 */
public interface JiraReportApi {

	Response getDashboardByName(RequestSpecification basicAuth, String query, int maxRecords);

	Response testCount(RequestSpecification basicAuth, String groupFld, Long projectId, Long versionId);

	Response getExecutionCount(RequestSpecification basicAuth, Long projectId,String groupFld, String daysPrevious, String periodName);

	Response getExecutionCountGroupByUser(RequestSpecification basicAuth,Long projectId, Long versionId, String groupFld, String daysPrevious,
			String periodName);

	Response getExecutionCountBySprint(RequestSpecification basicAuth,Long projectId, Long versionId, String groupFld);

	Response getExecutionCountAsBurndown(RequestSpecification basicAuth,Long projectId, Long versionId, String cycleId, String groupFld,
			String graphType);

	Response getExecutionCountAsSprintBurndown(RequestSpecification basicAuth,Long projectId, Long versionId, String sprintId, String groupFld,
			String graphType);

	Response getTopDefects(RequestSpecification basicAuth, Long projectId,Long versionId, Long issueStatuses);


}
