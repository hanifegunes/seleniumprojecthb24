package com.cybertek.tests.week_02_practice02;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GasMileageCalculator {
    public static void main(String[] args) {

        String url = "https://www.calculator.net ";
        WebDriver driver = WebDriverFactory.getDriver("chrome") ;
        driver.get("https://www.calculator.net");
        driver.manage().window().maximize();
        WebElement calculBox = driver.findElement(By.id("calcSearchTerm"));
        calculBox.sendKeys("gas mileage", Keys.ENTER);
        driver.findElement(By.linkText("Gas Mileage Calculator")).click();
          String expectedTitle = "Gas Mileage Calculator";
        String  actualTitle = driver.getTitle();
            if(actualTitle.equals(expectedTitle)) {
                System.out.println("pass");
            } else{
                System.out.println("Fail");
            }
            WebElement label = driver.findElement(By.xpath("//h1[.='Gas Mileage Calculator']"));
        System.out.println(label.isDisplayed()?"Pass":"Fail");
        List<WebElement>input =driver.findElements(By.cssSelector("input[type='text'"));

        for (int i = 0; i <4 ; i++) {
            input.get(i).clear();

        }  input.get(0).sendKeys("7925");
           input.get(1).sendKeys("7550");
           input.get(2).sendKeys("16");
           input.get(3).sendKeys("3.55");
           driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        System.out.println(driver.findElement(By.xpath("//font[@color='green']")).getText());

    }
}
     /*
      Add a new class GasMileageCalculatorTest
- Goto https://www.calculator.net
- Search for “gas mileage” using search box
- Click on the “Gas Mileage Calculator” link 
      On Next page verify:
o Title equals: “Gas Mileage Calculator”
o “Gas Mileage Calculator” label is displayed
        Locate, clear and type “7925” into “Current odometer” field
- Locate, clear and type “7550” into “Previous odometer” field
- Locate, clear and type “16” into “Gas added” field
- Locate, clear and type “3.55” into “Gas price” field and Click on Calculate button

        Locate and print the mpg value

      */