package com.thed.zephyr.model.jira;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * @author manoj.behera 24-Jan-2017
 *
 */
public class Issue {
	private String projectId;
	private String summary;
	private String issuetype;
	private String priority;
	private String reporter;
	private String environment;
	private List<String> versions;
	//private List<String> fixVersions;
	private String fixVersions;
	
	
	
	public Issue(String projectId, String summary, String issuetype, String priority, String reporter) {
		projectId = this.projectId;
		summary = this.summary;
		issuetype = this.issuetype;
		priority = this.priority;
		reporter = this.reporter;
	}
	public Issue() {
		// TODO Auto-generated constructor stub
	}
	
	public List<String> getVersions() {
		return versions;
	}
	
	public void setVersions(List<String> versions) {
		this.versions = versions;
	}
	
	public String getFixVersions() {
		return fixVersions;
	}
	
	public void setFixVersions(String fixVersions) {
		this.fixVersions = fixVersions;
	}
	
	public String getProject() {
		return projectId;
	}

	public void setProject(String projectId) {
		this.projectId = projectId;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getIssuetype() {
		return issuetype;
	}
	
	public void setIssuetype(String issuetype) {
		this.issuetype = issuetype;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getReporter() {
		return reporter;
	}
	
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	
	public String getEnvironment() {
		return environment;
	}
	
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		JSONObject dummy = new JSONObject();
		dummy.put("project", new JSONObject().put("id", this.projectId));
		dummy.put("summary", this.summary);
		dummy.put("issuetype", new JSONObject().put("id", this.issuetype));
		dummy.put("priority", new JSONObject().put("id", this.priority));
		dummy.put("reporter", new JSONObject().put("name", this.reporter));
		dummy.put("fixVersions", new JSONArray().put(0, (new JSONObject().put("id", this.fixVersions))));
		if(this.fixVersions == null ){
			dummy.put("fixVersions", this.fixVersions);
		}
/*//		if (this.fixVersions != null) {
//			executionJson.put("executions", this.executions);
//		}
		if(this.fixVersions != null){
			if(this.fixVersions.size() == 1 ){
				dummy.put("fixVersions", new JSONObject().put("id", this.fixVersions.get(0)));
			}else{
				JSONObject jo = new JSONObject();
				JSONArray jas = new JSONArray();
				
				for (int i = 0; i < this.fixVersions.size(); i++) {
					jo.put("id", this.fixVersions.get(i));
					jas.put(jo);
					System.out.println(jas);
				}
				
				dummy.put("fixVersions", jas);
			}
		}
		
		if(this.environment != null ){
			dummy.put("environment", this.environment);
		}*/
		json.put("fields", dummy) ;
		return json.toString();
	}
}