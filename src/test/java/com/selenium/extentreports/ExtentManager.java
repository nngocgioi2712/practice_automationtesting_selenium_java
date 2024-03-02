package com.selenium.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentManager {
  private static final ExtentReports EXTENT_REPORTS = new ExtentReports();

  public static synchronized ExtentReports getExtentReports() {
    ExtentSparkReporter reporter = new ExtentSparkReporter("./target/test-reports/ExtentReports/ExtentReport.html");
    reporter.config().setReportName("Practice Automation Test Selenium Extent Report");
    // reporter.config().setDocumentTitle("DocumentTitle");
    // reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.LOGIN,
    // ViewName.SORT}).apply();
    EXTENT_REPORTS.attachReporter(reporter);
    return EXTENT_REPORTS;
  }
}
