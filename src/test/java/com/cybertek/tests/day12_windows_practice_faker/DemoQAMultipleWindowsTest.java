package com.cybertek.tests.day12_windows_practice_faker;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoQAMultipleWindowsTest {

    WebDriver driver;
    String demoQAUrl = "https://demoqa.com/browser-windows";
    
      /*
        Click on New Window Button
     Switch to new Window
     Locate and print the message
     Close the window
     Go back to main window

1

      
      
       */
    

    @BeforeMethod
    public void setUp() {
        driver =   WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(demoQAUrl);
    }



   @Test
    public  void  getWindowTest() throws InterruptedException {
       WebElement newWindow = driver.findElement(By.cssSelector("#windowButton"));
       newWindow.click();
       Thread.sleep(2000);
      // driver.close();  // close currently open window
       //driver quit(); closes all windows in same session

       Set<String> windowHandleSet = driver.getWindowHandles();
       String parentWindowHandle = driver.getWindowHandle();//store current window handle
       for(String windowHandle: windowHandleSet){
           if(!windowHandle.equals(parentWindowHandle)){
               driver.switchTo().window(windowHandle);
           }
       }



       WebElement header = driver.findElement(By.cssSelector("#sampleHeading"));
       System.out.println("header text: "+ header.getText());
       Thread.sleep(2000);
          driver.close();
          // go back the parent window;
      // System.out.println("title : "+ driver.getTitle());
          driver.switchTo().window(parentWindowHandle);
       System.out.println("title: "+ driver.getTitle());


   }
   @AfterMethod
    public  void tearDown(){
        driver.quit();
   }




}
