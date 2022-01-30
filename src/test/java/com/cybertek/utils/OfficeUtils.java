package com.cybertek.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OfficeUtils {

    static Alert alert;//declared static alert object

    public static WebElement getLink(String str){

        return Driver.getDriver().findElement(By.partialLinkText(str));
    }

    //add Product(String category, String product), return an int value which is product price
    //also add the product to my cart

    public static int addProduct(String category, String product){

        getLink(category).click();
        getLink(product).click();

        WebElement priceContainer = Driver.getDriver().findElement(By.xpath("//h3"));

        int productsPrice = Integer.parseInt(priceContainer.getText().substring(1, 4));

        //click on Add to cart
        getLink("Add to cart").click();

        BrowserUtils.sleep(2);

        alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        getLink("Home").click();
        return productsPrice;
    }



    }




