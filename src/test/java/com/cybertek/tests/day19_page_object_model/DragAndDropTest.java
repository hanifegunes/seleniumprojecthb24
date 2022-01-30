package com.cybertek.tests.day19_page_object_model;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {
     @Test
    public void guru99DragAndDropTest(){
       driver.get(ConfigurationReader.getProperty("draganddrop.url"));
         WebElement bank= driver.findElement(By.linkText("BANK"));
         WebElement accountType = driver.findElement(By.id("bank"));

         actions.dragAndDrop(bank,accountType).perform();

        WebElement fiveK = driver.findElement(By.linkText("5000"));
        WebElement  bankAmount  = driver.findElement(By.id("amt7"));

      //  actions.dragAndDrop(fiveK, 793, 826).perform();
         actions.dragAndDrop(fiveK,bankAmount).perform();

     }
     @Test
    public void cargurusPriceSliderTest(){
         driver.get(ConfigurationReader.getProperty("cargurus.url") +
                 "/Cars/inventorylisting/viewDetailsFilterViewInventoryListing.action?sourceContext=carGurusHomePageModel&entitySelectingHelper.selectedEntity=d177&zip=22102");
         WebElement priceSlider = driver.findElement(By.xpath("//button[@aria-valuemin='3000']"));
      //   int x = priceSlider.getLocation().getX();
     //    int y = priceSlider.getLocation().getY();

         actions.dragAndDropBy(priceSlider, 50, 0).perform();

        //  actions.dragAndDropBy(priceSlider, 457, 833).perform(); did not work?

       //   actions.clickAndHold(priceSlider)
        //          .sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT) === works
        //          .release().build().perform();
        //

     }





}
