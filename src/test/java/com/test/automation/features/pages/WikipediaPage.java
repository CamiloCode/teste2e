package com.test.automation.features.pages;

import com.test.automation.features.config.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikipediaPage extends PageObject {

  @FindBy(css = "#firstHeading i")
  WebElement wikipediaHeader;

  public WikipediaPage(WebDriver driver) {
    super(driver);
  }

  public String getHeaderText() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(wikipediaHeader));
    return wikipediaHeader.getText();
  }

}
