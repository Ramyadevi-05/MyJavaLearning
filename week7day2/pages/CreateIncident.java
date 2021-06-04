package pages;

import hooks.TestNgHooks;

public class CreateIncident extends TestNgHooks{
	public String incNumber="";
	
	public CreateIncident toSwitchToCreateIncidentFrame()
	{
		switchToFrame("gsft_main");
		return this;
	}
	

	public CreateIncident getIncidentID()
	{
		click(locateElement("xpath", "//input[@name='incident.number']"));
		incNumber=togetAttributeValue(locateElement("xpath", "//input[@name='incident.number']"));
		return this;
	}
	
	public CreateIncident clickOnCallerId()
	{
		click(locateElement("id", "sys_display.incident.caller_id"));
		return this;
	}
	
	public CreateIncident enterCalledIDValue(String callerid)
	{
		clearAndType(locateElement("id", "sys_display.incident.caller_id"),callerid);
		toPressEnterKeys(locateElement("id", "sys_display.incident.caller_id"));
		toPressTabKeys(locateElement("id", "sys_display.incident.caller_id"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	 	
	public CreateIncident enterShortDesc(String shortdescription){
		//executeScriptToScrollIntoView(locateElement("id", "//input[@id='sys_display.incident.assigned_to']"));
		clearAndType(locateElement("xpath", "//input[@id='incident.short_description']"),shortdescription);
		return this;
	}
	
	public Home clickOnSubmit()
	{
		click(locateElement("xpath", "//button[@id='sysverb_insert']"));
		return new Home();
	}
}
