Feature: System should not allow to make updates with invalid credentials


  Background:
    Given go to sign in page of GMIBank
    When Click on user name and type the Username
    And Click on the Password and type Password
    And Click on the submit button

  Scenario:Email id cannot contain just digits or chars without "@" sign or "." extension
    When Click on Drop Drown menu
    And Click on User Info
    And Click on E-Mailbox, clear and type qwe@gmailcom
    Then User should see the error message "This field is invalid"
    When Click on E-Mailbox, clear and type qwegmail.com
    Then User should see the error message "This field is invalid"

  Scenario: There should not be an option of any other language other than English or Turkish
    When Click on Drop Drown menu
    And Click on User Info
    And Click on the Language Menu
    Then User should see only English and Turkish Language option