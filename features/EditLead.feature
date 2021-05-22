Feature: Edit Lead in Leaftaps 

Background:

Given To Launch the Chrome Browser for Edit Lead 
When To Load the URL for Edit Lead 'http://leaftaps.com/opentaps'
And Type the uname as 'DemoSalesManager'
And Type the pwd as 'crmsfa'
And Click Login for Edit Lead
And Verify Login for Edit Lead
And Click CRMSFA link for Edit Lead
Then Click on Lead for Edit Lead

Scenario Outline:Edit lead in Leaf taps with multiple data 

When To click on the Find Leads link
And To enter firstname as <FirstName>
And To click on the find leads button 
And Click on first resulting lead
And To get existing company name 
And To click on Edit option 
And To clear existing value and update new Company name as <companyname>
And To click on update button 
Then Verify changed company value 

Examples:
|FirstName|companyname|
|Ramyadevi|Verizon|
|Ramya|VZ|
