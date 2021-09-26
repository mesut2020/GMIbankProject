package gmibank.com.stepDefinitionsApi;

import gmibank.com.utilities.DatabaseUtility;
import gmibank.com.utilities.PDFGenerator;
import io.cucumber.java.en.Then;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class US_030_StepDefinitions {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static ResultSetMetaData resultSetMetaData;

    @Then("create a pdf for some users as id, first name, last name and role {string}")
    public void createAPdfForSomeUsersAsNameRoleAndSSN(String query) {

        statement = DatabaseUtility.getStatement();
        List<String> columnHeaderList= new ArrayList<>();

        try {
            resultSet = statement.executeQuery(query);
            resultSetMetaData = resultSet.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                columnHeaderList.add(resultSetMetaData.getColumnLabel(i));
            }

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.print(resultSetMetaData.getColumnLabel(i) + "  ");
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<List<Object>> list = DatabaseUtility
                .getQueryResultList(query);
        System.out.println(list);

        System.out.println(list.get(1));

        PDFGenerator.pdfGenerator("SomeUsers.pdf","Users Data",list,columnHeaderList,43);

        DatabaseUtility.closeConnection();

    }
}

/*
    .getQueryResultList("Select jhi_user.id, jhi_user.first_name, jhi_user.last_name, jhi_user_authority.authority_name AS role, tp_customer.ssn "
                        + "FROM jhi_user "
                        + "JOIN jhi_user_authority ON jhi_user_authority.user_id = jhi_user.id"
                        + "JOIN tp_customer ON jhi_user_authority.user_id = tp_customer.id"
                );
 */


//FROM jhi_user [[3052, LadyGaga, TeamTryCatch, ROLE_EMPLOYEE], [3479, Ali, Smith, ROLE_CUSTOMER], [31526, team20customer, team20customer, ROLE_CUSTOMER], [4638,
//tpaccount_registration   id  address  first_name  last_name  mobile_phone_number  ssn  user_name  user_id  email  create_date
//tp_employee    id  first_name  last_name  email  hire_date  mobile_phone_number  phone_number  zip_code  address  city  ssn  create_date  country_id  state  user_id  manager_id
//tp_customer    id  first_name  last_name  middle_initial  email  mobile_phone_number  phone_number  zip_code  address  city  ssn  create_date  zelle_enrolled  country_id  state  user_id