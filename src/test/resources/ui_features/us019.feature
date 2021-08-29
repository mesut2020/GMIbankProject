Feature: US_019 System should allow Admin to create a new Account

  Background: user anters gmibank homepage then reaches create new costomers link
    Given Ders User on the home page "gmibank_url"
    Then user clicks userEntry iconn
    Then user clicks signIn linkk
    Then user enters admin usernamee "manager_username"
    Then user enters admin passwordd "manager_password"
    Then user clicks signIn buttonn
    And user clicks myOperations linkk
    And user clicks manageAccounts linkk
    And user clicks createNewAccount linkk

  @US019_TC01
  Scenario: Create new Acoount
    Given An investment type or name is entered in the "Description" box.
    Then    Enter an amount in the "Balance" box
    Then    click the save button
    Then    admin sees required message
    Then     click the Bank Projeckt button
    And     click the  signOut button


@US019_TC02
  Scenario:  Description box error message
    Given click the Description box
    Then Description box is left blank
    Then press Enter key
    Then Error message under Description box is observed
    Then     click the Bank Projeckt button
    And     click the  signOut button
  @US019_TC03
  Scenario: Balance box error message
    Given click the Balance box
    Then Balance box is left blank
    Then  press Enter  keyy
    Then Error message under Balance box is observed
    Then     click the Bank Projeckt button
    And     click the  signOut button
  @US019_TC04
  Scenario:  can select an account type as CHECKING, SAVING, CREDIT_CARD or INVESTING
    Given   admin select an account as CHECKING and verify
    Then     admin select an account as a SAVING and verify
    Then     admin select an account as a CREDIT_CARD and verify
    Then     admin select an account as a INVESTING and verify
    Then     click the Bank Projeckt button
    And     click the  signOut button

  @US019_TC05
  Scenario: should account status defined as ACTIVE, SUESPENDED or CLOSED
    Given   admin click Account Status Type defined as a ACTIVE and verify
    Then     admin click Account Status Type defined as a  SUESPENDED and verify
    Then     admin click Account Status Type defined as a  CLOSED and verify
    Then     click the Bank Projeckt button
    And     click the  signOut button

  @US019_TC06
  Scenario: can select an employee from the drop-down
    Given   admin select Employee and verify the selectet Employee
    And     admin signOut
