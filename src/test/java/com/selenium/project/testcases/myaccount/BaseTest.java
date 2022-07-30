package com.selenium.project.testcases.myaccount;

import com.selenium.project.common.Helper;
import com.selenium.project.common.SetupDriver;
import com.selenium.project.pages.MenuBar;
import com.selenium.project.pages.myaccount.LoginPage;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends SetupDriver {
  private MenuBar menuBar;
  protected LoginPage loginPage;
  private Helper helper;

  @BeforeMethod
  public void beforeBaseTest() throws Exception {
    //helper = new Helper(driver);
    menuBar = new MenuBar(driver);

    Thread.sleep(3000);
    //helper.waitForPageLoaded();
    loginPage = menuBar.OpenMyAccountPage();
  }
}
