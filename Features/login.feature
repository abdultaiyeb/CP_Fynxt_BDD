Feature: Login functionality

  Scenario Outline: Verify user login
    Given the user is on the Sign-In page
    When the user enters the username "<username>" and password "<password>"
    And clicks on the Sign-In button
    Then the user should be redirected to the Dashboard

    Examples: 
      | username   | password  |
      | Abdul12345 | Abdul@123 |
