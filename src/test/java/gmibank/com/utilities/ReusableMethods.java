package gmibank.com.utilities;

import com.github.javafaker.Faker;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReusableMethods {

    public static String fakeUserName;
    public static String fakeFirstName;
    public static String fakeLastName;
    public static String randomSSN;
    public static String randomAccount_1;
    public static String randomAccount_2;

    /*
     * switches to new window by the exact title
     * returns to original window if windows with given title not found
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    //========Hover Over=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * return a list of string from a list of elements ignores any element with no
     * text
     *
     * @param list
     * @return
     */    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //===============Explicit Wait==============//
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    //======Fluent Wait====//
    public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(timeinsec))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }

    /**
     * Verifies whether the element matching the provided locator is displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementDisplayed(By by) {
        try {
            assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + by);
        }
    }

    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifies whether the element is displayed on page
     * fails if the element is not found or not displayed
     *
     * @param element
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + element);
        }
    }
    //======== Slider Ayarlama =========//
    public static void setSliderBall(WebElement element, int sliderStartPoint, int target) {
        Actions actions = new Actions(Driver.getDriver());
        String value = "";
        actions.clickAndHold(element).perform();
        for (int i = 0; i < sliderStartPoint; i++) {
            if (sliderStartPoint > 0) {
                actions.sendKeys(Keys.ARROW_LEFT).perform();
            }
            value = element.getAttribute("value");
            if (value.equals("0")) {
                for (int j = 0; j < target; j++) {
                    actions.sendKeys(Keys.ARROW_RIGHT).perform();
                }
            }
        }
    }

    // ======= RGB to HEX ==== //

    public static String getHexColor(WebElement element, String cssValue) {
        String color = element.getCssValue(cssValue); // RGB
        String hex = "";
        int r, g, b = 0;
        if (color.contains("rgba")) {
            String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
            r = Integer.parseInt(numbers[0].trim());
            g = Integer.parseInt(numbers[1].trim());
            b = Integer.parseInt(numbers[2].trim());
            hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
        } else {
            String[] numbers = color.replace("rgb(", "").replace(")", "").split(",");
            r = Integer.parseInt(numbers[0].trim());
            g = Integer.parseInt(numbers[1].trim());
            b = Integer.parseInt(numbers[2].trim());
            hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
        }
        return hex;
    }

    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    // ========= JS METHODS =========== //

    // CLICK WITH JS
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    // SCROLL TO ELEMENT WITH JS
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // SET ATTRIBUTE WITH JS
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }


    // ===========  JS COMMAND EXECUTE  =========== //

    // EXECUTES THE GIVEN JAVASCRIPT command on given web element
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }

    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);
    }

    // Silinmeyen Texboxlari temizlemek icin ==> .clean() in daha guclusu
    public static void cleanByJs(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].value = '';", element);
    }

    // ===== RONDOM DATA === //

    public static int randomNumberGenerator(int min, int max){
        return (int)(Math.random()*(max-min)+min);
    }

    public static String getRandomSSN() {
        randomSSN = "";
        for (int i = 0; i < 9; i++) {
            if(i==3 || i==5) randomSSN += "-";
            randomSSN += randomNumberGenerator(1,10);
        }
        return randomSSN;
    }

    /**
     * method adds three different chars to first part of email.
     * @param email is current email
     * @return a new email that is changed only first part
     */
    public static String getNewEmail(String email) {
        String data = "abcdefghijklmnoprstuvyzxw0123456789";
        int indexOfEt = email.indexOf("@");
        String emailFirstPart = email.substring(0, indexOfEt);
        String emailSecondPart = email.substring(indexOfEt); //@gmail.com
        String ekMail = "";
        for (int i = 0; i < 3; i++) {
            int random = (int) (Math.random()*data.length());
            ekMail += data.charAt(random);
        }
        emailFirstPart = emailFirstPart + ekMail;
        email = emailFirstPart + emailSecondPart;
        return email;
    }

    /**
     * Method changes the last three digitis of current phone number
     * @param mobileNumber is current mobeile phone number
     * @return new mobile number
     */
    public static String getNewRequestNumber(String mobileNumber) {
        String data = "0123456789";
        String numberFirstPart = mobileNumber.substring(0,mobileNumber.length()-3);
        String numberSecondPart = "";
        for (int i = 0; i < 3; i++) {
            int random = (int) (Math.random()*data.length());
            numberSecondPart += data.charAt(random);
        }
        mobileNumber = numberFirstPart + numberSecondPart;

        return mobileNumber;

    }

    public static String randomMethod(int a, int firstAscii, int lastAscii){
        String myData ="";
        for (int i=0;i<a;i++) {
            char ascii = (char) ThreadLocalRandom.current().nextInt(firstAscii, lastAscii );
            myData =myData + ascii;
        }
        return myData;
    }

    public static String getFakeUserName(){
        fakeUserName = new Faker().name().username();
        return fakeUserName;
    }

    public static String getFakeFirstName(){
        fakeFirstName = new Faker().name().firstName();
        return fakeFirstName;
    }

    public static String getFakeLastName(){
        fakeLastName = new Faker().name().lastName();
        return fakeLastName;
    }

    public static String getRandomAccount1(){
        randomAccount_1 = new Faker().currency().name();
        return randomAccount_1;
    }

    public static String getRandomAccount2(){
        randomAccount_2 = new Faker().currency().name();
        return randomAccount_2;
    }

    public static String date(){
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return formatter.format(now);
    }

    /**
     *
     * @param scenario
     */
    public static void screenShot(Scenario scenario){
        // Alinan resmin dosya adini duzenliyoruz: SenaryoAditarihsaat

        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File ekranDosyasi = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(ekranDosyasi, new File("target/failedScreenShots/" +
                    date() + "_" + scenario.getName() + "_" + Driver.browsers.get() +  ".png")); // chrome_Create country_20201021_014228.png
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


}
