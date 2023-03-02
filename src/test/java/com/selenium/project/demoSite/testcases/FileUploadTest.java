package com.selenium.project.demoSite.testcases;

import com.selenium.common.SetupDriver;
import com.selenium.helpers.PropertiesHelper;
import com.selenium.project.demoSite.pages.FileUploadPage;
import com.selenium.project.demoSite.pages.MenuBar;
import com.selenium.utils.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadTest extends SetupDriver {

  private MenuBar menuBar;
  private FileUploadPage fileUploadPage;
  String filePath = System.getProperty("user.dir") + "\\DataTest\\login.xlsx";
  String fileName = "login.xlsx";

  @BeforeMethod
  public void openFileUploadPage() {
    menuBar = new MenuBar(driver, wait);

    driver.get(PropertiesHelper.getValue("DEMO_URL"));

    fileUploadPage = menuBar.openFIleUpload();
  }

  @Test
  public void uploadFileSuccess() {
    fileUploadPage.uploadFileUseSendKey(filePath);
    Assert.assertTrue(fileUploadPage.verifyFileUploadSuccess(fileName));
  }

  @Test
  public void uploadFileSuccessUseRobot() {
    try {
      fileUploadPage.uploadFileUseRobotClass(filePath);
    } catch (InterruptedException e) {
      Log.error(e.getMessage());
    }

    Assert.assertTrue(fileUploadPage.verifyFileUploadSuccess(fileName));
  }
}
