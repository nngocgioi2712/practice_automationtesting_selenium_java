package com.selenium.project.pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoriesComponent {
    private WebDriver driver;
    @FindBy(xpath = "//h4[text() = 'Product Categories']/following-sibling::ul//a")
    private List<WebElement> categories;

    public CategoriesComponent(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickProductCategories(String menu) {
        boolean check_menu = false;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getText().equals(menu)) {
                categories.get(i).click();
                check_menu = true;
                break;
            }
        }
        if (check_menu == false) {
            //log.error("No menu match");
        }
    }
}
