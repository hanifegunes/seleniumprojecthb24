package com.cybertek.tests.day04_locators_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PercentageCalculatorTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.calculator.net";
        driver.get(url);
        driver.findElement(By.linkText("Percentage Calculator")).click();
        // verify title
        String expectedTitle = "Percentage Calculator";
        String actualTitle = driver.getTitle();

        System.out.println("Current Title: "+driver.getTitle());
        
        

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Pass: ");
        }else {
            System.out.println("Fail: ");
        }
          driver.findElement(By.name("cpar1")).sendKeys("20");
          driver.findElement(By.id("cpar2")).sendKeys("120000", Keys.ENTER);// 120000+Keys.ENTER

        driver.findElement(By.className("h2result")).getText();
        String result = driver.findElement(By.className("h2result")).getText();

        System.out.println("result = " + result);
        //"result : 24000" ends with this number
        if(result.endsWith("24000")){
            System.out.println("Pass: ");
        }else {
            System.out.println("failed");
        }
         driver.quit();
    }
}
