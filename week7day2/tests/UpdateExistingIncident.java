package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.Login;

public class UpdateExistingIncident extends TestNgHooks{
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Update Existing Incident";
		testDescription = "Update Existing Incident";
		nodes = "Incident";
		authors = "Ramya";
		category = "Smoke";
		dataSheetName = "UpdateExistingIncident";
	}
	
	@Test(dataProvider = "fetchData")
	public void UpdateExistingIncidentServiceNow(String username,String password, String callerid,String shortdescription,String WorkNotes)
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
		.getIncidentID()
		.clickOnCallerId()
		.enterCalledIDValue(callerid)
		.enterShortDesc(shortdescription)
		.clickOnSubmit()
		.openIncident()
		.clickonIncidentLink()
		.selectUrgency()
		.selectState()
		.toEnterWorkNotes(WorkNotes)
		.clickonUpdate();
	}

}
