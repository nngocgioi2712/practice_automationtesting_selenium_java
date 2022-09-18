package com.selenium.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Advertisement {
    private static  String urlAd = "https://practice.automationtesting.in/#google_vignette";
    @FindBy(css = "#dismiss-button")
    private static WebElement btn_closeAd;

    public static void closeAd(WebDriver driver){
        if(driver.getCurrentUrl().equals(urlAd)){
            driver.switchTo().frame("aswift_9");
            btn_closeAd.click();
            driver.switchTo().parentFrame();
        } else {}
    }
}
