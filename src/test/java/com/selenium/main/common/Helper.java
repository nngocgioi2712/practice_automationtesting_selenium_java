package com.selenium.main.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
  // Wait Page loaded
  private WebDriver driver;
  private WebDriverWait wait;

  public Helper(WebDriver driver) {
    this.driver = driver;
  }


}
