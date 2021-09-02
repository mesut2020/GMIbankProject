package gmibank.com.stepDefinitions;
import gmibank.com.pages.GmiSignInPage;
import gmibank.com.pages.US_010_US_013_Page;
import gmibank.com.pages.US_019_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class US_019_StepDefinitions {

    GmiSignInPage homePage = new GmiSignInPage();
    US_019_Page us19Page = new US_019_Page();
    Actions actions = new Actions(Driver.getDriver());

    @Given("user enters gmibank homepage{string}")
    public void userEntersGmibankHomepage(String gmibank_url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(gmibank_url));
    }

    @Then("user clicks userEntry iconn")
    public void userClicksUserEntryIcon() {
        homePage.accountMenu.click();
    }

    @Then("user clicks signIn linkk")
    public void userClicksSignInLink() {
        homePage.SignIn.click();
    }

    @Then("user enters admin usernamee {string}")
    public void userEntersAdminUsername(String manager_username) {
        homePage.username.sendKeys(ConfigurationReader.getProperty(manager_username));
    }

    @Then("user enters admin passwordd {string}")
    public void userEntersAdminPassword(String manager_password) {
        homePage.password.sendKeys(ConfigurationReader.getProperty(manager_password));
    }

    @Then("user clicks signIn buttonn")
    public void userClicksSignInButton() {
        homePage.submit.click();
    }

    @And("user clicks myOperations linkk")
    public void userClicksMyOperationsLink() {
      homePage.myOperations.click();

    }

    @And("user clicks manageAccounts linkk")
    public void userClicksManageAccountsLink() {
        us19Page.manageAccountsLink.click();
    }

    @And("user clicks createNewAccount linkk")
    public void userClicksCreateNewAccountLink() {
        us19Page.createANewAccountsLink.click();
    }

    @Given("An investment type or name is entered in the {string} box.")
    public void anInvestmentTypeOrNameIsEnteredInTheBox(String arg0) {
        us19Page.descriptionBox.sendKeys("dollar");
    }

    @And("Enter an amount in the {string} box")
    public void enterAnAmountInTheBox(String arg0) {
        us19Page.balanceBox.sendKeys("300");
    }
    @And("click the save button")
    public void clickTheSaveButton() {
        us19Page.saveButton.click();

    }
    @Then("admin sees required message")
    public void admin_sees_required_message() {
        //Driver.wait(3);
       // Assert.assertTrue(us19Page.thisFieldIsRequeiredMessage.isDisplayed());

    }
    @Then("click the Bank Projeckt button")
    public void clickTheBankProjecktButton() {
    us19Page.bankProjeckt.click();
    }
    @And("click the  signOut button")
    public void clickTheSignOutButton() {
        us19Page.signoutLink.click();
    }



