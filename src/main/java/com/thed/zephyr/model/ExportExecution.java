/**
 *
 */
package com.thed.zephyr.model;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Praveenkumar
 *
 */
public class ExportExecution {

	private String exportType;
	private String expand = "testSteps";
	private String[] executions = {""};
	private int startIndex = 0;
	private boolean maxAllowed = true;
	private String zqlQuery = "";

	public void setExportType(String exportType) {
		this.exportType = exportType;
	}

	public void setExpand(String expand) {
		this.expand = expand;
	}

	public void setExecutions(String[] executions) {
		this.executions = executions;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public void setMaxAllowed(boolean maxAllowed) {
		this.maxAllowed = maxAllowed;
	}

	public void setzqlQuery(String zqlQuery) {
		this.zqlQuery = zqlQuery;
	}

	@Override
	public String toString() {
		JSONObject executionJson = new JSONObject();
		executionJson.put("exportType", this.exportType);
		executionJson.put("expand", this.expand);
		executionJson.put("executions",new JSONArray(Arrays.asList(this.executions)));
		executionJson.put("startIndex", this.startIndex);
		executionJson.put("maxAllowed", this.maxAllowed);
		executionJson.put("zqlQuery", this.zqlQuery);
		return executionJson.toString();
	}

}
