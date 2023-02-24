package com.selenium.listeners;

import static com.selenium.extentreports.ExtentManager.getExtentReports;

import com.aventstack.extentreports.Status;
import com.selenium.extentreports.ExtentTestManager;
import com.selenium.main.helpers.CaptureHelper;
import com.selenium.main.utils.Log;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

  private WebDriver driver;

  public String getTestName(ITestResult result) {
    return result.getTestName();
  }

  public String getTestDescription(ITestResult result) {
    return result.getMethod().getDescription();
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
    ExtentTestManager.addScreenShot(Status.FAIL, getTestName(result), driver);
    ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
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
