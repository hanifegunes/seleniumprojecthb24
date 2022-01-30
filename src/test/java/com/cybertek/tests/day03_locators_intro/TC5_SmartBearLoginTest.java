package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_SmartBearLoginTest {
    public static void main(String[] args) throws InterruptedException {

       String appUrl = ("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        String userName = "Tester";
        String passWord = "test";


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(appUrl);

        String currentTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";

      // if(currentTitle.equals(expectedTitle)) {
          //  System.out.println("PASS: Web Orders title verification is successful");

            //driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");// enter userName
            driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);


           // driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"); //enter password
             driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(passWord);
           Thread.sleep(2000);
            driver.findElement(By.id("ctl00_MainContent_login_button")).click();
            String currentTitle2 = driver.getTitle();
            String expectedTitle2 = "Web Orders";
            if (currentTitle2.equals(expectedTitle2)) {
                System.out.println("PASS: Login title verification is successful");
            } else {
               System.out.println("PASS: Login title verification is failed");
           }

           driver.findElement(By.linkText("Logout")).click();
           // driver.findElement(By.id("ctl00_logout"));
            Thread.sleep(2000);



           driver.quit();

}}
