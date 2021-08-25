package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_001_Page {



        public US_001_Page() {
            PageFactory.initElements(Driver.getDriver(),this);
        }
    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement icon;

    @FindBy(xpath = "//*[text()='Register']")
    public WebElement ilkRegisterButton;

    @FindBy(xpath = "(//*[text()='Sign in'])[1]")
    public WebElement signInButton;

    @FindBy(id = "ssn")
    public WebElement ssnTextBox;

    @FindBy(id = "firstname")
    public WebElement firstNameTextBox;

    @FindBy(id = "lastname")
    public WebElement lastNameTextBox;

    @FindBy(id = "address")
    public WebElement addressTextBox;

    @FindBy(id = "mobilephone")
    public WebElement mobilePhoneNumberTextBox;

    @FindBy(id = "username")
    public WebElement usernameTextBox;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "firstPassword")
    public WebElement firstPasswordTextBox;

    @FindBy(id = "secondPassword")
    public WebElement secondPasswordTextBox;

    @FindBy(id = "register-submit")
    public WebElement registerButton;

    @FindBy(xpath = "//*[text()='Registration saved!']")
    public WebElement succesfulRegisterMessage;

    @FindBy(xpath = "//div[@class='invalid-feedback'][1]")
    public WebElement ssnErrorMesage;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[2]/div")
    public WebElement firstNameErrorMesage;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[3]/div")
    public WebElement lastNameErrorMesage;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[5]/div")
    public WebElement mobilePhoneNumberErrorMesage;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[6]/div")
    public WebElement usernameErrorMesage;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[7]/div")
    public WebElement eMailErrorMesage;
    @FindBy(xpath = "//*[@id=\"register-form\"]/div[8]/div")
    public WebElement passwordErrorMesage;
    @FindBy(xpath = "//*[@id=\"register-form\"]/div[10]/div")
    public WebElement newPasswordConfirmationErrorMesage;
}
