package com.thed.zephyr.service;

import java.util.Map;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
public interface ZAPIApiService {
	
	Response createCycle(RequestSpecification basicAuth, String payLoad);

	Response updateCycle(RequestSpecification basicAuth, String payLoad);

	Response deleteCycle(RequestSpecification basicAuth, String cycleId);

	Response getCycles(RequestSpecification basicAuth, Long projectId);

	Response getCycle(RequestSpecification basicAuth, String cycleId);

	Response cyclesByVersionAndSprint(RequestSpecification basicAuth, String payLoad);

	Response cleanupSprint(RequestSpecification basicAuth);
	
	Response addTestsToCycle(RequestSpecification basicAuth, String payLoad);

	Response getExecutionStatus(RequestSpecification basicAuth);

	Response getExecutionByExecutionId(RequestSpecification basicAuth, String executionId);

	Response deleteExecution(RequestSpecification basicAuth, String executionId);
	
	Response getDashboardByName(RequestSpecification basicAuth, String query, int maxRecords);
	
	Response getSystemInfo(RequestSpecification basicAuth);
	
	Response getModuleInfo(RequestSpecification basicAuth);
	
	Response getLicenseInfo(RequestSpecification basicAuth);
	
	Response getProjects(RequestSpecification basicAuth);
	
	Response getVersionsByProject(RequestSpecification basicAuth, Long projectId);
	
	Response getProjectMetadata(RequestSpecification basicAuth, Long projectId);
	
	Response getTestStepExecutionStatus(RequestSpecification basicAuth);
	
	Response getClauses(RequestSpecification basicAuth);

	Response executeSearch(RequestSpecification basicAuth, String zqlQuery);

	Response autoCompleteZQLJson(RequestSpecification basicAuth);
	
	Response loggedinUser(RequestSpecification basicAuth);

	Response createExecutionfilter(RequestSpecification basicAuth, String payLoad);
	
	Response updateExecutionfilter(RequestSpecification basicAuth, String payLoad);

	Response renameExecutionfilter(RequestSpecification basicAuth, String payLoad);

	Response copyExecutionfilter(RequestSpecification basicAuth, String payLoad);

	Response getfilterById(RequestSpecification basicAuth, String filterId);

	Response searchExecutionfilter(RequestSpecification basicAuth, String payload);

	Response toggleFavouriteFilter(RequestSpecification basicAuth, String payLoad);

	Response deleteFilter(RequestSpecification basicAuth, String filterId);
	
	Response getissue(RequestSpecification basicAuth, String query, String currentJQL, String currentIssueKey, long currentProjectId);

	Response getdefaultIssue(RequestSpecification basicAuth);
	
	Response addAttachment(RequestSpecification basicAuth, String entityId, String entityType, String fileName);

	Response addAttachmentToStepResult(RequestSpecification basicAuth, String entityId, String entityType,String fileName);

	Response getAttachment(RequestSpecification basicAuth, String entityId, String entityType);

//	Response getAttachmentByStepResultID(RequestSpecification basicAuth, String entityId, String entityType);
	
	Response getAttachmentById(RequestSpecification basicAuth, String attchmentId);

	Response getStepLevelAttachmentById(RequestSpecification basicAuth, String attchmentId);

	Response deleteAttachmentToStepResult(RequestSpecification basicAuth, String attchmentId);

	Response deleteAttachmentToExecution(RequestSpecification basicAuth, String attchmentId);
	
	Response bulkUpdateStatus(RequestSpecification basicAuth, String payLoad);

	Response bulkUpdateAssignee(RequestSpecification basicAuth, String payLoad);

	Response bulkUpdateDefects(RequestSpecification basicAuth, String DefectID);

	Response getDefectByExecution(RequestSpecification basicAuth, String executionId);

	Response getExecutionByIssue(RequestSpecification basicAuth, String issueId);

	Response getExecutionsSummaryBySprintAndIssueId(RequestSpecification basicAuth, String payLoad);

	Response exportExecution(RequestSpecification basicAuth, String payLoad);

	Response downloadExportedFile(String uri);

	Response bulkDeleteExecutions(RequestSpecification basicAuth, String payLoad);
	
	Response RefreshTheRemoteLinks(RequestSpecification basicAuth, String issueLinkTypeId);
	
	Response getTestByFilterId(RequestSpecification basicAuth, Long filterId);
	
	Response indexExecution(RequestSpecification basicAuth);

	Response indexStatus(RequestSpecification basicAuth, Long token);
	
	Response getTeststepResults(RequestSpecification basicAuth, Long executionsId);

	Response updateTeststepResults(RequestSpecification basicAuth, Long stepResultId, String payLoad);

