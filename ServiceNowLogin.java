package stepdefs;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowLogin extends ServiceNowBaseTest{

	@Given ("Load URL Service Now {string}")
	public void LoadURLinServiceNow(String url)
	{
		WebDriverManager.chromedriver().setup();

		// to disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	}
	@And ("Type username Service Now as {string}")
	public void toEnterUserNameinServiceNow(String UserName)
	{
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UserName);
	}
	
	
	@And ("Type password Service Now as {string}")
	public void toEnterPasswordinServiceNow(String Password)
	{
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);

	}
	
	@And ("Click Login Button Service Now")
	public void toClickOnLoginButtonInServiceNow()
	{
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	
	@Then ("Verify Login is successful Service Now")
	
	public void VerifyLoginToServiceNowIsSuccessFull()
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
		driver.close();
	}
	
}
