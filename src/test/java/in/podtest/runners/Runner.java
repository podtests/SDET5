package in.podtest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@sanity",
        features = {"src/test/resources/login.feature"},
        glue = {"in.podtest.stepdef"},
        plugin = {"pretty", "html:target/cucumber.html"},
        dryRun = false)
public class Runner extends AbstractTestNGCucumberTests {
}