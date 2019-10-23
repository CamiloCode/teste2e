package com.test.selenium.features.search;

import com.test.selenium.utils.DataServiceInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchStepsDefinition {

  private WebDriver driver;

  @Given("I’m on the homepage")
  public void iMOnTheHomepage() throws IOException {
    driver.get("http://www.google.com");
  }

  @When("I type “The name of the wind” into the search field")
  public void iTypeTheNameOfTheWindIntoTheSearchField() {
  }

  @Before
  public void createDriver() throws IOException {
    driver = new RemoteWebDriver(DataServiceInstance.getInstance().getService().getUrl(), new ChromeOptions());
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }

  @After
  public void quitDriver() {
    driver.quit();
  }

}
