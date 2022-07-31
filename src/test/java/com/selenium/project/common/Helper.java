package com.selenium.project.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {
  // Wait Page loaded
  private WebDriver driver;
  private WebDriverWait wait;

  public Helper(WebDriver driver) {
    this.driver = driver;
  }


}
