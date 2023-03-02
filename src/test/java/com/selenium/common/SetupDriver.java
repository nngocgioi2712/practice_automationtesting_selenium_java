package com.selenium.common;

import com.selenium.helpers.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.Locale;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetupDriver {
  protected WebDriver driver;
  protected WebDriverWait wait;

  @BeforeMethod
  public void setUp(ITestContext context) {
    setDriver();
    wait = new WebDriverWait(driver, 50);
    context.setAttribute("WebDriver", driver);
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }

  public void setDriver() {
    switch (PropertiesHelper.getValue("browser").toLowerCase(Locale.ROOT)) {
      case "chrome":
        driver = initChromeDriver();
        break;
      case "firefox":
        driver = initFireFoxDriver();
        break;
      default:
        System.out.println(
            "Browser " + PropertiesHelper.getValue("browser") + "is invalid. Launching Chrome ...");
        driver = initChromeDriver();
    }
    driver.manage().window().maximize();
  }

  public WebDriver getDriver() {
    return driver;
  }

  public WebDriver initChromeDriver() {
    // WebDriverManager.chromedriver().setup();
    System.setProperty("webdriver.chrome.driver", "./driver_chrome/chromedriver.exe");
    return new ChromeDriver();
  }

  public WebDriver initFireFoxDriver() {
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver();
  }
}
