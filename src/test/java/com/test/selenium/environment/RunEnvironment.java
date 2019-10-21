package com.test.selenium.environment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RunEnvironment {

  private WebDriver driver;

  public RunEnvironment() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--window-size=1200x600");
    options.addArguments("--no-sandbox");
    options.addArguments("--start-maximized");
    options.addArguments("--disable-notifications");
    options.addArguments("--disable-gpu");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }

  public WebDriver getDriver() {
    return this.driver;
  }

  public void setDriver(WebDriver driver) {
    this.driver = driver;
  }

}
