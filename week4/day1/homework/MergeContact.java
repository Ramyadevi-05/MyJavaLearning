package week4.day1.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		  
//		  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		  
//		  2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

//		  
//		  3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

//		  
//		  4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

//		  
//		  5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
//		  	
//		  6. Click on Merge Contacts using Xpath Locator
		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
//		  
//		  7. Click on Widget of From Contact
		
		driver.findElement(By.xpath("(//a//img[@alt='Lookup'])[1]")).click();
		
//		  8. Click on First Resulting Contact
		
		//To get the window handles 
		
		Set<String> allWindowHandles=driver.getWindowHandles();
		System.out.println(allWindowHandles.size());
		
		// To get the second window handle and switch to it
		
		List<String> lstWindows=new ArrayList<String>(allWindowHandles);
		System.out.println(lstWindows.size());
		
		String firstwindow=lstWindows.get(1);
		driver.switchTo().window(firstwindow);
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
	
				
		//Switching to parent window 
		String Parentwindow=lstWindows.get(0);

		driver.switchTo().window(Parentwindow);

//		  9. Click on Widget of To Contact
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//a//img[@alt='Lookup'])[2]")).click();

//		  10. Click on Second Resulting Contact
		Thread.sleep(1000);

		allWindowHandles=driver.getWindowHandles();
		System.out.println(allWindowHandles.size());
		lstWindows=new ArrayList<String>(allWindowHandles);
		System.out.println(lstWindows.size());
		String secondcontactselect=lstWindows.get(1);
		Thread.sleep(1000);

		driver.switchTo().window(secondcontactselect);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
//		  
//		  11. Click on Merge button using Xpath Locator
		
			Parentwindow=lstWindows.get(0);
			driver.switchTo().window(Parentwindow);
	  		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
//		  12. Accept the Alert
	  
	  		Alert alert=driver.switchTo().alert();
	  			alert.accept();

	  
//		  13. Verify the title of the page
	 
	  			System.out.println(driver.getTitle());

	  			driver.close();
	}

}
