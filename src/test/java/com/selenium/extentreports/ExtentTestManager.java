package com.selenium.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
  static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
  static ExtentReports extent = ExtentManager.getExtentReports();

  public static ExtentTest getTest() {
    return extentTestMap.get((int) Thread.currentThread().getId());
  }

  public static synchronized ExtentTest saveToReport(String testName, String desc) {
    ExtentTest test = extent.createTest(testName, desc);
    test.assignCategory("Login Test", "ShopTest");
    extentTestMap.put((int) Thread.currentThread().getId(), test);
    return test;
  }

  public static void addScreenShot(String mess, WebDriver driver) {
    String base64Image =
        "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    getTest()
        .log(
            Status.INFO,
            mess,
            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
  }

  public static void addScreenShot(Status status, String mess, WebDriver driver) {
    String base64Image =
        "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    getTest()
        .log(
            status,
            mess,
            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
  }

  public static void logMessage(String mess) {
    getTest().log(Status.INFO, mess);
  }

  public static void logMessage(Status status, String mess) {
    getTest().log(status, mess);
  }
}
