Feature: DEMO MEETING

  # The customer registers on the site.
  # Admin should accept the customer registration.
  # Employee creates at least two Account for customer.
  # Employee adds these accounts to customer.
  # Customer logins to system.
  # Customer makes money Transfer between accounts.

  @demo
  Scenario: TEAM54
    * user on the home page "gmibank_url"
    * user navigates to registration page
    * a little wait
    * user provides a valid "SSN"
    * user provides a valid Firstname
    * user provides a valid Lastname
    * user provides a valid Address
    * user provides a valid Mobile Phone Number
    * user provides a valid Username "Usernamee"
    * user provides a valid Email
    * user provides a valid Password "Password"
    * user provides a valid Password to Password confirmation textbox
    * User clicks on Register button
    * a little wait
    * user click on account menu
    * user click on sign in
    * user enter a valid "team54admin" to usernamebox
    * user enter a valid "Team54admin." to passwordbox
    * user click on "Sign in" button
    * a little wait
    * user click on Administration > User Mangement  on Header
    * a little wait
    * user clicks on createDate sort sorting button
    * a little wait
    * user finds customer "Usernamee" and activates user
    * a little wait
    * user signOut
    * user login with "employee" account
    * a little wait
    * employee creates 2 brand new accounts
    * a little wait
    * I click on My Operations button located on the top navigation bar
    * I hover over to Manage Customers
    * I click on Create a new Customer button
    * I type given "SSN" into SSN box and click Search button
    * a little wait
    * user fills required areas
    * a little wait
    * user signOut
    * user login with "demo" account
    * a little wait
    * Click on My Operations menu
    * Click on Transfer Money
    * Select first account as From dropdown
    * Select first account as To dropdown
    * Click on the Balance and type "10" Euro "50" Cent
    * Provide a description as "Transfer"
    * a little wait
    * Click on Make Transfer button
    * a little wait
    * User sees the successfully message as "Transfer is succesfull"
    * a little wait
    * closes browser












