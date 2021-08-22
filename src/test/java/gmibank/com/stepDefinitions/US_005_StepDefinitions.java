package gmibank.com.stepDefinitions;

import gmibank.com.pages.US_005_Page;
import gmibank.com.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class US_005_StepDefinitions {
    US_005_Page us_005_page = new US_005_Page();

    @Given("US05 go to SIGN IN page")
    public void usGoToSIGNINPage() {
        us_005_page.goToSignInPage();
    }

    @When("US05 click on username textbox and type {string}")
    public void usClickOnUsernameTextboxAndType(String username) {
        us_005_page.typeUserName(username);
    }

    @And("US05 click on password textbox and type {string}")
    public void usClickOnPasswordTextboxAndType(String password) {
        us_005_page.typePassword(password);
    }

    @And("US05 click on the sign in button")
    public void usClickOnTheSignInButton() {
        us_005_page.clickOnSubmitButton();
    }

    @But("US05 user should not be able to login and see an Error message as {string}")
    public void usUserShouldNotBeAbleToLoginAndSeeAnErrorMessageAs(String errorMessage) {
        Assert.assertTrue(us_005_page.isErrorMessageExist(errorMessage));
    }

    @When("US05 check the link to reset a password")
    public void usCheckTheLinkToResetAPassword() {
        Assert.assertTrue(us_005_page.isLinkResetPassExist());
    }

    @And("US05 click on the link to go to reset password page")
    public void usClickOnTheLinkToGoToResetPasswordPage() {
        us_005_page.clickOnResetPassword();
    }

    @Then("US05 User should see the page {string}")
    public void usUserShouldSeeThePage(String pageTitle) {
        Assert.assertTrue( us_005_page.isPageTitleExist(pageTitle));
    }

    @When("US05 check the link to register a new account")
    public void usCheckTheLinkToRegisterANewAccount() {
        Assert.assertTrue(us_005_page.isLinkRegisterNewAccountExist());
    }

    @And("US05 click on the link to go to register page")
    public void usClickOnTheLinkToGoToRegisterPage() {
        us_005_page.clickOnRegisterNewAcc();
    }

    @And("US05 close the DRIVER")
    public void usCloseTheDRIVER() {
        Driver.wait(2);
        Driver.closeDriver();
    }
}
