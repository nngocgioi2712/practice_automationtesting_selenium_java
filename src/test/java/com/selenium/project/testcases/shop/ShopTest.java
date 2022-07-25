package com.selenium.project.testcases.shop;

import com.selenium.project.common.SetupDriver;
import com.selenium.project.pages.shop.ShopPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopTest extends SetupDriver {
    private  ShopPage shopPage;
    private static final Logger log = LogManager.getLogger(ShopTest.class.getName());
    @Test
    public void filterByPrice() throws Exception{
        int minPrice = 150;
        int maxPrice = 451;
        int xOffset = -28;
        log.info("***Filter by Price Test***");
        shopPage = new ShopPage(driver);
        Thread.sleep(3000);
        shopPage.openShopMenu();
        Thread.sleep(3000);
        shopPage.filterPrice(xOffset);
        Assert.assertTrue(shopPage.verifyBookList(minPrice, maxPrice));
    }
    @Test
    public void testProductCategories() throws Exception{
        String menu = "JavaScript";
        String[] expectedResultText = {"JavaScript", "JS"};
        shopPage = new ShopPage(driver);
        Thread.sleep(3000);
        shopPage.openShopMenu();
        Thread.sleep(3000);
        shopPage.clickProductCategory(menu);
        Assert.assertTrue(shopPage.verifyNavigation(menu));
        Assert.assertTrue(shopPage.verifyProductList(expectedResultText));
    }
    @Test
    public void sortByPopularity() throws Exception{
        shopPage = new ShopPage(driver);
        Thread.sleep(3000);
        shopPage.openShopMenu();
        Thread.sleep(3000);
    }
    @Test
    public void sortByAverageRatings() throws Exception{
        shopPage = new ShopPage(driver);
        Thread.sleep(3000);
        shopPage.openShopMenu();
        Thread.sleep(3000);
    }
    @Test
    public void sortByNewnessRatings() throws Exception{
        shopPage = new ShopPage(driver);
        Thread.sleep(3000);
        shopPage.openShopMenu();
        Thread.sleep(3000);
    }
    @Test
    public void sortByLowToHigh() throws Exception{
        shopPage = new ShopPage(driver);
        Thread.sleep(3000);
        shopPage.openShopMenu();
        Thread.sleep(3000);
        shopPage.clickSortPriceLowToHigh();
        shopPage.verifySortPriceLowToHigh();
    }
    @Test
    public void sortByHighToLow() throws Exception{
        shopPage = new ShopPage(driver);
        Thread.sleep(3000);
        shopPage.openShopMenu();
        Thread.sleep(3000);
        shopPage.clickSortPriceHighToLow();
        shopPage.verifySortPriceHighToLow();
    }
}
