package tests;

import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.Login;

public class LoginTest extends TestNgHooks{
	
	@Test(dataProvider="FetchExcelData")
	public void login(String username, String password)
	{
		new Login()
		.typeUserName(username)
		.typePassword(password)
		.clickLogin()
		.getHomePageUserTitle()
		.clickLogoutSuccess();
	}

}
