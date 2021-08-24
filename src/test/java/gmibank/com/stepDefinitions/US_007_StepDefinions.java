package gmibank.com.stepDefinitions;

import gmibank.com.pages.US_007_Page;
import gmibank.com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US_007_StepDefinions {

US_007_Page us_007_page=new US_007_Page();

    @Given("go to sign in page of GMIBank")
    public void goToSignInPageOfGMIBank() {

        us_007_page.goToSignInPage();
    }

    @And("Click on user name and type the Username")
    public void clickOnUserNameAndTypeTheUsername() {
       // us_007_page.clickToWebElement("username");
        us_007_page.sendKeysToWebElement("username","cemil");

    }

    @And("Click on the Password and type Password")
    public void clickOnThePasswordAndTypePassword() {
      //  us_007_page.clickToWebElement("password");
        us_007_page.sendKeysToWebElement("password","12345678");

    }

    @And("Click on the submit button")
    public void clickOnTheSubmitButton() {
        us_007_page.clickToWebElement("submitButton");
    }

    @When("Click on Drop Drown menu")
    public void clickOnDropDrownMenu() {
        us_007_page.clickToWebElement("accountMenu");
    }

    @And("Click on User Info")
    public void clickOnUserInfo() {
        us_007_page.clickToWebElement("userInfo");
    }

    @And("Click on E-Mailbox, clear and type qwe@gmailcom")
    public void clickOnEMailboxClearAndTypeQweGmailcom() {
        us_007_page.clickToWebElement("eMail");
        us_007_page.sendKeysToWebElement("eMail","qwe@gmailcom");
    }

    @Then("User should see the error message {string}")
    public void userShouldSeeTheErrorMessage(String message) {
        us_007_page.verifyText("errorMessage",message);
    }

    @When("Click on E-Mailbox, clear and type qwegmail.com")
    public void clickOnEMailboxClearAndTypeQwegmailCom() {
        us_007_page.clickToWebElement("eMail");
        us_007_page.sendKeysToWebElement("eMail","qwegmail.com");
    }

    @And("Click on the Language Menu")
    public void clickOnTheLanguageMenu() {
        us_007_page.clickToWebElement("languageKey");
    }

    @Then("User should see only English and Turkish Language option")
    public void userShouldSeeOnlyEnglishAndTurkishLanguageOption() {
        us_007_page.islanguageExist("languageKey");
    }


}
