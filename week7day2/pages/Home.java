package pages;

import hooks.TestNgHooks;

public class Home extends TestNgHooks{
	CreateIncident c = new CreateIncident();
	String incidentNumber = c.incNumber;
	public Home clickOnFilter()	
	{
		click(locateElement("id", "filter"));
		return this;
	}
	
	public Home toSearchForIncident()
	{
		clearAndType(locateElement("id", "filter"), "Incident");
		toPressEnterKeys(locateElement("id", "filter"));
		return this;
	}

	public Home toSearchForChange()
	{	
		clearAndType(locateElement("id", "filter"), "Change");
		toPressEnterKeys(locateElement("id", "filter"));
		return this;
	}
	
	public CreateIncident toClickOnCreateNew()
	
	{
		click(locateElement("xpath", "//a[@href=\"incident.do?sys_id=-1&sysparm_query=active=true&sysparm_stack=incident_list.do?sysparm_query=active=true\"]"));
		return new CreateIncident();
	}

	public ViewIncident toClickOpen()
	{
		click(locateElement("xpath", "(//div[text()='Open'])[1]"));
		return new ViewIncident();
	}
	
	public UpdateIncident openIncident()

	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		click(locateElement("xpath", "//select[@class='form-control default-focus-outline']"));
		selectDropDownUsingText(locateElement("xpath", "//select[@class='form-control default-focus-outline']"),
				"Number");
		click(locateElement("xpath", "//input[@placeholder='Search' and @class='form-control']"));
		clearAndType(locateElement("xpath", "//input[@placeholder='Search' and @class='form-control']"),
				incidentNumber);
		toPressEnterKeys(locateElement("xpath", "//input[@placeholder='Search' and @class='form-control']"));
		String incNumberfromSearch = getTypedText(locateElement("xpath", "//a[@class='linked formlink']"));
		verifyExactTextValue(incidentNumber, incNumberfromSearch);
		return new UpdateIncident();
	}

	}


