package gmibank.com.stepDefinitionsApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.com.pojos.Customer;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.ReadToTxt;
import gmibank.com.utilities.WriteToTxt;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static gmibank.com.jsonModels.States_JsonBody.createState2;
import static io.restassured.RestAssured.given;

public class US_023_StepDefinitions {
    Customer[] customers ;
    List<String> ssn= new ArrayList<>();

    @Given("Read all registrants you created and validate them from your data set")
    public void readAllRegistrantsYouCreatedAndValidateThemFromYourDataSet() throws IOException {


       Response response= given().accept(ContentType.JSON).auth().oauth2(ConfigurationReader.getProperty("token")).
                get("https://www.gmibank.com/api/tp-account-registrations");

       response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();

        ObjectMapper objectMapper=new ObjectMapper();
        customers=objectMapper.readValue(response.asString(), Customer[].class);
      //  System.out.println(customers[0].getSsn());

        for(int i=0;i<customers.length;i++){
            ssn.add(customers[i].getSsn());
        }
        System.out.println(customers[customers.length-1].getSsn().toString());
        WriteToTxt.saveDataInFileWithSSN("CustomerSSN.txt",customers);

    }

    @Given("{string} to be verified")
    public void toBeVerified(String ID) {

    }

    @Given("Read all {string} you created and validate them from your data set")
    public void readAllYouCreatedAndValidateThemFromYourDataSet(String ID) {

        Response response1 = given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty("token"),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().get("https://gmibank-qa-environment.com/api/tp-account-registrations/"+ID).
                then().contentType(ContentType.JSON).extract().response();
            response1.prettyPrint();

            JsonPath jsonPath = response1.jsonPath();

            Assert.assertTrue(jsonPath.getString("userName").contains("team54"));
    }
}
