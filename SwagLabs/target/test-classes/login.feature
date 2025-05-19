Feature: validate the login functionality
  Scenario: verify the login page
    Given launch the browser
    When enter the valid data
    And click submit button
    Then close the browser