package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.google.com";
        driver.get(url);
        driver.findElement(By.name("q")).sendKeys("apple");
      //  driver.findElement(By.name("q")).sendKeys("wooden spoon");
        Thread.sleep(2000);
        driver.findElement(By.name("btnK")).click();
        // if above two lines did not, try this way;
        //  driver.findElement(By.name("q")).sendKeys("apple"); + Keys.ENTER);

        String acrTitle = driver.getTitle();
        String expTitle= "apple";

        if(acrTitle.indexOf(expTitle)==0){
            System.out.println("Pass: Title match");

        }else {
            System.out.println("Fail: Title does not match");
        }
       driver.quit();
    }
}
