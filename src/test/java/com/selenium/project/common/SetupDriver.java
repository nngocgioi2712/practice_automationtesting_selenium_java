package com.selenium.project.common;

import com.selenium.main.helpers.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Locale;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetupDriver {
  protected WebDriver driver;

  public void setDriver() {
    switch (PropertiesHelper.getValue("browser").toLowerCase(Locale.ROOT)) {
      case "chrome":
        driver = initChromeDriver();
        break;
      case "firefox":
        driver = initFireFoxDriver();
        break;
      default:
        System.out.println("Browser " + PropertiesHelper.getValue("browser") + "is invalid. Launching Chrome ...");
        driver = initChromeDriver();
    }
    driver.manage().window().maximize();
    driver.get("http://practice.automationtesting.in/");
  }

  public WebDriver getDriver() {
    return driver;
  }

  public WebDriver initChromeDriver() {
    //WebDriverManager.chromedriver().setup();
    System.setProperty("webdriver.chrome.driver", "./driver_chrome/chromedriver.exe");
    return new ChromeDriver();
  }

  public WebDriver initFireFoxDriver() {
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver();
  }

  @BeforeMethod
  public void setUp(ITestContext context) {
    setDriver();
    context.setAttribute("WebDriver", driver);
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void tearDown() {
    //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    driver.quit();
  }
}
