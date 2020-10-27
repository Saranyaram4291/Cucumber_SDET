@activity_11
Feature: Create a new user
Scenario:Visit the site’s backend and create a new user


Given User opens a browser
When Navigated to url and log in
Then Locate the left hand menu and click the menu item that says Users
Then Locate the Add New button and click it
Then Fill in the necessary details
Then Click the Add New User button
And Verify that the user was created
And Close the browser
