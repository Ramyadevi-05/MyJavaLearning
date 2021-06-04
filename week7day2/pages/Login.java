package pages;

import hooks.TestNgHooks;

public class Login extends TestNgHooks{
	
	public Login toswitchtoLoginFrame()
	{
		switchToFrame(0);
		return this;
	}
	public Login enterUserName(String username)
	{
		click(locateElement("id", "user_name"));
		clearAndType(locateElement("id", "user_name"), username);
		return this;
	}
	
	public Login enterPassWord(String password)
	{
		click(locateElement("id", "user_password"));
		clearAndType(locateElement("id", "user_password"), password);	
		return this;
	}
	
	public Home clickOnLogIn()
	{
		click(locateElement("id", "sysverb_login"));
		return new Home();
	}
	
	public Login invalidPasswordEntry(String password)
	{
		click(locateElement("id", "user_password"));
		clearAndType(locateElement("id", "user_password"), password);	
		return this;
	}
	
}
