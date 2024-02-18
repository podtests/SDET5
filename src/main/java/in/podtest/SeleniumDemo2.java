package in.podtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SeleniumDemo2 {

    static WebDriver wd;
    public static void main(String[] args) {


       wd  = new ChromeDriver();
        wd.navigate().to("https://selectorshub.com/iframe-scenario/");


        wd.switchTo().frame("pact1");
        //alert boxes
        wd.switchTo().frame("pact2");
        //wd.findElement(By.xpath("//input[@id='inp_val']")).sendKeys("Akhil");

     wd.findElement(By.xpath("//input[@id='jex']")).sendKeys("Akhil");

     wd.switchTo().parentFrame();

        wd.switchTo().parentFrame();

     String s  = wd.findElement(By.xpath("//img[@title='SH_512x512']")).getAttribute("class");
        System.out.println(s);


    }

    public  void multipleTabs() {
        String currentTabId = wd.getWindowHandle();
        System.out.println(currentTabId);
        System.out.println(wd.getTitle());

        wd.findElement(By.id("YT")).click();

        wd.findElement(By.id("Podtest")).click();

        Set<String> tabIds = wd.getWindowHandles();
        for(String s : tabIds) {
            System.out.println(s);
            wd.switchTo().window(s);
            System.out.println(wd.getTitle());

        }

        wd.switchTo().window(currentTabId);
        System.out.println(wd.getTitle());
    }
}
