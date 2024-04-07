package in.podtest.testngcases;

import in.podtest.pom.CartPOM;
import in.podtest.pom.CheckoutPOM;
import in.podtest.pom.LoginPOM;
import in.podtest.utils.ConfigManager;
import in.podtest.utils.DriverThreadManager;
import in.podtest.utils.ExcelManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class JIRA100 extends BaseTest{

    LoginPOM login;

    CheckoutPOM checkout;

    CartPOM cartPOM;

    @DataProvider(name = "credentials")
    public Object[][] getdata() {
        ExcelManager e1 = new ExcelManager();
        try {
            return e1.readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dataProvider = "credentials")
    public void loginTC(String UN, String PW) {

        WebDriver wd;
        wd = DriverThreadManager.createDriver(prop.readFile().getProperty("browserName"));
        wd.manage().window().maximize();
        login = new LoginPOM(wd);

        login.get().fillEmail(UN).fillPassword(PW)
                .clickSubmit().waitForPageLoad();

    }

    @Test(dataProvider = "credentials")
    public void readTableTC(String UN, String PW) {

        WebDriver wd;
        wd = DriverThreadManager.createDriver(prop.readFile().getProperty("browserName"));
        wd.manage().window().maximize();
        login = new LoginPOM(wd);
        cartPOM = new CartPOM(wd);

        login.get().fillEmail(UN).fillPassword(PW)
                .clickSubmit().waitForPageLoad();

        cartPOM.get().waitForPageLoad().getItemTableData2().readItemData();

    }

    @Test(dataProvider = "credentials")
    public void e2eTC(String UN, String PW) {
        login = new LoginPOM(wd);
        checkout = new CheckoutPOM(wd);

        login.get().fillEmail(UN).fillPassword(PW)
                .clickSubmit().waitForPageLoad()
                .clickItem("Nike air zoom pegasus 35")
                .waitForPageLoad().fillQty("2")
                .selectSize("M").selectColor("Green").clickAddToCart();

        checkout.get()
                .waitForPageLoad()
                .fillShippingAddress()
                .waitForShippingMethodSectionLoad()
                //.selectPaymentMethod("standard")
                .selectPaymentMethodJS("standard")
                .clickContinueToPayment();

    }

    @Test
    public void e2eTC2() {
        login = new LoginPOM(wd);
        checkout = new CheckoutPOM(wd);

        login.get().fillEmail("akhiljda@gmail.com").fillPassword("Password")
                .clickSubmit().waitForPageLoad();

        checkout.get()
                .waitForPageLoad()
                .fillShippingAddress()
                .waitForShippingMethodSectionLoad()
                .selectPaymentMethod("standard")
                //.selectPaymentMethodJS("standard")
                .clickContinueToPayment();

    }

    @Test
    public void e2eTC3() {
        WebDriver wd;
        wd = DriverThreadManager.createDriver(prop.readFile().getProperty("browserName"));
        wd.manage().window().maximize();
        login = new LoginPOM(wd);
        checkout = new CheckoutPOM(wd);

        login.get().fillEmail("akhiljda@gmail.com").fillPassword("Password")
                .clickSubmit().waitForPageLoad();

        checkout.get()
                .waitForPageLoad().selectPaymentMode();


    }




}
