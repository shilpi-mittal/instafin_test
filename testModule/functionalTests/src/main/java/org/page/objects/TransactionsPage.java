package org.page.objects;

import Utils.TestWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.support.How.CLASS_NAME;
import static org.openqa.selenium.support.How.CSS;

public class TransactionsPage extends Page {
  @FindBy(how = CSS, using = ".container-fluid h1")
  private static WebElement pageTitle = null;

  @FindBy(how = CSS, using = "[data-qa-element-id='startDate'] input")
  private static WebElement startDateInput = null;
  
  @FindBy(how = CSS, using = "[data-qa-element-id='endDate'] input")
  private static WebElement endDateInput = null;
  
  @FindBy(how = CSS, using = "[data-qa-element-id='organisationStructure.branch'] .Select-input input")
  private static WebElement branchInput = null;
  
  @FindBy(how = CSS, using = "form .btn-primary")
  private static WebElement filterButton = null;
  
  @FindBy(how = CSS, using = ".allTransactions__exportButtons--3l3Sp .btn-primary")
  private static WebElement exportButton = null;
  
  @FindBy(how = CLASS_NAME, using = "InstafinTable__segment--1IRqp")
  private static WebElement table = null;
  
  @FindBy(how = CSS, using = ".Pagination__buttonsContainer--3FIfL ~div")
  private static WebElement resultCount = null;
  
  public TransactionsPage(TestWebDriver testWebDriver) {
    super(testWebDriver);
    PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 1), this);
  }

  public String getPageTitle() {
	  return testWebDriver.getText(pageTitle);
  }
  
  public void filterReports(String startDate, String endDate, String branch) {
	  testWebDriver.enterInput(startDateInput, startDate);
	  testWebDriver.enterInput(endDateInput, endDate);
	  testWebDriver.enterInput(branchInput, branch);
	  branchInput.sendKeys(Keys.ENTER);
	  testWebDriver.clickOnElement(filterButton);
//	  testWebDriver.waitForElementToAppear(table);
  }
  
  public int getRowCount() {
	  try {
	  testWebDriver.waitForElementToAppear(table);
	  return testWebDriver.findElements(By.cssSelector(".fixedDataTableLayout_rowsContainer div .fixedDataTableRowLayout_rowWrapper")).size();
	  }
	  catch(Exception TimeoutException) {
		  return 0;
	  }
  }
  
  public void exportReports() {
	  testWebDriver.clickOnElement(exportButton);
  }
  
  public int getResultCount() {
	  try {
	  String str = testWebDriver.getText(resultCount);
	  return Integer.parseInt(str.substring(str.lastIndexOf("of ")+3, str.lastIndexOf(" ent")));
	  }
	  catch(Exception TimeoutException) {
		  return 0;
	  }
  }
}
