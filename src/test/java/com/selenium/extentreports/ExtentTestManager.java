package com.selenium.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.project.common.SetupDriver;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.getExtentReports();

    public static ExtentTest getTest(){
        return extentTestMap.get((int) Thread.currentThread().getId());
    }
    public static synchronized ExtentTest saveToReport(String testName, String desc){
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
public WebDriver getDriver(){
        WebDriver driver = SetupDriver.getDriver();
        return driver;
}
public static void logMessage(String mess){
        getTest().log(Status.INFO, mess);
}

public static void logMessage(Status status, String mess){
        getTest().log(status, mess);
}
}
