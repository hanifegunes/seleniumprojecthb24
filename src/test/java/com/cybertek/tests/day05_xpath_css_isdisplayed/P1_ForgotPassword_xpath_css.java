package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_ForgotPassword_xpath_css {
    public static void main(String[] args) {
        String appUrl = "http://practice.cybertekschool.com/forgot_password";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(appUrl);
        driver.manage().window().maximize();

        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement emailLabel;
        WebElement emailField;
        WebElement retrievePasswordBtn;
        WebElement poweredByLabel;

        System.out.println("homelink = "+ homeLink.isDisplayed());




    }
}
