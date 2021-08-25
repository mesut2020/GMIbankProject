package gmibank.com.stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;

import gmibank.com.pojos.Customer5;
import gmibank.com.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class apiDersBank7 {


Response response;
    @Given("read all customer data using with api endpoint {string}")
    public void read_all_customer_data_using_with_api_endpoint(String api_endpoint)  {

        response = given().headers("Authorization",
                "Bearer "+ ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,"Accept",ContentType.JSON)
                .when()
                .get(api_endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();




    }

    @Then("validate customer data")
    public void validate_customer_data() throws IOException {
        //dataların javada kullanılabilmesi için de-serialization yapcaz.

        ObjectMapper objectMapper=new ObjectMapper();
        Customer5[] customer5=objectMapper.readValue(response.asString(),Customer5[].class);
        System.out.println(customer5[0].getFirstName());
        System.out.println("===========================================================");
        System.out.println(customer5[4].getEmail()); //5. müsterinini mailini getirir.
        System.out.println("===========================================================");
        for (Customer5 item : customer5) {
            System.out.println(item.getSsn());
        }
        System.out.println("===========================================================");

        for (Customer5 value : customer5) {
            if (value.getFirstName().startsWith("M"))
                System.out.println(value.getFirstName());
        }
        System.out.println("===========================================================");
        //firstname null olmayan userlaın firstname yazdırır.
        for (int i=0; i<customer5.length; i++) {
            if (customer5[i].getUser().getFirstName()!=null) {
                System.out.println(customer5[i].getUser().getFirstName());
            }
        }

    }

}