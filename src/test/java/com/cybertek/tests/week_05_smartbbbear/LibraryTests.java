package com.cybertek.tests.week_05_smartbbbear;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LibraryTests extends TestBase {
   @Test
   public  void  test1(){

      driver.get(ConfigurationReader.getProperty("library.url"));

    //  WebElement email


    //  List<WebElement> emails= driver.findElements(By.xpath("//")) ;



   }



    
}
 /*

   public class LibraryUtil {
    public static void loginToLibrary(WebDriver driver){
        String url = "https://library3.cybertekschool.com/login.html";

        LinkedHashMap<String ,String> credentials = new LinkedHashMap<>();
        credentials.put("student3366@library",  "MU0rEdlK");
        credentials.put("student3367@library", "GbZeYc7z");

        /*
         * Get all keys from the LinkedHashMap
         * using the keySet method

 Set<String> emailsAndPasswords= credentials.keySet();

    /*
     * Convert it to an ArrayList
     */
  //  List<String> keysValueOfCredentials = new ArrayList<String>( emailsAndPasswords );
    /*
     * Find index using indexOf method.
     * It returns -1 if key is not found
     */


   // WebElement username = driver.findElement(By.id("inputEmail"));
    //        username.sendKeys(keysValueOfCredentials.get(1));

      //              String emails = keysValueOfCredentials.get(1);

       //             WebElement password = driver.findElement(By.id("inputPassword"));
         //           password.sendKeys(credentials.get(emails) + Keys.ENTER);
          //




  /*

                    or the Library task, please use below credentials and qa3 environment. You can store them in properties file as Key=value and work on the task, thank you


Name         Email                 Password Type
Test Student 3366 student3366@library MU0rEdlK Student
Test Student 3367 student3367@library GbZeYc7z Student
Test Student 3368 student3368@library NOgZ81BnStudent
Test Student 3369 student3369@library ANPknP6QStudent
Test Student 3370 student3370@library bC29FL6D Student
Test Student 3371 student3371@library Aki5ctyu Student
Test Student 3372 student3372@library C7keoiHu Student
Test Student 3373 student3373@library W06NfNjz Student
Test Student 3374 student3374@library aWqc2Hxv Student
Test Student 3375 student3375@library 1Q7dh20f Student
Test Student 3376 student3376@library i7thkDTY Student
Test Student 3377 student3377@library 7ntM5Zzx Student
Test Student 3378 student3378@library 7hOvELav Student
Test Student 3379 student3379@library BNvMT3qY Student
Test Student 3380 student3380@library Mm4RFh95 Student
Test Student 3381 student3381@library CtuCIbwS Student
Test Student 3382 student3382@library 05rxFBkM Student
Test Student 3383 student3383@library wB3poJC8 Student
Test Student 3384 student3384@library ikUtbcVR Student
Test Student 3385 student3385@library AMvmR0zEStudent
Test Librarian 1255 librarian1255@library sItD7lWB Librarian
Test Librarian 1256 librarian1256@library EgEUDEq6 Librarian
Test Librarian 1257 librarian1257@library awLnDEJA Librarian
Test Librarian 1258 librarian1258@library H0SRmvcn Librarian
Test Librarian 1259 librarian1259@library q6OOPRlm Librarian
Test Librarian 1260 librarian1260@library SmQChoT7 Librarian
Test Librarian 1261 librarian1261@library ICf9pm9S Librarian
Test Librarian 1262 librarian1262@library NLhOB6EE Librarian
Test Librarian 1263 librarian1263@library 6Zyvp0zv Librarian
Test Librarian 1264 librarian1264@library xKYxVcB Librarian
https://library3.cybertekschool.com/login.html





  */