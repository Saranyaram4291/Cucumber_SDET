@activity_4
Feature:Creating a Product
Scenario Outline:To use an Examples table to add products

Given Open the browser to the ​Alchemy CRM3 site and login
When Navigate to All -> Products-> Create Product
Then enter the details of the product "<productName>","<price>","<partNo>"
Then Click Save1
And Go to the “View Products” page to see all products listed
And Close the browser
Examples:
|productName|price|partNo|
|erererr|1212|dfeaerr|
|e1212121|12|ewewew|