package week4.day2.homework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangeManagement {

	public static void main(String[] args) throws InterruptedException {

				// 1) Go to https://dev103117.service-now.com -- Login into the application

				WebDriverManager.chromedriver().setup();

				// to disable notifications
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				ChromeDriver driver = new ChromeDriver(options);

				driver.get("https://dev103117.service-now.com");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				driver.switchTo().frame(0);
				// entering credentials
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("India@123");
				driver.findElement(By.xpath("//button[text()='Log in']")).click();

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.titleContains("ServiceNow"));
				
				//Searching for Change Request 
				driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Change");
				wait = new WebDriverWait(driver, Duration.ofSeconds(120));
				driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
				//Clicking on Create New
				driver.findElement(By.xpath(
						"//a[@href='new_change_redirect.do']"))
						.click();
				driver.switchTo().frame("gsft_main");
				//clicking on Model 
				driver.findElementByXPath("//div[@aria-label=\"Models\"]").click();
				//clicking on Normal model 
				driver.findElementByXPath("(//div[@class=\"change-model-card-component\"])[2]").click();
				Thread.sleep(2000);

				String ChangeRequestNumber=driver.findElementById("change_request.number").getAttribute("value");
				//Create new change
				System.out.println(ChangeRequestNumber);
		
				
				//Clicking on Submit 
				Thread.sleep(2000);

				driver.findElementById("sysverb_insert").click();
				
				Thread.sleep(2000);
				driver.switchTo().defaultContent();

				//To click on open 
				wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
				
				driver.switchTo().frame("gsft_main");
				Thread.sleep(2000);
				
				WebElement SelectSearchFilterasNumber=driver.findElementByXPath("//select[@class=\"form-control default-focus-outline\"]");
				SelectSearchFilterasNumber.click();
				Select selectValue = new Select(SelectSearchFilterasNumber);
				List<WebElement> values = selectValue.getOptions();
				int sizeofSearchList = values.size();
				System.out.println(sizeofSearchList);			
				
				selectValue.selectByVisibleText("Number");
				
				//To input number in the Search field 
				WebElement Search=driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']");
				
				Search.click();
				Thread.sleep(2000);

				Search.sendKeys(ChangeRequestNumber);
				Thread.sleep(2000);

				Search.sendKeys(Keys.ENTER);
				Thread.sleep(2000);

				WebElement ChangeRequestNumberLink=driver.findElementByXPath("//a[@class=\"linked formlink\"]");
				
				//Verifying the Created Change Request Number in Search and Validating it 
				
				String searchlistNumber=ChangeRequestNumberLink.getText();
				System.out.println(searchlistNumber);
				
				if(ChangeRequestNumber.equalsIgnoreCase(searchlistNumber))
				{
					System.out.println("Created and Searched values are same");
					ChangeRequestNumberLink.click();

				}else {
					System.out.println("Created and Searched values are not same");
				}
				
			//Assess the Change Request
				
			WebElement selectState=driver.findElementById("change_request.state");
			selectState.click();
			Select selectStateValue = new Select(selectState);
			List<WebElement> Statevalues = selectStateValue.getOptions();
			int size = Statevalues.size();
			System.out.println(size);			
			
			selectStateValue.selectByVisibleText("Assess");
			
			// To Select Assignment Group
			driver.findElementByXPath("//button[@name='lookup.change_request.assignment_group']").click();
			// To get the window handles

			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println(allWindowHandles.size());

			// To get the second window handle and switch to it

			List<String> lstWindows = new ArrayList<String>(allWindowHandles);
			System.out.println(lstWindows.size());

			String firstwindow = lstWindows.get(1);

			driver.switchTo().window(firstwindow);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			System.out.println(driver.getCurrentUrl());
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equals("Change Request | ServiceNow")) {
				System.out.println("Title is matched");
			} else {
				System.out.println("Title is not matched");
			}
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			driver.findElementByXPath("//a[text()='Software']").click();
			Thread.sleep(2000);
			driver.switchTo().window(lstWindows.get(0));
			driver.switchTo().frame("gsft_main");

			// To Select Assigned To Value
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			driver.findElementByXPath("//input[@id='sys_display.change_request.assigned_to']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//input[@id='sys_display.change_request.assigned_to']").sendKeys("IT");
			Thread.sleep(2000);
			driver.findElementByXPath("//input[@id='sys_display.change_request.assigned_to']").sendKeys(Keys.TAB);

			// To click on update
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.findElementById("sysverb_update").click();
			
			//To verify the Assess value is selected in State
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleContains("ServiceNow"));
			System.out.println(driver.getTitle());
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(ChangeRequestNumber);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(Keys.ENTER);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			String chgRequestValue = driver.findElementByXPath("//a[@class='linked formlink']").getText();
			System.out.println(chgRequestValue);

			if (chgRequestValue.contains(ChangeRequestNumber)) {
				System.out.println("Change Request is same from creation and search");
			} else {
				System.out.println("Change Request is not same from creation and search");
			}
			
			String assess = driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(6)")).getText();			
			System.out.println(assess);
			
			//Verifying state is Assess
			
			if(assess.equals("Assess"))
			{
				System.out.println("State is Assess");
			}else
			{
				System.out.println("State is not Assess");
			}
			
			driver.findElementByXPath("//a[@class='linked formlink']").click();
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleContains("ServiceNow"));
			
			
			//Update schedule for the existing Change
			
			driver.findElementByXPath("//span[@class=\"tab_caption_text\" and text()='Schedule']").click();
			
			driver.findElement(By.xpath("//span[@class='icon-calendar icon']")).click();
			
			driver.findElement(By.id("GwtDateTimePicker_ok")).click();
			
			driver.findElement(By.xpath("(//span[@class='icon-calendar icon'])[2]")).click();
			
			driver.findElement(By.id("GwtDateTimePicker_ok")).click();
			
			String PlannedStartDate=driver.findElementById("change_request.start_date").getAttribute("value");
			System.out.println("Selected Planned Start date:"+PlannedStartDate);
			
			String PlannedEndDate=driver.findElementById("change_request.end_date").getAttribute("value");
			System.out.println("Selected Planned End date:"+PlannedEndDate);
			
			//To check CAB Required check box 
			
			driver.findElementById("label.ni.change_request.cab_required").click();
			
			//To select CAB Date 
			driver.findElementById("change_request.cab_date.ui_policy_sensitive").click();
			
			//To select today's date 
			driver.findElementByXPath("//td[@class='calText calTodayText pointerhand']").click();
			
			String CAB_Date=driver.findElementById("change_request.cab_date").getAttribute("value");
			System.out.println("Selected CAB Date:"+CAB_Date);
			
			//Clicking on Update 
			Thread.sleep(1000);
			driver.findElementById("sysverb_update").click();
			
			
			
			//Navigating to the change request screen 
			Thread.sleep(1000);
			//Verifying the Planned start date 
			System.out.println(driver.findElementByXPath(("(//div[@class='datex date-calendar'])[1]")).getText());
			
			
			//Verifying the Planned End date
			
			System.out.println(driver.findElementByXPath(("(//div[@class='datex date-calendar'])[2]")).getText());

			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleContains("ServiceNow"));
	
			//To delete Change Request 
			
			//to clear the already applied filter having the change request number 
			
			Thread.sleep(2000);
			
			SelectSearchFilterasNumber=driver.findElementByXPath("//select[@class=\"form-control default-focus-outline\"]");
			SelectSearchFilterasNumber.click();
			selectValue = new Select(SelectSearchFilterasNumber);
			values = selectValue.getOptions();
			sizeofSearchList = values.size();
			System.out.println(sizeofSearchList);			
			
			selectValue.selectByVisibleText("State");
			
			//To filter only the New state records 
			
			driver.findElementByXPath("//input[@placeholder=\"Search\" and @class=\"form-control\"]").sendKeys("New");
			
			driver.findElementByXPath("//input[@placeholder=\"Search\" and @class=\"form-control\"]").sendKeys(Keys.ENTER);
			
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
				Thread.sleep(1000);
				driver.findElementById("sysverb_delete").click();
				driver.findElementById("ok_button").click();
				Thread.sleep(2000);
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.titleContains("ServiceNow"));
				
				Thread.sleep(2000);
				driver.switchTo().defaultContent();

				//To click on open 
				wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
				
				driver.switchTo().frame("gsft_main");
				Thread.sleep(2000);
				SelectSearchFilterasNumber=driver.findElementByXPath("//select[@class='form-control default-focus-outline']");
				SelectSearchFilterasNumber.click();
				selectValue = new Select(SelectSearchFilterasNumber);
				values = selectValue.getOptions();
				sizeofSearchList = values.size();
				System.out.println(sizeofSearchList);			
				
				selectValue.selectByVisibleText("Number");
				
					
				driver.findElementByXPath("//input[@placeholder=\"Search\" and @class=\"form-control\"]").sendKeys(selectedDataTodelete);
				driver.findElementByXPath("//input[@placeholder=\"Search\" and @class=\"form-control\"]").sendKeys(Keys.ENTER);
				
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				Thread.sleep(1000);
				
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
	}

}
