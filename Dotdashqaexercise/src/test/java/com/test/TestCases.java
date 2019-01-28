package com.test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pagefactory.QaExercisePageFactory;



public class TestCases {
	WebDriver driver;
	QaExercisePageFactory pf;
	String DaySelected, YearSelected, MonthSelected, createdTaskName, newDate, fullDate;
	ArrayList<String> colorscatagories;
	ArrayList<String> colors;
	String URL = "http://localhost/dot-dash%20project/qa-exercise/index.php";
	
	@BeforeTest
	public void getSetup() {	
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		pf = PageFactory.initElements(driver, QaExercisePageFactory.class);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
}
		
		//scenario 1: add name, choose category, due date and color assignment
	@Test(priority = 0)
	public void getNumber() {
			//1. Verify the number of tasks
		System.out.println("Total number of tasks on the todo list before adding a task:: " +pf.getListOfTasks().size());
	}
	@Test(priority = 1)
	public void addTask() {
			//2. Add a task in
		pf.getTaskName().sendKeys("Finish the exercise");
		Select categorySelect = new Select(pf.getCategory());
		categorySelect.selectByVisibleText("College");
		
		Select dueDaySelect = new Select(pf.getDueDay());
		dueDaySelect.selectByIndex(1);
		DaySelected = dueDaySelect.getOptions().get(1).getText();
		
		Select dueMonthSelect = new Select(pf.getDueMonth());
		dueMonthSelect.selectByIndex(1);
		MonthSelected = dueMonthSelect.getOptions().get(1).getText();
		
  		Select dueYearSelect = new Select(pf.getDueYear());
		dueYearSelect.selectByIndex(1);
		YearSelected = dueYearSelect.getOptions().get(1).getText();
		
		pf.getAddbtn().click();
	}
	@Test(priority = 2)
	public void checkNumberOfTask() {
			//3. Verify a number of task change after adding a new task
		System.out.println("Total number of tasks on the todo list after adding a task:: " + pf.getListOfTasks2().size());
		
		if (pf.getListOfTasks().size() != pf.getListOfTasks2().size()) {
			System.out.println("Total number of tasks on the todo list increases from " + pf.getListOfTasks().size() + " to " + pf.getListOfTasks2().size());
			}
		else {
			System.out.println("Total number of tasks on the todo list remains the same");
			
		}
	}
	@Test(priority = 3)
	public void taskAdded() {
			//4. Verify the name of the task added in
		for(WebElement name: pf.getNameOfTask()) {
			if(name.getText().contains("Finish the exercise")) {
				System.out.println("Task is added");
				
			}else {
				System.out.println("Not the added task");
			}
			}
	}
	@Test(priority = 4)
	public void verifiedDate() {
			//5. Verify the selected date
		createdTaskName = pf.getCreatedTask().getText();
		int openPar = createdTaskName.indexOf("(");
		int closePar = createdTaskName.indexOf(")");
		newDate = createdTaskName.substring(openPar +1, closePar);
		System.out.println("Date set on the todo list:: " +newDate);
		fullDate = DaySelected +"/" +MonthSelected + "/" + YearSelected;
		System.out.println("Date selected from the calendar:: "+fullDate);
	}		
	@Test(priority = 5)
	public void colorAssign() {
		//6. Verify color to match the color assignment
		
		//List<WebElement> catagories1 = driver.findElements(By.xpath("//a[@title  = 'Remove this category']//span"));
		String addedTaskColor = pf.getAddedTask().getCssValue("color");
		for(WebElement cat : pf.getCategories()) {
			if(addedTaskColor.equalsIgnoreCase(cat.getCssValue("color"))) {
				System.out.println("Added task is within the category:: " +pf.getAddedTask().getText() + " task");
			}else if(addedTaskColor.equalsIgnoreCase(pf.getOverdue().getCssValue("color"))) {
				System.out.println("Added task is overdue");
			}else {
				System.out.println("Added task is not within the category");
			}
		}
	}

