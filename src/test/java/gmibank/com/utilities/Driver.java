package gmibank.com.utilities;

import com.google.common.base.Function;
import gmibank.com.pages.GmiSignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Driver {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<String> browsers = new ThreadLocal<>();

    /**
     * this method returns the threadlocal webDriver
     * @return WebDriver
     */
    public static WebDriver getDriver(){

        if (browsers.get() == null){
            browsers.set("chrome");
        }

        if (driver.get() == null){
            switch (browsers.get()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "ie":
                case "internet explorer":
                    WebDriverManager.iedriver().setup();
                    driver.set(new InternetExplorerDriver());
                    break;
                case "edge":
                case "msedge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver.set(new OperaDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
            }

        }

        driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get().manage().window().maximize();

        return driver.get();
    }


    /**
     * quit the threadLocal WebDriver
     */
    public static void closeDriver(){
        if (driver.get() != null){
            driver.get().quit();
            driver.set(null);
        }
    }

    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    /**
     * Selects a random value from a dropdown list and returns the selected Web Element
     *
     * @param select
     * @return
     */
    public static WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);"
                ,element, attributeName, attributeValue);
    }

    /**
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param element
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param command
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);
    }

    public boolean isElementSelected(By locator) {
        return webAction(locator).isSelected();
    }

    public void sendValue(By locator, String value) {
        try {
            webAction(locator).sendKeys(value);
        } catch (Exception e) {
            System.out.println("Some exception occured while sending value" + locator);
        }

    }

    public static WebElement webAction(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds nut still could not find the element therefore TimeOutException has been thrown"
                );
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    public static void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }


    public static void waitAndSendText(WebElement element, String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public static String waitAndGetText(WebElement element, int timeout) {
        String text = "";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
        return null;
    }

    public static void loginEmployee(){
        GmiSignInPage gmiSignInPage=new GmiSignInPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
        Driver.waitAndClick(gmiSignInPage.accountMenu,2);
        Driver.waitAndClick(gmiSignInPage.SignIn,2);
        Driver.waitAndSendText(gmiSignInPage.username, ConfigurationReader.getProperty("employee_username"),2);
        Driver.waitAndSendText(gmiSignInPage.password, ConfigurationReader.getProperty("employee_password"),2);
        Driver.waitAndClick(gmiSignInPage.submit,2);
    }

    public static void loginAll(String role){
        GmiSignInPage gmiSignInPage=new GmiSignInPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
        Driver.waitAndClick(gmiSignInPage.accountMenu,2);
        Driver.waitAndClick(gmiSignInPage.SignIn,2);
        switch (role)
        {
            case "employee":
                Driver.waitAndSendText(gmiSignInPage.username, ConfigurationReader.getProperty("employee_username"),2);
                Driver.waitAndSendText(gmiSignInPage.password, ConfigurationReader.getProperty("employee_password"),2);
                Driver.waitAndClick(gmiSignInPage.submit,2);
                break;
            case "admin":
                Driver.waitAndSendText(gmiSignInPage.username, ConfigurationReader.getProperty("admin_username"),2);
                Driver.waitAndSendText(gmiSignInPage.password, ConfigurationReader.getProperty("admin_password"),2);
                Driver.waitAndClick(gmiSignInPage.submit,2);
                break;
            case "customer":
                Driver.waitAndSendText(gmiSignInPage.username, ConfigurationReader.getProperty("customer_username"),2);
                Driver.waitAndSendText(gmiSignInPage.password, ConfigurationReader.getProperty("customer_password"),2);
                Driver.waitAndClick(gmiSignInPage.submit,2);
                break;
            case "manager":
                Driver.waitAndSendText(gmiSignInPage.username, ConfigurationReader.getProperty("manager_username"),2);
                Driver.waitAndSendText(gmiSignInPage.password, ConfigurationReader.getProperty("manager_password"),2);
                Driver.waitAndClick(gmiSignInPage.submit,2);
                break;
            case "user":
                Driver.waitAndSendText(gmiSignInPage.username, ConfigurationReader.getProperty("user_username"),2);
                Driver.waitAndSendText(gmiSignInPage.password, ConfigurationReader.getProperty("user_password"),2);
                Driver.waitAndClick(gmiSignInPage.submit,2);
                break;
        }


    }

    public static void iAmOnHomePage() {
        GmiSignInPage gmiSignInPage = new GmiSignInPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
        Driver.waitAndClick(gmiSignInPage.accountMenu,3);
        Driver.waitAndClick(gmiSignInPage.SignIn,3);

    }
    public static void login (String role) {
        GmiSignInPage gmiSignInPage = new GmiSignInPage();
        if (role.equals("Employee")) {
            iAmOnHomePage();
            gmiSignInPage.username.sendKeys(ConfigurationReader.getProperty("employee_username"));
            gmiSignInPage.password.sendKeys(ConfigurationReader.getProperty("employee_password"));
            Driver.waitForVisibility(gmiSignInPage.cancelButton,5);
            Assert.assertTrue("Cancel button is  not avilable before submit button,test failed!",gmiSignInPage.cancelButton.isDisplayed());
            System.out.println("Cancel button is Displayed");
            gmiSignInPage.submit.click();
            Driver.wait(2);
            //Driver.closeDriver();
        } else if (role.equals("Admin")) {
            iAmOnHomePage();
            gmiSignInPage.username.sendKeys(ConfigurationReader.getProperty("admin_username"));
            gmiSignInPage.password.sendKeys(ConfigurationReader.getProperty("admin_password"));
            Driver.waitForVisibility(gmiSignInPage.cancelButton,5);
            Assert.assertTrue("Cancel button is  not avilable before submit button,test failed!",gmiSignInPage.cancelButton.isDisplayed());
            System.out.println("Cancel button is Displayed");
            gmiSignInPage.submit.click();
            Driver.wait(2);
            //Driver.closeDriver();
        } else if (role.equals("Customer")) {
            iAmOnHomePage();
            gmiSignInPage.username.sendKeys(ConfigurationReader.getProperty("customer_username"));
            gmiSignInPage.password.sendKeys(ConfigurationReader.getProperty("customer_password"));
            Driver.waitForVisibility(gmiSignInPage.cancelButton,5);
            Assert.assertTrue("Cancel button is  not avilable before submit button,test failed!",gmiSignInPage.cancelButton.isDisplayed());
            System.out.println("Cancel button is Displayed");
            gmiSignInPage.submit.click();
            Driver.wait(2);
            // Driver.closeDriver();
        }else if (role.equals("User")) {
            iAmOnHomePage();
            gmiSignInPage.username.sendKeys(ConfigurationReader.getProperty("user_username"));
            gmiSignInPage.password.sendKeys(ConfigurationReader.getProperty("user_password"));
            Driver.waitForVisibility(gmiSignInPage.cancelButton,5);
            Assert.assertTrue("Cancel button is  not avilable before submit button,test failed!",gmiSignInPage.cancelButton.isDisplayed());
            System.out.println("Cancel button is Displayed");
            gmiSignInPage.submit.click();
            Driver.wait(2);
            // Driver.closeDriver();

        }else if (role.equals("Manager")) {
            iAmOnHomePage();
            gmiSignInPage.username.sendKeys(ConfigurationReader.getProperty("manager_username"));
            gmiSignInPage.password.sendKeys(ConfigurationReader.getProperty("manager_password"));
            Driver.waitForVisibility(gmiSignInPage.cancelButton,5);
            Assert.assertTrue("Cancel button is  not avilable before submit button,test failed!",gmiSignInPage.cancelButton.isDisplayed());
            System.out.println("Cancel button is Displayed");
            gmiSignInPage.submit.click();
            Driver.wait(2);
            // Driver.closeDriver();
        }

    }



    public static void selectDropDownByIndex(WebDriver driver, WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void selectDropdownByVisibleText(WebDriver driver,WebElement element,String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }


        /*public static void passwordReliability(){
            US_03_Page us_03_page = new US_03_Page();
            String renk = us_03_page.line1.getCssValue("background-color");
            if(renk.contains(ConfigurationReader.getProperty("red"))){
                System.out.println("Password is Very Weak...");
            }else if(renk.contains(ConfigurationReader.getProperty("orange"))){
                System.out.println("Password is Fair...");
        //    }else if(renk.contains(ConfigurationReader.getProperty("yellow"))){
        //        System.out.println("Password is Weak...");
            }else if(renk.contains(ConfigurationReader.getProperty("lime"))){
                System.out.println("Password is Good...");
            }else if(renk.contains(ConfigurationReader.getProperty("green"))){
                System.out.println("Password is Strong...");
            }
       }*/



     public static void verifyElementClickablle(By by) {
         try {
             assertTrue("Element is clickable : " + by, Driver.getDriver().findElement(by).isEnabled());
         } catch (NoSuchElementException e) {
             e.printStackTrace();
         }

     }



  }
