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

public class CreateIncidentWithMandatoryFields extends ServiceNowBaseTest{
public String incidentNumber = " "; 
	@Given ("Load URL Service Now To Create Incident Mandatory Fields {string}")
	public void toLoadURLToCreateIncidentWithMandatoryFields(String URL)
	{

		WebDriverManager.chromedriver().setup();

		// to disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@And ("Type username Service Now To Create Incident Mandatory Fields  as {string}")
	public void toEnterUserNameToCreateIncidentWithMandatoryFields(String UserName) {
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UserName);
	}
	
	@And ("Type password Service Now To Create Incident Mandatory Fields  as {string}")
	public void toEnterPasswordToCreateIncientWithMandatoryFields(String Password) {
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
	}
	@And ("Click Login Button Service Now To Create Incident Mandatory Fields")
	public void toclickOnLoginToCreateIncientWithMandatoryFields(){
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	@And ("Verify Login is successful Service Now To Create Incident Mandatory Fields") 
	public void toVerifyLogintoCreateIncidentWithMandatoryFields() {
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
	@And ("Search for Incident To Create Incident Mandatory Fields")
	public void toSearchIncidentToCreateIncidentWithMandatoryFields() {
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
	}
	@And ("Click on CreateNewIncident To Create Incident Mandatory Fields")
	public void toClickonCreateNewIncidentToCreateIncidentMandatoryFields() {
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
	@And ("Click on Submit To Create Incident Mandatory Fields")
	public void toClickSubmitToCreateIncidentMandatoryFields() {
		driver.findElementByXPath("//button[@id='sysverb_insert']").click();
	}
	@Then ("Created Incident Number")
	public void toGetCreatedIncidentNumber() {
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
		driver.close();
		}	
	
	
}
