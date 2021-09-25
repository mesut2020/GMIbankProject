package gmibank.com.stepDefinitions;

import gmibank.com.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import gmibank.com.utilities.Driver;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println(scenario.getName() + " : " +scenario.getStatus());
        Driver.closeDriver();
    }
}
