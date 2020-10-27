@activity_3
Feature:Posting a job using parameterization

Scenario:Post a job using details passed from the Feature file

Given user opens browser with alchemy site
When Go to Post a Job page
Then Read job information from the Feature file table and fill in the details "test","testScript","test2","Full Time","test4","saranya@ram.com"
Then Click submit
Then Go to the Jobs page
And Confirm job listing is shown on page
And Generate HTML report
