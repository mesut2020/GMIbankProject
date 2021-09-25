package gmibank.com.stepDefinitionsApi;

import gmibank.com.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class US_026_StepDefinitions {
    Response response;
    String updateName;

    @When("user updates a country by using api end point {string}")
    public void userUpdatesACountryByUsingApiEndPoint(String url) {
        response = given().accept(ContentType.JSON)
                .auth().oauth2(ConfigurationReader.getProperty("token"))
                .when()
                .get(url);


        List<Integer> countryIdList = response.jsonPath().getList("id");

        int countryId = countryIdList.get((int)(Math.random()*countryIdList.size()));

        response.jsonPath().getString("");

        updateName = "Rüdesheim am Rhein";
        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("id", countryId);
        bodyMap.put("name", updateName);
        //bodyMap.put("states", null);

        response = given()
                .contentType(ContentType.JSON)
                .auth().oauth2(ConfigurationReader.getProperty("token"))
                .when()
                .body(bodyMap)
                .put(url)
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("name", equalTo(updateName))
                .extract().response();

        response.prettyPrint();

    }

    @Then("validates if the country has been updated")
    public void validatesIfTheCountryHasBeenUpdated() {
        Assert.assertTrue("Country name is not updated...", response.jsonPath().get("name").equals(updateName));
    }
}
