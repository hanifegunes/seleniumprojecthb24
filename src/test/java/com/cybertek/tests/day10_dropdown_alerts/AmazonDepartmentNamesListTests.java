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
import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDepartmentNamesListTests {
    String url = "https://www.amazon.com/";
    WebDriver driver;

    @BeforeMethod
    public  void setUp(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.get(url);

    }
    /*
     add new class AmazonDepartmentNamesListTest

add setUp method with @BeforeMethod annotation:
    launch selenium, maximize, set timeout, navigate to amazon

add @Test amazonDepartmentTest

assert Amazon home page is displayed
assert that "All" option is selected by default/automatically

get All available options and print out


     */

    @Test
    public  void amazonDepartmentTest() throws InterruptedException {
        String expectedTittle = "Amazon.com. Spend less. Smile more." ;
        Assert.assertEquals(driver.getTitle(),expectedTittle);
       // WebElement  = driver.findElement(By)
          // assert that "All" option is selected by default /automatically

        Select departments = new Select(driver.findElement(By.id("searchDropdownBox")));
        String selectOption = departments.getFirstSelectedOption().getText();
        assertEquals(selectOption,"All Departments");
       List<WebElement> allDepartments  = departments.getOptions();
       int countOfDepartments = allDepartments.size();
        System.out.println("Size of all departments: "+ countOfDepartments);

          assertTrue(countOfDepartments>10,"Department names are missing");
         //loop and print all available options

        for(WebElement dept: allDepartments){
            System.out.println(dept.getText());
        }

        System.out.println("===using for each loop with lambda expression");
          allDepartments.forEach(dept-> System.out.println(dept.getText()));

          // select  each iten by order and wait msn in between
        for(WebElement dept: allDepartments){
            departments.selectByVisibleText(dept.getText());
            Thread.sleep( 400);


        }
        

    }
    @Test(enabled = false)// skip this test
    public  void  testDemo(){
        System.out.println("testDemo is running");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }










}
