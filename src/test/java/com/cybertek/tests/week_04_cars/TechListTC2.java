package com.cybertek.tests.week_04_cars;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TechListTC2 extends TestBase {
    /*
     1: Verify that there are only 4 structure values present.
Read the 'Structure' column and find out the total number of structures present.
Read the value of 'Total' column and match with the previous step.
     */

  @Test
    public  void structure4Test1(){
   driver.get(ConfigurationReader.getProperty("techlistic.url"));
  List<WebElement> columnName= driver.findElements(By.xpath("//table/tbody/tr/th"));

      for(WebElement webElement: columnName){
          System.out.println("webElement get text: "+ webElement.getText());

      }

      System.out.println("Column size: "+ columnName.size());
      WebElement total = driver.findElement(By.xpath("//table/tfoot/tr/td"));
      Assert.assertEquals(columnName.size(),Integer.parseInt(total.getText().substring(0,1)));

  }
  @Test
  /*
    Read All the Values from the table row-wise and print them all
   */
    public void  allValuesRowWise(){
      driver.get(ConfigurationReader.getProperty("techlistic.url"));
      

    List<WebElement>allValues = driver.findElements(By.xpath("//table/tbody/tr"));
     for(WebElement allValue: allValues){
         System.out.println("all values in the row: "+" " +allValue.getText());
     }
      
  }
  
    


}
