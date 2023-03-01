package com.selenium.project.demoSite.testcases;

import com.selenium.common.SetupDriver;
import com.selenium.helpers.PropertiesHelper;
import com.selenium.project.demoSite.pages.MenuBar;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends SetupDriver {

    @BeforeMethod
    public void openWebDemo() {
        driver.get(PropertiesHelper.getValue("DEMO_URL"));
    }
}
