package com.selenium.project.demoSite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandlePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[text() = 'Open New Tabbed Windows ']")
    private WebElement lbl_openNewTab;

    @FindBy(xpath = "//a[text() = 'Open New Seperate Windows']")
    private WebElement lbl_openNewSeperateWindow;

    @FindBy(xpath = "//a[text() = 'Open Seperate Multiple Windows']")
    private WebElement lbl_openSeperateWindow;

    @FindBy(xpath = "//*[contains(text(),'click')]")
    private WebElement btn_click;

    public WindowsHandlePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void openNewWindowTab(){
        lbl_openNewTab.click();
        btn_click.click();
    }
    public void openNewSeperateWindow(){
        lbl_openNewSeperateWindow.click();
        btn_click.click();
    }
    public void openSeperateWindow(){
        lbl_openSeperateWindow.click();
        btn_click.click();
    }
}
