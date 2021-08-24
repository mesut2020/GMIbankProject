package gmibank.com.pages;

import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmiSignInPage {

    public GmiSignInPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css ="#account-menu")
    public WebElement accountMenu;

    @FindBy(id="login-item")
    public WebElement SignIn;

    @FindBy(xpath = "//input[contains(@id,'username')]")
    public WebElement username;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    public WebElement password;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath ="//span[contains(text(),'Operations')]")
    public WebElement myOperations;

    @FindBy(xpath =" //*[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy (css = "#account-menu > a > span")
    public WebElement accountMenu1;

    @FindBy(css = "#account-menu > div > a:nth-child(1) > span")
    public WebElement userInfo;

    public void userLogin () {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
        accountMenu.click();
        SignIn.click();
        username.sendKeys(ConfigurationReader.getProperty("user_username"));
        password.sendKeys(ConfigurationReader.getProperty("user_password"));
        submit.click();
        accountMenu1.click();
        userInfo.click();

    }

}
