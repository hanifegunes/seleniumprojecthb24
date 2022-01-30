package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.cybertek.utils.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationFormTest extends RegistrationFormTestBase{
      Faker faker = new Faker();
          @Test
    public  void  formTest() throws InterruptedException {
     WebElement firstname = driver.findElement(By.name("firstname"));
     firstname.sendKeys("Nadir");
     firstname.sendKeys(faker.name().firstName());

     WebElement lastname = driver.findElement(By.name("lastname"));
     lastname.sendKeys(faker.name().lastName());
        enterUserName(faker.name().username().replace(".",""));

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(faker.internet().password());

        WebElement mobile = driver.findElement(By.name("phone"));
        mobile.sendKeys(faker.phoneNumber().cellPhone());

        WebElement maleRadio = driver.findElement(By.xpath("//*[@value='male']"));
           maleRadio.click();

        WebElement birthday = driver.findElement(By.name("birthday"));
        birthday.sendKeys("01/01/1990");

        Select department  = new Select(driver.findElement(By.name("department")));
        department.selectByIndex(faker.number().numberBetween(1,9));

        Select jobTitle = new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByIndex(faker.number().numberBetween(1,8));

         List<WebElement> languages = driver.findElements(By.xpath("//input[@type='checkbox']")) ;
           for(WebElement eachLang: languages){
               eachLang.click();
           }


           WebElement signUp = driver.findElement(By.id("wooden_spoon"));
           signUp.click();

             Thread.sleep(2000);

           //verify "Well done!"message displayed
           WebElement heading = driver.findElement(By.className("alert-heading"));
              Assert.assertTrue(heading.isDisplayed());
           Assert.assertEquals(heading.getText(),"Well done!");

          }

     public  void enterUserName (String username ){

              WebElement usernameField = driver.findElement(By.name("username"));
              usernameField.sendKeys(username);
     }




    /*

   TC#6: Cybertek registration form confirmation
Note: Use JavaFaker when possible.
1. Open browser
2. Go to website: http://practice.cybertekschool.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10.Enter date of birth
11.Select Department/Office
12.Select Job Title
13.Select programming language from checkboxes
14.Click to sign up button
15.Verify success message “You’ve successfully completed registration.” is
displayed.




     */







    }
