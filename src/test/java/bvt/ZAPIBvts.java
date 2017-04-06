/**
 * Created by manoj.behera on 13-Feb-2017.
 */
package java.bvt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thed.zephyr.BaseTest;
import com.thed.zephyr.Config;
import com.thed.zephyr.model.BulkExecution;
import com.thed.zephyr.model.Cycle;
import com.thed.zephyr.model.Execution;
import com.thed.zephyr.model.ExecutionFilter;
import com.thed.zephyr.model.ExportTraceability;
import com.thed.zephyr.model.Stepresult;
import com.thed.zephyr.model.Teststep;
import com.thed.zephyr.model.Znav;
import com.thed.zephyr.model.jira.Issue;
import com.thed.zephyr.model.jira.Issuelink;
import com.thed.zephyr.model.jira.Sprint;
import com.thed.zephyr.util.RestUtils;
import com.thed.zephyr.startupdata.ApiTest;

/**
 * @author manoj.behera 13-Feb-2017
 *
 */
@SuppressWarnings("ALL")
public class ZAPIBvts extends BaseTest {
	
String issueKey = null;
	String issueKey2=null;
	String issueKey3=null;
	String issueKey4=null;
	String issueKey5=null;
	long issueId ;
	long issueId1;
	long issueId2;
	long issueId3;
	long issueId4;
	String cycleId = null;
	String cycleId1=null;
	String cycleId2 = null;
	String cycleId3 =null;
	String cycleId4 =null;
	String cycleId5 =null;
	String cycleId6 =null;
	String cycleId7=null;	
	String id1=null;
	String executionId1=null;
	String executionId2=null;
	String executionId3=null;
	String executionId4=null;
	long executionId5;
	long executionId6;
	String executionId7=null;
	String executionId8=null;
	long executionfilterId;
	long userexefilterId;
	long exefilterid1;
	String StepId=null;	
	long StepresId;
	long entityId;	
	String testAttachmentId = null;
	String teststepAttachmentId = null;
	long columnSelectorId;
	public String payload = null;
	public JSONObject obj = null;
	JSONObject issueJson = null;
	
	@BeforeClass
	public void beforeClass(){
//		Issue issuePayLoad = new Issue();
//		issuePayLoad.setProject(Config.getValue("project1Id"));
//		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
//		issuePayLoad.setSummary("First Test With Teststeps");
//		issuePayLoad.setPriority("3");
//		issuePayLoad.setReporter(Config.getValue("adminUserName"));
//		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
//		Assert.assertNotNull(response, "Create Issue Api Response is null.");
//
//		boolean status = jiraService.validateCreateIssueApi(response);
//		Assert.assertTrue(status, "Response Validation Failed.");
//		issueJson = new JSONObject(response.body().asString());
//		System.out.println("test steps creating for issue :" + issueJson.get("id"));
	}
	@BeforeMethod
	public void beforeMethod(){
		basicAuth = RestUtils.basicAuthRequest(Config.getValue("adminUserName"), Config.getValue("adminPassword"));
	}

	@Test(priority = 2)
	public void bvt2_getSystemInfo() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Response response = zapiService.getSystemInfo(basicAuth);
		test.log(LogStatus.PASS, "Get SystemInfo Api executed successfully.");

