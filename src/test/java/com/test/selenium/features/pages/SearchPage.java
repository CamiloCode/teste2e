package com.test.selenium.features.pages;

import com.test.selenium.features.config.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject {

  @FindBy(css = "input[name='q']")
  WebElement searchBar;

  @FindBy(css = "input[name='btnK']")
  WebElement searchButton;

  public SearchPage(WebDriver driver) {
    super(driver);
  }

  public void typeSearch(String text) {
    searchBar.sendKeys(text);
  }

  public void clickSearch() {
    searchButton.click();
  }

}
