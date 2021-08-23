package gmibank.com.stepDefinitions;

import gmibank.com.pages.GmiSignInPage;
import gmibank.com.pages.US_012_Page;
import gmibank.com.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

import java.util.List;

public class US_012_StepDefinitions {

    US_012_Page us_012_page = new US_012_Page();

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



    @Given("Employee should see and click on the view")
    public void employeeShouldSeeAndClickOnTheView() {
        List<WebElement> viewButton = Driver.getDriver().findElements(By.xpath("//a[@class='btn btn-info btn-sm']"));
        System.out.println(viewButton.size());
        //Assert.assertTrue(us_012_page.viewButton.isEnabled());
        int expectedSize = 20;
        Assert.assertEquals(expectedSize, viewButton.size());
        us_012_page.viewButtonSayi.click();
        Assert.assertTrue(us_012_page.viewSayfasi.isDisplayed());

    }

    @Then("Employee should see and click Edit button")
    public void employeeShouldSeeAndClickEditButton() {
//        Assert.assertTrue(us_012_page.editButton.isEnabled());
        Driver.getDriver().navigate().back();
        us_012_page.editButton.click();
        Assert.assertTrue(us_012_page.editSayfasi.isDisplayed());
    }

    @And("Employee should click on the View button for any customer")
    public void employeeShouldClickOnTheViewButtonForAnyCustomer() throws InterruptedException {
        us_012_page.viewButtonAnyCustomer.click();
        Thread.sleep(3000);

    }

    @And("Employee should click on the Edit button")
    public void employeeShouldClickOnTheEditButton() throws InterruptedException {
        // Driver.scrollToElement(us_012_page.viewSayfasiEdit);
        us_012_page.editButtonClick();
        Thread.sleep(3000);


    }

    @Then("Employee should check all customer information can be populated")
    public void employeeShouldCheckAllCustomerInformationCanBePopulated() throws InterruptedException {
         String expectedIm= "MI";
         String expectedCustomerState="TURKEY";
         String expectedCustomerEmail="democustomer004@gmail.com";
         String actualIm= us_012_page.im.getAttribute("value");
         String actualCustomerState=us_012_page.state.getAttribute("value");
         String actualCustomerEmail=us_012_page.eMail.getAttribute("value");

      Assert.assertEquals(expectedIm,actualIm);
      Assert.assertEquals(expectedCustomerState,actualCustomerState);
      Assert.assertEquals(expectedCustomerEmail,actualCustomerEmail);


    }

    @Given("Employee should write a new  Email address")
    public void employeeShouldWriteANewEmailAddress() throws InterruptedException {
        Thread.sleep(3000);
        JSExecutor.scrollInToViewJS(us_012_page.eMail);
        Thread.sleep(3000);
        us_012_page.eMail.clear();
        Driver.waitAndSendText(us_012_page.eMail, ConfigurationReader.getProperty("updateMail"), 2);


    }

    @And("Employee should click Save button")
    public void employeeShouldClickSaveButton() throws InterruptedException {
        Thread.sleep(3000);
        //Driver.scrollToElement(us_012_page.saveButton);
        us_012_page.saveButtonClick();
        Thread.sleep(3000);
    }

    @Then("Employee should verifies translation not found[gmiBankBackendApp.tPCustomer.updated")
    public void employeeShouldVerifiesTranslationNotFoundGmiBankBackendAppTPCustomerUpdated() throws InterruptedException {


        String actualMessage = us_012_page.toastMessage.getText();

        System.out.println("actual message:" + actualMessage + ".");
        String expectedMessage = "translation-not-found[gmiBankBackendApp.tPCustomer.updated]";

        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @Given("Employee should see and click Delete button")
    public void employeeShouldSeeAndClickDeleteButton() {
        us_012_page.deleteButtonClick();
    }

    @And("Employee should delete a customer")
    public void employeeShouldDeleteACustomer() {
        us_012_page.confirmDeleteButton.click();
    }

    @Given("Employee should see and click Edit button for any customer")
    public void employeeShouldSeeAndClickEditButtonForAnyCustomer() throws InterruptedException {
        us_012_page.anyCustomerEditButton.click();
        Thread.sleep(3000);
    }

    @And("Employee should verifies  message")
    public void employeeShouldVerifiesMessage() throws InterruptedException {

        String expected = "Confirm delete operation";

        Thread.sleep(3000);

        String actual = us_012_page.confirmMessage.getText();
        System.out.println(actual);
        Assert.assertEquals(expected, actual);

    }


    @And("User should close the DRIVER")
    public void userShouldCloseTheDRIVER() {
        Driver.wait(2);
        Driver.closeDriver();
    }

    @Then("Checked all customer information was filled")
    public void checkedAllCustomerInformationWasFilled() {
        Assert.assertEquals(us_012_page.expectedElementList, us_012_page.actualElementlist());
    }

    @Given("User select First Name, Last Name, Middle Initial, Email, Mobile Phone Number,Phone Number, Address, Date updated\"")
    public void userSelectFirstNameLastNameMiddleInitialEmailMobilePhoneNumberPhoneNumberAddressDateUpdated() throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }
}
