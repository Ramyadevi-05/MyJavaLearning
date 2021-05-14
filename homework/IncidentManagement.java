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

public class IncidentManagement {

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
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(
				"//a[@href=\"incident.do?sys_id=-1&sysparm_query=active=true&sysparm_stack=incident_list.do?sysparm_query=active=true\"]"))
				.click();

		String incidentNumber = " ";

		driver.switchTo().frame("gsft_main");
		// Reading incident Number and creating it
		incidentNumber = driver.findElementByXPath("//input[@name='incident.number']").getAttribute("value");
		System.out.println(incidentNumber);
		Thread.sleep(2000);

		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.findElementById("sys_display.incident.caller_id").click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		driver.findElementById("sys_display.incident.caller_id").sendKeys("ml.admin");
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		driver.findElementById("sys_display.incident.caller_id").sendKeys(Keys.ENTER);
		wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		driver.findElementById("sys_display.incident.caller_id").sendKeys(Keys.TAB);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		WebElement assignedTo = driver.findElement(By.xpath("//input[@id='sys_display.incident.assigned_to']"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.executeScript("arguments[0].scrollIntoView(true);", assignedTo);
		WebElement enterShortDescription = driver.findElementByXPath("//input[@id='incident.short_description']");
		enterShortDescription.sendKeys("Testing Incident ID Creation");
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.findElementByXPath("//button[@id='sysverb_insert']").click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		

		WebElement SelectSearchFilterasNumber=driver.findElementByXPath("//select[@class=\"form-control default-focus-outline\"]");
		SelectSearchFilterasNumber.click();
		Select selectValue = new Select(SelectSearchFilterasNumber);
		List<WebElement> values = selectValue.getOptions();
		int sizeofSearchList = values.size();
		System.out.println(sizeofSearchList);			
		
		selectValue.selectByVisibleText("Number");
		// TC001 Searching for created incident
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(incidentNumber);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(Keys.ENTER);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		String incidentValueAftercreation = driver.findElementByXPath("//a[@class='linked formlink']").getText();
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		System.out.println(incidentValueAftercreation);

		if (incidentValueAftercreation.contains(incidentNumber)) {
			System.out.println("Incident ID is same from creation and search");
		} else {
			System.out.println("Incident ID is not same from creation and search");
		}
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));
		// TC002 Updating incident ID
		WebElement urgencyDropDown = driver.findElementByXPath("//select[@name='incident.urgency']");
		urgencyDropDown.click();
		Select urgencyDropdown = new Select(urgencyDropDown);
		List<WebElement> valuesofUrgency = urgencyDropdown.getOptions();
		int size = valuesofUrgency.size();
		System.out.println(size);
		urgencyDropdown.selectByVisibleText("1 - High");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement stateDropDown = driver.findElementByXPath("//select[@name='incident.state']");
		stateDropDown.click();
		Select stateDropdown = new Select(stateDropDown);
		List<WebElement> Statevalues = stateDropdown.getOptions();
		size = Statevalues.size();
		System.out.println(size);
		stateDropdown.selectByVisibleText("In Progress");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement enterWorkNotes = driver.findElementByXPath("(//textarea[@aria-label='Work notes'])[2]");
		driver.executeScript("arguments[0].scrollIntoView(true);", enterWorkNotes);
		enterWorkNotes.sendKeys("Updated State and Urgency");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@value='sysverb_update'])[1]")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(incidentNumber);
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(Keys.ENTER);
		incidentValueAftercreation = driver.findElementByXPath("//a[@class='linked formlink']").getText();
		System.out.println(incidentValueAftercreation);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		System.out.println(incidentValueAftercreation);
		if (incidentValueAftercreation.contains(incidentNumber)) {
			System.out.println("Incident ID is same from creation and search");
		} else {
			System.out.println("Incident ID is not same from creation and search");
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));
		System.out.println(driver.getTitle());
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));

		String valueOfPriority = driver.findElementByXPath("//select[@name='incident.priority']").getText();
		String State = driver.findElementByXPath("//select[@name='incident.state']").getText();

		System.out.println("Value of Priority:" + valueOfPriority);
		System.out.println("State:" + State);

		if (valueOfPriority.contains("Moderate")) {
			System.out.println("Priority is Moderate");
		} else {
			System.out.println("Priority is not Moderate");
		}
		if (State.contains("In Progress")) {
			System.out.println("State is In Progress");
		} else {
			System.out.println("State is not In Progress");
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// TC003 Assign the incident
		// To Select Assignment Group
		driver.findElementByXPath("//button[@name='lookup.incident.assignment_group']").click();
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
		if (title.equals("Groups | ServiceNow")) {
			System.out.println("Title is matched");
		} else {
			System.out.println("Title is not matched");
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.findElementByXPath("(//input[@placeholder='Search'])[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys("Software");
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElementByXPath("(//a[@class='glide_ref_item_link'])[1]").click();
		driver.switchTo().window(lstWindows.get(0));
		driver.switchTo().frame("gsft_main");

		// To Select Assigned To Value
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.findElementByXPath("//input[@id='sys_display.incident.assigned_to']").click();
		driver.findElementByXPath("//input[@id='sys_display.incident.assigned_to']").sendKeys("IT");
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='sys_display.incident.assigned_to']").sendKeys(Keys.TAB);

		// To click on update
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.findElementByXPath("//button[@id='sysverb_update']").click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));
		System.out.println(driver.getTitle());
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(incidentNumber);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(Keys.ENTER);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		incidentValueAftercreation = driver.findElementByXPath("//a[@class='linked formlink']").getText();
		System.out.println(incidentValueAftercreation);

		if (incidentValueAftercreation.contains(incidentNumber)) {
			System.out.println("Incident ID is same from creation and search");
		} else {
			System.out.println("Incident ID is not same from creation and search");
		}
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));

		String valueOfAssignmentGroup = driver
				.findElementByXPath("//input[@id='sys_display.incident.assignment_group']").getAttribute("value");
		String valueOfAssignedUser = driver.findElementByXPath("//input[@id='sys_display.incident.assigned_to']")
				.getAttribute("value");

		System.out.println("Assignment Group:" + valueOfAssignmentGroup);
		System.out.println("Assigned To:" + valueOfAssignedUser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		System.out.println(valueOfAssignmentGroup);
		System.out.println(valueOfAssignedUser);
		if (valueOfAssignmentGroup.contains("Software")) {
			System.out.println("Assignment Group is Software");
		} else {
			System.out.println("Assignment Group is not Software");
		}
		if (valueOfAssignedUser.contains("ITIL User")) {
			System.out.println("Assigned User is ITIL User");
		} else {
			System.out.println("Assigned User is not ITIL User");
		}

		// TC004 Resolve Incident
		stateDropDown = driver.findElementByXPath("//select[@name='incident.state']");
		stateDropDown.click();
		stateDropdown = new Select(stateDropDown);
		Statevalues = stateDropdown.getOptions();
		size = Statevalues.size();
		System.out.println(size);
		stateDropdown.selectByVisibleText("Resolved");

		driver.findElementByXPath("(//span[@class='tab_caption_text'])[3]").click();

		WebElement selectResolutionCode = driver.findElementByXPath("//select[@id='incident.close_code']");
		selectResolutionCode.click();
		Select ResolutionCode = new Select(selectResolutionCode);
		List<WebElement> valuesOfResolutionCode = ResolutionCode.getOptions();
		size = valuesOfResolutionCode.size();
		System.out.println(size);
		ResolutionCode.selectByVisibleText("Solved (Permanently)");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ResolutionNotes=driver.findElementByXPath("//textarea[@id='incident.close_notes']");
		driver.executeScript("arguments[0].scrollIntoView(true);", ResolutionNotes);
		ResolutionNotes.sendKeys("Incident ID State is updated to Resolved");
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='Resolve']").click();

		// TC005 Delete incident
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));
		System.out.println(driver.getTitle());
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));

		// Verifying the State as Resolved
		selectResolutionCode = driver.findElementByXPath("//select[@id='incident.close_code']");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		selectResolutionCode.click();
		String StateValue = selectResolutionCode.getText();
		System.out.println(StateValue);
		if (StateValue.contains("Resolved")) {
			System.out.println("State is resolved");
		} else {
			System.out.println("State isn't resolved");
		}

		// To click on delete
		driver.findElementByXPath("//button[@id='sysverb_delete']").click();
		driver.findElementById("ok_button").click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		//To click on open 
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);		
		
		SelectSearchFilterasNumber=driver.findElementByXPath("//select[@class='form-control default-focus-outline']");
		SelectSearchFilterasNumber.click();
		selectValue = new Select(SelectSearchFilterasNumber);
		values = selectValue.getOptions();
		sizeofSearchList = values.size();
		System.out.println(sizeofSearchList);			
		
		selectValue.selectByVisibleText("Number");
		
		driver.findElementByXPath("//input[@placeholder=\"Search\" and @class=\"form-control\"]").sendKeys(incidentNumber);
		driver.findElementByXPath("//input[@placeholder=\"Search\" and @class=\"form-control\"]").sendKeys(Keys.ENTER);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(1000);
		// TC006 Verifying Deletion
		String numOfRecords =" ";
		numOfRecords = driver.findElementByXPath("//tr[@class='list2_no_records']//td").getText();
		System.out.println(numOfRecords);
		if (numOfRecords.contains("No records to display")) {
			System.out.println("Selected Record is deleted");
		} else {
			System.out.println("Selected Record is not deleted");
		}

	}

}
