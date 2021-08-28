package gmibank.com.stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.com.pojos.Country;
import gmibank.com.pojos.Customer;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.ReadToTxt;
import gmibank.com.utilities.WritetoTxt;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gmibank.com.jsonModels.CountryJson.createCountry;
import static io.restassured.RestAssured.given;

public class apiDersBank7 {

    int createdCountry;
    int id;
    String name;


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
        Customer[] customer =objectMapper.readValue(response.asString(), Customer[].class);
        System.out.println(customer[0].getFirstName());
        System.out.println("===========================================================");
        System.out.println(customer[4].getEmail()); //5. müsterinini mailini getirir.
        System.out.println("===========================================================");
        for (Customer item : customer) {
            System.out.println(item.getSsn());
        }
        System.out.println("===========================================================");

        for (Customer value : customer) {
            if (value.getFirstName().startsWith("M"))
                System.out.println(value.getFirstName());
        }
        System.out.println("===========================================================");
        //firstname null olmayan userlaın firstname yazdırır.
        for (int i = 0; i< customer.length; i++) {
            if (customer[i].getUser().getFirstName()!=null) {
                System.out.println(customer[i].getUser().getFirstName());
            }
        }

    }
//========================read all countries==================================

    @Then("read all countries and write country ids to txt using api endpoint {string}")
    public void read_all_countries_and_write_country_ids_to_txt_using_api_endpoint(String api_url) throws IOException {

        response = given().headers("Authorization",
                "Bearer "+ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .get(api_url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();

        // validate isleminde kullanmak icin tum ulke idlerini bir listin icine atalim

        List<String> countryId = new ArrayList<>();

        // objectmapper kullanarak deserilazition yapiyoruz

        ObjectMapper objectMapper = new ObjectMapper();

        Country [] country5 = objectMapper.readValue(response.asString(),Country[].class);

        // for dongusu ile tum country id lerini daha  once olusturdugumuz listin icine ekleyelim

        for(int i = 0 ; i < country5.length ; i++){
            countryId.add(String.valueOf(country5[i].getId()));
        }

        //ulke Idleri TXT olarak yazdıracaz bunun için Writetxt clasını kullanıcaz;
        WritetoTxt.saveDataInFileWithCountry5Id("countryIds",country5);
        //yukarıdaki işlem bize sadece target clasın altına Id leri getirir.


        //txt olarak yazdırdığımız Id leri şimdi de Readtxt olarak okutalım. Bunun için hazırlanmış
        // Oncelikle liste atalım. rearId içine attık sonra da assert yaptık.

        List<String> readId= ReadToTxt.returnCountry5IdList("countryIds"); //buradaki
        // name mutlaka bir onceki class ismi ile aynı olmalıdır.

        Assert.assertEquals("not match",countryId,readId);
        //

        System.out.println("Validation is succesfull");

///===============create all countries=============

    }
    @And("create country {string}")
    public void createCountry(String api_url) {

    response=given().headers("Authorization",
            "Bearer "+ConfigurationReader.getProperty("token"),
            "Content-Type",ContentType.JSON,"Accept",ContentType.JSON).
            when().body(createCountry).
            post(api_url).then().
            contentType(ContentType.JSON).
            extract().response();

    //Burada yeni bir ulke oluşturmuş olduk.

        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();
        createdCountry=jsonPath.getInt("id");

        System.out.println("================================");
        //yeni ulkenin Id si gelecek
        System.out.println(createdCountry);
    }

    @Then("validate created a country")
    public void validateCreatedACountry() {

        response=given().headers("Authorization",
                "Bearer "+ConfigurationReader.getProperty("token"),
                "Content-Type",ContentType.JSON,"Accept",ContentType.JSON).
                when().
                get("https://www.gmibank.com/api/tp-countries/"). //burada adrresi açık da yazabiliriz.
                then().
                contentType(ContentType.JSON).extract().response();

                JsonPath jsonPath=response.jsonPath();

                String stringId= jsonPath.getString("id");
                String stringcreatedcountyId=String.valueOf(createdCountry);
                Assert.assertTrue("not contains",stringId.contains(stringcreatedcountyId));
    }

    @And("update created a country using api end point {string}  {string} and its extension {string}")
    public void updateCreatedACountryUsingApiEndPointAndItsExtension(String api_url, String name, String id) {

        Map<String, Object> putCountry=new HashMap<>();
        putCountry.put("id",id);
        putCountry.put("name",name);
        putCountry.put("states",null);

        response=given().headers("Authorization",
                "Bearer "+ConfigurationReader.getProperty("token"),
                "Content-Type",ContentType.JSON,"Accept",ContentType.JSON).
                when().body(putCountry).
                put(api_url).
                then().
                contentType(ContentType.JSON).
                extract().response();

        //ulke guncellendi.
        response.prettyPrint();

    }


    @Given("delete updated a country using endpoint {string} and its extension {string} and validate")
    public void delete_updated_a_country_using_endpoint_and_its_extension_and_validate(String api_url, String id) {

            response = given().headers("Authorization",
                    "Bearer "+ConfigurationReader.getProperty("token"),
                    "Content-Type",
                    ContentType.JSON,
                    "Accept", ContentType.JSON)
                    .when()
                    .delete(api_url+id)
                    .then()
                    .extract()
                    .response();

            Response responseNew = given().headers("Authorization",
                    "Bearer "+ConfigurationReader.getProperty("token"),
                    "Content-Type",
                    ContentType.JSON,
                    "Accept", ContentType.JSON)
                    .when()
                    .get(api_url)
                    .then()
                    .contentType(ContentType.JSON)
                    .extract()
                    .response();

            JsonPath jsonPath =responseNew.jsonPath();
            String ids = jsonPath.getString("id");

            Assert.assertFalse("not delete" , ids.contains(id));
            System.out.println("Validation is succesfull");





    }
}