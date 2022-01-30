package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ClickGmailVerifyTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.google.com";
        driver.get(url);
       // driver.findElement(By.linkText("Gmail")).click();
        //verify title contains/ starts with gmail
        driver.findElement(By.partialLinkText("mail")).click();
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Pass: gmail title verification successful");

        }else {
            System.out.println("Fail: gmail title verification failed");
        }
        driver.navigate().back();
        String googleExpectedTitle = "Google";
        String googleActualTitle = driver.getTitle();
        if(googleActualTitle.equals(googleExpectedTitle)){
            System.out.println("Pass: Google expected title success");
        }else {
            System.out.println("Fail: Google expected title failed");
        }



        driver.quit();


    }
}
