package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EtsySubscribeTest extends TestBase {
    @Test
    public void randomEmailSubscribeTest(){
    driver.get(ConfigurationReader.getProperty("etsy.url"));

   // JavascriptExecutor js= (JavascriptExecutor)driver;
   // js.executeScript("window.scrollBy(0, 5000)");
     //   ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 5000)");


        BrowserUtils.scrollDown(4000);
        WebElement email = driver.findElement(By.name("email_address"));
      //  Faker faker = new Faker(); testbase has already has it
        email.sendKeys(faker.internet().emailAddress()+ Keys.ENTER);

       WebElement successMsg= driver.findElement(By.xpath("//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']"));
        Assert.assertTrue(successMsg.isDisplayed());
        Assert.assertEquals(successMsg.getText(),"Great! We've sent you an email to confirm your subscription.");









    }

    



    
}
 /*
 Goto Etsy homepage
Scroll down
Generate random email and enter into subscribe box
Click on Subscribe
Verify "Great! We've sent you an email to confirm your subscription." is displayed



  */