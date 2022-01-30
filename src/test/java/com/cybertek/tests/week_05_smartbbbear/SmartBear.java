package com.cybertek.tests.week_05_smartbbbear;

import com.cybertek.utils.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBear {

    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);


    }

   // @AfterMethod
    //   public  void  tearDown(){
    //    driver.quit();
   // }

     @Test
    public  void  test1(){
         WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
         username.sendKeys("Tester");
          WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
            password.sendKeys("test");
          WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button")) ;
             loginButton.click();


       

         List<WebElement> allLinks = driver.findElements(By.tagName("a"));

       for(WebElement  links :allLinks ) {
           System.out.println("All links texts: " +links.getText());

       }

        int count = allLinks.size();
         System.out.println( "all links size"+count);

    }

     @Test
    public  void test2() throws Exception {
        //  Click on Order
         WebElement order = driver.findElement(By.linkText("Order"));
         order.click();

         //  Select familyAlbum from product, set quantity to 2
         // Click to “Calculate” button

       Select familyAlbum = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        familyAlbum.selectByValue("FamilyAlbum");

     //  Select quantity = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")));
         WebElement quantity1 = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
         quantity1.clear();
         Thread.sleep(2000);
            quantity1.sendKeys("2");


        // Click to “Calculate” button
         WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
        // Thread.sleep(1000);
         calculate.sendKeys(Keys.ENTER);


        // Fill address Info with JavaFaker
         //• Generate: name, street, city, state, zip code
         // Click on “visa” radio button
         //. Generate card number using JavaFaker

         //. Verify success message “New order has been successfully added.”

         Faker faker = new Faker();
         WebElement name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
         name.sendKeys(faker.name().fullName());
        WebElement street = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys(faker.address().streetAddress());
        WebElement city = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys(faker.address().city());
         WebElement state = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));

         
        state.sendKeys(faker.address().state());
         Thread.sleep(2000);


        WebElement zip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys(faker.address().zipCode().replace("-",""));


        // Click on “visa” radio button
      //   11. Generate card number using JavaFaker

        WebElement visa = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visa.click();
        WebElement cardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys(faker.finance().creditCard().replace("-",""));
         WebElement date = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
         date.sendKeys("01/23");



         //. Click on “Process”

        WebElement process = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        process.sendKeys(Keys.ENTER);

        WebElement insert=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        insert.click();

        String actual ="New order has been successfully added.";
       Assert.assertEquals(actual,driver.findElement(By.tagName("strong")).getText());

     }



}
      /*

TC #1: Smartbear software link verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page

 Mini-Task: CREATE A CLASS à SmartBearUtils
• Create a method called loginToSmartBear
• This method simply logs in to SmartBear when you call it.
• Accepts WebDriver type as parameter

TC#2: Smartbear software order placing
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on “visa” radio button
11. Generate card number using JavaFaker
12. Click on “Process”
13. Verify success message “New order has been successfully added.”






       */