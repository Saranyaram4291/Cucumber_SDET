@activity_4
Feature:Posting a job using parameterization

Scenario Outline:Post a job using details passed from the Feature file

Given user opens browser with alchemy site
When Go to Post a Job page
Then Read job information from the Feature file table and fill in the details "<email>","<jobTitle>","<jobLocation>","<jobType>","<description>","<application>"
Then Click submit
Then Go to the Jobs page
And Confirm job listing is shown on page
And Generate HTML report

Examples:
|email|jobTitle|jobLocation|jobType|description|application|
|test@at.com|testing1|testLocation1|Full Time|check1|test1|
|sere@at.com|testing2|testLocation2|Part Time|check2|test2|