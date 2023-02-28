package com.selenium.project.demoSite.testcases;

import com.selenium.common.SetupDriver;
import com.selenium.helpers.PropertiesHelper;
import com.selenium.project.demoSite.pages.FileUploadPage;
import com.selenium.project.demoSite.pages.MenuBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadTest extends SetupDriver {

  private MenuBar menuBar;
  private FileUploadPage fileUploadPage;
  String filePath = System.getProperty("userDir") + "/DataTest/login.xlsx";

  @BeforeMethod
  public void openFileUploadPage() {
    menuBar = new MenuBar(driver, wait);

    driver.get(PropertiesHelper.getValue("DEMO_URL"));

    fileUploadPage = menuBar.openFIleUpload();
  }

  @Test
  public void uploadFileSuccess() {
    fileUploadPage.uploadFileUseSendKey();
    Assert.assertTrue(fileUploadPage.verifyFileUploadSuccess());
  }

  @Test
  public void uploadFileSuccessUseRobot() {
    fileUploadPage.uploadFileUseRobotClass(filePath);
    Assert.assertTrue(fileUploadPage.verifyFileUploadSuccess());
  }
}
