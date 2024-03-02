package com.selenium.project.practiceSite.pages;

import com.selenium.utils.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Advertisement {
  private static String urlAd = "#google_vignette";
  private static By ins_ads =
      By.xpath("//ins[@class='adsbygoogle adsbygoogle-noablate' and @aria-hidden='false']//iframe");
  private static By btn_closeAd = By.xpath("//*[@id = 'dismiss-button']");

  @Step("Close ads")
  public static void closeAd(WebDriver driver) {
    if (driver.getCurrentUrl().contains(urlAd)) {
      WebElement ad_frame = driver.findElement(ins_ads);
      driver.switchTo().frame(ad_frame);
      if (driver.findElements(btn_closeAd).size() == 0) {
        driver.switchTo().frame(0);
      }
      driver.findElement(btn_closeAd).click();
      Log.info("Ad was closed");
      driver.switchTo().defaultContent();
    }
  }
}
