package com.selenium.project.practiceSite.pages;

import com.selenium.utils.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Advertisement {
  private static String urlAd = "https://practice.automationtesting.in/#google_vignette";
  private static By oj_btn_closed = By.id("dismiss-button");
  private static By ad_iframe = By.id("ad_iframe");

  @Step("Close ads")
  public static void closeAd(WebDriver driver) {

    if (driver.getCurrentUrl().equals(urlAd)) {
      if (find_ad_frame("aswift_7", driver)) {
        Log.info("Ad was closed");
      } else if (find_ad_frame("aswift_8", driver)) {
        Log.info("Ad was closed");
      } else Log.info("Close ads failed");

    } else {
    }
  }

  public static boolean find_ad_frame(String iframe, WebDriver driver) {
    driver.switchTo().frame(iframe);
    if (driver.findElements(oj_btn_closed).size() > 0) {
      driver.findElement(oj_btn_closed).click();
      driver.switchTo().parentFrame();
      return true;
    } else if (driver.findElements(ad_iframe).size() > 0) {
      driver.switchTo().frame("ad_iframe");
      driver.findElement(oj_btn_closed).click();
      driver.switchTo().parentFrame();
      driver.switchTo().parentFrame();
      return true;
    } else {
      driver.switchTo().parentFrame();
      return false;
    }
  }
}
