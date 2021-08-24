package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_006_Page {
    public US_006_Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//span[contains(text(),'Team54 User')]")
       public WebElement usernameVerification;

    @FindBy(xpath = "//div[@class='modal-footer']//following::span")
    public WebElement signInButton;

    @FindBy(css = "(//*[@id='account-menu']//following::a)[1]")
    public WebElement userInfoButton;

    @FindBy(css = "#account-menu > div > a:nth-child(1) > span")
    public WebElement userInfo;

    @FindBy (css = "#account-menu > a > span")
    public WebElement accountMenu;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameBoxUserInfo;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameBoxUserInfo;

    @FindBy(css = "#email")
    public WebElement emailBoxUserInfo;

    @FindBy(xpath = "//select[@id='langKey']")
    public WebElement languageDropdownUserInfo;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButtonUserInfo;

    @FindBy(xpath="//div[@role='alert']//span//strong")
    public WebElement confirmationMessage;

    @FindBy(xpath = "//option[@value='en']")
    public WebElement englishOptionUserInfo;

    @FindBy(xpath = "//option[@value='tr']")
    public WebElement turkishOptionUserInfo;
}
