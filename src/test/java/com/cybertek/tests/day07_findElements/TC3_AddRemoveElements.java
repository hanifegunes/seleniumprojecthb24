package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC3_AddRemoveElements {
    public static void main(String[] args) {
        String url = "http://practice.cybertekschool.com/add_remove_elements/";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        // addElement.click();
        for (int i = 0; i <50 ; i++) {
            addElement.click();

        }
         //verify 50 delete buttons are on the page
        List<WebElement>deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("count of delete buttons: "+deleteButtons.size());
             if(deleteButtons.size()==50){
                 System.out.println("Pass");

             }  else{
                 System.out.println("fail");
             }
               //click all delete buttons to remove them
       // for (WebElement deleteButton : deleteButtons) {
          //  deleteButton.click();

       // }  lamda expression
          deleteButtons.forEach(deleteBtn ->deleteBtn.click());
             deleteButtons=driver.findElements(By.xpath("button[.='Delete']")) ;
             //run 1 more time if it is empty
             if(deleteButtons.isEmpty()){
                 System.out.println("Pass");
             } else{
                 System.out.println("fail");
             }

        
    }
}


/*
 This method is used to locate a single web element
• Returns a single web element
• Return type is:
• à“WebElement”
• If it cannot find a WebElement:
• à throws NoSuchElementException.
 */