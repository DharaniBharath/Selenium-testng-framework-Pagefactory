package com.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;
    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement MyaccountDropDown;

    @FindBy(xpath = "//a[.='Login']")
    private WebElement loginbutton;

    @FindBy(xpath = "//a[.='Register']")
     private WebElement registerbutton;

    @FindBy(xpath ="//input[@name='search']")
    private WebElement serachbox;

    @FindBy(xpath ="//div//span[@class='input-group-btn']//button")
    private WebElement serachbutton;


    @Step("Enter the product in search box {0}")
    public void entertextInsearchBox(String product)
    {
        serachbox.sendKeys(product);
    }

    @Step("Click on searchbutton")
    public SearchPage clickonSearchButton()
    {
        serachbutton.click();
        return new SearchPage(driver);
    }

public HomePage(WebDriver driver)
{
    this.driver=driver;
    PageFactory.initElements(driver,this);
}

@Step("Click on my account button")
public void clickonMyaccount()
{
    MyaccountDropDown.click();
}

@Step("Click on register button")
public RegisterPage clickonregister()
{
    registerbutton.click();
    return new RegisterPage(driver);
}

@Step("Click on loginbutton")
public LoginPage selectloginoption()
{
    loginbutton.click();
    return new LoginPage(driver);
}

}
