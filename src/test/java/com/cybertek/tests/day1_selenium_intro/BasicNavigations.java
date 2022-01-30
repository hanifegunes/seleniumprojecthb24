package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        //1- set up the browser driver
        WebDriverManager.chromedriver().setup();
        // open browser
        WebDriver driver = new ChromeDriver();
        // navigate to tesla homepage
       driver.get("https://www.tesla.com/");
       // navigate back. similar to clicking back button on the browse

        driver.wait(2000);
        driver.navigate().back();

        // how to call all browsers -> windows
        /*
        go to left bottom corner and click on windows icon
        type powershell then select first option then open
        type "killall google
        click enter
         */
        // pause the code
        Thread.sleep(4000);

        driver.navigate().forward();

        driver.navigate().refresh();
        Thread.sleep(2000);
        // navigate the home page
        driver.navigate().to("https://bestbuy.com");
        // print title of the page
        System.out.println("Current title"+driver.getTitle());
        // close the browser
        driver.quit();




    }
}
