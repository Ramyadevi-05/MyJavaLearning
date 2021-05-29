Feature: To Update Incident verification by filling the mandatory fields 

@servicenow
Scenario: To Update Incident verification by filling the mandatory fields 

Given Load URL Service Now To Update Incident Mandatory Fields 'https://dev103117.service-now.com'
And Type username Service Now To Update Incident Mandatory Fields  as 'admin'
And Type password Service Now To Update Incident Mandatory Fields  as 'India@123'
And Click Login Button Service Now To Update Incident Mandatory Fields
And Verify Login is successful Service Now To Update Incident Mandatory Fields 
And Search for Incident To Update Incident Mandatory Fields
And Click on CreateNewIncident To Update Incident Mandatory Fields
And Click on Submit To Update Incident Mandatory Fields
Then Created Incident Number to update Incident