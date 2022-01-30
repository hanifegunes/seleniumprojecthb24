package com.cybertek.tests.oH04;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import com.cybertek.utils.OfficeUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PlaceOrderTest extends TestBase {

   int expectedPrice= 0;
  @Test
  public  void PlaceOrder(){
    driver.get(ConfigurationReader.getProperty("demoblaze.url"));

   // OfficeUtils.addProduct("Laptops","Sony vaio i7");
     //adding laptops sony vaio i7
    expectedPrice+= OfficeUtils.addProduct("Laptops","Sony vaio i7");
    //adding iphone
    expectedPrice+= OfficeUtils.addProduct("Phones","Iphone 6 32gb");
    //adding monitor
    expectedPrice+= OfficeUtils.addProduct("Monitors","Apple monitor 24");
    System.out.println(expectedPrice);
    OfficeUtils.getLink("Cart").click();


    // I  try to locate delete button dynamically: I want to provide product's name so it will return me webelement

    //                //tbody//tr//td[contains(text(),'Sony vaio i7')] = this finds me cell that includes the product name
    //               //..:   going to parent (row of that cell)
    //              // td[.='Delete']/a   :  goes back down to child which has Delete element cell

    Driver.getDriver().findElement(By.xpath("//tbody//tr//td[contains(text(),'Iphone 6 32gb')]//..//td[.='Delete']/a"));







  }






}
