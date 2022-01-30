package com.cybertek.tests.day11_alarts_iframe_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 import static org.testng.Assert.*;
import java.util.concurrent.TimeUnit;

public class AlertExampleTest2 {

    String url = "http://practice.cybertekschool.com/javascript_alerts";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

      driver =   WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        driver.get(url);

    }
   @ AfterMethod
    public  void tearDown(){
        driver.quit();
   }
   @Test
    public  void alertInfoTest() {
        WebElement alertLink = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertLink.click();
       Alert alert = driver.switchTo().alert();
       alert.getText();
       Assert.assertEquals(alert.getText(),"I am a JS Alert");
       alert.accept();

       WebElement resultWindow = driver.findElement(By.id("result"));
        assertEquals(resultWindow.getText(),"You successfuly clicked an alert");

        

   }
   @Test
    public  void alertConfirm(){

        WebElement confirmWindow = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmWindow.click();
        Alert confirmAlert = driver.switchTo().alert();
        assertEquals(confirmAlert.getText(),"I am a JS Confirm");
         confirmAlert.dismiss();

         WebElement result = driver.findElement(By.id("result"));
         assertEquals(result.getText(),"You clicked: Cancel");

   }

   @Test
    public void alertPromptTest(){
    WebElement prompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
    prompt.click();

    Alert promptWindow = driver.switchTo().alert();
    assertEquals(promptWindow.getText(),"I am a JS prompt");
    promptWindow.sendKeys("hello");
    promptWindow.accept();

    WebElement result = driver.findElement(By.id("result")) ;
    assertEquals(result.getText(),"You entered: hello");

   }


}
