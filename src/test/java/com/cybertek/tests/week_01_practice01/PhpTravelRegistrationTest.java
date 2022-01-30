package com.cybertek.tests.week_01_practice01;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhpTravelRegistrationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
       String url = "https://www.phptravels.net";
       driver.get(url);

        WebElement signUp= driver.findElement(By.xpath("//a[@class='theme-btn theme-btn-small waves-effect']"));
        signUp.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.click();
        firstName.sendKeys("adam"+ Keys.ENTER);
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.sendKeys("Grey"+Keys.ENTER);
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
          phone.sendKeys("123654"+Keys.ENTER);
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("abcde@gmail.com"+Keys.ENTER);
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("ert4!34"+Keys.ENTER);
        Thread.sleep(8000);

        WebElement signUpButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']"));
        signUpButton.sendKeys(Keys.ENTER);

        String expectedTitle = "Login - PHPTRAVELS";
        String actualTitle = driver.getTitle();
        System.out.println("expected title "+ expectedTitle);
        System.out.println("actual title: "+ actualTitle);
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("fail");
        }

        WebElement emailLogin = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailLogin.sendKeys("abc@gmail.com"+Keys.ENTER);
        WebElement passwordLogin = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordLogin.sendKeys("ert4!34"+Keys.ENTER);
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();

        //WebElement containsName = driver.findElement(By.tagName("h2"));
        String welcomeName = driver.findElement(By.tagName("h2")).getText();
        System.out.println("welcome "+ welcomeName);
        
        String expectedNamed = "Adam";

        if(welcomeName.contains(expectedNamed)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

               driver.quit();




    }
}
