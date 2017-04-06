package com.thed.zephyr.model.jira;

import org.json.JSONObject;

public class Project {
	private String key;
	private String name;
	private String projectTypeKey;
	private String projectTemplateKey;
	private String lead;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProjectTypeKey() {
		return projectTypeKey;
	}
	public void setProjectTypeKey(String projectTypeKey) {
		this.projectTypeKey = projectTypeKey;
	}
	public String getProjectTemplateKey() {
		return projectTemplateKey;
	}
	public void setProjectTemplateKey(String projectTemplateKey) {
		this.projectTemplateKey = projectTemplateKey;
	}
	public String getLead() {
		return lead;
	}
	public void setLead(String lead) {
		this.lead = lead;
	}
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("key", this.key);
		json.put("name", this.name);
		json.put("projectTypeKey", this.projectTypeKey);
		json.put("projectTemplateKey", this.projectTemplateKey);
		json.put("lead", this.lead);
		return json.toString();
   }
}


