Feature: Login for LeafTaps 

Scenario Outline: Login Positive tests

Given Type username is entered as <username>
And Type password is entered as <password>
And Click Login
And Verify the welcome message 
Then Click Logout 

Examples:
|username|password|
|DemoSalesManager|crmsfa|