package in.podtest;

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
   ChromeOptions option;
   FirefoxOptions ffOption;

    @Parameters({"browserName"})
    @BeforeMethod
    public void preSteps(String browseName) throws MalformedURLException {
        switch(browseName) {
            case "chrome": {
                option = new ChromeOptions();
                wd = new RemoteWebDriver(new URL("http://localhost:4444"), option);
                break;
            }
            case "firefox": {
                ffOption  = new FirefoxOptions();
                wd = new RemoteWebDriver(new URL("http://localhost:4444"), ffOption);
                break;
            }
            default: {
                option = new ChromeOptions();
                wd = new RemoteWebDriver(new URL("http://localhost:4444"), option);
                break;
            }


        }


    }

    @AfterMethod
    public void postSteps() {
        //wd.quit();
    }
}
