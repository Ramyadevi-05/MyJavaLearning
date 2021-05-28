package week6day2.homework.servicenowhooks;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowHooks {
	
public static ChromeDriver driver;
//public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//public static ChromeOptions options;
	@BeforeMethod
	public void init()
	{
		WebDriverManager.chromedriver().setup();
		// to disable notifications
//		options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
	//	driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}

