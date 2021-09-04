@createState
  Feature: System should allow to create new states using api end point
    "https://www.gmibank.com/api/tp-states" if not created already

  Scenario: Create new state
  Given User creates a state using api endpoint "https://www.gmibank.com/api/tp-states"
    Then User verifies if the state has been created

