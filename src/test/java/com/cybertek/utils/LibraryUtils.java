package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LibraryUtils {


  public static void loginLibrary(WebDriver driver){
      driver.get(ConfigurationReader.getProperty("library.url"));

      WebElement email = driver.findElement(By.id("inputEmail"));
      email.sendKeys("student3366@library");

      WebElement passWord  = driver.findElement(By.id("inputPassword"));
      passWord.sendKeys("MU0rEdlK");
      WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
      signIn.click();
  }








}
