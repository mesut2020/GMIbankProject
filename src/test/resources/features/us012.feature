@wip12
Feature: An Employee can manage Customer
  Background:
The user should navigate to the LinnBank registration page. (http://54.236.40.75/register)
Given User navigate to the LinnBank homepage
And User login as a employee
And Click on myOperations link
And Click on manageCustomers link

  Scenario: All customers should show up on manage customers module
  populating the account information of the customer
  "First Name Last Name Middle Initial Email Mobile Phone Number Phone Number Address Create Date "
    Given the Employee should see the First Name
    And the Employee should see the Last Name
    And the Employee should see the Middle Initial
    And the Employee should see the E-mail
    And the Employee should see the Mobile Phone Number
    And the Employee should see the Phone Number
    And the Employee should see the Address
    Then the Employee should see the Create Date