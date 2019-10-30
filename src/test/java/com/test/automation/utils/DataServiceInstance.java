package com.test.automation.utils;

import org.openqa.selenium.chrome.ChromeDriverService;

public class DataServiceInstance {

  private static DataServiceInstance INSTANCE;
  private ChromeDriverService chromeDriverService;

  private DataServiceInstance() {
  }

  public static DataServiceInstance getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new DataServiceInstance();
    }
    return INSTANCE;
  }

  public ChromeDriverService getService() {
    return this.chromeDriverService;
  }

  public void setService(ChromeDriverService chromeDriverService) {
    this.chromeDriverService = chromeDriverService;
  }

}
