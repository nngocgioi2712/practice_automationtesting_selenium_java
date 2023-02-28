package com.selenium.project.practiceSite.pages;

import com.selenium.project.practiceSite.pages.myaccount.LoginPage;
import com.selenium.project.practiceSite.pages.shop.ShopPage;

import io.qameta.allure.Step;
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
    PageFactory.initElements(driver, this);
  }

  @Step("Open My Account Page")
  public LoginPage OpenMyAccountPage() {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(mnu_myAccount));
    mnu_myAccount.click();
    Advertisement.closeAd(driver);
    return new LoginPage(driver);
  }

  @Step("Open Shop Page")
  public ShopPage openShopMenu() {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(mnu_shop));
    mnu_shop.click();
    Advertisement.closeAd(driver);
    return new ShopPage(driver);
  }
}
