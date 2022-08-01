package com.selenium.project.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {
  // Wait Page loaded
  private WebDriver driver;
  private WebDriverWait wait;

  public Helper(WebDriver driver) {
    this.driver = driver;
  }

  public void waitForPageLoaded() {

    // wait for jQuery to loaded
    ExpectedCondition<Boolean> jQueryLoad =
        new ExpectedCondition<Boolean>() {
          @Override
          public Boolean apply(WebDriver driver) {
            try {
              return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active")
                  == 0);
            } catch (Exception e) {
              return true;
            }
          }
        };

    // wait for Javascript to loaded
    ExpectedCondition<Boolean> jsLoad =
        new ExpectedCondition<Boolean>() {
          @Override
          public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .toString()
                .equals("complete");
          }
        };

    try {
      wait = new WebDriverWait(driver, 30);
      if (wait.until(jQueryLoad)) {
        System.out.println("JqueryLoaded");
      } else {
        System.out.println("Load fail");
      }
      if (wait.until(jsLoad)) {
        System.out.println("JSLoaded");
      } else {
        System.out.println("load JS fail");
      }
    } catch (Throwable error) {
      Assert.fail("Quá thời gian load trang.");
    }
  }
}
