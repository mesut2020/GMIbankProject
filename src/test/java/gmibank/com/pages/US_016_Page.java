package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class US_016_Page {

    public US_016_Page(){PageFactory.initElements(Driver.getDriver(),this);}

    WebDriver driver= Driver.getDriver();

    GmiSignInPage gmiSignInPage = new GmiSignInPage();

    WebElement myElement;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement submitButton;

    @FindBy(xpath ="//span[contains(text(),'Operations')]")
    private WebElement myOperationsDropDown;

    @FindBy(linkText = "My Accounts")
    private WebElement myAccounts;

    @FindAll({@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")})
    private List<WebElement> accounts;

    @FindBy(xpath ="//a[contains(text(),'Transfer Money')]")
    private WebElement transferMoney;

    @FindBy(xpath = "//select[@name='fromAccountId']")
    public WebElement fromAccount;

    @FindBy(xpath = "//select[@name='toAccountId']")
    public WebElement toAccount;

    @FindBy(xpath = "//input[@name='balance']")
    private WebElement balance;

    @FindBy(xpath = "//input[@name='balancecent']")
    private WebElement balanceCent;


    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement description;

    @FindBy(id = "make-transfer")
    private WebElement makeTransfer;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement succesfullMessage;



    public void goToSignInPage() {
        Driver.iAmOnHomePage();

    }


    public void clickToWebElement(String element){

        switch (element){case "submitButton": myElement=submitButton;break;

       case "myOperationsDropDown": myElement=myOperationsDropDown;break;

       case "myAccounts": myElement=myAccounts;break;

        case "transferMoney": myElement=transferMoney;break;

        case "fromAccount": myElement=fromAccount;break;

        case "toAccount": myElement=toAccount;break;

        case "balance": myElement=balance;break;

        case "description": myElement=description;break;

        case "makeTransfer": myElement=makeTransfer;break;}

        Driver.waitAndClick(myElement,2);
    }


    public void sendKeysToWebElement(String element, String value){


        switch (element){case "username": myElement=username;break;

        case "password": myElement= password;break;

        case "balance": myElement=balance;break;

        case "balanceCent": myElement=balanceCent;break;

        case "description": myElement=description;break;}


myElement.clear();

        Driver.waitAndSendText(myElement, value,2);

    }



    public boolean isAccountExist(String element){

//        System.out.println(accounts.size());
//        System.out.println(accounts.get(0).getText());

        return accounts.size()>=2;

    }

    public String selectFromAccount(String element,String text){
        Driver.wait(2);

        Select selectFromAccount=new Select(fromAccount);
        selectFromAccount.selectByValue(text);


return text;

    }
    public String selectToAccount(String element,String text){
        Driver.wait(2);

        Select selectToAccount=new Select(toAccount);
        selectToAccount.selectByValue(text);
        // selectAccount.selectByVisibleText(text);


        return text;

    }


    public boolean verifyText(String element, String message){
Driver.waitForVisibility(succesfullMessage,2);

        System.out.println(succesfullMessage.getText()+ ":"+ message);

        if (succesfullMessage.getText().contains(message)) return true;

       else return false;
    }
}
