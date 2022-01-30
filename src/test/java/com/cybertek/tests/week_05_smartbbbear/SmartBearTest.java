package com.cybertek.tests.week_05_smartbbbear;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.SmartBearUtils;
import org.testng.annotations.Test;

public class SmartBearTest extends TestBase {
    @Test
    public void printNames(){
        driver.get(ConfigurationReader.getProperty("smart.url"));
        SmartBearUtils.loginToSmartBear(driver);
       SmartBearUtils.verifyOrder(driver,"Mark Smith");
         SmartBearUtils.printNameAndCities(driver);
         SmartBearUtils.viewAllOrders(driver);
          driver.quit();
    }




}
