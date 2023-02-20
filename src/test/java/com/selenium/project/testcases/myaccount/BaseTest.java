package com.selenium.project.testcases.myaccount;

import com.selenium.project.common.SetupDriver;
import com.selenium.project.pages.MenuBar;
import com.selenium.project.pages.myaccount.LoginPage;
import com.selenium.project.pages.myaccount.RegisterPage;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends SetupDriver {
  private MenuBar menuBar;
  protected LoginPage loginPage;
  protected RegisterPage registerPage;
  @BeforeMethod
  public void beforeBaseTest(){
    menuBar = new MenuBar(driver);
    registerPage = new RegisterPage(driver);
    loginPage = menuBar.OpenMyAccountPage();
  }
}
