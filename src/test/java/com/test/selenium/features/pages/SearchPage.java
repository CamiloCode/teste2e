package com.test.selenium.features.pages;

import com.test.selenium.features.config.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends PageObject {

  @FindBy(css = "input[name='q']")
  WebElement searchBar;

  @FindBy(css = "input[name='btnK']")
  WebElement searchButton;

  @FindBy(css = ".suggestions-inner-container")
  WebElement suggestionList;

  @FindBy(css = ".suggestions-inner-container div[role='option']")
  WebElement suggestionListFirstItem;

  public SearchPage(WebDriver driver) {
    super(driver);
  }

  public void typeSearch(String text) {
    searchBar.sendKeys(text);
  }

  public void clickSearch() {
    searchButton.click();
  }

  public void waitForSuggestions() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(suggestionList));
  }

  public void clickOnFirstSuggestion() {
    suggestionListFirstItem.click();
  }

}
