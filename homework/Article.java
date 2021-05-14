package week4.day2.homework;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Article {

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
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Knowledge");
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement CreateArticle=driver.findElementByXPath("(//div[@class='sn-widget-list-content']//div[text()='Create New' and @class=\"sn-widget-list-title\"])[5]");
		driver.executeScript("arguments[0].scrollIntoView(true);", CreateArticle);
		Thread.sleep(2000);

		CreateArticle.click();
		
		driver.switchTo().frame("gsft_main");
		
		String ArticleNumber=driver.findElementById("sys_readonly.kb_knowledge.number").getAttribute("value");
		System.out.println(ArticleNumber);
		System.out.println("Article ID is created"+ArticleNumber);

		driver.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']").sendKeys("Knowledge");
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		Thread.sleep(2000);
		
		driver.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']").sendKeys(Keys.TAB);
		driver.findElementById("kb_knowledge.short_description").sendKeys("Creating New Article");	
		Thread.sleep(2000);

		driver.findElementById("sysverb_insert").click();
		System.out.println("Knowledge base article created with value knowledge");

		Thread.sleep(2000);
		
		WebElement SelectSearchFilterasNumber=driver.findElementByXPath("//select[@class=\"form-control default-focus-outline\"]");
		SelectSearchFilterasNumber.click();
		Select selectValue = new Select(SelectSearchFilterasNumber);
		List<WebElement> values = selectValue.getOptions();
		int sizeofSearchList = values.size();
		System.out.println(sizeofSearchList);			
		
		selectValue.selectByVisibleText("Number");
		
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").click();
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(ArticleNumber);
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElementByXPath("//a[@class='linked formlink']").click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));
		Thread.sleep(2000);

		driver.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']").sendKeys("IT");
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		Thread.sleep(2000);

		driver.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']").sendKeys(Keys.TAB);
		driver.findElementById("sysverb_update").click();
		
		Thread.sleep(2000);
		System.out.println("Knowledge base value updated to IT");

		SelectSearchFilterasNumber=driver.findElementByXPath("//select[@class=\"form-control default-focus-outline\"]");
		SelectSearchFilterasNumber.click();
		selectValue = new Select(SelectSearchFilterasNumber);
		values = selectValue.getOptions();
		sizeofSearchList = values.size();
		System.out.println(sizeofSearchList);			
		
		selectValue.selectByVisibleText("Number");
		
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").click();
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(ArticleNumber);
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElementByXPath("//a[@class='linked formlink']").click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("ServiceNow"));
		Thread.sleep(2000);

		driver.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_category']").sendKeys("Java");
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		Thread.sleep(2000);

		driver.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_category']").sendKeys(Keys.TAB);
		driver.findElementById("sysverb_update").click();
		System.out.println("Category value updated");
		driver.close();
		
		
	}

}
