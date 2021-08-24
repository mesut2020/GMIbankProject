Feature: US004 Login page should accessible with valid credentials

  Scenario Outline: TC001_There should be a valid username and password validating the success message to login

    Given user go to  "gmibank_url"
    And user click on account menu
    And user click on sign in
    And user enter a valid "<username>" to usernamebox
    And user enter a valid "<password>" to passwordbox
    Then user click on "Sign in" button
    Then user verifies successful login with "<username>"
    Then user closes browser

    Examples:
    |username|password|
    |team54admin|Team54admin.|
    |team54user |Team54user.|
    |team54employee|Team54employee.|
    |team54manager |Team54manager.|
    |team54customer|Team54customer.|


  Scenario Outline: TC002_There should be an option to cancel login

    Given user go to  "gmibank_url"
    And user click on account menu
    And user click on sign in
    And user enter a valid "<username>" to usernamebox
    And user enter a valid "<password>" to passwordbox
    Then user click on Cancel button
    Then user verifies to cancel login
    Then user closes browser

    Examples:
      |username|password|
      |team54admin|Team54admin.|