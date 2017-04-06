package com.thed.zephyr.model.jira;

import org.json.JSONObject;

public class Filter {
	private String name;
	private String description;
	private String jql;
	private String favourite;
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
	public String getJql() {
		return jql;
	}
	public void setJql(String jql) {
		this.jql = jql;
	}
	public String getFavourite() {
		return favourite;
	}
	public void setFavourite(String favourite) {
		this.favourite = favourite;
	}
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("name", this.name);
		json.put("description", this.description);
		json.put("jql", this.jql);
		json.put("favourite", this.favourite);
		return json.toString();
   }
}

