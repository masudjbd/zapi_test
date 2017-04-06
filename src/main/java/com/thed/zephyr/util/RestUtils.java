
package com.thed.zephyr.util;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.testng.Assert;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author manoj.behera
 *
 */
public class RestUtils {
	//Global Setup Variables
    public static String path; //Rest request path
    
    /**
     * @param userName
     * @param password
     * @return RequestSpecification
     */
    public static RequestSpecification basicAuthRequest(String userName,String password){
		return given().auth().preemptive().basic(userName,password);
	}

    /**
     * ***Sets Base URI***
     * Before starting the test, we should set the RestAssured.baseURI
     * @param baseURI
     */
    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }
    /**
     * ***Sets base path***
     * Before starting the test, we should set the RestAssured.basePath
     * @param basePathTerm
     */
    public static void setBasePath(String basePathTerm){
         RestAssured.basePath = basePathTerm;
     }
    /**
     * ***Reset Base URI (after test)***
     * After the test, we should reset the RestAssured.baseURI
     */
    public static void resetBaseURI (){
         RestAssured.baseURI = null;
     }
    /**
     * ***Reset base path (after test)***
     * After the test, we should reset the RestAssured.basePath
     */
    public static void resetBasePath(){
          RestAssured.basePath = null;
      }
    /**
     * ***Sets ContentType***
     * We should set content type as JSON or XML before starting the test
     * @param Type
     */
    public static void setContentType (ContentType Type){
          given().contentType(Type);
    }
      /*
       ***Returns response***
       We send "path" as a parameter to the Rest Assured'a "get" method
       and "get" method returns response of API
       */
       public static Response getResponse() {
           //System.out.print("path: " + path +"\n");
           return get(path);
       }
        /**
         * ***Returns JsonPath object***
         * First convert the API's response to String type with "asString()" method.
         * Then, send this String formatted json response to the JsonPath class and return the JsonPath
         * @param res
         * @return JsonPath
         * @author Created by manoj.behera on 14-Nov-2016.
         */
        public static JsonPath getJsonPath (Response res) {
            String json = res.asString();
            //System.out.print("returned json: " + json +"\n");
            return new JsonPath(json);
        }
        /**
         * Verify the http response status returned. Check Status Code is 200?
         * We can use Rest Assured library's response's getStatusCode method
         * @param response
         */
        public static void ValidateStatusIs200(Response response) {
            Assert.assertEquals(response.getStatusCode(), 200, "Status Check Failed!, Status returned : "+response.getStatusCode());
            System.out.println("API Response status Validated.");
        }
        /**
         * Verify the http response status returned. Check Status Code is 201?
         * We can use Rest Assured library's response's getStatusCode method
         * @param response
         */
        public static void ValidateStatusIs201(Response response) {
            Assert.assertEquals(response.getStatusCode(), 201, "Status Check Failed!, Status returned : "+response.getStatusCode());
            System.out.println("API Response status Validated.");
        }
        /**
         * Verify the http response status returned. Check Status Code is 204?
         * We can use Rest Assured library's response's getStatusCode method
         * @param response
         */
        public static void ValidateStatusIs204(Response response) {
            Assert.assertEquals(response.getStatusCode(), 204, "Status Check Failed!, Status returned : "+response.getStatusCode());
            System.out.println("API Response status Validated.");
        }
        /**
         * @param response
         */
        public static void validateStatusIs400(Response response) {
            Assert.assertEquals(response.getStatusCode(), 400, "Status Check Failed!, Status returned : "+response.getStatusCode());
            System.out.println("API Response status Validated.");
        }
        /**
         * @param response
         */
        public static void validateStatusIs500(Response response) {
            Assert.assertEquals(response.getStatusCode(), 500, "Status Check Failed!, Status returned : "+response.getStatusCode());
            System.out.println("API Response status Validated.");
        }
        /**
         * @param propertiesFile
         * @return Properties file
         * @throws Throwable
         */
        public static Properties propertiesSetup(String propertiesFile) throws Throwable{
    		Properties properties=null;
    		FileInputStream fis;
    		try{
    			fis=new FileInputStream(propertiesFile);
    			properties=new Properties();
    			properties.load(fis);
    			
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		return properties;
    	}
        /**
         * @param path
         * @return the File
         * @throws URISyntaxException
         */
        public static File getPropertyFilePath(String path) throws URISyntaxException {
            URL url = path.getClass().getResource(path);
    	    File inputFile = new File(url.toURI());
    	    return inputFile ;
    	}
    	/**
    	 * @param path
    	 * @return Properties
    	 */
    	public static Properties loadProperties(String path) {
    		Properties properties = new Properties();
    		FileInputStream fis = null ;
    		try {
    			File file = getPropertyFilePath(path); 
    			fis = new FileInputStream(file);
    			properties.load(fis);
    			fis.close();
    		} catch (Exception e) {
    			return null ;
    		} finally {
    			if (fis != null) {
    				try {
    					fis.close();
    				} catch (Exception e) {
    					;
    				}
    			}
    		}
    		return properties ;
    	}
}
