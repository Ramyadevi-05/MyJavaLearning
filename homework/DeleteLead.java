package week5.day2.homework;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteLead extends BaseTest{
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws InvalidFormatException, IOException{
		
		String[][] data = ReadExcel.readExcelData("Delete Lead");
		return data;
		
	}
	@Test(dataProvider = "TestData")
	public void deletelead(String PhoneNumber) throws InterruptedException {

//	7	Click Find leads
	
	driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	
//	8	Click on Phone
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	
//	9	Enter phone number
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(PhoneNumber);
	
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
}

}
