package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WordPopulationXpathTest {
    public static void main(String[] args) throws InterruptedException {

      /*
      Goto https://www.worldometers.info/world-population/
wait 4 seconds
Locate current world population number using relative xpath
loop from 1 to 10
    print the text of the element
    wait 1 second

       */


        String appUrl = "https://www.worldometers.info/world-population";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);
        Thread.sleep(4000);

        WebElement wordPopulation = driver.findElement(By.xpath("//div[@class='maincounter-number']"));
        System.out.println(wordPopulation.getText());

        for (int i = 1; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(i+"- "+ wordPopulation.getText());

        }
         driver.quit();

    }
}
