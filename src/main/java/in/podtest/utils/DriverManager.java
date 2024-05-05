package in.podtest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

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
public class DriverManager {

    WebDriver wd;
    ChromeOptions option;
    FirefoxOptions ffOption;

    public  WebDriver getDriver(String browseName) throws MalformedURLException {
        switch (browseName) {
            case "chrome": {
                option = new ChromeOptions();
                wd = new RemoteWebDriver(new URL("http://localhost:4444"), option);
                break;
            }
            case "firefox": {
                ffOption = new FirefoxOptions();
                wd = new RemoteWebDriver(new URL("http://localhost:4444"), ffOption);
                break;
            }
            default: {
                option = new ChromeOptions();
                wd = new RemoteWebDriver(new URL("http://localhost:4444"), option);
                break;
            }
        }

        return wd;
    }

    public void tearDown() {
        wd.quit();
    }

}
