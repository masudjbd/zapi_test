package com.thed.zephyr.model;

import java.sql.Array;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Znav {
		private String userName;
		private String executionFilterId;
		private List<Object>  columnItemBean;
		private String filterIdentifier;
		private boolean visible;
		private int orderId;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getExecutionFilterId() {
			return executionFilterId;
		}
		public void setExecutionFilterId(String executionFilterId) {
			this.executionFilterId = executionFilterId;
		}
		public List<Object>  getColumnItemBean() {
			return columnItemBean;
		}
		public void setColumnItemBean(List<Object> columnItemBean) {
			this.columnItemBean = columnItemBean;
		}
		public String getFilterIdentifier() {
			return filterIdentifier;
		}
		public void setFilterIdentifier(String filterIdentifier) {
			this.filterIdentifier = filterIdentifier;
		}
		public boolean isVisible() {
			return visible;
		}
		public void setVisible(boolean visible) {
			this.visible = visible;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		@Override
		public String toString() {
			JSONObject executionJson = new JSONObject();
			executionJson.put("columnItemBean", this.columnItemBean);
			//JSONArray dummy = new JSONArray();
			//dummy.put(this.columnItemBean);
			if (userName != null) {
				executionJson.put("userName", this.userName);
			}
			executionJson.put("executionFilterId", this.executionFilterId);
			//executionJson.put("columnItemBean", dummy) ;
			return executionJson.toString();
}
}
