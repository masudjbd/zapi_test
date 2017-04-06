/**
 * Created by manoj.behera on 14-Nov-2016.
 */
package com.thed.zephyr.api;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
public interface FilterApi {

	
	Response loggedinUser(RequestSpecification basicAuth);

	Response createExecutionfilter(RequestSpecification basicAuth, String payLoad);

	Response updateExecutionfilter(RequestSpecification basicAuth, String payLoad);

	Response renameExecutionfilter(RequestSpecification basicAuth, String payLoad);

	Response copyExecutionfilter(RequestSpecification basicAuth, String payLoad);

	Response getfilterById(RequestSpecification basicAuth, String filterId);

	Response searchExecutionfilter(RequestSpecification basicAuth, String payLoad);

	Response toggleFavouriteFilter(RequestSpecification basicAuth, String payLoad);

	Response deleteFilter(RequestSpecification basicAuth, String filterId);

	Response getTestByFilterId(RequestSpecification basicAuth, Long filterId);

	Response getFavFilter(RequestSpecification basicAuth, String fav);

	Response searchFilter(RequestSpecification basicAuth, String query);

	Response createColumnSelection(RequestSpecification basicAuth,
			String payload);

	Response getColumnSelection(RequestSpecification basicAuth,
			long executionFilterId);

	Response updateColumnSelection(RequestSpecification basicAuth, long id,
			String payload);

	Response quickSearchZQLFilter(RequestSpecification basicAuth,String fieldName);

	Response getExecutionDetailsInZql(RequestSpecification basicAuth, long id, String zql);

	

}
