package week6day2.homework.servicenowpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import week6day2.homework.servicenowhooks.ServiceNowHooks;

public class HomePage extends ServiceNowHooks{

	public HomePage verifyHomePage()
	{
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));
		String title=driver.getTitle();
		if(title.contains("ServiceNow"))
			System.out.println("Title is matched.Logged in Successfully");
		else
			System.out.println("Login failed");
		return this;
	}

	public HomePage searchforChangeRequest()
	{	
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Change");
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		return this;
	}
	
	public CreateNewChangeRequestPage clickOnCreateNew() {
		
		//Clicking on Create New
		driver.findElement(By.xpath(
				"//a[@href='new_change_redirect.do']"))
				.click();
		driver.switchTo().frame("gsft_main");
		//clicking on Model 
		driver.findElementByXPath("//div[@aria-label=\"Models\"]").click();
		//clicking on Normal model 
		driver.findElementByXPath("(//div[@class=\"change-model-card-component\"])[2]").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new CreateNewChangeRequestPage();
	}	

	
	public SearchPage clickOnOpen()
	{
		//To click on open 
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();		
		driver.switchTo().frame("gsft_main");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		return new SearchPage();
	}
	
	public HomePage ClickOnKnowledge()
	{
		//Searching for Change Request 
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Knowledge");
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public ArticlePage toClickOnCreateNewArticle()
	{
		WebElement CreateArticle=driver.findElementByXPath("(//div[@class='sn-widget-list-content']//div[text()='Create New' and @class=\"sn-widget-list-title\"])[5]");
		driver.executeScript("arguments[0].scrollIntoView(true);", CreateArticle);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		CreateArticle.click();
		return new ArticlePage();
	}
}
