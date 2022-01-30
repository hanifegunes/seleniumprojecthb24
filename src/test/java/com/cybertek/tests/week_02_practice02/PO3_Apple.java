package com.cybertek.tests.week_02_practice02;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PO3_Apple {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url ="https://www.apple.com";
        driver.get(url);
        List<WebElement> headers  =driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));
        for(int eachLink=1;  eachLink<headers.size();eachLink++)
       // for(WebElement eachLink : headers)
        {
            System.out.println("Title of current page"+ headers.get(eachLink).getText());
            headers.get(eachLink).click();
            headers= driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

            List<WebElement> totalLinks  =driver.findElements(By.xpath("//body//a"));
            System.out.println("Number of lists: "+ totalLinks.size());
               int linkText = 0;
               int linkNoText = 0;
               for(WebElement link: totalLinks){
                   if (!link.getText().isEmpty()){
                       linkText++;

                   }  else{
                       linkNoText++;
                   }

               }
            System.out.println("Link with text= "+linkText);
            System.out.println("Link without text= "+ linkNoText);
        }
        driver.quit();



    }
}
