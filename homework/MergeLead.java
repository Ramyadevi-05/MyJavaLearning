package week5.day2.homework;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MergeLead extends BaseTest{
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws InvalidFormatException, IOException{
		
		String[][] data = ReadExcel.readExcelData("Merge Lead");
		return data;
		
	}
	@Test(dataProvider = "TestData")
	public void mergelead(String firstname) throws InterruptedException {
		
		//To click on the Merge Leads link
		driver.findElementByXPath("//a[text()='Merge Leads']").click();
		
		//To click on the From Lead 	
		driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
		
		Thread.sleep(1000);
		//To search with First Name
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(firstname);
		
		//To click on find leads		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
		//Click on first resulting lead		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		Thread.sleep(2000);
		
		//To click on the To Lead 
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		
		//To click on find leads		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		//Click on first resulting lead		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[2]")).click();
		Thread.sleep(2000);
		
		//Click on Merge Lead
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Clicking on Alert 
		driver.switchTo().alert().accept();
		
		String Title=driver.getTitle();
		
		System.out.println(Title);
		
		if(Title.equalsIgnoreCase("View Lead | opentaps CRM"))
		{
			System.out.println("Title is matched");
		}
		else
		{
			System.out.println("Title is not matched");
		}
		
		
	}

}
