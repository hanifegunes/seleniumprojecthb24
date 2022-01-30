package com.cybertek.tests.day19_page_object_model;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BookManagementPage {

  public  BookManagementPage(){

    PageFactory.initElements(Driver.getDriver(), this);
    
  }
    @FindBy(xpath ="//h3[.='Book Management']")
   public WebElement bookMangtHeader;

    public  void isCurrentPage(){
        Assert.assertEquals(Driver.getDriver().getTitle(),"Library");
    }

}
