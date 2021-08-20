package gmibank.com.pages;

import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_012_Page {

    public US_012_Page(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    WebDriver driver = Driver.getDriver();
    GmiSignInPage gmiSignInPage = new GmiSignInPage();

    @FindBy(xpath = "(//a[@role='menuitem'])[1]")
    public WebElement manageCustomer;

    public void goUrl(){
        Driver.iAmOnHomePage();
    }
    public void employee(){
        Driver.waitAndSendText(gmiSignInPage.username, ConfigurationReader.getProperty("employee_username"),2);
        Driver.waitAndSendText(gmiSignInPage.password, ConfigurationReader.getProperty("employee_password"),2);
        Driver.waitAndClick(gmiSignInPage.submit,2);
    }
    public void operationLink(){
        gmiSignInPage.myOperations.click();
    }

}

