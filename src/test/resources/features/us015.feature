Feature: US_015 System should allow user to manage their account

  Background:
    Given US15 login to GMIBank as a Customer
    And US15 click on My Operations dropdown
    And US15 choose My Account from dropdown menu

  Scenario: US_015 TC_01 User should see all account types and balance populated
    Then US15 user should see the account types and balance

  Scenario: US_015 TC_02 User can view transaction
    When US15 click on View Transaction button
    Then US15 user should see the transactions