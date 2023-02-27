package com.selenium.project.practiceSite.pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectBox {
    private WebDriver driver;

    private static final String DEFAULT_SORTING = "menu_order";
    private static final String SORT_BY_POPULARITY = "popularity";
    private static final String SORT_BY_AVERAGE_RATING = "rating";
    private static final String SORT_BY_PRICE_LOW_TO_HIGH = "price";
    private static final String SORT_BY_PRICE_HIGH_TO_LOW = "price-desc";
    @FindBy(xpath = "//select[@name = 'orderby']")
    private WebElement slc_sort;



    public SelectBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void select(String value) {
        Select drpOrderBy = new Select(slc_sort);
        //slc_sort.click();
        drpOrderBy.selectByValue(value);
    }
}
