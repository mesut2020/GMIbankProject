package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_015_Page {

    public US_015_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    GmiSignInPage gmiSignInPage = new GmiSignInPage();

    @FindBy(linkText = ("My Accounts"))
    private WebElement myAccountsLink;

    @FindAll({@FindBy(css = "table > tbody > tr > td:nth-child(1)")})
    private List<WebElement> customerAccountsList;

    @FindAll({@FindBy(css = "table > tbody > tr > td:nth-child(2)")})
    private List<WebElement> accountTypesList;

    @FindAll({@FindBy(css = "table > tbody > tr > td:nth-child(3)")})
    private List<WebElement> accountBalanceList;

    @FindAll({@FindBy(css = "button.btn")})
    private List<WebElement> viewTransactionButtons;

    @FindAll({@FindBy(css = " tbody > tr > td:nth-child(6)")})
    private List<WebElement> newBalance;

    @FindAll({@FindBy(xpath = "(//table[@class='table table-striped'])[2]/tbody/tr/td")})
    private List<WebElement> transInfo;


    public void signInAsCustomer() {
        Driver.loginAll("customer");
    }

    public void clickOnMyOperations() {
        Driver.waitAndClick(gmiSignInPage.myOperations, 5);
    }

    public void clickOnMyAccounts() {
        Driver.waitAndClick(myAccountsLink, 5);
    }

    public boolean isAccountTypeExist(){
        ArrayList<String> accountTypes = new ArrayList<>(List.of("CHECKING", "SAVING", "CREDIT_CARD", "INVESTING"));

        for (int i = 0; i < customerAccountsList.size(); i++) {
            if(!accountTypes.contains(accountTypesList.get(i).getText())) return false;
        }
        return true;
    }

    public boolean isNumber(String str){
        char[] ch=str.toCharArray();
        for (int i = 0; i <ch.length ; i++) {
            if(ch[i]!='.')
                if(ch[i]<48 || ch[i]>57)  return false;
        }
        return true;
    }

    public boolean isBalanceExist(){
        for (int i = 0; i < customerAccountsList.size(); i++) {
            if(!isNumber(accountBalanceList.get(i).getText())) return false;
        }
        return true;
    }

    public void printCustomerAccounts(){
        System.out.printf("%-10s%-10s%10s%n","ID","ACC.TYPE","BALANCE");
        System.out.printf("%-10s%-10s%10s%n","--","--------","-------");
        for (int i = 0; i < customerAccountsList.size() ; i++) {
            System.out.printf("%-10s%-10s%10s%n",customerAccountsList.get(i).getText(),accountTypesList.get(i).getText(),accountBalanceList.get(i).getText());
        }
    }

    public boolean clickOnViewTransactionButtons() {
        for (int i = 0; i < viewTransactionButtons.size(); i++) {
            Driver.waitAndClick(viewTransactionButtons.get(i), 5);
            if(!isTransactionExist(accountBalanceList.get(i).getText())) return false;
        }
        return true;
    }

    public boolean isTransactionExist(String balance){
        Driver.wait(1);
        printTransactions();
        int numberOfTransactions = newBalance.size();
        return newBalance.get(numberOfTransactions-1).getText().contains(balance);
    }

    public void printTransactions(){
        System.out.printf("%-10s%-10s%-40s%-30s%10s%15s%n","TR.ID","ACC.ID","DESCIPTION","DATE","AMOUNT","NEW BALANCE");
        System.out.printf("%-10s%-10s%-40s%-30s%10s%15s%n","-----","------","----------","----","------","-----------");
        int j=0;
        for (int i = 0; i < newBalance.size(); i++) {
            for (; j < transInfo.size(); j=j+6) {
                System.out.printf("%-10s%-10s%-40s%-30s%10s%15s%n"
                        ,transInfo.get(j).getText(),transInfo.get(j+1).getText(),transInfo.get(j+2).getText()
                        ,transInfo.get(j+3).getText(),transInfo.get(j+4).getText(),transInfo.get(j+5).getText());
            }
        }
        System.out.println();
    }

}
