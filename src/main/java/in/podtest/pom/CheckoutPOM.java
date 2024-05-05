package in.podtest.pom;

import in.podtest.utils.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/*
-------------------------
Created By: Akhil Jain
Owner: PodTest.in
Website: https://podtest.in
Email Address: akhil.jain@podtest.in
-------------------------
 */
public class CheckoutPOM {

    WebDriver wd;

    By fullName = By.xpath("//input[contains(@name,'full_name')]");
    By telephone = By.xpath("//input[contains(@name,'telephone')]");

    By address = By.xpath("//input[contains(@name,'address_1')]");

    By city = By.xpath("//input[contains(@name,'city')]");

    By country = By.xpath("//select[contains(@name,'country')]");

    By province = By.xpath("//select[contains(@name,'province')]");

    By postcode = By.xpath("//input[contains(@name,'postcode')]");

    By standardDelivery = By.xpath("//span[contains(text(),'Standard Delivery')]//preceding::input[@type='radio' and @id='method0']");

    By standardDeliverycss = By.cssSelector("input[id='method0']~span");

    By shippingNoMethodMessage = By.xpath("//div[text()='Sorry, there is no available method for your address']");
    By expressDelivery = By.xpath("//span[contains(text(),'Express Delivery')]//preceding::input[@type='radio' and @id='method1']");

    By continueToPayment = By.xpath("//button/span[text()='Continue to payment']");

    By paymentFormSection = By.xpath("form[id='checkoutPaymentForm']");

    By cashOnDeliveryMethod = By.xpath("//div[contains(@class,'payment-method-list')][1]//a");

    By placeOrderButton = By.xpath("//button/span[text()='Place Order']");

    By successMessage = By.xpath("//div[@class='checkout-success-customer-info']//div[@class='self-center']/div");
    public CheckoutPOM(WebDriver wd) {
        this.wd = wd;
    }

    public CheckoutPOM get() {
        wd.get("https://demo.evershop.io/checkout");
        return this;
    }

    public CheckoutPOM waitForPageLoad() {
        WaitManager.setExplicitWait(wd, ExpectedConditions.presenceOfElementLocated(fullName));
        return this;
    }

    public CheckoutPOM waitForShippingMethodSectionLoad() {
        WaitManager.setExplicitWait(wd, ExpectedConditions.elementToBeClickable(standardDelivery));
        return this;
    }

    public CheckoutPOM fillShippingAddress() {
        wd.findElement(fullName).sendKeys("Akhil Jain");
        wd.findElement(telephone).sendKeys("9876543210");
        wd.findElement(address).sendKeys("Wahington");
        wd.findElement(city).sendKeys("Alabama");
        selectCountry("US");
        selectProvince("US-AL");
        wd.findElement(postcode).sendKeys("201011");
        Actions ac = new Actions(wd);
        ac.sendKeys(Keys.TAB);
        return this;
    }

    //US
    public CheckoutPOM selectCountry(String countryName) {
        Select countryDD = new Select(wd.findElement(country));
        countryDD.selectByValue(countryName);
        return this;
    }

    //US-AL
    public CheckoutPOM selectProvince(String provinceName) {
        Select provinceDD = new Select(wd.findElement(province));
        provinceDD.selectByValue(provinceName);
        return this;
    }

    public CheckoutPOM selectPaymentMethod(String paymentMethod) {
        if (paymentMethod.equalsIgnoreCase("standard")){
            wd.findElement(standardDelivery).click();
            //wd.findElement(standardDeliverycss).click();
        }
        else {
            wd.findElement(expressDelivery).click();
        }
        return this;
    }


    public CheckoutPOM selectPaymentMethodJS(String paymentMethod) {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector(\"input[id='method0']~span\").click()");
        return this;
    }


    public CheckoutPOM clickContinueToPayment() {
        wd.findElement(continueToPayment).click();
        return this;
    }

    public CheckoutPOM waitForPaymentMethodToLoad() {
        WaitManager.setExplicitWait(wd,ExpectedConditions.visibilityOfElementLocated(paymentFormSection));
        return this;
    }

    public CheckoutPOM selectCashOnDelivery() {
        wd.findElement(cashOnDeliveryMethod).click();
        return this;
    }

    public CheckoutPOM clickPlaceOrder() {
        WaitManager.setExplicitWait(wd, ExpectedConditions.elementToBeClickable(placeOrderButton));
        wd.findElement(placeOrderButton).click();
        return this;
    }

    public String verifySuccessPage() {
        WaitManager.setExplicitWait(wd, ExpectedConditions.urlContains("checkout/success"));
        return wd.findElement(successMessage).getText();
    }

}
