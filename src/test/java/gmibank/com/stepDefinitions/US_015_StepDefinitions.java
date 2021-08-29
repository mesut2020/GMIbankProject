package gmibank.com.stepDefinitions;

import gmibank.com.pages.US_015_Page;
import gmibank.com.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_015_StepDefinitions {

    US_015_Page us_015_page = new US_015_Page();
    boolean check;

    /*@After
    public void after(){
        Driver.closeDriver();
    }*/

    @Given("US15 login to GMIBank as a Customer")
    public void usLoginToGMIBankAsACustomer() {
        us_015_page.signInAsCustomer();
    }

    @And("US15 click on My Operations dropdown")
    public void usClickOnMyOperationsDropdown() {
        us_015_page.clickOnMyOperations();
    }

    @When("US15 choose My Account from dropdown menu")
    public void usChooseMyAccountFromDropdownMenu() {
        us_015_page.clickOnMyAccounts();
        us_015_page.printCustomerAccounts();
    }

    @Then("US15 user should see the account types and balance")
    public void usUserShouldSeeTheAccountTypesAndBalance() {
        Assert.assertTrue(us_015_page.isAccountTypeExist());
        Assert.assertTrue(us_015_page.isBalanceExist());
    }

    @And("US15 click on View Transaction button")
    public void usClickOnViewTransactionButton() {
    check = us_015_page.clickOnViewTransactionButtons();
    }

    @Then("US15 user should see the transactions")
    public void usUserShouldSeeTheTransactions() {
        Assert.assertTrue(check);
    }

}