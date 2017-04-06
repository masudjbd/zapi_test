/**
 *
 */
package com.thed.zephyr.model;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Praveenkumar
 *
 */
public class ExportTraceability {

	private String exportType;
	private List<Long> defectIdList;
	private List<Long> requirementIdList;
	private Long versionId;

	public String getExportType() {
		return exportType;
	}

	public void setExportType(String exportType) {
		this.exportType = exportType;
	}

	public List<Long> getDefectIdList() {
		return defectIdList;
	}

	public void setDefectIdList(List<Long> defectIdList) {
		this.defectIdList = defectIdList;
	}

	public List<Long> getRequirementIdList() {
		return requirementIdList;
	}

	public void setRequirementIdList(List<Long> requirementIdList) {
		this.requirementIdList = requirementIdList;
	}

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}


	@Override
	public String toString() {
		JSONObject exportJson = new JSONObject();
		exportJson.put("exportType", this.exportType);
		if ((this.defectIdList != null)) {
			//exportJson.put("defectIdList",new JSONArray(Arrays.asList(this.defectIdList)));
			exportJson.put("defectIdList",this.defectIdList);
		}
		if ((this.requirementIdList != null)) {
			//exportJson.put("requirementIdList",new JSONArray(Arrays.asList(this.requirementIdList)));
			exportJson.put("requirementIdList",this.requirementIdList);
		}
		exportJson.put("versionId", this.versionId);
		return exportJson.toString();
	}
}
	