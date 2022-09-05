package com.selenium.project.testcases.myaccount;

import com.selenium.project.helpers.PropertiesHelper;
import com.selenium.project.utils.Excel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Locale;

public class LoginTest extends BaseTest {
  private Excel excel = new Excel();
  @DataProvider(name = "loginData")
  public Object[][] getLoginData(Method m){
    Object[][] dataLoginIncorrect = new Object[2][2];
    if(m.getName().equalsIgnoreCase("loginWithIncorrectUsernameAndPassword")){
      excel.setExcelFile("./DataTest/login.xlsx", "IncorrectUsername");
    } else {
      excel.setExcelFile("./DataTest/login.xlsx", "EmptyPassword");
    }

    for(int i = 0; i < 2; i++) {
      dataLoginIncorrect[i][0] = excel.getCellData("username", i + 1);
      dataLoginIncorrect[i][1] = excel.getCellData("password", i + 1);
    }
    return  dataLoginIncorrect;
    /*return new Object[][] {
            {"abcxyzasn", "Lta@#3433"},
            {"abc1zxss", "Lta#$122"}
    };*/
  }
  @Test(priority = 0)
  @Parameters({"username", "password"})
  public void loginSuccessful(String username, String password) {
//    String username = PropertiesHelper.getValue("username");
//    String password = PropertiesHelper.getValue("password");
    String expectedText = "Hello " + username + " (not " + username + "? Sign out)";
    loginPage.login(username, password);
    Assert.assertTrue(loginPage.verifySuccessText(expectedText));
  }

  @Test(dataProvider = "loginData")
  public void loginWithIncorrectUsernameAndPassword(String username, String password) {
    String expectedText =
              "Error: the username "
                      + username
                      + " is not registered on this site. If you are unsure of your username, try your email address instead.";
      loginPage.login(username, password);
      Assert.assertTrue(loginPage.verifyInvalidUsernameText(expectedText));
  }

  @Test(dataProvider = "loginData")
  public void loginWithEmptyPassword(String username, String password) {
    String expectedText = "Error: Password is required.";
    loginPage.login(username, password);
    Assert.assertTrue(loginPage.verifyRequiredText(expectedText));
  }

  @Test(priority = 3)
  public void loginWithEmptyUsername() {
    String username = "";
    String password = "Lta@#3499";
    String expectedText = "Error: Username is required.";
    loginPage.login(username, password);
    Assert.assertTrue(loginPage.verifyRequiredText(expectedText));
  }

  @Test(priority = 4)
  public void loginWithEmptyUsernameAndPassword() {
    String username = "";
    String password = "";
    String expectedText = "Error: Username is required.";
    loginPage.login(username, password);
    Assert.assertTrue(loginPage.verifyRequiredText(expectedText));
  }
  @Test
  public void loginWithPasswordMasked() {
    String username = "";
    String password = "12345";
    loginPage.login(username, password);
    Assert.assertTrue(loginPage.verifyPasswordMasked());
  }
  @Test
  public void loginWithUsernameChangeCase() {
    String username = PropertiesHelper.getValue("username").toUpperCase(Locale.ROOT);
    String password = PropertiesHelper.getValue("password");
    String expectedText = "Hello " + username.toLowerCase() + " (not " + username.toLowerCase() + "? Sign out)";
    loginPage.login(username, password);
    Assert.assertTrue(loginPage.verifySuccessText(expectedText));
  }
  @Test
  public void loginWithPasswordChangeCase() {
    String username = PropertiesHelper.getValue("username");
    String password = PropertiesHelper.getValue("password").toUpperCase(Locale.ROOT);
    String expectedText = "Error: the password you entered for the username " + username + " is incorrect. Lost your password?";
    loginPage.login(username, password);
    Assert.assertTrue(loginPage.verifyInvalidPasswordText(expectedText));
  }
}
