package com.cybertek.tests.week_02_practice02;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPeople {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://login2.nextbasecrm.com/";
        driver.get(url);
       driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys("helpdesk11@cybertekschool.com");
       driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("UserUser");
       driver.findElement(By.xpath("//input[@id='USER_REMEMBER']")).click();

        driver.findElement(By.xpath("//input[@value='Log In']")).sendKeys(Keys.ENTER);
       // driver.findElement(By.xpath("//input[@placeholder='find people, documents, and more']")).sendKeys("employee");
      //  driver.findElement(By.xpath("//span[@class='header-search-icon header-search-icon-title']")).click();
      //  driver.findElement(By.cssSelector("span[class='search-title-top-delete']")).sendKeys(Keys.ENTER);
        WebElement searchField = driver.findElement(By.cssSelector("input[placeholder='find people, documents, and more']"));
       // users  (hr, marketing and helpdesk) search a valid info : employee, doc, post, task

        searchField.sendKeys("employee");
        Thread.sleep(2000);
        searchField.clear();

        searchField.sendKeys("doc");
        Thread.sleep(2000);
        searchField.clear();

        searchField.sendKeys("post");
        Thread.sleep(2000);
        searchField.clear() ;

        searchField.sendKeys("task");
        Thread.sleep(2000);
        searchField.clear();

        //users get ""Employees"", ""Groups"", ""Menu items"", and ""search"" once typing at least a letter
        searchField.sendKeys("g");
        Thread.sleep(2000);
        searchField.clear();

        searchField.sendKeys("m");
        Thread.sleep(2000);
        searchField.clear();


        searchField.sendKeys("e");
        Thread.sleep(2000);
        searchField.clear();

        int countEmpty = 0;
        int countLinkText = 0;
        int countEmpthyText = 0;
        

        List<WebElement> allList = driver.findElements(By.tagName("e"));
        for (WebElement webElement : allList) {
            if(webElement.getText().isEmpty()){
                countEmpthyText++;
            }else{
                countLinkText++;
            }
        }

        System.out.println(countEmpthyText + " empty text of links");
        System.out.println(countLinkText + " text links");
        System.out.println(countEmpthyText + countLinkText + " total of links");



         //  users cannot find an invalid info, the page should show "" Nothing Found"" (negative)

        searchField.sendKeys("iphone wooden case");
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(200);

       // driver.navigate().refresh();
       // driver.navigate().back();
           driver.quit();

       





    }
}
  /*
    "3. As a user, I should be able to search people,
document and more from search box"
     "1. Verify users can search a valid info from search box.
(employee, doc, post, etc)
2. Verify users get menu item and
     suggested modules when they type in the box.
"
   "1. users  (hr, marketing and helpdesk) search a valid info : employee, doc, post, task ..
2. users cannot find an invalid info, the page should show "" Nothing Found"" (negative)
3. users get ""Employees"", ""Groups"", ""Menu items"", and ""search"" once typing at least a letter
"

  
   */