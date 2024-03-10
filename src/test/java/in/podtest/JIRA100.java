package in.podtest;

import in.podtest.pom.LoginPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class JIRA100 extends BaseTest{

    LoginPOM login;

    @Test
    public void e2eTC() {
        login = new LoginPOM(wd);

        login.get().fillEmail("akhiljda@gmail.com").fillPassword("Password")
                .clickSubmit().waitForPageLoad()
                .clickItem("Nike air zoom pegasus 35")
                .waitForPageLoad().fillQty("2")
                .selectSize("M").selectColor("Green").clickAddToCart();
    }




}
