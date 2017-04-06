/**
 * Created by manoj.behera on 16-Nov-2016.
 */
package com.thed.zephyr.api;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera 16-Nov-2016
 *
 */
public interface JobProgressApi {

	Response jobProgress(RequestSpecification basicAuth, String jobProgressToken);


}
