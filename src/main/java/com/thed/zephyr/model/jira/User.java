package com.thed.zephyr.model.jira;

import java.util.List;

import org.json.JSONObject;

public class User {
	private String name;
	private String password;
	private String emailAddress;
	private String displayName;
	public List<String> applicationKeys;
	public List<String> getApplicationKeys() {
		return applicationKeys;
	}
	public void setApplicationKeys(List<String> applicationKeys) {
		this.applicationKeys = applicationKeys;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("name", this.name);
		json.put("password", this.password);
		json.put("emailAddress", this.emailAddress);
		json.put("displayName", this.displayName);
		json.put("applicationKeys", this.applicationKeys);
		return json.toString();
   }
}
