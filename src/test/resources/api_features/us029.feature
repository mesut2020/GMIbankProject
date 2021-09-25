Feature: Validate all data performing database testing using the port and
  following credentials jdbc:postgresql:will be given"
  7- Acilan kisimda host kismina:     157.230.48.97
  8- database kismina:     gmibank_db
  9- user kismina :    techprodb_user
  10- password kismina : "     Techpro_@126

  "jdbc:postgresql://157.230.48.97:5432/gmibank_db" ,
  "techprodb_user" and "Techpro_@126"

  Background:
    Given user connects to GMIBank database by using "jdbc:postgresql://157.230.48.97:5432/gmibank_db", "techprodb_user" and "Techpro_@126"

  Scenario: All user's info should be retrieved by database and validated
    Given user should be reads all users data from database
    And user should be all users data validate

  Scenario: All countries' info should be retrieved by database and validated
    Given user should be reads all countries data from database
    And user should be all countries data validate

  Scenario: All states should related to USA should be retrieved by database and validated
    Given user should be reads all states data of related to USA from database
    And user should be validate the data which all states of related to USA
    Then user should be exit GMIBank database