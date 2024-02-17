package in.podtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumDemo {

     WebDriver wd;



    public static void main(String[] args) {
        SeleniumDemo d1 = new SeleniumDemo();

        d1.runTestcase("chrome");
       // d1.runTestcase("firefox");
    }

    public void runTestcase(String browserName) {

        if(browserName.equals("chrome")) {

            wd= new ChromeDriver();
        } else if(browserName.equals("firefox")) {
            wd = new FirefoxDriver();
        }

        //wd.get("https://podtest.in");

        wd.get("https://demo.evershop.io/account/login");

        //akhiljda@gmail.com in email field
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");

        String s  = wd.findElement(By.cssSelector("button[type='submit']")).getAttribute("class");

        System.out.println(s);




    }



}