	@Test(priority = 6)
	public void checkedBox() {
		//8. Verify checkbox of added task
		pf.getCheckboxTask().click();
		if(pf.getCheckboxTask().isSelected()) {
			System.out.println("Checkbox works");
		}else {
			System.out.println("Checkbox malfunctioned");
		}
	}
	@Test(priority = 7)
	public void complete() {
		//9.complete button
		pf.getCompleteBtn().click();
		if(pf.getStrikeTask().getTagName().equalsIgnoreCase("strike")) {
			System.out.println("Task is complete");
		}else {
			System.out.println("Task is not complete");
		}
		//revive complete box by checking the box again and click on complete again 
	}
	@Test(priority = 8)
	public void toggleAll() {
		//10.toggle all
		pf.getToggleAllbox().click();
		for(int i = 0; i<pf.getAllCheckedBox().size(); i++) {
			if(pf.getAllCheckedBox().get(i).isSelected()) {
				System.out.println("All boxes are checked");
				
			}else {
				System.out.println("Some boxes are unchecked");
			} 
		}
	}
	@Test(priority =9)
	public void reCheckToggle() {
				//recheck toggle all
		pf.getToggleAllbox().click();
		for(int i = 0; i<pf.getAllCheckedBox().size(); i++) {
			if(pf.getAllCheckedBox().get(i).isSelected()) {
				System.out.println("All boxes are checked");
				
			}else {
				System.out.println("Boxes are unchecked");
			} 
		}
}
	@Test(priority =10)
	public void verifiedColor() throws Throwable{
	
		//11.verify colors that can be used
		colorscatagories = new ArrayList<String>();
		for(int i = 0; i<pf.getCategories2().size() ; i++) {
			String colorscat = pf.getCategories2().get(i).getCssValue("color");
			String hex = Color.fromString(colorscat).asHex();
			String hex1 = hex.replace("#", "");
			colorscatagories.add(hex1.toUpperCase());
		}
		System.out.println("Colors that are already used:: " +colorscatagories);
		colors = new ArrayList<String>();
			for(int i = 0; i<pf.getListOfColor().size(); i++) {
				String colorsall = pf.getListOfColor().get(i).getAttribute("value").replace("#", "");
				colors.add(colorsall);
			}
		System.out.println("All colors available:: " + colors);
		colors.removeAll(colorscatagories);
		System.out.println("Colors that are available to use:: "+ colors);
	}
	@Test(priority =11)
	public void AddCat() {
		//12. Verify Add category button
		pf.getAddCatInput().sendKeys("Work");
		Select colorSelect = new Select(pf.getSelectColor());
		colorSelect.selectByVisibleText("Yellow");
		pf.getAddCatbtn().click();
	}
	@Test(priority =12)
	public void deteleCat() throws Throwable{
		//12.verify and delete category
		for(WebElement cat : pf.getCategories3()) {
			if(cat.getText().equalsIgnoreCase("Work")) {
				System.out.println("New category is added");
				System.out.println("Number of categories are:: "+ pf.getCategories3().size());
			}
			
		}
		for(WebElement cat : pf.getCategories3()) {
			cat.click();
			break;
		}
		
		pf.getYes().click();
		System.out.println("Number of categories after deletion:: " + pf.getCategories4().size());
	}
	@Test(priority =13)
	public void remove() throws Throwable {
		//13.remove button
		pf.getCheckboxTask1().click();
		System.out.println("Position of checked task:: " +pf.getCheckboxTask1().getAttribute("name"));
		pf.getRemoveBtn().click();
		for(WebElement box: pf.getAllCheckedBox2()) {
			if(!box.getAttribute("name").equalsIgnoreCase("todo[11]")){
				System.out.println("The task has been removed");
	
			}
		}
	}
	@AfterTest
	public void teardown() {
		driver.quit();

}
}
