package com.thed.zephyr.model.jira;

import org.json.JSONObject;

public class Component {
		private String name;
		private String description;
		private String assigneeType;
		private String project;
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
		public String getAssigneeType() {
			return assigneeType;
		}
		public void setAssigneeType(String assigneeType) {
			this.assigneeType = assigneeType;
		}
		public String getProject() {
			return project;
		}
		public void setProject(String project) {
			this.project = project;
		}
		public String toString() {
			JSONObject json = new JSONObject();
			json.put("name", this.name);
			json.put("description", this.description);
			json.put("assigneeType", this.assigneeType);
			json.put("project", this.project);
			return json.toString();
	   }
	}


