package gmibank.com.stepDefinitions;

import com.github.javafaker.Faker;
import gmibank.com.pages.US_004_Page;
import gmibank.com.pages.US_017_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class US_017_StepDefinitions {

    US_017_Page us_017_page = new US_017_Page();

    @And("user click on Administration > User Mangement  on Header")
    public void userClickOnAdministrationUserMangementOnHeader() {
        us_017_page.administrationButton.click();
        us_017_page.userManagementButton.click();
    }

    @And("user click on Create a new user button on Management page")
    public void userClickOnCreateANewUserButtonOnManagementPage() {
        us_017_page.createANewUserButton.click();
    }

    @And("user fill in Login, First name, Last name and email fields")
    public void user_fill_in_login_first_name_last_name_and_email_fields() {
        Faker faker = new Faker();
        String loginName = faker.name().username();
        us_017_page.loginNameBox.sendKeys(loginName);
        us_017_page.nameBox.sendKeys(faker.name().firstName());
        us_017_page.surnameBox.sendKeys(faker.name().lastName());
        us_017_page.emailBox.sendKeys(faker.internet().emailAddress());

    }

    @And("user select {string} on profiles section")
    public void user_select_on_profiles_section(String role) {
        Select select = new Select(us_017_page.profilesOptions);
        switch (role) {
            case "ROLE_USER":
                select.selectByValue("ROLE_USER");
                break;
            case "ROLE_EMPLOYEE":
                select.selectByValue("ROLE_EMPLOYEE");
                break;
            case "ROLE_MANAGER":
                select.selectByValue("ROLE_MANAGER");
                break;
            case "ROLE_ADMIN":
                select.selectByValue("ROLE_ADMIN");
                break;
        }
    }

    @And("user click on Save button")
    public void user_click_on_save_button() {
        us_017_page.saveButton.click();

    }

    @Then("user verifies Success message")
    public void userVerifiesSuccessMessage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(us_017_page.succesText.getText().contains("is created with identifier"));
    }

    @And("user clicks on createDate sort sorting button")
    public void userClicksOnCreateDateSortSortingButton() {
        us_017_page.createDateSortButton.click();
    }

    @And("user finds customer {string} and activates user")
    public void userFindsCustomerAndActivatesUser(String customer) {

        if (us_017_page.activatedUser(ReusableMethods.fakeUserName).getText().equals("Deactivated")) {
            us_017_page.activatedUser(ReusableMethods.fakeUserName).click();
        }
//        if (us_017_page.activatedUser(ConfigurationReader.getProperty(customer)).getText().equals("Deactivated")) {
//            us_017_page.activatedUser(ConfigurationReader.getProperty(customer)).click();
//        }
    }

    public void createAccount(String description){




    }
}
