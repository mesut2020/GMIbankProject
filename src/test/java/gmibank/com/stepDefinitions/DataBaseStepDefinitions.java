package gmibank.com.stepDefinitions;

import gmibank.com.utilities.DatabaseUtility;
import gmibank.com.utilities.ReadToTxt;
import gmibank.com.utilities.WriteToTxt;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class DataBaseStepDefinitions {

    List<Object> allSsn;
    String fileName ="/Users/christian/team54BankProject/testData/CustomerSSNs.txt";

    @Given("user creates a connection with DB using {string} , {string} and {string}")
    public void userCreatesAConnectionWithDBUsingAnd(String url, String username, String password) {
        DatabaseUtility.createConnection("url", "username", "password");
    }
    @Given("user provides {string} and {string}")
    public void userProvidesAnd(String query, String id) {

        allSsn = DatabaseUtility.getColumnData(query,id);
        System.out.println(allSsn);
    }

    @And("user saves DB Customer info into correspondent  files")
    public void userSavesDBCustomerInfoIntoCorrespondentFiles() {
      //  WriteToTxt.saveAll(fileName,allSsn);
    }

    @Then("user validates all customer DB info")
    public void userValidatesAllCustomerDBInfo() {
        List<String> expectedSsn = new ArrayList<>();
        expectedSsn.add("444-55-6699");
        expectedSsn.add("444-55-6688");

        List<String> actualSsn = ReadToTxt.returnCustomerSNNList(fileName);
        System.out.println("actualSsn = " + actualSsn);
        Assert.assertTrue("Mismatch!", actualSsn.containsAll(expectedSsn));


    }


}
