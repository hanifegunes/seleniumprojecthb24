package com.cybertek.tests.week_01_practice01;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorTest {
    public static void main(String[] args) {
        Integer num1=100000,num2=4;
        int expectedResult = num1+num2;
        String number2 = num2 +"";
        String number1 = ""+num1;

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.calculator.net";
        driver.get(url);
       // int num1 = 5, num2 = 3;
       // int expectedResult = 8;

        for (int i = 0; i <number1.length() ; i++) {
            driver.findElement(By.xpath("//span[.='"+number1.charAt(i)+"']")).click();

        }
        for (int i = 0; i <number2.length() ; i++) {
            driver.findElement(By.xpath("//span[.='"+number2.charAt(i)+"']")).click();

        }
        


        WebElement num2Elem = driver.findElement(By.xpath("//span[.='"+num2+"']"));
        WebElement plus = driver.findElement(By.xpath("//span[.='+']"));
        WebElement equals = driver.findElement(By.xpath("//span[.='=']"));


        plus.click();
        num2Elem.click();




    }
}
