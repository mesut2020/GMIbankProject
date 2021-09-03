@getcustomer
Feature: System should allow to read all customers info using api end point
  "https://www.gmibank.com/api/tp-customers"

  Background: User creates bearerToken
    Given user creates token via api endpoint "https://gmibank-qa-environment.com/api/authenticate"

  Scenario: Read all customers you created and validate them from your data set
    Given user gets all customers data usign api endpoint "https://gmibank-qa-environment.com/api/tp-customers?size=3000"
    And validates them from data set

  Scenario: Read all customers you created and validate them 1 by 1
    Given user gets all customers data usign api endpoint "https://gmibank-qa-environment.com/api/tp-customers?size=3000"
    And validates them them 1 by 1