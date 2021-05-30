package tests;

import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.Login;

public class DuplicateLead extends TestNgHooks {
	@Test(dataProvider = "FetchExcelData")
	public void login(String username, String password) {
		try {
			new Login().typeUserName(username).typePassword(password).clickLogin().getHomePageUserTitle()
					.clickCRMSFALink().clickCreateLeadMenu().clickFindLeadMenu().typeCompanyName("VZ")
					.typeFirstName("Ramya").typeLastName("devi").clickCreateLeadSubmit().verifyTitle()
					.clickFindLeadMenu().clickEmailandEnterEmail("ramyadevi512@gmail.com").click_FindLeads_Button()
					.getFirstvalue().clickDuplicateLeadButton().clickonCreate_Lead_Update().verifyDuplicateValue();
		} catch (InterruptedException e) {
			System.err.println("Issue in creating lead and providing duplicate lead");

		}
	}

}
