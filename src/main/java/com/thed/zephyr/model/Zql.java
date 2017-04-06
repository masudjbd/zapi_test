/**
 *
 */
package com.thed.zephyr.model;

import org.json.JSONObject;

/**
 * 
 *
 */
public class Zql {

	private String zqlQuery;
	private int offset;
	private int maxRecords;

	public String getZqlQuery() {
		return zqlQuery;
	}

	public void setZqlQuery(String zqlQuery) {
		this.zqlQuery = zqlQuery;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getMaxRecords() {
		return maxRecords;
	}

	public void setMaxRecords(int maxRecords) {
		this.maxRecords = maxRecords;
	}

	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("zqlQuery", this.zqlQuery);
		json.put("offset", this.offset);
		json.put("maxRecords", this.maxRecords);
		return json.toString();
	}

}
