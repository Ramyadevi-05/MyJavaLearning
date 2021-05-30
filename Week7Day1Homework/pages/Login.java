package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.Given;


public class Login extends TestNgHooks{
	
	@Given ("Type username is entered as (.*)$")
	public Login typeUserName(String userdata)
	{
		type(locateElement("id", "username"),userdata);
		return this;
	}
	
	@Given("Type password is entered as (.*)$")
	public Login typePassword(String passdata)
	{
		type(locateElement("id","password"),passdata);
		return this;
	}
	
	
	public Home typePasswordAndEnter(String passdata) {
		typeAndEnter(locateElement("id","password"),passdata);
		return new Home();
	}
	
	@Given("Click Login")
	public Home clickLogin() {
		click(locateElement("class","decorativeSubmit"));
		return new Home();
	}

	
	public Login clickLoginForFailures()
	{
		click(locateElement("class","decorativeSubmit"));
		return this;
	}
	

}
