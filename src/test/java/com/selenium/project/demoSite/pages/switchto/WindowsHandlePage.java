package com.selenium.project.demoSite.pages.switchto;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandlePage {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = "//a[text() = 'Open New Tabbed Windows ']//parent::li")
  private WebElement lbl_openNewTab;

  @FindBy(xpath = "//a[text() = 'Open New Seperate Windows']//parent::li")
  private WebElement lbl_openNewSeperateWindow;

  @FindBy(xpath = "//a[text() = 'Open Seperate Multiple Windows']//parent::li")
  private WebElement lbl_openSeperateWindow;

  @FindBy(xpath = "//a[@target = '_blank']/button[contains(text(), 'click')]")
  private WebElement btn_clickOpenTab;

  @FindBy(xpath = "//button[@onclick = 'newwindow()' and text() = 'click']")
  private WebElement btn_clickOpenWindow;

  @FindBy(xpath = "//button[@onclick = 'multiwindow()' and text() = 'click ']")
  private WebElement btn_clickOpenMulti;

  public WindowsHandlePage(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    PageFactory.initElements(driver, this);
  }

  public String getCurrentWindow() {
    return driver.getWindowHandle();
  }

  public boolean verifyIsMainWindow(String mainWindow) {
    return driver.getWindowHandle().equals(mainWindow);
  }

  public void openNewWindowTab() {
    lbl_openNewTab.click();
    btn_clickOpenTab.click();
  }

  public void closeNewWindowAndSwitchWindow() {
    String mainWindow = driver.getWindowHandle();
    Set<String> windows = driver.getWindowHandles();

    for (String window : windows) {
      if (!mainWindow.equals(window)) {
        driver.switchTo().window(window);
        driver.close();
      }
    }
    driver.switchTo().window(mainWindow);
  }

  public void openNewSeparateWindow() {
    lbl_openNewSeperateWindow.click();
    btn_clickOpenWindow.click();
  }

  public void openSeparateWindow() {
    lbl_openSeperateWindow.click();
    btn_clickOpenMulti.click();
  }
}
