package gmibank.com.stepDefinitions;

import gmibank.com.pages.US_010_US_013_Page;
import gmibank.com.pages.US_016_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class demo {
    US_010_US_013_Page us10page=new US_010_US_013_Page();
    US_016_Page us_016_page= new US_016_Page();
    @And("user applies for a registration")
    public void userAppliesForARegistration() {

    }

    @And("employee creates 2 brand new accounts")
    public void employeeCreatesBrandNewAccounts() {
        createAccount(ReusableMethods.getRandomAccount1());
        ReusableMethods.waitFor(4);
        createAccount(ReusableMethods.getRandomAccount2());

    }
    @Given("a little wait")
    public void a_little_wait() {
        ReusableMethods.waitFor(4);
    }

    public void createAccount(String descriptions){
        us10page.my_operations.click();
        us10page.manageAccount.click();
        us10page.createnewaccount.click();
        us10page.description.sendKeys(descriptions);
        us10page.balance.sendKeys("1000000");
        Select select=new Select(us10page.accountType);
        select.selectByVisibleText("CHECKING");
        Select select1=new Select(us10page.accountStatus);
        select1.selectByVisibleText("ACTIVE");
        us10page.saveButton.click();
        ReusableMethods.waitFor(5);
    }
    public void selectFromAccount(WebElement element, int index){
        Driver.wait(2);

        Select selectFromAccount=new Select(element);
        selectFromAccount.selectByIndex(index);


    }
}