package com.cybertek.tests.group_project1;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VytractTests {

    String url = "https://qa2.vytrack.com/user/login";
    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.name("_username")).sendKeys("User7");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.name("_submit")).click();

        Tyler();


    }

    public void Tyler() {
        WebElement noClickFleetButton = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(noClickFleetButton).perform();

        WebElement vehicleBtn = driver.findElement(By.xpath("//span[@class='title title-level-2']"));
        vehicleBtn.click();
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void getCoordinates() {


    }


    @Test
    public void VyTrackValidateUILayout() {

        WebElement exportGridBtn = driver.findElement(By.xpath("//div[@class='pull-left grid-toolbar-mass-actions']"));
        exportGridBtn.click();

        WebElement exportGridOption1 = driver.findElement(By.xpath("//a[@title='CSV']"));
        WebElement exportGridOption2 = driver.findElement(By.xpath("//a[@title='XLSX']"));
        Assert.assertTrue(exportGridOption1.isDisplayed() && exportGridOption2.isDisplayed(), "Fail, options Not displayed");


        int winHeight = driver.manage().window().getSize().getHeight();
        int winWidth = driver.manage().window().getSize().getWidth();

        WebElement exportGridElement = driver.findElement(By.xpath("//div[@class='pull-left grid-toolbar-mass-actions']"));
        int xPosition = exportGridElement.getLocation().getX();
        int yPosition = exportGridElement.getLocation().getY();
        int elementHeight = exportGridElement.getSize().getHeight();
        int elementWidth = exportGridElement.getSize().getWidth();
        System.out.println(xPosition);
        System.out.println(yPosition);

        System.out.println("Element Width = " + elementWidth);
        System.out.println("Element Height = " + elementHeight);

        System.out.println("Window Width = " + winWidth);
        System.out.println("Window Height = " + winHeight);


        WebElement locateExportGrid = driver.findElement(By.xpath("//div[@class='pull-left grid-toolbar-mass-actions']"));
        Point location = locateExportGrid.getLocation();

        int x = location.getX();
        int y = location.getY();
        System.out.println("Coordinates of Export Grid Button is : " + x + " and " + y);
        Assert.assertTrue((xPosition + elementWidth) <= winWidth / 2, "Fail: Export Grid is NOT in upper left corner");
        //   12   +      118       <=    648

        Assert.assertTrue((yPosition + elementHeight) <= winHeight / 2, "Fail: Export Grid is NOT in upper left corner");


    }

    @Test
    public void TC3() { // User should be able to click refresh button

        WebElement resetBtn = driver.findElement(By.xpath("//i[@class='fa-repeat']"));
        resetBtn.click();

    }

    @Test
    public void TC4() throws InterruptedException { //User should be able to click reset button


        WebElement arrowBtn = driver.findElement(By.xpath("//i[@class='fa-chevron-right hide-text']"));
        arrowBtn.click();
        Thread.sleep(2000);

        WebElement pageNum = driver.findElement(By.xpath("//input[@type='number']"));

        String p2 = pageNum.getAttribute("value");   //2

        WebElement resetBtn = driver.findElement(By.xpath("//a[@title='Reset']"));
        resetBtn.click();
        Thread.sleep(2000);

        pageNum = driver.findElement(By.xpath("//input[@type='number']"));
        String p1 = pageNum.getAttribute("value"); //1

        Assert.assertTrue(!p1.equals(p2), "Fail: Reset Button Not Working as Expected");
        // Assert.assertFalse(p1.equals(p2));


    }

    @Test
    public void TC5() { // User should be able to click Grid Settings button
        WebElement gridSettingBtn = driver.findElement(By.xpath("//a[@title='Grid Settings']"));
        gridSettingBtn.click();

        WebElement gridSettingsWindow = driver.findElement(By.xpath("//div[@class='dropdown-menu']")) ;
        Assert.assertTrue(gridSettingsWindow.isDisplayed(), "Fail: Grid Setting Not Displayed - Button Not Clickable" );

    }

    @Test
    public void TC6() throws InterruptedException {


        WebElement toolBar = driver.findElement(By.xpath("//div[@class='actions-panel pull-right form-horizontal']"));


        List<WebElement> toolBarElements = toolBar.findElements(By.tagName("a"));


        for (int i = 0; i < toolBarElements.size(); i++) {
            toolBarElements.get(i).click();
            Thread.sleep(2000);

        }
        int t1 = toolBarElements.get(0).getLocation().getX();
        int t2 = toolBarElements.get(1).getLocation().getX();
        int t3 = toolBarElements.get(2).getLocation().getX();
        int t4 = toolBarElements.get(3).getLocation().getX();

        Assert.assertTrue(t2 < t3);
        Assert.assertTrue(t2 > t1);


    }
    @Test
    public void  T7() throws InterruptedException {

        WebElement toolBar = driver.findElement(By.xpath("//div[@class='actions-panel pull-right form-horizontal']"));


        List<WebElement> toolBarElements = toolBar.findElements(By.tagName("a"));


        for (int i = 0; i < toolBarElements.size(); i++) {
            toolBarElements.get(i).click();
            Thread.sleep(2000);

        }
        int t1 = toolBarElements.get(0).getLocation().getX();
        int t2 = toolBarElements.get(1).getLocation().getX();
        int t3 = toolBarElements.get(2).getLocation().getX();
        int t4 = toolBarElements.get(3).getLocation().getX();

        Assert.assertTrue(t4 > t3,"Fail: Grid Settings button is not on the right side of Reset Button");

    }
    @Test
    public void TC8() {
        WebElement exportGridBtn = driver.findElement(By.xpath("//div[@class='pull-left grid-toolbar-mass-actions']"));
        exportGridBtn.click();

        WebElement exportGridOption1 = driver.findElement(By.xpath("//a[@title='CSV']"));
        WebElement exportGridOption2 = driver.findElement(By.xpath("//a[@title='XLSX']"));
        Assert.assertTrue(exportGridOption1.isDisplayed() && exportGridOption2.isDisplayed(), "Fail, options Not displayed");


        int winHeight = driver.manage().window().getSize().getHeight();
        int winWidth = driver.manage().window().getSize().getWidth();

        WebElement gridSettingsBtn = driver.findElement(By.xpath("//a[@title='Grid Settings']"));
        int xPosition = gridSettingsBtn.getLocation().getX();
        int yPosition = gridSettingsBtn.getLocation().getY();
        int elementHeight = gridSettingsBtn.getSize().getHeight();
        int elementWidth = gridSettingsBtn.getSize().getWidth();
        System.out.println(xPosition);
        System.out.println(yPosition);

        System.out.println("Element Width = " + elementWidth);
        System.out.println("Element Height = " + elementHeight);

        System.out.println("Window Width = " + winWidth);
        System.out.println("Window Height = " + winHeight);


        WebElement locateGridSettingBtn = driver.findElement(By.xpath("//a[@title='Grid Settings']"));
        Point location = locateGridSettingBtn.getLocation();

        int x = location.getX();
        int y = location.getY();
        System.out.println("Coordinates of Export Grid Button is : " + x + " and " + y);
        Assert.assertTrue((xPosition + elementWidth) >= winWidth / 2, "Fail: Export Grid Settings Button is not on right side of Page");

        //   12   +      118       <=    648
    }




}
