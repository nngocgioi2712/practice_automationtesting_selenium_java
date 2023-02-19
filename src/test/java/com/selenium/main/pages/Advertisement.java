package com.selenium.main.pages;

import com.selenium.main.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Advertisement {
    private static  String urlAd = "https://practice.automationtesting.in/#google_vignette";
    private static By oj_btn_closed = By.id("dismiss-button");

    public static void closeAd(WebDriver driver){

        if(driver.getCurrentUrl().equals(urlAd)){
            driver.switchTo().frame("aswift_7");
            if(driver.findElement(oj_btn_closed) != null){
                driver.findElement(oj_btn_closed).click();
            } else {
            }
            Log.info("Ad was closed");
            driver.switchTo().parentFrame();

        } else {}
    }
}
