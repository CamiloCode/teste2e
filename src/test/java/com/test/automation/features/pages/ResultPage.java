package com.test.automation.features.pages;

import com.test.automation.features.config.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage extends PageObject {

  @FindBy(id = "resultStats")
  WebElement resultStats;

  @FindBy(css = "div.r h3")
  WebElement firstResult;

  @FindBy(css = "a[href='https://en.wikipedia.org/wiki/The_Name_of_the_Wind']")
  WebElement firstLink;

  public ResultPage(WebDriver driver) {
    super(driver);
  }

  public String getResultStats() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(resultStats));
    return resultStats.getText();
  }

  public String getFirstResultTitle() {
    return firstResult.getText();
  }

  public void clickOnFirstLink() {
    firstLink.click();
  }
}
