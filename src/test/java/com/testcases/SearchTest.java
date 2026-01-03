package com.testcases;

import com.PageObjects.HomePage;
import com.PageObjects.SearchPage;
import com.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

  //  WebDriver driver;
    HomePage home;
    SearchPage search;

    @BeforeMethod
    public void setup() {
        loadpropertiesFile();
        driver = initializebrowserandopenAppURL(pf.getProperty("browser"));
        home = new HomePage(driver);
    }

    // ======================= TEST 1 =======================

    @Severity(SeverityLevel.CRITICAL)
    @Story("Product Search")
    @Description("Verify that search results are displayed when user searches with a valid product name")
    @Test(priority = 1)
    public void searchwithvalidproduct() {

        home.entertextInsearchBox(dataprop.getProperty("validproduct"));
        search = home.clickonSearchButton();

        Assert.assertTrue(
                search.checkvalidproductisDisplayed(),
                "Valid product is not displayed in search results"
        );
    }

    // ======================= TEST 2 =======================

    @Severity(SeverityLevel.NORMAL)
    @Story("Product Search")
    @Description("Verify that proper message is shown when user searches with a non-existing product")
    @Test(priority = 2)
    public void searchwith_noexistent_product() {

        home.entertextInsearchBox(dataprop.getProperty("invalidproduct"));
        search = home.clickonSearchButton();

        Assert.assertTrue(
                search.Check_No_product_error_isDisplayed(),
                "No product error message is not shown for invalid product"
        );
    }

    // ======================= TEST 3 =======================

    @Severity(SeverityLevel.MINOR)
    @Story("Product Search")
    @Description("Verify that proper message is shown when user clicks search without entering any product")
    @Test(priority = 3)
    public void searchwithout_entering_product() {

        search = home.clickonSearchButton();

        Assert.assertTrue(
                search.Check_No_product_error_isDisplayed(),
                "No product error message is not shown when search is empty"
        );
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
