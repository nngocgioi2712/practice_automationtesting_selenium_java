package com.selenium.listeners;

import com.selenium.project.common.SetupDriver;
import com.selenium.project.helpers.CaptureHelper;
import com.selenium.project.utils.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
  @Override
  public void onTestStart(ITestResult result) {
    Log.info("Start testcase: " + result.getName());
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    Log.info("Testcase passed: " + result.getName());
    Log.info(CaptureHelper.captureScreenshot(SetupDriver.getDriver(), result.getName()));

  }

  @Override
  public void onTestFailure(ITestResult result) {}

  @Override
  public void onTestSkipped(ITestResult result) {}

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {
    this.onTestFailure(result);
  }

  @Override
  public void onStart(ITestContext context) {
      Log.info("Start Scenario");
  }

  @Override
  public void onFinish(ITestContext context) {
      Log.info("Finish Scenario");
  }
}
