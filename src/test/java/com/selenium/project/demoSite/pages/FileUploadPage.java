package com.selenium.project.demoSite.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadPage {
  private WebDriver driver;
  private WebDriverWait wait;
  private Robot rb;

  @FindBy(xpath = "//label[text() ='Select File']/following-sibling::div//input[@type='file']")
  private WebElement in_uploadFile;

  @FindBy(
      xpath =
          "//label[text() ='Select File']/following-sibling::div/div[contains(@class, 'btn-file')]")
  private WebElement btn_upload;

  @FindBy(xpath = "//div[@class='file-footer-caption']")
  private WebElement txt_fileName;

  public FileUploadPage(WebDriver driver, WebDriverWait wait) {
    this.wait = wait;
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void uploadFileUseSendKey(String filePath) {
    in_uploadFile.sendKeys(filePath);
  }

  public void uploadFileUseRobotClass(String filePath) throws InterruptedException {
    wait.until(ExpectedConditions.elementToBeClickable(btn_upload));
    btn_upload.click();
    try {
      rb = new Robot();
    } catch (AWTException e) {
      e.printStackTrace();
    }
    StringSelection str = new StringSelection(filePath);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

    Thread.sleep(1000);
    rb.keyPress(KeyEvent.VK_CONTROL);
    rb.keyPress(KeyEvent.VK_V);

    rb.keyRelease(KeyEvent.VK_CONTROL);
    rb.keyRelease(KeyEvent.VK_V);

    rb.keyPress(KeyEvent.VK_ENTER);
    rb.keyRelease(KeyEvent.VK_ENTER);
  }

  public boolean verifyFileUploadSuccess(String fileName) {
    wait.until(
        ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[@class='file-footer-caption']")));
    return txt_fileName.getAttribute("title").equals(fileName);
  }
}
