package com.selenium.project.pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    private WebDriver driver;
    @FindBy(partialLinkText = "Shop")
    private WebElement mnu_shop;
    @FindBy(css = "#min_price")
    private WebElement in_minPrice;
    @FindBy(css = "#max_price")
    private WebElement in_maxPrice;
    @FindBy(xpath = "//div[@class = \"price_slider_wrapper\"]/div/span[2]")
    private WebElement note_max;

    public ShopPage(WebDriver _driver){
        driver = _driver;
        PageFactory.initElements(driver, this);
    }

    public void openShopMenu(){
        mnu_shop.click();
    }
    public void verifyBookList() {
    }

    public void filterPrice(int minPrice, int maxPrice) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(note_max, -29, 0).build().perform();
    }
}
