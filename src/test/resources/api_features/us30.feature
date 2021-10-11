Feature: All users (user, employee, manager or admin) should
  be printed as a pdf file

  Scenario: Create a pdf file for all users' info as Name, last name and role on a pdf document
    Given user connects to GMIBank database by using "jdbc:postgresql://157.230.48.97:5432/gmibank_db", "techprodb_user" and "Techpro_@126"
    Then create a pdf for some users as id, first name, last name and role "Select id, first_name, last_name, jhi_user_authority.authority_name AS role FROM jhi_user JOIN jhi_user_authority ON jhi_user_authority.user_id = jhi_user.id"