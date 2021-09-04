package gmibank.com.stepDefinitionsApi;

import gmibank.com.pojos.Country;
import gmibank.com.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.List;
import static gmibank.com.jsonModels.Country_JsonBody.createCountry3;
import static io.restassured.RestAssured.given;

public class US_025_StepDefinitions {
    Response response;
    Response responseCreate;
    Country country = new Country();
    String jsonBody;

    @Given("User creates a country using {string}")
    public void userCreatesACountryUsing(String URI) {

        responseCreate = given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty("token"),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().body(createCountry3).post(URI).then().contentType(ContentType.JSON).extract().response();

        response= given().accept(ContentType.JSON).auth().oauth2(ConfigurationReader.getProperty("token")).
                get(URI);

        jsonBody = responseCreate.jsonPath().get("name");
    }

    @Then("validates the country")
    public void validatesTheCountry() {

        JsonPath jsonPath = response.jsonPath();
        List<Object> countryList = jsonPath.getList("name");


        System.out.println(countryList);

        Assert.assertTrue(countryList.contains(jsonBody));

    }
}
