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
   Given User select First Name, Last Name, Middle Initial, Email, Mobile Phone Number,Phone Number, Address, Date updated"
    Then Checked all customer information was filled
    And User should close the DRIVER


  Scenario: There should be a View option where customer can be navigated to all customer info and see
  edit button there"
    Given Employee should see and click on the view
    Then Employee should see and click Edit button
    And User should close the DRIVER

  Scenario: There should be an Edit button where all customer information can be populated
    And Employee should click on the View button for any customer
    And Employee should click on the Edit button
    Then Employee should check all customer information can be populated


  Scenario: The Edit portal can allow user to create or update the user info
    Given Employee should see and click Edit button for any customer
    Given Employee should write a new  Email address
    And Employee should click Save button
    Then Employee should verifies translation not found[gmiBankBackendApp.tPCustomer.updated
    And User should close the DRIVER

  Scenario: User can delete a customer, but seeing a message if the user is sure about deletion
    Given Employee should see and click Delete button
    And Employee should verifies  message
    Then Employee should delete a customer
    And User should close the DRIVER

