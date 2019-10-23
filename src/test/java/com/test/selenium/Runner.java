package com.test.selenium;

import com.test.selenium.utils.DataServiceInstance;
import com.test.selenium.utils.PropertiesReader;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import java.io.File;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriverService;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, features = {
    "src/test/resources/features"})
public class Runner {

  private static ChromeDriverService service;

  @BeforeClass
  public static void createAndStartService() throws IOException {
    PropertiesReader propertiesReader = new PropertiesReader();
    service = new ChromeDriverService.Builder()
        .usingDriverExecutable(
            new File(propertiesReader.getProperties().getProperty("webdriver.chrome")).getAbsoluteFile())
        .usingAnyFreePort()
        .build();
    DataServiceInstance.getInstance().setService(service);
    service.start();
  }

  @AfterClass
  public static void stopService() {
    service.stop();
  }
}
