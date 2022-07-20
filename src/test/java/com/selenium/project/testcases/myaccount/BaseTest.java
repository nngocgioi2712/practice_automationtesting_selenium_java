package com.selenium.project.testcases.myaccount;

import com.selenium.project.common.SetupDriver;
import com.selenium.project.pages.myaccount.LoginPage;
import com.selenium.project.pages.myaccount.MyAccountPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends SetupDriver {
    private MyAccountPage myAccountPage;
    @BeforeMethod
    public void beforeBaseTest() throws Exception{
        myAccountPage = new MyAccountPage(driver);
        Thread.sleep(3000);
        myAccountPage.OpenMyAccountPage();
    }
}
