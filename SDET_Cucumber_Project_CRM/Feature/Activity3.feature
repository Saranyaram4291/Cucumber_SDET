@activity_3
Feature:Schedule a meeting and invite members
Scenario Outline:To schedule a meeting and include at least 3 invitees

Given Open the browser to the ​Alchemy CRM2 site and login
When  Navigate to Activities -> Meetings -> Schedule a Meeting
Then  Enter the details of the meeting
Then Search for members and add them to the meeting "<fname>","<lname>","<email>"
Then Click Save
And Navigate to View Meetings page and confirm creation of the meeting
And Close the browser
Examples:
|fname|lname|email|
|sara|ram||