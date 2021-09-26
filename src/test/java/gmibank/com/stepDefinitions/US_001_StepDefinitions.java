package gmibank.com.stepDefinitions;


import com.github.javafaker.Faker;
import gmibank.com.pages.GmiSignInPage;
import gmibank.com.pages.US_001_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Random;

public class US_001_StepDefinitions {
    GmiSignInPage homePage = new GmiSignInPage();
    US_001_Page registrationPage = new US_001_Page();

    @Given("user on the home page {string}")
    public void dersUserOnTheHomePage(String url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(url));
    }


    @And("user navigates to registration page")
    public void dersUserNavigatesToRegistrationPage() {
        registrationPage.icon.click();

        registrationPage.ilkRegisterButton.click();
    }

    @Then("user provides a valid {string}")
    public void dersUserProvidesAValidSSN(String ssn) {
        registrationPage.ssnTextBox.sendKeys(ReusableMethods.getRandomSSN());
        //registrationPage.ssnTextBox.sendKeys(ConfigurationReader.getProperty(ssn));
    }

    @Then("user provides a valid Firstname")
    public void dersUserProvidesAValidFirstname() {
        registrationPage.firstNameTextBox.sendKeys(ReusableMethods.getFakeFirstName());
    }


    @Then("user provides a valid Lastname")
    public void dersUserProvidesAValidLastname() {
        registrationPage.lastNameTextBox.sendKeys(ReusableMethods.getFakeLastName());
    }

    @Then("user provides a valid Address")
    public void dersUserProvidesAValidAddress() {
        registrationPage.addressTextBox.sendKeys(new Faker().address().cityName());
    }

    @Then("user provides a valid Mobile Phone Number")
    public void dersUserProvidesAValidMobilePhoneNumber() {
        registrationPage.mobilePhoneNumberTextBox.sendKeys(ReusableMethods.getNewRequestNumber("254-254-7326"));
    }

    @Then("user provides a valid Username {string}")
    public void dersUserProvidesAValidUsername(String username) {
        registrationPage.usernameTextBox.sendKeys(ReusableMethods.getFakeUserName());
    }

    @Then("user provides a valid Email")
    public void dersUserProvidesAValidEmail() {
        Faker faker = new Faker();
        registrationPage.emailTextBox.sendKeys(faker.internet().emailAddress());
    }

    @Then("user provides a valid Password {string}")
    public void dersUserProvidesAValidPassword(String password) {
        registrationPage.firstPasswordTextBox.sendKeys(ConfigurationReader.getProperty(password));
    }

    @Then("user provides a valid Password to Password confirmation textbox")
    public void dersUserProvidesAValidPasswordToPasswordConfirmationTextbox() {
        registrationPage.secondPasswordTextBox.sendKeys("Yakup123.");
    }

    @Then("User clicks on Register button")
    public void userClicksOnRegisterButton() {
        registrationPage.registerButton.click();
        ReusableMethods.waitFor(5);
    }

    @And("Ders User validates that he registered succesfully")
    public void dersUserValidatesThatHeRegisteredSuccesfully() {
        ReusableMethods.waitForVisibility(registrationPage.succesfulRegisterMessage, 5);
        Assert.assertTrue(registrationPage.succesfulRegisterMessage.isDisplayed());
    }

//2
    @Given("The user leaves the SSN textbox blank as a user")
    public void theUserLeavesTheSSNTextboxBlankAsAUser() {
        registrationPage.ssnTextBox.sendKeys("");
        Driver.wait(3);
        registrationPage.ssnTextBox.sendKeys(Keys.ENTER);
    }




    @Then("The user as a user displays the error message {string}")
    public void theUserAsAUserDisplaysTheErrorMessage(String arg0) {
        Assert.assertTrue(registrationPage.ssnErrorMesage.isDisplayed());
    }
    //3
    @Given("As a user, the user enters a number in the SSN textbox without using the {string} character")
    public void asAUserTheUserEntersANumberInTheSSNTextboxWithoutUsingTheCharacter(String arg0) {
        registrationPage.ssnTextBox.sendKeys("456789767");
        Driver.wait(3);
        registrationPage.ssnTextBox.sendKeys(Keys.ENTER);


    }
    @Then("The user as a user displays the error message Your SSN is invalid")
    public void theUserAsAUserDisplaysTheErrorMessageYourSSNIsInvalid() {
        Assert.assertTrue(registrationPage.ssnErrorMesage.isDisplayed());
    }
