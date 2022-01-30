package com.cybertek.tests.week_03_practice03;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.ConfigurationGroupMethods;

public class DropHoverTC15 extends TestBase {
    @Test
    public void hoverTest() {
        driver.get(ConfigurationReader.getProperty("hover.url"));
        WebElement img1 = driver.findElement(By.xpath("//div[@class='figure']//img[1]"));
        actions.moveToElement(img1).perform();
        //  WebElement text = driver.findElement(By.tagName())
        Assert.assertTrue(img1.isDisplayed(), "fail");
        BrowserUtils.sleep(2);

        WebElement user1= driver.findElement(By.xpath("(//h5)[1]"));
        Assert.assertTrue(user1.isDisplayed());
        System.out.println("user1 get text: "+ user1.getText());
        //img2
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        actions.moveToElement(img2).perform();
        BrowserUtils.sleep(2);
        Assert.assertTrue(img2.isDisplayed(), "fail");
        BrowserUtils.sleep(1);
        WebElement user2= driver.findElement(By.xpath("(//h5)[2]"));
        Assert.assertTrue(user2.isDisplayed());
        System.out.println("user2 get text: "+ user2.getText());

        //img3
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
        actions.moveToElement(img3).perform();
        BrowserUtils.sleep(2);
        Assert.assertTrue(img3.isDisplayed(), "fail");
        WebElement user3= driver.findElement(By.xpath("(//h5)[3]"));
        Assert.assertTrue(user3.isDisplayed());
        System.out.println("user3 get text: "+ user3.getText());


    }

    /*
   TC #15: Hover Test
   1. Go to http://practice.cybertekschool.com/hovers
   2. Hover over to first image
   3. Assert:
   a. “name: user1” is displayed
   4. Hover over to second image
   5. Assert:
   a. “name: user2” is displayed
   6. Hover over to third image
   7. Confirm:
   a. “name: user3” is displayed
  


     */
    @Test
    public void contextclickTest() {
        driver.get(ConfigurationReader.getProperty("inthero.url") + "/context_menu");
        WebElement box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(box).perform();
        BrowserUtils.sleep(1);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }


 /*
 TC #17: Context Click – HOMEWORK
1. Go to https://the-internet.herokuapp.com/context_menu
2. Right click to the box.
3. Alert will open.
4. Accept alert
No assertion needed for this practice.

  */

 @Test
 public  void demosTelerikTest(){
     driver.get(ConfigurationReader.getProperty("demostelerik.url"));
     WebElement  bigCircle = driver.findElement(By.id("droptarget"));
     WebElement smallCircle = driver.findElement(By.id("draggable"));
     BrowserUtils.sleep(2);
     actions.dragAndDrop(smallCircle,bigCircle).perform();
     BrowserUtils.sleep(2);
     Assert.assertTrue(smallCircle.isDisplayed());
    // WebElement msg = driver.findElement(By.xpath("//div[.='You did great!']"));
    // Assert.assertTrue(msg.isDisplayed());

    

 }

}
/*
TC #16: Hover Test
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
 */