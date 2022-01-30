package com.cybertek.tests.day10_dropdown_alerts;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultiSelectDropdown {
    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;


    @BeforeClass
    public void setUp() {
        System.out.println("Setting up WebDriver...");
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

       @Test

    public void selectMultipleLanguagesTests() throws InterruptedException {
        Select language =  new Select(driver.findElement(By.name("Languages")));
        language.selectByVisibleText("Java");
        language.selectByVisibleText("JavaScript");
        language.selectByVisibleText("Python");

        System.out.println("language.isMultiple : "+ language.isMultiple());
        Thread.sleep(1234);
        language.deselectAll();

        for(WebElement each: language.getOptions()){
             each.click();
        }


    }




}
