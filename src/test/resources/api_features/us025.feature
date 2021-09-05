@createCountry

  Feature: System should allow to create new countries using api end point
    "https://www.gmibank.com/api/tp-countries" if not created already

    Scenario: User can create a country
    Given User creates a country using "https://www.gmibank.com/api/tp-countries"
    Then validates the country