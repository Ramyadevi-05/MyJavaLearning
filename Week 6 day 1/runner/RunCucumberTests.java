package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	dryRun=false,
//	features= {"src/test/java/features/Login.feature"},
//	features= {"src/test/java/features/CreateLead.feature"},	
	features= {"src/test/java/features/EditLead.feature","src/test/java/features/DuplicateLead.feature"},
//	features= {"src/test/java/features/EditLead.feature"},
//features= {"src/test/java/features/DuplicateLead.feature"},		

	glue= {"stepdefs"},
	monochrome=true
)

public class RunCucumberTests extends AbstractTestNGCucumberTests{
	
	
}