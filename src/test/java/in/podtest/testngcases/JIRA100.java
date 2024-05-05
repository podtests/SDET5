package in.podtest.testngcases;

import in.podtest.pom.CartPOM;
import in.podtest.pom.CheckoutPOM;
import in.podtest.pom.LoginPOM;
import in.podtest.utils.ConfigManager;
import in.podtest.utils.DriverThreadManager;
import in.podtest.utils.ExcelManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/*
-------------------------
Created By: Akhil Jain
Owner: PodTest.in
Website: https://podtest.in
Email Address: akhil.jain@podtest.in
-------------------------
 */
public class JIRA100 extends BaseTest{


    /*
-------------------------
Created By: Akhil Jain
Owner: PodTest.in
Website: https://podtest.in
Email Address: akhil.jain@podtest.in
-------------------------
 */
    @DataProvider(name = "credentials")
    public Object[][] getdata() {
        ExcelManager e1 = new ExcelManager();
        try {
            return e1.readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
-------------------------
Created By: Akhil Jain
Owner: PodTest.in
Website: https://podtest.in
Email Address: akhil.jain@podtest.in
-------------------------
 */

    @Test(dataProvider = "credentials", enabled = false)
    public void loginTC(String UN, String PW) {

        WebDriver wd;
        wd = DriverThreadManager.createDriver(prop.readFile().getProperty("browserName"));
        wd.manage().window().maximize();
        LoginPOM login = new LoginPOM(wd);

        login.get().fillEmail(UN).fillPassword(PW)
                .clickSubmit().waitForPageLoad();

        login = null;
        wd = null;

    }

    /*
-------------------------
Created By: Akhil Jain
Owner: PodTest.in
Website: https://podtest.in
Email Address: akhil.jain@podtest.in
-------------------------
 */

    @Test(dataProvider = "credentials")
    public void e2eTC(String UN, String PW) {
        WebDriver wd;
        wd = DriverThreadManager.createDriver(prop.readFile().getProperty("browserName"));
        wd.manage().window().maximize();

        LoginPOM login = new LoginPOM(wd);
        CheckoutPOM checkout = new CheckoutPOM(wd);

        login.get().fillEmail(UN).fillPassword(PW)
                .clickSubmit().waitForPageLoad()
                .clickItem("Nike air zoom pegasus 35")
                .waitForPageLoad().fillQty("2")
                .selectSize("M").selectColor("Green").clickAddToCart().waitForViewCartToast();

        checkout.get()
                .waitForPageLoad()
                .fillShippingAddress()
                .waitForShippingMethodSectionLoad()
                .selectPaymentMethod("standard")
                .clickContinueToPayment()
                .waitForPaymentMethodToLoad()
                .selectCashOnDelivery()
                .clickPlaceOrder();

        Assert.assertEquals(checkout.verifySuccessPage(), "Thank you Akhil!");

        login = null;
        checkout = null;
        wd = null;

    }

}
