package com.selenium.project.testcases.myaccount;

import com.selenium.listeners.ListenerTest;
import com.selenium.project.helpers.PropertiesHelper;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Locale;

@Listeners(ListenerTest.class)
public class LoginTest extends BaseTest {

  @Test(priority = 0)
  public void loginSuccessful() {
    String username = PropertiesHelper.getValue("username");
    String password = PropertiesHelper.getValue("password");
    String expectedText = "Hello " + username + " (not " + username + "? Sign out)";
    loginPage.login(username, password);
    loginPage.verifySuccessText(expectedText);
  }

  @Test(priority = 1)
  public void loginWithIncorrectUsernameAndPassword() {
    String username = "nng729123";
    String password = "1234";
    String expectedText =
        "\"Error: the username "
            + username
            + " is not registered on this site. If you are unsure of your username, try your email address instead.";
    loginPage.login(username, password);
    loginPage.verifyInvalidUsernameText(expectedText);
  }

  @Test(priority = 2)
  public void loginWithEmptyPassword() {
    String username = "nng729";
    String password = "";
    String expectedText = "Error: Password is required.";
    loginPage.login(username, password);
    loginPage.verifyRequiredText(expectedText);
  }

  @Test(priority = 3)
  public void loginWithEmptyUsername() {
    String username = "";
    String password = "Lta@#3499";
    String expectedText = "Error: Username is required.";
    loginPage.login(username, password);
    loginPage.verifyRequiredText(expectedText);
  }

  @Test(priority = 4)
  public void loginWithEmptyUsernameAndPassword() {
    String username = "";
    String password = "";
    String expectedText = "Errorrrrr: Username is required.";
    loginPage.login(username, password);
    Assert.assertTrue(loginPage.verifyRequiredText(expectedText));
  }
  @Test
  public void loginWithPasswordMasked() {
    String username = "";
    String password = "12345";
    loginPage.login(username, password);
    loginPage.verifyPasswordMasked();
  }
  @Test
  public void loginWithUsernameChangeCase() {
    String username = PropertiesHelper.getValue("username").toUpperCase(Locale.ROOT);
    String password = PropertiesHelper.getValue("password");
    String expectedText = "Hello " + username + " (not " + username + "? Sign out)";
    loginPage.login(username, password);
    loginPage.verifySuccessText(expectedText);
  }
  @Test
  public void loginWithPasswordChangeCase() {
    String username = PropertiesHelper.getValue("username");
    String password = PropertiesHelper.getValue("password").toUpperCase(Locale.ROOT);
    String expectedText = "Error: the password you entered for the username " + username + " is incorrect. Lost your password?";
    loginPage.login(username, password);
    loginPage.verifyInvalidPasswordText(expectedText);
  }
}
