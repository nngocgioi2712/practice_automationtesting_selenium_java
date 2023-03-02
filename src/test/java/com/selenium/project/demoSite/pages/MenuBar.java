package com.selenium.project.demoSite.pages;

import com.selenium.project.practiceSite.pages.Advertisement;
import com.selenium.utils.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuBar {

  private WebDriver driver;
  private WebDriverWait wait;
  private WebUI webUI;
  @FindBy(xpath = "//a[text()='More']")
  private WebElement mnu_more;

  @FindBy(xpath = "//a[text()='File Upload']")
  private WebElement mnu_fileUpload;

  public MenuBar(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    PageFactory.initElements(driver, this);
  }

  public FileUploadPage openFIleUpload() {
    webUI = new WebUI(driver);
    webUI.waitForPageLoaded();
    Advertisement.closeAd(driver);
    wait.until(ExpectedConditions.elementToBeClickable(mnu_more));
    mnu_more.click();
    Advertisement.closeAd(driver);
    mnu_fileUpload.click();
    Advertisement.closeAd(driver);
    return new FileUploadPage(driver, wait);
  }
}
