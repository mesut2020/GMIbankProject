package gmibank.com.stepDefinitions;

import gmibank.com.pages.US_002_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class US_002_StepDefinitions {


    US_002_Page us002Page = new US_002_Page();

    @Given("user goes to application landing page")
    public void user_goes_to_application_landing_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }

    @Then("user opens registration page")
    public void user_opens_registration_page() {
        us002Page.profileMenuButton.click();
        us002Page.profileMenuRegistrationButton.click();
    }

    @Then("user clicks on register button without filling mandatory areas")
    public void user_clicks_on_register_button_without_filling_mandatory_areas() {
        us002Page.registrationPageRegisterButton.click();
    }

    @Then("user verifies error messages for all fields on the registration page")
    public void user_verifies_error_messages_for_all_fields_on_the_registration_page() {
        for (WebElement w: us002Page.errorMessages) {
            System.out.println(w.getText());
            Assert.assertTrue("Error message is not displayed",w.isDisplayed());
        }
    }

    @Then("user types  {string} number to SSN box")
    public void userTypesNumberToSSNBox(String ssnNumber) {
        us002Page.ssnTextBox.sendKeys(ssnNumber, Keys.TAB);

    }

    @And("user verifies that invalid format of SSN number leads to error message")
    public void userVerifiesThatInvalidFormatOfSSNNumberLeadsToErrorMessage() {
        Assert.assertEquals(ConfigurationReader.getProperty("invalidSSN_message"),us002Page.ssnErrorMessage.getText());
    }

    @Then("user types  {string} number to mobilephone number box")
    public void userTypesNumberToMobilephoneNumberBox(String phoneNumber) {
        us002Page.mobilPhoneNumberTextBox.sendKeys(phoneNumber,Keys.TAB);
    }

    @And("user verifies that invalid format of mobilePhone number leads to error message")
    public void userVerifiesThatInvalidFormatOfMobilePhoneNumberLeadsToErrorMessage() {
        Assert.assertEquals(ConfigurationReader.getProperty("invalidPhoneNumber_message"),us002Page.mobilePhoneNumbererrorMessage.getText());
    }

    @Then("user types  {string} info to email box")
    public void userTypesInfoToEmailBox(String emailAddress) {
        us002Page.emailAddressTextBox.sendKeys(emailAddress,Keys.TAB);
    }

    @And("user verifies that invalid format of email leads to error message")
    public void userVerifiesThatInvalidFormatOfEmailLeadsToErrorMessage() {
        Assert.assertEquals(ConfigurationReader.getProperty("invalidEmailAddress_message"),us002Page.emailAddressErrorMessage.getText());
    }

    @Then("closes browser")
    public void closesBrowser() {
        Driver.closeDriver();
    }
}
