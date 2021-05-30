package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ViewLead extends TestNgHooks{
	
	String leadname=" ";
	@Given("Verify the lead is created")
	public ViewLead verifyTitle() {
		verifyExactTitle("View Lead");
		return this;
		}
	
	@Given("To click on Find Leads link")
	public ViewLead clickFindLeadMenu() {
		click(locateElement("link","Find Leads"));
		return this;
	}
	
	@And ("To click on email and enter email as (.*)$")
	public ViewLead clickEmailandEnterEmail(String email) throws InterruptedException {
		click(locateElement("xpath", "//span[text()='Email']"));
		type(locateElement("xpath", "//span[text()='Email']"),email);
		return this;

	}
	
	@And ("To click on find Leads button")
	public ViewLead click_FindLeads_Button()
	{
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		return this;
	}

	@And ("To get and click on first resulting value") 
	public ViewLead getFirstvalue() throws InterruptedException {
		getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]"));
		Thread.sleep(2000);
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]"));
		Thread.sleep(2000);
		leadname=getText(locateElement("id", "viewLead_firstName_sp"));
		return this;
	}
	
	@And ("To click DuplicateLead button")
	public ViewLead clickDuplicateLeadButton() {
		
		click(locateElement("xpath", "//a[text()='Duplicate Lead']"));
		verifyPartialTitle("Duplicate Lead");
		return this;

	}
	
	@And ("To click on Create Lead")
	public ViewLead clickonCreate_Lead_Update() throws InterruptedException
	{
		click(locateElement("xpath", "//input[@value='Create Lead']"));
		Thread.sleep(2000);
		return this;
	}
	
	@Then ("To Verify the duplicateValue updated")
	public ViewLead verifyDuplicateValue() throws InterruptedException {
		String text2 = getText(locateElement("id", "viewLead_firstName_sp"));
		System.out.println(text2);
		Thread.sleep(2000);
		if(text2.equalsIgnoreCase(leadname))
			System.out.println("Duplicate name and the captured name are same");
		else
			System.out.println("Duplicate name and the captured name are not same");
		return this;
	}
	
}