package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverFactoryTest {
    public static void main(String[] args) {
        WebDriver driver  = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.etsy.com");

        WebDriver driver1 = WebDriverFactory.getDriver("chrome");
        driver1.get("https://www.google.com");

    }
}
