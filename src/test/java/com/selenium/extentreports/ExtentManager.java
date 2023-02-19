package com.selenium.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static final ExtentReports EXTENT_REPORTS = new ExtentReports();
    public synchronized static ExtentReports getExtentReports(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/ExtentReport.html");
        reporter.config().setReportName("Practice Automation Test Selenium Extent Report");
        EXTENT_REPORTS.attachReporter(reporter);
        return EXTENT_REPORTS;
    }
}