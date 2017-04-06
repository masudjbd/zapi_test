package com.thed.zephyr.service.impl;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.api.AttachmentApi;
import com.thed.zephyr.api.AuditLogApi;
import com.thed.zephyr.api.ChartApi;
import com.thed.zephyr.api.CycleApi;
import com.thed.zephyr.api.ExecutionApi;
import com.thed.zephyr.api.IndexApi;
import com.thed.zephyr.api.IssuesApi;
import com.thed.zephyr.api.JiraReportApi;
import com.thed.zephyr.api.JobProgressApi;
import com.thed.zephyr.api.ServerInfoApi;
import com.thed.zephyr.api.StepresultsApi;
import com.thed.zephyr.api.TeststepApi;
import com.thed.zephyr.api.TraceabilityApi;
import com.thed.zephyr.api.ZqlApi;
import com.thed.zephyr.api.FilterApi;
import com.thed.zephyr.service.ZAPIApiService;
import com.thed.zephyr.util.RestUtils;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@Service("zapiService")
public class ZAPIAPIServiceImpl implements ZAPIApiService {

	@Autowired
	private CycleApi cycleApi;

	@Autowired
	private ExecutionApi executionApi;

	@Autowired
	private IssuesApi issuesApi;

	@Autowired
	private ServerInfoApi serverInfoApi;

	@Autowired
	private TeststepApi teststepApi;

	@Autowired
	private ZqlApi zqlApi;

	@Autowired
	private FilterApi filterApi;

	@Autowired
	private AttachmentApi attachmentApi;

	@Autowired
	private StepresultsApi stepresultsApi;

	@Autowired
	private JobProgressApi jobProgressApi;

	@Autowired
	private TraceabilityApi traceabilityApi;

	@Autowired
	private ChartApi chartApi;

	@Autowired
	private JiraReportApi jiraReportApi;

	@Autowired
	private AuditLogApi auditLogApi;

