package gmibank.com.stepDefinitionsApi;

import gmibank.com.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class US_027_StepDefinitions {

    Response response;
    int randomStateId;

    @When("user deletes a state by using api end point {string}")
    public void userDeletesAStateByUsingApiEndPoint(String url) {
        response = given().contentType(ContentType.JSON)
                        .auth().oauth2(ConfigurationReader.getProperty("token"))
                .when().get(url);

        List<Integer> statesIdList = response.jsonPath().getList("id");

        randomStateId = statesIdList.get((int)(Math.random()* statesIdList.size()));

        given().contentType(ContentType.JSON)
                .auth().oauth2(ConfigurationReader.getProperty("token"))
              //  .pathParam("id",randomStateId)
                .when()
                .delete(url+"/"+randomStateId)
                .then()
                .log().body()
                .statusCode(204)
        ;

    }

    @Then("validates if the state has been deleted")
    public void validatesIfTheStateHasBeenDeleted() {
        response = given().contentType(ContentType.JSON)
                .auth().oauth2(ConfigurationReader.getProperty("token"))
                .when().get("https://www.gmibank.com/api/tp-states/"+randomStateId);

        Assert.assertTrue(response.jsonPath().getString("detail").equals("404 NOT_FOUND"));
    }
}
