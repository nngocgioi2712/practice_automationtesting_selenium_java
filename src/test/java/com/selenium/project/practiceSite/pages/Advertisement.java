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
      By.xpath(
          "(//ins[@class=\"adsbygoogle adsbygoogle-noablate\" and @data-ad-status=\"filled\" and @aria-hidden=\"false\"])//iframe");
  private static By btn_closeAd = By.xpath("//*[@id='dismiss-button']");

  @Step("Close ads")
  public static void closeAd(WebDriver driver) {
    if (driver.getCurrentUrl().contains(urlAd)) {
      int size = driver.findElements(ins_ads).size();
      System.out.println(size);
      WebElement ad_frame = driver.findElement(ins_ads);
     // WebElement ad_frame = e_ins.findElement(By.tagName("iframe"));
      driver.switchTo().frame(ad_frame);
      System.out.println(driver.findElements(btn_closeAd).size());
      driver.findElement(btn_closeAd).click();
      Log.info("Ad was closed");
      driver.switchTo().parentFrame();
    }
    else {
    }
  }
}
