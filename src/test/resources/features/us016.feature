Feature: Money transfer should be available

  Background:
    Given go to sign in page of GMIBank
    When Click on user name and type the Username
    And Click on the Password and type Password
    And Click on the submit button
    When Click on My Operations menu

  Scenario: User should have at least 2 accounts

    And Click on My Account
    Then User should be able to see at least 2 Account

  Scenario: User makes transfer between accounts and should see the succesfully message.

    And Click on Transfer Money
    And Select first account as From dropdown
    And Select first account as To dropdown
    And Click on the Balance and type "10" Euro "50" Cent
    And Provide a description as "Transfer"
    And Click on Make Transfer button
    Then User sees the successfully message as "Transfer is succesfull"
