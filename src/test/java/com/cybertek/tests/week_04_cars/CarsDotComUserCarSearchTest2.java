package com.cybertek.tests.week_04_cars;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class CarsDotComUserCarSearchTest2 {

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

    @Test(priority = 1)
    public  void  defaultValuesTest() {
        String expectedTittle = "New Cars, Used Cars, Car Dealers, Prices & Reviews | Cars.com";
        String actualTittle = driver.getTitle();
        assertEquals(actualTittle, expectedTittle);
        WebElement icon = driver.findElement(By.xpath("//a[@class='header-logo']"));
        assertTrue(icon.isDisplayed());
       newUsedCars = new Select(driver.findElement(By.id("make-model-search-stocktype")));
        assertEquals(newUsedCars.getFirstSelectedOption().getText(),"New & used cars");

        make = new Select(driver.findElement(By.id("makes")));
         assertEquals(make.getFirstSelectedOption().getText(),"Mitsubishi");

        model = new Select(driver.findElement(By.id("models")));
        assertEquals(model.getFirstSelectedOption().getText(),"Outlander");

        price = new Select( driver.findElement(By.name("list_price_max")));
        assertEquals(price.getFirstSelectedOption().getText(),"No max price");

        distance = new Select(driver.findElement(By.id("make-model-maximum-distance")));
        assertEquals(distance.getFirstSelectedOption().getText(),"20 miles");


        zipCode = driver.findElement(By.id("make-model-zip"));
        String expZipCode = "79832";
        assertEquals(zipCode.getAttribute("value"),expZipCode);

        driver.findElement(By.xpath("//button[@data-linkname='search-all-make']")).click();

    }
    @Test(priority = 2)
    public void  usedTeslaSearchTest(){

       WebElement newUsedCars = driver.findElement(By.name("stock_type"));
       Select simpleDropDown1 = new Select(newUsedCars);
       simpleDropDown1.selectByVisibleText("Used cars");


       WebElement make =  driver.findElement(By.id("makes"));
       Select  simpleDropDown2 = new Select(make);
       simpleDropDown2.selectByVisibleText("Tesla");

       WebElement  model =   driver.findElement(By.id("models"));
        Select  simpleDropDown3 = new Select(model);
        simpleDropDown3.selectByValue("tesla-model_3");


       WebElement price =  driver.findElement(By.name("list_price_max"));
       Select  simpleDropDown4 = new Select(price);
       simpleDropDown4.selectByVisibleText("$50,000");


       WebElement distance =  driver.findElement(By.name("maximum_distance"));
       Select  simpleDropDown5 = new Select(distance);
       simpleDropDown5.selectByVisibleText("200 miles");


      driver.findElement(By.id("make-model-zip")).clear();
        driver.findElement(By.id("make-model-zip")).sendKeys("22102");

       driver.findElement(By.xpath("//button[@data-linkname='search-used-make']")).click();


        WebElement actualHeader =    driver.findElement(By.xpath("//h1[.='Used Tesla Model 3 for sale']"));
        assertTrue(actualHeader.getText().contains("Tesla Model 3"));

        WebElement count= driver.findElement(By.xpath("(//span[@class='total-filter-count'])[2]"));
        String result = count.getText();
        String numOfMatches = "";
    //    result = result.substring(0,result.length()-8);

        for(int i = 0; i< result.length(); i++){

           if(Character.isDigit(result.charAt(i))){
                 numOfMatches+=result.charAt(i);
            }
        }

         int countOfMatches = Integer.parseInt(numOfMatches);
        assertTrue(countOfMatches> 200 && countOfMatches<500,"your result does not match with your criteria");

        WebElement model3Box = driver.findElement(By.xpath("//input[@id='model_tesla-model_3']"));
       assertTrue(model3Box.isSelected());

        //WebElement modelSBox = driver.findElement(By.xpath("//label[for='model_tesla-model_s']"));
       // assertTrue(modelSBox.isEnabled());
      //  assertTrue(modelSBox.isSelected());




       // assertTrue(Integer.parseInt(result)>200 && Integer.parseInt(result)< 500);

       // assertTrue(driver.findElement(By.id("model_tesla-model_3")).isSelected());


        assertFalse(driver.findElement(By.cssSelector("label[for='model_tesla-model_s']")).isSelected());
        driver.navigate().back();




    }

    @Test(priority = 3)
    public  void usedTeslaAdvancedSearchTest(){

    driver.findElement(By.linkText("Advanced search")).click();

    WebElement header = driver.findElement(By.tagName("h1"));
    // <h1 class="sds-heading--1">
        //          Advanced search
       
     assertEquals(header.getText(),"Advanced search");
     
      WebElement distance = driver.findElement(By.name("maximum_distance"));
      Select simpleDropDown1 = new Select(distance);
      simpleDropDown1.selectByVisibleText("500 miles");


        WebElement zip  = driver.findElement(By.name("zip"));
        zip.clear();
        zip.sendKeys("22102");

        WebElement newUsed = driver.findElement(By.name("stock_type"));
        Select simpleDropDown2 = new Select(newUsed);
        simpleDropDown2.selectByValue("used");


        WebElement make = driver.findElement(By.name("makes[]"));
        Select simpleDropDown3 = new Select(make);
        simpleDropDown3.selectByVisibleText("Tesla");

       

        WebElement model3 = driver.findElement(By.xpath("//label[@for='desktop_tesla-model_3']"));
        if(!model3.isSelected()){
            model3.click();
        }

        WebElement modelS = driver.findElement(By.xpath("//label[@for='desktop_tesla-model_s']"));
        if(!modelS.isSelected()){
            modelS.click();
        }
        WebElement modelX = driver.findElement(By.xpath("//label[@for='desktop_tesla-model_x']"));
        if(!modelX.isSelected()){
           modelX.click();
        }
        WebElement modely = driver.findElement(By.xpath("//label[@for='desktop_tesla-model_y']"));
        if(!modely.isSelected()){
            modely.click();
       }
           WebElement zip2 = driver.findElement(By.name("zip"));
            assertEquals(zip2.getAttribute("value"),"22102");
         WebElement lowest = driver.findElement(By.id("desktop_list_price_min_select"));
         Select simpleDropDown4 = new Select(lowest);
         simpleDropDown4.selectByValue("2000");

         String strUrl = driver.getCurrentUrl();
         assertTrue(strUrl.contains("22102"));






            WebElement sort = driver.findElement(By.id("sort-dropdown"));
            assertEquals(sort.getAttribute("value"),"best_match_desc");
           Select sortBy= new Select(driver.findElement(By.xpath("//select[@id='sort-dropdown']")));
            sortBy.selectByVisibleText("Lowest price");

        WebElement  carTitle = driver.findElement(By.xpath("(//h2[@class='title'])[1]"));
        WebElement  mileage = driver.findElement(By.xpath("(//div[@class='mileage'])[2]"));
        WebElement  price = driver.findElement(By.xpath("(//span[@class='primary-price'])[1]"));
        System.out.println("Car title: "+ carTitle.getText());
        System.out.println("Mileage: "+ mileage.getText());
        System.out.println("price: "+ price.getText());


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
- Print the car title, mileage and price of the lowest result


       */



}











