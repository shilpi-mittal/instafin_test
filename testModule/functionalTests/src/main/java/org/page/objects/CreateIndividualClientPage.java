package org.page.objects;

import Utils.TestWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.openqa.selenium.support.How.ID;

import org.openqa.selenium.Keys;

import static org.openqa.selenium.support.How.CLASS_NAME;
import static org.openqa.selenium.support.How.CSS;

public class CreateIndividualClientPage extends Page {
  @FindBy(how = CLASS_NAME, using = "Form__Title--fff9p")
  private static WebElement pageHeader = null;

  @FindBy(how = ID, using = "externalId")
  private static WebElement customerIdInput = null;
  
  @FindBy(how = ID, using = "firstName")
  private static WebElement firstNameInput = null;
  
  @FindBy(how = ID, using = "lastName")
  private static WebElement lastNameInput = null;
  
  @FindBy(how = CSS, using = "[data-qa-element-id=dateOfBirth] .DayPickerInput input")
  private static WebElement dobInput = null;
  
  @FindBy(how = CSS, using = "[data-qa-element-id=gender] .Select-input input")
  private static WebElement genderInput = null;

  @FindBy(how = ID, using = "street1")
  private static WebElement streetInput = null;
  
  @FindBy(how = ID, using = "city")
  private static WebElement cityInput = null;

  @FindBy(how = ID, using = "country")
  private static WebElement countryInput = null;
  
  @FindBy(how = ID, using = "postCode")
  private static WebElement postCodeInput = null;
  
  @FindBy(how = ID, using = "optionalFields.businessPhone")
  private static WebElement phoneInput = null;
  
  @FindBy(how = CSS, using = "[data-qa-element-id='hierarchySelect.branch'] .Select-input input")
  private static WebElement branchInput = null;
  
  @FindBy(how = CSS, using = "[data-qa-element-id=createdOn] .DayPickerInput input")
  private static WebElement createdDateInput = null;
  
  @FindBy(how = CLASS_NAME, using = "btn-success")
  private static WebElement submitButton = null;
  
  
  public CreateIndividualClientPage(TestWebDriver testWebDriver) {
    super(testWebDriver);
    PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 1), this);
  }

  public String getPageTitle() {
	  return testWebDriver.getText(pageHeader);
  }
  
  public ClientDetailsPage createClient(String clientId, String gender, String firstName, String lastName, String dob, 
		  String streetAdress, String city, String country, String postCode, String phone, String branch, String createdDate) {
	  testWebDriver.enterInput(customerIdInput, clientId);
	  testWebDriver.enterInput(genderInput, gender);
	  genderInput.sendKeys(Keys.ENTER);
	  testWebDriver.enterInput(firstNameInput, firstName);
	  testWebDriver.enterInput(lastNameInput, lastName);
	  testWebDriver.enterInput(dobInput, dob);
	  testWebDriver.enterInput(streetInput, streetAdress);
	  testWebDriver.enterInput(cityInput, city);
	  testWebDriver.enterInput(countryInput, country);
	  testWebDriver.enterInput(postCodeInput, postCode);
	  testWebDriver.enterInput(branchInput, branch);
	  branchInput.sendKeys(Keys.ENTER);
	  testWebDriver.enterInput(createdDateInput, createdDate);
	  testWebDriver.enterInput(phoneInput, phone);
	  testWebDriver.clickOnElement(submitButton);
	  return PageObjectFactory.getClientDetailsPage(testWebDriver);
  }
}
