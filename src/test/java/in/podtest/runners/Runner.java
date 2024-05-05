package in.podtest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*
-------------------------
Created By: Akhil Jain
Owner: PodTest.in
Website: https://podtest.in
Email Address: akhil.jain@podtest.in
-------------------------
 */
@CucumberOptions(tags = "@sanity",
        features = {"src/test/resources/login.feature"},
        glue = {"in.podtest.stepdef"},
        plugin = {"pretty", "html:target/cucumber.html"},
        dryRun = false)
public class Runner extends AbstractTestNGCucumberTests {
}