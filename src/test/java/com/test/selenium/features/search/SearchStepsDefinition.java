package com.test.selenium.features.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.test.selenium.features.pages.ResultPage;
import com.test.selenium.features.pages.SearchPage;
import com.test.selenium.features.pages.WikipediaPage;
import com.test.selenium.utils.DataServiceInstance;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchStepsDefinition {

  private WebDriver driver;
  private SearchPage searchPage;
  private ResultPage resultPage;
  private WikipediaPage wikipediaPage;

  @Given("^I’m on the homepage$")
  public void iMOnTheHomepage() throws IOException {
    driver.get("http://www.google.com");
  }

  @When("^I type “(.*)“ into the search field$")
  public void iTypeTheNameOfTheWindIntoTheSearchField(String text) {
    searchPage = new SearchPage(driver);
    searchPage.typeSearch(text);
  }

  @And("^I click the Google Search button$")
  public void iClickInSearchButton() {
    searchPage.clickSearch();
  }

  @Before
  public void createDriver() throws IOException {
    driver = new RemoteWebDriver(DataServiceInstance.getInstance().getService().getUrl(),
        new ChromeOptions());
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }

  @After
  public void quitDriver() {
    driver.quit();
  }

  @Then("^I go to the search results page$")
  public void iGoToTheSearchResultsPage() throws Throwable {
    resultPage = new ResultPage(driver);
    assertThat(resultPage.getResultStats(), containsString("resultados"));
  }

  @And("^the first result is “(.*)”$")
  public void theFirstResultIsTheNameOfTheWind(String text) {
    assertThat(resultPage.getFirstResultTitle(), containsString(text));
  }

  @When("I click on the first result link")
  public void iClickOnTheFirstResultLink() {
    resultPage.clickOnFirstLink();
  }

  @Then("I go to the “The Name of the Wind - Wikipedia” page")
  public void iGoToTheNameOfTheWindPage() {
    wikipediaPage = new WikipediaPage(driver);
    assertThat(wikipediaPage.getHeaderText(), containsString("The Name of the Wind"));
  }

  @And("the suggestions list is displayed")
  public void theSuggestionsListIsDisplayed() {
    searchPage.waitForSuggestions();
  }

  @And("I click on the first suggestion in the list")
  public void iClickOnTheFirstSuggestionInTheList() {
    searchPage.clickOnFirstSuggestion();
  }
}
