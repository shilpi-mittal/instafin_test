package functional;

import Utils.TestCaseHelper;

import org.page.objects.DashboardPage;
import org.page.objects.LoginPage;
//import org.page.objects.HomePage;
import org.page.objects.PageObjectFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BasicLogin extends TestCaseHelper {

  @BeforeMethod(groups = {"testNG"})
  public void setup() {
    super.setup();
  }

  @Test(groups = {"testNG"})
  public void verifyLogin() {
	  
    LoginPage loginPage = PageObjectFactory.getLoginPage(testWebDriver);
    loginPage.openApplication();
    DashboardPage dashboard = loginPage.login();
    assertTrue(dashboard.isPageDisplayed());
  }

  @AfterMethod(groups = {"testNG"})
  public void tearDown() {
	 // testWebDriver.quitDriver();
  }
}