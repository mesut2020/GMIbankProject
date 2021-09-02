package gmibank.com.pages;

import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_010_US_013_Page extends ReusableMethods {
    public US_010_US_013_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriver driver = Driver.getDriver();
    GmiSignInPage gmiSignInPage = new GmiSignInPage();
    @FindBy(css = "li#account-menu > a > svg[role='img'] > path")
    public WebElement icon;

    @FindBy(css = "li#entity-menu > a > span")
    public WebElement my_operations;

    @FindBy(css = "li#entity-menu > div > a:nth-of-type(1) > span")
    public WebElement manageCustomers;

    @FindBy(css = "li#entity-menu > div > a:nth-of-type(2) > span")
    public WebElement manageAccount;

    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement createnewaccount;

    @FindBy(id = "tp-account-description")
    public WebElement description;

    @FindBy(id = "tp-account-balance")
    public WebElement balance;

    @FindBy(id = "tp-account-accountType")
    public WebElement accountType;

    @FindBy(id = "tp-account-accountStatusType")
    public WebElement accountStatus;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(id = "jh-create-entity")
    public WebElement createnewcustomer;

    @FindBy(id = "search-ssn")
    public WebElement searchSSN;

    @FindBy(id = "tp-customer-firstName")
    public WebElement firstName;

    @FindBy(id = "tp-customer-lastName")
    public WebElement lastName;

    @FindBy(id = "tp-customer-middleInitial")
    public WebElement midinitial;

    @FindBy(id = "tp-customer-email")
    public WebElement email;

    @FindBy(id = "tp-customer-mobilePhoneNumber")
    public WebElement mobilePhoneNumber;

    @FindBy(id = "tp-customer-phoneNumber")
    public WebElement phoneNumber;

    @FindBy(id = "tp-customer-zipCode")
    public WebElement zipCode;

    @FindBy(id = "tp-customer-address")
    public WebElement address;

    @FindBy(id = "tp-customer-city")
    public WebElement city;

    @FindBy(id = "tp-customer-ssn")
    public WebElement ssnn;

    @FindBy(id = "tp-customer-country")
    public WebElement countrytab;

    @FindBy(id = "tp-customer-state")
    public WebElement state;

    @FindBy(id = "tp-customer-zelleEnrolled")
    public WebElement zellebutton;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement error;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement errorline;

    @FindBy(css = "button#save-entity > span")
    public WebElement save;

    @FindBy(css = "li#account-menu > a > span")
    public WebElement menu;

    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signout;

    public void login() {
        icon.click();
        gmiSignInPage.SignIn.click();
        gmiSignInPage.username.sendKeys(ConfigurationReader.getProperty("employee_username"));
        gmiSignInPage.password.sendKeys(ConfigurationReader.getProperty("employee_password"));
        gmiSignInPage.submit.click();
    }

    public void newpage() {
        menu.click();
        signout.click();

    }
}
