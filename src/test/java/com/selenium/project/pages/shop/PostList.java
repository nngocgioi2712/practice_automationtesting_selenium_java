package com.selenium.project.pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PostList {
    private WebDriver driver;
    @FindBy(xpath = "//div[@id = \"content\"]/nav")
    private WebElement nav;
    @FindBy(
            xpath =
                    "//ul[@class = 'products masonry-done']/li//span[@class = 'woocommerce-Price-amount amount']")
    private List<WebElement> priceList;
    @FindBy(xpath = "//h3")
    private List<WebElement> txt_productName;

    public PostList(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean verifyNavigation(String menu) {
        return nav.getText().equalsIgnoreCase("Home / " + menu);
    }

    public boolean verifyNameOfProduct(String[] expectedResultText) {
        for (int i = 0; i < txt_productName.size(); i++) {
            boolean check = false;
            for (int j = 0; j < expectedResultText.length; j++) {
                txt_productName.get(i).getText().contains(expectedResultText[j]);
                check = true;
                continue;
            }
            if (!check) return false;
        }
        return true;
    }
    public boolean verifyPriceOfProduct(int minPrice, int maxPrice) {
        for (int i = 0; i < priceList.size(); i++) {
            if (Integer.parseInt(priceList.get(i).getText().substring(1, 3)) < minPrice
                    && Integer.parseInt(priceList.get(i).getText().substring(1, 3)) > maxPrice)
                return false;
        }
        return true;
    }

    public boolean verifySortPriceLowToHigh() {
        ArrayList<Integer> price_sorted = new ArrayList<>();
        for (int i = 0; i < priceList.size(); i++) {
            price_sorted.add(Integer.parseInt(priceList.get(i).getText().substring(1, 3)));
        }
        price_sorted.sort(Comparator.naturalOrder());
        for (int i = 0; i < priceList.size(); i++) {
            if (Integer.parseInt(priceList.get(i).getText().substring(1, 3)) != price_sorted.get(i))
                return false;
        }
        return true;
    }

    public boolean verifySortPriceHighToLow() {
        ArrayList<Integer> price_sorted = new ArrayList<>();
        for (int i = 0; i < priceList.size(); i++) {
            price_sorted.add(Integer.parseInt(priceList.get(i).getText().substring(1, 3)));
        }
        price_sorted.sort(Comparator.reverseOrder());
        for (int i = 0; i < priceList.size(); i++) {
            if (Integer.parseInt(priceList.get(i).getText().substring(1, 3)) != price_sorted.get(i))
                return false;
        }
        return true;
    }


}
