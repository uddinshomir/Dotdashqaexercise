package com.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaExercisePageFactory {
	
	WebDriver driver;
	
	public QaExercisePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
		@CacheLookup
		@FindBy(xpath="//ul[@style = 'list-style-type: none; padding-left:0']//li")
		private List<WebElement> listOfTasks;
		@CacheLookup
		
		@FindBy(xpath="//ul[@style = 'list-style-type: none; padding-left:0']//li")
		private List<WebElement> listOfTasks2;
		@CacheLookup
		
		@FindBy(xpath="//ul[@style = 'list-style-type: none; padding-left:0']//li")
		private List<WebElement> listOfTasks3;
		@CacheLookup
		
		@FindBy(xpath="//input[@name = 'data']")
		private WebElement taskName;
		@CacheLookup

		@FindBy(xpath="//select[@name = 'category']")
		private WebElement category;
		@CacheLookup
		
		@FindBy(xpath="//select[@name = 'due_day']")
		private WebElement dueDay;
		@CacheLookup
		
		@FindBy(xpath="//select[@name = 'due_month']")
		private WebElement dueMonth;
		@CacheLookup

		@FindBy(xpath="//select[@name = 'due_year']")
		private WebElement dueYear; 
		@CacheLookup

		@FindBy(xpath="//input[@value = 'Add']")
		private WebElement Addbtn;
		@CacheLookup
		
		@FindBy(xpath="//ul[@style = 'list-style-type: none; padding-left:0']//li//span[1]")
		private List<WebElement> nameOfTask;
		@CacheLookup

		@FindBy(xpath="//a[contains(text(), '11')]//parent::li")
		private WebElement createdTask;
		@CacheLookup

		@FindBy(xpath="//*[contains(text(), 'Finish the exercise')]")
		private WebElement addedTask;
		@CacheLookup

		@FindBy(xpath="//*[contains(text(), 'Overdue')]")
		private WebElement Overdue;
		@CacheLookup

		@FindBy(xpath="//a[contains(text(), '11')]//following-sibling::input")
		private WebElement checkboxTask;
		@CacheLookup
		
		@FindBy(xpath="//a[contains(text(), '11')]//following-sibling::input")
		private WebElement checkboxTask1;
		@CacheLookup

		@FindBy(xpath="//input[@value = 'Complete']")
		private WebElement completeBtn;
		@CacheLookup
		
		@FindBy(xpath="//a[contains(text(), '11')]//parent::li//span//strike")
		private WebElement strikeTask;
		@CacheLookup

		@FindBy(xpath="//input[@name = 'allbox']")
		private WebElement toggleAllbox;
		@CacheLookup

		@FindBy(xpath="(//input[@type= 'checkbox'])")
		private List<WebElement> allCheckedBox;
		@CacheLookup
		
		@FindBy(xpath="(//input[@type= 'checkbox'])")
		private List<WebElement> allCheckedBox2;
		@CacheLookup

		@FindBy(xpath="//a[@title  = 'Remove this category']//span")
		private List<WebElement> categories;
		@CacheLookup
		
		@FindBy(xpath="//a[@title  = 'Remove this category']//span")
		private List<WebElement> categories2;
		@CacheLookup
		
		@FindBy(xpath="//a[@title  = 'Remove this category']//span")
		private List<WebElement> categories3;
		@CacheLookup
		
		@FindBy(xpath="//a[@title  = 'Remove this category']//span")
		private List<WebElement> categories4;
		@CacheLookup

		@FindBy(xpath="//select[@name= 'colour']//option[@value]")
		private List<WebElement> listOfColor;
		@CacheLookup
		
		@FindBy(xpath="//input[@name= 'categorydata']")
		private WebElement addCatInput;
		@CacheLookup

		@FindBy(xpath="//select[@name= 'colour']")
		private WebElement selectColor;
		@CacheLookup

		@FindBy(xpath="//input[@value= 'Add category']")
		private WebElement addCatbtn; 
		@CacheLookup

		@FindBy(xpath="//*[contains(text(), 'Yes')]")
		private WebElement Yes; 
		@CacheLookup

		@FindBy(xpath="//input[@value = 'Remove']")
		private WebElement removeBtn;


	//getter methods
		public List<WebElement> getListOfTasks() {
			return listOfTasks;
		}
		
		public List<WebElement> getListOfTasks2() {
			return listOfTasks2;
		}
		
		public List<WebElement> getListOfTasks3() {
			return listOfTasks3;
		}


		public WebElement getTaskName() {
			return taskName;
		}


		public WebElement getCategory() {
			return category;
		}


		public WebElement getDueDay() {
			return dueDay;
		}


		public WebElement getDueMonth() {
			return dueMonth;
		}


		public WebElement getDueYear() {
			return dueYear;
		}


		public WebElement getAddbtn() {
			return Addbtn;
		}


		public List<WebElement> getNameOfTask() {
			return nameOfTask;
		}


		public WebElement getCreatedTask() {
			return createdTask;
		}


		public WebElement getAddedTask() {
			return addedTask;
		}


		public WebElement getOverdue() {
			return Overdue;
		}

		public WebElement getCheckboxTask() {
			return checkboxTask;
		}
		
		public WebElement getCheckboxTask1() {
			return checkboxTask1;
		}


		public WebElement getCompleteBtn() {
			return completeBtn;
		}


		public WebElement getStrikeTask() {
			return strikeTask;
		}


		public WebElement getToggleAllbox() {
			return toggleAllbox;
		}


		public List<WebElement> getAllCheckedBox() {
			return allCheckedBox;
		}

		public List<WebElement> getAllCheckedBox2() {
			return allCheckedBox2;
		}

		public List<WebElement> getCategories() {
			return categories;
		}
		
		public List<WebElement> getCategories2() {
			return categories2;
		}
		
		public List<WebElement> getCategories3() {
			return categories3;
		}
		
		public List<WebElement> getCategories4() {
			return categories4;
		}


		public List<WebElement> getListOfColor() {
			return listOfColor;
		}


		public WebElement getAddCatInput() {
			return addCatInput;
		}


		public WebElement getSelectColor() {
			return selectColor;
		}


		public WebElement getAddCatbtn() {
			return addCatbtn;
		}


		public WebElement getYes() {
			return Yes;
		}
		

		public WebElement getRemoveBtn() {
			return removeBtn;
		}

	}


