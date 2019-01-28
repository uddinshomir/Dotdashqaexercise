package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pagefactory.QaExercisePageFactory;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APITesting {
	QaExercisePageFactory pf;
	ArrayList<String> listOfCategories;
	ArrayList<String> listOfTask;
	ArrayList<String> listOfDateDue;
	ArrayList<String> listOfTasks;
@Test
	public void testAPI() {
		 listOfCategories = new ArrayList<String>();
		 listOfTask = new ArrayList<String>();
		 listOfDateDue = new ArrayList<String>();
		 listOfTasks = new ArrayList<String>();
		
		Response response=RestAssured.get("http://localhost/dot-dash%20project/qa-exercise/fake-api-call.php");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String categories = jsonPathEvaluator.get("category");
		listOfCategories.add(categories);
		int numberOfCat = 0;
		for(int i = 0; i<listOfCategories.size();i++) {
		if(listOfCategories.get(i).equalsIgnoreCase("")) {
			numberOfCat++;
		}
			
		}
		System.out.println("Number of tasks without category:: "+ numberOfCat);
	
		
		String taskName = jsonPathEvaluator.get("task name");
		listOfTask.add(taskName);
		System.out.println("task names are:: "+ listOfTask);
		System.out.println("Number of tasks are:: "+ listOfTask.size());
		for(WebElement task: pf.getListOfTasks3()) {
		listOfTasks.add(task.getText());
		}
		System.out.println(listOfTasks);
		listOfTasks.removeAll(listOfTask);
		if(listOfTasks.isEmpty()) {
			System.out.println("Names of tasks displayed equals to tasks from API call");
		}
		String dueDate = jsonPathEvaluator.get("due date");
		listOfDateDue.add(dueDate);
		for(String date :listOfDateDue) {
			listOfDateDue.add(date.replace("\r\n", ""));
				}
		Collections.sort(listOfDateDue, Collections.reverseOrder());
		System.out.println(listOfDateDue);
		listOfTask.sort(Comparator.comparingInt(listOfDateDue::indexOf));
		System.out.println(listOfTask);

}

}
