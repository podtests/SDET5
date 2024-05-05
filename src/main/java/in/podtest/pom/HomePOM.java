package in.podtest.pom;

import in.podtest.utils.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
-------------------------
Created By: Akhil Jain
Owner: PodTest.in
Website: https://podtest.in
Email Address: akhil.jain@podtest.in
-------------------------
 */
public class HomePOM {

    WebDriver wd;

    public HomePOM(WebDriver wd) {
        this.wd = wd;
    }

    String itemPath = "//a/span[text()='%s']";

    By shopKidsButton = By.xpath("//a/span[text()='Shop kids']");

    public HomePOM get() {
        wd.get("https://demo.evershop.io/");
        return this;
    }

    public HomePOM waitForPageLoad(){
        WaitManager.setFluentWait(wd,shopKidsButton);
        return this;
    }

    public ItemPOM clickItem(String item) {


        itemPath = String.format(itemPath, item);
        System.out.println(itemPath);

        wd.findElement(By.xpath(itemPath)).click();
        return new ItemPOM(wd);
    }


}
