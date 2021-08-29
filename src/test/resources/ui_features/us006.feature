@userInfo
Feature:  User info segment (User Settings) should be editable on Homepage
  Background: I navigate to GMI Bank website and sign in as a user
    Given I sign in as a user with the given data

  Scenario: TC_001_There should be user info being populated when navigating to user info firstname, lastname
    email and language
    Then I verify firstname,lastname,email and language boxes are visible


  Scenario: TC_002_There should be 2 languages available "English and Turkish"
    Then I verify English and Turkish language options are available on the page
    And I click on the update button

  Scenario: TC_003_There should be an option to update firstname
    Given I click on first name text box and update the name.
    And I click on the update button
    Then I verify the first name is updated.

  Scenario: TC_004_There should be an option to update lastname
    Then I click on last name text box and update the name.
    And I click on the update button
    Then I verify the last name is updated.

  Scenario: TC_005_There should be an option to update email id adding '@' sign and '.' extension.
    Given I click on email text box and update the email.
    And I click on the update button
    Then I verify the updated email contains @ sign and . extension