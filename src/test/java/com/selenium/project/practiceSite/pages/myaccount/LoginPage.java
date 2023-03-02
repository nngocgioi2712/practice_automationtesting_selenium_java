package com.selenium.project.practiceSite.pages.myaccount;

import com.selenium.utils.Log;
import com.selenium.utils.WebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  private WebDriver driver;

  @FindBy(css = "#username")
  private WebElement txt_username;

  @FindBy(css = "#password")
  private WebElement txt_password;

  @FindBy(xpath = "//input[@name = 'login']")
  private WebElement btn_login;

  @FindBy(xpath = "//div[@class = 'page-content entry-content']//p")
  private WebElement lbl_welcome;

  @FindBy(xpath = "//strong[text() = \"Error:\"]//parent::li")
  private WebElement msg_RequiredFields;

  @FindBy(xpath = "//strong[text() = \"Error\"]//parent::li")
  private WebElement msg_invalidFields;

  public LoginPage(WebDriver _driver) {
    driver = _driver;
    if (!driver.getTitle().contains("My Account")) {
      throw new IllegalArgumentException(String.format("Page is not My Account"));
    } else {
      PageFactory.initElements(_driver, this);
    }
  }

  @Step("Login with username: {0} and password: {1}")
  public void login(String username, String password) {
    Log.info("Login with username: \"" + username + "\" and password: \"" + password + "\"");
    WebUI.setText(txt_username, username);
    WebUI.setText(txt_password, password);
    btn_login.click();
  }

  @Step("Verify login success")
  public boolean verifySuccessText(String expectedText) {
    if (lbl_welcome.getText().equals(expectedText)) return true;
    else {
      Log.error(
          "Actual text is \""
              + msg_invalidFields.getText()
              + "\" and Expected text is \""
              + expectedText
              + "\"");
      return false;
    }
  }

  @Step("Verify required field")
  public boolean verifyRequiredText(String expectedText) {
    if (msg_RequiredFields.getText().equals(expectedText)) return true;
    else {
      Log.error(
          "Actual text is \""
              + msg_invalidFields.getText()
              + "\" and Expected text is \""
              + expectedText
              + "\"");
      return false;
    }
  }

  @Step("Verify input invalid username")
  public boolean verifyInvalidUsernameText(String expectedText) {
    if (msg_invalidFields.getText().equals(expectedText)) return true;
    else {
      Log.error(
          "Actual text is \""
              + msg_invalidFields.getText()
              + "\" and Expected text is \""
              + expectedText
              + "\"");
      return false;
    }
  }

  @Step("Verify input invalid password")
  public boolean verifyInvalidPasswordText(String expectedText) {
    if (msg_invalidFields.getText().equals(expectedText)) return true;
    else {
      Log.error(
          "Actual text is \""
              + msg_invalidFields.getText()
              + "\" and Expected text is \""
              + expectedText
              + "\"");
      return false;
    }
  }

  @Step("Verify password masked")
  public boolean verifyPasswordMasked() {
    System.out.println(
        txt_username.getAttribute("value") + txt_password.getAttribute("value") + "test");
    if (txt_password.getAttribute("type").equals("password")) {
      return true;
    } else {
      Log.error("Type of password input is \"" + txt_password.getAttribute("type") + "\"");
      return false;
    }
  }
}
