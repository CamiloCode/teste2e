package com.test.selenium.tests;

import static org.junit.Assert.assertEquals;

import com.test.selenium.environment.EnvironmentManager;
import com.test.selenium.environment.RunEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoTest {

  private static ChromeDriverService service;
  private WebDriver driver;

  @BeforeClass
  public static void createAndStartService() throws IOException {
    service = new ChromeDriverService.Builder()
        .usingDriverExecutable(new File("C:/chromedriver.exe"))
        .usingAnyFreePort()
        .build();
    service.start();
  }

  @AfterClass
  public static void stopService() {
    service.stop();
  }

  @Before
  public void createDriver() {
    driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }

  @After
  public void quitDriver() {
    driver.quit();
  }

  @Test
  public void testGoogleSearch() {
    driver.get("http://www.google.com");
    // rest of the test...
  }

}
