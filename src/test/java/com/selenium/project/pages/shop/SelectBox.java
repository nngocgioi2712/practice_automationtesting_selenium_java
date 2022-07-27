package com.selenium.project.pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectBox {
    private WebDriver driver;
    @FindBy(xpath = "//select[@name = 'orderby']")
    private WebElement slc_sort;

    @FindBy(xpath = "//select[@name = 'orderby']/option[@value = 'popularity']")
    private WebElement opt_popularity;

    @FindBy(xpath = "//select[@name = 'orderby']/option[@value = 'rating']")
    private WebElement opt_rating;

    @FindBy(xpath = "//select[@name = 'orderby']/option[@value = 'date']")
    private WebElement opt_date;

    @FindBy(xpath = "//select[@name = 'orderby']/option[@value = 'price']")
    private WebElement opt_price;

    @FindBy(xpath = "//select[@name = 'orderby']/option[@value = 'price-desc']")
    private WebElement opt_priceDesc;

    public SelectBox(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickSortPriceLowToHigh() {
        slc_sort.click();
        opt_price.click();
    }

    public void clickSortPriceHighToLow() {
        slc_sort.click();
        opt_priceDesc.click();
    }
}
