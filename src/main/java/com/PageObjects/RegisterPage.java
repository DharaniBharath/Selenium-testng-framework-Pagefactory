package com.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public WebDriver driver;

    public RegisterPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement fname;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private  WebElement lname;

    @FindBy(xpath = "//input[@id='input-email']")
    private  WebElement emIL;

    @FindBy(xpath = "//input[@id='input-telephone']")
    private  WebElement cell;

    @FindBy(xpath = "//input[@id='input-password']")
    private  WebElement inputPswd;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private  WebElement cfmpswd;

    @FindBy(xpath = "//input[@type='checkbox']")
    private  WebElement checkbx;

    @FindBy(xpath ="//input[@type='submit']")
    private  WebElement continuebutton;

    @FindBy(xpath = "//input[@name='newsletter' and @value='1']")
    private WebElement newlettercheckbox;

    @FindBy(xpath = "//div/*[text()='Warning: E-Mail Address is already registered!']")
    private WebElement emailwarningifexist;

    @FindBy(xpath = "//div[.='Warning: You must agree to the Privacy Policy!']")
    private WebElement privacyPolicyError;

    @FindBy(xpath = "//div[.='First Name must be between 1 and 32 characters!']")
    private WebElement firstNameError;

    @FindBy(xpath = "//div[.='Last Name must be between 1 and 32 characters!']")
    private WebElement lastNameError;

    @FindBy(xpath = "//div[.='E-Mail Address does not appear to be valid!']")
    private WebElement emailError;

    @FindBy(xpath = "//div[.='Telephone must be between 3 and 32 characters!']")
    private WebElement phoneError;

    @FindBy(xpath = "//div[.='Password must be between 4 and 20 characters!']")
    private WebElement passwordError;


    @Step("Get Privacy Policy warning message")
    public String getPrivacyPolicyError() {
        return privacyPolicyError.getText();
    }

    @Step("Get First Name validation error message")
    public String getFirstNameError() {
        return firstNameError.getText();
    }

    @Step("Get Last Name validation error message")
    public String getLastNameError() {
        return lastNameError.getText();
    }

    @Step("Get Email validation error message")
    public String getEmailError() {
        return emailError.getText();
    }

    @Step("Get Phone validation error message")
    public String getPhoneError() {
        return phoneError.getText();
    }

    @Step("Get Password validation error message")
    public String getPasswordError() {
        return passwordError.getText();
    }

    @Step("Check if email already exists warning is displayed")
    public boolean checkthemailwarning() {
        return emailwarningifexist.isDisplayed();
    }


    @Step("Accept Privacy Policy checkbox")
    public void clickoncheckbox() {
        checkbx.click();
    }

    @Step("Subscribe to newsletter")
    public void newlettercheckboX() {
        newlettercheckbox.click();
    }

    @Step("Click on Continue button and navigate to Account Success page")
    public AccountSucessPage clickoncontinue() {
        continuebutton.click();
        return new AccountSucessPage(driver);
    }


    @Step("Enter First Name: {firstname}")
    public void enterfirstname(String firstname) {
        fname.sendKeys(firstname);
    }

    @Step("Enter Last Name: {lastname}")
    public void enterlastname(String lastname) {
        lname.sendKeys(lastname);
    }

    @Step("Enter Email address: {email}")
    public void enteremail(String email) {
        emIL.sendKeys(email);
    }

    @Step("Enter Telephone number: {phone}")
    public void entertelephone(String phone) {
        cell.sendKeys(phone);
    }

    @Step("Enter Password")
    public void enterpassword(String pswd) {
        inputPswd.sendKeys(pswd);
    }

    @Step("Confirm Password")
    public void confirmpaswd(String paswd) {
        cfmpswd.sendKeys(paswd);
    }

}
