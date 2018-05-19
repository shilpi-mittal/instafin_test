package org.page.objects;

import Utils.TestWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.openqa.selenium.support.How.ID;
import static org.openqa.selenium.support.How.CLASS_NAME;
import static org.openqa.selenium.support.How.XPATH;

public class DashboardPage extends Page {
  @FindBy(how = ID, using = "content")
  private static WebElement dashBoardContent = null;

  @FindBy(how = CLASS_NAME, using = "fa-plus-square-o")
  private static WebElement createClientIcon = null;

  @FindBy(how = XPATH, using = "//a[contains(@class,'submenu')][contains(text(),'Individual')]")
  private static WebElement createIndividualClientLink = null;
  
  @FindBy(how = CLASS_NAME, using = "fa-icon-list-alt")
  private static WebElement reportIcon = null;
  
  @FindBy(how = XPATH, using = "//a[contains(@class,'submenu')][contains(text(),'All Transactions')]")
  private static WebElement allTransactionsLink = null;

  public DashboardPage(TestWebDriver testWebDriver) {
    super(testWebDriver);
    PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 1), this);
  }

  public boolean isPageDisplayed() {
	  return testWebDriver.isDisplayed(dashBoardContent);
  }
  
  public CreateIndividualClientPage createClient() {
	  testWebDriver.clickOnElement(createClientIcon);
	  testWebDriver.clickOnElement(createIndividualClientLink);
	  return PageObjectFactory.getCreateIndividualClientPage(testWebDriver);
  }
  
  public TransactionsPage openTransactions() {
	  testWebDriver.clickOnElement(reportIcon);
	  testWebDriver.clickOnElement(allTransactionsLink);
	  return PageObjectFactory.getTransactionsPage(testWebDriver);
  }
}
