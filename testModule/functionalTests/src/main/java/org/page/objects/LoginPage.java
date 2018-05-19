package org.page.objects;

import Utils.TestConstants;
import Utils.TestWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.openqa.selenium.support.How.CLASS_NAME;

public class LoginPage extends Page {
	
  @FindBy(how = CLASS_NAME, using = "login-input")
  private static WebElement username = null;

  @FindBy(how = CLASS_NAME, using = "login-input-password")
  private static WebElement password = null;

  @FindBy(how = CLASS_NAME, using = "custom-login-button")
  private static WebElement loginButton = null;

  public LoginPage(TestWebDriver testWebDriver) {
    super(testWebDriver);
    PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 1), this);
  }

  public void openApplication() {
    testWebDriver.goToBaseUrl();
    testWebDriver.waitForElementToAppear(loginButton);
  }

  public DashboardPage login() {
	testWebDriver.enterInput(username, TestConstants.USER_NAME);
	testWebDriver.enterInput(password, TestConstants.PASSWORD);
	testWebDriver.clickOnElement(loginButton);

	return PageObjectFactory.getDashboard(testWebDriver);
  }
}
