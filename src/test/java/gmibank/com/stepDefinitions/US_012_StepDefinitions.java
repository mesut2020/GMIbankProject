package gmibank.com.stepDefinitions;

import gmibank.com.pages.GmiSignInPage;
import gmibank.com.pages.US_012_Page;
import gmibank.com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class US_012_StepDefinitions {

    US_012_Page us_012_page=new US_012_Page();

    @Given("User navigate to the LinnBank homepage")
    public void userNavigateToTheLinnBankHomepage() {
        us_012_page.goUrl();

    }
    @And("User login as a employee")
    public void userLoginAsAEmployee() {
        us_012_page.employee();

    }
    @And("Click on myOperations link")
    public void clickOnMyOperationsLink() {
        us_012_page.operationLink();

    }
    @And("Click on manageCustomers link")
    public void clickOnManageCustomersLink() {
        us_012_page.manageCustomer.click();
    }


    @Given("the Employee should see the First Name")
    public void theEmployeeShouldSeeTheFirstName() {

    }

    @And("the Employee should see the Last Name")
    public void theEmployeeShouldSeeTheLastName() {
    }

    @And("the Employee should see the Middle Initial")
    public void theEmployeeShouldSeeTheMiddleInitial() {
    }

    @And("the Employee should see the E-mail")
    public void theEmployeeShouldSeeTheEMail() {
    }

    @And("the Employee should see the Mobile Phone Number")
    public void theEmployeeShouldSeeTheMobilePhoneNumber() {
    }

    @And("the Employee should see the Phone Number")
    public void theEmployeeShouldSeeThePhoneNumber() {
    }

    @And("the Employee should see the Address")
    public void theEmployeeShouldSeeTheAddress() {
    }

    @Then("the Employee should see the Create Date")
    public void theEmployeeShouldSeeTheCreateDate() {
    }
}
