/**
 * Created by manoj.behera on 24-Jan-2017.
 */
package com.thed.zephyr.api;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 24-Jan-2017
 *
 */
public interface IndexApi {

	
	Response indexExecution(RequestSpecification basicAuth);

	Response indexStatus(RequestSpecification basicAuth, Long token);

}
