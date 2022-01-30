package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsDemoTest extends TestBase {

    @Test
    public void hoverElementTest(){
      driver.get(ConfigurationReader.getProperty("hover.url"));
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        //create a action class object to be able to hover over img

        //hover over img1    //actions is a class, not interface , accepts object
         actions.moveToElement(img1).perform();
        BrowserUtils.sleep(2);

        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        actions.moveToElement(img2).perform();
        BrowserUtils.sleep(2);

        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
        actions.moveToElement(img3).perform();


    }
    
   /*
     List<WebElement> images = driver.findElements(By.xpath("//div/img"));
        for (WebElement image : images) {
            actions.moveToElement(image).perform();

        }


    */
  @Test
    public void hoverOverGroupOfElements(){
      driver.get(ConfigurationReader.getProperty("hover.url"));
      List<WebElement> images = driver.findElements(By.tagName("img"));
      for(WebElement img: images){
          BrowserUtils.sleep(2);
          actions.moveToElement(img).perform();
      }

  }
     @Test
    public void googleFeelingLuckyBtnHoverTest(){
     driver.get(ConfigurationReader.getProperty("google.url"));
     //locate 2 buttons
      WebElement searchBtn = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search']"));
      WebElement feelingLuckyBtn = driver.findElement(By.id("gbqfbb"));
      actions.moveToElement(feelingLuckyBtn).perform();
      BrowserUtils.sleep(2);
      actions.moveToElement(searchBtn).perform();

      for(int i = 0; i<=5; i++){
          actions.moveToElement(feelingLuckyBtn).perform();
          BrowserUtils.sleep(2);
          actions.moveToElement(searchBtn).perform();
          BrowserUtils.sleep(2);


      }



     }


}
