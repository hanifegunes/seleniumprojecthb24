package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest01 {
    public static void main(String[] args) {
        // 1) set up browser driver
        WebDriverManager.chromedriver().setup();
        // 2) open the browser.Create object of ChromeDriver class
        WebDriver driver = new ChromeDriver();
        /*
        ArrayList<Integer> driver = new ArrayList<>();

         */
        // 3- go to google homepage
        driver.get("https://www.google.com");
    }

}
