package pages;

import hooks.TestNgHooks;

public class UpdateIncident extends TestNgHooks{
	public UpdateIncident clickonIncidentLink()
	{
		
		click(locateElement("xpath", "//a[@class='linked formlink']"));
		return this;
	}


	public UpdateIncident selectUrgency()
	{
		click(locateElement("xpath", "//select[@name='incident.urgency']"));
		selectDropDownUsingText(locateElement("xpath", "//select[@name='incident.urgency']"),
				"1 - High");
		
		return this ;
	}
	
	public UpdateIncident selectState()
	{
		click(locateElement("xpath", "//select[@name='incident.state']"));
		selectDropDownUsingText(locateElement("xpath", "//select[@name='incident.state']"),"In Progress");
		return this ;
	}
	
	public UpdateIncident toEnterWorkNotes(String WorkNotes)
	{
		click(locateElement("xpath", "(//textarea[@aria-label='Work notes'])[2]"));
		executeScriptToScrollIntoView(locateElement("xpath", "(//textarea[@aria-label='Work notes'])[2]"));
		clearAndType(locateElement("xpath", "(//textarea[@aria-label='Work notes'])[2]"),WorkNotes);
		return this;
	}
	
	public ViewIncident clickonUpdate()
	{
		click(locateElement("xpath", "(//button[@value='sysverb_update'])[1]"));
		return new ViewIncident();
	}
	
}
