package com.selenium.project.pages.shop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShopPage {
  private WebDriver driver;









  private static final Logger log = LogManager.getLogger(ShopPage.class.getName());

  public ShopPage(WebDriver _driver) {
    driver = _driver;
    if (!driver.getTitle().contains("Products")) {
      throw new IllegalArgumentException(
          String.format("Page is not Products"));
    }else {
      PageFactory.initElements(driver, this);
    }
  }


}
