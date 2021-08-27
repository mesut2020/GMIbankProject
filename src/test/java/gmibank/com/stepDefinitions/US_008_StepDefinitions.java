package gmibank.com.stepDefinitions;

import gmibank.com.pages.US_008_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ReusableMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.ThreadLocalRandom;

public class US_008_StepDefinitions {
    US_008_Page us08Page=new US_008_Page();

    public static String randomMethod1(int a, int ilkAscii, int sonAscii){
        String myData ="";
        for (int i=0;i<a;i++) {
            char ascii = (char) ThreadLocalRandom.current().nextInt(ilkAscii, sonAscii );
            myData =myData + ascii;
        }
        return myData;
    }

    @Given("user enters gmibank homepage")
    public void user_enters_gmibank_homepage() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("gmibank_url"));
    }

    @Then("user clicks userEntry icon")
    public void user_clicks_userEntry_icon() {

        ReusableMethods.waitFor(1);
        us08Page.enterIcon.click();
    }

    @Then("user clicks signIn link")
    public void user_clicks_signIn_link() {
        ReusableMethods.waitFor(1);
        us08Page.signinLink.click();
    }

    @Then("user enters admin username {string}")
    public void user_enters_admin_username(String string) {

        ReusableMethods.waitFor(1);
        us08Page.username.sendKeys("USER1");
    }

    @Then("user enters admin password {string}")
    public void user_enters_admin_password(String string) {

        ReusableMethods.waitFor(1);
        us08Page.password.sendKeys("User123_");
    }

    @Then("user clicks signIn button")
    public void user_clicks_signIn_button() {

        ReusableMethods.waitFor(1);
        us08Page.signInButton.click();
    }

    @Then("user clicks password link")
    public void user_clicks_password_link() {
        us08Page.enterIcon.click();
        ReusableMethods.waitFor(2);
        us08Page.passwordButton.click();

    }

    @Given("user clicks password link and old password for three textbox {string}")
    public void user_clicks_password_link_and_old_password_for_three_textbox(String string) {
        us08Page.currentPasswordBox.clear();
        us08Page.currentPasswordBox.sendKeys("User123_");
        us08Page.newPasswordBox.clear();
        us08Page.newPasswordBox.sendKeys("User123_");
        us08Page.confirmPasswordBox.clear();
        us08Page.confirmPasswordBox.sendKeys("User123_");
    }

    @Then("user doesn't save")
    public void user_doesn_t_save() {
        Assert.assertTrue(us08Page.saveButton.isEnabled());
    }


    //TC_02

    @Given("user clicks password link and writes one random uppercase")
    public void user_clicks_password_link_and_writes_one_random_uppercase() {
        us08Page.newPasswordBox.clear();
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,65,90));
        System.out.println(us08Page.newPasswordBox.getText());

    }

    @Then("user writes six lower cases and sees the change of password scales")
    public void user_writes_six_lower_cases_and_sees_the_change_of_password_scales() {
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,97,122));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),us08Page.passwordStrengthScala.get(1).getAttribute("style"));

    }

    @Then("user writes six digits and sees the change of password scales")
    public void user_writes_six_digits_and_sees_the_change_of_password_scales() {
        user_clicks_password_link_and_writes_one_random_uppercase();
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,48,57));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),us08Page.passwordStrengthScala.get(1).getAttribute("style"));

    }

    @Then("user writes six special chars and sees the change of password scales")
    public void user_writes_six_special_chars_and_sees_the_change_of_password_scales() {
        user_clicks_password_link_and_writes_one_random_uppercase();
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,33,47));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),us08Page.passwordStrengthScala.get(1).getAttribute("style"));

    }

    //TC_03

    @Given("user clicks password link and writes one random lowercase")
    public void userClicksPasswordLinkAndWritesOneRandomLowercase() {
        us08Page.newPasswordBox.clear();
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,97,122));
    }

    @Then("user writes six upper cases and sees the change of password scales")
    public void userWritesSixUpperCasesAndSeesTheChangeOfPasswordScales() {
        userClicksPasswordLinkAndWritesOneRandomLowercase();
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,65,90));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),color);
    }



    @Then("user writes  six special chars and sees the change of password scales")
    public void userWritesSixSpecialCharsAndSeesTheChangeOfPasswordScales() {
        userClicksPasswordLinkAndWritesOneRandomLowercase();
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,33,47));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),color);

    }

    @Then("{int}user writes six digits and sees the change of password scales")
    public void userWritesSixDigitsAndSeesTheChangeOfPasswordScales(int arg0) {
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,48,57));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),color);

    }

    //TC_04

    @Given("testcasefour user clicks password link and writes one random digit")
    public void testcasefourUserClicksPasswordLinkAndWritesOneRandomDigit() {
        us08Page.newPasswordBox.clear();
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,48,57));
        System.out.println(us08Page.newPasswordBox.getText());
    }

    @Then("testcasefour user writes six upper cases and sees the change of password scales")
    public void testcasefourUserWritesSixUpperCasesAndSeesTheChangeOfPasswordScales() {
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,65,90));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),color);

    }

    @Then("testcasefour user writes six special chars and sees the change of password scales")
    public void testcasefourUserWritesSixSpecialCharsAndSeesTheChangeOfPasswordScales() {
        testcasefourUserClicksPasswordLinkAndWritesOneRandomDigit();
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,33,47));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),color);

    }

    @Then("testcasefour user writes six lower cases and sees the change of password scales")
    public void testcasefourUserWritesSixLowerCasesAndSeesTheChangeOfPasswordScales() {
        testcasefourUserClicksPasswordLinkAndWritesOneRandomDigit();
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,97,122));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),color);

    }

    //TC_05
    @Given("testcasefive user clicks password link and user writes one random special character")
    public void testcasefiveUserClicksPasswordLinkAndUserWritesOneRandomSpecialCharacter() {
        us08Page.newPasswordBox.clear();
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,33,47));
        System.out.println(us08Page.newPasswordBox.getText());
    }

    @Then("testcasefive user writes six lower cases and sees the change of password scales")
    public void testcasefiveUserWritesSixLowerCasesAndSeesTheChangeOfPasswordScales() {
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,97,122));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),color);

    }

    @Then("testcasefive user writes six upper cases and sees the change of password scales")
    public void testcasefiveUserWritesSixUpperCasesAndSeesTheChangeOfPasswordScales() {
        testcasefiveUserClicksPasswordLinkAndUserWritesOneRandomSpecialCharacter();
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,65,90));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(4);
        //Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),color);

    }

    @Then("testcasefive user writes six digits and sees the change of password scales")
    public void testcasefiveUserWritesSixDigitsAndSeesTheChangeOfPasswordScales() {
        testcasefiveUserClicksPasswordLinkAndUserWritesOneRandomSpecialCharacter();
        us08Page.newPasswordBox.sendKeys(randomMethod1(6,48,57));
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(("background-color: rgb(221, 221, 221);"),color);
        Assert.assertEquals(("background-color: rgb(255, 153, 0);"),color);

    }

    //TC_06

    @Given("user clicks password link and writes one random uppercase, lowercase, digit and special char")
    public void userClicksPasswordLinkAndWritesOneRandomUppercaseLowercaseDigitAndSpecialChar() {
        us08Page.newPasswordBox.clear();
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,33,47));
        ReusableMethods.waitFor(1);
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,48,57));
        ReusableMethods.waitFor(1);
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,65,90));
        ReusableMethods.waitFor(1);
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,97,122));
        ReusableMethods.waitFor(1);

    }


    @And("user writes two lower cases and doesn't see the change of password scales")
    public void userWritesTwoLowerCasesAndDoesnTSeeTheChangeOfPasswordScales() {
        us08Page.newPasswordBox.sendKeys(randomMethod1(2,97,122));
        ReusableMethods.waitFor(2);
        String color = us08Page.passwordStrengthScala.get(4).getAttribute("style");
        ReusableMethods.waitFor(2);
        System.out.println(color);
        Assert.assertNotEquals("background-color: rgb(0, 255, 0);",color);

    }

    @And("user write one more lower cases and sees to changing")
    public void userWriteOneMoreLowerCasesAndSeesToChanging() {
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,97,122));
        ReusableMethods.waitFor(1);
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        System.out.println(color);
        Assert.assertEquals(("background-color: rgb(0, 255, 0);"),color);
    }

    @And("user writes two upper cases and doesn't see the change of password scales")
    public void userWritesTwoUpperCasesAndDoesnTSeeTheChangeOfPasswordScales() {

        userClicksPasswordLinkAndWritesOneRandomUppercaseLowercaseDigitAndSpecialChar();
        us08Page.newPasswordBox.sendKeys(randomMethod1(2,65,90));
        ReusableMethods.waitFor(1);
        String color = us08Page.passwordStrengthScala.get(4).getAttribute("style");
        ReusableMethods.waitFor(1);
        Assert.assertNotEquals("background-color: rgb(0, 255, 0);",color);


    }

    @And("user write one more upper cases and sees to changing")
    public void userWriteOneMoreUpperCasesAndSeesToChanging() {
        ReusableMethods.waitFor(1);
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,65,90));
        ReusableMethods.waitFor(1);
        String color = us08Page.passwordStrengthScala.get(4).getAttribute("style");
        ReusableMethods.waitFor(1);
        Assert.assertEquals(("background-color: rgb(0, 255, 0);"),color);
    }

    @And("user writes two digits and doesn't see the change of password scales")
    public void userWritesTwoDigitsAndDoesnTSeeTheChangeOfPasswordScales() {
        userClicksPasswordLinkAndWritesOneRandomUppercaseLowercaseDigitAndSpecialChar();
        us08Page.newPasswordBox.sendKeys(randomMethod1(2,48,57));
        ReusableMethods.waitFor(1);
        String color = us08Page.passwordStrengthScala.get(4).getAttribute("style");
        ReusableMethods.waitFor(1);
        Assert.assertNotEquals("background-color: rgb(0, 255, 0);",color);

    }

    @And("user write one more digits and sees to changing")
    public void userWriteOneMoreDigitsAndSeesToChanging() {
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,48,57));
        ReusableMethods.waitFor(1);
        String color = us08Page.passwordStrengthScala.get(4).getAttribute("style");
        ReusableMethods.waitFor(1);
        Assert.assertEquals(("background-color: rgb(0, 255, 0);"),color);
    }

    @And("user writes two special chars and doesn't see the change of password scales")
    public void userWritesTwoSpecialCharsAndDoesnTSeeTheChangeOfPasswordScales() {
        userClicksPasswordLinkAndWritesOneRandomUppercaseLowercaseDigitAndSpecialChar();
        us08Page.newPasswordBox.sendKeys(randomMethod1(2,33,47));
        ReusableMethods.waitFor(1);
        String color = us08Page.passwordStrengthScala.get(4).getAttribute("style");
        ReusableMethods.waitFor(1);
        Assert.assertNotEquals("background-color: rgb(0, 255, 0);",color);
    }

    @Then("user write one more special chars and sees to changing")
    public void userWriteOneMoreSpecialCharsAndSeesToChanging() {
        us08Page.newPasswordBox.sendKeys(randomMethod1(1,33,47));
        ReusableMethods.waitFor(1);
        String color = us08Page.passwordStrengthScala.get(1).getAttribute("style");
        ReusableMethods.waitFor(1);
        Assert.assertEquals(("background-color: rgb(0, 255, 0);"),color);
    }

    //TC_07

    String newPasswordRandom = randomMethod1(8,33,122);


    @Given("user clicks password link and writes random password")
    public void userClicksPasswordLinkAndWritesRandomPassword() {
        ReusableMethods.waitFor(2);
        System.out.println(newPasswordRandom);
        us08Page.currentPasswordBox.sendKeys("User123_");
        // us08Page.newPasswordBox.sendKeys("User123_");
        us08Page.newPasswordBox.sendKeys(newPasswordRandom);
        // us08Page.confirmPasswordBox.sendKeys("User123_");
        us08Page.confirmPasswordBox.sendKeys(newPasswordRandom);


    }

    @Then("user saves new password")
    public void userSavesNewPassword() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us08Page.saveButton.isEnabled());




    }


    @Then("user signout")
    public void userSignout() {
        Driver.closeDriver();
    }
}