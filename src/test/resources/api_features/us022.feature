@getStates
Feature: System should allow to read states using api end point
  "https://www.gmibank.com/api/tp-states"

  Scenario: User creates bearerToken
    Given user creates token via api endpoint "https://gmibank.com/api/authenticate"

  Scenario: Read all states you created and validate them from your data set
    Given user gets all states data using api endpoint "https://gmibank-qa-environment.com/api/tp-states"
    And validates the state from data set