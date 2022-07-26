package com.selenium.project.testcases.shop;

import com.selenium.project.common.SetupDriver;
import com.selenium.project.pages.shop.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopTest extends SetupDriver {
  private ShopPage shopPage;

  @Test
  public void filterByPrice() throws Exception {
    int minPrice = 150;
    int maxPrice = 451;
    int xOffset = -28;
    shopPage = new ShopPage(driver);
    Thread.sleep(3000);
    shopPage.openShopMenu();
    Thread.sleep(3000);
    shopPage.filterPrice(xOffset);
    Assert.assertTrue(shopPage.verifyBookList(minPrice, maxPrice));
  }
}
