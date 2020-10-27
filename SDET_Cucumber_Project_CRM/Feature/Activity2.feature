@activity_2
Feature:Create leads using parameterization
Scenario:Open the Leads page and add multiple lead accounts using values passed from  Feature file

Given Open the browser to the ​Alchemy CRM1​ site and login
When   Navigate to Sales -> Leads -> Create Lead
Then  Fill in the necessary details to create lead accounts using the values passed from  the Feature file "saranya","ram","909000"
Then Click Save to finish
And Navigate to the View Leads page to see results
And Close the browser