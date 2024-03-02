package com.selenium.project.practiceSite.testcases.myaccount;

import com.selenium.common.SetupDriver;
import com.selenium.helpers.PropertiesHelper;
import com.selenium.project.practiceSite.pages.MenuBar;
import com.selenium.project.practiceSite.pages.myaccount.LoginPage;
import com.selenium.project.practiceSite.pages.myaccount.RegisterPage;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest extends SetupDriver {
  private MenuBar menuBar;
  protected LoginPage loginPage;
  protected RegisterPage registerPage;

  @BeforeMethod
  public void beforeBaseTest() {
    driver.get(PropertiesHelper.getValue("PRACTICE_URL"));
    menuBar = new MenuBar(driver);
    registerPage = new RegisterPage(driver);
    loginPage = menuBar.OpenMyAccountPage();
  }
}
