@activity_3
Feature: Add multiple employees
Scenario Outline:Creating multiple vacancies using data from an Examples table

Given Open the ​OrangeHRM​ page2 and login with credentials provided
When  Find the PIM option in the menu and click it
Then  Click the Add button to add a new Employee
Then  Make sure the Create Login Details checkbox is checked
Then Fill in the required fields using the data from the Examples table and click Save "<fname>","<lname>","<uname>"
And Verify that the employees have been created
And Close the browser

Examples:
|fname|lname|uname|
|saranya|ram|saranyaram|
|ram|moorthy|ramamoorthy|