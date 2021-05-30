Feature: Create a new Lead in Leaftaps

Background:
Given Type username as 'DemoSalesManager'
And Type password as 'crmsfa'
And Click Login Button
Then Verify Login is successful
And Click CRM SFA Link
Then Click Leads Tab

Scenario Outline: Create a new Lead with mandatory fields

When Click Find Lead Menu
And Type Company Name as <companyName>
And Type First Name as <firstName>
And Type Last Name as <lastName>
And Click Create Lead Button
Then Verify the lead is created

Examples:
|companyName|firstName|lastName|
|Verizon|Ramya|devi|
|VZ|Ramyadevi|AL|