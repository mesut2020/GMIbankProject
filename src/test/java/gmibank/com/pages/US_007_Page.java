package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class US_007_Page {

WebElement myElement;

    public US_007_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriver driver = Driver.getDriver();
    GmiSignInPage gmiSignInPage = new GmiSignInPage();

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement submitButton;

    @FindBy(id = "account-menu")
    private WebElement accountMenu;

    @FindBy(linkText = "User Info")
    private WebElement userInfo;

    @FindBy(id = "email")
    private WebElement eMail;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    private WebElement errorMessage;

@FindAll({@FindBy(xpath = "//select[@name='langKey']")})
    public List<WebElement> languageKey;



    public void goToSignInPage() {
        Driver.iAmOnHomePage();

    }

    public void clickToWebElement(String element){

        switch (element){case "submitButton": myElement=submitButton;break;

        case "accountMenu": myElement=accountMenu;break;

        case "userInfo": myElement=userInfo;break;

        case "eMail": myElement=eMail;break;

        case "languageKey": myElement=eMail;break;}


        Driver.waitAndClick(myElement,3);
    }



    public void sendKeysToWebElement(String element, String value){


        switch (element){case "username": myElement=username;break;

        case "password": myElement= password;break;

        case "email": myElement=eMail;break;}


myElement.clear();

        Driver.waitAndSendText(myElement, value,3);

    }



    public void verifyText(String element, String expectedMessage){

        //switch (element){case "errorMessage": myElement=errorMessage;break;}
String actualMessage=Driver.waitForVisibility(errorMessage,3).getText();
       // Assert.assertEquals(errorMessage.getText(),message);
Assert.assertEquals(expectedMessage,actualMessage);
    }


    public void selectWebElement(String options){

        for(WebElement element:languageKey){
            if(element.getText().contains(options)){
               element.click();
            }
        }
    }


    public boolean islanguageExist(String element){
        ArrayList<String> languageElement=new ArrayList<>(List.of("English","Turkish"));
        for (int i = 0; i < languageKey.size(); i++) {
if (languageElement.contains(languageKey.get(i))) return true;
else return false;
        }
        return true;

    }

}