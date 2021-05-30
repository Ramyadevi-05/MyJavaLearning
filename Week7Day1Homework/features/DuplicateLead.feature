Feature: Dupliate Lead in Leaftaps 

Background:

Given Type the user_name as 'DemoSalesManager'
And Type the user_password as 'crmsfa'
And Click Login
And Verify Login
And Click CRMSFA link
Then Click on Lead 


Scenario Outline: Duplicate lead in leaf taps using multiple data 

When To click on Find Leads link
And To click on email and enter email as <email>
And To click on find Leads button
And To get and click on first resulting value 
And To click DuplicateLead button
And To click on Create Lead
Then To Verify the duplicateValue updated 

Examples:
|email|
|ramyadevi512@gmail.com|
|test@xyz.com|