package com.cybertek.tests.day16_download_uploaded_is_executer;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
 import org.openqa.selenium.WebElement;

import java.io.File;

public class FileDownloadTest extends TestBase {

    @Test
    public  void fileDownloadTest(){
      //same as below
   //  driver.get(ConfigurationReader.getProperty("download.url"));

        Driver.getDriver ().get ( ConfigurationReader.getProperty ( "download.url" ) );
        WebElement someFileDownload = driver.findElement(By.linkText("some-file.txt"));
              someFileDownload.click();
        BrowserUtils.sleep(2);
              String filePath =  System.getProperty("user.home")+"/Downloads/some-file.txt";
              //verify if it is downloaded , go download folder and check it is downloaded
                                                //User/cybertek24/     Download/some-file.txt
        System.out.println("File path= "+filePath);
        File file = new File(filePath);
        System.out.println("file exists= "+ file.exists());

        while(!file.exists()) {
            BrowserUtils.sleep(1);
        }

       Assert.assertTrue(file.exists(),"file download failed");
        
        file.delete();


    }




    
}
