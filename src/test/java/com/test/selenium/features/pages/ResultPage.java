package com.test.selenium.features.pages;

import com.test.selenium.features.config.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends PageObject {

  @FindBy(id = "resultStats")
  WebElement resultStats;

  @FindBy(css = "div.r h3")
  WebElement firstResult;

  public ResultPage(WebDriver driver) {
    super(driver);
  }

  public String getResultStats() {
    return resultStats.getText();
  }

  public String getFirstResultTitle() {
    return firstResult.getText();
  }
}
