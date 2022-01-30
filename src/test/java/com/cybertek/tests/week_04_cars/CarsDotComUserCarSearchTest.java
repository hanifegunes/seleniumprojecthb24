package com.cybertek.tests.week_04_cars;

import com.cybertek.utils.WebDriverFactory;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class CarsDotComUserCarSearchTest {

     String url = "https://www.cars.com" ;
     WebDriver driver;


     Select make;
    Select model;
    Select newUsedCars;
    Select price;
    Select distance;
    WebElement zipCode;

     

        @BeforeMethod
     public  void  setUp(){
             driver= WebDriverFactory.getDriver("chrome");
             driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
             driver.get(url);

        }


        @AfterMethod
     public void  tearDown(){
             driver.quit();
        }

        @Test (priority = 1)
     public  void  defaultValuesTest(){
             String expectedTittle="New Cars, Used Cars, Car Dealers, Prices & Reviews | Cars.com";
             String actualTittle = driver.getTitle();
        assertEquals(actualTittle,expectedTittle);

           // driver.findElement(By.id("make-model-search-stocktype"));
          //  driver.findElement(By.id("makes"));
          //  driver.findElement(By.id("make-model-max-price"));
           // driver.findElement(By.id("make-model-maximum-distance"));
           // driver.findElement(By.id("make-model-zip"));

              newUsedCars = new Select(driver.findElement(By.id("make-model-search-stocktype")));
            System.out.println("Selected used cars: "+ newUsedCars.getFirstSelectedOption().getText());
              assertTrue(newUsedCars.getFirstSelectedOption().isSelected());

              make = new Select(driver.findElement(By.id("makes")));
             assertTrue(make.getFirstSelectedOption().isSelected());
            System.out.println("selected mitsubishi "+ make.getFirstSelectedOption().getText());

               model = new Select(driver.findElement(By.id("models")));
              assertTrue(model.getFirstSelectedOption().isSelected());
            System.out.println("selected model "+ model.getFirstSelectedOption().getText());

               price = new Select( driver.findElement(By.id("make-model-maximum-distance")));
              assertTrue(price.getFirstSelectedOption().isSelected());
            System.out.println("Selected price "+ price.getFirstSelectedOption().getText());

               distance = new Select(driver.findElement(By.id("make-model-maximum-distance")));
              assertTrue(distance.getFirstSelectedOption().isSelected());
            System.out.println("Selected distance "+ distance.getFirstSelectedOption().getText());


               zipCode = driver.findElement(By.id("make-model-zip"));
              String expZipCode = "79832";
              assertEquals(zipCode.getAttribute("value"),expZipCode);

            driver.findElement(By.xpath("//button[@data-linkname='search-all-make']")).click();




        }
       /*
        - assert title equals “New Cars, Used Cars, Car Dealers, Prices & Reviews | cars.com"
- assert cars.com icon is displayed
- locate and assert selected values of all 5 drop downs (can use
getFirstSelectedOption().getText()):
	 	 -> New & used cars
	 	 -> Mitsubishi
	 	 -> Outlander
	 	 -> No max price
	 	 -> 20 miles
- assert value in zip code field equals 22039 (please change zip code according to what
shows up for you)


        */

     @Test(priority = 2)
    public void  usedTeslaSearchTest(){
      driver.findElement(By.id("make-model-search-stocktype")).click();
      driver.findElement(By.xpath("//option[@value='used']")).click();

         driver.findElement(By.id("makes")).click();
           driver.findElement(By.xpath("//option[@value='tesla']")).click();

         driver.findElement(By.id("make-model-max-price")).click();
         driver.findElement(By.xpath("//option[@value='tesla-model_3']")).click();

         driver.findElement(By.id("make-model-max-price")).click();
         driver.findElement(By.xpath("//option[@value='50000']")).click();

        // driver.findElement(By.xpath("//button[@data-linkname='search-all-make']")).click();
         driver.findElement(By.id("make-model-maximum-distance")).click();

           driver.findElement(By.xpath("//option[@value='200']")).click();
           driver.findElement(By.id("make-model-zip")).clear();
           driver.findElement(By.id("make-model-zip")).sendKeys("22102");

         driver.findElement(By.xpath("//button[@data-linkname='search-used-make']")).click();

         WebElement actualHeader =    driver.findElement(By.xpath("//h1[.='Used Tesla Model 3 for sale']"));
           assertTrue(actualHeader.getText().contains("Tesla Model 3"));

           WebElement count= driver.findElement(By.xpath("(//span[@class='total-filter-count'])[2]"));
           String result = count.getText();
           result = result.substring(0,result.length()-8);
           assertTrue(Integer.parseInt(result)>200 && Integer.parseInt(result)< 500);

          assertTrue(driver.findElement(By.id("model_tesla-model_3")).isSelected());


          assertFalse(driver.findElement(By.cssSelector("label[for='model_tesla-model_s']")).isSelected());
           driver.navigate().back();
       





     }
    /*
    Set values of drop down lists and zip code according to image below and click search:
     Assertions:
- assert the main page header contains “Tesla Model 3”
- assert results count is more than 200 and less than 500 matches
- assert that Model 3 checkbox is checked (isSelected() )
- assert that Model S checkbox is available and Not checked
     */

       @Test(priority = 3)
        public  void usedTeslaAdvancedSearchTest(){


           
       }
      /*

     - click on Advanced search link in the middle of the page
- assert that Advanced search header is displayed
- Enter values according to the image below.
- Select all available Tesla Models one by one
- Click on Show matches button

     - assert that current Url contains “zip=22102”
- assert that default selected Sort by value is “Best match”
- Select “Lowest price” option
- Print the car title, mileage and price of the lowest resul


       */



}