		boolean status = zapiService.validateSystemInfo(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	@Test(priority = 3)
	public void bvt3_getModuleInfo() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Response response = zapiService.getModuleInfo(basicAuth);
		test.log(LogStatus.PASS, "Get Moduleinfo Api executed successfully.");

		boolean status = zapiService.validateModuleInfo(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	@Test(priority = 4)
	public void bvt4_getLicenseInfo() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Response response = zapiService.getLicenseInfo(basicAuth);
		test.log(LogStatus.PASS, "Get license Api executed successfully.");

		boolean status = zapiService.validateLicenseInfo(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	@Test(priority = 5)
	public void bvt5_getProjects() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");
		Response response = zapiService.getProjects(basicAuth);
		test.log(LogStatus.PASS, "Get projects Api executed successfully.");

		Map<String, Map<String, String>> map = new HashMap<>();
		Map<String, String> project1 = new HashMap<>();
		project1.put("projectId", "10000");
		project1.put("projectName", "Project1");
		Map<String, String> project2 = new HashMap<>();
		project2.put("projectId", "10001");
		project2.put("projectName", "Project2");
		map.put("project1", project1);
		map.put("project2", project2);

		boolean status = zapiService.validateProjects(response, map);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	@Test(priority = 6)
	public void bvt6_getVersionsByProject() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");
		long projectId = Long.parseLong(Config.getValue("project1Id"));
		Response response = zapiService.getVersionsByProject(basicAuth, projectId);
		test.log(LogStatus.PASS, "Get Version by project Api executed successfully.");

		Map<String, Map<String, String>> map = new HashMap<>();
		Map<String, String> version1 = new HashMap<>();
		version1.put("value", "-1");
		version1.put("label", "Unschedule");
		Map<String, String> version2 = new HashMap<>();
		version2.put("value", "10000");
		version2.put("label", "version 1");
		Map<String, String> version3 = new HashMap<>();
		version3.put("value", "10001");
		version3.put("label", "version 2");
		Map<String, String> version4 = new HashMap<>();
		version4.put("value", "10002");
		version4.put("label", "version 3");
		Map<String, String> version5 = new HashMap<>();
		version5.put("value", "10003");
		version5.put("label", "version 4");
		Map<String, String> version6 = new HashMap<>();
		version6.put("value", "10004");
		version6.put("label", "version 5");

		map.put("version1", version1);
		map.put("version2", version2);
		map.put("version3", version3);
		map.put("version4", version4);
		map.put("version5", version5);
		map.put("version6", version6);

		boolean status = zapiService.validateVersions(response, map);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);

	}

	@Test(priority = 7)
	public void bvt7_getProjectMetadata() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");
		long projectId = Long.parseLong(Config.getValue("project1Id"));
		Response response = zapiService.getProjectMetadata(basicAuth, projectId );
		test.log(LogStatus.PASS, "Get Project Metadata Api executed successfully.");

		boolean status = zapiService.validateProjectMetadata(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	@Test(priority = 8)
	public void bvt8_getExecutionStatus() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");
		Response response = zapiService.getExecutionStatus(basicAuth);
		test.log(LogStatus.PASS, "Get ExecutionStatus Api executed successfully.");

		boolean status = zapiService.validateTestExecutionStatuses(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	@Test(priority = 9)
	public void bvt9_getTestStepExecutionStatus() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");
		Response response = zapiService.getTestStepExecutionStatus(basicAuth);
		test.log(LogStatus.PASS, "Get StepExecution Status Api executed successfully.");

		boolean status = zapiService
				.validategetTestStepExecutionStatus(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	@Test(priority=10)
	public void bvt10_getDashboardByName() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String query ="dash";
		int maxRecords = 15;
		Response response = zapiService.getDashboardByName(basicAuth ,query, maxRecords );
		test.log(LogStatus.PASS, "Get Dashboard Api executed successfully.");

		boolean status = zapiService.validategetDashboardByName(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	@Test(priority = 11)
	public void bvt11_getIssues() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");
		String query = "test";
		String currentJQL = "type=test";
		String currentIssueKey = issueJson.getString("key");
		long currentProjectId = Long.parseLong(Config.getValue("project1Id"));
		Response response = zapiService.getissue(basicAuth, query, currentJQL, currentIssueKey, currentProjectId);
		test.log(LogStatus.PASS, "Get Issues Api executed successfully.");

		boolean status = zapiService.validategetIssues(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}


	@Test(priority = 12)
	public void bvt12_createTeststep() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Issue issuePayLoad = new Issue();		
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("First Test With Teststeps");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));		
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		test.log(LogStatus.PASS, "Create Issue Api executed successfully.");

		boolean status = jiraService.validateCreateIssueApi(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		issueId = new JSONObject(response.body().asString()).getLong("id");
		System.out.println("test steps creating for issue :" + issueId);

		for (int i = 0; i < 5; i++) {
			Teststep teststepJson = new Teststep();
			teststepJson.setStep("step"+i);
			teststepJson.setData("data"+i);
			teststepJson.setResult("result"+i);

			Response response1 = zapiService.createTeststep(basicAuth, issueId, teststepJson.toString());
			Assert.assertNotNull(response1, "Create teststep Api Without WIKI Response is null.");
			test.log(LogStatus.PASS, "Create teststep Api Without WIKI executed successfully.");
			boolean status1 = zapiService.validateCreatedtestStep(response1);
			Assert.assertTrue(status1, "Response Validation Failed.");
		}
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	// Create Teststep with WIKI
	@Test(priority = 13)
	public void bvt13_createTeststepWithWiki() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Issue issuePayLoad = new Issue();		
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("First with Wiki Teststeps");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		test.log(LogStatus.PASS, "Create Issue Api executed successfully.");

		boolean status = jiraService.validateCreateIssueApi(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		issueId = new JSONObject(response.body().asString()).getLong("id");
		System.out.println("Issue id is :" + issueId);

		Teststep teststepJson = new Teststep();
		teststepJson.setStep("h1.bigheading");
		teststepJson.setData("h1.bigheading");
		teststepJson.setResult("h1.bigheading");		
		Response response1 = zapiService.createTeststep(basicAuth, issueId, teststepJson.toString());
		Assert.assertNotNull(response1, "Create teststep Api with WIKI Response is null.");
		test.log(LogStatus.PASS, "Create teststep Api With WIKI executed successfully.");

		boolean status1 = zapiService.validateCreatetestStepWithWIKI(teststepJson.toString(), response1);
		Assert.assertTrue(status1);
		extentReport.endTest(test);
	}

	// Get test steps by issue id
	@Test(priority = 14)
	public void bvt14_getTeststepByIssueId() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Issue issuePayLoad = new Issue();		
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Test");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		test.log(LogStatus.PASS, "Create Issue Api executed successfully.");

		boolean status = jiraService.validateCreateIssueApi(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		issueId1 = new JSONObject(response.body().asString()).getLong("id");
		System.out.println("Issue id is :" + issueId1);

		for (int i = 0; i < 5; i++) {
			Teststep teststepJson = new Teststep();
			teststepJson.setStep("step"+i);
			teststepJson.setData("data"+i);
			teststepJson.setResult("result"+i);
			Response response1 = zapiService.createTeststep(basicAuth, issueId1, teststepJson.toString());
			Assert.assertNotNull(response1, "Create teststep Api Without WIKI Response is null.");
			test.log(LogStatus.PASS, "Create teststep Api Without WIKI executed successfully.");
			boolean status1 = zapiService.validateCreatedtestStep(response1);
		}

		Response response2 = zapiService.getTeststep(basicAuth, issueId1);
		Assert.assertNotNull(response2, "Get teststep by issue-Id Response is null.");
		test.log(LogStatus.PASS, "Get teststep by Issue-id executed successfully.");
		boolean status1 = zapiService.validateGetTestStepByIssueID(response2);
		Assert.assertTrue(status1, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	// Get test step by id
	@Test(priority = 15)
	public void bvt15_getTeststepByStepId() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Teststep teststepJson = new Teststep();
		teststepJson.setStep("Check for schedule count");
		teststepJson.setData("filter id");
		teststepJson.setResult("count should be equal to schedules returned by this filter.");

		Response response1 = zapiService.createTeststep(basicAuth, issueId1, teststepJson.toString());
		Assert.assertNotNull(response1, "Create teststep Api with WIKI Response is null.");
		test.log(LogStatus.PASS, "Create teststep Api With WIKI executed successfully.");
		Long stepId = new JSONObject(response1.body().asString()).getLong("id");
		System.out.println("test steps id is :" + stepId);

		Response response2 = zapiService.getTeststepByID(basicAuth, issueId1, stepId);
		Assert.assertNotNull(response2, "Get teststep by step-id Response is null.");
		test.log(LogStatus.PASS, "Get teststep by step-id executed successfully.");		
		boolean status1 = zapiService.validateGetTeststepByID(response2);
		Assert.assertTrue(status1, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Move teststep
	@Test(priority = 16)
	public void bvt16_moveTeststep() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Issue issuePayLoad = new Issue();		
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Test created to Move and Update steps");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		test.log(LogStatus.PASS, "Create Issue Api executed successfully.");

		issueId2 = new JSONObject(response.body().asString()).getLong("id");
		System.out.println("test id is :" + issueId2);

		Teststep teststepJson = new Teststep();
		teststepJson.setStep("Step1");
		teststepJson.setData("Data1");
		teststepJson.setResult("Result1");

		Response response1 = zapiService.createTeststep(basicAuth, issueId2, teststepJson.toString());
		Assert.assertNotNull(response1, "Create teststep Api Response is null.");
		test.log(LogStatus.PASS, "Create teststep Api executed successfully.");
		long testStepId1 = new JSONObject(response1.body().asString()).getLong("id");
		System.out.println("test steps id is :" + testStepId1);

		Teststep teststepJson1 = new Teststep();
		teststepJson1.setStep("New_step");
		teststepJson1.setData("New_data");
		teststepJson1.setResult("New_result");
		Response response2 = zapiService.createTeststep(basicAuth, issueId2, teststepJson1.toString());
		Assert.assertNotNull(response2, "Create teststep Api Response is null");
		test.log(LogStatus.PASS, "Create teststep Api Response is null");
		long testStepId2 = new JSONObject(response2.body().asString()).getLong("id");
		System.out.println("test steps id is :" + testStepId2);

		String payLoad = "{\"before\":\"/rest/zephyr/latest/teststep/" + issueId2 + "/" + testStepId2 + "\"}";
		Response response3 = zapiService.moveTeststep(basicAuth, issueId2, testStepId1, payLoad);
		Assert.assertNotNull(response3, "Move step Response is null.");
		test.log(LogStatus.PASS, "Move step executed successfully.");
		System.out.println("Response after moveTeststep:" + response3.body().asString());
		boolean status1 = zapiService.validateMovetestStep(payLoad, response3);
		Assert.assertTrue(status1, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	//Update test step (details/data/expected results)	
	@Test(priority = 17)
	public void bvt17_updateTeststep() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Teststep teststepJson = new Teststep();
		teststepJson.setStep("h1.Step2");
		teststepJson.setData("h1.Data2");
		teststepJson.setResult("h1.Result2");
		Response response1 = zapiService.createTeststep(basicAuth, issueId2, teststepJson.toString());
		Assert.assertNotNull(response1, "Create teststep Api is null.");
		test.log(LogStatus.PASS, "Create teststep Api executed successfully.");
		long testStepId = new JSONObject(response1.body().asString()).getLong("id");
		System.out.println("Steps id for update:" + testStepId);

		Teststep teststepJson1 = new Teststep();
		teststepJson1.setStep("h1.Updated Step1");
		teststepJson1.setData("h1.Updated Data1");
		teststepJson1.setResult("h1.Updated Result1");
		Response response2 = zapiService.updateTeststep(basicAuth, issueId2, testStepId, teststepJson1.toString());
		Assert.assertNotNull(response2, "Update step Response is null.");
		test.log(LogStatus.PASS, "Update step executed successfully.");
		System.out.println("Response after update Teststep:" +response2.body().asString());

		boolean status1 = zapiService.validateUpdatetestStep(teststepJson1.toString(), response2);
		Assert.assertTrue(status1, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	//Create a cloned test step at second position  and modify the step value while cloning
	@Test(priority = 18)
	public void bvt18_cloneTeststepAtSecondPositionWithOutWiki() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Teststep teststepJson = new Teststep();
		teststepJson.setStep("Big Heading for clone");
		teststepJson.setData("Big Heading for clone");
		teststepJson.setResult("Big Heading for clone");			
		Response response1 = zapiService.createTeststep(basicAuth, issueId2, teststepJson.toString());
		Assert.assertNotNull(response1, "Create teststep Response is null.");
		test.log(LogStatus.PASS, "Create teststep executed successfully.");
		long testStepId = new JSONObject(response1.body().asString()).getLong("id");
		System.out.println("Step id for cloning is:" + testStepId);

		String payLoad1 = "{\r\n\"position\": \"2\"\r\n}";

		Response response2 = zapiService.cloneTeststep(basicAuth, issueId2, testStepId, payLoad1);
		System.out.println("Response after clone Teststep:" +response2.getBody().asString());
		Assert.assertNotNull(response2, "Clone step Response is null.");
		test.log(LogStatus.PASS, "Clone step executed successfully.");

		boolean status1 = zapiService.validateCloneTeststep(response2);
		Assert.assertTrue(status1, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	//Clone test step  with wiki markup (details/data/expected result)
	@Test(priority = 19)
	public void bvt19_cloneTeststepWithWikiMarkup() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Teststep teststepJson = new Teststep();
		teststepJson.setStep("h1.Step in wiki");
		teststepJson.setData("h1.Data in wiki");
		teststepJson.setResult("h1.Result in wiki");
		Response response1 = zapiService.createTeststep(basicAuth, issueId2, teststepJson.toString());
		Assert.assertNotNull(response1, "Create teststep Response is null.");
		test.log(LogStatus.PASS, "Create teststep executed successfully.");
		long testStepId = new JSONObject(response1.body().asString()).getLong("id");
		System.out.println("Step id for clone:" + testStepId);

		String payLoad1 = "{\r\n\"position\": \"1\"\r\n}";		
		Response response2 = zapiService.cloneTeststep(basicAuth, issueId2, testStepId, payLoad1);
		Assert.assertNotNull(response2, "Clone step Response is null.");
		test.log(LogStatus.PASS, "Clone step executed successfully.");

		boolean status1 = zapiService.validateCloneTeststepWithWiki(response2);
		Assert.assertTrue(status1, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		System.out.println("Response after clone wiki teststep:" +response2.body().asString());
		extentReport.endTest(test);
	}

	// Delete test step
	@Test(priority = 20)
	public void bvt20_deleteTeststep() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Issue issuePayLoad = new Issue();		
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Test With Deleted Teststep");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		test.log(LogStatus.PASS, "Create Issue Api executed successfully.");

		boolean status = jiraService.validateCreateIssueApi(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		issueId = new JSONObject(response.body().asString()).getLong("id");
		System.out.println("Isuue id is :" + issueId);

		Teststep teststepJson = new Teststep();
		teststepJson.setStep("step-1");
		teststepJson.setData("data-1");
		teststepJson.setResult("result-1");

		Response response1 = zapiService.createTeststep(basicAuth, issueId, teststepJson.toString());
		Assert.assertNotNull(response1, "Create teststep Api is null.");
		test.log(LogStatus.PASS, "Create teststep Api executed successfully.");
		long testStepId = new JSONObject(response1.body().asString()).getLong("id");
		System.out.println("stepID id is :" + testStepId);

		Response response2 = zapiService.deleteTestStep(basicAuth, issueId, testStepId);
		Assert.assertNotNull(response2, "Delete step Response is null.");
		test.log(LogStatus.PASS, "Delete step executed successfully.");
		System.out.println(response2.body().asString());
		boolean status1 = zapiService.validateDeleteTeststep(response2);
		Assert.assertTrue(status1, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	// Create cycle under planned version, with only mandatory fields
	@Test(priority = 21)
	public void bvt21_createCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - zapi");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setName("New cycle created in Planned version");
		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Create Cycle Api Response is null.");
		test.log(LogStatus.PASS, "Create Cycle Api executed successfully.");

		boolean status = zapiService.validateCreateCycleApi(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		cycleId = new JSONObject(response.body().asString()).get("id").toString();
		extentReport.endTest(test);
	}

	//Create cycle with sprintId under unscheduled version		
	@Test(priority = 22)
	public void bvt22_createCycleWithSprintId() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - zapi");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(-1l);
		cycleJson.setName("Sample cycle1");
		cycleJson.setSprintId(Long.parseLong(Config.getValue("sprintId")));

		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Create Cycle Api Response is null.");
		test.log(LogStatus.PASS, "Create Cycle Api executed successfully.");

		boolean status = zapiService.validateCreateCycleApi(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		cycleId = new JSONObject(response.body().asString()).get("id").toString();
		extentReport.endTest(test);
	}

	// Create cycle with sprintId under planned version
	@Test(priority = 23)
	public void bvt23_createCycleplannedverion() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - zapi");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setName("sample cycle2");
		cycleJson.setSprintId(Long.parseLong(Config.getValue("sprintId")));

		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Create Cycle Api Response is null.");
		test.log(LogStatus.PASS, "Create Cycle Api executed successfully.");

		boolean status = zapiService.validateCreateCycleApi(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		cycleId1 = new JSONObject(response.body().asString()).get("id").toString();
		System.out.println("Created cycle id:" +cycleId1);
		extentReport.endTest(test);

		//Add executions
		Execution executionJson = new Execution();
		List<String> values= new ArrayList<String>();
		values.add("PROJ1-1");
		values.add("PROJ1-2");
		executionJson.setIssues(values);
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		executionJson.setCycleId(cycleId1);
		executionJson.setMethod(1);
		Response response1 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println("Add tests to cycle successful");

		boolean status1 = zapiService.validateAddTestsToCycle(response1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully."); 
		extentReport.endTest(test);

	}

	// Clone partially executed planned cycle to another version
	@Test(priority = 24)
	public void bvt24_cloneupdateCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - Zapi");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(-1l);
		cycleJson.setName("Cloned cycle moved to unscheduled version");
		cycleJson.setClonedCycleId(cycleId1);

		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "cloneCycle Api Response is null.");
		test.log(LogStatus.PASS, "cloneCycle Api executed successfully.");
		boolean status = zapiService.validateCloneCycle(response);
		System.out.println("Clone cycle successful");
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);

	}

	// Update cycle - add description		 
	@Test(priority = 25)
	public void bvt25_updateCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - Zapi");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setId(cycleId1);
		cycleJson.setName("sample cycle2- renamed");
		cycleJson.setDescription("Updated description");
		Response response = zapiService.updateCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Update Cycle description Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle description Api executed successfully.");

		boolean status = zapiService.validateUpdateCycleApi(response);
		System.out.println("Update cycle successful");
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	// Update cycle - add sprintId			
	@Test(priority = 26)
	public void bvt26_updateCyclesprintid() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - Zapi");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setName("Cycle created through API");
		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Create Cycle Api Response is null.");
		test.log(LogStatus.PASS, "Create Cycle Api executed successfully.");

		boolean status = zapiService.validateCreateCycleApi(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		cycleId2 = new JSONObject(response.body().asString()).get("id").toString();

		Cycle cycleJson1 = new Cycle();
		cycleJson1.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson1.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson1.setId(cycleId2);
		cycleJson1.setDescription("Cycle Updated with SprintId");
		cycleJson1.setSprintId(Long.parseLong(Config.getValue("sprintId")));
		Response response1 = zapiService.updateCycle(basicAuth, cycleJson1.toString());
		Assert.assertNotNull(response1, "Update Cycle with sprintid Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle with sprintid Api executed successfully.");

		boolean status1 = zapiService.validateUpdateCycleApi(response1);
		Assert.assertTrue(status1, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	// Get cycles by project id
	@Test(priority = 27)
	public void bvt27_getCycles() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - Zapi");

		Long projectId = Long.parseLong(Config.getValue("project1Id"));
		Response response = zapiService.getCycles(basicAuth, projectId);
		Assert.assertNotNull(response, "Api Response is null.");
		test.log(LogStatus.PASS, "Get cycle by projectId Api Response is null.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetCycles(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}

	// Get cycle by id if linked to a sprint
	@Test(priority = 28)
	public void bvt28_getCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - Zapi");

		String cycleId = cycleId2;
		Response response = zapiService.getCycle(basicAuth, cycleId);
		Assert.assertNotNull(response, "Getcycle Api Response is null.");
		test.log(LogStatus.PASS, "Getcycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetCycle(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated suuccessfully.");
		extentReport.endTest(test);
	}


	// Get cyclesbyVersionAndSprint, if multiple cycles from different versions are linked to sprint
	@Test(priority = 29)
	public void bvt29_getCyclesbyVersionAndSprint() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - zapi");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setSprintId(Long.parseLong(Config.getValue("sprintId")));

		Response response = zapiService.cyclesByVersionAndSprint(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "cyclesbyversionAndsprint Api Response is null.");
		test.log(LogStatus.PASS, "cyclesbyversionAndsprint Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetCyclesbyVersionAndSprint(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Cleanup sprint
	@Test(priority = 30)
	public void bvt30_cleanupsprint() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - zapi");

		Response response = zapiService.cleanupSprint(basicAuth);
		Assert.assertNotNull(response, "Cleanupsprint Api Response is null.");
		test.log(LogStatus.PASS, "Cleanupsprint Api executed successfully.");

		boolean status = zapiService.validateCleanupCycle(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);

	}

	// Create execution with no assignment under planned cycle
	@Test(priority = 31)
	public void bvt31_createExecution() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - zapi");

		Issue issuePayLoad = new Issue();
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Test");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));			
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		issueId = new JSONObject(response.body().asString()).getLong("id");
		System.out.println("test id is :" + issueId);

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(-1l);
		cycleJson.setName("Cycle created through API");
		Response response1 = zapiService.createCycle(basicAuth, cycleJson.toString());			
		Assert.assertNotNull(response1, "Create Cycle Api Response is null.");			
		cycleId = new JSONObject(response1.body().asString()).get("id").toString();
		System.out.println("Cycle id:" +cycleId);

		Execution json = new Execution();
		json.setIssueId(issueId);
		json.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		json.setVersionId(-1l);
		json.setCycleId(cycleId);
		payload = json.toString();
		Response response2 = zapiService.createExecution(basicAuth, payload);
		System.out.println(response2.getBody().asString());
		Assert.assertNotNull(response2, "Cleanupsprint Api Response is null.");
		test.log(LogStatus.PASS, "Cleanupsprint Api executed successfully.");

		boolean status = zapiService.validateCreateExecution(response2);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);

	}

	//Create execution with assignee as current user under planned cycle 
	@Test(priority = 32)
	public void bvt32_createExecution() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - zapi");

		Issue issuePayLoad = new Issue();
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Test");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));			
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		issueId = new JSONObject(response.body().asString()).getLong("id");
		System.out.println("test id is :" + issueId);

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setName("Cycle created through API");
		Response response1 = zapiService.createCycle(basicAuth, cycleJson.toString());			
		Assert.assertNotNull(response1, "Create Cycle Api Response is null.");			
		cycleId = new JSONObject(response1.body().asString()).get("id").toString();
		System.out.println("Cycle id:" +cycleId);

		Execution json = new Execution();
		json.setIssueId(issueId);
		json.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		json.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		json.setCycleId(cycleId);
		json.setAssigneeType("currentUser");
		payload = json.toString();
		Response response2 = zapiService.createExecution(basicAuth, payload);
		System.out.println(response2.getBody().asString());
		Assert.assertNotNull(response2, "Cleanupsprint Api Response is null.");
		test.log(LogStatus.PASS, "Cleanupsprint Api executed successfully.");

		boolean status = zapiService.validateCreateExecution(response2);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);

	}


	//Create execution with assignee as another user under planned cycle 
	@Test(priority = 33)
	public void bvt33_createExecution() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - zapi");

		Issue issuePayLoad = new Issue();
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Test");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));			
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		issueId = new JSONObject(response.body().asString()).getLong("id");
		System.out.println("test id is :" + issueId);

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setName("Cycle created through API- yyyvdx");
		Response response1 = zapiService.createCycle(basicAuth, cycleJson.toString());			
		Assert.assertNotNull(response1, "Create Cycle Api Response is null.");			
		cycleId = new JSONObject(response1.body().asString()).get("id").toString();
		System.out.println("Cycle id:" +cycleId);

		Execution json = new Execution();
		json.setIssueId(issueId);
		json.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		json.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		json.setCycleId(cycleId);
		json.setAssignee(Config.getValue("jiraUserName"));
		json.setAssigneeType("assignee");
		payload = json.toString();
		Response response2 = zapiService.createExecution(basicAuth, payload);
		System.out.println(response2.getBody().asString());
		Assert.assertNotNull(response2, "Cleanupsprint Api Response is null.");
		test.log(LogStatus.PASS, "Cleanupsprint Api executed successfully.");

		boolean status = zapiService.validateCreateExecution(response2);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);	
	}

	//Get search filters by keywords
	@Test(priority=34)
	public void bvt41_getSearchFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String query = "filter1";
		Response response = zapiService.searchFilter(basicAuth, query);
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateSearchFilter(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully."); 
		extentReport.endTest(test);
	}

	//Add individual test to cycle without assignee
	@Test(priority = 35)
	public void bvt42_addTestsToAdhocCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Execution executionJson = new Execution();
		List<String> values = new ArrayList<String>();
		values.add("PROJ1-3");
		values.add("PROJ1-4");
		executionJson.setIssues(values);
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(-1l);
		executionJson.setCycleId("-1");
		executionJson.setMethod(1);		
		Response response1 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println("Add tests to cycle successful");
		System.out.println(response1.getBody().asString());
		String jobProgressToken = new JSONObject(response1.getBody().asString()).getString("jobProgressToken");

		Response response6 = zapiService.jobprogress(basicAuth, jobProgressToken);
		boolean status = zapiService.validateAddTestsToCycle(response6);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully."); 
		extentReport.endTest(test);
	}

	//Add individual test to cycle with assignee as current user
	@Test(priority = 36)
	public void bvt43_addTestsToCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setName("Cycle created through API3");
		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Create Cycle Api Response is null.");
		cycleId3 = new JSONObject(response.body().asString()).get("id").toString();
		System.out.println("cycle id is" + cycleId3);

		Execution executionJson = new Execution();
		List<String> values = new ArrayList<String>();
		values.add("PROJ1-5");
		values.add("PROJ1-6");
		executionJson.setIssues(values);
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		executionJson.setCycleId(cycleId3);
		executionJson.setMethod(1);
		executionJson.setAssigneeType("currentUser");
		Response response1 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println("Add tests to cycle successful");		

		boolean status = zapiService.validateAddTestsToCycle(response1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully."); 
		extentReport.endTest(test);
		return;
	}

	//Add individual test to cycle with assignee as another user
	@Test(priority = 37)
	public void bvt44_addTestsToScheduleCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Execution executionJson = new Execution();
		List<String> values= new ArrayList<String>();
		values.add("PROJ1-7");
		values.add("PROJ1-8");
		executionJson.setIssues(values);
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		executionJson.setCycleId(cycleId3);
		executionJson.setAssignee(Config.getValue("jiraUserName"));
		executionJson.setAssigneeType("assignee");

		Response response = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println("Add tests to cycle successful");

		boolean status = zapiService.validateAddTestsToCycle(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully."); 
		extentReport.endTest(test);
	}


	//Get executions by param cycleId (Ad hoc)
	@Test(priority = 38)
	public void bvt45_getExecutionsByCycleId() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		long projectId = Long.parseLong(Config.getValue("project1Id"));
		long versionId = -1l;
		String cycleId = "-1";
		Response response = zapiService.getExecutionsByCycle(basicAuth, projectId, versionId, cycleId);		
		System.out.println(response.getBody().asString());
		id1 = (new JSONObject(response.body().asString()).getJSONArray("executions").getJSONObject(0).get("id")).toString();
		System.out.println("Execution id:" +id1);

		boolean status = zapiService.validateExecuteSearch(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get execution by id
	@Test(priority = 39)
	public void bvt46_getExecutionsById() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		//String executionId1 = "1";
		Response response = zapiService.getExecutionByExecutionId(basicAuth, id1);
		System.out.println(response.getBody().asString());
		System.out.println("Get executions by Id api executed successful");

		boolean status = zapiService.validateGetExecutionById(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Execute test to standard status (Pass)
	@Test(priority = 40)
	public void bvt34_executeTest() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String id = id1;		
		System.out.println(id);
		Execution json = new Execution();
		json.setStatusId(1);
		payload = json.toString();
		System.out.println(payload);			
		Response response = zapiService.executeTest(basicAuth, id, payload );		
		System.out.println(response.getBody().asString());


		boolean status = zapiService.validateExecuteTest(response, executionId1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Search executions by zql query (executionStatus, project)
	@Test(priority = 41)
	public void bvt35_executeSearch() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String zqlQuery = "project = Project1 AND  executionStatus =  PASS";
		Response response = zapiService.executeSearch(basicAuth, zqlQuery);		
		System.out.println(response.getBody().asString());


		boolean status = zapiService.validateExecuteSearch(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get executions by param cycleId (planned)
	@Test(priority = 42)
	public void bvt38_getExecutionsByCycleId() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		long projectId = Long.parseLong(Config.getValue("project1Id"));
		long versionId = Long.parseLong(Config.getValue("version1Id"));
		String cycleId =cycleId3;
		System.out.println("cycleId3::"+cycleId);		
		Response response = zapiService.getExecutionsByCycle(basicAuth,projectId, versionId, cycleId);
		executionId1 = new JSONObject(response.getBody().asString()).getJSONArray("executions").getJSONObject(0).get("id").toString();
		System.out.println("ExecutionId is:" +executionId1);
		System.out.println("Get executions by cycleId Api executed successful");

		boolean status = zapiService.validateGetExecutions(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Export cycle as CSV, partially executed with defects and execution comments
	@Test(priority = 43)
	public void bvt40_exportCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version5Id")));
		cycleJson.setName("Cycle created through API1");
		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Create Cycle Api Response is null.");
		cycleId6 = new JSONObject(response.body().asString()).get("id").toString();		
		System.out.println("cycle id is" + cycleId6);

		Execution executionJson = new Execution();		
		executionJson.setProjectId(10000l);
		executionJson.setVersionId(10001l);
		executionJson.setCycleId(cycleId6);
		executionJson.setMethod(2);
		executionJson.setSearchId(10002l);	    						
		Response response1 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println("Add tests to cycle is successful.");		
		long projectId = Long.parseLong(Config.getValue("project1Id"));
		long versionId = Long.parseLong(Config.getValue("version5Id"));
		String cycleId =cycleId6;
		Response response2 = zapiService.getExecutionsByCycle(basicAuth,projectId, versionId, cycleId);
		executionId1 = new JSONObject(response2.getBody().asString()).getJSONArray("executions").getJSONObject(0).get("id").toString();
		executionId2 = new JSONObject(response2.getBody().asString()).getJSONArray("executions").getJSONObject(1).get("id").toString();
		System.out.println("ExecutionId1 is:" +executionId1);
		System.out.println("ExecutionId2 is:" +executionId2);	

		String id = executionId1;
		System.out.println(id);
		Execution json = new Execution();
		json.setStatusId(1);
		json.setComment("Comment added");
		List<String> values = new ArrayList<>();
		values.add("PROJ1-41");
		json.setDefectList(values);
		json.setUpdateDefectList("true");
		payload = json.toString();
		Response response3 = zapiService.executeTest(basicAuth, id, payload );		
		System.out.println(response3.getBody().asString());

		Response response4 = zapiService.exportCycle(basicAuth, cycleId,projectId,versionId  );		
		System.out.println(response4.getBody().asString());

		boolean status = zapiService.validateExportCycle(response4);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Delete execution				
	@Test(priority = 44)
	public void bvt47_deleteExecution() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String executionId = executionId1;
		Response response = zapiService.deleteExecution(basicAuth, executionId);
		System.out.println("Delete executionApi executed successful");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validatedeleteExecution(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Delete cycle by id
	@Test(priority = 45)
	public void bvt39_deleteCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String cycleId = cycleId6;					
		Response response = zapiService.deleteCycle(basicAuth, cycleId );		
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateDeletedCycle(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}	

	//Copy multiple executions from one cycle to adhoc cycle, and clear statuses and defects
	@Test(priority = 46)
	public void bvt36_copyExecutions() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");


		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setName("Cycle created through API6");
		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());			
		cycleId = new JSONObject(response.body().asString()).get("id").toString();

		Execution executionJson = new Execution();		
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		executionJson.setCycleId(cycleId);
		executionJson.setMethod(2);
		executionJson.setSearchId(10002l);			
		Response response1 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println("Successful:" + response1.getBody().asString());			

		long projectId = Long.parseLong(Config.getValue("project1Id"));
		long versionId = Long.parseLong(Config.getValue("version1Id"));				
		Response response2 = zapiService.getExecutionsByCycle(basicAuth,projectId, versionId, cycleId);
		System.out.println(response2.getBody().asString());
		executionId7 = new JSONObject(response2.getBody().asString()).getJSONArray("executions").getJSONObject(0).get("id").toString();
		executionId8 = new JSONObject(response2.getBody().asString()).getJSONArray("executions").getJSONObject(1).get("id").toString();

		BulkExecution execJson = new BulkExecution();
		List<String> list = new ArrayList<>();
		list.add(executionId7);
		list.add(executionId8);		
		execJson.setExecutions(list);
		execJson.setStatus("3");			
		System.out.println(execJson);
		Response response3 = zapiService.bulkUpdateStatus(basicAuth, execJson.toString());

		List<String> list1 = new ArrayList<>();
		list1.add(executionId7);
		list1.add(executionId8);			
		List<String> list2 = new ArrayList<>();
		list2.add("PROJ2-1");
		list2.add("PROJ2-2");
		BulkExecution execJson1 = new BulkExecution();
		execJson1.setExecutions(list1);
		execJson1.setDefects(list2);				
		Response response4 = zapiService.bulkUpdateDefects(basicAuth, execJson1.toString());

		List<String> list3 = new ArrayList<>();
		list3.add(executionId7);
		list3.add(executionId8);
		BulkExecution json2 = new BulkExecution();
		json2.setExecutions(list3);
		json2.setProjectId(Config.getValue("project1Id"));
		json2.setVersionId("-1");
		json2.setClearAssignmentsFlag(false);
		json2.setClearStatusFlag(true);
		json2.setClearDefectMappingFlag(true);
		String payload = json2.toString();
		int cycleId1 = -1;			
		Response response5 = zapiService.copyExecutions(basicAuth, cycleId1, payload);	
		String jobProgressToken = new JSONObject(response5.getBody().asString()).getString("jobProgressToken");

		Response response6 = zapiService.jobprogress(basicAuth, jobProgressToken);		
		boolean status = zapiService.validateCopyExecutions(response6);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);

	}		
	//Move  executions from another cycle to planned cycle, without clearing statuses and defects
	@Test(priority = 47)
	public void bvt37_moveExecutions() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");


		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version2Id")));
		cycleJson.setName("Cycle created through API7");
		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());			
		String cycleId = new JSONObject(response.body().asString()).get("id").toString();

		List<String> list3 = new ArrayList<>();
		list3.add(executionId7);
		list3.add(executionId8);
		BulkExecution json2 = new BulkExecution();
		json2.setExecutions(list3);
		json2.setProjectId(Config.getValue("project1Id"));
		json2.setVersionId(Config.getValue("version2Id"));
		json2.setClearAssignmentsFlag(false);
		json2.setClearStatusFlag(false);
		json2.setClearDefectMappingFlag(false);
		String payload = json2.toString();
		int cycleId1 = Integer.parseInt(cycleId);			
		Response response5 = zapiService.moveExecutions(basicAuth, cycleId1, payload);
		System.out.println(response5.getBody().asString());
		String jobProgressToken = new JSONObject(response5.getBody().asString()).getString("jobProgressToken");

		Response response6 = zapiService.jobprogress(basicAuth, jobProgressToken);		
		boolean status = zapiService.validateMoveExecutions(response6);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);

	}		

	//Add tests from search filter without assignment	
	@Test(priority = 48)
	public void bvt48_addTestsFromSearchFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Execution executionJson = new Execution();		
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(-1l);
		executionJson.setCycleId("-1");
		executionJson.setMethod(2);
		executionJson.setSearchId(10002l);			
		Response response = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println("Successful:" + response.getBody().asString());

		boolean status = zapiService.validateAddTestsToCycle(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Add tests from search filter with assignee as current user	
	@Test(priority = 49)
	public void bvt49_addTestsFromSearchFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setName("Cycle created through API3");
		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Create Cycle Api Response is null.");
		cycleId4 = new JSONObject(response.body().asString()).get("id").toString();		
		System.out.println("cycle id is" + cycleId4);

		Execution executionJson = new Execution();		
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		executionJson.setCycleId(cycleId4);
		executionJson.setMethod(2);
		executionJson.setSearchId(10002l);
		executionJson.setAssigneeType("currentUser");					
		Response response1 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println(response1.getBody().asString());
		System.out.println("Add tests to cycle from search filter is successful");

		boolean status = zapiService.validateAddTestsToCycle(response1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Add tests from search filter with assignee as another user	
	@Test(priority = 50)
	public void bvt50_addTestsFromSearchFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		cycleJson.setName("Cycle created through API4");
		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Create Cycle Api Response is null.");
		cycleId5 = new JSONObject(response.body().asString()).get("id").toString();		
		System.out.println("cycle id is" + cycleId5);

		Execution executionJson = new Execution();		
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		executionJson.setCycleId(cycleId5);
		executionJson.setMethod(2);
		executionJson.setSearchId(10002l);
		executionJson.setAssignee(Config.getValue("jiraUserName"));
		executionJson.setAssigneeType("assignee");					
		Response response1 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println(response1.getBody().asString());
		System.out.println("Add tests to cycle from search filter is successful");

		boolean status = zapiService.validateAddTestsToCycle(response1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Add tests from another cycle without assignment
	@Test(priority = 51)
	public void bvt51_addTestsFromOtherCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Execution executionJson = new Execution();		
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version1Id")));
		executionJson.setCycleId("-1");
		executionJson.setMethod(3);
		executionJson.setFromCycleId("-1");
		executionJson.setFromVersionId(-1l);

		Response response = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println(response.getBody().asString());
		System.out.println("Add tests to cycle from another cycle is successful");

		boolean status = zapiService.validateAddTestsToCycle(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Add tests from another cycle with assignee as current user
	@Test(priority = 52)
	public void bvt52_addTestsFromOtherCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Execution executionJson = new Execution();		
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version2Id")));
		executionJson.setCycleId("-1");
		executionJson.setMethod(3);
		executionJson.setFromCycleId(cycleId4);
		executionJson.setFromVersionId(Long.parseLong(Config.getValue("version1Id")));
		executionJson.setAssigneeType("currentUser");
		System.out.println(executionJson);				
		Response response = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println(response.getBody().asString());
		System.out.println("Add tests to cycle from another cycle is successful");

		boolean status = zapiService.validateAddTestsToCycle(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Add tests from another cycle with assignee as another user
	@Test(priority = 53)
	public void bvt53_addTestsFromOtherCycle() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()	.getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");					

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version2Id")));
		cycleJson.setName("Cycle created through API5");
		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Create Cycle Api Response is null.");
		cycleId1 = new JSONObject(response.body().asString()).get("id").toString();		
		System.out.println("cycle id is" + cycleId1);

		Execution executionJson = new Execution();		
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version2Id")));
		executionJson.setCycleId(cycleId1);
		executionJson.setMethod(3);
		executionJson.setFromCycleId(cycleId5);
		executionJson.setFromVersionId(Long.parseLong(Config.getValue("version1Id")));
		executionJson.setAssignee("jira_user");
		executionJson.setAssigneeType("assignee");
		System.out.println(executionJson);						
		Response response1 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println(response1.getBody().asString());
		System.out.println("Add tests to cycle from another cycle is successful");

		boolean status = zapiService.validateAddTestsToCycle(response1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Bulkupdate status
	@Test(priority = 54)
	public void bvt54_BulkUpdateStatus() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version3Id")));
		cycleJson.setName("Cycle created through API6");
		Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response, "Create Cycle Api Response is null.");
		cycleId1 = new JSONObject(response.body().asString()).get("id").toString();		
		System.out.println("cycle id is" + cycleId1);

		Execution executionJson = new Execution();		
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version3Id")));
		executionJson.setCycleId(cycleId1);
		executionJson.setMethod(2);
		executionJson.setSearchId(10002l);	    						
		Response response1 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println("Add tests to cycle is successful.");		
		long projectId = Long.parseLong(Config.getValue("project1Id"));
		long versionId = Long.parseLong(Config.getValue("version3Id"));
		String cycleId =cycleId1;
		Response response2 = zapiService.getExecutionsByCycle(basicAuth,projectId, versionId, cycleId);
		executionId2 = new JSONObject(response2.getBody().asString()).getJSONArray("executions").getJSONObject(0).get("id").toString();
		executionId3 = new JSONObject(response2.getBody().asString()).getJSONArray("executions").getJSONObject(1).get("id").toString();
		System.out.println("ExecutionId1 is:" +executionId2);
		System.out.println("ExecutionId2 is:" +executionId3);		

		BulkExecution execJson = new BulkExecution();
		List<String> list = new ArrayList<>();
		list.add(executionId2);
		list.add(executionId3);		
		execJson.setExecutions(list);
		execJson.setStatus("1");
		//execJson.setStepStatus(2);
		//		execJson.setTestStepStatusChangeFlag(False);
		System.out.println(execJson);
		Response response3 = zapiService.bulkUpdateStatus(basicAuth, execJson.toString());
		Assert.assertNotNull(response, "bulkupdate status Api Response is null.");
		test.log(LogStatus.PASS, "bulkupdate status Api executed successfully.");		
		String jobProgressToken = new JSONObject(response3.getBody().asString()).getString("jobProgressToken");

		//Job progress

		Response response4 = zapiService.jobprogress(basicAuth, jobProgressToken);		
		boolean status1 = zapiService.validateBulkStatusUdate(response4);
		Assert.assertTrue(status1, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Bulk assign executions to current user
	@Test(priority = 55)
	public void bvt55_BulkAssignCurrentuser() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		List<String> list = new ArrayList<>();
		list.add(executionId2);
		list.add(executionId3);
		BulkExecution execJson = new BulkExecution();
		execJson.setExecutions(list);
		execJson.setAssigneeType("currentUser");
		Response response = zapiService.bulkUpdateAssignee(basicAuth, execJson.toString());
		Assert.assertNotNull(response, "bulkupdate status Api Response is null.");
		test.log(LogStatus.PASS, "bulkupdate status Api executed successfully.");
		String jobProgressToken = new JSONObject(response.getBody().asString()).getString("jobProgressToken");

		Response response4 = zapiService.jobprogress(basicAuth, jobProgressToken);			
		boolean status = zapiService.validateBulkUpdateAssignee(response4);
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Bulk assign executions to another user
	@Test(priority = 56)
	public void bvt56_BulkAssignAnotherUser() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		List<String> list = new ArrayList<>();
		list.add(executionId2);
		list.add(executionId3);
		BulkExecution execJson = new BulkExecution();
		execJson.setExecutions(list);
		execJson.setAssigneeType("assignee");
		execJson.setAssignee(Config.getValue("jiraUserName"));
		Response response = zapiService.bulkUpdateAssignee(basicAuth, execJson.toString());
		Assert.assertNotNull(response, "bulkupdate status Api Response is null.");
		test.log(LogStatus.PASS, "bulkupdate status Api executed successfully.");
		String jobProgressToken = new JSONObject(response.getBody().asString()).getString("jobProgressToken");

		Response response4 = zapiService.jobprogress(basicAuth, jobProgressToken);			
		boolean status = zapiService.validateBulkUpdateAssignee(response4);
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Bulk unassign executions
	@Test(priority = 57)
	public void bvt57_BulkUnassign() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		List<String> list = new ArrayList<>();
		list.add(executionId2);
		list.add(executionId3);
		BulkExecution execJson = new BulkExecution();
		execJson.setExecutions(list);
		Response response = zapiService.bulkUpdateAssignee(basicAuth, execJson.toString());
		Assert.assertNotNull(response, "bulkupdate status Api Response is null.");
		test.log(LogStatus.PASS, "bulkupdate status Api executed successfully.");

		String jobProgressToken = new JSONObject(response.getBody().asString()).getString("jobProgressToken");

		Response response4 = zapiService.jobprogress(basicAuth, jobProgressToken);			
		boolean status = zapiService.validateBulkUpdateAssignee(response4);
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Link multiple defects to multiple executions (2 defects link to 2 executions)
	@Test(priority = 58)
	public void bvt59_executionUpdateWithBulkDefects() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		List<String> list = new ArrayList<>();
		list.add("23");
		List<String> list1 = new ArrayList<>();
		list1.add("SAM-68");
		list1.add("SAM-69");
		BulkExecution execJson = new BulkExecution();
		execJson.setExecutions(list);
		execJson.setDefects(list1);
		Response response = zapiService.bulkUpdateDefects(basicAuth, execJson.toString());
		Assert.assertNotNull(response, "Response is null.");
		test.log(LogStatus.PASS, " execution Update With Bulk Defects executed successfully.");
		System.out.println("Response:" +response.body().asString());

		if(StringUtils.isNotBlank(response.getBody().asString())) {
			String jobProgressToken = new JSONObject(response.getBody().asString()).getString("jobProgressToken");
			Response response4 = zapiService.jobprogress(basicAuth, jobProgressToken);
		}
//		boolean status = zapiService.validateexecutionUpdateWithBulkDefect(response4);
//		Assert.assertTrue(status);
//		extentReport.endTest(test);
	}


	//Get defects by execution id
	@Test(priority = 59)
	public void bvt60_getDefectsByExecutionID() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String executionId = executionId2;		
		Response response = zapiService.getDefectByExecution(basicAuth,executionId );
		Assert.assertNotNull(response, "Update step Response is null.");
		test.log(LogStatus.PASS, "get Defects By ExecutionID executed successfully.");
		System.out.println("Defects linked to execution:" +response.body().asString());
		boolean status = zapiService.validateGetDefectsByExecution(response);
		Assert.assertTrue(status);
		extentReport.endTest(test);
	}

	// Get executions by issue key/id	 
	@Test(priority = 60)
	public void bvt61_getExecutionsByIssueID() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Issue issuePayLoad = new Issue();
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Story linked to Sprint");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));			
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		issueId = new JSONObject(response.body().asString()).getLong("id");		

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(-1l);
		cycleJson.setName("Cycle created through API");
		Response response1 = zapiService.createCycle(basicAuth, cycleJson.toString());			
		Assert.assertNotNull(response1, "Create Cycle Api Response is null.");			
		String cycleId = new JSONObject(response1.body().asString()).get("id").toString();		

		Execution json = new Execution();
		json.setIssueId(issueId);
		json.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		json.setVersionId(-1l);
		json.setCycleId(cycleId);
		payload = json.toString();
		Response response2 = zapiService.createExecution(basicAuth, payload);

		long projectId = Long.parseLong(Config.getValue("project1Id"));
		long versionId = -1l;		
		Response response3 = zapiService.getExecutionsByCycle(basicAuth, projectId, versionId, cycleId);		
		String executionId = (new JSONObject(response3.body().asString()).getJSONArray("executions").getJSONObject(0).get("id")).toString();

		Issue issuePayLoad1 = new Issue();
		issuePayLoad1.setProject(Config.getValue("project1Id"));
		issuePayLoad1.setIssuetype(Config.getValue("issueTypeStoryId"));
		issuePayLoad1.setSummary("Issuetype-Story");
		issuePayLoad1.setPriority("3");
		issuePayLoad1.setReporter(Config.getValue("adminUserName"));			
		Response response4 = jiraService.createIssue(basicAuth, issuePayLoad1.toString());		
		issueKey5 = new JSONObject(response4.getBody().asString()).getString("key");

		List<String> values = new ArrayList<>();
		values.add(issueKey5);
		Sprint json1 = new Sprint();
		json1.setIdOrKeys(values);
		json1.setSprintId(1);
		payload = json1.toString();
		Response response5 = jiraService.linkIssueToSprint(basicAuth, payload);

		List<String> val = new ArrayList<>();
		val.add(issueKey5);
		String id = executionId;		
		Execution json2 = new Execution();
		json2.setStatusId(1);
		json2.setDefectList(val);
		json2.setUpdateDefectList("true");
		payload = json2.toString();
		Response response6 = zapiService.executeTest(basicAuth, id, payload );

		String issueId = issueKey5;
		Response response7 = zapiService.getExecutionByIssue(basicAuth, issueId);
		Assert.assertNotNull(response, "Update step Response is null.");
		test.log(LogStatus.PASS, "get Defects By ExecutionID executed successfully.");
		System.out.println(response7.body().asString());
		boolean status = zapiService.validateGetExecutionByIssueKey(response7);
		Assert.assertTrue(status);
		extentReport.endTest(test);


	}

	//Get execution summaries and defect count by sprint and issue Id	
	@Test(priority = 61)
	public void bvt62_getExecutionsSummaryBySprintAndIssueID() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Execution json = new Execution();
		json.setSprintId(1);
		json.setIssueIdOrKeys(issueKey5);
		System.out.println(json.toString());
		Response response = zapiService.getExecutionsSummaryBySprintAndIssueId(basicAuth, json.toString());
		Assert.assertNotNull(response, "Update step Response is null.");
		test.log(LogStatus.PASS, "get Defects By ExecutionID executed successfully.");
		System.out.println(response.body().asString());
		boolean status = zapiService.validategetExecutionsSummaryBySprintAndIssueID(response);
		Assert.assertTrue(status);
		extentReport.endTest(test);
	}

	// Export execution	
	@Test(priority = 62)
	public void bvt63_exportsExecutions() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");		

		String payLoad = "{\"exportType\": \"xls\", \"maxAllowedResult\": \"true\",\"expand\": \"teststeps\",\"startIndex\": \"0\",\"zqlQuery\": \"executionStatus != UNEXECUTED AND executedBy = vm_admin\"}";
		Response response = zapiService.exportExecution(basicAuth, payLoad);
		Assert.assertNotNull(response, "Update step Response is null.");
		test.log(LogStatus.PASS, "get Defects By ExecutionID executed successfully.");
		System.out.println(response.body().asString());
		boolean status = zapiService.validateExportExecutios(response);
		Assert.assertTrue(status);
		extentReport.endTest(test);
	}

	//Delete multiple executions
	@Test(priority = 63)
	public void bvt64_deleteMultipleExecutions() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Execution json = new Execution();
		List<String> values = new ArrayList<String>();		
		values.add(executionId2);
		values.add(executionId3);		
		json.setExecutions(values);
		System.out.println(json);
		Response response = zapiService.bulkDeleteExecutions(basicAuth, json.toString());
		Assert.assertNotNull(response, "Delete multiple execution Response is null.");
		test.log(LogStatus.PASS, "Delete multiple executions  executed successfully.");		
		String jobProgressToken = new JSONObject(response.getBody().asString()).getString("jobProgressToken");

		Response response6 = zapiService.jobprogress(basicAuth, jobProgressToken);
		boolean status = zapiService.validateDeleteExecution(response6);
		Assert.assertTrue(status);
		extentReport.endTest(test);
	}

	//Create test step result without setting status	 	
	@Test(priority = 64)
	public void bvt65_createTestStepResultWithoutStatus() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Issue issuePayLoad = new Issue();		
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Test With Teststeps");
		issuePayLoad.setPriority("1");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));		
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		System.out.println(response.getBody().asString());
		issueId = new JSONObject(response.body().asString()).getLong("id");
		issueKey = new JSONObject(response.getBody().asString()).getString("key");
		System.out.println("IssueKey :" + issueKey);
		System.out.println("IssueId :" + issueId);

		Teststep teststepJson = new Teststep();
		teststepJson.setStep("step1");
		teststepJson.setData("data1");
		teststepJson.setResult("result1");
		Response response1 = zapiService.createTeststep(basicAuth, issueId, teststepJson.toString());
		Assert.assertNotNull(response1, "Create teststep Api Without WIKI Response is null.");
		Response response2 = zapiService.getTeststep(basicAuth, issueId);		
		long teststepId = new JSONArray(response2.body().asString()).getJSONObject(0).getLong("id");
		System.out.println("TeststepId:" +teststepId);
		Assert.assertNotNull(response2, "Get teststep by issue-Id Response is null.");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(Long.parseLong(Config.getValue("version4Id")));
		cycleJson.setName("Cycle created through API8");
		Response response3 = zapiService.createCycle(basicAuth, cycleJson.toString());
		Assert.assertNotNull(response3, "Create Cycle Api Response is null.");		
		cycleId7 = new JSONObject(response3.body().asString()).get("id").toString();		
		System.out.println("cycle id is:" + cycleId7);

		Execution executionJson = new Execution();
		List<String> values = new ArrayList<String>();
		values.add(issueKey);
		executionJson.setIssues(values);
		executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		executionJson.setVersionId(Long.parseLong(Config.getValue("version4Id")));
		executionJson.setCycleId(cycleId7);
		executionJson.setMethod(1);
		Response response4 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
		System.out.println("Add tests to cycle is successful.");
		System.out.println(response4.getBody().asString());
		long projectId = Long.parseLong(Config.getValue("project1Id"));
		long versionId = Long.parseLong(Config.getValue("version4Id"));
		Response response5 = zapiService.getExecutionsByCycle(basicAuth,projectId, versionId, cycleId7);
		executionId5 = new JSONObject(response5.getBody().asString()).getJSONArray("executions").getJSONObject(0).getLong("id");
		System.out.println("ExecutionId1 is:" +executionId5);

		Stepresult json = new Stepresult();		
		json.setExecutionId(executionId5);
		json.setStepId(Long.toString(teststepId));
		json.setStatus(-1);
		payload = json.toString();		
		Response response6 = zapiService.createStepResultWithoutSettingStatus(basicAuth, payload);
		Assert.assertNotNull(response6, "create Step Result Without Setting Status Response is null.");
		test.log(LogStatus.PASS, "create StepResult Without Setting Status executed successfully.");
		StepresId = new JSONObject(response6.body().asString()).getInt("id");
		System.out.println("StepId:" + StepresId );
		boolean status1 = zapiService.validateStepresult(response6);
		Assert.assertTrue(status1);
		extentReport.endTest(test);
	}

	//Get test step results by execution id
	@Test(priority = 65)
	public void bvt58_getTeststepResultByExecutionId() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		long executionsId = executionId5;			
		Response response = zapiService.getTeststepResultsByExecutionId(basicAuth, executionsId);
		Assert.assertNotNull(response, "Get step result Response is null.");
		test.log(LogStatus.PASS, "Get step result executed successfully.");
		System.out.println("Teststep results:"+response.body().asString());
		boolean status = zapiService.validateGetStepResult(response);
		Assert.assertTrue(status);		
		extentReport.endTest(test);
	}

	// Get test step result by id
	@Test(priority = 66)
	public void bvt66_getTeststepResultByID() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		long orderId = StepresId;	
		Response response = zapiService.getTeststepResults(basicAuth, orderId);
		Assert.assertNotNull(response, "Clone step Response is null.");
		test.log(LogStatus.PASS, "Clone step executed successfully.");
		System.out.println("Teststep results:"+response.body().asString());

		boolean status = zapiService.validateGetStepResultById(response);
		Assert.assertTrue(status);
		extentReport.endTest(test);
	}

