package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_009_Page {
        public US_009_Page (){
            PageFactory.initElements(Driver.getDriver(),this);
        }

    @FindBy(xpath = "//div[@class='modal-footer']//following::span")
    public WebElement signInButton;

    @FindBy (css = "#account-menu > a > span")
    public WebElement accountMenu;

    @FindBy(css = "#entity-menu > div > a:nth-child(2) > span")
    public WebElement manageAccounts;

    @FindBy(xpath = "//span[contains(text(),'Create a new Customer')]")
    public WebElement createNewCustomer;

    @FindBy(css = "#search-ssn")
    public WebElement searchSSN;

    @FindBy(css = "#entity-menu>a>span")
    public WebElement myOperations;

    @FindBy(css = "#entity-menu > div > a:nth-child(1) > span")
    public WebElement manageCustomers;

    @FindBy(css = ".btn.btn-secondary")
    public WebElement searchButton;

    @FindBy(name = "firstName")
    public WebElement firstName;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(name = "middleInitial")
    public WebElement middleInitial;

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(name = "mobilePhoneNumber")
    public WebElement mobilePhoneNumber;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumber;

    @FindBy(name = "zipCode")
    public WebElement zipCode;

    @FindBy(name = "address")
    public WebElement addressBox;

    @FindBy(name = "city")
    public WebElement city;

    @FindBy(name = "ssn")
    public WebElement ssnBox;

    @FindBy(name = "createDate")
    public WebElement createDate;

    @FindBy(name = "country.id")
    public WebElement countryDropdown;

    @FindBy(name = "state")
    public WebElement stateBox;

    @FindBy(name = "user.id")
    public WebElement userDropdown;

    @FindBy(id = "tp-customer-account")
    public WebElement account;

    @FindBy(id = "zelleEnrolledLabel")
    public WebElement zelleEnrolled;

    @FindBy(id = "cancel-save")
    public WebElement backButton;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy (xpath = "(//div[@class='col-md-8'])[2]")
    public WebElement form1;

    @FindBy (xpath = "//form[@class='av-invalid']")
    public WebElement form2;

    public WebElement account1(String account){

        return Driver.getDriver().findElement(By.xpath("//option[text()='" + account + "']"));
    }

    }
