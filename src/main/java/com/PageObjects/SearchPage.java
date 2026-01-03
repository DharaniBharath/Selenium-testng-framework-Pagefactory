package com.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

   public WebDriver driver;
    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[.='HP LP3065']")
    private WebElement validproduct;

    @FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
    private WebElement noproductError;

    @Step("check valid product is displayed")
    public boolean checkvalidproductisDisplayed()
    {
       return validproduct.isDisplayed();
    }

    @Step("Check no product error is displayed")
    public boolean Check_No_product_error_isDisplayed()
    {
        return noproductError.isDisplayed();
    }

}