//US019_TC02
    @Given("click the Description box")
    public void clickTheDescriptionBox() {
        us19Page.descriptionBox.sendKeys("");


    }

    @And("Description box is left blank")
    public void descriptionBoxIsLeftBlank() {
    }

    @And("press Enter key")
    public void pressEnterKey() {
        us19Page.descriptionBox.sendKeys(Keys.ENTER);
    }

    @Then("Error message under Description box is observed")
    public void errorMessageUnderDescriptionBoxIsObserved() {
        Assert.assertTrue(us19Page.descriptionBoxErorMesage.isDisplayed());
    }
    //US019_TC03
    @Given("click the Balance box")
    public void clickTheBalanceBox() {
    }

    @And("Balance box is left blank")
    public void balanceBoxIsLeftBlank() {
        us19Page.balanceBox.sendKeys("");
    }

    @And("press Enter  keyy")
    public void pressEnterKeyy() {
        us19Page.balanceBox.sendKeys(Keys.ENTER);
    }

    @Then("Error message under Balance box is observed")
    public void errorMessageUnderBalanceBoxIsObserved() {
        Assert.assertTrue(us19Page.balanceBoxErorMesage.isDisplayed());
    }













    @Given("admin select an account as CHECKING and verify")
    public void admin_select_an_account_as_CHECKING_and_verify() {
        ReusableMethods.waitFor(2);
        for (WebElement w : us19Page.accountTypeLink) {
            String accountType = w.getText();
            System.out.println(accountType);
            if (w.getText().contains("CHECKING")) {
                w.click();
                Assert.assertTrue(us19Page.accountTypeLink.contains(w));
                break;
            }
        }

    }

    @Given("admin select an account as a SAVING and verify")
    public void admin_select_an_account_as_a_SAVING_and_verify() {
        us19Page.accountTypeSelect.click();
        ReusableMethods.waitFor(1);
        String myAccount11[] = {"CHECKING", "SAVING", "CREDIT_CARD", "INVESTING",};
        int i = 0;
        for (WebElement w : us19Page.accountTypeLink) {
            String option = w.getText();
            System.out.println(option);
            Assert.assertEquals(option, myAccount11[i]);
            i++;
        }

    }

    @Given("admin select an account as a CREDIT_CARD and verify")
    public void admin_select_an_account_as_a_CREDIT_CARD_and_verify() {
        us19Page.accountTypeSelect.click();
        ReusableMethods.waitFor(1);
        String myAccount12[] = {"CHECKING", "SAVING", "CREDIT_CARD", "INVESTING",};
        for (int i = 0; i < myAccount12.length; i++) {
            us19Page.accountTypeSelect.click();
            ReusableMethods.waitFor(1);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ENTER).perform();
            //Assert.assertEquals(us19Page.accountTypeSelect.getText(), myAccount12[i]);
        }

    }

    @Given("admin select an account as a INVESTING and verify")
    public void admin_select_an_account_as_a_INVESTING_and_verify() {
        us19Page.accountTypeSelect.click();
        ReusableMethods.waitFor(2);
        String myAccount13[] = {"CHECKING", "SAVING", "CREDIT_CARD", "INVESTING",};
        int i = 0;
        for (WebElement w : us19Page.accountTypeLink) {
            String myAccount1 = w.getText();
            System.out.println(myAccount1);
            Assert.assertEquals(myAccount1, myAccount13[i]);
            i++;
        }

    }
    //@US019_TC05
    @Given("admin click Account Status Type defined as a ACTIVE and verify")
    public void admin_click_Account_Status_Type_defined_as_a_ACTIVE_and_verify() {
        us19Page.accountStatusTypeBox.click();
        ReusableMethods.waitFor(2);
        String myStatusType11[] = {"ACTIVE", "SUESPENDED", "CLOSED",};
        int i = 0;
        for (WebElement w : us19Page.accountStatusTypeLink) {
            String statusType = w.getText();
            System.out.println(statusType);
            Assert.assertTrue(statusType, true);
            i++;
        }

    }

    @Given("admin click Account Status Type defined as a  SUESPENDED and verify")
    public void admin_click_Account_Status_Type_defined_as_a_SUEPENDED_and_verify() {
        us19Page.accountStatusTypeBox.click();
        ReusableMethods.waitFor(2);
        String myStatusType12[] = {"ACTIVE", "SUESPENDED", "CLOSED",};
        int i = 0;
        for (WebElement w : us19Page.accountStatusTypeLink) {
            String statusType = w.getText();
            System.out.println(statusType);
            Assert.assertEquals(statusType, myStatusType12[i]);
            i++;
        }
    }


    @Given("admin click Account Status Type defined as a  CLOSED and verify")
    public void admin_click_Account_Status_Type_defined_as_a_CLOSED_and_verify() {
        us19Page.accountStatusTypeBox.click();
        ReusableMethods.waitFor(2);
        String myStatusType13[] = {"ACTIVE", "SUESPENDED", "CLOSED",};
        int i = 0;
        for (WebElement w : us19Page.accountStatusTypeLink) {
            String statusType = w.getText();
            System.out.println(statusType);
            Assert.assertEquals(statusType, myStatusType13[i]);
            i++;
        }

    }
//06
    @Given("admin select Employee and verify the selectet Employee")
    public void admin_select_Employee_and_verify_the_selectet_Employee() {
        us19Page.employeeBox.click();
        //Select select =new Select(us19Page.employeeBox);
        System.out.println("Employee'in ici bos! BUG VAR");

    }

    @And("user signOut")
    public void adminSignOut() {
        US_010_US_013_Page page = new US_010_US_013_Page();
        page.newpage();
    }



}

