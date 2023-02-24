package com.selenium.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestContext {

  public static WebDriver getDriver(ITestResult result) {
    WebDriver driver;
    ITestContext context = result.getTestContext();
    driver = (WebDriver) context.getAttribute("WebDriver");
    return driver;
  }
  public static String getTestsName(ITestResult result) {
    ITestContext context = result.getTestContext();
    return context.getCurrentXmlTest().getName();
  }
}
