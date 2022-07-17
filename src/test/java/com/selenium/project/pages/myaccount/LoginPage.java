package com.selenium.project.pages.myaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By by_username = By.cssSelector("#username");
    private By by_password = By.cssSelector("#password");
    private By by_login = By.xpath("//input[@name = 'login']");
    private By txt_hello = By.xpath("//div[@class = 'page-content entry-content']//p");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String username, String password){
        WebElement in_username = driver.findElement(by_username);
        WebElement in_password = driver.findElement(by_password);
        WebElement btn_login = driver.findElement(by_login);
        in_username.sendKeys(username);
        in_password.sendKeys(password);
        btn_login.click();

        System.out.println(driver.findElement(txt_hello).getText());
    }

}
