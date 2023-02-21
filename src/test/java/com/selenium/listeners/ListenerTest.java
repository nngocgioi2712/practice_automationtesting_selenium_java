package com.selenium.listeners;

import com.selenium.main.helpers.CaptureHelper;
import com.selenium.main.utils.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class ListenerTest implements ITestListener {

  private WebDriver driver;
  @Override
  public void onTestStart(ITestResult result) {
    Log.info("Start testcase: " + result.getName());
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    ITestContext context = result.getTestContext();
    driver = (WebDriver) context.getAttribute("WebDriver");
    Log.info("Testcase '" + result.getName() + "' passed.");
    Log.info(CaptureHelper.captureScreenshot(driver , result.getName()));
  }

  @Override
  public void onTestFailure(ITestResult result) {
    ITestContext context = result.getTestContext();
    driver = (WebDriver) context.getAttribute("WebDriver");
    Log.error(result.getName() + " failed.");
    Log.info(CaptureHelper.captureScreenshot(driver , result.getName()));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    ITestContext context = result.getTestContext();
    driver = (WebDriver) context.getAttribute("WebDriver");
    Log.info(result.getName() + " skipped.");
    Log.info(CaptureHelper.captureScreenshot(driver, result.getName()));
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {
    ITestContext context = result.getTestContext();
    driver = (WebDriver) context.getAttribute("WebDriver");
    Log.info(result.getName() + " failed with timeout.");
    Log.info(CaptureHelper.captureScreenshot(driver, result.getName()));
  }

  @Override
  public void onStart(ITestContext context) {
      Log.debug("***********Start Scenario**************");
  }

  @Override
  public void onFinish(ITestContext context) {
      Log.info("*************Finish Scenario************");
  }
}
