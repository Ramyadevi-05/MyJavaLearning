Feature: Create Incident verification without filling the mandatory fields 

@servicenow
Scenario: Create Incident validation when no mandatory fields entered(Positive)

Given Load URL Service Now To Create Incident 'https://dev103117.service-now.com'
And Type username Service Now To Create Incident as 'admin'
And Type password Service Now To Create Incident as 'India@123'
And Click Login Button Service Now To Create Incident
And Verify Login is successful Service Now To Create Incident
And Search for Incident To Create Incident
And Click on CreateNewIncident To Create Incident 
And Click on Submit To Create Incident
Then VerifyMandatoryFieldsValidation To Create Incident
