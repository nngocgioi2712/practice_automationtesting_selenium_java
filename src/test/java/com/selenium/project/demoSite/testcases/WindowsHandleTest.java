package com.selenium.project.demoSite.testcases;

import com.selenium.project.demoSite.pages.MenuBar;
import com.selenium.project.demoSite.pages.switchto.WindowsHandlePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsHandleTest extends BaseTest {

  private MenuBar menuBar;
  private WindowsHandlePage windowsHandlePage;

  @BeforeMethod
  public void openWindowsPage() {
    menuBar = new MenuBar(driver, wait);
    windowsHandlePage = menuBar.openWindowsPage();
  }

  @Test
  public void openNewWindowTabTest() {
    String mainWindow = windowsHandlePage.getCurrentWindow();
    windowsHandlePage.openNewWindowTab();
    windowsHandlePage.closeNewWindowAndSwitchWindow();
    windowsHandlePage.verifyIsMainWindow(mainWindow);
  }
  @Test
  public void openNewWindowSeperateTest() {
    String mainWindow = windowsHandlePage.getCurrentWindow();
    windowsHandlePage.openNewSeparateWindow();
    windowsHandlePage.closeNewWindowAndSwitchWindow();
    windowsHandlePage.verifyIsMainWindow(mainWindow);
  }
  @Test
  public void openNewSeperateTest() {
    String mainWindow = windowsHandlePage.getCurrentWindow();
    windowsHandlePage.openSeparateWindow();
    windowsHandlePage.closeNewWindowAndSwitchWindow();
    windowsHandlePage.verifyIsMainWindow(mainWindow);
  }
}
