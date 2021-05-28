package week6day2.homework.servicenowpages;

import week6day2.homework.servicenowhooks.ServiceNowHooks;

public class CreateNewChangeRequestPage extends ServiceNowHooks{
	String ChangeRequestNumber;
	public CreateNewChangeRequestPage getChangeRequestNumber() {
		
		ChangeRequestNumber=driver.findElementById("change_request.number").getAttribute("value");
		//Create new change
		System.out.println(ChangeRequestNumber);
		return this;	
	}
	
	public HomePage ClickOnSubmit()
	{
		//Clicking on Submit 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElementById("sysverb_insert").click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		
		return new HomePage();
	}
	
	public String getCRValue()
	{
		return ChangeRequestNumber;
	}
	
}
