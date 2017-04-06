package com.thed.zephyr.model;

import java.util.List;

import org.json.JSONObject;

/**
 * @author priyanka.bishi
 *
 */

public class BulkExecution {
		private String status;
		private String stepStatus;
		private boolean clearDefectMappingFlag;
		private boolean clearStatusFlag;
		private boolean clearAssignmentsFlag;
		public boolean getClearStatusFlag() {
			return clearStatusFlag;
		}
		public void setClearStatusFlag(boolean clearStatusFlag) {
			this.clearStatusFlag = clearStatusFlag;
		}
		public boolean getClearAssignmentsFlag() {
			return clearAssignmentsFlag;
		}
		public void setClearAssignmentsFlag(boolean clearAssignmentsFlag) {
			this.clearAssignmentsFlag = clearAssignmentsFlag;
		}
		public String getProjectId() {
			return projectId;
		}
		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}
		public String getVersionId() {
			return versionId;
		}
		public void setVersionId(String versionId) {
			this.versionId = versionId;
		}
		private String testStepStatusChangeFlag;
		private List<String> executions;
		private List<String> defects;
		private String assigneeType;
		private String assignee;
		private String projectId;
		private String versionId;
		public String getAssigneeType() {
			return assigneeType;
		}
		public void setAssigneeType(String assigneeType) {
			this.assigneeType = assigneeType;
		}
		public String getAssignee() {
			return assignee;
		}
		public void setAssignee(String assignee) {
			this.assignee = assignee;
		}
		//private Long projectId;
		//private Long issueId;
		//private List<Long> issueIds;
		//private List<String> issues;
		//private String cycleId;
		//private String fromCycleId;
		//private List<String> cycleIds;
		//private Long versionId;
		//private Long fromVersionId;
		//private String executionId;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getStepStatus() {
			return stepStatus;
		}
		public void setStepStatus(String stepStatus) {
			this.stepStatus = stepStatus;
		}
		public boolean getClearDefectMappingFlag() {
			return clearDefectMappingFlag;
		}
		public void setClearDefectMappingFlag(boolean clearDefectMappingFlag) {
			this.clearDefectMappingFlag = clearDefectMappingFlag;
		}
		public String getTestStepStatusChangeFlag() {
			return testStepStatusChangeFlag;
		}
		public void setTestStepStatusChangeFlag(String testStepStatusChangeFlag) {
			this.testStepStatusChangeFlag = testStepStatusChangeFlag;
		}
		public List<String> getExecutions() {
			return executions;
		}
		public void setExecutions(List<String> executions) {
			this.executions = executions;
		}
						
		
	@Override
	public String toString() {
		JSONObject bulkExecutionJson = new JSONObject();
		bulkExecutionJson.put("executions", this.executions);
		bulkExecutionJson.put("status", this.status);
		bulkExecutionJson.put("clearDefectMappingFlag", this.clearDefectMappingFlag);
		bulkExecutionJson.put("testStepStatusChangeFlag", this.testStepStatusChangeFlag);
		bulkExecutionJson.put("assigneeType", this.assigneeType);
		bulkExecutionJson.put("assignee", this.assignee);
		if (this.defects != null) {
		bulkExecutionJson.put("defects", this.defects);
		}
		bulkExecutionJson.put("projectId", this.projectId);
		bulkExecutionJson.put("versionId", this.versionId);
		bulkExecutionJson.put("clearStatusFlag", this.clearStatusFlag);
		bulkExecutionJson.put("clearAssignmentsFlag", this.clearAssignmentsFlag);
		return bulkExecutionJson.toString();
	}
	public List<String> getDefects() {
		return defects;
	}
	public void setDefects(List<String> defects) {
		this.defects = defects;
	}
}