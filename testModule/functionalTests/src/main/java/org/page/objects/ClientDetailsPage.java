package org.page.objects;

import Utils.TestWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.openqa.selenium.support.How.CLASS_NAME;
import static org.openqa.selenium.support.How.CSS;

public class ClientDetailsPage extends Page {
  @FindBy(how = CLASS_NAME, using = "Overview__Title--2j0qr")
  private static WebElement clientName = null;

  @FindBy(how = CLASS_NAME, using = "ClientStatusIndicator__Indicator--1vTdO")
  private static WebElement clientStatus = null;
  
  @FindBy(how = CSS, using = ".Overview__TabsHeader--25i9g > a:nth-child(2)")
  private static WebElement loanAccountTab = null;
  
  @FindBy(how = CLASS_NAME, using = "fixedDataTableRowLayout_body")
  private static WebElement loanAccountRow = null;
  
  
  public ClientDetailsPage(TestWebDriver testWebDriver) {
    super(testWebDriver);
    PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 1), this);
  }

  public String getPageTitle() {
	  return testWebDriver.getText(clientName);
  }
  
  public String getClientstatus() {
	  return clientStatus.getAttribute("title");
  }
}
