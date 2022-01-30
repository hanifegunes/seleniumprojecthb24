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
  import  static org.testng.Assert.*;
import java.util.concurrent.TimeUnit;

public class AlertsExampleTests {

    String url = "http://practice.cybertekschool.com/javascript_alerts";
    WebDriver driver;

     @BeforeMethod
    public  void setUp(){
         driver= WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         driver.get(url);

     }
     @AfterMethod
    public  void tearDown(){
         driver.quit();
     }
     @Test
    public  void  infoAlertTest(){
         WebElement alertLink = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
         alertLink.click();

         //Switch the alert and assert text is "I am a JS Alert" I -> interface
         Alert alert = driver.switchTo().alert();
        // alert.getText()
         System.out.println("text of alert: "+ alert.getText());
         assertEquals(alert.getText(),"I am a JS Alert");
           alert.accept();

           //assert the confirmation message is displayed

           WebElement resultMessage = driver.findElement(By.id("result"));
           assertEquals(resultMessage.getText(),"You successfuly clicked an alert");

     }
     @Test
     public  void confirmAlertTest(){
        // click on js confirm link
        //switch to alert then assert the text is"I am a JS Confirm"
        //Click on cancel
        //assert message text is"You Clicked Cancel

      WebElement confirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
      confirm.click();
      Alert confirmAlert = driver.switchTo().alert();
      assertEquals(confirmAlert.getText(),"I am a JS Confirm");
        confirmAlert.dismiss();
         //assert the confirmation message is canceled
         WebElement resultMessage = driver.findElement(By.id("result"));
         assertEquals(resultMessage.getText(),"You clicked: Cancel");


     }
      @Test
    public  void promptAlertTest(){
         //click on js prompt button
          //switch to alert than assert/confirm the text is"I am a JS prompt"
          //assert You entered:hello
       WebElement jsPromptButton = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
       jsPromptButton.click();
     
        Alert promptAlert = driver.switchTo().alert();
          System.out.println("Alert text= "+ promptAlert.getText());
          assertEquals(promptAlert.getText(),"I am a JS prompt");

          //enter "hello" and click Ok
          promptAlert.sendKeys("hello");
          promptAlert.accept();
          //assert "You entered: hello" message is displayed
          WebElement resultMsg = driver.findElement(By.xpath("//p[@id='result']"));
          System.out.println("resultMsg.getText() = " + resultMsg.getText());
          Assert.assertEquals(resultMsg.getText(), "You entered: hello");

           

      }








}
