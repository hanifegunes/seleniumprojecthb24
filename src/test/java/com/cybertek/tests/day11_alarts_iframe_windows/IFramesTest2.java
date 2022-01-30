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

public class IFramesTest2 {
    String url = "http://practice.cybertekschool.com/iframe";
    WebDriver driver;

    @BeforeMethod
    public  void setUp(){
         driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         driver.get(url);


    }
    @AfterMethod
   public void  tearDown(){
        driver.quit();
    }

     @Test
    public void iFrameTest(){
         driver.switchTo().frame("mce_0_ifr");
         WebElement commonField = driver.findElement(By.id("tinymce"));
         System.out.println("Command text: "+commonField.getText());
         commonField.clear();
         commonField.sendKeys("hello hello");
         driver.switchTo().defaultContent();


     }
     @Test
    public  void multipleTests(){
      driver.get("http://practice.cybertekschool.com/nested_frames");

         List<WebElement>frames = driver.findElements(By.tagName("frame"));
         System.out.println("Count of frames: "+ frames.size());
         driver.switchTo().frame("frame-bottom");
         WebElement bodyElement = driver.findElement(By.tagName("body"));

         System.out.println("Body text: "+ bodyElement.getText());
         
         driver.switchTo().parentFrame();
         driver.switchTo().defaultContent();

         driver.switchTo().frame(0).switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_right']")));
         bodyElement = driver.findElement(By.tagName("body"));
         System.out.println("right frame text: "+ bodyElement.getText());
      


     }

}
