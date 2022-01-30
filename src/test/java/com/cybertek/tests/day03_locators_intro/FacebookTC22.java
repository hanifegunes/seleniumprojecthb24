package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FacebookTC22 {
    public static void main(String[] args) throws InterruptedException {
        /*
        TC #2: Facebook incorrect login title verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Enter incorrect username
4. Enter incorrect password
5. Verify title changed to:
Expected: “Log into Facebook”
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String appUrl = "https://www.facebook.com ";
        driver.get(appUrl);
        // enter username
        driver.findElement(By.id("email")).sendKeys("sdflkfd");//inspect den email
        //enter password
        driver.findElement(By.id("pass")).sendKeys("dhdkj");//inspectetn pass

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click login
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);
        String expectedTitle = "Log into Facebook";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS: title verification successful");


        }else{
            System.out.println("FAIL: title verification failed");

    }
}}
