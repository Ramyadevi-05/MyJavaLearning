package week5.day2.homework;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateLead extends BaseTest{
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws InvalidFormatException, IOException{
		
		String[][] data = ReadExcel.readExcelData("Create Lead");
		return data;
		
	}
	
	@Test(dataProvider = "TestData",invocationCount = 3)
	public void createlead(String CompanyName,String firstName, String lastName,String primaryAreaCode, 
			String phonenumer,String extension,
			String email) throws InterruptedException {
		//Enter the company name 			
		driver.findElement(By.xpath("//td//input[@name='companyName']")).sendKeys(CompanyName);
		
		//Enter the first name 
		driver.findElement(By.xpath("//td//input[@name='firstName']")).sendKeys(firstName);
		
		//Enter the last name 				
		driver.findElement(By.xpath("//td//input[@name='lastName']")).sendKeys(lastName);
		
		// Area code 
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys(primaryAreaCode);
		
		//Phone Number	
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phonenumer);
	
		//Extension
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys(extension);
		
		//E-Mail Address
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);

		//Final Step  Click on create lead 
		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	}
	

}
