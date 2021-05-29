package stepdefs;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncidentWithNoMandatoryfieldsTest extends ServiceNowBaseTest{
	
	@Given ("Load URL Service Now To Create Incident {string}")
	public void toLoginToCreateIncident(String URL)
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
	
	@And ("Type username Service Now To Create Incident as {string}")
	public void toEnterUserNameToCreateIncident(String UserName)
	{
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UserName);
	}
	
	@And ("Type password Service Now To Create Incident as {string}")
	public void toEnterPasswordToCreateIncident(String Password)
	{
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
	}
	@And ("Click Login Button Service Now To Create Incident")
	public void ClickLoginforCreateIncident()
	{
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	@And ("Verify Login is successful Service Now To Create Incident")
	public void VerifyLoginToCreateIncident()
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
	
	@And ("Search for Incident To Create Incident")
	public void SearchForIncidentInFilter()
	{

		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
	}
	
	@And ("Click on CreateNewIncident To Create Incident") 
	public void ClickOnCreateNewIncidentLink()
	{
		driver.findElement(By.xpath(
				"//a[@href=\"incident.do?sys_id=-1&sysparm_query=active=true&sysparm_stack=incident_list.do?sysparm_query=active=true\"]"))
				.click();

		String incidentNumber = " ";
		driver.switchTo().frame("gsft_main");
		// Reading incident Number and creating it
		incidentNumber = driver.findElementByXPath("//input[@name='incident.number']").getAttribute("value");
		System.out.println(incidentNumber);
	}
	
	@And ("Click on Submit To Create Incident")
	public void ClickOnSubmitToCreateIncident()
	{
		driver.findElementByXPath("//button[@id='sysverb_insert']").click();
	}
	
	
	@Then ("VerifyMandatoryFieldsValidation To Create Incident")
	public void VerifyMandatoryFields()
	{
		String Validation=driver.findElementByXPath("//span[@class='outputmsg_text']").getText();
		System.out.println(Validation);
		if(Validation.contains("The following mandatory fields are not filled in: Short description, Caller"))
		{
			System.out.println("Mandatory Field validation is verified");
		}else
		{
			System.out.println("Mandatory Field validation is failed");
		}
		
		driver.close();
	}
	
	
	
}
