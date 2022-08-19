package com.selenium.project.common;

import com.selenium.project.helpers.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetupDriver {
  protected static WebDriver driver;

  public void setDriver() {
    switch (PropertiesHelper.getValue("browser").toLowerCase(Locale.ROOT)) {
      case "chrome":
        driver = initChromeDriver();
        break;
      case "firefox":
        driver = initFireFoxDriver();
        break;
      default:
        System.out.println("Browse " + PropertiesHelper.getValue("browser") + "is invalid. Launching Chrome ...");
        driver = initChromeDriver();
    }
    driver.manage().window().maximize();
    driver.get("http://practice.automationtesting.in/");
  }

  public static WebDriver getDriver() {
    return driver;
  }

  public WebDriver initChromeDriver() {
    //WebDriverManager.chromedriver().setup();
    System.setProperty("webdriver.chrome.driver", "D:\\0.GIOINN\\AUTO_selenium\\chromedriver.exe");
    return new ChromeDriver();
  }

  public WebDriver initFireFoxDriver() {
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver();
  }

  @BeforeMethod
  public void setUp() {
    setDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void tearDown() {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    driver.quit();
  }
}
