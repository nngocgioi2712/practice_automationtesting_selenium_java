package com.selenium.project.practiceSite.pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterComponent {
  private WebDriver driver;

  @FindBy(xpath = "//button[text() = 'Filter']/following-sibling::div/span[1]")
  private WebElement sp_minPrice;

  @FindBy(xpath = "//button[text() = 'Filter']/following-sibling::div/span[2]")
  private WebElement sp_maxPrice;

  @FindBy(xpath = "//div[@class = \"price_slider_wrapper\"]/div/span[2]")
  private WebElement sp_noteMax;

  @FindBy(xpath = "//button[text() = 'Filter']")
  private WebElement btn_filter;

  public FilterComponent(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void filterPrice(int xOffset) {
    Actions action = new Actions(driver);
    action.dragAndDropBy(sp_noteMax, xOffset, 0).build().perform();
    btn_filter.click();
  }

  public boolean verifyPriceInFilter(int minPrice, int maxPrice) {
    if (Integer.parseInt(sp_minPrice.getText().substring(1)) == minPrice
        && Integer.parseInt(sp_maxPrice.getText().substring(1)) == maxPrice) {
      return true;
    } else {
      return false;
    }
  }
}
