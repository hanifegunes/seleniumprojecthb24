package com.cybertek.tests.oH04;

import com.cybertek.pages.PlaceOrderPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cybertek.utils_office.OfficeUtils1;

import java.util.HashMap;
import java.util.Map;

public class PlaceOrderTest2 extends TestBase {

    int expectedPrice = 0;
    @Test
    public void placeOrder() {
        // gets me URL of the page
        driver.get(ConfigurationReader.getProperty("demoblazeUrl"));
        // adding Laptops Sony vaio i7
        expectedPrice += OfficeUtils1.addProduct("Laptops", "Sony vaio i7");
        // adding Iphone
        expectedPrice += OfficeUtils1.addProduct("Phones", "Iphone 6 32gb");
        // adding Monitor
        expectedPrice += OfficeUtils1.addProduct("Monitors", "Apple monitor 24");

        System.out.println(expectedPrice);

        OfficeUtils1.getLink("Cart").click();

        expectedPrice -= OfficeUtils1.removeProduct("Iphone 6 32gb");


        BrowserUtils.sleep(1);

        System.out.println("expectedPrice = " + expectedPrice);

        // we are calling our form filling method
        PlaceOrderPage placeOrderPage = new PlaceOrderPage();
        placeOrderPage.placeOrderButton.click();
        placeOrderPage.fillForm(faker);
        placeOrderPage.purchaseButton.click();

        System.out.println("placeOrderPage.confirmationText.getText() = " + placeOrderPage.confirmationText.getText());

        //     split method with regex "\n"  you need two splits

        String [] arr = placeOrderPage.confirmationText.getText().split("\n");

        // Click OK button after we get the text
        BrowserUtils.sleep(2);
        placeOrderPage.OK.click();

        Map<String,Object> dataMap = new HashMap<>(); // if the order of the keys not important for me
        // arr[0].split(":")[0] = Id ---> Key for my Map  arr[0].split(":")[1]=1575159 ----> Value for my map
        // arr[0] : String value  Object can hold any data 

        for (String s : arr) {
            dataMap.put(s.split(":")[0].trim(),s.split(":")[1].trim());
        }

        System.out.println("dataMap = " + dataMap); // dataMap = {Id=5551210}
         //Object: Everything can be Object (String primitives, objects created from class,
        //List<String>, Arrays,ArrayList

           int actualPrice= Integer.parseInt(((String)dataMap.get("Amount")).split(" ")[0]);

        System.out.println("data map = "+ dataMap);

        Assert.assertEquals(actualPrice,expectedPrice,"The price is NOT as expected ");


        
    }
    }
