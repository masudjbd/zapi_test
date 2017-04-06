package com.thed.zephyr.model;

import org.json.JSONObject;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
public class Cycle {

	
	private Long projectId;
	private Long versionId;
	private String name;
	private String description;
	private String build;
	private String environment;
	private String startDate;
	private String endDate;
	private String id;
	private Long sprintId;
	private String clonedCycleId;
	
	
	public Cycle() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the clonedCycleId
	 * Created by manoj.behera on 24-Jan-2017.
	 */
	public Cycle(Long projectId, Long versionId, String name, String description ) {
		projectId = this.projectId ;
		versionId = this.versionId;
		name = this.name;
		description = this.description;
	}
	
	public String getClonedCycleId() {
		return clonedCycleId;
	}
	
	public void setClonedCycleId(String clonedCycleId) {
		this.clonedCycleId = clonedCycleId;
	}
	
	public void setSprintId(Long sprintId) {
		this.sprintId = sprintId;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	
	public Long getVersionId() {
		return versionId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getBuild() {
		return build;
	}
	
	public String getEnvironment() {
		return environment;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public String getId() {
		return id;
	}
	
	public Long getSprintId() {
		return sprintId;
	}
	
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setBuild(String build) {
		this.build = build;
	}
	
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public void setId(String cycleId) {
		this.id = cycleId;
	}
	
	@Override
	public String toString() {
		JSONObject cycleJson = new JSONObject();
		cycleJson.put("projectId", this.projectId);
		cycleJson.put("versionId", this.versionId);
		cycleJson.put("name", this.name);
		if(this.description != null || this.description != ""){
			cycleJson.put("description", this.description);
		}
		if(this.build != null || this.build != ""){
			cycleJson.put("build", this.build);
		}
		if(this.environment != null || this.environment != ""){
			cycleJson.put("environment", this.environment);
		}
		if(this.startDate != null || this.startDate != ""){
			cycleJson.put("startDate", this.startDate);
		}
		if(this.endDate != null || this.endDate != ""){
			cycleJson.put("endDate", this.endDate);
		}
		if(this.id != null || this.id != ""){
			cycleJson.put("id", this.id);
		}
		if(this.clonedCycleId != null || this.clonedCycleId != ""){
			cycleJson.put("clonedCycleId", this.clonedCycleId);
		}
		if(this.sprintId != null ){
			cycleJson.put("sprintId", this.sprintId);
		}
		return cycleJson.toString();
	}
}
