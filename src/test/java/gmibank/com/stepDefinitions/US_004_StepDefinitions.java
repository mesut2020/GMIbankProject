package gmibank.com.stepDefinitions;

import gmibank.com.pages.US_004_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

public class US_004_StepDefinitions {

    US_004_Page us_004_page= new US_004_Page();

    @Given("user go to  {string}")
    public void user_go_to(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty(string));

    }

    @Given("user click on account menu")
    public void user_click_on_account_menu() {
        us_004_page.accountmenu.click();
    }

    @Given("user click on sign in")
    public void user_click_on_sign_in() {
        us_004_page.login.click();

    }

    @Given("user enter a valid {string} to usernamebox")
    public void user_enter_a_valid_to_usernamebox(String string) {
        us_004_page.usernameBox.sendKeys(string);

    }

    @Given("user enter a valid {string} to passwordbox")
    public void user_enter_a_valid_to_passwordbox(String string) {
        us_004_page.passwordBox.sendKeys(string);

    }

    @Then("user click on {string} button")
    public void user_click_on_button(String string) {
        us_004_page.signinButton.click();
    }

    @Then("user verifies successful login with {string}")
    public void userVerifiesSuccessfulLoginWith(String userName) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(us_004_page.headerTabs.size()>8);
    }

    @Then("user closes browser")
    public void userClosesBrowser() {
        Driver.closeDriver();
    }

    @Then("user click on Cancel button")
    public void userClickOnCancelButton() {
        us_004_page.cancelbutton.click();
    }

    @Then("user verifies to cancel login")
    public void userVerifiesToCancelLogin() throws InterruptedException {

        Thread.sleep(3000);
        Assert.assertTrue(us_004_page.headerTabs.size()==8);
    }

}
