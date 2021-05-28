package week6day2.homework.servicenowpages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import week6day2.homework.servicenowhooks.ServiceNowHooks;

public class SearchPage extends ServiceNowHooks{
CreateNewChangeRequestPage CR=new CreateNewChangeRequestPage();
public SearchPage SetFilterAsNumber()
{
	WebElement SelectSearchFilterasNumber=driver.findElementByXPath("//select[@class=\"form-control default-focus-outline\"]");
	SelectSearchFilterasNumber.click();
	Select selectValue = new Select(SelectSearchFilterasNumber);
	List<WebElement> values = selectValue.getOptions();
	int sizeofSearchList = values.size();
	System.out.println(sizeofSearchList);			
	selectValue.selectByVisibleText("Number");
	return this;
}
	
public SearchPage seachCR(String ChangeRequestNumber)
{
	//To input number in the Search field 
		WebElement Search=driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']");		
		Search.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	Search.sendKeys(CR.getCRValue());
	System.out.println(CR.getCRValue());
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	Search.sendKeys(Keys.ENTER);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	return this;
}

public ChangeRequestEditPage ValidateSearchAndRetrievedCR()
{
	WebElement ChangeRequestNumberLink=driver.findElementByXPath("//a[@class=\"linked formlink\"]");
	
	//Verifying the Created Change Request Number in Search and Validating it 
	
	String searchlistNumber=ChangeRequestNumberLink.getText();
	System.out.println(searchlistNumber);
	CreateNewChangeRequestPage CR=new CreateNewChangeRequestPage();
	if(CR.getCRValue().equalsIgnoreCase(searchlistNumber))
	{
		System.out.println("Created and Searched values are same");
		ChangeRequestNumberLink.click();

	}else {
		System.out.println("Created and Searched values are not same");
	}
	return new ChangeRequestEditPage();
}

public SearchPage toVerifyState()
{
	//Verifying state is Assess
	String assess = driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(6)")).getText();			
	System.out.println(assess);
	if(assess.equals("Assess"))
	{
		System.out.println("State is Assess");
	}else
	{
		System.out.println("State is not Assess");
	}		
	return this;
}

public SearchPage toVerifyAssignedUser()
{
	//Verifying the Assigned To User
	String assignedToValue=driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(10)")).getText();
	System.out.println(assignedToValue);
	if(assignedToValue.contains("ITIL User"))
	{
		System.out.println("Assigned to value is selected is ITIL User");
	}else
	{
		System.out.println("Assigned to value is not selected as ITIL User");
	}
	
	return this;
}

public ChangeRequestEditPage toClickOnCRLink() {
	driver.findElementByXPath("//a[@class='linked formlink']").click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.titleContains("ServiceNow"));
	return new ChangeRequestEditPage();	
}



public SearchPage toVerifyPlannedStartandEndDate()
{
	
	//Navigating to the change request screen 
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	//Verifying the Planned start date 
	System.out.println(driver.findElementByXPath(("(//div[@class='datex date-calendar'])[1]")).getText());
	
	
	//Verifying the Planned End date
	
	System.out.println(driver.findElementByXPath(("(//div[@class='datex date-calendar'])[2]")).getText());

	return this;
}

public SearchPage toResetFilterToDelete()
{
	
	//to clear the already applied filter having the change request number 
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	WebElement SelectSearchFilterasNumber=driver.findElementByXPath("//select[@class=\"form-control default-focus-outline\"]");
	SelectSearchFilterasNumber.click();
	Select selectValue = new Select(SelectSearchFilterasNumber);
	List<WebElement> values = selectValue.getOptions();
	int sizeofSearchList = values.size();
	System.out.println(sizeofSearchList);			
	
	selectValue.selectByVisibleText("State");
	return this;
}

public SearchPage toSelectNewStatusRecords()
{
	//To filter only the New state records 
	
	driver.findElementByXPath("//input[@placeholder=\"Search\" and @class=\"form-control\"]").sendKeys("New");
	
	driver.findElementByXPath("//input[@placeholder=\"Search\" and @class=\"form-control\"]").sendKeys(Keys.ENTER);
	return this;
}

public SearchPage toVerifytheSearchResultAndDeleteOneData()
{
	List<WebElement> table=driver.findElementsByXPath("//tbody[@class=\"list2_body\"]//tr");
	int rowCount=table.size();
	System.out.println(rowCount);
			
	if(rowCount>=1)
	{
		System.out.println("Values can be deleted");
		driver.findElement(By.xpath("//label[@class='checkbox-label']")).click();
		WebElement SelectedRecordForDelete=driver.findElementByXPath("(//a[@class=\"linked formlink\"])[1]");
		String selectedDataTodelete=SelectedRecordForDelete.getText();
		System.out.println(selectedDataTodelete);
		
		//verifying the deleted data point 
		SelectedRecordForDelete.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElementById("sysverb_delete").click();
		driver.findElementById("ok_button").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		driver.switchTo().defaultContent();

		//To click on open 
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		
		driver.switchTo().frame("gsft_main");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement SelectSearchFilterasNumber=driver.findElementByXPath("//select[@class='form-control default-focus-outline']");
		SelectSearchFilterasNumber.click();
		Select selectValue = new Select(SelectSearchFilterasNumber);
		List<WebElement> values = selectValue.getOptions();
		int sizeofSearchList = values.size();
		System.out.println(sizeofSearchList);			
		
		selectValue.selectByVisibleText("Number");
		
			
		driver.findElementByXPath("//input[@placeholder=\"Search\" and @class=\"form-control\"]").sendKeys(selectedDataTodelete);
		driver.findElementByXPath("//input[@placeholder=\"Search\" and @class=\"form-control\"]").sendKeys(Keys.ENTER);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verifying the selected data is deleted or not
		String numOfRecords =" ";
		numOfRecords = driver.findElementByXPath("//tr[@class='list2_no_records']//td").getText();
		System.out.println(numOfRecords);
		if (numOfRecords.contains("No records to display")) {
			System.out.println("Selected Record is deleted");
		} else {
			System.out.println("Selected Record is not deleted");
		}

	}else
	{
		System.out.println("No data found.Data cannot be deleted");
	}
	return this;
}
}