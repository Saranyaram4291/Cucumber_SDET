@activity_4
Feature: Creating multiple vacancies

@tag1
Scenario Outline:Creating multiple vacancies using data from an Examples table

Given Open the ​OrangeHRM​ page3 and login with credentials provided
When Navigate to the Recruitment page1
Then Click on the Vacancies menu item to navigate to the vacancies page1
Then Click on the Add button to navigate to the Add Job Vacancy form1
Then Fill out the necessary details using data from the Examples tables and click Save "<jobTitle>","<vacancyName>","<hiringManager>","<noOfPositions>","<desc>"
Then Click the Save button to save the vacancy1
Then Verify that the employees have been created
And Verify that all the vacancies have been successfully created
And Close the browser

Examples:
|jobTitle|vacancyName|hiringManager|noOfPositions|desc|
|Android Developer|ram|AfirstName1 AlastName1|1|tcheck|
|Automation Test Engineer|moorthy|AfirstName12 AlastName12|2|test|