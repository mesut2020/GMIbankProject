package gmibank.com.stepDefinitionsApi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.com.pojos.Customer;
import gmibank.com.utilities.ConfigurationSetter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class US_020_StepDefinitions {
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    Properties properties;
    Response response;
    String token;
    List<Object> customerId;
    Cookies cookies;

    @Given("user creates token via api endpoint {string}")
    public void userCreatesTokenViaApiEndpoint(String uri) throws IOException {
        String postBody = "{\n" +
                    "    \"username\" : \"CWoburn\",\n" +
                    "    \"password\" : \"Cw192837?\",\n" +
                    "    \"rememberMe\" : false\n" +
                    "}";

        response = given().contentType("application/json").when().body(postBody).post(uri);
        JsonPath js = response.jsonPath();
        token = js.get("id_token");
        System.out.println(token);

        ConfigurationSetter.setProperty("configuration.properties","token",token);

//        fileInputStream = new FileInputStream("configuration.properties");
//        properties = new Properties();
//        properties.load(fileInputStream);
//        properties.setProperty("token",token);
//        fileOutputStream = new FileOutputStream("configuration.properties");
//        properties.store(fileOutputStream,null);

    }


    @Given("user gets all customers data usign api endpoint {string}")
    public void user_gets_all_customers_data_usign_api_endpoint(String endPoint) throws IOException {

        response = given().accept(ContentType.JSON).auth().oauth2(token).
                when().get(endPoint);

        //response.prettyPrint();


        /*JsonPath js = response.jsonPath();

        // actualdata
        List<Object> customerSsn = js.getList("ssn");

        // expectedData

        List<Object> expectedSsn = new ArrayList<>();
        expectedSsn.add("027-31-2727");
        expectedSsn.add("355-88-2318");
        expectedSsn.add("821-84-3971");

        Assert.assertTrue(customerSsn.containsAll(expectedSsn));*/

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        Customer [] customers = objectMapper.readValue(response.asString(),Customer[].class);

        customerId = new ArrayList<>();

        for (int i = 0; i < customers.length; i++) {
            customerId.add(customers[i].getSsn());
        }

        System.out.println(customerId);


    }

    @And("validates them from data set")
    public void validatesThemFromDataSet() {

        List<Object> expectedSsn = new ArrayList<>();
        expectedSsn.add("111-54-5450");
        expectedSsn.add("111-54-5458");
        Assert.assertTrue(customerId.containsAll(expectedSsn));
        System.out.println("Test Success");


    }

    @And("validates them them 1 by 1")
    public void validatesThemThemBy() {

        response = given().accept(ContentType.JSON).auth().oauth2(token).
                when().get("https://gmibank-qa-environment.com/api/tp-customers?size=3000");

        JsonPath jsonPath = response.jsonPath();
        List<Object> actualSsn = jsonPath.getList("ssn");
        System.out.println(actualSsn);

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("ssn", Matchers.hasItem("111-54-5450"),
                "email",Matchers.hasItem("team54c@team.com"));

        Assert.assertTrue(actualSsn.contains("111-54-5450"));

    }
}
