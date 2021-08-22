Feature: System should allow any user to register with valid credentials
  validating the success message

  @us001_tc01
  Scenario: System should allow any user to register with valid credentials
  validating the success message
    Given Ders User on the home page "qa_environment_url"
    And Ders User navigates to registration page
    Then Ders User provides a valid SSN
    Then Ders User provides a valid Firstname
    Then Ders User provides a valid Lastname
    Then Ders User provides a valid Address
    Then Ders User provides a valid Mobile Phone Number
    Then Ders User provides a valid Username
    Then Ders User provides a valid Email
    Then Ders User provides a valid Password
    Then Ders User provides a valid Password to Password confirmation textbox
    Then User clicks on Register button
    And Ders User validates that he registered succesfully

  @us001_tc02
  Scenario : TC_0102 gecersiz SSN test
    Given The user leaves the SSN textbox blank as a user
    Then The user as a user displays the error message "Your SSN is invalid"


  @us001_tc03
  Scenario Outline: TC_0102 gecersiz SSN test
    Given As a user, the user enters a number in the SSN textbox without using the "-" character
    Then The user as a user displays the error message "Your SSN is invalid"
    Examples: TC_0102 SSN numaralari
      |SSN|
      |333-22-44445   |
      |333-22-443    |
  @us001_tc04
  Scenario: TC_0104 bos first name negative test
    Given The user leaves the Fist Name textbox blank as a user
    Then Kullanici bir user olarak "Your First Name is required" hata uyarisini goruntuler


  @us001_tc05
  Scenario: TC_0106 bos last name negative test
    Given The user leaves the Last Name textbox blank as a user
    Then The user as a user displays the error message "Your Last Name is required"


  @us001_tc06
  Scenario: TC_0107  negatif address test
    Given The user leaves the Address textbox blank as a user
    Then The user as a user displays the error message "Your Address is required"


  @us001_tc07
  Scenario: TC_0109 negatif mobile phone number negative test
    Given The user leaves the Mobile Phone Nummer textbox blank as a user
    Then The user as a user displays the error message "Your Mobile Phone Nummer  is required"

  @us001_tc08
  Scenario: TC_0109 gecersiz mobile phone number negative test
    Given As a user, the user enters the mobile phone number "1231231234" without the dash in the Mobile Phone Number textbox
    Then The user as a user displays the error message "Your Mobile Phone Nummer  is required"

  @us001_tc09
  Scenario: TC_0111 negatif kullanici adi test
    Given Given The user leaves the Username textbox blank as a user
    Then The user as a user displays the error message "Your Username is required"


  @us001_tc10
    Given Given The user leaves the Email textbox blank as a user
    Then The user as a user displays the error message "Your Email is required"


  @us001_tc011
    Given The user enters an invalid mail in the mailbox
    Then The user as a user displays the error message "Your Email is required"
  @us001_tc012
    Given Given The user leaves the Password textbox blank as a user
    Then The user as a user displays the error message "Your Email is required"


  @us001_tc013
    Given  user types  "<Password>" a valid  Password  to Password box
    And Password is retyped for new password confirmation
    Then The user as a user displays the error message "?????"