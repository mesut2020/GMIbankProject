package gmibank.com.stepDefinitionsApi;

import gmibank.com.jsonModels.States_JsonBody;
import gmibank.com.pojos.States;
import gmibank.com.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static gmibank.com.jsonModels.States_JsonBody.createState1;
import static gmibank.com.jsonModels.States_JsonBody.createState2;
import static io.restassured.RestAssured.given;

public class US_024_StepDefinitions {

    Response response;
    Response responseCreate;
    States states = new States();
    States_JsonBody statesJsonBody = new States_JsonBody();
    String jsonBody;
    @Given("User creates a state using api endpoint {string}")
    public void userCreatesAStateUsingApiEndpoint(String URI) {

        responseCreate = given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty("token"),
                            "Content-Type", ContentType.JSON,
                            "Accept", ContentType.JSON).
                    when().body(createState2).post(URI).then().contentType(ContentType.JSON).extract().response();
        responseCreate.prettyPrint();

        jsonBody = responseCreate.jsonPath().get("name");

        response= given().accept(ContentType.JSON).auth().oauth2(ConfigurationReader.getProperty("token")).
               get(URI);

    }

    @Then("User verifies if the state has been created")
    public void userVerifiesIfTheStateHasBeenCreated() {

        JsonPath jsonPath = response.jsonPath();
        List<String> stateList = jsonPath.getList("name");

        System.out.println(stateList);

        Assert.assertTrue(stateList.contains(jsonBody));
    }
}
