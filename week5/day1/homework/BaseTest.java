package week5.day1.homework;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	ChromeDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	
	public void Login() {
		
				// Pre-condition - As per the machine config. it will download the required driver as per the version 
				WebDriverManager.chromedriver().setup();
						
				// Step 1: to launch browser 
				driver=new ChromeDriver();
				
				//Step 2: URL Load 
				driver.get("http://leaftaps.com/opentaps");
				
				//Step 3: Maximize			
				driver.manage().window().maximize();
				
				//step 4: Find the user name and type the value
				driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
				
				//Step 5: To find the password field and enter the password value 				
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				
				//Step 6: Find the login  button and click 				
				driver.findElement(By.className("decorativeSubmit")).click();
				
				//Step 7: Verify that you logged in 				
				String text = driver.findElement(By.tagName("h2")).getText();
				System.out.println(text);
				
				//To get title 
				
				String title=driver.getTitle();
				if(title.equals("Leaftaps - TestLeaf Automation Platform"))
				{
					System.out.println("Title is matched");
				}else 
				{
					System.out.println("Title mismatch");
				}
				
				//Step 8 To click on link CRM/SFA				
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				//Step 9  Click Create Lead link 
				driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@AfterMethod
	 public void Logout()
	 {
		driver.close();
	 }
	
	
}
