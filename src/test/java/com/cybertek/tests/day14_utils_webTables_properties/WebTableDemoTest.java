package com.cybertek.tests.day14_utils_webTables_properties;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import  static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableDemoTest {

    WebDriver driver;
    String url ="http://practice.cybertekschool.com/tables";

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);


    }

    @AfterMethod
    public  void  tearDown(){
         driver.quit();
    }

    @Test
    public  void  readFromTableTest(){
        //Print table data as a single String, not so common, but useful sometimes
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("Table 1 text = " + table1.getText());
        //verify this email is any where on the table

       assertTrue(table1.getText().contains("tconway@earthlink.net"));

       //print all column names
        WebElement allColumnNames = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("All colum names: "+ allColumnNames.getText());

       // each column names in separate lines using loop and find
       // //table[@id='table1']/thead/tr/th will match 6 column name cells individually, we can use this xpath to findElements method and store all 6 cells in the list
         List<WebElement> columnNamesList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        System.out.println("List of columns count: "+ columnNamesList.size());

        for(WebElement columnNames: columnNamesList){
            System.out.println("Column name get text: "+columnNames.getText());
        }
        //print first col + first cell data
       String xpathString = "//table[@id='table1']/tbody/tr[1]/td[1]";
        WebElement firstRowCell = driver.findElement(By.xpath(xpathString)) ;
        System.out.println("firstRowCell.getText  = " + firstRowCell.getText());
        System.out.println("col 1 ,row 4 "+ getCellData(1,4));
        System.out.println("col 3, row 3 "+ getCellData(3,3));
        



         
    }

    @Test
    public void getAllColumns(){
      // print all names
      //print all emails
   List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
   List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
        System.out.println("---ALL FIRST NAMES--- ");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(i+1 + " -  "+names.get(i).getText());

        }
        System.out.println("---ALL EMAILS---");
        for (WebElement e : emails) {
            System.out.println(e.getText());

        }




    }

    @Test
    public void printAllTableDataTest() {
        //get rows count and assign to rowsCount variable and print it
        int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        System.out.println("rowsCount = " + rowsCount);

        for (int r = 1; r <= rowsCount; r++) {
            for(int c = 1; c <= 6; c++) {
             //   String value = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+r+"]/td["+c+"]")).getText();
                String value = getCellData(r,c);

                System.out.println("value = " + value);
            }

        }

    }
    @Test
    public  void  readNeighbourCell(){
     WebElement johnEmail = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/following-sibling::td[1]"));
        System.out.println("John email: "+ johnEmail.getText());

     WebElement johnLastName= driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/preceding-sibling::td[1]"));
        System.out.println("John last name: "+ johnLastName.getText());


    }


    public  String getCellData(int row, int col){
        String xpathStr= "//table[@id='table1']/tbody/tr["+row+"]/td["+col+"]";
        return driver.findElement(By.xpath(xpathStr)).getText();

    }


}
