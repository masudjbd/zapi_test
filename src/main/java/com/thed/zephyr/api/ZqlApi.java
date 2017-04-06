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
public interface ZqlApi {

	Response getClauses(RequestSpecification basicAuth);

	Response executeSearch(RequestSpecification basicAuth, String zqlQuery);

	Response autoCompleteZQLJson(RequestSpecification basicAuth);

	Response getZqlAutocompleteApi(RequestSpecification basicAuth, String fieldName, String fieldValue);

	}
