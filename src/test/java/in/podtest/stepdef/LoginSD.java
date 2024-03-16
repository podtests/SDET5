package in.podtest.stepdef;

import in.podtest.pom.LoginPOM;
import in.podtest.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class LoginSD {

    WebDriver wd;

    LoginPOM login;

    @Given("User is on login page")
    public void openLoginPage() {
        try {
            wd = new DriverManager().getDriver("chrome");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        login = new LoginPOM(wd);
        login.get();
    }

    @When("User fills credentials as {string} and {string}")
    public void fillCrdentials(String UN, String PW) {
        login.fillEmail(UN).fillPassword(PW);
    }

    @When("clicks on Submit button")
    public void clickSubmit() {
        login.clickSubmit();
    }

    @Then("User should be able to login")
    public void validateUserLogin() {
        String cURL = wd.getCurrentUrl();
        if (cURL.equals("https://demo.evershop.io/")) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Failed");
        }
    }
}
