@readApplicants
  Feature: System should allow to read all Applicants using api endpoint
    "https://www.gmibank.com/api/tp-account-registrations

  Scenario Outline: Read all existing applicants
      Given Read all "<ID>" you created and validate them from your data set

      Examples:
        | ID   |
        | 8105 |
        | 8106 |
        | 8107 |
        | 8108 |
