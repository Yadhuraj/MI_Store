Feature: To Check the functionality of the homepage

Scenario: To Access the page and check title
Given The user lands on the expected url
When the title is checked
Then The title is matched
And the landed on expected page
Then close the report

Scenario: Login check
Given Navigate to the Login page
Then Enter username and password 
And validate the Login 
Then close 


Scenario: Search Item
Given Click on Search bar
Then Enter the Products
And close search