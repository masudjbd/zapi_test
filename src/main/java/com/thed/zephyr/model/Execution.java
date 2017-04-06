/**
 * Created by manoj.behera on 16-Nov-2016.
 */
package com.thed.zephyr.model;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.thed.zephyr.util.CommonUtils;

/**
 * @author manoj.behera 16-Nov-2016
 *
 */
public class Execution {
	private Long projectId;
	private Long issueId;
	private List<Long> issueIds;
	private List<String> issues;
	private String cycleId;
	private String fromCycleId;
	private List<String> cycleIds;
	private Long versionId;
	private Long fromVersionId;
	private String executionId;
	private List<String> executions;
	private String assigneeType;
	private boolean changeAssignee;
	private String assignee;
	private int noOfExecutions;
	private List<String> defectList;
	private String comment;
	private int method;
	private Long searchId;
	private int sprintId;
	private int statusId;
	private String updateDefectList;
	private String issueIdOrKeys;
	public String getIssueIdOrKeys() {
		return issueIdOrKeys;
	}
	public void setIssueIdOrKeys(String issueIdOrKeys) {
		this.issueIdOrKeys = issueIdOrKeys;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getIssueId() {
		return issueId;
	}
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}
	public List<Long> getIssueIds() {
		return issueIds;
	}
	public void setIssueIds(List<Long> issueIds) {
		this.issueIds = issueIds;
	}
	public List<String> getIssues() {
		return issues;
	}
	public void setIssues(List<String> issues) {
		this.issues = issues;
	}
	public String getCycleId() {
		return cycleId;
	}
	public void setCycleId(String cycleId) {
		this.cycleId = cycleId;
	}
	public String getFromCycleId() {
		return fromCycleId;
	}
	public void setFromCycleId(String fromCycleId) {
		this.fromCycleId = fromCycleId;
	}
	public List<String> getCycleIds() {
		return cycleIds;
	}
	public void setCycleIds(List<String> cycleIds) {
		this.cycleIds = cycleIds;
	}
	public Long getVersionId() {
		return versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	public Long getFromVersionId() {
		return fromVersionId;
	}
	public void setFromVersionId(Long fromVersionId) {
		this.fromVersionId = fromVersionId;
	}
	public String getExecutionId() {
		return executionId;
	}
	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}
	public List<String> getExecutions() {
		return executions;
	}
	public void setExecutions(List<String> executions) {
		this.executions = executions;
	}
	public String getAssigneeType() {
		return assigneeType;
	}
	public void setAssigneeType(String assigneeType) {
		this.assigneeType = assigneeType;
	}
	public boolean isChangeAssignee() {
		return changeAssignee;
	}
	public void setChangeAssignee(boolean changeAssignee) {
		this.changeAssignee = changeAssignee;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public int getNoOfExecutions() {
		return noOfExecutions;
	}
	public void setNoOfExecutions(int noOfExecutions) {
		this.noOfExecutions = noOfExecutions;
	}
	public List<String> getDefectList() {
		return defectList;
	}
	public void setDefectList(List<String> defectList) {
		this.defectList = defectList;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getMethod() {
		return method;
	}
	public void setMethod(int method) {
		this.method = method;
	}
	public Long getSearchId() {
		return searchId;
	}
	public void setSearchId(Long searchId) {
		this.searchId = searchId;
	}
	public int getSprintId() {
		return sprintId;
	}
	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getUpdateDefectList() {
		return updateDefectList;
	}
	public void setUpdateDefectList(String updateDefectList) {
		this.updateDefectList = updateDefectList;
	}

	@Override
	public String toString() {
		JSONObject executionJson = new JSONObject();
		if (statusId != 0) {
			executionJson.put("status", this.statusId);
		}
		executionJson.put("projectId", this.projectId);
		executionJson.put("versionId", this.versionId);
		executionJson.put("searchId", this.searchId);
		executionJson.put("cycleId", this.cycleId);
	    executionJson.put("fromCycleId", this.fromCycleId);
	    executionJson.put("fromVersionId", this.fromVersionId);
	    executionJson.put("id", this.executionId);
	    executionJson.put("assigneeType", this.assigneeType);
	
	if (this.noOfExecutions != 0) {
		executionJson.put("noOfExecutions", this.noOfExecutions);
	}
	if (this.sprintId != 0) {
		executionJson.put("sprintId", this.sprintId);
	}
	if (this.method != 0) {
		executionJson.put("method", this.method);
	}
	if (this.assigneeType != null) {
		executionJson.put("assigneeType", this.assigneeType);
	}
	if (this.assignee != null) {
		executionJson.put("assignee", this.assignee);
	}
	if (this.issues != null) {
		executionJson.put("issues", this.issues);
	}
	if (this.issueId != null) {
		executionJson.put("issueId", this.issueId);
	}
	if (this.defectList != null) {
		executionJson.put("defectList", this.defectList);
	}
	if (this.updateDefectList != null) {
		executionJson.put("updateDefectList", this.updateDefectList);
	}
	if (this.comment != null) {
		executionJson.put("comment", this.comment);
	}
	if (this.executions != null) {
		executionJson.put("executions", this.executions);
	}
	if (this.issueIdOrKeys != null) {
		executionJson.put("issueIdOrKeys", this.issueIdOrKeys);
	}
	return executionJson.toString();
	}
	
}
