package homeWork_week_2_day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {
		
	/*http://leaftaps.com/opentaps/control/main*/
	 
	//Delete Lead:
//	1	Launch the browser
	
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver=new ChromeDriver();
	
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
	
//	2	Enter the username
	
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

	
//	3	Enter the password
	
	driver.findElement(By.id("password")).sendKeys("crmsfa");
//	4	Click Login
	driver.findElement(By.className("decorativeSubmit")).click();		

	
//	5	Click crm/sfa link
	
	driver.findElement(By.xpath("//*[@id='label']/a")).click();
	  
//	6	Click Leads link
	
	driver.findElement(By.linkText("Create Lead")).click();

//	7	Click Find leads
	
	driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	
//	8	Click on Phone
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	
//	9	Enter phone number
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1234567891");
	
//	10	Click find leads button
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(2000);

	
//	11	Capture lead ID of First Resulting lead
	String text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).getText();
	System.out.println(text);
	Thread.sleep(2000);
//	12	Click First Resulting lead
	Thread.sleep(2000);

	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).click();
	
//	13	Click Delete
	Thread.sleep(2000);

	driver.findElement(By.xpath("//a[text()='Delete']")).click();
	Thread.sleep(2000);

	
//	14	Click Find leads
	
	driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	Thread.sleep(2000);

	
//	15	Enter captured lead ID
	
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text);
	
//	16	Click find leads button
	driver.findElementByXPath("//button[text()='Find Leads']").click();

	Thread.sleep(2000);

//	17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	
	String text2 = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
	System.out.println(text2);
	if(text2.equalsIgnoreCase("No records to display"))
		System.out.println("Lead ID Record deleted:" + " " +text);
	else
		System.out.println("Lead ID Record not deleted:" + " " +text);

	
//	18	Close the browser (Do not log out)
	driver.close();

}

}
