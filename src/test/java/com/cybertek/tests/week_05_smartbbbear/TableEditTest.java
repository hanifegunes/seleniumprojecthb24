package com.cybertek.tests.week_05_smartbbbear;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.TableUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TableEditTest extends TestBase {
    @Test
    public  void  verifyOrderTest(){
      driver.get(ConfigurationReader.getProperty("tableedit.url"));
        TableUtils.verifyOrder(driver,"Smith");
       TableUtils.printNamesAndEmails(driver);




        
    }




    
}
 /*
  PRACTICE #4: Method: verifyOrder
• Create a method named verifyOrder in TableUtils class.
• Method takes WebDriver object and String(name).
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.

Practice #5: Method: printNamesAndEmails
• Create a method named printNamesAndEmails in TableUtils class.
• Method takes WebDriver object.
• This method should simply print all the names and emails in the table
• Create a new TestNG test to test if the method is working as expected.
• Output should be like:
• Name1: name , Email1: email
• Name2: name , Email2: email

Use of the methods:
1. Create a new class
2. Create new Tests
3. Read URL using ConfigurationReader.getProperty
4. Test if the utility methods are working as expected.








  */