package homeWork_week_2_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		    
		
			//http://leaftaps.com/opentaps/control/main
			
//			 1	Launch the browser

		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
//			 2	Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
 
//			 3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

//		4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();		

		
//		5	Click crm/sfa link
		
		driver.findElement(By.xpath("//*[@id='label']/a")).click();
//		6	Click Leads link
		
		driver.findElement(By.linkText("Create Lead")).click();
		
//		7	Click Find leads
		
		driver.findElement(By.linkText("Find Leads")).click();

//			 8	Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName' and @class=' x-form-text x-form-field'])[3]")).sendKeys("Ramya");
		
//			 9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
//			 10 Click on first resulting lead
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		Thread.sleep(2000);

		

		String text3 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		Thread.sleep(2000);

		System.out.println(text3);
//			 11 Verify title of the page
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("View Lead"))
			System.out.println("Title is matching");
		else
			System.out.println("Title is not matching");

//			 12 Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(2000);

//			 13 Change the company name
		String text = driver.findElement(By.id("updateLeadForm_companyName")).getText();
		Thread.sleep(2000);

		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		Thread.sleep(2000);


		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("ZOHO");
		Thread.sleep(2000);

		
//			 14 Click Update
		
		driver.findElementByXPath("//input[@value='Update']").click();
		
//			 15 Confirm the changed name appears
		String text2 = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println(text2);
		
		if(text2.contains(text3))
			System.out.println("Names are matching");
		else
			System.out.println("Names are not matching");
			
//			 16 Close the browser (Do not log out)
	//	driver.close();

	}
	
}	