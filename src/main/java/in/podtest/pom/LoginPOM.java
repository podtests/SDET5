package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {

    WebDriver wd;

    public LoginPOM(WebDriver wd) {
        this.wd = wd;
    }

    By userName = By.xpath("//input[@name='email']");

    By password = By.xpath("//input[@name='password']");

    By submitButton = By.xpath("//button[@type='submit']");

    public LoginPOM get() {
        wd.get("https://demo.evershop.io/account/login");
        return this;
    }

    public LoginPOM fillEmail(String UN) {
        wd.findElement(userName).sendKeys(UN);
        return this;
    }

    public LoginPOM fillPassword(String PW) {
        wd.findElement(password).sendKeys(PW);
        return this;
    }

    public HomePOM clickSubmit() {
        wd.findElement(submitButton).click();
        return new HomePOM(wd);
    }
}
