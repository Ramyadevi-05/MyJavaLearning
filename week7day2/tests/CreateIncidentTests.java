package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import hooks.TestNgHooks;
import pages.Login;

public class CreateIncidentTests extends TestNgHooks{
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Create Incident";
		testDescription = "Create Incident";
		nodes = "Incident";
		authors = "Ramya";
		category = "Smoke";
		dataSheetName = "Create Incident";
	}
	
	@Test(dataProvider = "fetchData")
	public void LoginServiceNow(String username,String password)
	{
		new Login()
		.toswitchtoLoginFrame()
		.enterUserName(username)
		.enterPassWord(password)
		.clickOnLogIn()
		.clickOnFilter()
		.toSearchForIncident()
		.toClickOnCreateNew()
		.toSwitchToCreateIncidentFrame()
		.getIncidentID();
	}

}
