@activity_1
Feature: Creating a job vacancy
Scenario:To create a job vacancy for DevOps Engineer

Given Open the ​OrangeHRM​ page and login with credentials provided
When  Navigate to the Recruitment page
Then  Click on the Vacancies menu item to navigate to the vacancies page
Then  Click on the Add button to navigate to the Add Job Vacancy form
Then Fill out the necessary details
Then Click the Save button to save the vacancy
And Verify that the vacancy was created
And Close the browser