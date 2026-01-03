package com.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    public WebDriver driver;

    public AccountPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[.='Edit your account information']")
    private WebElement inputvalidverify;

    @Step("validating Edit your account information is displayed")
    public boolean validlogin_check()
    {
        return inputvalidverify.isDisplayed();
    }


}
