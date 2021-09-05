package gmibank.com.stepDefinitions;

import com.github.javafaker.Faker;
import gmibank.com.pages.GmiSignInPage;
import gmibank.com.pages.US_006_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;

public class US_006_StepDefinitions {
    US_006_Page us_006_page = new US_006_Page();
    GmiSignInPage gmiSignInPage = new GmiSignInPage();
    Actions action = new Actions(Driver.getDriver());
    Faker fake = new Faker();

    @Given("I sign in as a user with the given data")
    public void i_sign_in_as_a_user_with_the_given_and_data() throws InterruptedException {
        gmiSignInPage.userLogin();
    }

    @Then("I verify firstname,lastname,email and language boxes are visible")
    public void i_verify_firstname_lastname_email_and_language_boxes_are_visible() throws IOException {

        String firstname= ConfigurationReader.getProperty("user_name");
        String lastname = ConfigurationReader.getProperty("user_lastname");
        String email = ConfigurationReader.getProperty("user_email");

        Assert.assertEquals(firstname,us_006_page.firstNameBoxUserInfo.getAttribute("value"));
        Assert.assertEquals(lastname,us_006_page.lastNameBoxUserInfo.getAttribute("value"));
        Assert.assertEquals(email,us_006_page.emailBoxUserInfo.getAttribute("value"));
    }
    @Then("I verify English and Turkish language options are available on the page")
    public void i_verify_english_and_turkish_language_options_are_available_on_the_page() throws InterruptedException {

        us_006_page.languageDropdownUserInfo.click();
        action.moveToElement(us_006_page.turkishOptionUserInfo);
        Thread.sleep(5000);
        Assert.assertTrue(us_006_page.turkishOptionUserInfo.isDisplayed());

        us_006_page.languageDropdownUserInfo.click();
        action.moveToElement(us_006_page.englishOptionUserInfo);
        Thread.sleep(5000);
        Assert.assertTrue(us_006_page.englishOptionUserInfo.isDisplayed());
    }
    @Then("I click on the update button")
    public void i_click_on_the_update_button() {
        us_006_page.saveButtonUserInfo.click();
        ReusableMethods.waitForVisibility(us_006_page.confirmationMessage,5000);
        Assert.assertTrue(us_006_page.confirmationMessage.isDisplayed());

    }
    @Given("I click on first name text box and update the name.")
    public void i_click_on_first_name_text_box_and_update_the_name() {

        us_006_page.firstNameBoxUserInfo.clear();
        us_006_page.firstNameBoxUserInfo.sendKeys(ConfigurationReader.getProperty("updatedName"));
        us_006_page.saveButtonUserInfo.click();
        ReusableMethods.waitForVisibility(us_006_page.confirmationMessage,5000);
        Assert.assertTrue(us_006_page.confirmationMessage.isDisplayed());


    }

    @Then("I verify the first name is updated.")
    public void i_verify_the_first_name_is_updated() {
        us_006_page.saveButtonUserInfo.click();
        ReusableMethods.waitForVisibility(us_006_page.confirmationMessage,5000);
        Assert.assertTrue(us_006_page.confirmationMessage.isDisplayed());
        us_006_page.firstNameBoxUserInfo.clear();
        us_006_page.firstNameBoxUserInfo.sendKeys(ConfigurationReader.getProperty("user_name"));
        us_006_page.saveButtonUserInfo.click();
    }
    @Then("I click on last name text box and update the name.")
    public void i_click_on_last_name_text_box_and_update_the_name() {
        us_006_page.lastNameBoxUserInfo.clear();
        us_006_page.lastNameBoxUserInfo.sendKeys(ConfigurationReader.getProperty("updatedLastName"));
        us_006_page.saveButtonUserInfo.click();
        ReusableMethods.waitForVisibility(us_006_page.confirmationMessage,5000);
        Assert.assertTrue(us_006_page.confirmationMessage.isDisplayed());

    }

    @Then("I verify the last name is updated.")
    public void i_verify_the_last_name_is_updated() {
        us_006_page.saveButtonUserInfo.click();
        ReusableMethods.waitForVisibility(us_006_page.confirmationMessage,5000);
        Assert.assertTrue(us_006_page.confirmationMessage.isDisplayed());
        us_006_page.lastNameBoxUserInfo.clear();
        us_006_page.lastNameBoxUserInfo.sendKeys(ConfigurationReader.getProperty("user_lastname"));
        us_006_page.saveButtonUserInfo.click();
    }
    @Given("I click on email text box and update the email.")
    public void i_click_on_email_text_box_and_update_the_email() {
        us_006_page.emailBoxUserInfo.clear();
        us_006_page.emailBoxUserInfo.sendKeys(ConfigurationReader.getProperty("updatedEmail"));
        us_006_page.saveButtonUserInfo.click();
        ReusableMethods.waitForVisibility(us_006_page.confirmationMessage,5000);
        Assert.assertTrue(us_006_page.confirmationMessage.isDisplayed());
    }

    @Then("I verify the updated email contains @ sign and . extension")
    public void i_verify_the_updated_email_contains_sign_and_extension() {
        us_006_page.emailBoxUserInfo.clear();
        us_006_page.emailBoxUserInfo.sendKeys(ConfigurationReader.getProperty("updatedEmail"));
        us_006_page.saveButtonUserInfo.click();
        ReusableMethods.waitForVisibility(us_006_page.confirmationMessage,5000);
        Assert.assertTrue(us_006_page.emailBoxUserInfo.getAttribute("value")
                .contains("@") && us_006_page.emailBoxUserInfo.getAttribute("value")
                .contains("."));
        us_006_page.emailBoxUserInfo.sendKeys(ConfigurationReader.getProperty("user_email"));
        us_006_page.saveButtonUserInfo.click();


    }

}
