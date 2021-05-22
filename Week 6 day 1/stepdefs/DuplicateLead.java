package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	ChromeDriver driver;
	String leadname="";
	@Given ("To Launch the Chrome Browser")
	public void launchBroser_DuplicateLead(){	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@When ("To Load the URL {string}")
	public void url_DuplicateLead(String url){
		driver.get(url);
		}

	@And ("Type the user_name as {string}")
	public void type_UserName_DuplicateLead(String username){
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@And ("Type the user_password as {string}")
	public void type_Pword_DuplicateLead(String password) {
		
		driver.findElement(By.id("password")).sendKeys(password);

	}
	@And ("Click Login")
	public void clickOnLogin_DuplicateLead(){
		driver.findElement(By.className("decorativeSubmit")).click();

	}
	@And ("Verify Login")
	public void isSuccess_DuplicateLead(){
	WebElement eleCrm=driver.findElementByLinkText("CRM/SFA");
	System.out.println(eleCrm.isDisplayed());
	}

	@And ("Click CRMSFA link")
	public void clickOnCRMSFALink_DuplicateLead()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
	}


	@Then ("Click on Lead") 
	public void clickOnCreateLead_DuplicateLead() {
		
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	
	@When ("To click on Find Leads link")
	public void click_FindLeads_Link()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@And ("To click on email and enter email as (.*)$")
	public void clickEmailandEnterEmail(String email) throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys(email);
		Thread.sleep(2000);

	}
	
	@And ("To click on find Leads button")
	public void click_FindLeads_Button()
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@And ("To get and click on first resulting value") 
	public void getFirstvalue() throws InterruptedException {
		String text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).getText();
		System.out.println(text);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).click();
		Thread.sleep(2000);

		leadname=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(leadname);
	}
	
	@And ("To click DuplicateLead button")
	public void clickDuplicateLeadButton() {
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();	
		String title = driver.getTitle();
		if(title.contains("Duplicate Lead"))
			System.out.println("Title is matching");
		else
			System.out.println("Title is not matching");
	}
	
	@And ("To click on Create Lead")
	public void clickonCreate_Lead_Update() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();	
		Thread.sleep(2000);
	}
	
	
	@Then ("To Verify the duplicateValue updated")
	public void verifyDuplicateValue() throws InterruptedException {
		String text2 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(text2);
		Thread.sleep(2000);
		if(text2.equalsIgnoreCase(leadname))
			System.out.println("Duplicate name and the captured name are same");
		else
			System.out.println("Duplicate name and the captured name are not same");
	}
	
}
