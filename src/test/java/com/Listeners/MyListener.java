package com.Listeners;
import com.allurereportsData.AllureLog;
import com.base.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class MyListener implements ITestListener {

    int passedCount = 0;
    int failedCount = 0;
    int skippedCount = 0;

    @Override
    public void onStart(ITestContext result) {
        String msg =
                "===== TEST EXECUTION STARTED =====\n" +
                        "Suite Name : " + result.getSuite().getName() + "\n" +
                        "Start Time : " + result.getStartDate();

        AllureLog.log(msg);

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED : " + result.getMethod().getMethodName());
        AllureLog.log("TEST STARTED : " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        passedCount++;
        AllureLog.log("TEST PASSED : " + result.getMethod().getMethodName());
        allurescreenshot(result);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        AllureLog.log("Test FAILED: " + result.getMethod().getMethodName());
        AllureLog.log("Reason: " + result.getThrowable());
        allurescreenshot(result);
    }

    public void allurescreenshot(ITestResult result)
    {
        Object testClass = result.getInstance();
        if (testClass instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testClass;
            if (baseTest.driver != null) {
                saveScreenshotPNG(baseTest.driver);
            }
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skippedCount++;
        System.out.println("TEST SKIPPED : " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        AllureLog.log("===== TEST EXECUTION FINISHED =====");
        System.out.println("===== TEST EXECUTION FINISHED =====");
        System.out.println("Total Tests : " + context.getAllTestMethods().length);
        System.out.println("Passed : " + passedCount);
        System.out.println("Failed : " + failedCount);
        System.out.println("Skipped : " + skippedCount);
        System.out.println("End Time : " + context.getEndDate());
    }
}
