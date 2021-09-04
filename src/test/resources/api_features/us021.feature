Feature: System should allow to read all countries info using api end point
  "https://www.gmibank.com/api/tp-countries"

  Background: User creates bearerToken
    Given user creates token via api endpoint "https://gmibank-qa-environment.com/api/authenticate"

  Scenario:  Read all countries you created and validate them from your data set
    Given user gets all country data usign api endpoint "https://www.gmibank.com/api/tp-countries"
    And validates countries from data set