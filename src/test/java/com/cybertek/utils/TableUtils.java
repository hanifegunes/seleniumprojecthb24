package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TableUtils {

   public  static  void verifyOrder (WebDriver driver, String name) {

      List<WebElement > nameList= driver.findElements(By.xpath("//table[@id='table1']//td[contains(text(),'\"+name+\"')]")) ;
      for(WebElement nameOntTheList: nameList) {
         System.out.println("name on the list. get text "+ nameOntTheList.getText());
         Assert.assertTrue(nameOntTheList.getText().contains(name));

      }

   }
    public static void  printNamesAndEmails(WebDriver driver){
     List<WebElement> names  = driver.findElements(By.xpath("//table[@id='table1']//td[2]"));
     List<WebElement>emails= driver.findElements(By.xpath("//table[@id='table1']//td[3]"));
       for(int i= 0; i<names.size(); i++){
           System.out.println("Name"+(i+1)+": "+names.get(i).getText()+" , "+"Email"+(i+1)+": "+emails.get(i).getText()+"\n");
       }

    }



}
   /*
     Practice #5: Method: printNamesAndEmails
• Create a method named printNamesAndEmails in TableUtils class.
• Method takes WebDriver object.
• This method should simply print all the names and emails in the table
• Create a new TestNG test to test if the method is working as expected.
• Output should be like:
• Name1: name , Email1: email
• Name2: name , Email2: email

    */