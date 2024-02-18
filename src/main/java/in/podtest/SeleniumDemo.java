package in.podtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

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

        int colIndex = d1.getColumnIndex("Quantity");
        System.out.println("Col position is: "+colIndex);
        int rowIndex = d1.getRowIndex("Nike air zoom pegasus 35", "Green");
        System.out.println("Row position is: "+rowIndex);
        d1.deleteItem(rowIndex);


        String qty = d1.getQuantity(d1.getRowIndex("Mix and match chuck taylor all star", "Grey")     , d1.getColumnIndex("Quantity"));
        System.out.println(qty);

        d1.click("//a[@class='button primary']/span[text()='CHECKOUT']");


        //Dropdown Approach1
        //Select countryDD = new Select(wd.findElement(By.xpath("//select[contains(@id, 'country')]")));
        //countryDD.selectByValue("IN");

        //Approach2:
        d1.click("//select[contains(@id,'country')]");

        List<WebElement> ddValues =  wd.findElements(By.xpath("//select[contains(@id,'country')]/option"));
        String valueTobeSelected ="KR";
        for(WebElement ele: ddValues) {
            if(ele.getAttribute("value").equalsIgnoreCase(valueTobeSelected)) {
                ele.click();
                break;
            }
        }

        d1.click("//select[contains(@id,'country')]");






    }

    public String getQuantity(int rowpos, int colpos) {

    return wd.findElement(By.xpath("//tbody/tr["+rowpos+"]/td["+colpos+"]")).getText();

    }

    public void deleteItem(int rowPosition) {
        wd.findElement(By.xpath("//tbody/tr["+rowPosition+"]/td[1]//a[contains(@class,'text-textSubdued')]")).click();
    }


    public int getColumnIndex(String ColumnName) {
        int tolColumnCount = wd.findElements(By.xpath("//thead/tr/td")).size();
        int columnPosition = -1;
        for(int i =1; i <=tolColumnCount; i++) {
            if (wd.findElement(By.xpath("//thead/tr/td["+i+"]/span")).getText().equalsIgnoreCase(ColumnName)){
                columnPosition = i;
                break;
            }
        }
        return columnPosition;
    }

    //tbody/tr[1]/td[1]//div[contains(@class,'cart-item-variant-options')]//li[2]/span[2]
    //tbody/tr[1]/td[1]//div[contains(@class,'cart-tem-info')]/a
    public int getRowIndex(String itemName, String color) {
        //tbody/tr[3]/td[1]//div[@class='cart-tem-info']/a
        int rowPosition = -1;

        List<WebElement> rows =  wd.findElements(By.xpath("//tbody/tr"));
        for(int i =1 ; i<= rows.size(); i++) {
            if (wd.findElement(By.xpath("//tbody/tr["+i+"]/td[1]//div[contains(@class,'cart-tem-info')]/a")).getText().equalsIgnoreCase(itemName)
                    &&
              wd.findElement(By.xpath("//tbody/tr["+i+"]/td[1]//div[contains(@class,'cart-item-variant-options')]//li[2]/span[2]")).getText().equalsIgnoreCase(color))
            {
                rowPosition =i;
                break;
            }
        }
        return rowPosition;
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
