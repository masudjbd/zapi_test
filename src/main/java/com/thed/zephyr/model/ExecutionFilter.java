/**
 * Created by manoj.behera on 24-Jan-2017.
 */
package com.thed.zephyr.model;

import org.json.JSONObject;

/**
 * @author manoj.behera 24-Jan-2017
 *
 */
public class ExecutionFilter {
	private String query;
	private String filterName;
	private String description;
	private Boolean isFavorite;
	private Integer sharePerm;
	private Long id;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	public Integer getSharePerm() {
		return sharePerm;
	}

	public void setSharePerm(int sharePerm) {
		this.sharePerm = sharePerm;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("query", this.query);
		json.put("filterName", this.filterName);
		json.put("description", this.description);
		json.put("isFavorite", this.isFavorite);
		json.put("sharePerm", this.sharePerm);
		json.put("id", this.id);
		if(this.description != null || this.description != ""){
			json.put("description", this.description);
		}
		if(this.isFavorite != null){
			json.put("isFavorite", this.isFavorite);
		}
		if(this.sharePerm != null){
			json.put("sharePerm", this.sharePerm);
		}
		return json.toString();
	}
}
