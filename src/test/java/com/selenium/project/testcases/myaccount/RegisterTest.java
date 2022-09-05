package com.selenium.project.testcases.myaccount;

import com.selenium.project.pages.myaccount.RegisterPage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
  @Test
  public void registrationSuccess() {
    String username = "nng279@gmail.com";
    String password = "Vbs!!@2322";
    String expectedText = "Hello " + username + " (not " + username + "? Sign out)";
    registerPage.register(username, password);
    registerPage.verifyLoginSuccess(expectedText);
  }
}
