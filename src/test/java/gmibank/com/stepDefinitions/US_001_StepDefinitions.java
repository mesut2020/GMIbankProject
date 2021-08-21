package gmibank.com.stepDefinitions;


import gmibank.com.pages.US_001_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US_001_StepDefinitions {

    US_001_Page registrationPage = new US_001_Page();
    @Given("Ders User on the home page {string}")
    public void dersUserOnTheHomePage(String pageUrl) {
        Driver.getDriver().get(ConfigurationReader.getProperty(pageUrl));
    }

    @And("Ders User navigates to registration page")
    public void dersUserNavigatesToRegistrationPage() {
        registrationPage.icon.click();

        registrationPage.registerButton.click();
    }

    @Then("Ders User provides a valid SSN")
    public void dersUserProvidesAValidSSN() {
        registrationPage.ssnTextBox.sendKeys("");
    }

    @Then("Ders User provides a valid Firstname")
    public void dersUserProvidesAValidFirstname() {
        registrationPage.firstNameTextBox.sendKeys("");
    }


    @Then("Ders User provides a valid Lastname")
    public void dersUserProvidesAValidLastname() {
        registrationPage.lastNameTextBox.sendKeys("");
    }

    @Then("Ders User provides a valid Address")
    public void dersUserProvidesAValidAddress() {
        registrationPage.addressTextBox.sendKeys("");
    }

    @Then("Ders User provides a valid Mobile Phone Number")
    public void dersUserProvidesAValidMobilePhoneNumber() {
        registrationPage.mobilePhoneNumberTextBox.sendKeys("");
    }

    @Then("Ders User provides a valid Username")
    public void dersUserProvidesAValidUsername() {
        registrationPage.usernameTextBox.sendKeys("");
    }

    @Then("Ders User provides a valid Email")
    public void dersUserProvidesAValidEmail() {
        registrationPage.emailTextBox.sendKeys("");
    }

    @Then("Ders User provides a valid Password")
    public void dersUserProvidesAValidPassword() {
        registrationPage.firstPasswordTextBox.sendKeys("");
    }

    @Then("Ders User provides a valid Password to Password confirmation textbox")
    public void dersUserProvidesAValidPasswordToPasswordConfirmationTextbox() {
        registrationPage.secondPasswordTextBox.sendKeys("");
    }

    @Then("User clicks on Register button")
    public void userClicksOnRegisterButton() {
        registrationPage.registerButton.click();
    }

    @And("Ders User validates that he registered succesfully")
    public void dersUserValidatesThatHeRegisteredSuccesfully() {
        ReusableMethods.waitForVisibility(registrationPage.succesfulRegisterMessage, 5);
        Assert.assertTrue(registrationPage.succesfulRegisterMessage.isDisplayed());
    }


}
