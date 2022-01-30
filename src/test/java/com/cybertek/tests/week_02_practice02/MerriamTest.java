package com.cybertek.tests.week_02_practice02;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MerriamTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        String url = "https://www.merriam-webster.com/";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(2000);

        List<WebElement> links = driver.findElements(By.xpath("//body//a")) ;
        System.out.println(links.size()+ " total links on this page");

        int hasText = 0;
        int noText = 0;
        for (WebElement each : links) {
            each.getText();
            if(!each.getText().isEmpty()){
               hasText++;
        }    else {
                noText++;
        }

        }
        System.out.println(hasText+" links has text \n"+ noText + " has no text");

    }


}


/*

TC #0: FINDELEMENTS
1. Open Chrome browser
2. Go to https://www.merriam-webster.com/
3. Print out the texts of all links
4. Print out how many link is missing text
5. Print out how many link has text
6. Print out how many total link

 */