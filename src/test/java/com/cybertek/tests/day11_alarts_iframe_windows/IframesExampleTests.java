package com.cybertek.tests.day11_alarts_iframe_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IframesExampleTests {

    String url= "http://practice.cybertekschool.com/iframe";
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
    public void  iframeTest(){
        //switch to frame 
         driver.switchTo().frame("mce_0_ifr");
        WebElement commonField = driver.findElement(By.id("tinymce"));
        System.out.println("Command text: "+commonField.getText());
          commonField.clear();
          commonField.sendKeys("hello hello");

          //go out from iframe back to  main content
           driver.switchTo().defaultContent();
    }
        @Test
    public void multipleTests(){
         driver.get("http://practice.cybertekschool.com/nested_frames");
         // find out count of frames in this page
            List<WebElement> frames = driver.findElements(By.tagName("frame"));
            System.out.println("count of frames= "+ frames.size());
           // switch to buttom frame by name
            driver.switchTo().frame("frame-bottom");
            WebElement bodyElement = driver.findElement(By.tagName("body"));
            System.out.println(" Text of button frame:  " + bodyElement.getText());

            //go out frame to main level
            driver.switchTo().defaultContent();
            driver.switchTo().frame(0).switchTo().frame(1);// switch to first ->  index 0
            bodyElement= driver.findElement(By.tagName("body"));
            System.out.println("Frame 0 body element text "+ bodyElement.getText());

             //go back parent frame then main level
            driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            driver.switchTo().frame(0).switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_right']")));
            bodyElement = driver.findElement(By.tagName("body"));
            System.out.println("Frame right element text: "+ bodyElement.getText());




        
        }






}
