package week6day2.homework.tests;

import org.testng.annotations.Test;

import week6day2.homework.servicenowhooks.ServiceNowHooks;
import week6day2.homework.servicenowpages.CreateNewChangeRequestPage;
import week6day2.homework.servicenowpages.LoginPage;
public class AccessChangeRequests extends ServiceNowHooks{

	CreateNewChangeRequestPage CR=new CreateNewChangeRequestPage();

	@Test
	public void AccessChgReq() {
			new LoginPage()
			.switchToframeforlogin()
			.toEnterUserName("admin")
			.toEnterPassword("India@123")
			.clickOnLogin()
			.verifyHomePage()
			.searchforChangeRequest()
			.clickOnCreateNew()
			.getChangeRequestNumber()
			.ClickOnSubmit()
			.clickOnOpen()
			.SetFilterAsNumber()
			.seachCR(CR.getCRValue())
			.ValidateSearchAndRetrievedCR()
			.toSelectAssessGroup()
			.toSelectAssignmentGroup()
			.toSelectAssignedGroup()
			.toUpdateCR()
			.seachCR(CR.getCRValue())
			.toVerifyState()
			.toVerifyAssignedUser();		
			
	}

}
