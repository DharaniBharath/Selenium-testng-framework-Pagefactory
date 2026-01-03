package com.testcases;

import com.PageObjects.AccountPage;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.base.BaseTest;
import com.utils.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
   // WebDriver driver;
    LoginPage loginp;
    @BeforeMethod
    public void setUp()
    {
        loadpropertiesFile();
        driver= initializebrowserandopenAppURL(pf.getProperty("browser"));
        HomePage homep=new HomePage(driver);
        homep.clickonMyaccount();
        loginp=homep.selectloginoption();
    }

   @AfterMethod
    public void quit()
    {
        driver.quit();
    }

    @Description("This test case will check whether user can login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Story("To Check login page with valid creds")
    @Test (priority = 1)
    public void verifyloginwith_valid_credentials(){
        loginp.enterinputemail(dataprop.getProperty("existemail"));
        loginp.enterPassword(dataprop.getProperty("validpswd"));
        AccountPage acc=loginp.clickonsubmit();
        Assert.assertTrue(acc.validlogin_check());

    }

    @Description("This test case will check whether user can login with invalid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Story("To Check login page with invalid creds")
    @Test(priority = 2)
    public void verifyloginwith_invalid_credentials(){
        loginp.enterinputemail("bharathddb421"+ Utility.timeStampnumber()+"@gmail.com");
        loginp.enterPassword(dataprop.getProperty("invalidpswd"));
        loginp.clickonsubmit();
        Assert.assertTrue(loginp.invalid_login_check());

    }

    @Description("This test case will erifyloginwith_invalid_email_valid_password")
    @Severity(SeverityLevel.BLOCKER)
    @Story("To Check erifyloginwith_invalid_email_valid_password")
    @Test(priority = 3)
    public void verifyloginwith_invalid_email_valid_password(){
        loginp.enterinputemail("bharathddb421"+ Utility.timeStampnumber()+"@gmail.com");
        loginp.enterPassword(dataprop.getProperty("validpswd"));
        loginp.clickonsubmit();
        Assert.assertTrue(loginp.invalid_login_check());
    }

    @Description("This test case will verifyloginwith_valid_email_invalid_password")
    @Severity(SeverityLevel.BLOCKER)
    @Story("To Check verifyloginwith_valid_email_invalid_password")
    @Test(priority = 4)
    public void verifyloginwith_valid_email_invalid_password(){
        loginp.enterinputemail(dataprop.getProperty("existemail"));
        loginp.enterPassword(dataprop.getProperty("invalidpswd"));
        loginp.clickonsubmit();
        Assert.assertTrue(loginp.invalid_login_check());
    }

    @Description("This test case will verifyloginwithout_email_password")
    @Severity(SeverityLevel.BLOCKER)
    @Story("To Check verifyloginwithout_email_password")
    @Test(priority = 5)
    public void verifyloginwithout_email_password(){
        loginp.clickonsubmit();
        Assert.assertTrue(loginp.invalid_login_check());
    }

    @DataProvider(name="supplyTestdata")
    public Object[][] supplyTest()
    {
        return Utility.getDatafromExcelfile("Login");

    }

    @Description("This test case will verifyloginwithInvalidCredential with datadriven with excel")
    @Severity(SeverityLevel.BLOCKER)
    @Story("To Check verifyloginwithInvalidCredential with excel data driven")
    @Test(priority = 6,dataProvider = "supplyTestdata", enabled = true)
    public void verifyloginwithInvalidCredential(String email, String password){
        loginp.enterinputemail(email);
        loginp.enterPassword(password);
        loginp.clickonsubmit();
        Assert.assertTrue(loginp.invalid_login_check());
    }

}
