package com.cybertek.tests.week_05_smartbbbear;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import com.cybertek.utils.LibraryUtils;
import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LibraryVerification  extends TestBase {


    @Test
    public  void printLinks() {
      //  Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));


        LibraryUtils.loginLibrary(driver);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("count links: "+links.size());
        for(WebElement each: links) {

            System.out.println("links: " + each.getAttribute("href"));
        }

    }










}
 /*
  Task #1: Library software link verification
1. Open browser
2. Go to website: http://library2.cybertekschool.com/login.html
3. Enter username: “”
4. Enter password: “”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page

 Task #2:
• Create a method called loginToLibrary in the same java class with the @Test
• This method simply logs in to Library app when you call it.


Task #3:
• Create a new class under ‘utilities’ package named “LibraryUtilities”
• Move loginToLibrary method from the same java class to “LibraryUtilities”
• Overcome the challenge so it works when you call from the other class.




  */