package com.selenium.project.testcases.myaccount;

import com.selenium.project.common.Helper;
import com.selenium.project.common.SetupDriver;
import com.selenium.project.pages.myaccount.LoginPage;
import com.selenium.project.pages.myaccount.MyAccountPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends SetupDriver {
    private MyAccountPage myAccountPage;
    private Helper helper;
    @BeforeMethod
    public void beforeBaseTest() throws Exception{
        helper = new Helper(driver);
        myAccountPage = new MyAccountPage(driver);
        helper.waitForPageLoaded();
        myAccountPage.OpenMyAccountPage();
    }
}
