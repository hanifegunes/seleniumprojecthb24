package com.cybertek.tests.day04_locators_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeDemo {
    /*
    navigate to google home page

Locate the search field and assign to WebElement variable
WebElement searchField = driver.findElement(By.name("q"));
     */
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(By.name("q"));
        System.out.println("class value: "+ searchField.getAttribute("class"));
        System.out.println("max length: "+searchField.getAttribute("maxlength"));

        searchField.sendKeys("wooden spoon");
        // read the value that is in the search field.
        System.out.println("current values= "+ searchField.getAttribute("value"));
         // print the name value of the web element

        System.out.println("name= "+ searchField.getAttribute("name"));



    }
}
