package com.cybertek.tests.oH03;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class TotalOrderPrice1 {
     String url = " http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";

     WebDriver driver;

     @BeforeClass
      public  void  setUp(){
          driver = WebDriverFactory.getDriver("chrome");
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          driver.get(url);

     }
          @Test
    public void login() {


              WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
              username.sendKeys("Tester");

              WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
              password.sendKeys("test");

              WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
              login.click();


              WebElement order = driver.findElement(By.linkText("Order"));
              order.click();
             Select selectProduct = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));

             String selectedOption = selectProduct.getFirstSelectedOption().getText();
             String expected= "MyMoney";
              System.out.println(expected + " - "+selectedOption);

             Assert.assertEquals(selectProduct.getFirstSelectedOption().getText(),expected);
             selectProduct.selectByValue("FamilyAlbum");
             
          WebElement  quantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
                quantity.sendKeys("2");
           WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
                calculate.click();
                int quantitySize = Integer.parseInt(quantity.getAttribute("value"));
              System.out.println("Quantity size " + quantitySize);


               WebElement price = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
              int pricePerUnit = Integer.parseInt(price.getAttribute("value"));
              System.out.println("Unit price "+ " - "+ pricePerUnit);

             WebElement totalUnit = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));
               int total = Integer.parseInt(totalUnit.getAttribute("value"));
              System.out.println("Total "+ "- "+ total);


              Assert.assertEquals(total,quantitySize*pricePerUnit);
              System.out.println("total "+" - "+ total);


          }

         @AfterClass
    public  void tearDown(){


         driver.quit();
         }



}
  /*
   Test Case 1:
Total Order Price Calculation 1
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Login with username: Tester, password: test
- Click  Order button
- Verify under Product Information, selected option is “MyMoney”
-Then select FamilyAlbum, make quantity 2, and click Calculate,
- Then verify Total is equal to Quantity*PricePerUnit 


   */