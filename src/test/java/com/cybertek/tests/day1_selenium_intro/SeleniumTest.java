package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {
        // set up the web driver
        WebDriverManager.chromedriver().setup();
        // create the instance of the driver
        WebDriver driver = new ChromeDriver();
        //test if driver is working
        driver.get("https://www.google.com");
    }
}
