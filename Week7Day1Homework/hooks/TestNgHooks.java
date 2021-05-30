package hooks;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ReadExcel;
import wrappers.BaseDriver;

public class TestNgHooks extends BaseDriver{
	
	@BeforeSuite
	public void init()
	{
		
	}
	
	@BeforeTest
	public void setUpTest() {
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		
	}
	
	@BeforeMethod
	public void invoke()
	{
		//start the app 
		startApp("chrome","http://leaftaps.com/opentaps");
	}
	
	@AfterMethod
	public void close()
	{
		closeActiveBrowser();
	}
	
	@AfterClass
	public void afterClass()
	{
		
	}
	@AfterTest
	public void afterTest()
	{
		
	}
	@AfterSuite
	public void afterSuite()
	{
		
	}

	@Before
	public void initBefore()
	{
		invoke();
	}
	
	@After
	public void afterClose()
	{
		close();
	}
	
	@DataProvider(name="FetchExcelData")
	public Object[][] readExcelData()
	{
		try {
			return ReadExcel.readExcelData("Login");
		} catch (InvalidFormatException e) {
			System.err.println("Excel format is incorrect");
		} catch (IOException e) {
			System.err.println("File read error");
		}
		return null;
	}

	
}
