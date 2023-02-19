package com.selenium.main.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebUI {
    private WebDriver driver;
    private static WebDriverWait wait;
    public WebUI(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public static void setText(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }
    public static String getText(WebElement element){
        return element.getText();
    }
    public static void clickElement(WebElement element){
        element.click();
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
            //Assert.fail("Quá thời gian load trang.");
        }
    }
}
