package gmibank.com.stepDefinitions;

import gmibank.com.utilities.Driver;
import gmibank.com.utilities.ExcelUtil;
import gmibank.com.utilities.ReusableMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

    @Before
    public void before(Scenario scenario) {
        System.out.println(scenario.getName() + " has been started");
    }

    @After
    public void after(Scenario scenario) {
        System.out.println(scenario.getName() + " : " + scenario.getStatus());

        if (scenario.getStatus().toString() == "FAILED") {
            ReusableMethods.screenShot(scenario);
        }

        ExcelUtil.writeScenarioToExcel(scenario);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Driver.closeDriver();

    }
}
