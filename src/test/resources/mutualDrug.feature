@tag
Feature: To check the functionality of Mutual Drug application

  Background: To validate the signIn functionality
    Given user opens google chrome and enters mutual drug application url
    When user enters valid username and password
    Then user should be navigated to apllication homepage

  @tag2
  Scenario: To validate the details page
    Given user goes to member application and clicks on member dropdown
    Then user clicks on details

  @tag3
  Scenario: To validate the account page
    Given user is in mutual drug homepage
    When user goes to logIn and clicks on account
    Then account page should be shown
    Then user should able to enter FirstName
    Then user should able to enter LastName
    When user try to enter email it should not be allowed
    And user should able to enter old password new password confirm new password fields
		And the old password is mismatched then it should not allow to change new password
		Then to check whether the updated fields are displayed properly