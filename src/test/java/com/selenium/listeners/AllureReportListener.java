package com.selenium.listeners;

import static com.selenium.extentreports.ExtentManager.getExtentReports;

import com.aventstack.extentreports.Status;
import com.selenium.extentreports.ExtentTestManager;
import com.selenium.helpers.CaptureHelper;
import com.selenium.utils.Log;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureReportListener implements ITestListener {

    private WebDriver driver;

    public String getTestName(ITestResult result) {
        return result.getTestName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html){
        return html;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext context) {
        Log.info("***********Start Scenario**************");
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("*************Finish Scenario************");
        getExtentReports().flush();
    }
    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Start testcase: " + result.getName());
        ExtentTestManager.saveToReport(result.getName(), result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().assignCategory(TestContext.getTestsName(result));
        // TestContext.getTestsName(result);
        System.out.println(TestContext.getTestsName(result));
        Log.info("Testcase '" + result.getName() + "' passed.");
        ExtentTestManager.logMessage(Status.PASS, getTestDescription(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        driver = TestContext.getDriver(result);

        Log.error(result.getName() + " failed.");
        Log.info(CaptureHelper.captureScreenshot(driver, result.getName()));

        saveScreenshotPNG(driver);
        saveTextLog(result.getMethod().getMethodName() + "Failed and screenshot taken!");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        driver = TestContext.getDriver(result);
        Log.info(result.getName() + " skipped.");
        Log.info(CaptureHelper.captureScreenshot(driver, result.getName()));
        ExtentTestManager.addScreenShot(Status.SKIP, getTestName(result), driver);
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        driver = TestContext.getDriver(result);
        Log.info(result.getName() + " failed with timeout.");
        ExtentTestManager.addScreenShot(Status.FAIL, getTestName(result), driver);
        Log.info(CaptureHelper.captureScreenshot(driver, result.getName()));
    }
}
