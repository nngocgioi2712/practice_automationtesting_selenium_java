package com.selenium.project.testcases.myaccount;

import com.selenium.project.common.SetupDriver;
import com.selenium.project.pages.myaccount.LoginPage;
import com.selenium.project.pages.myaccount.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {
    private MyAccountPage myAccountPage;
    private LoginPage loginPage;

    @Test
    public void loginSuccessful(){
        String username = "nng729";
        String password = "Lta@#3499";
        String expectedText = "Hello " + username + " (not " + username + "? Sign out)";
        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }
}
