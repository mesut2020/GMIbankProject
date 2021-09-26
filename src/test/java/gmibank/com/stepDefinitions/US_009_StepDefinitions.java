package gmibank.com.stepDefinitions;

import gmibank.com.pages.GmiSignInPage;
import gmibank.com.pages.US_009_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class US_009_StepDefinitions {

    US_009_Page us_009_page = new US_009_Page();
    GmiSignInPage gmiSignInPage = new GmiSignInPage();
    Actions action = new Actions(Driver.getDriver());

        @Given("I sign in as an employee with the given data")
        public void iSignInAsAnEmployeeWithTheGivenData() {
            Driver.loginAll("employee");
        }

        @And("I click on My Operations button located on the top navigation bar")
        public void i_click_on_my_operations_button_located_on_the_top_navigation_bar() {
          us_009_page.myOperations.click();
        }
        @Then("I hover over to Manage Customers")
        public void i_hover_over_to_manage_customers() {
            us_009_page.manageCustomers.click();
        }
        @And("I click on Create a new Customer button")
        public void i_click_on_create_a_new_customer_button() {
            us_009_page.createNewCustomer.click();
        }

        @And("I type given {string} into SSN box and click Search button")
         public void iTypeGivenIntoSSNBoxAndClickSearchButton(String SSN) throws InterruptedException {
        us_009_page.searchSSN.sendKeys(ReusableMethods.randomSSN);
        us_009_page.searchButton.click();
            Driver.waitForPageToLoad(2000);
            Thread.sleep(4000);
        }

        @Then("I should be able to list customer's all data.")
        public void i_should_be_able_to_list_customer_s_all_data() {
            /*
            System.out.println("First Name : " + us_009_page.firstName.getAttribute("value"));
            System.out.println("Last Name : " + us_009_page.lastName.getAttribute("value"));
            System.out.println("Middle Initial" + us_009_page.middleInitial.getAttribute("value"));
            System.out.println("Email : " + us_009_page.emailBox.getAttribute("value"));
            System.out.println("Mobile : " + us_009_page.mobilePhoneNumber.getAttribute("value"));
            System.out.println("Phone number : " + us_009_page.phoneNumber.getAttribute("value"));
            System.out.println("Zipcode : " + us_009_page.zipCode.getAttribute("value"));
            System.out.println("Address  : " + us_009_page.addressBox.getAttribute("value"));
            System.out.println("City : " + us_009_page.city.getAttribute("value"));
            System.out.println("SSN : " + us_009_page.ssnBox.getAttribute("value"));
            System.out.println("Create Date : " + us_009_page.createDate.getAttribute("value"));
            System.out.println("Country : " + us_009_page.countryDropdown.getAttribute("value"));
            System.out.println("State : " + us_009_page.stateBox.getAttribute("value"));
            System.out.println("User : " + us_009_page.userDropdown.getAttribute("value"));
            System.out.println("Account : " + us_009_page.account.getAttribute("value"));
            */
                Assert.assertNotNull(us_009_page.ssnBox.getAttribute("value"));

        }


    @And("user fills required areas")
    public void userFillsRequiredAreas() {

        String chord = Keys.chord("Ahmet",Keys.TAB,Keys.TAB,Keys.TAB,"254-254-8526",Keys.TAB,
                "10003",Keys.TAB,Keys.TAB,"New York");
        us_009_page.middleInitial.sendKeys(chord);
        us_009_page.countryDropdown.sendKeys("USA");
        us_009_page.stateBox.sendKeys("NY");
        action.click(us_009_page.account1(ReusableMethods.randomAccount_1)).
                keyDown(Keys.CONTROL).click(us_009_page.account1(ReusableMethods.randomAccount_2)).perform();
        action.keyUp(Keys.CONTROL).perform();
        us_009_page.saveButton.click();
        ReusableMethods.waitFor(5);





    }
}

