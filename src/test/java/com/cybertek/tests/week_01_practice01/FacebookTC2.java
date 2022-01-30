package com.cybertek.tests.week_01_practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTC2 {
    public static void main(String[] args) throws InterruptedException {

        String userName = "abc@gmail.com";
        String actualUserName = "";
        String expectedPassword = "";
        String password = "test07";





        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.facebook.com/";
        driver.get(url);


        driver.findElement(By.id("pass")).sendKeys(password);

        driver.findElement(By.id("email")).sendKeys(userName);

       //  Thread.sleep(2000);
       //  String userName = driver.findElement(By.id("abc@gmail.com")).getText();


       driver.findElement(By.name("login")).click();
        Thread.sleep(2000);

        String expectedTitle = "Log into Facebook";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Pass: ");
        }else{
            System.out.println("Fail: ");
        }




    }
}
