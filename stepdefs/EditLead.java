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

public class EditLead {
	String text3="";
	ChromeDriver driver;
	
@Given ("To Launch the Chrome Browser for Edit Lead")
public void launchBroser_EditLead(){	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
@When ("To Load the URL for Edit Lead {string}")
public void url_EditLead(String url){
	driver.get(url);
	}

@And ("Type the uname as {string}")
public void type_UserName_EditLead(String username){
	driver.findElement(By.id("username")).sendKeys(username);
}
@And ("Type the pwd as {string}")
public void type_Password_EditLead(String password) {
	
	driver.findElement(By.id("password")).sendKeys(password);

}
@And ("Click Login for Edit Lead")
public void clickOnLogin_EditLead(){
	driver.findElement(By.className("decorativeSubmit")).click();

}
@And ("Verify Login for Edit Lead")
public void isSuccess_EditLead(){
WebElement eleCrm=driver.findElementByLinkText("CRM/SFA");
System.out.println(eleCrm.isDisplayed());
}

@And ("Click CRMSFA link for Edit Lead")
public void clickOnCRMSFALink_EditLead()
{
	driver.findElement(By.linkText("CRM/SFA")).click();
}


@Then ("Click on Lead for Edit Lead") 
public void clickOnCreateLead_EditLead() {
	
	driver.findElement(By.linkText("Create Lead")).click();
}


@When ("To click on the Find Leads link")
public void clickOnFindLeadsLink() {
	driver.findElement(By.linkText("Find Leads")).click();	
}
@And ("To enter firstname as (.*)$")
public void enterFirstNameToEditLead(String firstname)
{
	driver.findElement(By.xpath("(//input[@name='firstName' and @class=' x-form-text x-form-field'])[3]")).sendKeys(firstname);	
}
@And ("To click on the find leads button")
public void clickonFindLeadsButton() throws InterruptedException
{
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
}
@And ("Click on first resulting lead")
public void ToSelectFirstResultingLead() throws InterruptedException {
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
	Thread.sleep(2000);
}
@And ("To get existing company name")
public void getExistingCompanyName() throws InterruptedException {
	text3 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
	Thread.sleep(2000);

	System.out.println(text3);
//		 11 Verify title of the page
	String title = driver.getTitle();
	System.out.println(title);
	if(title.contains("View Lead"))
		System.out.println("Title is matching");
	else
		System.out.println("Title is not matching");
}
@And ("To click on Edit option") 
public void clickEditOption() throws InterruptedException
{
	driver.findElement(By.xpath("//a[text()='Edit']")).click();
	Thread.sleep(2000);

}
@And ("To clear existing value and update new Company name as (.*)$") 
public void resetAndReEnterCompanyName(String companyname) throws InterruptedException
{
	String text = driver.findElement(By.id("updateLeadForm_companyName")).getText();
	Thread.sleep(2000);
	System.out.println(text);
	driver.findElement(By.id("updateLeadForm_companyName")).clear();
	Thread.sleep(2000);
	driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyname);
	Thread.sleep(2000);

}

@And ("To click on update button") 
public void clickUpdate() {
	driver.findElementByXPath("//input[@value='Update']").click();
}

@Then ("Verify changed company value")
public void verifyEditedCompanyValue() {
	String text2 = driver.findElementById("viewLead_companyName_sp").getText();
	System.out.println(text2);
	
	if(text2.contains(text3))
		System.out.println("Names are matching");
	else
		System.out.println("Names are not matching");

}

	
}
