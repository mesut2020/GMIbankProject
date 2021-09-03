package gmibank.com.stepDefinitionsApi;

import gmibank.com.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class US_021_StepDefinitions {

    Response response;


    @Given("user gets all country data usign api endpoint {string}")
    public void userGetsAllCountryDataUsignApiEndpoint(String arg0) {
        response = given().accept(ContentType.JSON).auth().oauth2(ConfigurationReader.getProperty("token")).when().get(arg0);
    }

    @And("validates countries from data set")
    public void validatesCountriesFromDataSet() {

    }
}
