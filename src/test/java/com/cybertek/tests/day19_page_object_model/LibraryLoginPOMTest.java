package com.cybertek.tests.day19_page_object_model;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LibraryLoginPOMTest extends TestBase {

@Test
public void invalidCredentialsTest() {
    driver.get(ConfigurationReader.getProperty("library.url"));
    //create object of LibraryLoginPage page object class
    LibraryLoginPage loginPage = new LibraryLoginPage();
    //access email WebElement and type the email
    loginPage.email.sendKeys("invalid_email@gmail.com");
    loginPage.password.sendKeys("randompwd12");
    loginPage.signInBtn.click();

  //  WebElement errorMsg = driver.findElement(By.className("alert alert_danger")); //not needed
    Assert.assertTrue(loginPage.errorMsg.isDisplayed());

}
  @Test
    public void positiveLoginTest(){
    driver.get(ConfigurationReader.getProperty("library.url"));
      LibraryLoginPage loginPage = new LibraryLoginPage();
    //  loginPage.email.sendKeys("student3366@library");
    //  loginPage.password.sendKeys("MU0rEdlK");
    //  loginPage.signInBtn.click();

      loginPage.email.sendKeys(ConfigurationReader.getProperty("library3.student.email"));
      loginPage.password.sendKeys(ConfigurationReader.getProperty("library3.student.password"));
      loginPage.signInBtn.click();


    BookManagementPage bookManagementPage= new BookManagementPage();
    assertTrue(bookManagementPage.bookMangtHeader.isDisplayed());
    bookManagementPage.isCurrentPage();
      



    
  }

}
