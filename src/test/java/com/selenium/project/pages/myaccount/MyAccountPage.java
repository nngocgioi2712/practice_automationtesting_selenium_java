package com.selenium.project.pages.myaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private WebDriver driver;
    private By mnu_myAccount = By.partialLinkText("My Account");

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
    }
    public void OpenMyAccountPage(){
        WebElement elm = driver.findElement(mnu_myAccount);
        elm.click();
    }
}
