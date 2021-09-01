package gmibank.com.stepDefinitions;

import gmibank.com.pages.GmiSignInPage;
import gmibank.com.pages.US_010_US_013_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class US_010_1_StepDefinitions {
    US_010_US_013_Page us10page=new US_010_US_013_Page();
    GmiSignInPage gmiSignInPage=new GmiSignInPage();


    @And("click on My Operations button located on the top navigation bar")
    public void clickOnMyOperationsButtonLocatedOnTheTopNavigationBar() {
        us10page.login();
        us10page.my_operations.click();

    }

    @Then("hover over to Manage Customers")
    public void hoverOverToManageCustomers() {
        us10page.manageCustomers.click();
    }

    @And("click on Create a new Customer button")
    public void clickOnCreateANewCustomerButton() {
        us10page.createnewcustomer.click();
    }

    @And("Type SSN number")
    public void typeSSNNumber() {
        us10page.searchSSN.sendKeys(ConfigurationReader.getProperty("ssn_number"));

    }

    @And("Type first name")
    public void typeFirstName() {

        us10page.firstName.sendKeys(ConfigurationReader.getProperty("firstname"));
    }

    @And("Type lastname")
    public void typeLastname() {
        us10page.lastName.sendKeys(ConfigurationReader.getProperty("lastname"));
    }

    @And("Type middle-initial")
    public void typeMiddleInitial() {
        us10page.midinitial.sendKeys(ConfigurationReader.getProperty("middleinitial"));
    }

    @And("Type email address")
    public void typeEmailAddress() {
        us10page.email.sendKeys(ConfigurationReader.getProperty("email"));
    }

    @And("Type mobile-phone-number")
    public void typeMobilePhoneNumber() {
        us10page.mobilePhoneNumber.sendKeys(ConfigurationReader.getProperty("mobilephone"));
    }

    @And("Type phone number")
    public void typePhoneNumber() {
        us10page.phoneNumber.sendKeys(ConfigurationReader.getProperty("phone"));
    }

    @And("Type zip-code")
    public void typeZipCode() {
        us10page.zipCode.sendKeys(ConfigurationReader.getProperty("zipcode"));
    }

    @And("Type SSNn number")
    public void typeSSNnNumber() {
        us10page.ssnn.sendKeys(ConfigurationReader.getProperty("ssn_number"));
    }

    @And("Type city")
    public void typeCity() {
        us10page.city.clear();
        us10page.city.sendKeys(ConfigurationReader.getProperty("city"));
    }

    @And("Select country")
    public void selectCountry() {

    }

    @And("Type state")
    public void typeState() {
        us10page.state.sendKeys(ConfigurationReader.getProperty("state"));
    }

    @Then("should be able to see {string} text.")
    public void ShouldBeAbleToSeeText(String arg0) {
    }

    @And("Type address")
    public void typeAddress() {
        us10page.address.clear();
        us10page.address.sendKeys(ConfigurationReader.getProperty("address"));
    }

    @And("Type Country")
    public void typeCountry() {
        Select select=new Select(us10page.countrytab);
        select.selectByVisibleText("USA");
    }

    @Given("go to SIGN IN page")
    public void goToSIGNINPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }

    @Then("should be able to see error text.")
    public void shouldBeAbleToSeeErrorText() {
        Assert.assertTrue(us10page.error.isDisplayed());
    }

    @Then("should be able to see city error text.")
    public void shouldBeAbleToSeeCityErrorText() {
        Assert.assertTrue(us10page.error.isDisplayed());
    }

    @And("click savebutton")
    public void clickSavebutton() {
        us10page.save.click();
    }

    @Then("should be able to see country error text.")
    public void shouldBeAbleToSeeCountryErrorText() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(us10page.errorline.isDisplayed());
    }

    @Then("should be able to see state error text.")
    public void shouldBeAbleToSeeStateErrorText() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(us10page.errorline.isDisplayed());
    }

    @Then("go to new page")
    public void goToNewPage() {
        us10page.newpage();
    }
}
