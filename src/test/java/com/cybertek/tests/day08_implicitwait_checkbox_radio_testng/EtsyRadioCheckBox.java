package com.cybertek.tests.day08_implicitwait_checkbox_radio_testng;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EtsyRadioCheckBox {
    public static void main(String[] args) {
        String url = "https://www.etsy.com/";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //implicit wait command
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url) ;
        WebElement searchField = driver.findElement(By.name("search_query"));
         searchField.sendKeys("wooden spoon"+ Keys.ENTER);
       WebElement allFilters= driver.findElement(By.id("search-filter-button"));
       allFilters.sendKeys(Keys.ENTER);
        //select under $25 ==//select Free shipping, on sale, under $25 > click on Apply
         WebElement freeShipping = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
            freeShipping.click();

             WebElement  under25 = driver.findElement(By.xpath("//label[@for='price-input-1']"));
             under25.click();

             WebElement apply = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
             apply.click();

             WebElement results = driver.findElement(By.xpath("(//span[contains(text(),'results')])[1]"));
        System.out.println("results: "+results.getText());

        



    }
}
