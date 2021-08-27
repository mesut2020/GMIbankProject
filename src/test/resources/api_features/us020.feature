@getcustomer
Feature: System should allow to read all customers info using api end point
  "https://www.gmibank.com/api/tp-customers"

  Scenario: User creates bearerToken
    Given user creates token via api endpoint "https://gmibank.com/api/authenticate"

  Scenario: Read all customers you created and validate them from your data set
    Given user gets all customers data usign api endpoint "https://www.gmibank.com/api/tp-customers?3000"
    And validates them from data set