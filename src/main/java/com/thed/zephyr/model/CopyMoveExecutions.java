/**
 *
 */
package com.thed.zephyr.model;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

public class CopyMoveExecutions {

	private String[] executions = null;
	private Long projectId;
	private Long versionId;
	private Boolean clearDefectMappingFlag;
	private Boolean clearStatusFlag;

	public void setExecutions (String[] executions) {
		this.executions = executions;
	}

	public void setProjectId (Long projectId) {
		this.projectId = projectId;
	}

	public void setVersionId (Long versionId) {
		this.versionId = versionId;
	}

	public void setClearDefectMappingFlag (Boolean clearDefectMappingFlag) {
		this.clearDefectMappingFlag = clearDefectMappingFlag;
	}

	public void setClearStatusFlag (Boolean clearStatusFlag) {
		this.clearStatusFlag = clearStatusFlag;
	}

	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		if(executions!=null) {
			json.put("executions",new JSONArray(Arrays.asList(this.executions)));
		}
		json.put("projectId", this.projectId);
		json.put("versionId", this.versionId);
		json.put("clearDefectMappingFlag", this.clearDefectMappingFlag);
		json.put("clearStatusFlag", this.clearStatusFlag);
		return json.toString();
	}

}
