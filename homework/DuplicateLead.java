package week5.day2.homework;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseTest{
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws InvalidFormatException, IOException{
		
		String[][] data = ReadExcel.readExcelData("Duplicate Lead");
		return data;
		
	}
	@Test(dataProvider = "TestData")
	public void duplicatelead(String email) throws InterruptedException {
	
//	7	Click Find leads
	
	driver.findElement(By.linkText("Find Leads")).click();

//	8	Click on Email
	
	driver.findElement(By.xpath("//span[text()='Email']")).click();
	
//	9	Enter Email
	driver.findElement(By.name("emailAddress")).sendKeys(email);
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

}
	
}
