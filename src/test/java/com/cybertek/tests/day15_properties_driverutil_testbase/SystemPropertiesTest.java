package com.cybertek.tests.day15_properties_driverutil_testbase;

import com.cybertek.utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SystemPropertiesTest {


   @Test
   public  void readingSystemProperties(){

       System.out.println("OS name= "+System.getProperty("os.name"));
       System.out.println("User name= "+ System.getProperty("user.name"));
       System.out.println("User dir= "+ System.getProperty("user.dir"));

       System.out.println("Pom.xml path="+System.getProperty("user.dir")+"/pom.xml");
       System.out.println("java version= "+ System.getProperty("java.version"));

   }
     @Test
    public  void  configurationReaderUnitTest(){
         System.out.println(ConfigurationReader.getProperty("browser"));
         String url = ConfigurationReader.getProperty("webtableUrl");
         System.out.println("url= "+ url);
         Assert.assertEquals(ConfigurationReader.getProperty("browser"),"chrome");
         Assert.assertEquals(ConfigurationReader.getProperty("env"),"qa");

         Assert.assertEquals(ConfigurationReader.getProperty("hello"),null);

     }



}
