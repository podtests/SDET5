package in.podtest.testngcases;

import in.podtest.utils.DriverManager;
import in.podtest.utils.WaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    WebDriver wd;
    DriverManager driver;
    @Parameters({"browserName"})
    @BeforeMethod
    public void preSteps(String browseName) throws MalformedURLException {
        driver = new DriverManager();
        wd = driver.getDriver(browseName);
    }

    @AfterMethod
    public void postSteps() {
        //driver.tearDown();
    }
}
