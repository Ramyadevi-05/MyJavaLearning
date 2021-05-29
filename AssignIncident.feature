Feature: To Assign Incident verification by filling the mandatory fields 

@servicenow
Scenario: To Assign Incident verification by filling the mandatory fields 

Given Load URL Service Now To Assign Incident Mandatory Fields 'https://dev103117.service-now.com'
And Type username Service Now To Assign Incident as 'admin'
And Type password Service Now To Assign Incident as 'India@123'
And Click Login Button Service Now To Assign Incident Mandatory Fields
And Verify Login is successful Service Now To Assign Incident Mandatory Fields 
And Search for Incident To Assign Incident Mandatory Fields
And Click on CreateNewIncident To Assign Incident Mandatory Fields
And Click on Submit To Assign Incident Mandatory Fields
And Created Incident Number to Assign Incident
Then Assign the Created Incident Number 
