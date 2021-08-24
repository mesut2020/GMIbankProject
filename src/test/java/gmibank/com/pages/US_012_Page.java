package gmibank.com.pages;

import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_012_Page {

    public US_012_Page(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    WebDriver driver = Driver.getDriver();
    GmiSignInPage gmiSignInPage = new GmiSignInPage();

    @FindBy(xpath = "(//a[@role='menuitem'])[1]")
    public WebElement manageCustomer;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[12]")
    public WebElement viewButtonAnyCustomer;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])")
    public WebElement editButton;

    @FindBy(xpath = "//h2/span")
    public WebElement viewSayfasi;

    @FindBy(id = "gmibankfrontendApp.tPCustomer.home.createOrEditLabel")
    public WebElement editSayfasi;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement anyCustomerEditButton;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement eMail;

    @FindBy(id= "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div[1]")
    public WebElement toastMessage;

    @FindBy(xpath = "//a[@class='btn btn-danger btn-sm']")
    public WebElement deleteButton;

    @FindBy(css = "body > div:nth-child(12) > div > div.modal.fade.show > div > div > div.modal-header > h5 > span")
    public WebElement confirmMessage;

    @FindBy(xpath = "(//span[@aria-hidden='true'])[3]")
    public WebElement closeButton;

    @FindBy(id = "jhi-confirm-delete-tPCustomer")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    public WebElement viewButtonSayi;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement viewSayfasiEdit;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='tp-customer-email']")
    public WebElement customerMail;

    @FindBy(xpath = "//input[@id='tp-customer-state']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='tp-customer-middleInitial']")
    public WebElement im;






    public void goUrl(){
        Driver.iAmOnHomePage();
    }
    public void employee(){
        Driver.waitAndSendText(gmiSignInPage.username, ConfigurationReader.getProperty("employee_username"),2);
        Driver.waitAndSendText(gmiSignInPage.password, ConfigurationReader.getProperty("employee_password"),2);
        Driver.waitAndClick(gmiSignInPage.submit,2);
    }
    public void operationLink(){
        gmiSignInPage.myOperations.click();
    }
    public List<String> expectedElementList = Arrays.asList("ID", "First Name","Last Name","Middle Initial","Email","Mobile Phone Number","Phone Number","Address","Create Date");

    public List<String> actualElementlist(){
        List<String> actualElementList = new ArrayList<>();
        for (int i = 1; i <= expectedElementList.size(); i++) {
            String eachElementLocator = "thead > tr > th:nth-child("+i+") > span";
            String eachElement = Driver.getDriver().findElement(By.cssSelector(eachElementLocator)).getText();
            actualElementList.add(eachElement);
        }
        return actualElementList;
    }
    public void saveButtonClick(){
        Driver.clickWithJS(saveButton);
    }
    public void deleteButtonClick(){
        Driver.clickWithJS(deleteButton);
    }
    public void editButtonClick(){
       Driver.clickWithJS(viewSayfasiEdit);
   }




}


