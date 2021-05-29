package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	dryRun=false,
	//features= {"src/test/java/features/ServiceNowLogin.feature"},	
	//features= {"src/test/java/features/CreateIncidentWithNoMandatoryFields.feature"},	
	//features= {"src/test/java/features/CreateIncident.feature"},
	//features= {"src/test/java/features/UpdateExistingIncident.feature"},
	features= {"src/test/java/features/AssignIncident.feature"},
	glue= {"stepdefs"},
	monochrome=true,
	tags="@servicenow"
)

public class RunCucumberServiceNow extends AbstractTestNGCucumberTests{
	
	
}