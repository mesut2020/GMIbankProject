Feature: Database Testing
  Background: set the connection with the DB
    Given user creates a connection with DB using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"

    Scenario Outline: Test all customer info based on DB
      Given user provides "<query>" and "<id>"
      And user saves DB Customer info into correspondent  files
      Then user validates all customer DB info

      Examples: All customer DB date
        | query                       | columnName |
        | SELECT  * from tp_customer; | id         |