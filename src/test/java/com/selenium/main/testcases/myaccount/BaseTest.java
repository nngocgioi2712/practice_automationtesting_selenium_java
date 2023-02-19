package com.selenium.main.testcases.myaccount;

import com.selenium.main.common.SetupDriver;
import com.selenium.main.pages.MenuBar;
import com.selenium.main.pages.myaccount.LoginPage;
import com.selenium.main.pages.myaccount.RegisterPage;
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
