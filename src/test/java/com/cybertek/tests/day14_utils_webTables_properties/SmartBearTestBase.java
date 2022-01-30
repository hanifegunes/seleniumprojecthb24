package com.cybertek.tests.day14_utils_webTables_properties;

import com.cybertek.utils.SmartBearUtils;
import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class SmartBearTestBase {

    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);


    }

    @AfterMethod
    public  void  tearDown(){
        driver.quit();
    }

           @Test
    public  void  orderVerification(){
        SmartBearUtils.loginToSmartBear(driver);
         SmartBearUtils.verifyOrder(driver,"Paul Brown");

    }

        
    }




