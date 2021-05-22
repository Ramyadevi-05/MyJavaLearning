package week5.day2.homework;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends BaseTest{
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws InvalidFormatException, IOException{
		
		String[][] data = ReadExcel.readExcelData("Edit Lead");
		return data;
		
	}
	@Test(dataProvider = "TestData")
	public void editlead(String firstname, String companyname) throws InterruptedException {
		    
//		7	Click Find leads
		
		driver.findElement(By.linkText("Find Leads")).click();

//			 8	Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName' and @class=' x-form-text x-form-field'])[3]")).sendKeys(firstname);
		
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
		System.out.println(text);
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		Thread.sleep(2000);

		
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyname);
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

	}
	
}	