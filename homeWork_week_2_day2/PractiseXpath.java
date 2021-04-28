package homeWork_week_2_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseXpath {

	public static void main(String[] args) {

		/*
		**No need to write Selenium script - Just find these elements in the DOM using only XPaths
		
		Try all the xpaths that you've learnt (basic, text-based, axes..)*/
		
	//	1. Launch the URL
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//	2. Enter the username based on its label
		
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[1]")).sendKeys("");
		
		//	3. Enter the password based on its label
		
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("");

		
		
		//	4. Click Login
		
		driver.findElement(By.xpath("(//input[@class='decorativeSubmit']")).click();
		
		//	5. Click on CRMSFA link
		
		driver.findElement(By.xpath("//*[@id='label']/a")).click();
		
		//	6. Click on Leads link
		
		driver.findElement(By.xpath("(//div[@class='x-panel-tc']//div[@class='x-panel-header']/a)[2]")).click();
		
		//	7. Click on Merge Leads link
		
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li/a[text()='Merge Leads']")).click();
		
		//	8. Click the first img icon
		driver.findElement(By.xpath("(//a//img[@alt='Lookup'])[1]")).click();
		
		//	9. Select the first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[1]")).click();
		
		//	10. Click the second img icon
		
		driver.findElement(By.xpath("(//a//img[@alt='Lookup'])[2]")).click();
		
		//	11. Select the second resulting lead
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[2]")).click();

		//	12. Click on Merge Lead (submit) button
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		//	13. Get the company name text based on its label
		driver.findElement(By.xpath("//td[@class='label']//following-sibling::td//span[@id='viewLead_companyName_sp']")).getText();
		
		

	}

}