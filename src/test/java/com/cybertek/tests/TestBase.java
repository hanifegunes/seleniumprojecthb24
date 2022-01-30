package com.cybertek.tests;

import com.cybertek.utils.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
   // protected JavascriptExecutor js= (JavascriptExecutor)driver;
    protected Faker faker = new Faker();
    protected Actions actions ;
  //  protected WebDriverWait wait;
    @BeforeMethod
    public void setUp() {

        driver = Driver.getDriver();
      //  driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;  in driver class we already have them
       actions = new Actions(driver);
     //  wait  = new WebDriverWait(driver,20);

    }

    @AfterMethod
    public void tearDown() {
      //  Driver.closeDriver();
      //  driver.close(); it is not usable, closing and making null at the same time
    }






}
