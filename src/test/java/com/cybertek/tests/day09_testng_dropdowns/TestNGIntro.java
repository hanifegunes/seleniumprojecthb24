package com.cybertek.tests.day09_testng_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGIntro {
   //can be used by each test
 String url = "https://www.etsy.com";
 @BeforeClass        // 1 runs
     public  void  setUp(){
         System.out.println("@BeforeClass setUp method...");
         System.out.println("Opened browser and navigating to: "+ url);
         System.out.println("=================");
     }
     @BeforeMethod    // 2. runs   --->4. runs before 2. method
     public  void  setUpApp(){
         System.out.println("@BeforeMethod setUpApp method is running ...");
         System.out.println("Navigating back  to "+ url);
         System.out.println("=================");
     }



 @Test(priority = 1)   // giving priority so it will run 1.
    public void test1(){      // 5 . runs
     System.out.println("Running test1 ....");
     int num = 10;
     Assert.assertEquals(10,num);
 }
 @Test (priority =  2) // convert regular method to test method
 public  void  myTest2(){       //3. runs alfabetic
     System.out.println("Running test 2");

     String name = "Bob";
     Assert.assertTrue(name.contains("o"));



 }
 @AfterMethod
 public  void  tearDown(){      // 6. runs
     System.out.println("After method tear down is running");
     System.out.println("======================");
 }
   @AfterClass
    public  void  clearUp(){     // end of the class 7. runs
       System.out.println("Clear up after class is running ......");
       System.out.println("=====================");

   }



}
