Feature: System should allow to delete states using api end point
  "https://www.gmibank.com/api/tp-states/1803"

  Background:
    Given user creates token via api endpoint "https://gmibank-qa-environment.com/api/authenticate"

    Scenario: User can delete a state
      When user deletes a state by using api end point "https://www.gmibank.com/api/tp-states"
      Then validates if the state has been deleted