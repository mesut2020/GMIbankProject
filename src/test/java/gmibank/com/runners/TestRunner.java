
package gmibank.com.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/html-reports/cucumber.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/FailedReRun.txt"
        },
        features = "src/test/resources/ui_features",
        glue = "gmibank/com/stepDefinitions",

        tags = "@demo",

        dryRun = false
        //stepNotifications = true, // to see report gherkin step level
        //monochrome = false, // outputların daha okunabilir olması ıcın
        //publish = false  // it is to get online report
)
public class TestRunner {
}