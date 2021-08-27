Feature: US_002 System should not allow anyone to register with invalid credentials
  seeing the message "If you want to sign in, you can try the default
  accounts:- Administrator (login="admin" and password="admin")
  - User (login="user" and password="user").

  Background: Given user goes to application landing page
    Given user goes to application landing page

    Scenario: TC_001 Any field on the registration page should not be left blank
      Then user opens registration page
      Then user clicks on register button without filling mandatory areas
      And user verifies error messages for all fields on the registration page


    Scenario Outline: TC_002 SSN number cannot be of any chars nor spec chars except "-"
      Then user opens registration page
      Then user types  "<SSN>" number to SSN box
      And user verifies that invalid format of SSN number leads to error message


      Examples:
        | SSN         |
        | 123*85*8541 |
        | 123!85!8541 |
        | 123?85?8541 |

    Scenario Outline:  TC_003 Mobilephone number cannot be of any chars nor spec chars except "-"
      Then user opens registration page
      Then user types  "<phoneNumber>" number to mobilephone number box
      And user verifies that invalid format of mobilePhone number leads to error message


      Examples:
        | phoneNumber   |
        | 545?854?44?85 |
        | 545*854*44*86 |
        | 545!854!44!87 |

    Scenario Outline:TC_004 Email id cannot be created without "@" sign and "." extensions
      Then user opens registration page
      Then user types  "<email>" info to email box
      And user verifies that invalid format of email leads to error message


      Examples:
        | email        |
        | testmail.com |
        | test@mailcom |
        | testmailcom  |


