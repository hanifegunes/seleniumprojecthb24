package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultipleButtonsXpathTest {
    public static void main(String[] args) {
        String appUrl = "http://practice.cybertekschool.com/multiple_buttons";
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get(appUrl);
        /*
      copy all xpath -> /html/body/div/div[2]/div/div[1]/button[1]
       copy element;->  <button class="btn btn-primary" onclick="button1()">Button 1</button>
       -->
        if someone needs:
      if you need to search multiple attributes to track down a locator, you can use "and" like this:
      driver.findElement(By.xpath("//button[@id='form_submit' and @type='submit']"));



         */

        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        WebElement resultMsg = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println(resultMsg.getText());

        // locate button2 using xpath and check if it is currently displayed on the page
        // then click on it   " //button[.='Button2']"
       // WebElement button2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        WebElement button2 = driver.findElement(By.xpath("//button[.='Button 2']"));

        if(button2.isDisplayed()){
            System.out.println("Pass: Button2 is displayed");
            button2.click();
        }else {
            System.out.println("Failed - Button2 is not displayed");

        }
      //  driver.quit();


    }
}

/*
TC #6: XPATH LOCATOR practice
1. Open Chrome browser
2. Go to C http://practice.cybertekschool.com/multiple_buttons
3. Click on Button 1
4. Verify text displayed is as expected:
Expected: “Clicked on button one!”
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS


 */