package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_006_Page {
    public US_006_Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id ="account-menu")
       public WebElement accountMenu;
    @FindBy (id = "login-item")
    public WebElement signIn;
    @FindBy (id = "username")
    public WebElement usernameBox;
    @FindBy (id = "password")
    public WebElement passwordBox;
    @FindBy(xpath = "//div[@class='modal-footer']//following::span")
    public WebElement signInButton;


}
