package gmibank.com.stepDefinitionsApi;

import gmibank.com.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class US_020_StepDefinitions {
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    Properties properties;
    Response response;

    @Given("user creates token via api endpoint {string}")
    public void userCreatesTokenViaApiEndpoint(String uri) throws IOException {
        String postBody = "{\n" +
                    "    \"username\" : \"CWoburn\",\n" +
                    "    \"password\" : \"Cw192837?\",\n" +
                    "    \"rememberMe\" : false\n" +
                    "}";

        response = given().contentType("application/json").when().body(postBody).post(uri);
        JsonPath js = response.jsonPath();
        String token = js.get("id_token");
        fileInputStream = new FileInputStream("configuration.properties");
        properties = new Properties();
        properties.load(fileInputStream);
        properties.setProperty("token",token);
        fileOutputStream = new FileOutputStream("configuration.properties");
        properties.store(fileOutputStream,null);

    }


    @Given("user gets all customers data usign api endpoint {string}")
    public void user_gets_all_customers_data_usign_api_endpoint(String endPoint) {

        String token = ConfigurationReader.getProperty("token");

        response = given().accept(ContentType.JSON).auth().oauth2(token).
                when().get(endPoint);

        response.prettyPrint();


    }

    @And("validates them from data set")
    public void validatesThemFromDataSet() {


    }

}
