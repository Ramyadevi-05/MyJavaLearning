package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.Given;

public class CreateLead  extends TestNgHooks{

	@Given("Click CRM SFA Link")
	public Home clickCrmSfa() {
		click(locateElement("link","CRM/SFA"));
		return new Home();
	}
	
	@Given("Click Leads Tab")
	public CreateLead clickCreateLeadMenu() {
		click(locateElement("link","Create Lead"));
		return this;
	}
	
	@Given("Click Find Lead Menu")
	public CreateLead clickFindLeadMenu() {
		click(locateElement("link","Find Leads"));
		return this;
	}
	@Given("Type Company Name as (.*)$")
	public CreateLead typeCompanyName(String companyName) {
		type(locateElement("id", "createLeadForm_companyName"),companyName);
		return this;
	}
	
	@Given("Type First Name as (.*)$")
	public CreateLead typeFirstName(String firstName) {
		type(locateElement("id", "createLeadForm_firstName"),firstName);
		return this;
	}
	
	@Given("Type Last Name as (.*)$")
	public CreateLead typeLastName(String lastName) {
		type(locateElement("id", "createLeadForm_lastName"),lastName);
		return this;
		}

	@Given("Click Create Lead Button")
	public ViewLead clickCreateLeadSubmit() {
		click(locateElement("class","smallSubmit"));
		return new ViewLead();
	}
	
	}
