package gmibank.com.pages;

import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_014_Page {

    public US_014_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "li#account-menu")
    public WebElement profileMenuButton;

    @FindBy(css = "a#login-item")
    public WebElement profileMenuLoginButton;

    @FindBy(css = "input#username")
    public WebElement usernameTextBox;

    @FindBy(xpath ="//*[text()='My Operations']")
    public WebElement myOperationsButton;

    @FindBy(css = "a.dropdown-item:nth-child(2)")
    public WebElement manageAccountsButton;

    @FindBy(css = "a#jh-create-entity")
    public WebElement createNewaccountButton;

    @FindBy(css = "input#tp-account-createDate")
    public WebElement createDateTextBox;

    @FindBy(css = "input#tp-account-closedDate")
    public WebElement closedDateTextBox;

    @FindBy(css = ".text-danger.form-group:nth-child(5)")
    public WebElement createDateErrorFormat;

    @FindBy(css = ".text-danger.form-group:nth-child(5)")
    public WebElement closedDateErrorFormat;

    @FindBy(css = ".dropdown-item:nth-child(1)")
    public WebElement manageCustomerButton;

    @FindBy(css = "#jh-create-entity")
    public WebElement createCustomerButton;

    @FindBy(css = "#search-ssn")
    public WebElement ssnSearch;

    @FindBy(css = ".btn.btn-secondary")
    public WebElement searchButtonForSnn;

    @FindBy(css = "#tp-customer-firstName")
    public WebElement firstNameAfterSearch;

    @FindBy(xpath = "(//tbody//tr//td//a)[1]")
    public WebElement accountPageFirstID;

    @FindBy(xpath = "//h2//b")
    public WebElement firstAccountDetails;


    public void loginWith(String accountType){
        profileMenuButton.click();
        profileMenuLoginButton.click();
        switch (accountType){
            case "employee":
                String chord = Keys.chord(ConfigurationReader.getProperty("employee_username"), Keys.TAB,
                        ConfigurationReader.getProperty("employee_password"),Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
                usernameTextBox.sendKeys(chord);
                break;
            case "admin":
                String chord1 = Keys.chord(ConfigurationReader.getProperty("admin_username"), Keys.TAB,
                        ConfigurationReader.getProperty("admin_password"),Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
                usernameTextBox.sendKeys(chord1);
                break;

            case "demo":
                String chord2 = Keys.chord(ReusableMethods.fakeUserName, Keys.TAB,
                        ConfigurationReader.getProperty("Password"),Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
                usernameTextBox.sendKeys(chord2);
                break;
        }


    }


}
