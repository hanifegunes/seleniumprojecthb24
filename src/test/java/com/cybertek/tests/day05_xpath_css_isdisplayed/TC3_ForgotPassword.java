package com.cybertek.tests.day05_xpath_css_isdisplayed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ForgotPassword {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/forgot_password";
        driver.get(url);
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("yamod35340@dukeoo.com" +
                "");
        WebElement retrievePaBtn = driver.findElement(By.id("form_submit"));
        retrievePaBtn.click();
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("email_sent")){
            System.out.println("Pass: email sent verified");
        }else{
            System.out.println("Failed");
        }

        WebElement message = driver.findElement(By.name("confirmation_message"));
        System.out.println("message displayed = " + message.getText());

        //<h4 name="confirmation_message">Your e-mail's been sent!</h4>

        String expMessage = "Your e-mail's been sent!";
        String actMessage = message.getText();

        if (actMessage.equals(expMessage)) {
            System.out.println("PASS: message displayed correctly");
        } else {
            System.out.println("FAIL: message is not displayed as expected");
        }

        System.out.println("'Name' attribute value of message element = " + message.getAttribute("name"));

        driver.quit();


    }

}


/*
TC #3: PracticeCybertek/ForgotPassword URL verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Enter any email into input box
4. Click on Retrieve password
5. Verify URL contains:
Expected: “email_sent”
6. Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”
Hint: You need to use getText method for this practice


 */