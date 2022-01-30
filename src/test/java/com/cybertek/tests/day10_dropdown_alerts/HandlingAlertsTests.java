package com.cybertek.tests.day10_dropdown_alerts;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HandlingAlertsTests {

    String url = "http://practice.cybertekschool.com/javascript_alerts";
    WebDriver driver; //can use in every method

    @BeforeMethod   //public @interface @BeforeMethod  --can run this way
    public  void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

    }
    @Test
    public  void  jsAlertsTests() throws InterruptedException {
        WebElement infoAlertLink = driver.findElement(By.xpath("//*[.='Click for JS Alert']"));
        infoAlertLink.click();
            // switch to alert and click on it
        Thread.sleep(1234);
        Alert infoAlert = driver.switchTo().alert();
        System.out.println("Text of alert: "+infoAlert.getText());

            infoAlert.accept();
    }

    @Test
    public  void  confirmAlertTest() throws InterruptedException {
        WebElement confirm = driver.findElement(By.xpath("//*[.='Click for JS Confirm']"));
        confirm.click();
           Thread.sleep(1234);
        Alert alert = driver.switchTo().alert();
        System.out.println("Text to alert: "+ alert.getText());

        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss(); //cancel


    }

    @AfterMethod
    public  void  tearDown(){
        driver.quit();
    }


}
