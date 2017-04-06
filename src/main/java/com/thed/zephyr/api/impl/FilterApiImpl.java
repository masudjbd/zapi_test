/**
 * Created by manoj.behera on 14-Nov-2016.
 */
package com.thed.zephyr.api.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.thed.zephyr.Config;
import com.thed.zephyr.api.FilterApi;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@Service("executionFilterApi")
public class FilterApiImpl implements FilterApi {
	@Override
	public Response loggedinUser(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/zql/executionFilter/user";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}

	@Override
	public Response createExecutionfilter(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/zql/executionFilter";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}

	@Override
	public Response updateExecutionfilter(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/zql/executionFilter/update";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}

	@Override
	public Response renameExecutionfilter(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/zql/executionFilter/rename";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}

	@Override
	public Response copyExecutionfilter(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/zql/executionFilter/copy";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}

	@Override
	public Response getfilterById(RequestSpecification basicAuth, String filterId) {
		String api = "/rest/zapi/latest/zql/executionFilter/" + filterId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}

	@Override
	public Response searchExecutionfilter(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/zql/executionFilter/search?filterName="+payLoad;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().get(api);
	}

	@Override
	public Response toggleFavouriteFilter(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/zql/executionFilter/toggleFav";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}

	@Override
	public Response deleteFilter(RequestSpecification basicAuth, String filterId) {
		String api = "/rest/zapi/latest/zql/executionFilter/" + filterId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).delete(api);
	}

	public Response getFilters(RequestSpecification basicAuth) {
		String api = "/rest/zapi/latest/picker/filters";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);

	}
	
	@Override
	public Response getFavFilter(RequestSpecification basicAuth, String fav) {
		String api = "/rest/zapi/latest/zql/executionFilter?fav="+fav;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).get(api);
	}
	
	@Override
	public Response getTestByFilterId(RequestSpecification basicAuth, Long filterId) {
		String api = "/rest/zapi/latest/test/mySearches/" +filterId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	
	@Override
	public Response searchFilter(RequestSpecification basicAuth, String query) {
		String api = "/rest/zapi/latest/picker/filters?query="+query;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		URI uri = null;
		try {
			uri = new URI(Config.getValue("jiraBaseUrl")+api);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return basicAuth.get(uri);
	}

	@Override
	public Response createColumnSelection(RequestSpecification basicAuth, String payLoad) {
		String api = "/rest/zapi/latest/znav/createColumnSelection";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().post(api);
	}
	
	@Override
	public Response getColumnSelection(RequestSpecification basicAuth, long executionFilterId) {
		String api = "/rest/zapi/latest/znav/availableColumns?executionFilterId="+executionFilterId;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	
	@Override
	public Response updateColumnSelection(RequestSpecification basicAuth, long id,
			String payLoad) {
		String api = "/rest/zapi/latest/znav/updateColumnSelection/"+id;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).body(payLoad).when().put(api);
	}
	
	public Response quickSearchZQLFilter(RequestSpecification basicAuth, String fieldName) {
		String api = "/rest/zapi/latest/zql/executionFilter/quickSearch?query="+fieldName;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
	
	@Override
	public Response getExecutionDetailsInZql(RequestSpecification basicAuth, long id, String zql) {
		String api = "/rest/zapi/latest/execution/navigator/"+id+"?zql="+zql;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return basicAuth.headers(headers).when().get(api);
	}
}
