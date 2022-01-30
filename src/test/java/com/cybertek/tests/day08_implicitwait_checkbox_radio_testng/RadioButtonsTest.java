package com.cybertek.tests.day08_implicitwait_checkbox_radio_testng;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonsTest {
    public static void main(String[] args) throws InterruptedException {

     String url = "http://practice.cybertekschool.com/radio_buttons";
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
       // waits upto 10 sec.  while finding element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        WebElement red = driver.findElement(By.id("red"));


        if(!red.isSelected()){
            red.click();
        }

         WebElement basketball = driver.findElement(By.id("basketball"));
        basketball.click();
        if(!basketball.isSelected()){
            basketball.click();

        }


          WebElement football = driver.findElement(By.id("football")) ;
        if(!football.isSelected()){
            football.click();
        }

        if(football.isSelected()) {

            System.out.println(" Pass--Selecting <football> radio button");
        }

        else{
            System.out.println("fail");
        }
      

        List<WebElement> radioButtons  =driver.findElements(By.xpath("//input[@type='radio']"));

        System.out.println("count= "+ radioButtons.size());
       


         for(WebElement radio: radioButtons) {
             radio.click();
         }

             Thread.sleep(2000);

             driver.quit();




    }



}
/*
 List<WebElement>radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        System.out.println(radioButtons.size());
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for(WebElement each: radioButtons){
            if(each.isEnabled()){
                each.click();
            }
        }

     
List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));


        for(WebElement each : radio){
            each.click();
        if(each.isSelected()){
            System.out.println(each.getAttribute("id") + "  is selectable");
        }else{
            System.out.println(each.getAttribute("id") +  " is Not selectable");
        }



 */
