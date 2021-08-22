Feature: US_010 Address of customer can be created
  Background:
    Given go to SIGN IN page
    And click on My Operations button located on the top navigation bar
    Then hover over to Manage Customers
    And click on Create a new Customer button
    And Type SSN number
    And Type first name
    And Type lastname
    And Type middle-initial
    And Type email address
    And Type mobile-phone-number
    And Type phone number
    And Type zip-code
    And Type SSNn number

@us10_tc01
  Scenario:US_010 TC_01 Address as street and number should be provided and cannot be left blank

    And Type city
    And Select country
    And Type state
    And click savebutton
    Then should be able to see error text.
    Then go to new page
  @us10_tc02
  Scenario:US_010 TC_02 City should be provided and cannot be left as blank

    And Type address
    And Select country
    And Type state
    And click savebutton
    Then should be able to see city error text.
    Then go to new page
  @us10_tc03
  Scenario:US_010 TC_03 Country should be typed and cannot be blank

    And Type address
    And Type city
    And Type state
    And click savebutton
    Then should be able to see country error text.
    Then go to new page
  @us10_tc04
  Scenario:US_010 TC_04 State should be provided as US state and cannot be blank

    And Type address
    And Type city
    And Select country
    And click savebutton
    Then should be able to see state error text.
