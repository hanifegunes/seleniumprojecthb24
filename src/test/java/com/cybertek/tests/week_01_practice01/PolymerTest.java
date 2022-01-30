package com.cybertek.tests.week_01_practice01;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PolymerTest {

    /*
    Write a basic browser automation framework to validate a Polymer website.

The focus should be on the interaction with the browser.
The Web Application under test http://todomvc.com/
    The first step should be to load the website,
    click within the JavaScript tab,
    and select the Polymer link.
    The second step should be: Add one
    Then Verify that the item added.
    
     */
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("Chrome");
          driver.manage().window().maximize();
          String url = "http://todomvc.com";
          driver.get(url);
          driver.manage().window().maximize();
          WebElement jScript= driver.findElement(By.xpath("//div[@class='tab-content flex-auto center-center horizontal layout style-scope paper-tab']"));
          jScript.click();
          WebElement polymer= driver.findElement(By.linkText("Polymer"));
                  polymer.click();

                  WebElement toDo = driver.findElement(By.xpath("//input[@class='new-todo style-scope td-todos']"));
                   // toDo.click();
                    toDo.sendKeys("do it "+ Keys.ENTER);
                  if(toDo.isDisplayed()){
                      System.out.println(true);
                  }else{
                      System.out.println(false);
                  }
                   driver.quit();
    }
    
}
