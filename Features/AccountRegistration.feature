Feature: Account Registration

  Scenario: Verify account registration with valid details
    Given the user is on the Sign-In page
    When the user clicks on the Sign-Up button
    And the user enters a random username
    And the user enters a random first name
    And the user enters a random last name
    And the user enters a random email address
    And the user confirms the entered email address
    And the user enters a random password
    And the user enters a random phone number
    And the user clicks the Sign-Up button
    Then the account should be successfully created
