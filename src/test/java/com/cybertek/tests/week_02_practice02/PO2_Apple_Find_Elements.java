package com.cybertek.tests.week_02_practice02;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PO2_Apple_Find_Elements {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        String url = "https://www.apple.com";
        driver.manage().window().maximize();
        driver.get(url);
        WebElement iphone = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']"));
        iphone.click();
       // iphone.sendKeys(Keys.ENTER);
        List<WebElement> links = driver.findElements(By.tagName("a")) ;
        System.out.println("links "+ links.size());

        int countText = 0;
        int noText= 0;
        for(WebElement each: links){
            each.getText();
            if(!each.getText().isEmpty()){
                countText++;
            } else{
                noText++;
            }

        }
        System.out.println("links "+ links.size()+ "\nhas text "+ countText +"\n no text "+ noText);
        
    }
}
    /*
    TC #02: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to iPhone
4. Print out the texts of all links
5. Print out how many link is missing text
6. Print out how many link has text
7. Print out how many total link



     */