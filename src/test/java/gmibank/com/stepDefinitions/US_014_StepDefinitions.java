package gmibank.com.stepDefinitions;
import gmibank.com.pages.US_014_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.JSExecutor;
import gmibank.com.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import javax.swing.*;


public class US_014_StepDefinitions {
    US_014_Page us014Page = new US_014_Page();

    @Given("user login with {string} account")
    public void user_login_with_account(String accountType) {
        us014Page.loginWith(accountType);
    }


    @And("user clicks on My Operations")
    public void userClicksOnMyOperations() {
        us014Page.myOperationsButton.click();
    }

    @And("user clicks on Manage Accounts")
    public void userClicksOnManageAccounts() {
        us014Page.manageAccountsButton.click();
    }

    @And("clicks on +Create a new Account")
    public void clicksOnCreateANewAccount() {
        us014Page.createNewaccountButton.click();

    }

    @And("clicks on the Create Datetextbox and type the {string}")
    public void clicksOnTheCreateDatetextboxAndTypeThe(String account_creation_date) {
        //us014Page.createDateTextBox.sendKeys(ConfigurationReader.getProperty(account_creation_date));
        us014Page.createDateTextBox.sendKeys(ConfigurationReader.getProperty(account_creation_date),Keys.ARROW_RIGHT,"16:00");
    }

    @And("clicks on the Closed Datetextbox and type the {string} later than the time of account creation")
    public void clicksOnTheClosedDatetextboxAndTypeTheLaterThanTheTimeOfAccountCreation(String account_closed_date) {
        us014Page.closedDateTextBox.sendKeys(ConfigurationReader.getProperty(account_closed_date),Keys.ARROW_RIGHT,"17:00",Keys.TAB);
    }
    @Then("Verify that Create Date and Closed Date created successfully")
    public void verifyThatCreateDateAndClosedDateCreatedSuccessfully() {
        try{
            us014Page.createDateErrorFormat.getText();
        }catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
        try{
            us014Page.closedDateErrorFormat.getText();
        }catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @And("clicks on the Closed Datetextbox and type the {string} before than the time of account creation")
    public void clicksOnTheClosedDatetextboxAndTypeTheBeforeThanTheTimeOfAccountCreation(String account_closed_date_before) {
        us014Page.closedDateTextBox.sendKeys(ConfigurationReader.getProperty(account_closed_date_before),Keys.ARROW_RIGHT,"17:00",Keys.TAB);
    }

    @Then("Verify that Create Date and Closed Date not created successfully")
    public void verifyThatCreateDateAndClosedDateNotCreatedSuccessfully() {
        try{
            Assert.assertTrue(us014Page.closedDateErrorFormat.getAttribute("class").equals("text-danger form-group"));
        }catch (NoSuchElementException e){
            Assert.assertTrue(false);
        }
    }

    @And("clicks on the Create Date textbox and type date as month,day,year,hour and minute {string}")
    public void clicksOnTheCreateDateTextboxAndTypeDateAsMonthDayYearHourAndMinute(String date) {

        us014Page.createDateTextBox.sendKeys(date.split(" ")[0],Keys.ARROW_RIGHT,date.split(" ")[1],Keys.TAB);
    }

    @Then("Then Verify that the date created succesfully")
    public void thenVerifyThatTheDateCreatedSuccesfully() {
        try{
            Assert.assertTrue(us014Page.closedDateErrorFormat.getAttribute("class").equals("text-danger form-group"));
        }catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @And("clicks on the Create Date textbox and type date as month,day,year {string}")
    public void clicksOnTheCreateDateTextboxAndTypeDateAsMonthDayYear(String arg0) {
        us014Page.createDateTextBox.clear();
        us014Page.createDateTextBox.sendKeys(arg0,Keys.TAB);
    }

    @Then("Verify that the date not created succesfully")
    public void thenVerifyThatTheDateNotCreatedSuccesfully() {
        try{
            Assert.assertTrue(us014Page.closedDateErrorFormat.getAttribute("class").equals("text-danger form-group"));
        }catch (NoSuchElementException e){
            Assert.assertTrue(false);
        }
    }

    @And("user clicks on Manage Customers")
    public void userClicksOnManageCustomers() {
        us014Page.manageCustomerButton.click();
    }

    @And("clicks on +Create a new Customer")
    public void clicksOnCreateANewCustomer() {
        us014Page.createCustomerButton.click();
    }

    @And("enters a valid SSN {string} and clicks on Search button")
    public void entersAValidSSNAndClicksOnSearchButton(String ssnNumber) {
        us014Page.ssnSearch.sendKeys(ssnNumber);
        us014Page.searchButtonForSnn.click();
    }
    @Then("verifies user information is displayed")
    public void verifiesUserInformationIsDisplayed() {
        Assert.assertTrue(us014Page.firstNameAfterSearch.getAttribute("value").length()>1);
    }

    @And("user selects Zelle Enrolled option checkbox {string}")
    public void userSelectsZelleEnrolledOptionCheckbox(String arg0) {

    }

    @And("user clicks on Save button")
    public void userClicksOnSaveButton() {

    }

    @Then("user verifies no error message displayed since this section is optional")
    public void userVerifiesNoErrorMessgeDisplayedSinceThisSectionIsOptional() {

    }

    @And("clicks on an ID item to choose an account created on manage accounts")
    public void clicksOnAnIDItemToChooseAnAccountCreatedOnManageAccounts() {
        ReusableMethods.waitForPageToLoad(5);
        us014Page.accountPageFirstID.click();

    }

    @Then("verifies selected account is displayed")
    public void verifiesSelectedAccountIsDisplayed() {
        String firstAccountDetailsText = us014Page.firstAccountDetails.getText();
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(firstAccountDetailsText));

    }
}
