Feature: US_019 System should allow Admin to create a new Account

  Background: user anters gmibank homepage then reaches create new costomers link
    Given Ders User on the home page "gmibank_url"
    Then user clicks userEntry icon
    Then user clicks signIn link
    Then user enters admin username "bankprojectmanager"
    Then user enters admin password "Bankprojectmanager."
    Then user clicks signIn button
    And user clicks myOperations link
    And user clicks manageAccounts link
    And user clicks createNewAccount link

  @US019_TC01
  Scenario: Create new Acoount
    Given An investment type or name is entered in the "Description" box.
    And     Enter an amount in the "Balance" box
    And     click the save button
    Then    admin sees required message


@US019_TC02
  Scenario:  Description box error message
    Given click the Description box
    And Description box is left blank
    And press Enter key
    Then Error message under Description box is observed
  @US019_TC03
  Scenario: Balance box error message
    Given click the Balance box
    And Balance box is left blank
    And  press Enter  keyy
    Then Error message under Balance box is observed
  @US019_TC04
  Scenario:  can select an account type as CHECKING, SAVING, CREDIT_CARD or INVESTING
    Given   admin select an account as CHECKING and verify
    And     admin select an account as a SAVING and verify
    And     admin select an account as a CREDIT_CARD and verify
    And     admin select an account as a INVESTING and verify

  @US019_TC05
  Scenario: should account status defined as ACTIVE, SUESPENDED or CLOSED
    Given   admin click Account Status Type defined as a ACTIVE and verify
    And     admin click Account Status Type defined as a  SUESPENDED and verify
    And     admin click Account Status Type defined as a  CLOSED and verify

  @US019_TC06
  Scenario: can select an employee from the drop-down
    Given   admin select Employee and verify the selectet Employee
    And     admin signOut
