Feature: System should allow to update countries using api end point
  "https://www.gmibank.com/api/tp-countries"

  Background:
    Given user creates token via api endpoint "https://gmibank-qa-environment.com/api/authenticate"

    Scenario: User can update a country
      When user updates a country by using api end point "https://www.gmibank.com/api/tp-countries"
      Then validates if the country has been updated