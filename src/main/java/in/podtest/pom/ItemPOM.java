package in.podtest.pom;

import in.podtest.utils.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
-------------------------
Created By: Akhil Jain
Owner: PodTest.in
Website: https://podtest.in
Email Address: akhil.jain@podtest.in
-------------------------
 */
public class ItemPOM {

    WebDriver wd;

    public ItemPOM(WebDriver wd) {
        this.wd = wd;
    }

    By skuText = By.xpath("//div[contains(@class,'product-single-sku')]");

    String colorSelection = "(//ul[contains(@class,'variant-option-list')])[2]//a[text()='%s']";

    String sizeSelection = "(//ul[contains(@class,'variant-option-list')])[1]//a[text()='%s']";

    By qty = By.xpath("//input[@name='qty']");

    By addToCartButton = By.xpath("//button[@type='button']/span[text()='ADD TO CART']");

    By viewCartToastBox = By.xpath("//div[@class='Toastify']//a[text()='Continue Shopping']");

    public ItemPOM waitForPageLoad() {
        WaitManager.setExplicitWait(wd,wd.findElement(qty));
        return this;
    }

    public ItemPOM fillQty(String itemqty) {

        wd.findElement(qty).clear();
        wd.findElement(qty).sendKeys(itemqty);
        return this;
    }

    public ItemPOM selectSize(String size) {
        sizeSelection = String.format(sizeSelection, size);
        System.out.println(sizeSelection);
        wd.findElement(By.xpath(sizeSelection)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public ItemPOM selectColor(String color) {
        colorSelection = String.format(colorSelection, color);
        System.out.println(colorSelection);
        wd.findElement(By.xpath(colorSelection)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public ItemPOM clickAddToCart() {
        wd.findElement(addToCartButton).click();
        return this;
    }

    public ItemPOM waitForViewCartToast() {
        WaitManager.setExplicitWait(wd, ExpectedConditions.visibilityOfElementLocated(viewCartToastBox));
        return this;
    }
}
