package com.thed.zephyr.model.jira;

import org.json.JSONObject;

public class Version {
	private String project;
	private String projectId;
	private String name;
	private String description;
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("project", this.project);
		json.put("projectId", this.projectId);
		json.put("name", this.name);
		json.put("description", this.description);
		return json.toString();
   }
	}

