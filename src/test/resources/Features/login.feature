Feature: Test Login Functionality

  @regression
  Scenario Outline: Check login is successful with valid credentials

    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page
    Examples:
      | username | password |
      | rmendez  | 1234 |