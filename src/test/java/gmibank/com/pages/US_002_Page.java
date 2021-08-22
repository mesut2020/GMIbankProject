package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_002_Page {

    public US_002_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "li#account-menu")
    public WebElement profileMenuButton;

    @FindBy(css = "a.dropdown-item:nth-child(2)")
    public WebElement profileMenuRegistrationButton;

    @FindBy(css = "button#register-submit")
    public WebElement registrationPageRegisterButton;

    @FindBy(css = "div.invalid-feedback")
    public List<WebElement> errorMessages;

    @FindBy(css = "#ssn")
    public WebElement ssnTextBox;

    @FindBy(xpath= "(//div[@class='invalid-feedback'])[1]")
    public WebElement ssnErrorMessage;

    @FindBy(css = "#mobilephone")
    public WebElement mobilPhoneNumberTextBox;

    @FindBy(css= "div.invalid-feedback")
    public WebElement mobilePhoneNumbererrorMessage;

    @FindBy(css = "#email")
    public WebElement emailAddressTextBox;

    @FindBy(css = "div.invalid-feedback")
    public WebElement emailAddressErrorMessage;





}
