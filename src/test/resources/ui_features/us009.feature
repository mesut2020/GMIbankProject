@employee
@regressionTest @smokeTest
Feature:  Existing customer's data should be able to be listed by an employee
  Background: I sign in as an employee
    Given I sign in as an employee with the given data

  Scenario Outline: Employee can search for a new applicant by their SSN and see all their registration info populated email and language"
    And I click on My Operations button located on the top navigation bar
    Then I hover over to Manage Customers
    And I click on Create a new Customer button
    And I type given "<SSN>" into SSN box and click Search button
    Then I should be able to list customer's all data.
    Examples:
      | SSN  |
      | SSN1 |
      | SSN2 |



  Scenario:User in employee role identifies created bank accounts to customer
    And I click on My Operations button located on the top navigation bar
    Then I hover over to Manage Customers
    And I click on Create a new Customer button
    And I type given "SSN" into SSN box and click Search button
    And user fills required areas
