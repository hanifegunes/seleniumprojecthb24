package com.cybertek.tests.week_05_smartbbbear;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCJavaFakerTest extends TestBase {

   @Test
   public  void  registrationForm(){
      driver.get(ConfigurationReader.getProperty("java.faker"));
       Faker faker = new Faker();

      WebElement firstName = driver.findElement(By.name("firstname")) ;
       firstName.sendKeys(faker.name().firstName());

      WebElement lastName = driver.findElement(By.name("lastname"));
      lastName.sendKeys(faker.name().lastName());

       WebElement userName = driver.findElement(By.name("username"));
       userName.sendKeys(faker.name().username().replace(".",""));

       WebElement emailAddress= driver.findElement(By.name("email"));
       emailAddress.sendKeys(faker.internet().emailAddress());

       WebElement   passWord = driver.findElement(By.name("password")) ;
      passWord.sendKeys(faker.internet().password());

       WebElement    tellNumber = driver.findElement(By.name("phone"));
       tellNumber.sendKeys(faker.phoneNumber().phoneNumber());

       WebElement gender = driver.findElement(By.xpath("//*[@value='female']"));
       gender.click();

       WebElement    date = driver.findElement(By.name("birthday"));
       date.sendKeys("11/10/2021");


       Select department = new Select(driver.findElement(By.xpath("//*[@name='department']")));
      department.selectByValue("DE");

      Select jobTitle = new Select(driver.findElement(By.xpath("//*[@name='job_title']")));
       jobTitle.selectByIndex(faker.number().numberBetween(1,8));

       WebElement language= driver.findElement(By.id("inlineCheckbox2"));
         language.click();
       WebElement signUp = driver.findElement(By.id("wooden_spoon"));
         signUp.click();
      // WebElement heading = driver.findElement(By.xpath("//*[@class='alert-heading']//*[.='You've successfully completed registration!']"));
      // Assert.assertEquals(heading.getText(),"You've successfully completed registration!");
          driver.quit();
      // WebElement actMsg = driver.findElement(By.xpath("//*[contains(text(),'completed')]"));

       String expMsg = "You've successfully completed registration!";
       WebElement actMsg = driver.findElement(By.xpath("//*[contains(text(),'completed')]"));
       System.out.println("actMsg = " + actMsg.getText());
       Assert.assertEquals(expMsg,actMsg.getText());




   }


    
}
