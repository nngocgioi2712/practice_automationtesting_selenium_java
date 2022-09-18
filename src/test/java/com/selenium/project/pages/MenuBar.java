package com.selenium.project.pages;

import com.selenium.project.pages.myaccount.LoginPage;
import com.selenium.project.pages.shop.ShopPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuBar {
  private final WebDriver driver;
  @FindBy (partialLinkText = "My Account")
  private WebElement mnu_myAccount;
  @FindBy(partialLinkText = "Shop")
  private WebElement mnu_shop;

  public MenuBar(WebDriver driver) {
    this.driver = driver;
    if (!driver.getTitle().contains("Automation Practice Site")) {
      throw new IllegalArgumentException(
          String.format("This is not Automation Practice Site"));
    } else {
      driver.switchTo().frame("aswift_9");
      Advertisement.closeAd(driver);
      driver.switchTo().parentFrame();
      PageFactory.initElements(driver, this);
    }
  }

  public LoginPage OpenMyAccountPage() {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(mnu_myAccount));
    mnu_myAccount.click();
    Advertisement.closeAd(driver);
    return new LoginPage(driver);
  }
  public ShopPage openShopMenu() {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(mnu_shop));
    mnu_shop.click();
    Advertisement.closeAd(driver);
    return new ShopPage(driver);
  }
}
