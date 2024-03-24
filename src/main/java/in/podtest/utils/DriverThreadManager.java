package in.podtest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverThreadManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static DriverManager dm = new DriverManager();
    private static void setDriver(String browserName) {

        try {
            driver.set(dm.getDriver(browserName));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver createDriver(String browserName) {
        setDriver(browserName);
        return driver.get();
    }

}
