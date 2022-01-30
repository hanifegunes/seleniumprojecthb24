package com.cybertek.tests.day02_browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooPracticeVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        String url = "https://www.yahoo.com";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String expectedTitle = "Yahoo | Mail,Weather, Search, Politics,News,Finance,Sports & Videos";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Pass: title verification successful");

        }else {
            System.out.println("Fail: title verification failed");
        }
       // if(driver.getTitle().equals("Yahoo | Mail,Weather, Search, Politics")){

      //  }
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle= "+ expectedTitle);
        driver.getTitle();
    }
}
