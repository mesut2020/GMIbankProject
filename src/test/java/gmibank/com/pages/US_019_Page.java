package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_019_Page {

    public US_019_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[.='Manage Accounts']")
    public WebElement manageAccountsLink;

    @FindBy(xpath = "//span[.='Create a new Account']")
    public WebElement createANewAccountsLink;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "(//div[.='This field is required.'])[2]")
    public WebElement thisFieldIsRequeiredMessage;

    @FindBy(xpath = "//input[@name='balance']")
    public WebElement balanceBox;

    @FindBy(xpath = "//select[@name='accountType']")
    public WebElement accountTypeSelect;

    @FindBy(xpath = "//*[@id='tp-account-accountType']/option")
    public List<WebElement> accountTypeLink;

    @FindBy(xpath = "//*[@id='tp-account-accountStatusType']/option")
    public WebElement accountStatusTypeBox;

    @FindBy(xpath = "//*[@id='tp-account-accountStatusType']/option")
    public List<WebElement> accountStatusTypeLink;

    @FindBy(xpath = "//select[@name='employee.id']")
    public WebElement employeeBox;

    @FindBy(xpath = "(//a[@href='#'])[2]")
    public WebElement userInfoLink;

    @FindBy(xpath = "//span[.='Sign out']")
    public WebElement signoutLink;

}
