package com.selenium.project.practiceSite.testcases.shop;

import com.selenium.common.SetupDriver;
import com.selenium.helpers.PropertiesHelper;
import com.selenium.project.practiceSite.pages.MenuBar;
import com.selenium.project.practiceSite.pages.shop.CategoriesComponent;
import com.selenium.project.practiceSite.pages.shop.FilterComponent;
import com.selenium.project.practiceSite.pages.shop.PostList;
import com.selenium.project.practiceSite.pages.shop.SelectBox;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShopTest extends SetupDriver {
  private MenuBar menuBar;
  private FilterComponent filterComponent;
  private CategoriesComponent categoriesComponent;
  private SelectBox selectBox;
  private PostList postList;

  @BeforeMethod
  public void beforeShopTest() {
    driver.get(PropertiesHelper.getValue("PRACTICE_URL"));
    menuBar = new MenuBar(driver);
  }

  @Test
  public void filterByPrice() {
    int minPrice = 150;
    int maxPrice = 451;
    int xOffset = -28;
    menuBar.openShopMenu();
    filterComponent = new FilterComponent(driver);
    postList = new PostList(driver);
    filterComponent.filterPrice(xOffset);
    filterComponent.verifyPriceInFilter(minPrice, maxPrice);
    Assert.assertTrue(postList.verifyPriceOfProduct(minPrice, maxPrice));
  }

  @Test
  public void testProductCategories() {
    String menu = "JavaScript";
    String[] expectedResultText = {"JavaScript", "JS"};
    menuBar.openShopMenu();
    categoriesComponent = new CategoriesComponent(driver);
    postList = new PostList(driver);
    categoriesComponent.clickProductCategories(menu);
    Assert.assertTrue(postList.verifyNavigation(menu));
    Assert.assertTrue(postList.verifyNameOfProduct(expectedResultText));
  }

  public void sortByPopularity() {}

  public void sortByAverageRatings() {}

  public void sortByNewnessRatings() {}

  @Test
  public void sortByLowToHigh() {
    menuBar.openShopMenu();
    selectBox = new SelectBox(driver);
    postList = new PostList(driver);
    selectBox.select("price");
    postList.verifySortPriceLowToHigh();
  }

  @Test
  public void sortByHighToLow() {
    menuBar.openShopMenu();
    selectBox = new SelectBox(driver);
    postList = new PostList(driver);
    selectBox.select("price-desc");
    postList.verifySortPriceHighToLow();
  }
}
