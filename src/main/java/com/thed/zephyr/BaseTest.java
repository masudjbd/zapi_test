package com.thed.zephyr;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import com.relevantcodes.extentreports.ExtentReports;
import com.thed.zephyr.service.ZAPIApiService;
import com.thed.zephyr.service.jira.JiraApiService;
import com.thed.zephyr.util.RestUtils;

/**
 * @author manoj.behera 14-Nov-2016
 *
 */
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})
public class BaseTest extends AbstractTestNGSpringContextTests {
	protected static boolean isInit = false ;
	protected static RequestSpecification basicAuth = null;
	protected static final boolean testEnabled = true;

	protected static ExtentReports extentReport = null;
	


	@Autowired
	protected ZAPIApiService zapiService;

	@Autowired
	protected JiraApiService jiraService;


	public BaseTest() {
		init();
	}

	public static void init() {
		if (isInit) {
			return ;
		}
		new Config();	// initialization
		isInit = true ;
		
	}
	
	/*=========================================================
	 * TEST LIFECYCLE METHODS
	 *=======================================================*/
	
	/*=========================================================
	 * COMMON METHODS
	 *=======================================================*/
	

	/**
	 * beforeSuite() will set start the report, set contentType, set base url and generate basic auth
	 * Created by manoj.behera on 14-Nov-2016.
	 */
	@BeforeSuite
	public void beforeSuite(){
		extentReport = new ExtentReports("reports" + File.separator + "ExtentReportsTestNG.html", true);
		RestUtils.setContentType(ContentType.JSON);
		RestUtils.setBaseURI(Config.getValue("jiraBaseUrl"));
//		RestUtils.setBasePath("/rest/zapi/latest"); //Setup Base Path
		basicAuth = RestUtils.basicAuthRequest(Config.getValue("adminUserName"), Config.getValue("adminPassword"));
	}
	/**
	 * afterSuite() will flush the report.
	 * Created by manoj.behera on 14-Nov-2016.
	 */
	@AfterSuite
	public void afterSuite(){
		extentReport.flush();
	}
}
