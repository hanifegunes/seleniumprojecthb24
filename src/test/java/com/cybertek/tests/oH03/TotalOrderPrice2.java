package com.cybertek.tests.oH03;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TotalOrderPrice2 {

     String url = "https://www.demoblaze.com/index.html#";
     WebDriver driver;

      @BeforeClass
    public void setUp(){

              driver = WebDriverFactory.getDriver("chrome");
              driver.manage().window().maximize();
              driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
              driver.get(url);


      }

      @Test
    public   void  priceCalculation() throws InterruptedException {
     // From Categories select Laptops, and from products select Sony Vaio i7
          // - click Add to Cart then handle pop up

          driver.findElement(By.xpath("//a[.='Laptops']")).click();
          driver.findElement(By.linkText("Sony vaio i7")).click();
          driver.findElement(By.linkText("Add to cart")).click();
           Thread.sleep(3000);

           Alert popUpMsg = driver.switchTo().alert();
           popUpMsg.accept();
        //  Navigate to Home
             driver.navigate().to(url);

             // From Categories select Phones, and from products select Iphone 6 32gb
          // - click Add to Cart then handle pop up
          // - Navigate to Cart
             driver.findElement(By.linkText("Phones")).click();
               driver.findElement(By.linkText("Iphone 6 32gb")).click();
               driver.findElement(By.linkText("Add to cart")).click();
               Thread.sleep(3000);
               Alert popUp = driver.switchTo().alert();
               popUp.accept();
                driver.findElement(By.linkText("Cart")).click();

              // Then Verify that total cart price is equal to expected (total of added 2 items) price
             
                WebElement total = driver.findElement(By.xpath("//h3[.='1580']"));
                WebElement item1 = driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
                WebElement item2  = driver.findElement(By.xpath("//tbody/tr[2]/td[3]")) ;

                String expectedTotal = Integer.parseInt(item1.getText())+Integer.parseInt(item2.getText())+"";
               Assert.assertEquals(total.getText(),expectedTotal);

                   System.out.println(total.getText()+ " "+ expectedTotal);

      }

      @AfterClass
    public  void tearDown(){
          driver.quit();
      }






}

/*
    - Go to https://www.demoblaze.com/index.html#
 - From Categories select Laptops, and from products select Sony Vaio i7
 - click Add to Cart then handle pop up
 - Navigate to Home
  - From Categories select Phones, and from products select Iphone 6 32gb
 - click Add to Cart then handle pop up
 - Navigate to Cart
- Then Verify that total cart price is equal to expected (total of added 2 items) price


 */
