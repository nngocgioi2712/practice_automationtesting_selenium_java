package com.selenium.project.pages.myaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyAccountPage {
  private WebDriver driver;
  //    @FindBy(partialLinkText = "My Account")
  //    private WebElement mnu_myAccount;
  private By mnu_Account = By.partialLinkText("My Account");

  public MyAccountPage(WebDriver _driver) {
    driver = _driver;
    PageFactory.initElements(_driver, this);
  }

  public void OpenMyAccountPage() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(mnu_Account));
    driver.findElement(mnu_Account).click();
  }
}
