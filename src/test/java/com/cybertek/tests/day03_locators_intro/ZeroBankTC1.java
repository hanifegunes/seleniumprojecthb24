package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankTC1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://zero.webappsecurity.com/login.html";
        driver.get(url);

      //  driver.findElement(By.tagName("h3")).getText();
       // String currentTagName =
        System.out.println("Header text: "+driver.findElement(By.tagName("h3")).getText());
        String header =driver.findElement(By.tagName("h3")).getText();
        System.out.println("Header = " + header);


        String expectedHeader = "Log in to ZeroBank";

        if(header.equals(expectedHeader)) {
            System.out.println("PASS: Header is displayed correctly");
        } else {
            System.out.println("FAIL: Header mismatch");
        }

        driver.quit();

    }
}
