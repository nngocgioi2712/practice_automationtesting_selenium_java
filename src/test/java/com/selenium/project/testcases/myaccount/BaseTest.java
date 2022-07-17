package com.selenium.project.testcases.myaccount;

import com.selenium.project.common.SetupDriver;
import com.selenium.project.pages.myaccount.MyAccountPage;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends SetupDriver {
    private MyAccountPage myAccountPage;
    @BeforeMethod
    public void openMyAccountPage(){
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.OpenMyAccountPage();
    }
}
