package com.cybertek.tests.week_04_cars;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TechlisticTC1 extends TestBase {
      @Test
    public void lastRowTest() {
        driver.get(ConfigurationReader.getProperty("techlistic.url"));
        List<WebElement> lastRow = driver.findElements(By.xpath("//table/tfoot/tr/*"));
        System.out.println("lastRow.size() = " + lastRow.size());
        Assert.assertEquals(lastRow.size(), 2);
    }
    @Test
    public  void BurcjHeight(){
    driver.get(ConfigurationReader.getProperty("techlistic.url"));
        WebElement burjKhalifaHeight = driver.findElement(By.xpath("//table/tbody/tr/th[contains(text(), 'Burj Khalifa')]/following-sibling::td[3]"));
        int height =Integer.parseInt(burjKhalifaHeight.getText().substring(0,3));
        Assert.assertEquals(burjKhalifaHeight.getText(), "829m");
         /*
 Assignment 3: Verify that Burj Khalifa has a height of 829m (similar for other structures)
  */

    }

  @Test
    public void allValuesRow(){

      driver.get(ConfigurationReader.getProperty("techlistic.url"));
      List<WebElement> rows = driver.findElements(By.xpath("//table/tbody"));
      for (WebElement row : rows) {
          System.out.println("row.getText() = " + row.getText());

      }

          
  }
  @Test
          public void allValuesRead() {


      driver.get(ConfigurationReader.getProperty("techlistic.url"));
      List<WebElement> columnName = driver.findElements(By.xpath("//table/tbody/tr/th"));
      for(WebElement webElement: columnName){
          System.out.println("webElement.getText: "+ webElement.getText());
      }


      WebElement total = driver.findElement(By.xpath("//table/tfoot/tr/td"));
      Assert.assertEquals(columnName.size(), Integer.parseInt(total.getText().substring(0,1)));






  }
}
