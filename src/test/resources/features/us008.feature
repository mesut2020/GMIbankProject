@US_08
Feature: US_08 Password segment on Homepage should be editable

  Background: us08 user enters gmibank homepage then reaches password menu link
    Given  user enters gmibank homepage
    Then  user clicks userEntry icon
    Then  user clicks signIn link
    Then  user enters admin username "USER1"
    Then  user enters admin password "User123_"
    Then  user clicks signIn button
    Then user clicks password link


  @TC_0801
  Scenario: The old password should not be used
    When user clicks password link and old password for three textbox "User123_"
    Then user doesn't save
    Then user signout



  @TC_0802
  Scenario: There should be at least 1 uppercase char for stronger password
    Given  user clicks password link and writes one random uppercase
    Then user writes six lower cases and sees the change of password scales
    Then user writes six digits and sees the change of password scales
    Then user writes six special chars and sees the change of password scales


  @TC_0803
  Scenario: There should be at least 1 lowercase char for stronger password
    Given user clicks password link and writes one random lowercase
    Then user writes six digits and sees the change of password scales
    Then user writes six upper cases and sees the change of password scales
    Then user writes  six special chars and sees the change of password scales


  @TC_0804
  Scenario: There should be at least 1 digit char for stronger password
    Given testcasefour user clicks password link and writes one random digit
    Then testcasefour user writes six upper cases and sees the change of password scales
    Then testcasefour user writes six special chars and sees the change of password scales
    Then testcasefour user writes six lower cases and sees the change of password scales


  @TC_0805
  Scenario: There should be at least 1 special char for stronger password
    Given testcasefive user clicks password link and user writes one random special character
    Then testcasefive user writes six lower cases and sees the change of password scales
    Then testcasefive user writes six upper cases and sees the change of password scales
    Then testcasefive user writes six digits and sees the change of password scales


  @TC_0806
  Scenario: There should be at least 7 chars for a stronger password
    Given user clicks password link and writes one random uppercase, lowercase, digit and special char
    And user writes two lower cases and doesn't see the change of password scales
    And user write one more lower cases and sees to changing
    And user writes two upper cases and doesn't see the change of password scales
    And user write one more upper cases and sees to changing
    And user writes two digits and doesn't see the change of password scales
    And user write one more digits and sees to changing
    And user writes two special chars and doesn't see the change of password scales
    Then user write one more special chars and sees to changing


  @TC_0807
  Scenario: The new password should be confirmed
    Given user clicks password link and writes random password
    Then user saves new password

