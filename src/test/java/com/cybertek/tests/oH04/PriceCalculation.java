package com.cybertek.tests.oH04;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PriceCalculation {
    WebDriver driver;
    String demoQAUrl = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";

    @BeforeMethod
    public void setUp() {
        driver =   WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(demoQAUrl);
    }
     @AfterMethod
    public void tearDown(){

       driver.quit();


     }
     @Test
    public  void testOne() throws InterruptedException {
        //login with username:Tester, password: test

         driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
         driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);

           //Click order button
         driver.findElement(By.linkText("Order")).click();



         // Verify under Product Information, selected option is “MyMoney”
         Select dropDown = new Select(driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct")));
        // String expectedText = "MyMone";
         String expectedText = "MyMoney";
         String actualText = dropDown.getFirstSelectedOption().getText();

         Assert.assertEquals(actualText,expectedText,"Text do NOT match"); // we will see this if it fails
         // Then select FamilyAlbum, make quantity 2, and click Calculate
         dropDown.selectByValue("FamilyAlbum");
         WebElement quantityBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
         // int quantity = 2;
         //  quantityBox.clear();
         quantityBox.sendKeys(Keys.DELETE+"2");
         Thread.sleep(2000);

         WebElement pricePerUnitElement = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
         int pricePerUnit = Integer.parseInt(pricePerUnitElement.getAttribute("value"));
         System.out.println("pricePerUnit = " + pricePerUnit);

         // click calculate button
         driver.findElement(By.xpath("//input[@value='Calculate']")).click();

         int expectedTotalPrice = 2*pricePerUnit;
         int actualTotalPrice = Integer.parseInt(driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value"));

         System.out.println("expectedTotalPrice = " + expectedTotalPrice);
         System.out.println("actualTotalPrice = " + actualTotalPrice);

         Assert.assertEquals(actualTotalPrice,expectedTotalPrice,"The Price DO NOT match");
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
Test Case 2:
Total Order Price Calculation 2
 - Go to https://www.demoblaze.com/index.html#
 - From Categories select Laptops, and from products select Sony Vaio i7
 - click Add to Cart then handle pop up
 - Navigate to Home
  - From Categories select Phones, and from products select Iphone 6 32gb
 - click Add to Cart then handle pop up
 - Navigate to Cart
- Then Verify that total cart price is equal to expected (total of added 2 items) price



  */