package com.cybertek.tests.day02_browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CyberTekPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url =  "https://practice.cybertekschool.com/";

        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        if(currentUrl.contains("cybertekschool")){
            System.out.println("Pass: URL verification pass");

        }else {
            System.out.println("Fail: URL verification failed");
        }if(title.equals("Practice")){
            System.out.println("Pass: url verification pass");
        }else {
            System.out.println("Fail: URL verification failed");

        }

        driver.quit();


    }
}
