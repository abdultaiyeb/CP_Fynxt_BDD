Feature: Transfer Funds

  Scenario: Successful transfer of funds between wallets
    Given the user is logged in
    When the user navigates to the My Wallet page
    And the user clicks on the Transfer Funds option
    And the user selects "Wallet (USD)" as the source wallet
    And the user selects "1245983689 (dvdfv)" as the destination wallet
    And the user enters "1000" as the transfer amount
    And the user clicks on the confirm transfer button
    Then the user should see a success message "Fund transfer successful."
