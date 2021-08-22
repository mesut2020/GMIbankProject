package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_004_Page {
        public US_004_Page() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(id = "account-menu")
        public WebElement accountmenu;
        @FindBy (id = "login-item")
        public WebElement login;
        @FindBy(id = "username")
        public WebElement usernameBox;

        @FindBy(id = "password")
        public WebElement passwordBox;
        @FindBy (xpath = "//*[@class='btn btn-primary']")
        public WebElement signinButton;
        @FindBy (xpath = "//*[@class='btn btn-secondary']")
        public WebElement cancelbutton;

        @FindBy (css = "#header-tabs li")
        public List <WebElement> headerTabs;

    }
