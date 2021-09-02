Feature: US017 System should allow the Admin to manage users

  Scenario Outline: US017_TC_for_"<role>" Admin can activate a role as "<role>"

    Given user go to  "gmibank_url"
    And user click on account menu
    And user click on sign in
    And user enter a valid "<username>" to usernamebox
    And user enter a valid "<password>" to passwordbox
    Then user click on "Sign in" button
    And user click on Administration > User Mangement  on Header
    And user click on Create a new user button on Management page
    And user fill in Login, First name, Last name and email fields
    And user select "<role>" on profiles section
    Then user click on Save button
    Then user verifies Success message
    Then user closes browser




      Examples:
      |username|password|role|
      |team54admin|Team54admin.|ROLE_USER|
      |team54admin|Team54admin.|ROLE_EMPLOYEE|
      |team54admin|Team54admin.|ROLE_MANAGER|
      |team54admin|Team54admin.|ROLE_ADMIN|


  Scenario Outline: Admin can activate customer's account

    Given user go to  "gmibank_url"
    And user click on account menu
    And user click on sign in
    And user enter a valid "<username>" to usernamebox
    And user enter a valid "<password>" to passwordbox
    Then user click on "Sign in" button
    And user click on Administration > User Mangement  on Header
    And user clicks on createDate sort sorting button
    And user finds customer "Usernamee" and activates user



    Examples:
      | username    | password     |
      | team54admin | Team54admin. |