	Response getStepResultsDefects(RequestSpecification basicAuth, String stepResultId);

	Response getStepDefectsByExecution(RequestSpecification basicAuth, long executionId);

	Response createStepResultWithoutSettingStatus(RequestSpecification basicAuth, String payLoad);
	
	Response createTeststep(RequestSpecification basicAuth, Long issueId, String payLoad);

	Response getTeststep(RequestSpecification basicAuth, Long issueId);

	Response getTeststepByID(RequestSpecification basicAuth, Long issueId, Long stepId);

	Response getTeststepForUpdatedSteps(RequestSpecification basicAuth, Long issueId, Long updatedstepId);

	Response deleteTestStep(RequestSpecification basicAuth, Long issueId, Long stepId);

	Response updateTeststep(RequestSpecification basicAuth, Long issueId, Long testStepId, String payLoad);

	Response cloneTeststep(RequestSpecification basicAuth, Long issueId, Long testStepId, String payLoad);

	Response moveTeststep(RequestSpecification basicAuth, Long issueId, Long testStepId, String payLoad);

	Response getTeststepByExecution(RequestSpecification basicAuth, Long executionsId, Long expand);
	
	Response testCount(RequestSpecification basicAuth, String groupFld, Long projectId, Long versionId);
	
	Response getAuditLogs(RequestSpecification basicAuth, String entityType, int offset, int maxRecords);
	
	Response getTeststepResultsByExecutionId(RequestSpecification basicAuth,Long executionId);

	boolean validateCreateCycleApi(Response response);

	boolean validateUpdateCycleApi(Response response);

	boolean validateDeletedCycle(Response response);

	boolean validateSystemInfo(Response response);

	boolean validateModuleInfo(Response response);

	boolean validateLicenseInfo(Response response);

	boolean validateProjects(Response response, Map<String, Map<String, String>> map);

	boolean validateVersions(Response response, Map<String, Map<String, String>> map);

	boolean validateProjectMetadata(Response response);

	boolean validateTestExecutionStatuses(Response response);

	boolean validategetTestStepExecutionStatus(Response response);

	boolean validategetDashboardByName(Response response);

	boolean validategetIssues(Response response);

	boolean validatedeleteExecution(Response response);

	boolean validateGetExecutionById(Response response);

	boolean validateGetExecutions(Response response);

	boolean validateAddTestsToCycle(Response response1);

	boolean validategetindexStatus(Response response);

	boolean validateIndexExecution(Response response);

	boolean validateCloneCycle(Response response);

	boolean validateCleanupCycle(Response response);

	boolean validateBulkUpdateAssignee(Response response);

	boolean validateloggedInUser(Response response);

	boolean validateCreateExecutionfilter(Response response);

	boolean validateCloneTeststep(Response response);

	boolean validateUpdatetestStep(String reqPayload, Response response);

	boolean validateMovetestStep(String reqPayload, Response response);

	boolean validateCreatetestStepWithWIKI(String reqPayload, Response response);

	boolean validateCreatedtestStep(Response response1);

	boolean validateGetTestStepByIssueID(Response response2);

	boolean validateGetTeststepByID(Response response2);

	boolean validateDeleteTeststep(Response response);

	boolean validateGetStepResult(Response response);

	boolean validateexecutionUpdateWithBulkDefect(Response response);

	boolean validateGetDefectsByExecution(Response response);

	boolean validateGetExecutionByIssueKey(Response response);

	boolean validategetExecutionsSummaryBySprintAndIssueID(Response response);

	boolean validateDeleteExecution(Response response);

	boolean validateCloneTeststepWithWiki(Response response2);

	boolean validateGetCycles(Response response);

	boolean validateGetCycle(Response response);

	boolean validateGetCyclesbyVersionAndSprint(Response response);

	boolean validateExportExecutios(Response response);

	boolean validateStepresult(Response response);

	boolean validateAddAttachment(Response response);

	boolean validateGetAttachment(Response response);

	boolean validateDeleteAttachment(Response response);

	boolean validateBulkStatusUdate(Response response3);
	
	boolean validateGetStepResultById(Response response);

	boolean validateUpdateStepResult(Response response);

	boolean validateStepResultDefects(Response response);

	boolean validateStepDefectsByExecutionID(Response response);

	boolean validateUpdateExecutionFilter(Response response);

	boolean validateRenamedFilter(Response response);

	boolean validateCopyExecutionFilter(Response response);

	boolean validateGetExecutionFilter(Response response, String executionfilterId);

	boolean validatesearchExecutionFilter(Response response);

	boolean validateToggleFavFilter(Response response);

	boolean validateDeleteExecutionFilter(Response response);

	Response getFavFilter(RequestSpecification basicAuth, String fav);

