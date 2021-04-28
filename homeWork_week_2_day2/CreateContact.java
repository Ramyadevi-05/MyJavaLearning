package homeWork_week_2_day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		
		
		 //Pseudo Code
		  
		 // 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		
		// 2. Enter the user name and password by using the id property 
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
				
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		
		 //3. Click on Login Button using Class Locator
		
		driver.findElement(By.className("decorativeSubmit")).click();		
		 // 4. Click on CRM/SFA Link
		
		driver.findElement(By.xpath("//*[@id='label']/a")).click();
		  
		 // 5. Click on contacts Button
		
		driver.findElement(By.xpath("//div[@class='x-panel-header']/a[text()='Contacts']")).click();
		 
		 // 6. Click on Create Contact
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		  
		 // 7. Enter FirstName Field Using id Locator
		
		driver.findElement(By.id("firstNameField")).sendKeys("Ramya");
		 
		 // 8. Enter LastName Field Using id Locator
		
		driver.findElement(By.id("lastNameField")).sendKeys("Devi");

		  
		 // 9. Enter FirstName(Local) Field Using id Locator
		
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Devi");
		  
		 // 10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Devi");
		  
		 // 11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("CSC");

		 // 12. Enter Description Field Using any Locator of your choice 
		
		driver.findElement(By.id("createContactForm_description")).sendKeys("Practicing create contact scenario");

		 // 13. Enter your email in the E-mail address Field using the locator of your choice
		
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("testing@gmail.com");
 
		 // 14. Select State/Province as NewYork Using Visible Text
		
		WebElement State=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		
		Select Statedropddown=new Select(State);
		
		Statedropddown.selectByVisibleText("New York");
		 // 15. Click on Create Contact
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		 
		 // 16. Click on edit button 
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(2000);
		  
		//  17. Clear the Description Field using .clear
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();

		 // 18. Fill ImportantNote Field with Any text
		
		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Updating important note field from edit screen");

		  
		 // 19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		
		  
		// 20. Get the Title of Resulting Page.
		
		String title = driver.getTitle();
		System.out.println(title);
		
         driver.close();
		
	}

}
