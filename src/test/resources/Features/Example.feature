Feature: feature to test google search functionality

  @smoke
  Scenario: Validate google search is working

    Given browser is open
    And user is on google search page
    When user enters a text in search box
    And hits enter
    Then user is navigate to search results