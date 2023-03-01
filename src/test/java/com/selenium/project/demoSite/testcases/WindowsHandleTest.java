package com.selenium.project.demoSite.testcases;

import com.selenium.common.SetupDriver;
import com.selenium.project.demoSite.pages.MenuBar;
import com.selenium.project.demoSite.pages.WindowsHandlePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowsHandleTest extends BaseTest {

    private MenuBar menuBar;
    private WindowsHandlePage windowsHandlePage;

    @BeforeMethod
    public void openWindowsPage(){
        menuBar = new MenuBar(driver, wait);
        windowsHandlePage = menuBar.openWindowsPage();
    }
    @Test
    public void openNewWindowTabTest(){
        windowsHandlePage.openNewWindowTab();
    }
}
