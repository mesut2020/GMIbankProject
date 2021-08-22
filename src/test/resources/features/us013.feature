Feature: US_013 An Employee can create a new Account
  Background:
    Given go to SIGN IN page
    Then hover over to Manage Account
    And click on Create a new Account



  @us13_tc01
  Scenario:US_013 TC_01 User should create a description for the new account and it cannot be blank
    Given Type Balance
    And Select Account Type
    And Select Account Status
    And Click Save Button
    Then should be able to see error text.
    Then go to new page

  @us13_tc02
  Scenario:US_013 TC_02 User should create a description for the new account and it cannot be blank
    Given Type Description
    And Select Account Type
    And Select Account Status
    And Click Save Button
    Then should be able to see error text.
    Then go to new page

  @us13_tc03
  Scenario:US_013 TC_03 User should create a description for the new account and it cannot be blank

    Given Type Description
    And Type Balance
    And Select Account Type
    And Select Account Status
    Then should be able to account type
    Then go to new page

  @us13_tc04
  Scenario:US_013 TC_04 User should create a description for the new account and it cannot be blank

    Given Type Description
    And Type Balance
    And Select Account Type
    And Select Account Status
    Then should be able to status type
    Then go to new page

  @us13_tc05
  Scenario:US_013 TC_05 User should create a description for the new account and it cannot be blank

    Given Type Description
    And Type Balance
    And Select Account Type
    And Select Account Status
    And Select employee
    Then should be able to employee