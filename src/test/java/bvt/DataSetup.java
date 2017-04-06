package java.bvt; /**
 * Created by manoj.behera on 01-Mar-2017.
 */

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.LogStatus;
import com.thed.zephyr.BaseTest;
import com.thed.zephyr.Config;
import com.thed.zephyr.model.Cycle;
import com.thed.zephyr.model.Execution;
import com.thed.zephyr.model.ExecutionFilter;
import com.thed.zephyr.model.Stepresult;
import com.thed.zephyr.model.Teststep;
import com.thed.zephyr.model.jira.Issue;
import com.thed.zephyr.util.CommonUtils;


/**
 * @author manoj.behera 01-Mar-2017
 *
 */
public class DataSetup extends BaseTest {
	AtomicInteger s = new AtomicInteger(0);
	
	@Test(enabled = true)
	public void test1() {
		
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		System.out.println("Started at : " + df.format(new Date()));
		String username = Config.getValue("adminUserName");
		int versionLimit = 4;
		List<String> versionsList = new ArrayList<>();
		int testIssueLimit = 200;
		int bugIssueLimit = 50;
		List<String> testIssueList = new ArrayList<>();
		List<String> bugIssueList = new ArrayList<>();
		List<String> bugIssueKeyList = new ArrayList<>();
		int teststepLimit = 5;
		List<String> teststepList = new ArrayList<>();
		int cycleLimit = 4;
		List<String> cycleList = new ArrayList<>();
		int executionLimit = 10;
		List<String> executionsList = new ArrayList<>();
		int executionFilterLimit = 10;
		List<String> executionFilterList = new ArrayList<>();
		String projectPrefix = "PROJ"+s.incrementAndGet();
		System.out.println(projectPrefix);
		/**
		 * Creating Project
		 */
		String projectPayload = "{\"key\": \"" + projectPrefix.toString() + "\",\"name\": \"" + projectPrefix.toString()
				+ "\",\"projectTypeKey\": \"software\",\"projectTemplateKey\": \"com.pyxis.greenhopper.jira:gh-scrum-template\",\"description\": \"Example Project description\",\"lead\": \""
				+ username + "\"}";
		Response response = jiraService.createProject(basicAuth, projectPayload);
		Assert.assertNotNull(response, "Create project Api Response is null.");

		String projectId = new JSONObject(response.getBody().asString()).get("id").toString();
		System.out.println("projectId : " + projectId);

		/**
		 * Creating Versions
		 */
		for (int i = 1; i <= versionLimit; i++) {
			String versionPayload = "{ \"projectId\": \"" + projectId + "\", \"name\": \"Version " + i + "\"}";
			response = jiraService.createVersion(basicAuth, versionPayload);
			Assert.assertNotNull(response, "Create Version Api Response is null.");

			String versionId = new JSONObject(response.getBody().asString()).get("id").toString();
			System.out.println("versionId : " + versionId);
			versionsList.add(versionId);
		}
		/**
		 * Creating Tests
		 */
		for (int i = 1; i <= testIssueLimit; i++) {
			Issue issuePayload = new Issue();
			issuePayload.setSummary("Test " + testIssueLimit);
			issuePayload.setIssuetype(Config.getValue("issueTypeTestId"));
			issuePayload.setProject(projectId);
			issuePayload.setPriority("1");
			issuePayload.setReporter(username);
			// String versionPayload = "{ \"projectId\": \"" + projectId + "\",
			// \"name\": \"Version " + i + "\"}";
			response = jiraService.createIssue(basicAuth, issuePayload.toString());
			Assert.assertNotNull(response, "Create Test Response is null.");

			String testId = new JSONObject(response.getBody().asString()).get("id").toString();
			System.out.println("testId : " + testId);
			testIssueList.add(testId);

			for (int j = 1; j <= teststepLimit; j++) {
				Teststep teststepJson = new Teststep();
				teststepJson.setStep("step " + j);
				teststepJson.setData("data " + j);
				teststepJson.setResult("result " + j);

				Response response1 = zapiService.createTeststep(basicAuth, Long.parseLong(testId),
						teststepJson.toString());
				Assert.assertNotNull(response1, "Create teststep Api Without WIKI Response is null.");
				System.out.println(response1.getBody().asString());
			}
		}
		/**
		 * Creating Bugs
		 */
		for (int i = 1; i <= bugIssueLimit; i++) {
			Issue issuePayload = new Issue();
			issuePayload.setSummary("Bug " + testIssueLimit);
			issuePayload.setIssuetype(Config.getValue("issueTypeBugId"));
			issuePayload.setProject(projectId);
			issuePayload.setPriority("1");
			issuePayload.setReporter(username);
			response = jiraService.createIssue(basicAuth, issuePayload.toString());
			Assert.assertNotNull(response, "Create Test Response is null.");

			String bugId = new JSONObject(response.getBody().asString()).get("id").toString();
			System.out.println("Bug : " + bugId);
			bugIssueList.add(bugId);
			String bugKey = new JSONObject(response.getBody().asString()).get("key").toString();
			System.out.println("Bug : " + bugKey);
			bugIssueKeyList.add(bugKey);
		}
		System.out.println("Ended at : " + df.format(new Date()));

		versionsList.add("-1");
		System.out.println("Added unscheduled version into the versions list.");
		for (int i = 0; i < versionsList.size(); i++) {
			/**
			 * Create Cycles execution randomly
			 */
			for (int j = 1; j <= cycleLimit; j++) {
				Cycle cycleJson = new Cycle();
				cycleJson.setProjectId(Long.parseLong(projectId));
				cycleJson.setVersionId(Long.parseLong(versionsList.get(i)));
				cycleJson.setName("Cycle " + j);
				Response response1 = zapiService.createCycle(basicAuth, cycleJson.toString());
				Assert.assertNotNull(response1, "Create Cycle Api Response is null.");
				String cycleId = new JSONObject(response1.body().asString()).get("id").toString();
				System.out.println("Cycle id:" + cycleId);
				cycleList.add(cycleId);
				
				/**
				 * Create execution randomly
				 */
				List<String> executionList = new ArrayList<>();
				String executionId = null;
				for (int k = 0; k < executionLimit; k++) {
					Execution executionJson = new Execution();
					Long issueId = Long.parseLong(testIssueList.get(new Random().nextInt(testIssueList.size())));
					executionJson
							.setIssueId(issueId);
					executionJson.setProjectId(Long.parseLong(projectId));
					executionJson.setVersionId(Long.parseLong(versionsList.get(i)));
					executionJson.setCycleId(cycleId);
					Response response2 = zapiService.createExecution(basicAuth, executionJson.toString());
					System.out.println(response2.getBody().asString());
					Assert.assertNotNull(response2, "Create execution Api Response is null.");

					boolean status = zapiService.validateCreateExecution(response2);
					Assert.assertTrue(status, "Response Validation Failed.");
					System.out.println(response2.getBody().asString());
					// executionList.add(e)
					Iterator<String> execIterator = new JSONObject(response2.getBody().asString()).keys();
					
					for (Iterator iterator = execIterator; iterator.hasNext();) {
						executionId = (String) iterator.next();
						System.out.println("Execution Id : " + executionId);
						executionList.add(executionId);
						executionsList.add(executionId);
					}
					
					/**
					 * Update execution randomly
					 */
					Execution updateExecJson = new Execution();
					updateExecJson.setStatusId(1);
					updateExecJson.setIssueId(issueId);
					int statusId = CommonUtils.getStatusId("unexecuted", "default");
					updateExecJson.setStatusId(statusId);
					if(statusId == 2){
						String bugkey = bugIssueKeyList.get(new Random().nextInt(bugIssueKeyList.size()));
						List<String> defectList = new ArrayList<>();
						defectList.add(bugkey);
						updateExecJson.setDefectList(defectList);
						updateExecJson.setUpdateDefectList("true");
					}
					Response updateExecutionResponse = zapiService.executeTest(basicAuth, executionId, updateExecJson.toString());
					Assert.assertNotNull(updateExecutionResponse, "UpdateExecution response is null.");
					System.out.println(response2.getBody().asString());
				}
				Response stepResResponse = zapiService.getTeststepResultsByExecutionId(basicAuth, Long.parseLong(executionId));
				Assert.assertNotNull(stepResResponse, "Get step result Response is null.");
				System.out.println(stepResResponse.getBody().asString());
				
				JSONArray stepResults = new JSONArray(stepResResponse.getBody().asString());
				for (int k = 0; k < stepResults.length(); k++) {
					JSONObject json = new JSONObject(stepResults.get(k).toString());
					String stepResId = json.get("id").toString();
					Stepresult updateStepResJson = new Stepresult();
					updateStepResJson.setExecutionId(Long.parseLong(executionId));
					int statusId = CommonUtils.getStatusId("unexecuted", "default");
					updateStepResJson.setStatus(statusId);
					if(statusId == 2){
						String bugkey = bugIssueKeyList.get(new Random().nextInt(bugIssueKeyList.size()));
						List<String> defectList = new ArrayList<>();
						defectList.add(bugkey);
						updateStepResJson.setdefectList(defectList);
						updateStepResJson.setUpdateDefectList("true");
					}

					Long id = Long.parseLong(stepResId);
					Response updateStepResResponse = zapiService.updateTeststepResults(basicAuth, id, updateStepResJson.toString());
					Assert.assertNotNull(updateStepResResponse, "updateStepRes Response is null.");
					System.out.println(updateStepResResponse.getBody().asString());
				}
				
			}
		}
		
		for (int i = 1; i <=  executionFilterLimit; i++) {
			ExecutionFilter filJson = new ExecutionFilter();
			filJson.setQuery("project = "+projectPrefix+" and executionStatus = Unexecuted");
			filJson.setFilterName("Filter "+ + System.currentTimeMillis());
			Response execFilterResponse = zapiService.createExecutionfilter(basicAuth, filJson.toString());
			Assert.assertNotNull(execFilterResponse, "CreateExecutionfilter Api Response is null.");

			System.out.println(execFilterResponse.getBody().asString());
			String filterId = new JSONObject(execFilterResponse.getBody().asString()).get("id").toString();
			System.out.println("Filter : " + filterId);
			executionFilterList.add(filterId);
		}
		
		System.out.println("Ended at : " + df.format(new Date()));
	}
}