	boolean validateGetFavFilter(Response response);

	boolean validateGetTestByFilterId(Response response);

	boolean validateGetTestCountGroupByUser(Response response);

	Response createExecution(RequestSpecification basicAuth, String payload);

	boolean validateCreateExecution(Response response);

	Response executeTest(RequestSpecification basicAuth, String id, String payload);

	boolean validateExecuteTest(Response response, String executionId1);

	boolean validateExecuteSearch(Response response);

	Response getExecutionsByCycle(RequestSpecification basicAuth,Long projectId, Long versionId, String cycleId);

	Response exportCycle(RequestSpecification basicAuth, String cycleId,Long versionId, Long projectId);

	boolean validateExportCycle(Response response);

	Response searchFilter(RequestSpecification basicAuth, String query);

	boolean validateSearchFilter(Response response);

	boolean validategetAutocompleteJson(Response response);

	boolean validategetZql(Response response);
	
	Response getZQLAutocomplete(RequestSpecification basicAuth,String fieldName, String fieldValue);

	boolean validategetZQLAutocomplete(String fieldValue, Response response);

	Response createColumnSelection(RequestSpecification basicAuth,String payload);

	Response getColumnSelection(RequestSpecification basicAuth,	long executionFilterId);

	Response updateColumnSelection(RequestSpecification basicAuth, long id,	String payload);

	Response getExecutionCount(RequestSpecification basicAuth, Long projectId,String groupFld, String daysPrevious, String periodName);

	Response getExecutionCountGroupByUser(RequestSpecification basicAuth,Long projectId, Long versionId, String groupFld, String daysPrevious, String periodName);

	Response getExecutionCountBySprint(RequestSpecification basicAuth,Long projectId, Long versionId, String groupFld);

	Response getExecutionCountAsBurndown(RequestSpecification basicAuth,Long projectId, Long versionId, String cycleId, String groupFld,
			String graphType);

	Response getExecutionCountAsSprintBurndown(RequestSpecification basicAuth,Long projectId, Long versionId, String sprintId, String groupFld,
			String graphType);

	Response getTopDefects(RequestSpecification basicAuth, Long projectId,Long versionId, Long issueStatuses);

	Response searchExecutionsByTest(RequestSpecification basicAuth,String testIdOrKey, int maxResult, int offset);

	Response searchExecutionsByRequirement(RequestSpecification basicAuth,String requirementIdOrKeyList);

	Response searchExecutionsByDefect(RequestSpecification basicAuth,String defectIdOrKey);

	Response searchDefectStatistics(RequestSpecification basicAuth,String defectIdOrKeyList);

	Response exportTraceability(RequestSpecification basicAuth,String payload);

	boolean validateExportTraceability(Response response);

	boolean validaterefreshReomteLinks(Response response);

	boolean validateAuditLogs(Response response);

	Response getAuditByExecutionId(RequestSpecification basicAuth, int offset,int maxRecords, long executionId);

	boolean validateGetAuditByExecutionId(Response response);

	boolean validateSearchExecutionsByTest(Response response);

	boolean validateGetExecutionCount(Response response);

	boolean validateGetExecutionCountGroupByUser(Response response);

	boolean validateGetExecutionCountBySprint(Response response);

	boolean validateGetExecutionCountAsBurndown(Response response);

	boolean validateGetExecutionCountAsSprintBurndown(Response response);

	boolean validateGetTopDefects(Response response);

	boolean validateSearchExecutionsByRequirement(Response response);

	boolean validateSearchExecutionsByDefect(Response response);

	boolean validateSearchDefectStatistics(Response response);

	Response quickSearchZQLFilter(RequestSpecification basicAuth,String fieldName);

	boolean validatequickSearchZQLFilter(Response response);

	Response getTestCreated(RequestSpecification basicAuth, String projectKey, int daysPrevious, String periodName);

	boolean validateGetTestCreated(Response response);

	Response getIssueStatuses(RequestSpecification basicAuth, long projectId);

	boolean validateGetIssueStatuses(Response response);	

	Response copyExecutions(RequestSpecification basicAuth, int cycleId, String payLoad);

	Response moveExecutions(RequestSpecification basicAuth, int cycleId1, String payload);

	boolean validatecreateColumnSelection(Response response1);

	boolean validategetColumnSelection(Response response);

	boolean validateupdateColumnSelection(Response response1);

	Response getExecutionDetailsInZql(RequestSpecification basicAuth, long id, String zql);

	boolean validategetExecutionDetailsInZql(Response response4);

	Response jobprogress(RequestSpecification basicAuth, String jobProgressToken);

	boolean validateCopyExecutions(Response response6);

	boolean validateMoveExecutions(Response response6);

			
}			
