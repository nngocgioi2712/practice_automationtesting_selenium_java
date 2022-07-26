package com.selenium.project.pages.myaccount;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    @FindBy(css = "#username")
    WebElement in_username;
    @FindBy(css = "#password")
    WebElement in_password;
    @FindBy(xpath = "//input[@name = 'login']")
    WebElement btn_login;
    @FindBy(xpath = "//div[@class = 'page-content entry-content']//p")
    private WebElement txt_hello;
    @FindBy(xpath = "//strong[text() = \"Error:\"]//parent::li")
    private WebElement txt_error;
    @FindBy(xpath = "//strong[text() = \"Error\"]//parent::li")
    private WebElement txt_invalidUsername;

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage(WebDriver _driver){
        driver = _driver;
        PageFactory.initElements(_driver, this);
    }

    public void login(String username, String password){
        log.info("Login with username: " + username + " and password: " + password);
        in_username.sendKeys(username);
        in_password.sendKeys(password);
        btn_login.click();
    }
    public boolean verifySuccessText(String expectedText){
        if(txt_hello.getText().equals(expectedText)) return true;
        else return false;
    }
    public boolean verifyErrorText(String expectedText){
        if(txt_error.getText().equals(expectedText)) return true;
        else return false;
    }
    public boolean verifyInvalidUsernameText(String expectedText){
        if(txt_invalidUsername.getText().equals(expectedText)) return true;
        else return false;
    }


}
