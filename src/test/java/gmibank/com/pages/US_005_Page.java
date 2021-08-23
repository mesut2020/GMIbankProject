package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_005_Page extends ReusableMethods {

    public US_005_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    GmiSignInPage gmiSignInPage = new GmiSignInPage();


    @FindBy(css = "div.alert>span>strong")
    private WebElement errorMessageEl;

    @FindBy(css = "a[href='/account/reset/request']>span")
    private WebElement resetPasswordLink;

    @FindBy(css = "h1>span")
    private WebElement pageTitleEl;

    @FindBy(css = "a[href='/account/register']>span")
    private WebElement registerNewAccountLink;

    public void goToSignInPage(){
        Driver.iAmOnHomePage();
    }

    public void typeUserName(String username){
        Driver.waitAndSendText(gmiSignInPage.username, username, 5);
    }

    public void typePassword(String password){
        Driver.waitAndSendText(gmiSignInPage.password, password, 5);
    }

    public void clickOnSubmitButton(){
        Driver.waitAndClick(gmiSignInPage.submit, 5);
    }

    public boolean isErrorMessageExist(String errorMessage){
        return waitForVisibility(errorMessageEl, 5).getText().equals(errorMessage);
    }

    public boolean isLinkResetPassExist(){
        return waitForVisibility(resetPasswordLink,5).isDisplayed();
    }

    public void clickOnResetPassword(){
        Driver.clickWithJS(resetPasswordLink);
    }

    public void clickOnRegisterNewAcc(){
        Driver.clickWithJS(registerNewAccountLink);
    }

    public boolean isPageTitleExist(String pageTItle){
        return waitForVisibility(pageTitleEl, 5).getText().equals(pageTItle);
    }

    public boolean isLinkRegisterNewAccountExist(){
        return registerNewAccountLink.isEnabled();
    }
}
