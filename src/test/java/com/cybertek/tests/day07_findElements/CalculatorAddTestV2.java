package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTestV2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.calculator.net";
        driver.get(url);
        int num1 = 5, num2 = 3;
        int expectedResult = 8;

        WebElement num1Elem = driver.findElement(By.xpath("//span[.='"+num1+"']"));
        WebElement num2Elem = driver.findElement(By.xpath("//span[.='"+num2+"']"));
        WebElement plus = driver.findElement(By.xpath("//span[.='+']"));
        WebElement equals = driver.findElement(By.xpath("//span[.='=']"));

        num1Elem.click();
        plus.click();
        num2Elem.click();
        equals.click();

        WebElement result = driver.findElement(By.xpath("//div[@id='sciOutPut']"));
        System.out.println("Result = " + result.getText());

        driver.quit();
    }
}
