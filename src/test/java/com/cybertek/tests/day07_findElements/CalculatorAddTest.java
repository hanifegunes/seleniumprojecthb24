package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.calculator.net";
        driver.get(url);
        int num1 = 5, num2 = 3;
        int expectedResult = 8;

        WebElement num5 = driver.findElement(By.cssSelector("span[onclick='r(5)']"));
        WebElement plus = driver.findElement(By.cssSelector("span[onclick='r(\\'+\\')']"));
         System.out.println("+sign "+plus.isDisplayed());
         WebElement num3 = driver.findElement(By.cssSelector("span[onclick='r(3)']"));
           WebElement equal = driver.findElement(By.xpath("(//span[@class='scieq'])[2]"));  //  "//span[.='+']"
          System.out.println("equal "+equal.isDisplayed());                                 //    "//span[@text()='=']"

         num5.click();
         plus.click();
         num3.click();
         equal.click();

         WebElement result = driver.findElement(By.cssSelector("div[id='sciOutPut']"));
         System.out.println("result "+result.getText());
        System.out.println(num1+" + "+num2+" + "+" = "+result.getText());

        String resultValue = result.getText();
        resultValue = resultValue.trim();
        //convert from String to int
        int actualResult = Integer.parseInt(resultValue);

         // int actualResult = Integer.parseInt(result.getText().replaceAll("\\W",""));
         System.out.println("Calculator test :"+(actualResult==expectedResult?"Pass:result":"fail"));

           driver.quit();


}  }
