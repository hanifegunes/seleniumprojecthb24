package com.cybertek.tests.week_03_practice03;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownTC1 {
   String url = "http://practice.cybertekschool.com/dropdown";
   WebDriver driver;


   @BeforeClass
   public void setUp() {
      System.out.println("Setting up WebDriver...");
      driver = WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.get(url);
   }

      @Test ()
   public  void  simpleDropDownTest(){
          Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));
         WebElement actualDropdown = driver.findElement(By.xpath("//option[.='Please select an option']"));
         Assert.assertEquals(actualDropdown.getText(),"Please select an option");

          WebElement actualStateSelect = driver.findElement(By.xpath("//option[.='Select a State']")) ;
          Assert.assertEquals(actualStateSelect.getText(),"Select a State");


         System.out.println("Please select an option "+ actualDropdown);
          System.out.println("Select a state "+ actualStateSelect);
         /*
          Verify “Simple dropdown” default selected value is correct
       Expected: “Please select an option”
         4. Verify “State selection” default selected value is correct
         Expected: “Select a State”


          */

          driver.quit();

   }

   /*
   : Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)


   
    */

    @Test()
      public  void  selectState(){
        Select selectState = new Select(driver.findElement(By.id("state")));
        driver.findElement(By.xpath("//option[.='Select a State']"));
          // selectState.selectByValue("IL");
        selectState.selectByValue("VA");
      //  selectState.selectByValue("CA");
        selectState.selectByVisibleText("Illinois");
      // selectState.selectByVisibleText("California");
      //  selectState.selectByVisibleText("Virginia");
        selectState.selectByIndex(5);
        WebElement lastSelected = driver.findElement(By.xpath("//option[.='California']"));
           Assert.assertEquals(lastSelected.getText(),"California");
        System.out.println("last selected "+ lastSelected.getText());
         driver.quit();
    }
      /*
      Selecting date on dropdown and verifying
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/dropdown
    3. Select “December 1st, 1922” and verify it is selected.
    Select year using : visible text
    Select month using : value attribute
    Select day using : index number

      
       */

    @Test()

    public  void  selectDate(){
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));
       selectYear.selectByVisibleText("1922");
       selectMonth.selectByValue("11");
       selectDay.selectByIndex(0);
        System.out.println("Date:"+ selectMonth.getFirstSelectedOption().getText()+" "+selectDay.getFirstSelectedOption().getText()+" "+selectYear.getFirstSelectedOption().getText());
         driver.quit();
    }



   





}