	// Update test step result to default status (e.g. Blocked)
	@Test(priority = 67)
	public void bvt67_updateTeststepResult() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Stepresult json = new Stepresult();
		List<String> values = new ArrayList<>();
		values.add("PROJ2-2");
		json.setdefectList(values);			
		json.setExecutionId(executionId5);
		long id = StepresId;			
		json.setStatus(4);
		json.setUpdateDefectList("true");
		payload = json.toString();

		Response response = zapiService.updateTeststepResults(basicAuth, id, payload);
		Assert.assertNotNull(response, "Clone step Response is null.");
		test.log(LogStatus.PASS, "Clone step executed successfully.");
		System.out.println(response.body().asString());		
		boolean status = zapiService.validateUpdateStepResult(response);
		extentReport.endTest(test);
	}

	// Get defects linked to test step result
	@Test(priority = 68)
	public void bvt68_getStepResultDefects() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String stepResultId = Long.toString(StepresId);			
		Response response = zapiService.getStepResultsDefects(basicAuth, stepResultId);
		Assert.assertNotNull(response, "Clone step Response is null.");
		test.log(LogStatus.PASS, "Clone step executed successfully.");
		System.out.println(response.body().asString());
		boolean status = zapiService.validateStepResultDefects(response);
		extentReport.endTest(test);
	}

	// Get step defects by execution
	@Test(priority = 69)
	public void bvt69_getStepDefectsByExecutionID() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Stepresult json = new Stepresult();		
		json.setExecutionId(executionId5);		
		Response response = zapiService.getStepDefectsByExecution(basicAuth, executionId5);
		Assert.assertNotNull(response, "Clone step Response is null.");
		test.log(LogStatus.PASS, "Clone step executed successfully.");
		System.out.println(response.body().asString());
		extentReport.endTest(test);
		boolean status = zapiService.validateStepDefectsByExecutionID(response);
		extentReport.endTest(test);
	}

	//Add attachment to execution (jpeg)	
	@Test(priority = 70)
	public void bvt70_addAttachment() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String entityId = Long.toString(executionId5);		
		String entityType = "SCHEDULE";
		String fileName = "attachment.png";
		Response response = zapiService.addAttachment(basicAuth, entityId, entityType, fileName);
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response.body().asString());
		boolean status = zapiService.validateAddAttachment(response);
		Assert.assertTrue(status);
		extentReport.endTest(test);
	}

	// Add attachment to test step result (txt)
	@Test(priority = 71)
	public void bvt71_addAttachment() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String entityId =Long.toString(StepresId);		
		String entityType = "TESTSTEPRESULT";
		String fileName = "attachment.png";
		Response response = zapiService.addAttachmentToStepResult(basicAuth, entityId, entityType, fileName);
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response.body().asString());
		boolean status = zapiService.validateAddAttachment(response);
		Assert.assertTrue(status);
		extentReport.endTest(test);
	}

	// Get attachment By executionId
	@Test(priority = 72)
	public void bvt72_getAttachment() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String entityId = Long.toString(executionId5);
		String entityType = "execution";		
		Response response2 = zapiService.getAttachment(basicAuth, entityId, entityType);
		Assert.assertNotNull(response2, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response2.body().asString());
		testAttachmentId = new JSONObject(response2.body().asString()).getJSONArray("data").getJSONObject(0).getString("fileId");
		extentReport.endTest(test);
		boolean status = zapiService.validateGetAttachment(response2);
		Assert.assertTrue(status);
		extentReport.endTest(test);
	}

	// Get attachment By StepResult id
	@Test(priority = 73)
	public void bvt73_getAttachment() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String entityId =Long.toString(StepresId);
		String entityType = "TESTSTEPRESULT";
		Response response2 = zapiService.getAttachment(basicAuth, entityId, entityType);
		Assert.assertNotNull(response2, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response2.body().asString());
		teststepAttachmentId = new JSONObject(response2.body().asString()).getJSONArray("data").getJSONObject(0).getString("fileId");
		boolean status = zapiService.validateGetAttachment(response2);
		Assert.assertTrue(status);
		extentReport.endTest(test);

	}
	// Get Testlevel attachment by passing attachment ID if attachment is of different types
	@Test(priority = 74)
	public void bvt74_getAttachment() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String attchmentId = testAttachmentId;
		Response response = zapiService.getAttachmentById(basicAuth, attchmentId);
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response.body().asString());
		boolean status = zapiService.validateGetAttachment(response);
		Assert.assertTrue(status);
		extentReport.endTest(test);

	}

	// Get Steplevel attachment by passing attachment ID if attachment is of different types
	@Test(priority = 75)
	public void bvt75_getAttachment() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String attchmentId = teststepAttachmentId;
		Response response = zapiService.getAttachmentById(basicAuth, attchmentId);
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response.body().asString());
		boolean status = zapiService.validateGetAttachment(response);
		Assert.assertTrue(status);
		extentReport.endTest(test);

	}

	// Delete attachment to an execution
	@Test(priority = 76)
	public void bvt76_deleteAttachment() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String attchmentId = testAttachmentId;
		Response response = zapiService.deleteAttachmentToExecution(basicAuth, attchmentId);
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response.body().asString());
		boolean status = zapiService.validateDeleteAttachment(response);
		Assert.assertTrue(status);
		extentReport.endTest(test);

	}

	// Delete attachment to an step Result
	@Test(priority = 77)
	public void bvt77_deleteAttachment() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String attchmentId = teststepAttachmentId;
		Response response = zapiService.deleteAttachmentToStepResult(basicAuth, attchmentId);
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response.body().asString());
		boolean status = zapiService.validateDeleteAttachment(response);
		Assert.assertTrue(status);
		extentReport.endTest(test);

	}

	//Get ZQL clauses
	@Test(priority = 78)
	public void bvt78_getZqlClauses() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Response response = zapiService.getClauses(basicAuth);
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validategetZql(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get autocomplete JSON fields and reserved words
	@Test(priority = 79)
	public void bvt79_getZQLAutocompleteJson() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Response response = zapiService.autoCompleteZQLJson(basicAuth);
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validategetAutocompleteJson(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get autocomplete values for executionStatus
	@Test(priority = 80)
	public void bvt80_getZQLAutocomplete() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String fieldName = "executionStatus";
		String fieldValue = "p";
		Response response = zapiService.getZQLAutocomplete(basicAuth, fieldName, fieldValue);
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validategetZQLAutocomplete(fieldValue, response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Get logged in user
	@Test(priority = 81)
	public void bvt81_loggedinUser() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("Automation API BVT Suite - Zapi");

		Response response = zapiService.loggedinUser(basicAuth);
		Assert.assertNotNull(response, "loggedinuser Api Response is null.");
		test.log(LogStatus.PASS, "Loggedinuser Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateloggedInUser(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);

	}

	// Create execution filter (global, favorite)
	@Test(priority = 82)
	public void bvt82_createExecutionFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		ExecutionFilter filJson = new ExecutionFilter();
		filJson.setQuery("executionStatus = Unexecuted");
		filJson.setFilterName("Apifilter1");
		Response response = zapiService.createExecutionfilter(basicAuth, filJson.toString());
		Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");

		System.out.println(response.getBody().asString());
		boolean status = zapiService.validateCreateExecutionfilter(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Create execution (private, non-favorite)
	@Test(priority = 83)
	public void bvt83_createPrivateFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		ExecutionFilter filJson = new ExecutionFilter();
		filJson.setQuery("assignee = vm_admin");
		filJson.setFilterName("Api Privatefilter1");
		filJson.setIsFavorite(false);
		filJson.setSharePerm(2);
		Response response = zapiService.createExecutionfilter(basicAuth, filJson.toString());
		Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");

		System.out.println(response.getBody().asString());	
		executionfilterId = new JSONObject(response.body().asString()).getLong("id");
		boolean status = zapiService.validateCreateExecutionfilter(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Update execution filter - add description
	@Test(priority = 84)
	public void bvt84_updateExecutionFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		ExecutionFilter filJson = new ExecutionFilter();
		filJson.setDescription("filterDescription updated sucessfully");
		filJson.setId(executionfilterId);		
		Response response = zapiService.updateExecutionfilter(basicAuth, filJson.toString());
		Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateUpdateExecutionFilter(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Rename execution filter
	@Test(priority = 85)
	public void bvt85_renameExecutionFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		ExecutionFilter filJson = new ExecutionFilter();
		filJson.setId(executionfilterId);		
		filJson.setFilterName("Filter renamed1");
		Response response = zapiService.renameExecutionfilter(basicAuth, filJson.toString());
		Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateRenamedFilter(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Copy execution filter created by another user (global/favorite)
	@Test(priority = 86)
	public void bvt86_copyExecutionFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		ExecutionFilter filJson = new ExecutionFilter();
		filJson.setId(executionfilterId);		
		filJson.setFilterName("Filter copied1");
		Response response = zapiService.copyExecutionfilter(basicAuth, filJson.toString());
		Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateCopyExecutionFilter(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Get execution filter by id
	@Test(priority = 87)
	public void bvt87_getExecutionFilterById() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String FilterId = Long.toString(executionfilterId);		
		Response response = zapiService.getfilterById(basicAuth, FilterId);
		Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetExecutionFilter(response, FilterId);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Search execution filter by name
	@Test(priority = 88)
	public void bvt88_searchExecutionFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		ExecutionFilter filJson = new ExecutionFilter();
		filJson.setQuery("cycleName = \"Ad hoc\"");
		filJson.setFilterName("Apifilter2");
		Response response = zapiService.createExecutionfilter(basicAuth, filJson.toString());
		Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
		String payload = "Apifilter2";		
		Response response1 = zapiService.searchExecutionfilter(basicAuth, payload);
		System.out.println(response1.getBody().asString());
		Assert.assertNotNull(response1, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");

		boolean status = zapiService.validatesearchExecutionFilter(response1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Add execution filter created by another user as favorite
	@Test(priority = 89)
	public void bvt89_toggleFavFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");
		{

			ExecutionFilter filJson = new ExecutionFilter();
			filJson.setQuery("executionStatus = Unexecuted");
			filJson.setFilterName("User filter");
			basicAuth = RestUtils.basicAuthRequest(Config.getValue("jiraUserName"), Config.getValue("jiraUserPassword"));
			Response response = zapiService.createExecutionfilter(basicAuth, filJson.toString());
			Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
			test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");
			System.out.println(response.body().asString());
			userexefilterId = new JSONObject(response.body().asString()).getLong("id");
			System.out.println(userexefilterId);
		}
		ExecutionFilter filJson1 = new ExecutionFilter();
		filJson1.setId(userexefilterId);
		filJson1.setIsFavorite(true);
		System.out.println(filJson1.toString());
		basicAuth = RestUtils.basicAuthRequest(Config.getValue("adminUserName"), Config.getValue("adminPassword"));
		Response response1 = zapiService.toggleFavouriteFilter(basicAuth, filJson1.toString());
		Assert.assertNotNull(response1, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");
		System.out.println(response1.getBody().asString());

		boolean status = zapiService.validateToggleFavFilter(response1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Delete execution filter
	@Test(priority = 90)
	public void bvt90_deleteExecutionFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String id = Long.toString(executionfilterId);		
		Response response = zapiService.deleteFilter(basicAuth, id);
		Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateDeleteExecutionFilter(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get all favorite filters
	@Test(priority = 91)
	public void bvt91_getFavFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String fav = "true";
		Response response = zapiService.getFavFilter(basicAuth, fav);
		Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetFavFilter(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Create column selection for an execution filter
	@Test(priority = 92)
	public void bvt92_createColumnSelection() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		ExecutionFilter filJson = new ExecutionFilter();
		filJson.setQuery("executionStatus != Unexecuted");
		filJson.setFilterName("Apifilter2dd");
		Response response = zapiService.createExecutionfilter(basicAuth, filJson.toString());
		Assert.assertNotNull(response, "CreateExecutionfilter Api Response is null.");
		exefilterid1 = new JSONObject(response.getBody().asString()).getLong("id");
				
		List<Object> val= new ArrayList<>();		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("filterIdentifier", "Cycle Name");		
		map1.put("visible", true);		
		map1.put("orderId", 0);	
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("filterIdentifier", "Issue Key");		
		map2.put("visible", true);		
		map2.put("orderId", 1);	
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("filterIdentifier", "Test Summary");		
		map3.put("visible", true);		
		map3.put("orderId", 2);	
		
		val.add(map1);
		val.add(map2);
		val.add(map3);
				
		Znav json = new Znav();
		json.setUserName("vm_admin");
		json.setExecutionFilterId(Long.toString(exefilterid1));
		json.setColumnItemBean(val);
		payload = json.toString();
		Response response1 = zapiService.createColumnSelection(basicAuth, payload);
		Assert.assertNotNull(response1, "CreateExecutionfilter Api Response is null.");
		System.out.println(response1.getBody().asString());
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");
		
		boolean status = zapiService.validatecreateColumnSelection(response1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get available columns for an execution filter
	@Test(priority = 93)
	public void bvt93_getColumnSelection() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		long executionFilterId = exefilterid1;		
		Response response1 = zapiService.getColumnSelection(basicAuth, executionFilterId);
		Assert.assertNotNull(response1, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");
		System.out.println(response1.getBody().asString());
		columnSelectorId = new JSONObject(response1.getBody().asString()).getLong("id");
				
		boolean status = zapiService.validategetColumnSelection(response1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}	

	//Update column selection for an execution filter
	@Test(priority = 94)
	public void bvt94_updateColumnSelection() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		List<Object> val= new ArrayList<>();		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("filterIdentifier", "Cycle Name");		
		map1.put("visible", false);		
		map1.put("orderId", 0);	
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("filterIdentifier", "Issue Key");		
		map2.put("visible", false);		
		map2.put("orderId", 1);	
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("filterIdentifier", "Test Summary");		
		map3.put("visible", true);		
		map3.put("orderId", 2);
		
		Map<String, Object> map4 = new HashMap<>();
		map4.put("filterIdentifier", "Project Name");		
		map4.put("visible", true);		
		map4.put("orderId", 3);
		
		Map<String, Object> map5 = new HashMap<>();
		map5.put("filterIdentifier", "Priority");		
		map5.put("visible", true);		
		map5.put("orderId", 4);
		
		Map<String, Object> map6 = new HashMap<>();
		map6.put("filterIdentifier", "Execution Status");		
		map6.put("visible", true);		
		map6.put("orderId", 5);
		
		val.add(map1);
		val.add(map2);
		val.add(map3);
		val.add(map4);
		val.add(map5);
		val.add(map6);
				
		Znav json = new Znav();
		json.setUserName("vm_admin");
		json.setExecutionFilterId(Long.toString(exefilterid1));		
		json.setColumnItemBean(val);
		payload = json.toString();		
		long id = columnSelectorId;
		Response response1 = zapiService.updateColumnSelection(basicAuth, id, payload);
		Assert.assertNotNull(response1, "CreateExecutionfilter Api Response is null.");
		test.log(LogStatus.PASS, "CreateExecutionfilter status Api executed successfully.");		
		System.out.println(response1.getBody().asString());		
		
		boolean status = zapiService.validateupdateColumnSelection(response1);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}	
	
	//Get exeuction details and the position of the execution in the zql query's results
		@Test(priority = 95)
		public void bvt95_getExecutionDetailsInZql() {
			ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			test.assignCategory("ZAPI Server BVT Suite");

			Cycle cycleJson = new Cycle();
			cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
			cycleJson.setVersionId(Long.parseLong(Config.getValue("version5Id")));
			cycleJson.setName("Cycle created through API10");
			Response response = zapiService.createCycle(basicAuth, cycleJson.toString());
			Assert.assertNotNull(response, "Create Cycle Api Response is null.");
			String cycleId = new JSONObject(response.body().asString()).get("id").toString();		
			
			Execution executionJson = new Execution();		
			executionJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
			executionJson.setVersionId(Long.parseLong(Config.getValue("version5Id")));
			executionJson.setCycleId(cycleId);
			executionJson.setMethod(2);
			executionJson.setSearchId(10002l);
			Response response1 = zapiService.addTestsToCycle(basicAuth, executionJson.toString());
			
			long projectId = Long.parseLong(Config.getValue("project1Id"));
			long versionId = Long.parseLong(Config.getValue("version5Id"));			
			Response response2 = zapiService.getExecutionsByCycle(basicAuth, projectId, versionId, cycleId);		
			String id1 = (new JSONObject(response2.body().asString()).getJSONArray("executions").getJSONObject(0).get("id")).toString();
						
			ExecutionFilter filJson = new ExecutionFilter();
			filJson.setQuery("executionStatus = Unexecuted");
			filJson.setFilterName("Apifilter10");
			Response response3 = zapiService.createExecutionfilter(basicAuth, filJson.toString());
						
			long id = Long.parseLong(id1);
			String zql = "executionStatus = Unexecuted";																
			Response response4 = zapiService.getExecutionDetailsInZql(basicAuth, id, zql);
			System.out.println(response4.getBody().asString());

			boolean status = zapiService.validategetExecutionDetailsInZql(response4);
			Assert.assertTrue(status, "Response Validation Failed.");
			test.log(LogStatus.PASS, "Response validated successfully.");
			extentReport.endTest(test);
		}	

	//Quick search for execution filters		
	@Test(priority = 96)
	public void bvt96_quickSearchZQLFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String fieldName = "filter";																
		Response response = zapiService.quickSearchZQLFilter(basicAuth, fieldName);
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validatequickSearchZQLFilter(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}	

	//Get tests count by project (30-day summary)		
	@Test(priority = 97)
	public void bvt97_getTestCreated() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String projectKey = Config.getValue("project1Key");	
		int daysPrevious = 30;
		String periodName = "daily";
		Response response = zapiService.getTestCreated(basicAuth, projectKey, daysPrevious, periodName);
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetTestCreated(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get issue statuses by project
	@Test(priority = 98)
	public void bvt98_getIssueStatuses() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		long projectId =Long.parseLong(Config.getValue("project1Id"));					
		Response response = zapiService.getIssueStatuses(basicAuth, projectId);
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetIssueStatuses(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}					

	// Get tests by search filter id >>>Need to give jira filter id
	@Test(priority = 99)
	public void bvt99_getTestBySearchFilterId() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Long Id = 10002l;
		Response response = zapiService.getTestByFilterId(basicAuth, Id);
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response.body().asString());

		boolean status = zapiService.validateGetTestByFilterId(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Get tests count in a given version group by user (test distribution)
	@Test(priority = 100)
	public void bvt100_getTestCountGroupByUser() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String groupFld = "user";
		Long projectID = Long.parseLong(Config.getValue("project1Id"));
		Long VersionId = Long.parseLong(Config.getValue("version1Id"));
		Response response = zapiService.testCount(basicAuth, groupFld, projectID, VersionId);
		Assert.assertNotNull(response, "Get tests count in a given version group by user Response is null.");
		test.log(LogStatus.PASS, "Get tests count in a given version group by user executed successfully.");
		System.out.println(response.body().asString());

		boolean status = zapiService.validateGetTestCountGroupByUser(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get execution count by project (30-day summary)
	@Test(priority = 101)
	public void bvt101_getExecutionCount() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");		

		Long projectId = 10000l;
		String groupFld = "timePeriod";
		String daysPrevious = "30";
		String periodName = "daily";
		Response response = zapiService.getExecutionCount(basicAuth, projectId, groupFld, daysPrevious, periodName);
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetExecutionCount(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get execution count in a given version group by user (test execution gadget)
	@Test(priority = 102)
	public void bvt102_getExecutionCountGroupByUser() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Long projectId = 10000l;
		String groupFld = "user";
		Long versionId = -1l;
		String daysPrevious = "30";
		String periodName = "daily";		
		Response response = zapiService.getExecutionCountGroupByUser(basicAuth, projectId, versionId, groupFld, daysPrevious, periodName);
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetExecutionCountGroupByUser(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get test execution count by �sprint-cycle� (test execution gadget) 				
	@Test(priority = 103)
	public void bvt103_getExecutionCountBySprint() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");	

		Long projectId = 10000l;
		String groupFld = "sprint-cycle";
		Long versionId = 10000l;
		Response response = zapiService.getExecutionCountBySprint(basicAuth, projectId, versionId, groupFld );
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetExecutionCountBySprint(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}	

	//Get execution count by cycle as burndown	
	@Test(priority = 104)
	public void bvt104_getExecutionCountAsBurndown() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Long projectId = 10000l;
		Long versionId = 10000l;
		String groupFld = "timePeriod";
		String cycleId = "-1";
		String graphType = "burndown";
		String daysPrevious = "30";
		String periodName = "daily";		
		Response response = zapiService.getExecutionCountAsBurndown(basicAuth, projectId, versionId, cycleId, groupFld, graphType );
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetExecutionCountAsBurndown(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}
	//Get execution count by sprint as burndown	
	@Test(priority = 105)
	public void bvt105_getExecutionCountAsSprintBurndown() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Long projectId = 10000l;
		Long versionId = 10000l;
		String groupFld = "timePeriod";
		String sprintId = "1";
		String graphType = "burndown";
		Response response = zapiService.getExecutionCountAsSprintBurndown(basicAuth, projectId, versionId, sprintId, groupFld, graphType );
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetExecutionCountAsSprintBurndown(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Get top defects by issue statuses (1|3|4)	
	@Test(priority = 106)
	public void bvt106_getTopDefects() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Long projectId = 10000l;
		Long versionId = -1l;
		Long issueStatuses = 10000l;							
		Response response = zapiService.getTopDefects(basicAuth, projectId, versionId, issueStatuses);
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetTopDefects(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Search executions by test
	@Test(priority = 107)
	public void bvt107_searchExecutionsByTest()
	{
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Issue issuePayLoad = new Issue();
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Test");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));			
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		issueId = new JSONObject(response.body().asString()).getLong("id");
		issueKey = new JSONObject(response.getBody().asString()).getString("key");

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(-1l);
		cycleJson.setName("Cycle created through API");
		Response response1 = zapiService.createCycle(basicAuth, cycleJson.toString());			
		Assert.assertNotNull(response1, "Create Cycle Api Response is null.");			
		cycleId = new JSONObject(response1.body().asString()).get("id").toString();

		Execution json = new Execution();
		json.setIssueId(issueId);
		json.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		json.setVersionId(-1l);
		json.setCycleId(cycleId);
		payload = json.toString();
		Response response2 = zapiService.createExecution(basicAuth, payload);
		System.out.println(response2.getBody().asString());

		String testIdOrKey = issueKey;
		int maxResult = 10;
		int offset = 0;
		Response response3 = zapiService.searchExecutionsByTest(basicAuth, testIdOrKey, maxResult, offset );
		Assert.assertNotNull(response3, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateSearchExecutionsByTest(response3);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Search tests by requirement
	@Test(priority = 108)
	public void bvt108_searchExecutionsByRequirement()
	{
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");
		test.assignAuthor("Priyanka");

		Issue issuePayLoad = new Issue();
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Issuetype-Test");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));			
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		long issueId = new JSONObject(response.body().asString()).getLong("id");
		String issueKey1 = new JSONObject(response.getBody().asString()).getString("key");Teststep teststepJson = new Teststep();
		teststepJson.setStep("step1");
		teststepJson.setData("data1");
		teststepJson.setResult("result1");
		Response response1 = zapiService.createTeststep(basicAuth, issueId, teststepJson.toString());
		Response response2 = zapiService.getTeststep(basicAuth, issueId);
		long teststepId = new JSONArray(response2.body().asString()).getJSONObject(0).getLong("id");

		//Create requirement	
		Issue issuePayLoad1 = new Issue();
		issuePayLoad1.setProject(Config.getValue("project1Id"));
		issuePayLoad1.setIssuetype(Config.getValue("issueTypeStoryId"));
		issuePayLoad1.setSummary("Issuetype-Story");
		issuePayLoad1.setPriority("3");
		issuePayLoad1.setReporter(Config.getValue("adminUserName"));			
		Response response3 = jiraService.createIssue(basicAuth, issuePayLoad1.toString());
		String issueKey2 = new JSONObject(response3.getBody().asString()).getString("key");
		issueId3 = new JSONObject(response3.body().asString()).getLong("id");

		//Create defects
		Issue issuePayLoad2 = new Issue();
		issuePayLoad2.setProject(Config.getValue("project1Id"));
		issuePayLoad2.setIssuetype(Config.getValue("issueTypeBugId"));
		issuePayLoad2.setSummary("Issuetype-bug1");
		issuePayLoad2.setPriority("3");
		issuePayLoad2.setReporter(Config.getValue("adminUserName"));			
		Response response10 = jiraService.createIssue(basicAuth, issuePayLoad2.toString());
		issueKey3 = new JSONObject(response10.getBody().asString()).getString("key");
		issueId4 = new JSONObject(response3.body().asString()).getLong("id");

		Issue issuePayLoad4 = new Issue();
		issuePayLoad4.setProject(Config.getValue("project1Id"));
		issuePayLoad4.setIssuetype(Config.getValue("issueTypeBugId"));
		issuePayLoad4.setSummary("Issuetype-bug2");
		issuePayLoad4.setPriority("3");
		issuePayLoad4.setReporter(Config.getValue("adminUserName"));			
		Response response11= jiraService.createIssue(basicAuth, issuePayLoad4.toString());
		issueKey4 = new JSONObject(response11.getBody().asString()).getString("key");

		//Link requirement to tests	
		Issuelink json = new Issuelink();
		json.setLinktype("Duplicate");
		json.setInwardIssue(issueKey1);
		json.setOutwardIssue(issueKey2);
		payload = json.toString();
		Response response4 = jiraService.createIssueLink(basicAuth, payload);

		Cycle cycleJson = new Cycle();
		cycleJson.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		cycleJson.setVersionId(-1l);
		cycleJson.setName("Cycle created through API");
		Response response5 = zapiService.createCycle(basicAuth, cycleJson.toString());			
		cycleId = new JSONObject(response5.body().asString()).get("id").toString();

		Execution json1 = new Execution();
		json1.setIssueId(issueId);
		json1.setProjectId(Long.parseLong(Config.getValue("project1Id")));
		json1.setVersionId(-1l);
		json1.setCycleId(cycleId);
		payload = json1.toString();
		Response response6 = zapiService.createExecution(basicAuth, payload);

		long projectId = Long.parseLong(Config.getValue("project1Id"));
		long versionId = -1l;
		Response response7 = zapiService.getExecutionsByCycle(basicAuth,projectId, versionId, cycleId);
		long executionId = new JSONObject(response7.getBody().asString()).getJSONArray("executions").getJSONObject(0).getLong("id");
		
		String id = Long.toString(executionId);
		List<String> value = new ArrayList<>();
		value.add(issueKey3);
		Execution json3 = new Execution();
		json3.setDefectList(value);
		json3.setIssueId(issueId);
		json3.setUpdateDefectList("true");
		payload = json3.toString();
		Response response9 = zapiService.executeTest(basicAuth, id, payload );	

		Long executionsId =executionId;
		System.out.println(executionsId);		
		Response response13 = zapiService.getTeststepResultsByExecutionId(basicAuth, executionsId);
		System.out.println(response13.body().asString());
		long stepId = new JSONArray(response13.body().asString()).getJSONObject(0).getLong("stepId");
		long id2 = new JSONArray(response13.body().asString()).getJSONObject(0).getLong("id");

		List<String> values = new ArrayList<>();
		values.add(issueKey4);
		Stepresult json5 = new Stepresult();
		json5.setdefectList(values);	
		json5.setExecutionId(executionId);		
		json5.setUpdateDefectList("true");
		json5.setStatus(1);
		payload = json5.toString();
		Response response12 = zapiService.updateTeststepResults(basicAuth, id2, payload);

		String requirementIdOrKeyList = issueKey2;
		Response response14 = zapiService.searchExecutionsByRequirement(basicAuth, requirementIdOrKeyList);
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response14.getBody().asString());

		boolean status = zapiService.validateSearchExecutionsByRequirement(response14);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Search executions by defect at test level
	@Test(priority = 109)
	public void bvt109_searchExecutionsByDefect()
	{
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String defectIdOrKey = issueKey3;
		System.out.println(defectIdOrKey);
		Response response = zapiService.searchExecutionsByDefect(basicAuth, defectIdOrKey);
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateSearchExecutionsByDefect(response);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}		

	//Search executions by defect at step level
	@Test(priority = 110)
	public void bvt110_searchExecutionsByDefect()
	{
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String defectIdOrKey = issueKey4;
		Response response = zapiService.searchExecutionsByDefect(basicAuth, defectIdOrKey);
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateSearchExecutionsByDefect(response);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}		

	//Search defect statistics by defect list
	@Test(priority = 111)
	public void bvt111_searchDefectStatistics()
	{
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String defectIdOrKeyList = issueKey3;
		Response response = zapiService.searchDefectStatistics(basicAuth, defectIdOrKeyList);
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateSearchDefectStatistics(response);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	//Export requirement to defects traceability report in Excel format
	@Test(priority = 112)
	public void bvt112_exportTraceability()
	{
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		ExportTraceability json = new ExportTraceability();
		List<Long> values = new ArrayList<>();
		values.add(issueId3);		
		json.setRequirementIdList(values);
		json.setExportType("excel");
		json.setVersionId(0l);
		payload = json.toString();
		Response response = zapiService.exportTraceability(basicAuth, payload);
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateExportTraceability(response);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}				

	//Export defects to requirements  traceability report  in HTML format
	@Test(priority = 113)
	public void bvt113_exportTraceability()
	{
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		ExportTraceability json = new ExportTraceability();
		List<Long> values = new ArrayList<>();
		values.add(issueId4);		
		json.setDefectIdList(values);
		json.setExportType("html");
		json.setVersionId(0l);
		payload = json.toString();
		Response response = zapiService.exportTraceability(basicAuth, payload);
		Assert.assertNotNull(response, "Create Execution Api Response is null.");
		test.log(LogStatus.PASS, "Update Cycle Api executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateExportTraceability(response);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}					

	//Get Index executions
	@Test(priority = 114)
	public void test114_indexExecution() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Response response = zapiService.indexExecution(basicAuth);		
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response.getBody().asString());
		boolean status = zapiService.validateIndexExecution(response);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Get index status
	@Test(priority = 115)
	public void test115_indexStatus() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		Response response = zapiService.indexExecution(basicAuth);
		Assert.assertNotNull(response, "Index execution Response is null.");
		test.log(LogStatus.PASS, "Index execution executed successfully.");
		long tokenNo = new JSONObject(response.body().asString()).getLong("token");
		System.out.println("Token is :" + tokenNo);
		Response response1 = zapiService.indexStatus(basicAuth, tokenNo);
		Assert.assertNotNull(response1, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response1.body().asString());

		boolean status = zapiService.validategetindexStatus(response1);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Refresh remote links
	@Test(priority = 116)
	public void test116_refreshReomteLinks() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		List<String> list = new ArrayList<>();
		list.add(executionId2);
		list.add(executionId3);		
		List<String> list1 = new ArrayList<>();
		list1.add("PROJ2-1");
		list1.add("PROJ2-2");
		BulkExecution execJson = new BulkExecution();
		execJson.setExecutions(list);
		execJson.setDefects(list1);				
		Response response = zapiService.bulkUpdateDefects(basicAuth, execJson.toString());

		String issueLinkTypeId = "10002";
		Response response1 = zapiService.RefreshTheRemoteLinks(basicAuth, issueLinkTypeId);
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response1.body().asString());

		boolean status = zapiService.validaterefreshReomteLinks(response1);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);

	}

	// Get all audit logs for execution
	@Test(priority = 117)
	public void test117_getAuditLogs() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		String entityType = "EXECUTION";
		int offset = 0;
		int maxRecords = 20;
		Response response = zapiService.getAuditLogs(basicAuth, entityType, offset, maxRecords);
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");		
		extentReport.endTest(test);
		entityId = new JSONObject(response.body().asString()).getJSONArray("auditLogs").getJSONObject(0).getLong("executionId");
		System.out.println("entityId:"+entityId);

		boolean status = zapiService.validateAuditLogs(response);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}

	// Get audit logs for execution by execution id
	@Test(priority = 118)
	public void test118_getAuditByExecutionId() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.assignCategory("ZAPI Server BVT Suite");

		long executionId = entityId ;		
		int offset = 0;
		int maxRecords = 20;
		Response response = zapiService.getAuditByExecutionId(basicAuth, offset, maxRecords,executionId);
		Assert.assertNotNull(response, "Index status Response is null.");
		test.log(LogStatus.PASS, "Index status executed successfully.");
		System.out.println(response.getBody().asString());

		boolean status = zapiService.validateGetAuditByExecutionId(response);
		Assert.assertTrue(status, "Not validated added attachment");
		test.log(LogStatus.PASS, "Response validated successfully.");
		extentReport.endTest(test);
	}
}
