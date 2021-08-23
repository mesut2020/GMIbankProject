package gmibank.com.pages;

import gmibank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_011_Page {

    public US_011_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public  WebElement myOperationLink;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement manageCustomersLink;

    @FindBy(xpath = "//a[@class='btn btn-primary float-right jh-create-entity']")
    public WebElement createNewCustomerLink;

    @FindBy(id = "tp-customer-createDate")
    public WebElement createDateBox ;

    @FindBy (id = "tp-customer-user")
    public WebElement userDropdownBox;

    @FindBy (id = "tp-customer-account")
    public WebElement accountDropdownBox;

    @FindBy (id = "tp-customer-zelleEnrolled")
    public WebElement zelleEnrolledCheckBox;

    @FindBy(id="save-entity")
    public WebElement saveButton;


}
