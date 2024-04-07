package in.podtest.pom;

import in.podtest.utils.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class CartPOM {

    WebDriver wd;

    Map<Integer, List<String>> itemData = new HashMap<Integer, List<String>>();

    private By itemsTable = By.xpath("//table[@class='items-table listing']//tbody/tr");

    // //table[@class='items-table listing']//tbody/tr[1]/td[1]//div[@class='cart-tem-info']/a
    // //table[@class='items-table listing']//tbody/tr[1]/td[2]//span[@class='sale-price']
    // //table[@class='items-table listing']//tbody/tr[1]/td[3]//span
    // //table[@class='items-table listing']//tbody/tr[1]/td[4]//span

    private By checkoutButton = By.xpath("//a[@class='button primary']/span[text()='CHECKOUT']");

    public CartPOM(WebDriver wd) {
        this.wd = wd;
    }

    public CartPOM get() {
        wd.get("https://demo.evershop.io/cart");
        return this;
    }
    public CartPOM waitForPageLoad(){
        WaitManager.setFluentWait(wd,checkoutButton);
        return this;
    }

    public CartPOM getItemTableData() {
        int noOfItems = getItemCount();

        List<String> rowItem1 = new ArrayList<String>();
        List<String> rowItem2 = new ArrayList<String>();
        List<String> rowItem3 = new ArrayList<String>();

        rowItem1.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[1]/td[1]//div[@class='cart-tem-info']/a")).getText());
        rowItem1.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[1]/td[2]//span[@class='sale-price']")).getText());
        rowItem1.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[1]/td[3]//span")).getText());
        rowItem1.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[1]/td[4]//span")).getText());

        rowItem2.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[2]/td[1]//div[@class='cart-tem-info']/a")).getText());
        rowItem2.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[2]/td[2]//span[@class='sale-price']")).getText());
        rowItem2.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[2]/td[3]//span")).getText());
        rowItem2.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[2]/td[4]//span")).getText());

        rowItem3.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[3]/td[1]//div[@class='cart-tem-info']/a")).getText());
        rowItem3.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[3]/td[2]//span[@class='sale-price']")).getText());
        rowItem3.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[3]/td[3]//span")).getText());
        rowItem3.add(wd.findElement(By.xpath("//table[@class='items-table listing']//tbody/tr[3]/td[4]//span")).getText());

        itemData.put(1, rowItem1);
        itemData.put(2, rowItem2);
        itemData.put(3, rowItem3);


        return this;


        //Iterator<WebElement> ite1 = wd.findElements(itemsTable).iterator();
        //WebElement we = null;
        /*
        for(int i = 0 ; i<noOfItems; i++) {

        }

        //while(ite1.hasNext()) {
          //  we = ite1.next();  //tr[1]
            rowItem1.add(we.findElement(By.xpath("td[1]//div[@class='cart-tem-info']/a")).getText());
            rowItem1.add(we.findElement(By.xpath("td[2]//span[@class='sale-price']")).getText());
            rowItem1.add(we.findElement(By.xpath("td[3]//span")).getText());
            rowItem1.add(we.findElement(By.xpath("td[4]//span")).getText());

            itemData.put(1, rowItem1);
        }
        */


    }

    public CartPOM getItemTableData2() {
       Iterator<WebElement> rowIterator = wd.findElements(By.xpath("//table[@class='items-table listing']//tbody/tr")).iterator();
       WebElement row;

       int rowNo =1;
       while(rowIterator.hasNext()) {
           row = rowIterator.next();
           itemData.put(rowNo,
                   Arrays.asList(row.findElement(By.xpath("td[1]//div[@class='cart-tem-info']/a")).getText(),
                           row.findElement(By.xpath("td[2]//span[@class='sale-price']")).getText(),
                           row.findElement(By.xpath("td[3]//span")).getText(),
                           row.findElement(By.xpath("td[4]//span")).getText()));
           rowNo++;
       }
        return this;
    }

    public void readDataFromMap(int rowNo) {
        Iterator<String> rowItems =  itemData.get(rowNo).iterator();
        while(rowItems.hasNext()) {
            System.out.print(" | "+ rowItems.next());
        }
    }

    public void readItemData() {
        Iterator<Integer> rowNoIterator =  itemData.keySet().iterator();
        int rowNo =0;
        Iterator<String> rowItems = null;

        while(rowNoIterator.hasNext()) {
            rowNo = rowNoIterator.next();
            rowItems = itemData.get(rowNo).iterator();
            while(rowItems.hasNext()) {
                System.out.print(" | "+ rowItems.next());
            }
            System.out.println();

        }


    }

    public int getItemCount() {
        return wd.findElement(itemsTable).findElements(By.xpath("//tbody/tr")).size();
    }


}
