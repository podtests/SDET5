package in.podtest.testngcases;

import in.podtest.utils.ConfigManager;
import in.podtest.utils.DriverManager;
import in.podtest.utils.DriverThreadManager;
import in.podtest.utils.WaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*
-------------------------
Created By: Akhil Jain
Owner: PodTest.in
Website: https://podtest.in
Email Address: akhil.jain@podtest.in
-------------------------
 */
public class BaseTest {

    ConfigManager prop = new ConfigManager();


    @AfterSuite
    public void tearDown() {
        DriverThreadManager.tearDown();
    }

}
