package com.cybertek.tests.day22_explicitwait_review;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CherCherWaitPracticeTest extends TestBase {

    @BeforeMethod
    public void gotoHomePage() {
        driver.get(ConfigurationReader.getProperty("chercher.url"));
    }

    @Test
    public void waitForAlertTest() {
        WebElement openAlertBtn = driver.findElement(By.id("alert"));
        openAlertBtn.click();
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
         alert.accept();
        // driver.switchTo().alert().accept();
    }

    @Test
    public void waitForButtonEnabledTest() {
     WebElement button = driver.findElement(By.id("disable"));
        System.out.println("cher cher button is enable= "+ button.isEnabled());
        button.click();
        //click on Enable button
       WebElement enableBtn= driver.findElement(By.id("enable-button"));
       enableBtn.click();
        //wait until the button is enabled
       WebDriverWait wait = new WebDriverWait(driver,15);
       wait.until(ExpectedConditions.elementToBeClickable(button));

    }
    @Test
    public void waitForCheckBoxIsCheckedTest() {
        WebElement checkBox= driver.findElement(By.id("ch"));
        System.out.println("cher cher button is enable= "+ checkBox.isSelected());

        WebElement enableCheckBox = driver.findElement(By.id("checkbox"));
        enableCheckBox.click();
        //wait until checkbox is selected
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeSelected(checkBox));
        System.out.println("checkbox is checked = " + checkBox.isSelected());

    }

}
