@US_11
Feature: US_11 tests

  Background: user enters gmibank homepage then reaches sign in link and clicks user info
    Given user enters gmibank homepage
    And user clicks userEntry icon
    And user clicks signIn link
    Then user enters admin username "USER1"
    Then user enters admin password "User123_"
    Then user clicks signIn button
    And user clicks myOperations link
    And user clicks manageCostomers link
    And user clicks createNewCustomer link

  @TC_1101
  Scenario Outline: Create Date negative test (for in the past)
    Given user send data to date box "<Create Date>"
    Then user verifies valid data entry to Create Date box

    Examples: Test Dates
      | Create Date      |
      | 12.12.2015 12:00 |
      #| 01.20.2020 11:15 |


  @TC_1102
  Scenario Outline: TC_1102 Date format negative test
    Given user send invalid data format to date box "<Create Date Invalid>"
    Then user verifies invalid data entry to Create Date box

    Examples: Test Dates
      | Create Date Invalid |
    #  | 01.12.2020          |
     # | 01.20.2021 11       |
      | 11.2021 09:30       |

  @TC_1103
  Scenario Outline: TC_1103 Date format pozitive test
    Given user send valid data format to date box "<Create Date Valid>"
    Then user verifies valid date format to Create Date box

    Examples: Test Dates
      | Create Date Valid |
   #   | 12.30.2020 12:00  |
      | 01.21.2021 11:15  |

  @TC_1104
  Scenario: User positive test
    Given user select a user from dropbox
    Then user verifies a user can be selected


  @TC_1105
  Scenario: Account positive test
    Given user select an account from dropbox
    Then user verifies an account can be selected


  @TC_1106
  Scenario: Zelle Enrolled option checkbox pozitive test
    Given user select Zelle Enrolled checkbox
    Then user clicks on save button
    Then user verifies is selected

