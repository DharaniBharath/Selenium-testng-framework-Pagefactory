package com.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucessPage {

    public WebDriver driver;

    @FindBy(xpath = "//div//*[text()='Your Account Has Been Created!']")
    private WebElement accountcreatedText;

    @FindBy(xpath = "//a[contains(@class,'btn-primary') and .='Continue']")
    private WebElement continuebuttononAccountSucess;

    @Step("Click on continue button")
    public AccountPage clickoncontinuebutton()
    {
        continuebuttononAccountSucess.click();
        return new AccountPage(driver);
    }

    @Step("verify the account created text is showing")
    public boolean checkAccountcreatedText()
    {
        return accountcreatedText.isDisplayed();
    }

    public AccountSucessPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


}
