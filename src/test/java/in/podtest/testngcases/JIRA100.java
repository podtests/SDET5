package in.podtest.testngcases;

import in.podtest.pom.CheckoutPOM;
import in.podtest.pom.LoginPOM;
import org.testng.annotations.Test;

public class JIRA100 extends BaseTest{

    LoginPOM login;

    CheckoutPOM checkout;

    @Test
    public void e2eTC() {
        login = new LoginPOM(wd);
        checkout = new CheckoutPOM(wd);

        login.get().fillEmail("akhiljda@gmail.com").fillPassword("Password")
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




}
