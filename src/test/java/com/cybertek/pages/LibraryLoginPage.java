package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

 public LibraryLoginPage(){
  //Selenium command to initialize the element below
  PageFactory.initElements(Driver.getDriver(), this);
 }


 @FindBy(id = "inputEmail")
 public WebElement email;

 @FindBy(id="inputPassword")
 public WebElement password;

 @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']") //[.='Sign in']
 public WebElement signInBtn;
  @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
   public  WebElement errorMsg;
 // WebElement errorMsg = driver.findElement(By.className("alert alert_danger"));







}
