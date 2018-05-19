package functional;

import static org.testng.AssertJUnit.assertEquals;

import Utils.TakeScreenshot;
import Utils.TestCaseHelper;
import Utils.TestWebDriver;

import org.page.objects.ClientDetailsPage;
import org.page.objects.CreateIndividualClientPage;
import org.page.objects.DashboardPage;
import org.page.objects.LoginPage;
import org.page.objects.PageObjectFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.util.Date;

@Listeners(TakeScreenshot.class)

public class IndividualClientCreation extends TestCaseHelper {

  @BeforeClass(groups = {"create_client"})
  public void setup() {
    super.setup();
  }

  @Test(groups = {"login", "create_client"})
  public void login() {
    LoginPage loginPage = PageObjectFactory.getLoginPage(testWebDriver);
    loginPage.openApplication();
    DashboardPage dashboard = loginPage.login();
    assertTrue(dashboard.isPageDisplayed());
  }
  
  @Test(groups = {"create_client"})
  public void verifyIndividualAcountCreation() {
	TestWebDriver.loadPropertiesFile("individualClientTestData.txt");
	DashboardPage dashboard = PageObjectFactory.getDashboard(testWebDriver);
	CreateIndividualClientPage createIndividualClientPage =dashboard.createClient();
	
	assertEquals(createIndividualClientPage.getPageTitle(),"Create Client");
	String clientId = IndividualClientDetails.CLIENT_ID + (new Date()).getTime();
	ClientDetailsPage clientDetailsPage = createIndividualClientPage.createClient(clientId, IndividualClientDetails.GENDER, IndividualClientDetails.FIRST_NAME, 
	   IndividualClientDetails.LAST_NAME, IndividualClientDetails.DATE_OF_BIRTH, IndividualClientDetails.STREET_ADDRESS, 
	   IndividualClientDetails.CITY, IndividualClientDetails.COUNTRY, IndividualClientDetails.POSTAL_ZIP_CODE, IndividualClientDetails.BUSSINESS_PHONE,
	   IndividualClientDetails.BRANCH, IndividualClientDetails.CREATION_DATE);
	assertEquals(clientDetailsPage.getPageTitle(), IndividualClientDetails.FIRST_NAME + " " + IndividualClientDetails.LAST_NAME);
	assertEquals(clientDetailsPage.getClientstatus(), "Pending Approval");
  }

  @AfterClass(groups = {"create_client"})
  public void tearDown() {
//	  testWebDriver.quitDriver();
  }
}