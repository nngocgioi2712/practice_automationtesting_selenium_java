package com.selenium.project.pages.shop;

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
    @FindBy(partialLinkText = "Shop")
    private WebElement mnu_shop;
    @FindBy(xpath = "//button[text() = 'Filter']/following-sibling::div/span[1]")
    private WebElement sp_minPrice;
    @FindBy(xpath = "//button[text() = 'Filter']/following-sibling::div/span[2]")
    private WebElement sp_maxPrice;
    @FindBy(xpath = "//div[@class = \"price_slider_wrapper\"]/div/span[2]")
    private WebElement note_max;
    @FindBy(xpath = "//button[text() = 'Filter']")
    private WebElement btn_filter;
    @FindBy(xpath = "//ul[@class = 'products masonry-done']/li//span[@class = 'woocommerce-Price-amount amount']")
    private List<WebElement> priceList;
    public ShopPage(WebDriver _driver){
        driver = _driver;
        PageFactory.initElements(driver, this);
    }

    public void openShopMenu(){
        mnu_shop.click();
    }


    public void filterPrice(int xOffset) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(note_max, xOffset, 0).build().perform();
        btn_filter.click();
    }
    public boolean verifyBookList(int minPrice, int maxPrice) {
        if(Integer.parseInt(sp_minPrice.getText().substring(1)) == minPrice && Integer.parseInt(sp_maxPrice.getText().substring(1)) == maxPrice){
            for(int i = 0; i < priceList.size(); i++){
                if(Integer.parseInt(priceList.get(i).getText().substring(1, 3)) < minPrice
                        && Integer.parseInt(priceList.get(i).getText().substring(1, 3)) > maxPrice
                ) return false;
            }
            return true;
        }else return false;
    }

    public void clickProductCategory(String menu) {
        boolean check_menu = false;
        for(int i = 0; i < mnuList.size(); i++){
            if(mnuList.get(i).getText().equals(menu)){
                mnuList.get(i).click();
                check_menu = true;
                break;
            }
        }
        if(check_menu == false){
            log.error("No menu match");
        }
    }
    public boolean verifyNavigation(String menu){
        return nav.getText().equalsIgnoreCase("Home / " + menu);
    }
    public boolean verifyProductList(String[] expectedResultText) {
        for(int i = 0; i < txt_productName.size(); i++){
            boolean check = false;
            for(int j = 0; j < expectedResultText.length; j++){
                txt_productName.get(i).getText().contains(expectedResultText[j]);
                check = true;
                continue;
            }if (!check)return false;
        }
        return true;
    }

    public boolean verifySortPriceLowToHigh() {
        ArrayList<Integer> price_sorted = new ArrayList<>();
        for(int i = 0; i < priceList.size(); i++){
            price_sorted.add(Integer.parseInt(priceList.get(i).getText().substring(1, 3)));
        }
        price_sorted.sort(Comparator.naturalOrder());
        for(int i = 0; i < priceList.size(); i++){
            if(Integer.parseInt(priceList.get(i).getText().substring(1,3)) != price_sorted.get(i))
             return false;

        }
        return true;
    }

    public boolean verifySortPriceHighToLow() {
        ArrayList<Integer> price_sorted = new ArrayList<>();
        for(int i = 0; i < priceList.size(); i++){
            price_sorted.add(Integer.parseInt(priceList.get(i).getText().substring(1, 3)));
        }
        price_sorted.sort(Comparator.reverseOrder());
        for(int i = 0; i < priceList.size(); i++){
            if(Integer.parseInt(priceList.get(i).getText().substring(1, 3)) != price_sorted.get(i))
                return false;

        }
        return true;
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
