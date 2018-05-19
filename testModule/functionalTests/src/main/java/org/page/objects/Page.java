package org.page.objects;

import Utils.TestWebDriver;

import java.io.InputStream;

public class Page {
  public TestWebDriver testWebDriver;

  public Page(TestWebDriver testWebDriver) {
    this.testWebDriver = testWebDriver;
  }

  public LoginPage accessLoginPage() {
    testWebDriver.goToBaseUrl();
    return PageObjectFactory.getLoginPage(testWebDriver);
  }

  public String getUrl() {
    return testWebDriver.getCurrentUrl();
  }

//  public String getBaseUrl() {
//    return baseUrl;
//  }
}
