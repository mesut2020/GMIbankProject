@wip
Feature:US_014 Date should be created on the time of account creation

  Rule: User reachs to Create a New Account Page
  Background: Given user goes to application landing page and logs in with employee_account and lands on Create New Account Page
    Given user goes to application landing page
    And user login with "employee" account
    And user clicks on My Operations
    And user clicks on Manage Accounts
    And clicks on +Create a new Account

    Scenario: TC_001-1 The date cannot be typed earlier, in the past, at the time of creation an account
      And clicks on the Create Datetextbox and type the "account_creation_date"
      And clicks on the Closed Datetextbox and type the "account_closed_date" later than the time of account creation
      Then Verify that Create Date and Closed Date created successfully


    Scenario: TC_001-2 The date cannot be typed earlier, in the past, at the time of creation an account
      And clicks on the Create Datetextbox and type the "account_creation_date"
      And clicks on the Closed Datetextbox and type the "account_closed_date_before" before than the time of account creation
      Then Verify that Create Date and Closed Date not created successfully

    Scenario: TC_002-1 The date should be created as month, day, year, hour and minute
      And clicks on the Create Date textbox and type date as month,day,year,hour and minute "18.08.2021 16:00"
      Then Then Verify that the date created succesfully


    Scenario: TC_002-2 The date should be created as month, day, year, hour and minute
      And clicks on the Create Date textbox and type date as month,day,year "18.08.2021"
      Then Verify that the date not created succesfully



  Rule: User reachs to Create a New Customer Page
  Background: Given user goes to application landing page and logs in with employee_account and lands on Create New Customer Page
    Given user goes to application landing page
    And user login with "employee" account
    And user clicks on My Operations
    And user clicks on Manage Customers
    And clicks on +Create a new Customer

    Scenario:TC_003 User can choose a user from the registration and it cannot be blank
      And enters a valid SSN "654-96-7412" and clicks on Search button
      Then verifies user information is displayed


    Scenario Outline:TC_004 User can select Zelle Enrolled optionally and save it
      And user selects Zelle Enrolled option checkbox "<checkbox>"
      And user clicks on Save button
      Then user verifies no error message displayed since this section is optional


      Examples:
        | checkbox |
        | true     |
        | false    |

  Rule: User reachs to Manage Account Main Page
    Background: Given user goes to application landing page and logs in with employee_account and lands on Manage Accounts Page
      Given user goes to application landing page
      And user login with "employee" account
      And user clicks on My Operations
      And user clicks on Manage Accounts

    Scenario:TC_004 There user can choose an account created on manage accounts
      And clicks on an ID item to choose an account created on manage accounts
      Then verifies selected account is displayed

