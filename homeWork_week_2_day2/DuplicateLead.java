package homeWork_week_2_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	
	public static void main(String[] args) throws InterruptedException {
	/*http://leaftaps.com/opentaps/control/main	*/
	
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
	
	driver.findElement(By.linkText("Find Leads")).click();

//	8	Click on Email
	
	driver.findElement(By.xpath("//span[text()='Email']")).click();
	
//	9	Enter Email
	driver.findElement(By.name("emailAddress")).sendKeys("XYZ@gmail.com");
	Thread.sleep(2000);

	
//	10	Click find leads button
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	
//	11	Capture name of First Resulting lead
	Thread.sleep(2000);

	String text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).getText();
	System.out.println(text);
	
//	12	Click First Resulting lead
	
	Thread.sleep(2000);

	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).click();
	Thread.sleep(2000);

	String	leadname=driver.findElement(By.id("viewLead_firstName_sp")).getText();
	System.out.println(leadname);
//	13	Click Duplicate Lead
	driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
	
//	14	Verify the title as 'Duplicate Lead'
	String title = driver.getTitle();
	if(title.contains("Duplicate Lead"))
		System.out.println("Title is matching");
	else
		System.out.println("Title is not matching");
		
	
//	15	Click Create Lead

	
	driver.findElement(By.xpath("//input[@value='Create Lead']")).click();

	
//	16	Confirm the duplicated lead name is same as captured name
	Thread.sleep(2000);
	String text2 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
	System.out.println(text2);
	Thread.sleep(2000);

	if(text2.equalsIgnoreCase(leadname))
		System.out.println("Duplicate name and the captured name are same");
	else
		System.out.println("Duplicate name and the captured name are not same");
	
	
//	17	Close the browser (Do not log out)
	driver.close();
}
	
}
