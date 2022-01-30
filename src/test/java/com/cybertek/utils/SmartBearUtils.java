package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearUtils {



    public static void loginToSmartBear (WebDriver driver){

        driver.get(ConfigurationReader.getProperty("smart.url"));
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button")) ;
        loginButton.click();
        Assert.assertEquals(driver.getTitle(),"Web Orders","Failed to login to smartbearapp");
    }

     public  static  void addProduct(WebDriver driver){



     }
     public  static  void  verifyOrder(WebDriver driver, String name) {

      //   WebElement orderNames = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
     //    Assert.assertTrue(orderNames.getText().contains("Paul"), "fail");
         //table[@id='table1']//td[contains(text(),'\"+name+\"')]")) ;
          ////table[@class='SampleTable']/tbody/tr
         List<WebElement> allname = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[contains(text(),'\"+name+\"')]"));

         for (WebElement eachName : allname) {

             if (eachName.getText().contains(name)) {

                 Assert.assertTrue(eachName.getText().contains(name), "Fail");
             }
         }
        }

     public  static  void printNameAndCities(WebDriver driver){

     List<WebElement>names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[2]")) ;
     List<WebElement>cities= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[7]")) ;

    for(int i = 0; i<names.size(); i++){

        System.out.println("Name"+(i+1)+": "+names.get(i).getText()+" , "+"City"+(i+1)+": "+cities.get(i).getText()+"\n");
    }

     
     }
     /*
      Create a method named printNamesAndCities in SmartBearUtils class.
• Method takes WebDriver object.
• This method should simply print all the names in the List of All Orders.
• Create a new TestNG test to test if the method is working as expected.
• Output should be like:
• Name1: name , City1: city
• Name2: name , City2: city

      */
    ////table[@id='table1']//td[contains(text(),'\"+name+\"')]")) ;
   public static void viewAllOrders(WebDriver driver){
    WebElement viewAllOrders= driver.findElement(By.tagName("a"));
    viewAllOrders.click();
      WebElement susan = driver.findElement(By.xpath("//table[@class='SampleTable']//tr[6]/td[2]"));
      WebElement dateSusan = driver.findElement(By.xpath("//table[@class='SampleTable']//tr[6]/td[5]"));
       System.out.println(susan.getText());
       System.out.println(dateSusan.getText());
     Assert.assertEquals(susan.getText(),"Susan McLaren");
     Assert.assertEquals(dateSusan.getText(),"01/05/2010");

   }

    
     
}
/*
  TC#3: Smartbear software order verification
1. Open browser and login to Smartbear software
2. Click on View all orders
3. Verify Susan McLaren has order on date “01/05/2010”


 */