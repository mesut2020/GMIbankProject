package gmibank.com.stepDefinitionsApi;

import gmibank.com.jsonModels.States_JsonBody;
import gmibank.com.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import static gmibank.com.jsonModels.States_JsonBody.createState1;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class US_022_StepDefinitions {
    Response response;
    Response responsePostBody;

    States_JsonBody expedtedStateBody = new States_JsonBody();

    @Given("user gets all states data using api endpoint {string}")
    public void userGetsAllStatesDataUsingApiEndpoint(String URI) {

        // CREATING STATE WITH POST REQUEST
        responsePostBody = given().headers("Authorization","Bearer "+ConfigurationReader.getProperty("token"),
                    "Content-Type",ContentType.JSON,"Accept",ContentType.JSON).
                when().body(createState1).post(URI).then().contentType(ContentType.JSON).extract().response();

        // READING DATA WITH GET REQUEST
        response= given().accept(ContentType.JSON).auth().oauth2(ConfigurationReader.getProperty("token")).
                get(URI);

        response.prettyPrint();
    }

    @And("validates the state from data set")
    public void validatesTheStateFromDataSet() throws IOException {

            JsonPath jsonPath = response.jsonPath();
            List<Object> stateList = jsonPath.getList("name");

        System.out.println(stateList);

        if (stateList.contains(ConfigurationReader.getProperty("verifyState"))){
            System.out.println("Passed!");
            Assert.assertTrue(true);
        }else{
            System.out.println("Not on record!");
            Assert.assertTrue(false);
        }

    }
}