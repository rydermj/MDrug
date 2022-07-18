@tag
Feature: To check the functionality of Mutual Drug application

@tag1
Scenario: To validate the signIn functionality 
Given user opens google chrome and enters mutual drug application url
When user enters valid username and password
Then user should be navigated to apllication homepage

@tag2
Scenario: To validate the details page
Given user goes to member application and clicks on member dropdown
Then user clicks on details