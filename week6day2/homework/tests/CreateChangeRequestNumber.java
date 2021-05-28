package week6day2.homework.tests;

import org.testng.annotations.Test;

import week6day2.homework.servicenowhooks.ServiceNowHooks;
import week6day2.homework.servicenowpages.LoginPage;

public class CreateChangeRequestNumber extends ServiceNowHooks{

	@Test
	public void ServiceNow() {
			new LoginPage()
			.switchToframeforlogin()
			.toEnterUserName("admin")
			.toEnterPassword("India@123")
			.clickOnLogin()
			.verifyHomePage()
			.searchforChangeRequest()
			.clickOnCreateNew()
			.getChangeRequestNumber()
			.ClickOnSubmit();
	}

}
