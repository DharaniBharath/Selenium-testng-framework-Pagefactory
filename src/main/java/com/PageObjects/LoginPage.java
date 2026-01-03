package com.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(id = "input-email")
    private WebElement inputemail;

    @FindBy(id = "input-password")
    private WebElement inputpassword;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitbutton;

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement input_invalidverifymessage;


    @Step("Enter the Email: {0}")
    public void enterinputemail(String email)
    {
        inputemail.sendKeys(email);
    }

    @Step("Enter the Password: {0} ")
    public void enterPassword(String password)
    {
        inputpassword.sendKeys(password);
    }

    @Step("Click on submit ")
    public AccountPage clickonsubmit()
    {
        submitbutton.click();
        return new AccountPage(driver);
    }

    @Step("Checking for invalid error message")
    public boolean invalid_login_check()
    {
        return input_invalidverifymessage.isDisplayed();
    }


    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
