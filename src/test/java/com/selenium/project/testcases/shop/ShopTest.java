package com.selenium.project.testcases.shop;

import com.selenium.project.common.SetupDriver;
import com.selenium.project.pages.MenuBar;
import com.selenium.project.pages.shop.CategoriesComponent;
import com.selenium.project.pages.shop.FilterComponent;
import com.selenium.project.pages.shop.PostList;
import com.selenium.project.pages.shop.SelectBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShopTest extends SetupDriver {
  private MenuBar menuBar;
  private FilterComponent filterComponent;
  private CategoriesComponent categoriesComponent;
  private SelectBox selectBox;
  private PostList postList;
  private static final Logger log = LogManager.getLogger(ShopTest.class.getName());

  @BeforeMethod
  public void beforeShopTest(){
    menuBar = new MenuBar(driver);
  }
  @Test
  public void filterByPrice() throws Exception {
    int minPrice = 150;
    int maxPrice = 451;
    int xOffset = -28;
    log.info("***Filter by Price Test***");
    menuBar.openShopMenu();
    filterComponent = new FilterComponent(driver);
    postList = new PostList(driver);
    filterComponent.filterPrice(xOffset);
    filterComponent.verifyPriceInFilter(minPrice, maxPrice);
    Assert.assertTrue(postList.verifyPriceOfProduct(minPrice, maxPrice));
  }

  @Test
  public void testProductCategories() throws Exception {
    String menu = "JavaScript";
    String[] expectedResultText = {"JavaScript", "JS"};
    menuBar.openShopMenu();
    categoriesComponent = new CategoriesComponent(driver);
    postList = new PostList(driver);
    categoriesComponent.clickProductCategories(menu);
    Assert.assertTrue(postList.verifyNavigation(menu));
    Assert.assertTrue(postList.verifyNameOfProduct(expectedResultText));
  }

  @Test
  public void sortByPopularity() throws Exception {
  }

  @Test
  public void sortByAverageRatings() throws Exception {
  }

  @Test
  public void sortByNewnessRatings() throws Exception {
  }

  @Test
  public void sortByLowToHigh() {
    menuBar.openShopMenu();
    selectBox = new SelectBox(driver);
    postList = new PostList(driver);
    selectBox.clickSortPriceLowToHigh();
    postList.verifySortPriceLowToHigh();
  }

  @Test
  public void sortByHighToLow() throws Exception {
    menuBar.openShopMenu();
    selectBox = new SelectBox(driver);
    postList = new PostList(driver);
    selectBox.clickSortPriceHighToLow();
    postList.verifySortPriceHighToLow();
  }
}
