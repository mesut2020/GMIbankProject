package gmibank.com.stepDefinitionsApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.com.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import javax.naming.Name;

import java.util.List;

import static gmibank.com.jsonModels.Country_JsonBody.createCountry1;
import static gmibank.com.jsonModels.Country_JsonBody.createCountry2;
import static io.restassured.RestAssured.given;

public class US_021_StepDefinitions {
    Response response;
    Response responsePostBody;
    @Given("user gets all countries data using api endpoint {string}")
    public void userGetsAllCustomersDataUsingApiEndpoint(String URI) {

    responsePostBody=given().headers("Authorization","Bearer " +
                            ConfigurationReader.getProperty("token"),
                    "Content-Type",ContentType.JSON,
                             "Accept",ContentType.JSON).

            when().body(createCountry2).post(URI).
            then().contentType(ContentType.JSON).extract().response();

/*
{
    "id": 94837,
    "name": "Australia",
    "states": []
}
 */
        response = given().accept(ContentType.JSON).auth().oauth2(ConfigurationReader.getProperty("token")).
                when().get(URI);
    }

    @And("validates the country from data set")
    public void validatesTheCountryFromDataSet() {

        JsonPath jsonPath = response.jsonPath();
     //   System.out.println(jsonPath.getString("name"));
        List<Object> countryList = jsonPath.getList("id");

        if(countryList.contains(94837)){
            System.out.println("Country created");
        }else{
            System.out.println("Not On Record");
        }
    }
}
