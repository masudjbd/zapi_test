package com.thed.zephyr.startupdata;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thed.zephyr.BaseTest;
import com.thed.zephyr.Config;
import com.thed.zephyr.model.Teststep;
import com.thed.zephyr.model.jira.Component;
import com.thed.zephyr.model.jira.Filter;
import com.thed.zephyr.model.jira.Issue;
import com.thed.zephyr.model.jira.Issuelink;
import com.thed.zephyr.model.jira.Project;
import com.thed.zephyr.model.jira.Sprint;
import com.thed.zephyr.model.jira.User;
import com.thed.zephyr.model.jira.Version;
import com.thed.zephyr.service.jira.impl.JiraApiServiceImpl;

public class ApiTest extends BaseTest {

	long issueId;
	String projectkey = null;
	String projectid = null;
	String versionname = null;
	String componentname = null;
	String userkey = null;
	public String payload = null;
	public JSONObject obj = null;

	// Create projects
	@Test(priority = 1)
	public void test1_createProject() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		for (int i = 1, j = 1; i < 3; i++, j++) {
			Project projectPayLoad = new Project();
			projectPayLoad.setKey("PROJ" + i);
			projectPayLoad.setName("Project" + j);
			projectPayLoad.setProjectTypeKey("software");
			projectPayLoad.setProjectTemplateKey("com.pyxis.greenhopper.jira:gh-scrum-template");
			projectPayLoad.setLead("vm_admin");
			Response response = jiraService.createProject(basicAuth,projectPayLoad.toString());
			Assert.assertNotNull(response,"Create Project Api Response is null.");

			boolean status = jiraService.validateCreateProject(response);
			Assert.assertTrue(status, "Response Validation Failed.");
			projectkey = new JSONObject(response.body().asString()).get("key").toString();
			System.out.println("projectkey:"+projectkey);
		}
	}

	// Create versions in project1
	@Test(priority = 2)
	public void test2_createVersion() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		for (int i = 1; i < 6; i++) {
			Version versionPayLoad = new Version();
			versionPayLoad.setProject("PROJ1");
			versionPayLoad.setName("Version" + i);
			versionPayLoad.setDescription("An excellent version");
			Response response = jiraService.createVersion(basicAuth,versionPayLoad.toString());
			Assert.assertNotNull(response,"Create Version Api Response is null.");

			boolean status = jiraService.validateCreateVersion(response);
			Assert.assertTrue(status, "Response Validation Failed.");
			versionname = new JSONObject(response.body().asString()).get("id").toString();
			System.out.println("versionname:"+versionname);
		}
	}

	// Create components in project1
	@Test(priority = 3)
	public void test3_createComponent() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		for (int i = 1; i < 6; i++) {
			Component componentPayLoad = new Component();
			componentPayLoad.setName("Component" + i);
			componentPayLoad.setDescription("This is a JIRA component");
			componentPayLoad.setAssigneeType("PROJECT_LEAD");
			componentPayLoad.setProject("PROJ1");
			Response response = jiraService.createComponent(basicAuth,componentPayLoad.toString());
			Assert.assertNotNull(response,"Create Component Api Response is null.");

			boolean status = jiraService.validateCreateComponent(response);
			Assert.assertTrue(status, "Response Validation Failed.");
			componentname = new JSONObject(response.body().asString()).get("name").toString();
			System.out.println("componentname:"+componentname);
		}
	}

	// Create user
	@Test(priority = 4)
	public void test4_createUser() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());

		User userPayLoad = new User();
		userPayLoad.setName("Jira_user");
		userPayLoad.setPassword("password");
		userPayLoad.setEmailAddress("jirauser@atlassian.com");
		userPayLoad.setDisplayName("Jira_user");
		List<String> values = new ArrayList<String>();
		values.add("jira-software");
		userPayLoad.setApplicationKeys(values);
		Response response = jiraService.createUser(basicAuth,userPayLoad.toString());
		Assert.assertNotNull(response, "Create User Api Response is null.");

		boolean status = jiraService.validateCreateUser(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		userkey = new JSONObject(response.body().asString()).get("key").toString();
		System.out.println("userkey:"+userkey);
	}

	// Create 2 issues of type bug in Project2

	@Test(priority = 5)
	public void test5_createIssue() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		for (int i = 0; i < 2; i++) {
			Issue issuePayLoad = new Issue();		
			issuePayLoad.setProject(Config.getValue("project2Id"));
			issuePayLoad.setIssuetype(Config.getValue("issueTypeBugId"));
			issuePayLoad.setSummary("Issue type-Bug");
			issuePayLoad.setPriority("3");
			issuePayLoad.setReporter(Config.getValue("adminUserName"));		
			Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
			//System.out.println(response.body().asString());
			Assert.assertNotNull(response, "Create Issue Api Response is null.");

			boolean status = jiraService.validateCreateIssueApi(response);
			Assert.assertTrue(status, "Response Validation Failed.");
			issueId = new JSONObject(response.body().asString()).getLong("id");
			System.out.println("issueId:"+issueId);
		}
	}

	// Create 14 Issues of type test in Project1

	@Test(priority = 6)
	public void test6_createIssue() {
		ExtentTest test = extentReport.startTest(Thread.currentThread()
				.getStackTrace()[1].getMethodName());
		for (int i = 0; i < 12; i++) {
			Issue issuePayLoad = new Issue();
			issuePayLoad.setProject(Config.getValue("project1Id"));
			issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
			issuePayLoad.setSummary("First test");
			issuePayLoad.setPriority("3");
			issuePayLoad.setReporter(Config.getValue("adminUserName"));
			Response response = jiraService.createIssue(basicAuth,issuePayLoad.toString());
			Assert.assertNotNull(response, "Create Issue Api Response is null.");

			boolean status = jiraService.validateCreateIssueApi(response);
			issueId = new JSONObject(response.body().asString()).getLong("id");
			//System.out.println("test id is :" + issueId);

			Teststep teststepJson = new Teststep();
			teststepJson.setStep("Teststep");
			teststepJson.setData("Testdata");
			teststepJson.setResult("Testresult");
			Response response1 = zapiService.createTeststep(basicAuth, issueId, teststepJson.toString());
		}
		for (int j = 0; j < 2; j++) {
			Issue issuePayLoad = new Issue();
			issuePayLoad.setProject(Config.getValue("project1Id"));
			issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
			issuePayLoad.setSummary("First test");
			issuePayLoad.setPriority("3");
			issuePayLoad.setReporter(Config.getValue("adminUserName"));
			List<String> fixVersions = new ArrayList<>();
			fixVersions.add("10000");
			issuePayLoad.setFixVersions("10000");
			Response response = jiraService.createIssue(basicAuth,issuePayLoad.toString());
			Assert.assertNotNull(response, "Create Issue Api Response is null.");

			boolean status = jiraService.validateCreateIssueApi(response);
			issueId = new JSONObject(response.body().asString()).getLong("id");
			System.out.println("test id is :" + issueId);

			Teststep teststepJson = new Teststep();
			teststepJson.setStep("Teststep");
			teststepJson.setData("Testdata");
			teststepJson.setResult("Testresult");
			Response response1 = zapiService.createTeststep(basicAuth, issueId, teststepJson.toString());
		}
	}


	// Create custom testexecution and teststepexecution status

	// Create search filter
	@Test(priority = 7)
	public void test7_createFilter() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

		Filter filterPayLoad = new Filter();
		filterPayLoad.setName("Filter1");
		filterPayLoad.setDescription("This is a JIRA filter");
		filterPayLoad.setJql("fixVersion = Version1");
		filterPayLoad.setFavourite("true");
		Response response = jiraService.createFilter(basicAuth,filterPayLoad.toString());
		Assert.assertNotNull(response, "Create Component Api Response is null.");
		test.log(LogStatus.PASS, "Create Component Api executed successfully.");

		boolean status = jiraService.validateCreateFilter(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		String filterId = new JSONObject(response.body().asString()).get("id").toString();
		System.out.println("filterId:" + filterId);
	}

	// Create sprint in project1
	@Test(priority = 8)
	public void test8_createSprint() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

		Response response = jiraService.createSprint(basicAuth);
		Assert.assertNotNull(response, "Create Component Api Response is null.");
		test.log(LogStatus.PASS, "Create Component Api executed successfully.");

		boolean status = jiraService.validateCreateSprint(response);
		Assert.assertTrue(status, "Response Validation Failed.");
		String sprintId = new JSONObject(response.body().asString()).get("id").toString();
		System.out.println("sprintId:" + sprintId);
	}	

	// Create issuelink
	//@Test(priority = 9)
	public void test9_createIssueLink() {
		ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

		Issue issuePayLoad = new Issue();
		issuePayLoad.setProject(Config.getValue("project1Id"));
		issuePayLoad.setIssuetype(Config.getValue("issueTypeTestId"));
		issuePayLoad.setSummary("Issuetype-Test");
		issuePayLoad.setPriority("3");
		issuePayLoad.setReporter(Config.getValue("adminUserName"));			
		Response response = jiraService.createIssue(basicAuth, issuePayLoad.toString());
		Assert.assertNotNull(response, "Create Issue Api Response is null.");
		String issueKey1 = new JSONObject(response.getBody().asString()).getString("key");
		System.out.println(issueKey1);

		Issue issuePayLoad1 = new Issue();
		issuePayLoad1.setProject(Config.getValue("project1Id"));
		issuePayLoad1.setIssuetype(Config.getValue("issueTypeStoryId"));
		issuePayLoad1.setSummary("Issuetype-Story");
		issuePayLoad1.setPriority("3");
		issuePayLoad1.setReporter(Config.getValue("adminUserName"));			
		Response response1 = jiraService.createIssue(basicAuth, issuePayLoad1.toString());
		Assert.assertNotNull(response1, "Create Issue Api Response is null.");
		String issueKey2 = new JSONObject(response1.getBody().asString()).getString("key");
		System.out.println(issueKey2);

		Issuelink json = new Issuelink();
		json.setLinktype("Duplicate");
		json.setInwardIssue(issueKey1);
		json.setOutwardIssue(issueKey2);
		payload = json.toString();
		System.out.println(payload);
		Response response3 = jiraService.createIssueLink(basicAuth, payload);

	}		
	
	// Link issue to Sprint
		//@Test(priority = 10)
		public void test10_linkIssueToSprint() {
			ExtentTest test = extentReport.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

			Issue issuePayLoad1 = new Issue();
			issuePayLoad1.setProject(Config.getValue("project1Id"));
			issuePayLoad1.setIssuetype(Config.getValue("issueTypeStoryId"));
			issuePayLoad1.setSummary("Issuetype-Story");
			issuePayLoad1.setPriority("3");
			issuePayLoad1.setReporter(Config.getValue("adminUserName"));			
			Response response1 = jiraService.createIssue(basicAuth, issuePayLoad1.toString());
			Assert.assertNotNull(response1, "Create Issue Api Response is null.");
			String issueKey2 = new JSONObject(response1.getBody().asString()).getString("key");
			System.out.println(issueKey2);

			List<String> values = new ArrayList<>();
			values.add(issueKey2);
			Sprint json = new Sprint();
			json.setIdOrKeys(values);
			json.setSprintId(4);
			payload = json.toString();
			System.out.println(payload);
			Response response3 = jiraService.linkIssueToSprint(basicAuth, payload);
			System.out.println(response3.getBody().asString());

		}		
}
