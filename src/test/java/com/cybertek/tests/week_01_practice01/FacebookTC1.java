package com.cybertek.tests.week_01_practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTC1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();;
        String url = "https://www.facebook.com ";
        driver.get(url);
        String expectedTitle ="Facebook - Log In or Sign Up";
        System.out.println("expectedTitle = " + expectedTitle);

        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Pass: Login title verification is successful");
        }else {
            System.out.println("Fail: Login title verification is failed ");
        }

    }
}
