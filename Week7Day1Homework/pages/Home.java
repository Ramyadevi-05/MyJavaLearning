package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.Given;

public class Home extends TestNgHooks{	
	
		@Given("Verify the welcome message ")
		public Home getHomePageUserTitle() 
		{
			String userTitle=driver.findElementByTagName("h2").getText();
			if(userTitle.contains("Welcome"))
			{
				System.out.println("HomePage test passed");
			}else
			{
				System.out.println("HomePage test failed");
			}
			
			return this;	
		}
		
		
		public CreateLead clickCRMSFALink()
		{
			driver.findElementByLinkText("CRM/SFA").click();
			System.out.println("CRM/SFA link clicked successfully");
			return new CreateLead();
			
		}
		
		@Given("Click Logout")
		public Login clickLogoutSuccess() {
			driver.findElementByClassName("decorativeSubmit").click();
			Login login=new Login();
			return login;

		}
	

}
