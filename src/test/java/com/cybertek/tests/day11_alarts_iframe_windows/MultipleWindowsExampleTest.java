package com.cybertek.tests.day11_alarts_iframe_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindowsExampleTest {
     String url = "http://practice.cybertekschool.com/windows";
     WebDriver driver;
     String demoQaUrl = "https://demoqa.com/browser-windows";

     @BeforeMethod
     public  void setUp(){
          driver= WebDriverFactory.getDriver("chrome");
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          driver.get(url);

     }
     @AfterMethod
     public  void tearDown() {
           driver.quit();
     }

     @Test
     public  void windowsTest(){

     String mainWindowHandle =driver.getWindowHandle();
          //get current window handle
          System.out.println("mainWindowHandle= "+ mainWindowHandle);
            // click on new window
          WebElement newWindowLink = driver.findElement(By.linkText("Click Here"));
          newWindowLink.click();

          Set<String> windowsHandles = driver.getWindowHandles();
          System.out.println("count of windows "+ windowsHandles.size());
          System.out.println("windowHandles ="+ windowsHandles);
          //loop and switch to a different window

          for(String windowHandle: windowsHandles){
               driver.switchTo().window(windowHandle);
               System.out.println("Current window title= "+ driver.getTitle());
          }

          WebElement h3Element= driver.findElement(By.xpath("//h3"));
          System.out.println("h3 header on new page= "+ h3Element.getText());
           // go back to parent window/main window
          driver.switchTo().window(mainWindowHandle) ;
          System.out.println("Title back to main window: "+ driver.getTitle());

     }
       @Test
     public void  demoMultipleTests() throws InterruptedException {
         driver.get(demoQaUrl);
            WebElement newTab = driver.findElement(By.id("tabButton"));
          WebElement newElement = driver.findElement(By.id("windowButton"));
          WebElement newWindowWithMessage = driver.findElement(By.id("messageWindowButton"));
             newTab.click();
             Thread.sleep(4000);
             newElement.click();
             Thread.sleep(4000);
             newWindowWithMessage.click();
            System.out.println("Tittle of main page= "+ driver.getTitle());
            //store main  window handle id in variable
            String parentWindowHandle = driver.getWindowHandle();

            //store all window handle ids in to a set
              Set<String> allWindowHandles = driver.getWindowHandles();
            System.out.println("total window count  " + allWindowHandles.size());

           //  allWindowHandles.forEach(window->{
            //      System.out.println("Switching to : "+ window);
            //      driver.switchTo().window(window);
             //     System.out.println("Current window title: "+ driver.getTitle());
           //  });






       }




    
}
