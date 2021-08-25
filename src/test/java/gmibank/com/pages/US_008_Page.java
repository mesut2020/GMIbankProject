package gmibank.com.pages;


import gmibank.com.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_008_Page {
    public US_008_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement enterIcon;
    @FindBy(xpath = "//span[.='Sign in']")
    public WebElement signinLink;
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement signInButton;



    @FindBy(xpath = "//span[.='Password']")
    public WebElement passwordButton;

    @FindBy(xpath = "//input[@id='currentPassword']")
    public WebElement currentPasswordBox;

    @FindBy(xpath = "//input[@id='newPassword']")
    public WebElement newPasswordBox;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//li[@class='point']")
    public List<WebElement> passwordStrengthScala;

    @FindBy(xpath = "//span[.='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//strong[.='Password Changed']")
    public WebElement passwordChanged;


}