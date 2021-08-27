Feature: US_005 Login page should not be accessible with invalid credentials

  Background:
    Given US05 go to SIGN IN page

  Scenario: US_005 TC_01 User cannot login with invalid username validating the error message
    When US05 click on username textbox and type "team54"
    And US05 click on password textbox and type "Team54customer."
    And US05 click on the sign in button
    But US05 user should not be able to login and see an Error message as "Failed to sign in!"

  Scenario: US_005 TC_02 User cannot login with invalid password validating the error message
    When US05 click on username textbox and type "team54customer"
    And US05 click on password textbox and type "Team54"
    And US05 click on the sign in button
    But US05 user should not be able to login and see an Error message as "Failed to sign in!"

  Scenario: US_005 TC_03 User cannot login with invalid username and password validating the error message
    When US05 click on username textbox and type "team54"
    And US05 click on password textbox and type "Team54"
    And US05 click on the sign in button
    But US05 user should not be able to login and see an Error message as "Failed to sign in!"

  Scenario: US_005 TC_04 User with invalid credentials should be given an option to reset their password
    When US05 check the link to reset a password
    And US05 click on the link to go to reset password page
    Then US05 User should see the page "Reset your password"

  Scenario: US_005 TC_05 User should be given the option to navigate to registration page if they did not register yet
    When US05 check the link to register a new account
    And US05 click on the link to go to register page
    Then US05 User should see the page "Registration"