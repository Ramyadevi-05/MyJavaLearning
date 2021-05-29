Feature: Login to the Service Now Application

@servicenow
Scenario: Login (Positive)

Given Load URL Service Now 'https://dev103117.service-now.com'
And Type username Service Now as 'admin'
And Type password Service Now as 'India@123'
And Click Login Button Service Now
Then Verify Login is successful Service Now