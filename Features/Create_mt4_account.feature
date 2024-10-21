Feature: Create MT4 Account

  Scenario: User creates a new MT4 account successfully
    Given the user is logged in
    When the user navigates to the My Accounts page
    And the user clicks on the Create Account option
    And the user selects "MT4" as the trading platform
    And the user enters a random account name
    And the user selects "USD" as the wallet option
    And the user sets the deposit amount to "1000"
    And the user confirms account creation
    And the user clicks the Create Account button
    Then the user should see the newly created MT4 account number
    And the user dismisses the account creation modal
