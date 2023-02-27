package com.selenium.helpers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureHelper {
  private static String projectPath = System.getProperty("user.dir") + "\\";
  private static SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
  public static String captureScreenshot(WebDriver driver, String screenName) {
    try {
      TakesScreenshot ts = (TakesScreenshot) driver;
      File source = ts.getScreenshotAs(OutputType.FILE);
      File theDir = new File(projectPath + "ExportData\\images\\");
      if (!theDir.exists()) {
        theDir.mkdirs();
      }
      String filePath = "ExportData\\images\\" + screenName + "_" + dateFormat.format(new Date()) + ".png";
      //System.out.println(filePath);
      FileHandler.copy(source, new File(projectPath + filePath));
      return  "Capture image in '" + filePath + "'";
    } catch (Exception e) {
      return "Capture fail: '" + e.getMessage() + "'";
    }
  }
}
