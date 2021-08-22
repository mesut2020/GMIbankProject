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

public class US_013_StepDefinitions {


    US_010_US_013_Page us10page=new US_010_US_013_Page();
    GmiSignInPage gmiSignInPage=new GmiSignInPage();

    @Then("hover over to Manage Account")
    public void hoverOverToManageAccount() {
        us10page.login();
        us10page.my_operations.click();
        us10page.manageAccount.click();
    }


    @And("click on Create a new Account")
    public void clickOnCreateANewAccount() {

        us10page.createnewaccount.click();
    }



    @Given("Type Balance")
    public void typeBalance() {
        us10page.balance.sendKeys("1000");
    }

    @And("Select Account Type")
    public void selectAccountType() {
        Select select=new Select(us10page.accountType);
        select.selectByVisibleText("CHECKING");
    }

    @And("Select Account Status")
    public void selectAccountStatus() {
        Select select=new Select(us10page.accountStatus);
        select.selectByVisibleText("ACTIVE");
    }

    @And("Click Save Button")
    public void clickSaveButton() {
        us10page.saveButton.click();
    }

    @Given("Type Description")
    public void typeDescription() {
        us10page.description.sendKeys("Holiday");
    }

    @Then("should be able to account type")
    public void shouldBeAbleToAccountType() {

        Assert.assertEquals("CHECKING",us10page.accountType.getAttribute("value"));

    }

    @Then("should be able to status type")
    public void shouldBeAbleToStatusType() {
        Assert.assertEquals("ACTIVE",us10page.accountStatus.getAttribute("value"));
    }

    @And("Select employee")
    public void selectEmployee() {
    }

    @Then("should be able to employee")
    public void shouldBeAbleToEmployee() {
    }
}
