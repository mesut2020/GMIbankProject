Feature: System should allow any user to register with valid credentials validating the success message

  Background:Home Page
    Given Ders User on the home page "gmibank_url"
    And Ders User navigates to registration page

  @us001_tc01
  Scenario: US_01_TC_01 System should allow any user to register with valid credentials
  validating the success message

    Then Ders User provides a valid "SSN"
    Then Ders User provides a valid Firstname
    Then Ders User provides a valid Lastname
    Then Ders User provides a valid Address
    Then Ders User provides a valid Mobile Phone Number
    Then Ders User provides a valid Username "Usernamee"
    Then Ders User provides a valid Email
    Then Ders User provides a valid Password "Password"
    Then Ders User provides a valid Password to Password confirmation textbox
    Then User clicks on Register button
    And Ders User validates that he registered succesfully

  @us001_tc02
  Scenario: US_01_TC_01  An invalid SSN number is entered and the error message is observed.
    Given The user leaves the SSN textbox blank as a user
    Then The user as a user displays the error message "Your SSN is invalid"

  @us001_tc03
  Scenario: US_01_TC_03 An invalid SSN number is entered and the error message "Enter a valid ssn" is observed.
    Given As a user, the user enters a number in the SSN textbox without using the "-" character
    Then The user as a user displays the error message "Your SSN is invalid"

  @us001_tc04
  Scenario: US_01_TC_04 Error message should appear when first name box is left empty
    Given The user leaves the Fist Name textbox blank as a user
    Then Kullanici bir user olarak "Your First Name is required" hata uyarisini goruntuler
  @us001_tc05
  Scenario: US_01_TC_05 Error message should appear when last name box is left empty
    Given The user leaves the Last Name textbox blank as a user
    Then The user displays the red "Your lastname required" error message below the last name box as the user.
  @us001_tc06
  Scenario: US_01_TC_06   Error message should appear when address box is left empty
    Given The user leaves the Address textbox blank as a user
    Then The user as a user displays the error message "Your Address is required"
  @us001_tc07
  Scenario: US_01_TC_07  Error message should appear when mobile phone number box is left empty
    Given The user leaves the Mobile Phone Nummer textbox blank as a user
    Then The user as a user displays the error message "Your Mobile Phone Nummer  is required"
  @us001_tc08
  Scenario: US_01_TC_08 As a user, the user enters the mobile phone number without the dash in the Mobile Phone Number textboxgit
    Given As a user, the user enters the mobile phone number "1231231234" without the dash in the Mobile Phone Number textbox
    Then The user as a user displays the error message "Your Mobile Phone Nummer  is required"
  @us001_tc09
  Scenario: US_01_TC_09 Username box error message observed
    Given The user leaves the Username textbox blank as a user
    Then The user as a user displays the error message "Your Username is required"
  @us001_tc10
  Scenario: US_01_TC_10 Email box error message observed
    Given Given The user leaves the Email textbox blank as a user
    Then The user as a user displays the error message "Your Email is required"
  @us001_tc011
  Scenario: US_01_TC_11 Email box error message observed
    Given The user enters an invalid mail in the mailbox
    Then The user as a user displays the error message "Your Email is required"
  @us001_tc012
  Scenario: US_01_TC_12 Password box error message observed
    Given Given The user leaves the Password textbox blank as a user
    Then The user as a user displays the error message "Your Email is required"
  @us001_tc013
  Scenario: US_01_TC_13 New password confirmation  box error message observed
    Given  user types  "<Password>" a valid  Password  to Password box
    And Password is retyped for new password confirmation
    Then The user as a user displays the error message "Your confirmation password is required."