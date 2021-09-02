package gmibank.com.stepDefinitions;

import gmibank.com.pages.US_007_Page;
import gmibank.com.pages.US_016_Page;
import gmibank.com.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class US_016_StepDefinitions {

    US_016_Page us_016_page= new US_016_Page();

    @When("Click on My Operations menu")
    public void clickOnMyOperationsMenu() {
        us_016_page.clickToWebElement("myOperationsDropDown");
    }

    @And("Click on My Account")
    public void clickOnMyAccount() {
us_016_page.clickToWebElement("myAccounts");
    }

    @Then("User should be able to see at least 2 Account")
    public void userShouldBeAbleToSeeAtLeastAccount() {
        Assert.assertTrue(us_016_page.isAccountExist("accounts"));
    }

    @And("Click on Transfer Money")
    public void clickOnTransferMoney() {
        us_016_page.clickToWebElement("transferMoney");
    }

    demo demo = new demo();
    @And("Select first account as From dropdown")
    public void selectFirstAccountAsFromDropdown() {
       // us_016_page.selectFromAccount("selectFromAccount","6677");
       demo.selectFromAccount(us_016_page.fromAccount, 1);
    }

    @And("Select first account as To dropdown")
    public void selectFirstAccountAsToDropdown() {
        demo.selectFromAccount(us_016_page.toAccount, 1);
        //us_016_page.selectToAccount("selectToAccount","6688");
    }

    @And("Click on the Balance and type {string} Euro {string} Cent")
    public void clickOnTheBalanceAndType(String e,String c) {
        us_016_page.clickToWebElement("balance");
        us_016_page.sendKeysToWebElement("balance",e);
        us_016_page.sendKeysToWebElement("balanceCent",c);
    }

    @And("Provide a description as {string}")
    public void provideADescriptionAs(String text) {
        us_016_page.clickToWebElement("description");
        us_016_page.sendKeysToWebElement("description",text);
    }

    @And("Click on Make Transfer button")
    public void clickOnMakeTransferButton() {
        us_016_page.clickToWebElement("makeTransfer");

    }

    @Then("User sees the successfully message as {string}")
    public void userSeesTheSuccessfullyMessageAs(String message) {

        Assert.assertTrue(us_016_page.verifyText("succesfullMessage",message));
    }

/*@After()
    public void after(){
    Driver.closeDriver();
}*/

}
