package com.cybertek.tests.day10_dropdown_alerts;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CarGurusUsedCarSearchTest {

    String url = "https://www.cargurus.com";
    WebDriver driver; //can use in every method

      @BeforeMethod   //public @interface @BeforeMethod  --can run this way
    public  void setUp(){
          driver= WebDriverFactory.getDriver("chrome");
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          driver.get(url);

      }

        @Test
    public  void  searchForMinivanTest(){
          String expectedTittle = "Buy & Sell Cars: Reviews, Prices, and Financing - CarGurus";
            Assert.assertEquals(driver.getTitle(),"Buy & Sell Cars: Reviews, Prices, and Financing - CarGurus");

            Select make = new Select(driver.findElement(By.id("carPickerUsed_makerSelect")));
            make.selectByVisibleText("Toyota");
            //select Sienna
             //  <option value="d308" class="selectOption">Sienna</option>

            Select model = new Select(driver.findElement(By.id("carPickerUsed_modelSelect"))) ;
            model.selectByValue("d308");

            WebElement zipCode = driver.findElement(By.name("zip"));
            zipCode.sendKeys("22102");
              // print selected options of model 
            System.out.println("Selected make: "+ make.getFirstSelectedOption().getText());
            System.out.println("Selected model: "+ model.getFirstSelectedOption().getText());
             WebElement search = driver.findElement(By.id("dealFinderForm_0")) ;
             search.click();

             WebElement resultCount = driver.findElement(By.xpath("//span[@class='oKvYB4']/strong[2]"));
            System.out.println("Result count: "+ resultCount.getText());
            int count = Integer.parseInt(resultCount.getText());
            Assert.assertTrue(count>0);

        }
        @AfterClass
    public  void tearDown(){
          driver.quit();
        }





}
