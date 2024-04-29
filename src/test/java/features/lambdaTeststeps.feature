Feature: LambdaTest Scenario
@Lambda-01
  Scenario: Verify LambdaTest website functionality
    Given User is on LambdaTest website homepage
    When User waits for all elements to be available
    And User scrolls to SEE ALL INTEGRATIONS link
    And User clicks on SEE ALL INTEGRATIONS link and verifies URL
    And User scrolls to Codeless Automation
    And User clicks on LEARN MORE for Testing Whiz and verifies page title
    Then User closes the current window
    And  User sets the URL
    And User clicks on Community link and verifies URL
    Then User closes the current browser window

