package com.testcases;

import com.PageObjects.AccountPage;
import com.PageObjects.AccountSucessPage;
import com.PageObjects.HomePage;
import com.PageObjects.RegisterPage;
import com.base.BaseTest;
import com.utils.Utility;
import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    //WebDriver driver;
    RegisterPage rg;
    AccountSucessPage as;
    AccountPage account;

    @BeforeMethod
    public void setup() {
        loadpropertiesFile();
        driver = initializebrowserandopenAppURL(pf.getProperty("browser"));
        HomePage home = new HomePage(driver);
        home.clickonMyaccount();
        rg = home.clickonregister();
    }

    // ======================= TEST 1 =======================

    @Severity(SeverityLevel.CRITICAL)
    @Story("User Registration")
    @Description("Verify that user can register successfully by providing only mandatory fields")
    @Test(priority = 1)
    public void verify_register_an_account_with_mandatory_filed() {

        Faker faker = new Faker();
        String firstname = faker.name().fullName();
        String lastname = faker.name().lastName();
        String phone = faker.phoneNumber().cellPhone();
        String email = "bharathddb421+" + Utility.timeStampnumber() + "@gmail.com";

        rg.enterfirstname(firstname);
        rg.enterlastname(lastname);
        rg.enteremail(email);
        rg.entertelephone(phone);
        rg.enterpassword(dataprop.getProperty("validpswd"));
        rg.confirmpaswd(dataprop.getProperty("validpswd"));
        rg.clickoncheckbox();

        as = rg.clickoncontinue();
        Assert.assertTrue(as.checkAccountcreatedText(), "Account creation failed");
    }

    // ======================= TEST 2 =======================

    @Severity(SeverityLevel.BLOCKER)
    @Story("User Registration")
    @Description("Verify that user can register successfully by providing all fields including newsletter subscription")
    @Test(priority = 2)
    public void verify_register_an_account_with_all_filed() {

        Faker faker = new Faker();
        String firstname = faker.name().fullName();
        String lastname = faker.name().lastName();
        String phone = faker.phoneNumber().cellPhone();
        String email = "bharathddb421+" + Utility.timeStamp() + "@gmail.com";

        rg.enterfirstname(firstname);
        rg.enterlastname(lastname);
        rg.enteremail(email);
        rg.entertelephone(phone);
        rg.enterpassword(dataprop.getProperty("validpswd"));
        rg.confirmpaswd(dataprop.getProperty("validpswd"));
        rg.clickoncheckbox();
        rg.newlettercheckboX();

        as = rg.clickoncontinue();
        Assert.assertTrue(as.checkAccountcreatedText());

        account = as.clickoncontinuebutton();
        Assert.assertTrue(account.validlogin_check(), "User not navigated to account page");
    }

    // ======================= TEST 3 =======================

    @Severity(SeverityLevel.NORMAL)
    @Story("User Registration")
    @Description("Verify that registration fails when user tries to register with an already existing email address")
    @Test(priority = 3)
    public void verify_register_an_account_with_existing_email() {

        Faker faker = new Faker();
        String firstname = faker.name().fullName();
        String lastname = faker.name().lastName();
        String phone = faker.phoneNumber().cellPhone();

        rg.enterfirstname(firstname);
        rg.enterlastname(lastname);
        rg.enteremail(dataprop.getProperty("existemail"));
        rg.entertelephone(phone);
        rg.enterpassword(dataprop.getProperty("validpswd"));
        rg.confirmpaswd(dataprop.getProperty("validpswd"));
        rg.clickoncheckbox();
        rg.newlettercheckboX();
        rg.clickoncontinue();

        Assert.assertTrue(
                rg.checkthemailwarning(),
                "Warning: E-Mail Address is already registered!"
        );
    }

    // ======================= TEST 4 =======================

    @Severity(SeverityLevel.MINOR)
    @Story("User Registration")
    @Description("Verify validation error messages when user submits registration form without entering any data")
    @Test(priority = 4)
    public void verifyallfielsmessagesNodataprovided() {

        rg.clickoncontinue();

        Assert.assertEquals(
                rg.getPrivacyPolicyError(),
                "Warning: You must agree to the Privacy Policy!",
                "Privacy policy error not displayed"
        );
        Assert.assertEquals(rg.getFirstNameError(), "First Name must be between 1 and 32 characters!");
        Assert.assertEquals(rg.getLastNameError(), "Last Name must be between 1 and 32 characters!");
        Assert.assertEquals(rg.getEmailError(), "E-Mail Address does not appear to be valid!");
        Assert.assertEquals(rg.getPhoneError(), "Telephone must be between 3 and 32 characters!");
        Assert.assertEquals(rg.getPasswordError(), "Password must be between 4 and 20 characters!");
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
