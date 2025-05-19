Feature: validate the login functionality
  Scenario: Valid login
    Given user is on the login page
    When user enters valid credentials
    Then user is redirected to the dashboard