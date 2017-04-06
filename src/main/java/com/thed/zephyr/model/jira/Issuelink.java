package com.thed.zephyr.model.jira;

import org.json.JSONArray;
import org.json.JSONObject;

public class Issuelink {
	private String linktype;
	private String inwardIssue;
	private String outwardIssue;
	public String getLinktype() {
		return linktype;
	}
	public void setLinktype(String linktype) {
		this.linktype = linktype;
	}
	public String getInwardIssue() {
		return inwardIssue;
	}
	public void setInwardIssue(String inwardIssue) {
		this.inwardIssue = inwardIssue;
	}
	public String getOutwardIssue() {
		return outwardIssue;
	}
	public void setOutwardIssue(String outwardIssue) {
		this.outwardIssue = outwardIssue;
	}
	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("type", new JSONObject().put("name", this.linktype));
		json.put("inwardIssue", new JSONObject().put("key", this.inwardIssue));
		json.put("outwardIssue", new JSONObject().put("key", this.outwardIssue));
		return json.toString();
}
}