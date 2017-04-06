/**
 * Created by manoj.behera on 15-Nov-2016.
 */
package com.thed.zephyr.model;

import java.util.List;

import org.json.JSONObject;

/**
 * @author manoj.behera 15-Nov-2016
 *
 */
public class Teststep {
	private String id;
	private Long orderId;
	private Long projectId;
	private Long issueId;
	private String step;
	private List<String> stepList;
	private String data;
	private List<String> dataList;
	private String result;
	private List<String> resultList;
	private String createdBy;
	private String createdOn;
	private int noOfTeststeps;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setStepList(List<String> stepList) {
		this.stepList = stepList;
	}

	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}

	public void setResultList(List<String> resultList) {
		this.resultList = resultList;
	}

	public void setNoOfTeststeps(int noOfTeststeps) {
		this.noOfTeststeps = noOfTeststeps;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}


	@Override
	 public String toString() {
	  JSONObject teststepJson = new JSONObject();
	  if(this.id != null){
	   teststepJson.put("id", this.id);
	  }
	  if(this.noOfTeststeps != 0){
		   teststepJson.put("noOfTeststeps", this.noOfTeststeps);
	  }
	  if(this.projectId != null){
	   teststepJson.put("projectId", this.projectId);
	  }
	  if(this.orderId != null){
	   teststepJson.put("orderId", this.orderId);
	  }
	  if(this.issueId != null){
	   teststepJson.put("issueId", this.issueId);
	  }
	  if(this.step != null){
	   teststepJson.put("step", this.step);
	  }
	  if(this.stepList != null ){
		   teststepJson.put("stepList", this.stepList);
	  }
	  if(this.data != null){
	   teststepJson.put("data", this.data);
	  }
	  if(this.dataList != null ){
		   teststepJson.put("dataList", this.dataList);
	  }
	  if(this.result != null){
	   teststepJson.put("result", this.result);
	  }
	  if(this.resultList != null){
		   teststepJson.put("resultList", this.resultList);
	  }
	  if(this.createdBy != null){
	   teststepJson.put("createdBy", this.createdBy);
	  }
	  
	  return teststepJson.toString();
	 }
	
}
