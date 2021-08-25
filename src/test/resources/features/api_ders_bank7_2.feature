@api_testing_ders_1
  Feature: Api testing ders 1

    @Customer_validation
    Scenario: Read and validate customer data
      Given read all customer data using with api endpoint "https://www.gmibank.com/api/tp-customers"
      Then validate customer data