//4
    @Given("The user leaves the Fist Name textbox blank as a user")
    public void theUserLeavesTheFistNameTextboxBlankAsAUser() {
        registrationPage.firstNameTextBox.sendKeys("");
        Driver.wait(3);
        registrationPage.firstNameTextBox.sendKeys(Keys.ENTER);
    }


    @Then("Kullanici bir user olarak {string} hata uyarisini goruntuler")
    public void kullaniciBirUserOlarakHataUyarisiniGoruntuler(String arg0) {

            Assert.assertTrue(registrationPage.firstNameErrorMesage.isDisplayed());


    }
//5
@Given("The user leaves the Last Name textbox blank as a user")
public void theUserLeavesTheLastNameTextboxBlankAsAUser() {
    registrationPage.lastNameTextBox.sendKeys("");
    Driver.wait(3);
    registrationPage.lastNameTextBox.sendKeys(Keys.ENTER);
}

    @Then("The user displays the red {string} error message below the last name box as the user.")
    public void theUserDisplaysTheRedErrorMessageBelowTheLastNameBoxAsTheUser(String arg0) {
        Assert.assertTrue(registrationPage.lastNameErrorMesage.isDisplayed());
    }

//6
    @Given("The user leaves the Address textbox blank as a user")
    public void theUserLeavesTheAddressTextboxBlankAsAUser() {
        registrationPage.addressTextBox.sendKeys("");
        Driver.wait(3);
        registrationPage.addressTextBox.sendKeys(Keys.ENTER);
        
    }

    @Given("The user leaves the Mobile Phone Nummer textbox blank as a user")
    public void theUserLeavesTheMobilePhoneNummerTextboxBlankAsAUser() {
        registrationPage.mobilePhoneNumberTextBox.sendKeys("abcdg");
        Driver.wait(3);
        registrationPage.mobilePhoneNumberTextBox.sendKeys(Keys.ENTER);
        Assert.assertTrue(registrationPage.mobilePhoneNumberErrorMesage.isDisplayed());
    }

    @Given("As a user, the user enters the mobile phone number {string} without the dash in the Mobile Phone Number textbox")
    public void asAUserTheUserEntersTheMobilePhoneNumberWithoutTheDashInTheMobilePhoneNumberTextbox(String arg0) {
        registrationPage.mobilePhoneNumberTextBox.sendKeys("45666666666");
        Driver.wait(3);
        registrationPage.mobilePhoneNumberTextBox.sendKeys(Keys.ENTER);
        Assert.assertTrue(registrationPage.mobilePhoneNumberErrorMesage.isDisplayed());
    }

    @Given("The user leaves the Username textbox blank as a user")
    public void theUserLeavesTheUsernameTextboxBlankAsAUser() {
        registrationPage.usernameTextBox.sendKeys("");
        Driver.wait(3);
        registrationPage.usernameTextBox.sendKeys(Keys.ENTER);
        Assert.assertTrue(registrationPage.usernameErrorMesage.isDisplayed());
    }

    @Given("Given The user leaves the Email textbox blank as a user")
    public void givenTheUserLeavesTheEmailTextboxBlankAsAUser() {
        registrationPage.emailTextBox.sendKeys("");
        Driver.wait(3);
        registrationPage.emailTextBox.sendKeys(Keys.ENTER);
        Assert.assertTrue(registrationPage.eMailErrorMesage.isDisplayed());

    }

    @Given("The user enters an invalid mail in the mailbox")
    public void theUserEntersAnInvalidMailInTheMailbox() {
        registrationPage.emailTextBox.sendKeys("abcdmail.com");
        Driver.wait(3);
        registrationPage.emailTextBox.sendKeys(Keys.ENTER);
        Assert.assertTrue(registrationPage.eMailErrorMesage.isDisplayed());
    }

    @Given("Given The user leaves the Password textbox blank as a user")
    public void givenTheUserLeavesThePasswordTextboxBlankAsAUser() {
        registrationPage.firstPasswordTextBox.sendKeys("");
        Driver.wait(3);
        registrationPage.firstPasswordTextBox.sendKeys(Keys.ENTER);
        Assert.assertTrue(registrationPage.passwordErrorMesage.isDisplayed());
    }

    @Given("user types  {string} a valid  Password  to Password box")
    public void userTypesAValidPasswordToPasswordBox(String arg0) {
        registrationPage.firstPasswordTextBox.sendKeys("Abcde.123");
    }

    @And("Password is retyped for new password confirmation")
    public void passwordIsRetypedForNewPasswordConfirmation() {
        registrationPage.secondPasswordTextBox.sendKeys("Abcde_123");
        Driver.wait(3);
        registrationPage.secondPasswordTextBox.sendKeys(Keys.ENTER);
        Assert.assertTrue(registrationPage.newPasswordConfirmationErrorMesage.isDisplayed());
    }



}
