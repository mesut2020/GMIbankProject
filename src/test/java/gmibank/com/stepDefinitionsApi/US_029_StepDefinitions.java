package gmibank.com.stepDefinitionsApi;

import gmibank.com.utilities.DatabaseUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.w3c.dom.stylesheets.LinkStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class US_029_StepDefinitions {

    private ResultSet users;
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    List<List<Object>> listOfUsers;
    List<Object> listOfFirstName;
    List<List<Object>> listOfCountries;
    List<Object> listOfCountryNames;
    List<List<Object>> listOfStates;
    List<Object> listOfStateNames;

    @Given("user connects to GMIBank database by using {string}, {string} and {string}")
    public void userConnectsToGMIBankDatabaseByUsingAnd(String url, String username, String password) {
        connection = DatabaseUtility.createConnection(url, username, password);
        statement = DatabaseUtility.getStatement();
    }

    @Given("user should be reads all users data from database")
    public void userShouldBeReadsAllUsersDataFromDatabase() throws SQLException {

        resultSet = statement.executeQuery("SELECT * FROM public.jhi_user");

        for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
            System.out.print(resultSet.getMetaData().getColumnLabel(i) + "    ");
        }
        System.out.println();
        listOfUsers = DatabaseUtility.getQueryResultList("SELECT * FROM public.jhi_user");
        System.out.println(listOfUsers.get(0));
//        for (List<Object> listOfUser : listOfUsers) {
//            System.out.println(listOfUser);
//        }
        listOfFirstName = DatabaseUtility.getColumnData("SELECT * FROM public.jhi_user","first_name");
        System.out.println(listOfFirstName);
    }

    @And("user should be all users data validate")
    public void userShouldBeAllUsersDataValidate() {

        Assert.assertTrue("User not found in database", listOfFirstName.contains("Cemal"));
    }

    @Given("user should be reads all countries data from database")
    public void userShouldBeReadsAllCountriesDataFromDatabase() {
        listOfCountries = DatabaseUtility.getQueryResultList("SELECT * FROM public.tp_country ORDER BY name DESC");
        listOfCountryNames = DatabaseUtility.getColumnData("SELECT * FROM public.tp_country","name");
        System.out.println(listOfCountryNames);
//        for (List<Object> listOfCountry : listOfCountries) {
//            System.out.println(listOfCountry);
//        }
    }

    @And("user should be all countries data validate")
    public void userShouldBeAllCountriesDataValidate() {
        Assert.assertTrue("Country is not found in database", listOfCountryNames.contains("TEAM54COUNTRY1"));
    }

    @Given("user should be reads all states data of related to USA from database")
    public void userShouldBeReadsAllStatesDataOfRelatedToUSAFromDatabase() {
        listOfStates = DatabaseUtility.getQueryResultList("SELECT * FROM public.tp_state");
        listOfStateNames = DatabaseUtility.getColumnData("SELECT * FROM public.tp_state", 2);
        System.out.println(listOfStateNames);
    }

    @And("user should be validate the data which all states of related to USA")
    public void userShouldBeValidateTheDataWhichAllStatesOfRelatedToUSA() {
        Assert.assertTrue("State is not found in database", listOfStateNames.contains("Koblenz"));
    }

    @Then("user should be exit GMIBank database")
    public void userShouldBeExitGMIBankDatabase() {
        DatabaseUtility.closeConnection();
    }


}
