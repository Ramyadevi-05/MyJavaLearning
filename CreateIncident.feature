Feature: To Create Incident verification by filling the mandatory fields 

@servicenow
Scenario: To Create Incident verification by filling the mandatory fields 

Given Load URL Service Now To Create Incident Mandatory Fields 'https://dev103117.service-now.com'
And Type username Service Now To Create Incident Mandatory Fields  as 'admin'
And Type password Service Now To Create Incident Mandatory Fields  as 'India@123'
And Click Login Button Service Now To Create Incident Mandatory Fields
And Verify Login is successful Service Now To Create Incident Mandatory Fields 
And Search for Incident To Create Incident Mandatory Fields
And Click on CreateNewIncident To Create Incident Mandatory Fields
And Click on Submit To Create Incident Mandatory Fields
Then Created Incident Number