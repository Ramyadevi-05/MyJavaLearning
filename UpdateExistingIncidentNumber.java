package stepdefs;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateExistingIncidentNumber extends ServiceNowBaseTest{
	public String incidentNumber;
	public String incidentValueAftercreation;
	@Given ("Load URL Service Now To Update Incident Mandatory Fields {string}")
	public void toLoadURLToUpdateIncident(String url)
	{
		WebDriverManager.chromedriver().setup();

		// to disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@And ("Type username Service Now To Update Incident Mandatory Fields  as {username}")
	public void toEnterUserNameToUpdateIncident(String username)
	{
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	}
	
	@And ("Type password Service Now To Update Incident Mandatory Fields  as {password}")
	public void toEnterPasswordToUpdateIncident(String password)
	{
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	}
	
	@And ("Click Login Button Service Now To Update Incident Mandatory Fields")
	public void toLoginToCreateandUpdateIncident()
	{
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	
	
	@And ("Verify Login is successful Service Now To Update Incident Mandatory Fields")
	public void toVerifyLoginToCreateandUpdateIncident()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));
		String text=driver.getTitle();
		if(text.contains("ServiceNow"))
		{
			System.out.println("Title is matched");
		}else
		{
			System.out.println("Title is mismatched");
		}
	}
	
	@And ("Search for Incident To Update Incident Mandatory Fields")
	public void toSearchIncident()
	{
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
	}
	
	@And ("Click on CreateNewIncident To Update Incident Mandatory Fields")
	public void toClickOnCreateNewIncidentToUpdate()
	{
		driver.findElement(By.xpath(
				"//a[@href=\"incident.do?sys_id=-1&sysparm_query=active=true&sysparm_stack=incident_list.do?sysparm_query=active=true\"]"))
				.click();

		
		driver.switchTo().frame("gsft_main");
		// Reading incident Number and creating it
		incidentNumber = driver.findElementByXPath("//input[@name='incident.number']").getAttribute("value");
		System.out.println(incidentNumber);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.findElementById("sys_display.incident.caller_id").click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		driver.findElementById("sys_display.incident.caller_id").sendKeys("ml.admin");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	}
	
	@And ("Click on Submit To Update Incident Mandatory Fields")	
	public void toclickOnUpdateToCreateandUpdateIncident()
	{
		driver.findElement(By.xpath(
				"//a[@href=\"incident.do?sys_id=-1&sysparm_query=active=true&sysparm_stack=incident_list.do?sysparm_query=active=true\"]"))
				.click();

		
		driver.switchTo().frame("gsft_main");
		// Reading incident Number and creating it
		//incidentNumber = driver.findElementByXPath("//input[@name='incident.number']").getAttribute("value");
		System.out.println(incidentNumber);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.findElementById("sys_display.incident.caller_id").click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		driver.findElementById("sys_display.incident.caller_id").sendKeys("ml.admin");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	}
	
	@Then ("Created Incident Number to update Incident")
	public void updateIncidentNumber()
	{
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
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
	}
}
