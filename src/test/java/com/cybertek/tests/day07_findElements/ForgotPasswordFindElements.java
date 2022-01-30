package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ForgotPasswordFindElements {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/forgot_password";
        driver.get(url);//find all linksand store into list of webelements
        List<WebElement>links = driver.findElements(By.tagName("a"));

        //print  count of links
        System.out.println("count of links: "+links.size());
        // print first link
        System.out.println("first link: "+ links.get(0).getText());

        //print text of second one
        System.out.println("second link = " + links.get(1).getText());

        
        






    }
}
