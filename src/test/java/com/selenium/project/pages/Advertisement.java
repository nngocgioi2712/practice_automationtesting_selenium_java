package com.selenium.project.pages;

import com.selenium.project.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Advertisement {
    private static  String urlAd = "https://practice.automationtesting.in/#google_vignette";
    @FindBy(css = "#dismiss-button")
    private static WebElement btn_closeAd;

    @FindBy(css = ".dismiss-button")
    private  static WebElement btn_close;
    public static void closeAd(WebDriver driver){
        if(driver.getCurrentUrl().equals(urlAd)){
            driver.switchTo().frame("aswift_7");
            if(btn_closeAd != null){
                btn_closeAd.click();
            } else if(btn_close != null) {
                btn_close.click();
            }
            Log.info("Ad was closed");
            driver.switchTo().parentFrame();

        } else {}
    }
}
