package com.cybertek.tests.week_01_practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsySearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.etsy.com/";
        driver.get(url);
          Thread.sleep(1000);
     String expectedTitle = "wooden spoon";
     String actualTitle = driver.getTitle();

      //  System.out.println(actualTitle.startsWith(expectedTitle)? "Title verification:Pass!":"Failed");
        System.out.println(actualTitle +": "+ expectedTitle);
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Pass: ");
        }else {
            System.out.println("Fail:");
        }

        // Thread.sleep(2000);

        driver.findElement(By.linkText("Holiday Shop")).click();
        Thread.sleep(2000);
        String expectHeader = "Holiday Shop";
     String head =   driver.findElement(By.tagName("h1")).getText();// "The Holiday Shop"
        System.out.println(expectHeader+": "+head);
       // System.out.println(head.equals(expectHeader)? "Head verification: Pass!":"Failed");
        if(head.equals(expectHeader)){
            System.out.println("Pass:");
        }else {
            System.out.println("Failed: ");
        }


       // Thread.sleep(2000);

       // driver.quit();


    }
}
