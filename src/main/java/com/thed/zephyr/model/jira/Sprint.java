package com.thed.zephyr.model.jira;

import java.util.List;

import org.json.JSONObject;

public class Sprint {
	private List<String> idOrKeys;
	private int sprintId;
	public List<String> getIdOrKeys() {
		return idOrKeys;
	}
	public void setIdOrKeys(List<String> idOrKeys) {
		this.idOrKeys = idOrKeys;
	}
	public int getSprintId() {
		return sprintId;
	}
	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}
	
	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("idOrKeys", this.idOrKeys);
		json.put("sprintId", this.sprintId);
		return json.toString();
}
}