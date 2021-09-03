@getCountry
Feature: System should allow to read all countries info using api end point
  https://www.gmibank.com/api/tp-countries

  Scenario: User creates bearerToken
    Given user creates token via api endpoint "https://gmibank.com/api/authenticate"

  Scenario: Read all countries you created and validate them from your data set
    Given user gets all countries data using api endpoint "https://www.gmibank.com/api/tp-countries"
    And validates the country from data set