	@Autowired
	private IndexApi indexApi;
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thed.zephyr.service.ZAPIApiService#createCycle(com.jayway.restassured
	 * .specification.RequestSpecification, java.lang.String)
	 * 
	 * @author Created by manoj.behera on 23-Jan-2017.
	 */
	@Override
	public Response createCycle(RequestSpecification basicAuth, String payLoad) {
		return cycleApi.createCycle(basicAuth, payLoad);
	}

	@Override
	public Response updateCycle(RequestSpecification basicAuth, String payLoad) {
		return cycleApi.updateCycle(basicAuth, payLoad);
	}

	@Override
	public Response deleteCycle(RequestSpecification basicAuth, String cycleId) {
		return cycleApi.deleteCycle(basicAuth, cycleId);
	}

	@Override
	public Response getCycles(RequestSpecification basicAuth, Long projectId) {
		return cycleApi.getCycles(basicAuth, projectId);
	}

	@Override
	public Response getCycle(RequestSpecification basicAuth, String cycleId) {
		return cycleApi.getCycle(basicAuth, cycleId);
	}

	@Override
	public Response searchFilter(RequestSpecification basicAuth, String query) {
		return filterApi.searchFilter(basicAuth, query);
	}
	
	@Override
	public Response cyclesByVersionAndSprint(RequestSpecification basicAuth, String payLoad) {
		return cycleApi.cyclesByVersionAndSprint(basicAuth, payLoad);
	}

	@Override
	public Response cleanupSprint(RequestSpecification basicAuth) {
		return cycleApi.cleanupSprint(basicAuth);
	}
	
	@Override
	public Response exportCycle(RequestSpecification basicAuth, String cycleId, Long versionId, Long projectId) {
		return cycleApi.exportCycle(basicAuth,cycleId,versionId,projectId);
	}
	
	@Override
	public Response createExecution(RequestSpecification basicAuth, String payload) {
		return executionApi.createExecution(basicAuth, payload);
	}


	@Override
	public Response addTestsToCycle(RequestSpecification basicAuth, String payLoad) {
		return executionApi.addTestsToCycle(basicAuth, payLoad);
	}

	@Override
	public Response getExecutionStatus(RequestSpecification basicAuth) {
		return executionApi.getExecutionStatus(basicAuth);
	}

	@Override
	public Response getExecutionsByCycle(RequestSpecification basicAuth, Long projectId, Long versionId, String cycleId) {
		return executionApi.getExecutionsByCycle(basicAuth, projectId, versionId, cycleId);
	}

	@Override
	public Response getExecutionByExecutionId(RequestSpecification basicAuth, String executionId) {
		return executionApi.getExecutionByExecutionId(basicAuth, executionId);
	}
	
	@Override
	public Response executeTest(RequestSpecification basicAuth, String id, String payload) {
		return executionApi.executeTest(basicAuth, id, payload);
	}
	
	@Override
	public Response executeSearch(RequestSpecification basicAuth, String zqlQuery) {
		return zqlApi.executeSearch(basicAuth, zqlQuery);
	}
	
	@Override
	public Response jobprogress(RequestSpecification basicAuth, String jobProgressToken) {
		
		Response response4 = null;
		do {
			response4 = jobProgressApi.jobProgress(basicAuth, jobProgressToken);
			if(response4 != null)
			System.out.println(response4.getBody().asString());
		} while (response4 != null && new JSONObject(response4.getBody().asString()).get("progress").toString() != null
				&& !(new JSONObject(response4.getBody().asString()).get("progress").toString().equals("1.0")));
		return response4;
	}

	@Override
	public Response deleteExecution(RequestSpecification basicAuth, String executionId) {
		return executionApi.deleteExecution(basicAuth, executionId);
	}

	@Override
	public Response getDashboardByName(RequestSpecification basicAuth, String query, int maxRecords) {
		return jiraReportApi.getDashboardByName(basicAuth, query, maxRecords);
	}

	@Override
	public Response getSystemInfo(RequestSpecification basicAuth) {
		return serverInfoApi.getSystemInfo(basicAuth);
	}

	@Override
	public Response getModuleInfo(RequestSpecification basicAuth) {
		return serverInfoApi.getModuleInfo(basicAuth);
	}

	@Override
	public Response getProjects(RequestSpecification basicAuth) {
		return serverInfoApi.getProjects(basicAuth);
	}
	
	@Override
	public Response getVersionsByProject(RequestSpecification basicAuth, Long projectId) {
		return serverInfoApi.getVersionsByProject(basicAuth, projectId);
	}
  
	@Override
	public Response getProjectMetadata(RequestSpecification basicAuth, Long projectId) {
		return serverInfoApi.getProjectMetadata(basicAuth, projectId);
	}
	
	@Override
	public Response getTestStepExecutionStatus(RequestSpecification basicAuth) {
		return teststepApi.getTestStepExecutionStatus(basicAuth);
	}

	@Override
	public Response getClauses(RequestSpecification basicAuth) {
		return zqlApi.getClauses(basicAuth);
	}

	@Override
	public Response autoCompleteZQLJson(RequestSpecification basicAuth) {
		return zqlApi.autoCompleteZQLJson(basicAuth);
	}

	@Override
	public Response getZQLAutocomplete(RequestSpecification basicAuth,String fieldName, String fieldValue) {
		return zqlApi.getZqlAutocompleteApi(basicAuth, fieldName, fieldValue);
	}
	@Override
	public Response loggedinUser(RequestSpecification basicAuth) {
		return filterApi.loggedinUser(basicAuth);
	}

	@Override
	public Response createExecutionfilter(RequestSpecification basicAuth, String payLoad) {
		return filterApi.createExecutionfilter(basicAuth, payLoad);
	}

	@Override
	public Response updateExecutionfilter(RequestSpecification basicAuth, String payLoad) {
		return filterApi.updateExecutionfilter(basicAuth, payLoad);
	}

	@Override
	public Response renameExecutionfilter(RequestSpecification basicAuth, String payLoad) {
		return filterApi.renameExecutionfilter(basicAuth, payLoad);
	}

	@Override
	public Response copyExecutionfilter(RequestSpecification basicAuth, String payLoad) {
		return filterApi.copyExecutionfilter(basicAuth, payLoad);
	}

	@Override
	public Response getfilterById(RequestSpecification basicAuth, String filterId) {
		return filterApi.getfilterById(basicAuth, filterId);
	}

	@Override
	public Response searchExecutionfilter(RequestSpecification basicAuth, String payLoad) {
		return filterApi.searchExecutionfilter(basicAuth, payLoad);
	}

	@Override
	public Response toggleFavouriteFilter(RequestSpecification basicAuth, String payLoad) {
		return filterApi.toggleFavouriteFilter(basicAuth, payLoad);
	}

	@Override
	public Response getFavFilter(RequestSpecification basicAuth, String fav) {
		return filterApi.getFavFilter(basicAuth, fav);
	}
	
	@Override
	public Response deleteFilter(RequestSpecification basicAuth, String filterId) {
		return filterApi.deleteFilter(basicAuth, filterId);
	}

	@Override
	public Response getissue(RequestSpecification basicAuth, String query, String currentJQL, String currentIssueKey, long currentProjectId) {
		return issuesApi.getissue(basicAuth, query,currentJQL, currentIssueKey, currentProjectId);
	}

	@Override
	public Response getdefaultIssue(RequestSpecification basicAuth) {
		return issuesApi.getdefaultIssue(basicAuth);
	}
	@Override
	public Response addAttachmentToStepResult(RequestSpecification basicAuth, String entityId, String entityType,String fileName) {
		return attachmentApi.addAttachmentToStepResult(basicAuth, entityId, entityType, fileName);
	}

	@Override
	public Response getAttachment(RequestSpecification basicAuth, String entityId, String entityType) {
		return attachmentApi.getAttachment(basicAuth, entityId, entityType);
	}
	
	@Override
	public Response getAttachmentById(RequestSpecification basicAuth, String attchmentId) {
		return attachmentApi.getAttachmentById(basicAuth, attchmentId);
	}

	@Override
	public Response getStepLevelAttachmentById(RequestSpecification basicAuth, String attchmentId) {
		return attachmentApi.getStepLevelAttachmentById(basicAuth, attchmentId);
	}

	@Override
	public Response deleteAttachmentToStepResult(RequestSpecification basicAuth, String attchmentId) {
		return attachmentApi.deleteAttachmentToStepResult(basicAuth, attchmentId);
	}

	@Override
	public Response deleteAttachmentToExecution(RequestSpecification basicAuth, String attchmentId) {
		return attachmentApi.deleteAttachmentToExecution(basicAuth, attchmentId);
	}

	@Override
	public Response getAuditLogs(RequestSpecification basicAuth, String entityType, int offset, int maxRecords) {
		return auditLogApi.getAuditLogs(basicAuth, entityType, offset, maxRecords);
	}
	
	@Override
	public Response getAuditByExecutionId(RequestSpecification basicAuth, int offset, int maxRecords, long executionId) {
		return auditLogApi.getAuditByExecutionId(basicAuth, offset, maxRecords,executionId);
	}

	@Override
	public Response bulkUpdateStatus(RequestSpecification basicAuth, String payLoad) {
		return executionApi.bulkUpdateStatus(basicAuth, payLoad);
	}

	@Override
	public Response bulkUpdateAssignee(RequestSpecification basicAuth, String payLoad) {
		return executionApi.bulkUpdateAssignee(basicAuth, payLoad);
	}
	@Override
	public Response bulkUpdateDefects(RequestSpecification basicAuth,String payLoad) {
		return executionApi.bulkUpdateDefects(basicAuth, payLoad);
	}
	
	@Override
	public Response copyExecutions(RequestSpecification basicAuth, int cycleId1, String payLoad) {
		return executionApi.copyExecutions(basicAuth, cycleId1, payLoad);
	}
	
	@Override
	public Response moveExecutions(RequestSpecification basicAuth, int cycleId1, String payLoad) {
		return executionApi.moveExecutions(basicAuth, cycleId1, payLoad);
	}

	@Override
	public Response getDefectByExecution(RequestSpecification basicAuth, String executionId) {
		return executionApi.getDefectByExecution(basicAuth, executionId);
	}

	@Override
	public Response getExecutionByIssue(RequestSpecification basicAuth, String issueId) {
		return executionApi.getExecutionByIssue(basicAuth, issueId);
	}

	@Override
	public Response getExecutionsSummaryBySprintAndIssueId(RequestSpecification basicAuth, String payLoad) {
		return executionApi.getExecutionsSummaryBySprintAndIssueId(basicAuth, payLoad);
	}

	@Override
	public Response exportExecution(RequestSpecification basicAuth, String payLoad) {
		return executionApi.exportExecution(basicAuth, payLoad);
	}

	@Override
	public Response downloadExportedFile(String uri) {
		return executionApi.downloadExportedFile(uri);
	}

	@Override
	public Response bulkDeleteExecutions(RequestSpecification basicAuth, String payLoad) {
		return executionApi.bulkDeleteExecutions(basicAuth, payLoad);
	}

	@Override
	public Response RefreshTheRemoteLinks(RequestSpecification basicAuth, String issueLinkTypeId) {
		return executionApi.RefreshTheRemoteLinks(basicAuth, issueLinkTypeId);
	}

	@Override
	public Response getTestByFilterId(RequestSpecification basicAuth, Long filterId) {
		return filterApi.getTestByFilterId(basicAuth, filterId);
	}

	@Override
	public Response indexExecution(RequestSpecification basicAuth) {
		return indexApi.indexExecution(basicAuth);
	}
	@Override
	public Response indexStatus(RequestSpecification basicAuth, Long token) {
		return indexApi.indexStatus(basicAuth, token);
	}
	
	@Override
	public Response getTeststepResults(RequestSpecification basicAuth, Long orderId) {
		return stepresultsApi.getTeststepResults(basicAuth, orderId);
	}
	
	@Override
	public Response getTeststepResultsByExecutionId(RequestSpecification basicAuth, Long executionsId) {
		return stepresultsApi.getTeststepResultsByExecutionId(basicAuth, executionsId);
	}
	
	@Override
	public Response updateTeststepResults(RequestSpecification basicAuth, Long stepResultId, String payLoad) {
		return stepresultsApi.updateTeststepResults(basicAuth, stepResultId, payLoad);
	}

	@Override
	public Response getStepResultsDefects(RequestSpecification basicAuth, String stepResultId) {
		return stepresultsApi.getStepResultsDefects(basicAuth, stepResultId);
	}

	@Override
	public Response getStepDefectsByExecution(RequestSpecification basicAuth, long executionId) {
		return stepresultsApi.getStepDefectsByExecution(basicAuth, executionId);
	}

	
	@Override
	public Response createStepResultWithoutSettingStatus(RequestSpecification basicAuth, String payLoad) {
		return stepresultsApi.createStepResultWithoutSettingStatus(basicAuth, payLoad);
	}

	@Override
	public Response createTeststep(RequestSpecification basicAuth, Long issueId, String payLoad) {
		return teststepApi.createTeststep(basicAuth, issueId, payLoad);
	}

	@Override
	public Response getTeststep(RequestSpecification basicAuth, Long issueId) {
		return teststepApi.getTeststep(basicAuth, issueId);
	}

	@Override
	public Response getTeststepByID(RequestSpecification basicAuth, Long issueId, Long stepId) {
		return teststepApi.getTeststepByID(basicAuth, issueId, stepId);
	}

	
	@Override
	public Response getTeststepForUpdatedSteps(RequestSpecification basicAuth, Long issueId, Long updatedstepId) {
		return teststepApi.getTeststepForUpdatedSteps(basicAuth, issueId, updatedstepId);
	}

	@Override
	public Response deleteTestStep(RequestSpecification basicAuth, Long issueId, Long stepId) {
		return teststepApi.deleteTestStep(basicAuth, issueId, stepId);
	}

	@Override
	public Response updateTeststep(RequestSpecification basicAuth, Long issueId2, Long testStepId, String payLoad) {
		return teststepApi.updatetestStep(basicAuth, issueId2, testStepId, payLoad);
	}

	@Override
	public Response cloneTeststep(RequestSpecification basicAuth, Long issueId2, Long testStepId, String payLoad1) {
		return teststepApi.cloneTeststep(basicAuth, issueId2, testStepId, payLoad1);
	}

	@Override
	public Response moveTeststep(RequestSpecification basicAuth, Long issueId2, Long testStepId, String payLoad) {
		return teststepApi.moveTeststep(basicAuth, issueId2, testStepId, payLoad);
	}

	@Override
	public Response getTeststepByExecution(RequestSpecification basicAuth, Long executionsId, Long expand) {
		return teststepApi.getTeststepByExecution(basicAuth, executionsId, expand);
	}

	@Override
	public Response testCount(RequestSpecification basicAuth, String groupFld, Long projectId, Long versionId) {
		return jiraReportApi.testCount(basicAuth, groupFld, projectId, versionId);
	}
	
	@Override
	public Response getExecutionCount(RequestSpecification basicAuth, Long projectId,
			String groupFld, String daysPrevious, String periodName) {
		return jiraReportApi.getExecutionCount(basicAuth, projectId,groupFld, daysPrevious,periodName );
	}

	@Override
	public Response getExecutionCountGroupByUser(RequestSpecification basicAuth,
			Long projectId, Long versionId, String groupFld, String daysPrevious, String periodName){
		return jiraReportApi.getExecutionCountGroupByUser(basicAuth, projectId,versionId,groupFld, daysPrevious,periodName );
	}
	
	@Override
	public Response getExecutionCountBySprint(RequestSpecification basicAuth,
			Long projectId, Long versionId, String groupFld){
		return jiraReportApi.getExecutionCountBySprint(basicAuth, projectId,versionId,groupFld);
	}
	
	@Override
	public Response getExecutionCountAsBurndown(RequestSpecification basicAuth,Long projectId, Long versionId, String cycleId, String groupFld,
			String graphType){
		return jiraReportApi.getExecutionCountAsBurndown(basicAuth, projectId,versionId,cycleId,groupFld,graphType);
	}
	
	@Override
	public Response getExecutionCountAsSprintBurndown(RequestSpecification basicAuth,Long projectId, Long versionId, String sprintId, String groupFld,
			String graphType){
		return jiraReportApi.getExecutionCountAsSprintBurndown(basicAuth, projectId,versionId,sprintId,groupFld,graphType);
	}
	
	@Override
	public Response getTopDefects(RequestSpecification basicAuth, Long projectId,Long versionId, Long issueStatuses){
		return jiraReportApi.getTopDefects(basicAuth, projectId,versionId,issueStatuses);
	}
	
	@Override
	public Response getTestCreated(RequestSpecification basicAuth, String projectKey, int daysPrevious, String periodName) {
		return chartApi.getTestCreated(basicAuth, projectKey, daysPrevious, periodName);
	}
	
	@Override
	public Response getIssueStatuses(RequestSpecification basicAuth, long projectId) {
		return chartApi.getIssueStatuses(basicAuth, projectId);
	}
	
	@Override
	public Response searchExecutionsByTest(RequestSpecification basicAuth,String testIdOrKey, int maxResult, int offset){
		return traceabilityApi.searchExecutionsByTest(basicAuth, testIdOrKey,maxResult,offset);
	}
	
	@Override
	public Response searchExecutionsByRequirement(RequestSpecification basicAuth,String requirementIdOrKeyList){
		return traceabilityApi.searchExecutionsByRequirement(basicAuth,requirementIdOrKeyList);
	}
	
	@Override
	public Response searchExecutionsByDefect(RequestSpecification basicAuth,String defectIdOrKey){
		return traceabilityApi.searchExecutionsByDefect(basicAuth,defectIdOrKey);
	}
	
	@Override
	public Response searchDefectStatistics(RequestSpecification basicAuth,String defectIdOrKeyList){
		return traceabilityApi.searchDefectStatistics(basicAuth,defectIdOrKeyList);
	}
	
	@Override
	public Response exportTraceability(RequestSpecification basicAuth,String payload){
		return traceabilityApi.exportTraceability(basicAuth,payload);
	}
	
	@Override
	public boolean validateExportTraceability(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		//Assert.assertNotNull(new JSONObject(responseData).get("id"), "Created cycle id is null.");
		Assert.assertTrue(new JSONObject(responseData).get("url").toString().contains("/plugins/servlet/export/exportAttachment?fileName="));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateCreateCycleApi(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		System.out.println(responseData);
		Assert.assertNotNull(new JSONObject(responseData).get("id"), "Created cycle id is null.");
		Assert.assertTrue(new JSONObject(responseData).get("responseMessage").toString().contains("created successfully"));
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateUpdateCycleApi(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertNotNull(new JSONObject(responseData).get("id"), "Updated cycle id is null.");
		Assert.assertTrue(new JSONObject(responseData).get("responseMessage").toString().contains("updated successfully"));
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateDeletedCycle(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).get("success").toString().contains("successfully deleted"));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateCopyExecutions(Response response6) {
		RestUtils.ValidateStatusIs200(response6);
		String responseData = response6.getBody().asString();
		Assert.assertTrue(new JSONObject(new JSONObject(responseData).getString("message")).get("success").toString().length()>0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateMoveExecutions(Response response6) {
		RestUtils.ValidateStatusIs200(response6);
		String responseData = response6.getBody().asString();
		//System.out.println(new JSONObject(new JSONObject(responseData).getString("message")).get("success").toString().length());
		Assert.assertTrue(new JSONObject(new JSONObject(responseData).getString("message")).get("success").toString().length()>0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetCycles(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).length() > 0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetCycle(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertFalse(new JSONObject(responseData).get("sprintId")== "null", "Cycle is not linked to sprint");
		Assert.assertEquals(new JSONObject(responseData).get("name"),"Cycle created through API");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetCyclesbyVersionAndSprint(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("id"), "1");
		Assert.assertTrue((new JSONArray(responseData).getJSONObject(0)).getJSONArray("cycles").length() > 0);
		System.out.println("Response data validated successfully.");
		return true;
	}	
	
	@Override
	public boolean validateSystemInfo(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		System.out.println(responseData);
		// Assert.assertTrue(new
		// JSONObject(responseData).get("customerId").contains("QA"));
		Assert.assertEquals(new JSONObject(responseData).get("customerId"), "zephyr");
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateModuleInfo(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		System.out.println(responseData);
		Assert.assertEquals(new JSONObject(responseData).get("status"), "ENABLED");
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateLicenseInfo(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		System.out.println(responseData);
		Assert.assertEquals(new JSONObject(responseData).get("customerId"), "zephyr");
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateProjects(Response response, Map<String, Map<String, String>> map) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		System.out.println(responseData);
		JSONArray abc = new JSONArray(new JSONObject(responseData).get("options").toString());
		Assert.assertTrue(abc.length() == map.size());
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateVersions(Response response, Map<String, Map<String, String>> map) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		System.out.println(responseData);
		JSONArray abc = new JSONArray(new JSONObject(responseData).get("unreleasedVersions").toString());
		Assert.assertTrue(abc.length() == map.size());
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateProjectMetadata(Response response) {
		RestUtils.ValidateStatusIs200(response);
		JSONObject responseData = new JSONObject(response.getBody().asString());
		System.out.println(responseData);
		Assert.assertEquals(responseData.getJSONArray("components").length(), 5);
		Assert.assertEquals(responseData.getJSONArray("priorities").length(), 5);
		Assert.assertEquals(responseData.getJSONArray("issueStatuses").length(), 3);
		Assert.assertEquals(responseData.getJSONArray("executionStatuses").length(), 5);
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateTestExecutionStatuses(Response response) {
		RestUtils.ValidateStatusIs200(response);
		JSONArray responseData = new JSONArray(response.getBody().asString());
		System.out.println(responseData);
		Assert.assertEquals(responseData.length(), 5);
		Assert.assertEquals(responseData.getJSONObject(0).getString("name"), "PASS");
		Assert.assertEquals(responseData.getJSONObject(1).getString("name"), "FAIL");
		Assert.assertEquals(responseData.getJSONObject(2).getString("name"), "WIP");
		Assert.assertEquals(responseData.getJSONObject(3).getString("name"), "BLOCKED");
		Assert.assertEquals(responseData.getJSONObject(4).getString("name"), "UNEXECUTED");
		//Assert.assertEquals(responseData.getJSONObject(5).getString("name"), "PENDING");
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validategetTestStepExecutionStatus(Response response) {
		RestUtils.ValidateStatusIs200(response);
		JSONArray responseData = new JSONArray(response.getBody().asString());
		System.out.println(responseData);
		Assert.assertEquals(responseData.length(), 5);
		Assert.assertEquals(responseData.getJSONObject(0).getString("name"), "PASS");
		Assert.assertEquals(responseData.getJSONObject(1).getString("name"), "FAIL");
		Assert.assertEquals(responseData.getJSONObject(2).getString("name"), "WIP");
		Assert.assertEquals(responseData.getJSONObject(3).getString("name"), "BLOCKED");
		Assert.assertEquals(responseData.getJSONObject(4).getString("name"), "UNEXECUTED");
		//Assert.assertEquals(responseData.getJSONObject(5).getString("name"), "APPROVED");

		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validategetDashboardByName(Response response) {
		RestUtils.ValidateStatusIs200(response);
		JSONArray responseData = new JSONArray(response.getBody().asString());
		System.out.println(responseData);
		Assert.assertTrue(responseData.length() > 0);
		Assert.assertEquals(responseData.getJSONObject(0).get("id"), 10000);
		Assert.assertEquals(responseData.getJSONObject(0).getString("name"), "System Dashboard");
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validategetIssues(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		System.out.println(responseData);
		Assert.assertTrue(responseData.length() > 0);
		
		JSONArray jsonArray = new JSONObject(responseData).getJSONArray("sections");
		Assert.assertEquals(jsonArray.getJSONObject(1).getString("label"),
				"Current Search");
		Assert.assertEquals(jsonArray.getJSONObject(1).get("id").toString(), "cs");
		Assert.assertTrue(jsonArray.getJSONObject(1).getJSONArray("issues").length()>0);				
		//Assert.assertEquals((new JSONObject(responseData).getJSONArray("sections")).getJSONObject(1).getString("id"),
			//	"cs");

		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateAddTestsToCycle(Response response6) {
		RestUtils.ValidateStatusIs200(response6);
		String responseData = response6.getBody().asString();
		//Assert.assertFalse(new JSONObject(responseData).getString("warn").contains("Tests added: <strong>-<"));
		String s1 = new JSONObject(responseData).getString("message");
		String[] s2 = s1.split("<br/>");		
		//System.out.println(s2[1]);
		Assert.assertTrue(s2[1].contains("PROJ1-3"));
		Assert.assertTrue(s2[1].contains("PROJ1-4"));
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateGetExecutions(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue((new JSONObject(responseData).getJSONArray("executions").length()> 0));
		Assert.assertEquals(new JSONObject(responseData).get("recordsCount").toString(), "4");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateExportCycle(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		new JSONObject(responseData).getString("url").contains("export/exportAttachment");
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateGetExecutionById(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertFalse(new JSONObject(responseData).getJSONObject("execution").get("id").toString() == "null");
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateExecuteTest(Response response, String executionId1) {
		RestUtils.ValidateStatusIs200(response);
		//SoftAssert softassert = new SoftAssert();
		
		String responseData = response.getBody().asString();
		//Assert.assertTrue(new JSONObject(responseData).get("id")== executionId1);
		Assert.assertTrue(new JSONObject(responseData).get("id") != "null");
		//Assert.assertFalse(new JSONObject(responseData).getString("error").contains("Error in creating Execution"));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateExecuteSearch(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		System.out.println("Record counts:" +new JSONObject(responseData).getJSONArray("executions").length());
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("executions").length() > 0);
		//Assert.assertFalse(new JSONObject(responseData).getString("error").contains("Error in creating Execution"));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validatedeleteExecution(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(
				new JSONObject(responseData).getString("success").contains("Successfully deleted execution(s)"));
		System.out.println("Response data validated successfully.");
		return true;
	}
	@Override
	public boolean validateDeleteExecution(Response response6) {
		RestUtils.ValidateStatusIs200(response6);
		String responseData = response6.getBody().asString();
		//Assert.assertFalse(new JSONObject(responseData).getString("success").length()== 0);
		Assert.assertTrue(new JSONObject(new JSONObject(responseData).getString("message")).get("success").toString().length()>0);
		System.out.println("Response data validated successfully.");
		return true;
	}

	
	@Override
	public boolean validateExportExecutios(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getString("url").contains("export/exportAttachment") );
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateStepresult(Response response6) {
		RestUtils.ValidateStatusIs200(response6);
		String responseData = response6.getBody().asString();
		/*Assert.assertTrue(new JSONArray(responseData).getJSONObject(0).get("id") != "null");
		System.out.println(new JSONArray(responseData).getJSONObject(0).get("id"));
		Assert.assertTrue((new JSONArray(responseData).getJSONObject(0)).get("status")== "-1");*/
		Assert.assertTrue(new JSONObject(responseData).get("id") != "null");
		Assert.assertEquals(new JSONObject(responseData).get("status"), "-1");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public Response addAttachment(RequestSpecification basicAuth, String entityId, String entityType, String fileName) {
		return attachmentApi.addAttachment(basicAuth, entityId, entityType, fileName);
	}
	public boolean validateAddAttachment(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).get("success").toString().contains("successfully uploaded") );
		System.out.println("Response data validated successfully.");
		return true;
	}

	public boolean validateGetAttachment(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).get("data").toString().contains("fileName"));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	public boolean validateDeleteAttachment(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).get("success").toString().contains("successfully deleted"));
		System.out.println("Response data validated successfully.");
		return true;
	}	

	@Override
	public boolean validateIndexExecution(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).get("token") != "null");
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validategetindexStatus(Response response1) {
		RestUtils.ValidateStatusIs200(response1);
		String responseData = response1.getBody().asString();
		Assert.assertFalse(new JSONObject(responseData).toString().contains("notfound"));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validaterefreshReomteLinks(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		//System.out.println(new JSONObject(responseData).get("token"));
		Assert.assertTrue(new JSONObject(responseData).get("token") != "null");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateAuditLogs(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		//System.out.println((Integer)new JSONObject(responseData).get("totalItemsCount"));
		Assert.assertTrue((Integer)new JSONObject(responseData).get("totalItemsCount") > 0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetAuditByExecutionId(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue((Integer)new JSONObject(responseData).get("totalItemsCount") > 0);
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateCloneCycle(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		System.out.println(responseData);
		Assert.assertNotNull(new JSONObject(responseData).get("id"), "Created cycle id is null.");
		Assert.assertTrue(
				new JSONObject(responseData).get("responseMessage").toString().contains("created successfully"));
		System.out.println("Response data validated successfully.");
		return true;
	}
	@Override
	public boolean validateCleanupCycle(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String res = new JSONObject(response.getBody().asString()).get("took").toString();
		Assert.assertEquals(res, "0");
		System.out.println("Response data validated successfully.");
		return true;

	}
	
	@Override
	public boolean validateCreateExecution(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).length() == 1);
		Assert.assertTrue(new JSONObject(responseData).toString().contains("id"));
		System.out.println("Response data validated successfully.");
		return true;

	}
	
	@Override
	public boolean validateBulkStatusUdate(Response response4) {		
		RestUtils.ValidateStatusIs200(response4);
		String responseData = response4.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).get("message").toString().contains("successfully updated."));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateBulkUpdateAssignee(Response response4) {
		String success="All execution(s) were successfully updated.";
		RestUtils.ValidateStatusIs200(response4);
		String responseData = response4.getBody().asString();
		//System.out.println(responseData);
		//Assert.assertTrue(new JSONObject(responseData).get("message").toString().contains(success),"successfully updated1.");
		Assert.assertTrue(new JSONObject(responseData).get("message").toString().contains("successfully updated."));
		System.out.println("Response data validated successfully.");
		return true;
	}
	@Override
	public boolean validateloggedInUser(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertEquals(new JSONObject(responseData).get("LOGGED_IN_USER").toString(),"vm_admin");
		//Assert.assertEquals(new JSONObject(responseData).get("LOGGED_IN_USER").toString().contains("LOGGED_IN_USER"),"Config.getValue("adminUserName")");
		System.out.println("Response data validated successfully.");
		return true;
	}
	@Override
	public boolean validateCreateExecutionfilter(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).get("responseMessage").toString().contains("Execution Filter created successfully"));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateUpdateExecutionFilter(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).get("success").toString().contains("Execution Filter updated successfully."));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateRenamedFilter(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).get("success").toString().contains("Execution Filter renamed successfully."));
		System.out.println("Response data validated successfully.");
		return true;
	}
	

	@Override
	public boolean validateCopyExecutionFilter(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).get("success").toString().contains("Execution Filter copied successfully."));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetExecutionFilter(Response response, String FilterId) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		System.out.println("executionfilterId:"+FilterId);
		//System.out.println(new JSONObject(responseData).get("id"));
		Assert.assertTrue(new JSONObject(responseData).get("id")!= "null");
		//Assert.assertEquals((new JSONObject(responseData).get("id")), FilterId);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validatesearchExecutionFilter(Response response1) {
		RestUtils.ValidateStatusIs200(response1);
		String responseData = response1.getBody().asString();
		//Assert.assertTrue(responseData.contains("Apifilter1"),"Filter name is different.");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("filterName"), "Apifilter2");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateSearchFilter(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		//Assert.assertTrue(responseData.contains("Apifilter1"),"Filter name is different.");
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("options").length() > 0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateToggleFavFilter(Response response1) {
		RestUtils.ValidateStatusIs200(response1);
		String responseData = response1.getBody().asString();
		Assert.assertEquals(new JSONObject(responseData).get("success"),"Favorite status toggled successfully.");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateDeleteExecutionFilter(Response response1) {
		RestUtils.ValidateStatusIs200(response1);
		String responseData = response1.getBody().asString();
		Assert.assertEquals(new JSONObject(responseData).get("success"),"Execution Filter deleted successfully.");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetFavFilter(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONArray(responseData).length()>0,"Fav filter not found");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("isFavorite"),true);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validatecreateColumnSelection(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertFalse(new JSONObject(responseData).toString().contains("Column configuration for given User and ZQLFilter already exists!"));
		//Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("isFavorite"),true);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validategetColumnSelection(Response response1) {
		RestUtils.ValidateStatusIs200(response1);
		String responseData = response1.getBody().asString();
		Assert.assertFalse(new JSONObject(responseData).toString().contains("Operation not permitted, no right permissions on given ZQLFilter!"));
		Assert.assertTrue(new JSONObject(responseData).get("id") != "null");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateupdateColumnSelection(Response response1) {
		RestUtils.ValidateStatusIs200(response1);
		String responseData = response1.getBody().asString();
		Assert.assertFalse(new JSONObject(responseData).toString().contains("Operation not permitted, no right permissions on given ZQLFilter!"));
		Assert.assertTrue(new JSONObject(responseData).get("id") != "null");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validategetExecutionDetailsInZql(Response response4) {
		RestUtils.ValidateStatusIs200(response4);
		String responseData = response4.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONObject("execution").get("id")!= "null");
		Assert.assertTrue(new JSONObject(responseData).toString().contains("prevExecutionId"));
		Assert.assertTrue(new JSONObject(responseData).toString().contains("nextExecutionId"));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetTestByFilterId(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertEquals(new JSONObject(responseData).get("desc"),"This is a JIRA filter");
		Assert.assertEquals(new JSONObject(responseData).get("count"),2);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validatequickSearchZQLFilter(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONArray(responseData).length()>0,"Execution filter not found");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetTestCreated(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONObject("TestsCreationMap").length()>0);
		Assert.assertTrue((new JSONObject(responseData).get("TestsCreationCount")).toString() != "null");
		Assert.assertEquals(new JSONObject(responseData).get("TestsCreationPeriod"), 30);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetIssueStatuses(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("IssueStatusesOptionsList").length()>0);
		Assert.assertEquals(new JSONObject(responseData).getJSONArray("IssueStatusesOptionsList").getJSONObject(0).get("label"), "Done");
		Assert.assertEquals(new JSONObject(responseData).getJSONArray("IssueStatusesOptionsList").getJSONObject(1).get("label"), "In Progress");
		Assert.assertEquals(new JSONObject(responseData).getJSONArray("IssueStatusesOptionsList").getJSONObject(2).get("label"), "To Do");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetTestCountGroupByUser(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertEquals(new JSONObject(responseData).get("groupFld"),"user");
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("data").getJSONObject(0).get("cnt")!= "null" );
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetExecutionCount(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONObject("data").length()>0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetExecutionCountGroupByUser(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertEquals(new JSONObject(responseData).getString("urlBase"), "TBD");
		Assert.assertEquals(new JSONObject(responseData).getString("groupFld"), "user");
		Assert.assertTrue(new JSONObject(responseData).getJSONObject("statusSeries").length()>0);
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("data").length()>0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetExecutionCountBySprint(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertEquals(new JSONObject(responseData).getString("urlBase"), "TBD");
		Assert.assertEquals(new JSONObject(responseData).getString("groupFld"), "sprint-cycle");
		Assert.assertTrue(new JSONObject(responseData).getJSONObject("statusSeries").length()>0);
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("data").length()>0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetExecutionCountAsBurndown(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONObject("data").length()>0);
		System.out.println("Response data validated successfully.");
		return true;
	}	
	
	@Override
	public boolean validateGetExecutionCountAsSprintBurndown(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONObject("data").length()>0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateGetTopDefects(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("data").length()>0);
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("data").getJSONObject(0).getJSONArray("associatedTestIds").length()>0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateSearchExecutionsByTest(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("executions").length()>0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateSearchExecutionsByRequirement(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONArray(responseData).getJSONObject(0).getJSONObject("requirement").length() !=0);
		Assert.assertTrue(new JSONArray(responseData).getJSONObject(0).get("totalDefects")!="null");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateSearchExecutionsByDefect(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("executions").length() >0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateSearchDefectStatistics(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONArray(responseData).getJSONObject(0).getJSONObject("defect").length() >0);
		Assert.assertTrue(new JSONArray(responseData).getJSONObject(0).getJSONObject("executionStat").length() >0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateCloneTeststep(Response response2) {
		RestUtils.ValidateStatusIs200(response2);
		String responseData = response2.getBody().asString();
		Assert.assertNotNull(new JSONArray(responseData).getJSONObject(1).get("id"), "Clone cycle id is null");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(1).get("step"), "CLONE - Big Heading for clone");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(1).get("data"), "Big Heading for clone");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(1).get("result"), "Big Heading for clone");
		System.out.println("Response data validated successfully.");
		return true;
	}
	@Override
	public boolean validateCloneTeststepWithWiki(Response response2) {
		RestUtils.ValidateStatusIs200(response2);
		String responseData = response2.getBody().asString();
		Assert.assertNotNull(new JSONArray(responseData).getJSONObject(0).get("id"), "Clone cycle id is null");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("step"), "CLONE - \nh1.Step in wiki");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("data"), "h1.Data in wiki");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("result"), "h1.Result in wiki");
		System.out.println("Response data validated successfully.");
		return true;
	}
	@Override
	public boolean validateUpdatetestStep(String reqPayload, Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		JSONObject responseObject = new JSONObject(responseData);
		JSONObject reqObject = new JSONObject(reqPayload);
		Assert.assertNotNull(new JSONObject(responseData).get("id"), "updated teststep id is null.");
		Assert.assertNotNull(new JSONObject(responseData).get("orderId"), "Updated step  id is null.");
		if (reqObject.has("step") || reqObject.get("step") != "") {
			Assert.assertEquals(responseObject.get("step").toString(), reqObject.get("step").toString());
		}
		if (reqObject.has("data") || reqObject.get("data") != "") {
			Assert.assertEquals(responseObject.get("data").toString(), reqObject.get("data").toString());
		}
		if (reqObject.has("result") || reqObject.get("result") != "") {
			Assert.assertEquals(responseObject.get("result").toString(), reqObject.get("result").toString());
		}
		Assert.assertNotNull(responseObject.get("createdBy"), "");
		Assert.assertNotNull(responseObject.get("modifiedBy"), "");
		System.out.println("Response data validated successfully.");
		return true;
	}
	@Override
	public boolean validateMovetestStep(String reqPayload, Response response3) {
		RestUtils.ValidateStatusIs200(response3);
		String responseData = response3.getBody().asString();
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("step"), "New_step");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("data"), "New_data");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("result"), "New_result");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateCreatedtestStep(Response response1) {
		RestUtils.ValidateStatusIs200(response1);
		String responseData = response1.getBody().asString();
		Assert.assertNotNull(new JSONObject(responseData).get("id").toString(), "stepId is null");
		String stepId = new JSONObject(responseData).get("id").toString();
		System.out.println("stepId:" + stepId);
		return true;
	}
	
	@Override
	public boolean validateCreatetestStepWithWIKI(String reqPayload, Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertNotNull(new JSONObject(responseData).get("id").toString(), "stepId is null");
		String stepId = new JSONObject(responseData).get("id").toString();
		System.out.println("stepId:" + stepId);
		return true;
	}
	
	@Override
	public boolean validateGetTestStepByIssueID(Response response2) {
		String responseData = response2.getBody().asString();
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(0).get("orderId").toString(), "1");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(1).get("orderId").toString(), "2");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(2).get("orderId").toString(), "3");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(3).get("orderId").toString(), "4");
		Assert.assertEquals(new JSONArray(responseData).getJSONObject(4).get("orderId").toString(), "5");
		System.out.println("Response data validated successfully.");
		return true;
	}
		
	@Override
	public boolean validateGetTeststepByID(Response response2) {
		RestUtils.ValidateStatusIs200(response2);
		String responseData = response2.getBody().asString();
		String stepId = new JSONObject(responseData).get("id").toString();
		System.out.println("stepId:" + stepId);		
		Assert.assertTrue(new JSONObject(responseData).length() > 0);
		Assert.assertEquals(new JSONObject(responseData).get("orderId").toString(), "6");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateDeleteTeststep(Response response) {
		RestUtils.ValidateStatusIs200(response);
		return true;
	}

	@Override
	public Response getLicenseInfo(RequestSpecification basicAuth) {
		return serverInfoApi.getLicenseInfo(basicAuth);
	}

	@Override
	public boolean validateGetStepResult(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONArray(responseData).length() > 0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	@Override
	public boolean validateGetStepResultById(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).length() > 0);
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateUpdateStepResult(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertEquals(new JSONObject(responseData).get("status"), "4");
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateStepResultDefects(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).toString().contains("key"));
		System.out.println("Response data validated successfully.");
		return true;
	}
	
	@Override
	public boolean validateStepDefectsByExecutionID(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertEquals(new JSONObject(responseData).get("totalDefectCount"),1);
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateexecutionUpdateWithBulkDefect(Response response4) {
		RestUtils.ValidateStatusIs200(response4);
		String responseData = response4.getBody().asString();
		Assert.assertFalse(new JSONObject(responseData).getString("message").contains("invalid"));
		System.out.println("Response data validated successfully.");
		return true;
		/*JSONObject responseObject = new JSONObject(responseData);
		JSONObject reqObject = new JSONObject(reqPayload);*/
		//Assert.assertEquals(new JSONObject(responseData).length(), 2);		
		/*Assert.assertNotNull(new JSONObject(responseData).get("id"), "updated teststep id is null.");
		Assert.assertNotNull(new JSONObject(responseData).get("orderId"), "Updated step  id is null.");
		if (reqObject.has("executions") || reqObject.get("executions") != "") {
			Assert.assertEquals(responseObject.get("step").toString(), reqObject.get("step").toString());
		}
		if (reqObject.has("data") || reqObject.get("data") != "") {
			Assert.assertEquals(responseObject.get("data").toString(), reqObject.get("data").toString());
		}
		if (reqObject.has("result") || reqObject.get("result") != "") {
			Assert.assertEquals(responseObject.get("result").toString(), reqObject.get("result").toString());
		}
		Assert.assertNotNull(responseObject.get("createdBy"), "");
		Assert.assertNotNull(responseObject.get("modifiedBy"), "");*/
		
	}

	@Override
	public boolean validateGetDefectsByExecution(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).length() >0);
		Assert.assertTrue(new JSONObject(responseData).toString().contains("key"), "Execution is not linked to defects");
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validateGetExecutionByIssueKey(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("executions").length()!= 0);
		System.out.println("Response data validated successfully.");
		return true;
	}

	@Override
	public boolean validategetExecutionsSummaryBySprintAndIssueID(
			Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONObject("successful").toString().contains("totalExecutions"));
		System.out.println("Response data validated successfully.");
		return true;
	}

	 public boolean validategetZql(Response response) {
		RestUtils.ValidateStatusIs200(response);
		String responseData = response.getBody().asString();
		Assert.assertTrue(new JSONObject(responseData).getJSONArray("clauses").length()== 16);
		System.out.println("Response data validated successfully.");
		return true;
}
	 public boolean validategetAutocompleteJson(Response response) {
			RestUtils.ValidateStatusIs200(response);
			String responseData = response.getBody().asString();
			Assert.assertTrue(new JSONObject(responseData).toString().contains("jqlFieldZ"));
			Assert.assertFalse(new JSONObject(responseData).getString("jqlFieldZ").length() ==0);
			System.out.println("Response data validated successfully.");
			return true;
	
}
	 public boolean validategetZQLAutocomplete(String textForSearch,Response response) {
			RestUtils.ValidateStatusIs200(response);
			String responseData = response.getBody().asString();
			/*System.out.println(responseData);
			JSONArray json = new JSONArray(response.getBody().asString());
			for (int i = 0; i < json.length(); i++) {
				JSONObject json1 = json.getJSONObject(i);
				System.out.println(json1.getString("displayName") + " : " + textForSearch);
				// System.out.println(json1.getString("displayName").toLowerCase().compareToIgnoreCase(textForSearch.toLowerCase()));
				Assert.assertTrue(json1.getString("displayName").toLowerCase().contains(textForSearch.toLowerCase()));
				Assert.assertTrue(json1.getString("value").toLowerCase().contains(textForSearch.toLowerCase()));
			}*/
			Assert.assertEquals((new JSONObject(responseData).getJSONArray("results").getJSONObject(0).get("value")), "PASS");
			return true;
}

	@Override
	public Response createColumnSelection(RequestSpecification basicAuth,
			String payload) {
		return filterApi.createColumnSelection(basicAuth, payload);
	}

	@Override
	public Response getColumnSelection(RequestSpecification basicAuth,long executionFilterId) {
		return filterApi.getColumnSelection(basicAuth, executionFilterId);
	}
	
	@Override
	public Response getExecutionDetailsInZql(RequestSpecification basicAuth, long id, String zql) {
		return filterApi.getExecutionDetailsInZql(basicAuth, id, zql);
	}
	
	@Override
	public Response updateColumnSelection(RequestSpecification basicAuth, long id,
			String payload) {
		return filterApi.updateColumnSelection(basicAuth, id, payload);
	}
	
	@Override
	public Response quickSearchZQLFilter(RequestSpecification basicAuth,String fieldName) {
		return filterApi.quickSearchZQLFilter(basicAuth, fieldName);
	}
}