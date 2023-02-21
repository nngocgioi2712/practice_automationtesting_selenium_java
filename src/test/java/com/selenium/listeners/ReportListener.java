package com.selenium.listeners;

import com.aventstack.extentreports.Status;
import com.selenium.extentreports.ExtentTestManager;
import com.selenium.project.common.SetupDriver;
import com.selenium.main.helpers.CaptureHelper;
import com.selenium.main.utils.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.selenium.extentreports.ExtentManager.getExtentReports;

public class ReportListener implements ITestListener {
    public String getTestName(ITestResult result){
    return result.getTestName();
    }
    public String getTestDescription(ITestResult result){
        return result.getMethod().getDescription();
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Start testcase: " + result.getName());
        ExtentTestManager.saveToReport(result.getName(), result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Testcase '" + result.getName() + "' passed.");
        ExtentTestManager.logMessage(Status.PASS, getTestDescription(result));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error(result.getName() + " failed.");
        Log.info(CaptureHelper.captureScreenshot(SetupDriver.getDriver(), result.getName()));
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info(result.getName() + " skipped.");
        Log.info(CaptureHelper.captureScreenshot(SetupDriver.getDriver(), result.getName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        Log.info(result.getName() + " failed with timeout.");
        Log.info(CaptureHelper.captureScreenshot(SetupDriver.getDriver(), result.getName()));
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
}
