package com.selenium.project.testcases.myaccount;

import com.selenium.project.helpers.PropertiesHelper;
import com.selenium.project.pages.myaccount.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.selenium.listeners.ListenerTest.class)
public class LoginTest extends BaseTest {
  //private LoginPage loginPage;
  private static final Logger log = LogManager.getLogger(LoginTest.class.getName());

  @Test(priority = 0)
  public void loginSuccessful() {
    log.info("***Test login successful***");
    String username = PropertiesHelper.getValue("username");
    String password = PropertiesHelper.getValue("password");
    String expectedText = "Hello " + username + " (not " + username + "? Sign out)";
    loginPage.login(username, password);
    if (loginPage.verifySuccessText(expectedText)) {
      log.info("test pass");
    } else log.info("test fail");
  }

  @Test(priority = 1)
  public void loginWithIncorrectUsernameAndPassword() {
    String username = "nng729123";
    String password = "1234";
    String expectedText =
        "\"Error: the username "
            + username
            + " is not registered on this site. If you are unsure of your username, try your email address instead.";
    //loginPage = new LoginPage(driver);
    loginPage.login(username, password);
    loginPage.verifyInvalidUsernameText(expectedText);
  }

  @Test(priority = 2)
  public void loginWithEmptyPassword() {
    String username = "nng729";
    String password = "";
    String expectedText = "Error: Password is required.";
    //loginPage = new LoginPage(driver);
    loginPage.login(username, password);
    loginPage.verifyErrorText(expectedText);
  }

  @Test(priority = 3)
  public void loginWithEmptyUsername() {
    String username = "";
    String password = "Lta@#3499";
    String expectedText = "Error: Username is required.";
    //loginPage = new LoginPage(driver);
    loginPage.login(username, password);
    loginPage.verifyErrorText(expectedText);
  }

  @Test(priority = 4)
  public void loginWithEmptyUsernameAndPassword() {
    String username = "";
    String password = "";
    String expectedText = "Error: Username is required.";
    //loginPage = new LoginPage(driver);
    loginPage.login(username, password);
    loginPage.verifyErrorText(expectedText);
  }
  @Test
  public void loginWithPasswordMasked(){
    String password = "12345";
    loginPage.login("", password);
    loginPage.verifyPasswordMasked();
  }
  @Test
  public void loginWithUsernameChangeCase(){
    String username = "NNG729";
    String password = PropertiesHelper.getValue("password");
    String expectedText = "Hello " + username + " (not " + username + "? Sign out)";
    loginPage.login(username, password);
    if (loginPage.verifySuccessText(expectedText)) {
      log.info("test pass");
    } else log.info("test fail");
  }

  public void loginWithPasswordChangeCase(){
    String username = "nng729";
    String password = "lTA@#3499";
    String expectedText = "Error: the password you entered for the username " + username + " is incorrect. Lost your password?";
    loginPage.login(username, password);
    if (loginPage.verifyErrorText(expectedText)) {
      log.info("test pass");
    } else log.info("test fail");
  }
  public void loginAuthentication(){
    loginSuccessful();
  }
}
