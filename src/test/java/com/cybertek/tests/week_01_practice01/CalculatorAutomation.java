package com.cybertek.tests.week_01_practice01;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAutomation {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.calculator.net";
        driver.get(url);

        int num1 = 5, num2 = 3;
        int expectedResult = 8;
       // WebElement num5 = driver.findElement(By.cssSelector("span[onclick='r(5)']"));
      //  WebElement plus = driver.findElement(By.cssSelector("span[onclick='r(\\'+\\')']"));
       // System.out.println("+sign "+plus.isDisplayed());
      // WebElement num3 = driver.findElement(By.cssSelector("span[onclick='r(3)']"));
     //   WebElement equal = driver.findElement(By.xpath("(//span[@class='scieq'])[2]"));
      //  System.out.println("equal "+equal.isDisplayed());

       // num5.click();
       // plus.click();
       // num3.click();
       // equal.click();

       // WebElement result = driver.findElement(By.cssSelector("div[id='sciOutPut']"));
       // System.out.println("result "+result.getText());
      //  int actualResult = Integer.parseInt(result.getText().replaceAll("\\W",""));
       // System.out.println("Calculator test :"+(actualResult==expectedResult?"Pass:result":"fail"));
         getTab(4).click();
        // getSign("+").click();
       //  getTab(2).click();
        // getSign("=").click();


        
      
    }
    public static WebElement getTab(int tab){
        String locator = "span[onclick='"+tab+"']";
        return  driver.findElement(By.cssSelector(locator));
    }
    public static WebElement getSign(String sign2){
      String location = "span[onclick='r(\\'"+sign2+"\\')']";
      return driver.findElement(By.cssSelector(sign2));
    }
}
