package in.podtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;

public class SeleniumDemo {
    static WebDriver wd;

    public static void main(String[] args) throws InterruptedException {
        SeleniumDemo d1 = new SeleniumDemo();

       wd = d1.createDriver();
       wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       //wd.get("https://demo.evershop.io/account/login");
     d1.openURLUsingNavigate("https://demo.evershop.io/account/login");
     d1.fillText("//input[@name='email']", "akhiljda@gmail.com");
    d1.fillText("//input[@name='password']", "Password");
    d1.click("//button[@type='submit']");

    d1.click("//a/span[text()='Nike air zoom pegasus 35']");

    String itemCode = d1.getText("//div[contains(@class,'product-single-sku')]");
        System.out.println("Item Code is: "+itemCode);

    //click on Blue color:
      d1.click("(//ul[contains(@class,'variant-option-list')])[2]//a[text()='Green']");

      Thread.sleep(2000);

      //select the size
      d1.click("(//ul[contains(@class,'variant-option-list')])[1]//a[text()='L']");

        Thread.sleep(2000);

      //clcik on add to cart button
        d1.click("//button[@type='button']/span[text()='ADD TO CART']");

        Thread.sleep(1000);

       // d1.click("//a[@class='mini-cart-icon']");
        d1.openURLUsingNavigate("https://demo.evershop.io/cart");
/*
//qty for Row1 col 3
        wd.findElement(By.xpath("//tbody/tr[1]/td[3]/span")).getText();

        //qty for row2 col3
        wd.findElement(By.xpath("//tbody/tr[2]/td[3]/span")).getText();


        //read data for First Row:
        wd.findElement(By.xpath("//tbody/tr[1]/td[1]//div[@class='cart-tem-info']/a")).getText(); //Col1
        wd.findElement(By.xpath("//tbody/tr[1]/td[2]/div/span")).getText();
        wd.findElement(By.xpath("//tbody/tr[1]/td[3]/span")).getText();
        wd.findElement(By.xpath("//tbody/tr[1]/td[4]/span")).getText();

        //read data for Second Row:
        wd.findElement(By.xpath("//tbody/tr[2]/td[1]//div[@class='cart-tem-info']/a")).getText(); //Col1
        wd.findElement(By.xpath("//tbody/tr[2]/td[2]/div/span")).getText();
        wd.findElement(By.xpath("//tbody/tr[2]/td[3]/span")).getText();
        wd.findElement(By.xpath("//tbody/tr[2]/td[4]/span")).getText();
        */

        //
        List<WebElement> rows = wd.findElements(By.xpath("//tbody/tr"));

        //rows -> Row1 : tr[1] , Row2: tr
        //wd.findElement(By.xpath("//tbody/tr")).findElement()

        for(WebElement row: rows) {
            System.out.println(row.findElement(By.xpath("td[1]//div[@class='cart-tem-info']/a")).getText());
            System.out.println(row.findElement(By.xpath("td[2]/div/span")).getText());
            System.out.println(row.findElement(By.xpath("td[3]/span")).getText());
            System.out.println(row.findElement(By.xpath("td[4]/span")).getText());
        }



    }

    public String getText(String locator) {
        return wd.findElement(By.xpath(locator)).getText();
    }



    public void click(String locator) {
        wd.findElement(By.xpath(locator)).click();
    }


    public void fillText(String locator, String text) {
        wd.findElement(By.xpath(locator)).sendKeys(text);
    }

    public WebDriver createDriver() {
        WebDriver wd1 = new ChromeDriver();
        return wd1;
    }

    public void openURLUsingGet(String URL) {
        wd.get(URL);
    }

    public void openURLUsingNavigate(String URL) {
        wd.navigate().to(URL);
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
