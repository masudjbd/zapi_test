/**
 * Created by manoj.behera on 17-Nov-2016.
 */
package com.thed.zephyr.model;

import java.util.List;

import org.json.JSONObject;

/**
 * @author manoj.behera 17-Nov-2016
 *
 */
public class Stepresult {

	private Long issueId;
	private long executionId;
	private String stepId;
	private String comment;
	private int status;
	private List<String> defectList;
	private String updateDefectList;
	public String getUpdateDefectList() {
		return updateDefectList;
	}
	public void setUpdateDefectList(String updateDefectList) {
		this.updateDefectList = updateDefectList;
	}
	
	public void setdefectList(List<String> defectList) {
		this.defectList = defectList;
	}
	
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}
	
	public void setExecutionId(long executionId) {
		this.executionId = executionId;
	}
	
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @author Created by manoj.behera on 17-Nov-2016.
	 */
	@Override
	public String toString() {
		JSONObject stepresultJson = new JSONObject();
//		stepresultJson.put("stepId", this.stepId);
//		stepresultJson.put("executionId", this.executionId);
//		stepresultJson.put("issueId", this.issueId);
//		stepresultJson.put("status", this.status);
		if(this.defectList != null){
			stepresultJson.put("defectList", this.defectList);
			stepresultJson.put("updateDefectList", this.updateDefectList);
		}
		
		/*if(this.status != 0){
			stepresultJson.put("status", new JSONObject().put("id", this.status));
		}*/
		if(this.status != 0){
			stepresultJson.put("status", this.status);
		}
		if(this.comment != null){
			stepresultJson.put("comment", this.comment);
		}
		/*if(this.defects != null){
			stepresultJson.put("defects", this.defects);
		}*/
		return stepresultJson.toString();
	}
	
}
