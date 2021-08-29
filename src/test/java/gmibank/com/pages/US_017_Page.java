package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_017_Page {

        public US_017_Page(){
            PageFactory.initElements(Driver.getDriver(),this);
        }

        // @FindBy(xpath= "//*[@id=\"admin-menu\"]/a/span")
        //  @FindBy(xpath = "//*[@id=\"admin-menu\"]/a/span")
        //*[@id="admin-menu"]
        @FindBy(xpath = "//input[@name='username']")
        public WebElement userNameBox ;
        @FindBy(xpath = "//input[@name='password']")
        public WebElement passwordBox ;
        @FindBy(xpath = "//button[@type='submit']")
        public WebElement signInButton ;

        @FindBy(css= " #admin-menu")
        public WebElement administrationButton ;
        @FindBy(partialLinkText = "User management")
        public WebElement userManagementButton ;

        @FindBy(partialLinkText= "Create a new user")
        public WebElement createANewUserButton ;

        @FindBy (id = "authorities")
        public WebElement profilesOptions;

        @FindBy(xpath = "//input[@name='login']")
        public WebElement loginNameBox ;
        @FindBy(xpath = "//input[@name='firstName']")
        public WebElement nameBox ;
        @FindBy(xpath = "//input[@name='lastName']")
        public WebElement surnameBox ;
        @FindBy(xpath = "//input[@name='email']")
        public WebElement emailBox ;

        @FindBy(id= "langKey")
        public WebElement languageDropDown ;

        @FindBy(xpath = "//*[@id=\"authorities\"]/option[1]")
        public WebElement roleAdminOption ;
        @FindBy(xpath = "//*[@id=\"authorities\"]/option[2]")
        public WebElement roleUserOption ;
        @FindBy(xpath = "//*[@id=\"authorities\"]/option[3]")
        public WebElement roleEmployeeOption ;
        @FindBy(xpath = "//*[@id=\"authorities\"]/option[4]")
        public WebElement roleManagerOption ;
        @FindBy(xpath = "//*[@id=\"authorities\"]/option[5]")
        public WebElement roleCustomerOption ;

        //@FindBy(xpath = "//button[@type='submit']")
        //*[@id="app-view-container"]/div[1]/div/div/div/div[2]/div/form/button
        @FindBy(xpath = "//button[@type='submit']")
        public WebElement saveButton ;

        @FindBy(xpath = "//select[@id='authorities']")
        public WebElement selectButton ;
        @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
        public WebElement succesText ;

        @FindBy(xpath = "//thead//tr//th[7]")
        public WebElement createDateSortButton;


        public WebElement activatedUser(String user){

               WebElement element = Driver.getDriver().findElement(By.xpath("//tbody//tr[@id='"+user+"']//button[@type='button']"));
               return element;
        }





}
