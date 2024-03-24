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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    WebDriver wd;
    DriverManager driver;

    ConfigManager prop = new ConfigManager();
    //String browserName;

    /*
    @BeforeMethod
    public void preSteps() throws MalformedURLException {

        try {
        prop = new ConfigManager();
        browserName = prop.readFile().getProperty("browserName");
            System.out.println("Browser Name is: "+browserName);
        driver = new DriverManager();
        wd = driver.getDriver(browserName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    */


    @Parameters({"browserName"})
    @BeforeMethod
    public void preSteps(String browserName) throws MalformedURLException {
          //  driver = new Driver();
           // wd = driver.getDriver(browserName);
          //  wd = DriverThreadManager.createDriver(browserName);
          //  wd.manage().window().maximize();
    }

    @AfterMethod
    public void postSteps() {
        //driver.tearDown();
    }
}
