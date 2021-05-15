package week5.day1.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class CreateLead extends BaseTest{
	@Test
	public void createlead() throws InterruptedException {
		
	
		//Step 10 Enter the company name 			
		driver.findElement(By.xpath("//td//input[@name='companyName']")).sendKeys("Verizon");
		
		//Step 11 Enter the first name 
		driver.findElement(By.xpath("//td//input[@name='firstName']")).sendKeys("Ramyadevi");
		
		//Step 12 Enter the last name 				
		driver.findElement(By.xpath("//td//input[@name='lastName']")).sendKeys("AL");
		
		//Step 12a - Select source drop down value as Partner				
		WebElement dropdown1=driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd1=new Select(dropdown1);				
		dd1.selectByVisibleText("Partner");
		
		//Step 13 To select Marketing Campaign 				
		WebElement MarketingCampaign=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dd2=new Select(MarketingCampaign);
		dd2.selectByVisibleText("Demo Marketing Campaign");
		
		//Step 14 to enter firstNameLocal
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("R");
		
		//Step 15 to enter lastNameLocal
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("D");
		
		//Step 16 To enter Salutation				
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Ms");
		
		//Step 17 To enter Birth date 								
		driver.findElement(By.name("birthDate")).sendKeys("12/05/88");
		
		//Step 18 To enter Title 
		driver.findElement(By.name("generalProfTitle")).sendKeys("Quality Assurance");
		
		//Step 19 Department
		driver.findElement(By.name("departmentName")).sendKeys("Quality Assurance");

		//Step 20 Annual Revenue
		driver.findElement(By.name("annualRevenue")).sendKeys("1200000");
		
		//Step 21 Preferred Currency 
		WebElement Currency=driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select dd3=new Select(Currency);
		dd3.selectByVisibleText("INR - Indian Rupee");
		
		//Step 22 Industry 
		WebElement Industry=driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dd4=new Select(Industry);
		dd4.selectByVisibleText("Computer Software");
		
		//Step 23 Number of employees 				
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("15000");
		
		//Step 24 Ownership 
		WebElement Ownership=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dd5=new Select(Ownership);
		dd5.selectByVisibleText("Partnership");
		
		//Step 25 SIC Code	
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("1001");
		
		//Step 26 Ticker Symbol	
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("NA");
		
		//Step 27 Description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Learning Selenium element locators and practicing");
		
		//Step 28 Important Note			
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Learning");
		
		//Step 29 Area code 
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("91");
		
		//Step 30 Phone Number	
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9841498342");
	
		//Step 31 Extension
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("000");
		
		//Step 32 Person to Ask For	
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Ramyadevi");
	
		//Step 33 E-Mail Address
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ramyadevi512@gmail.com");

		//Step 34 Web Url	
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://github.com/Ramyadevi-05/MyJavaLearning");
		
		//Step 35 To Name	
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Ramyadevi AL");

		//Step 36 Attention Name
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Ramyadevi AL");
		
		//Step 37 Address Line 1	
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Chennai");

		//Step 38 Address Line 2	
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Chennai");

		//Step 39 City
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Ramyadevi AL");
		
		//Step 40 Country
		
		WebElement Country=driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select dd6=new Select(Country);
		dd6.selectByVisibleText("India");

		//Step 41 Zip/Postal Code	
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("601301");
		
		//Step 42 Zip/Postal Code Extension	
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("601301");
		
		//Step 43 State/Province
		Thread.sleep(1000);
		
		WebElement State=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd7=new Select(State);
		dd7.selectByVisibleText("TAMILNADU");

		//Final Step  Click on create lead 
		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	}
}
