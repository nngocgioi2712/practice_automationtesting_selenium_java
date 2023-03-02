package com.selenium.project.practiceSite.pages.myaccount;

import com.selenium.utils.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

  private WebDriver driver;

  @FindBy(css = "#reg_username")
  private WebElement txt_username;

  @FindBy(css = "#reg_password")
  private WebElement txt_password;

  @FindBy(xpath = "//input[@name = \"register\"")
  private WebElement btn_register;

  @FindBy(xpath = "//div[@class = 'page-content entry-content']//p")
  private WebElement lbl_welcome;

  public RegisterPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @Step("Register with username: {0} and passwor: {1}")
  public void register(String username, String password) {
    txt_username.sendKeys(username);
    txt_password.sendKeys(password);
    btn_register.click();
  }

  @Step("Verify login success")
  public boolean verifyLoginSuccess(String expectedText) {
    if (lbl_welcome.getText().equals(expectedText)) {
      return true;
    } else {
      Log.info(
          "ActualText is \""
              + lbl_welcome.getText()
              + "\" and ExpectedText is \""
              + expectedText
              + "\"");
      return false;
    }
  }
}
