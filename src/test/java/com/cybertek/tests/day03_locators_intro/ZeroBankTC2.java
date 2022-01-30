package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankTC2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        String appUrl = "http://zero.webappsecurity.com/login.html";
        driver.get(appUrl);
        String textOfLink = driver.findElement(By.className("brand")).getText();
        driver.findElement(By.className("brand")).getText();

        Thread.sleep(2000);

        String actualLinkText = driver.findElement(By.className("brand")).getText();
        System.out.println("text of the link: "+textOfLink);
        Thread.sleep(2000);
       //String expectedLinkText="Zero Bank";
        if(textOfLink.equals("Zero Bank")){
            System.out.println("Pass");
        }else{
            System.out.println("fail");
        }
         String herf = driver.findElement(By.className("brand")).getAttribute("herf");

        System.out.println("herf: "+herf);
        Thread.sleep(2000);
      // driver.quit();
    }
}
