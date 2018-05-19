package stepDefinitions;

import Utils.TestCaseHelper;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.TakesScreenshot;
import org.page.objects.DashboardPage;
import org.page.objects.LoginPage;
import org.page.objects.PageObjectFactory;
import org.page.objects.TransactionsPage;
import static org.openqa.selenium.OutputType.BYTES;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllTransactionsReportDownloadSteps extends TestCaseHelper {
	public TransactionsPage transactionsPage;

  @Before
  public void setup() {
    super.setup();
  }

  @Given("^User is logged in$")
  public void user_is_logged_in() {
	  LoginPage loginPage = PageObjectFactory.getLoginPage(testWebDriver);
	    loginPage.openApplication();
	    DashboardPage dashboard = loginPage.login();
	    assertTrue(dashboard.isPageDisplayed());
  }

  @When("^goes to All Transaction reports$")
  public void goes_to_All_Transaction_reports() {
      DashboardPage dashboard = PageObjectFactory.getDashboard(testWebDriver);
      transactionsPage = dashboard.openTransactions();
  }

  @When("^filter reports by \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
  public void filter_reports_by_and(String startDate, String endDate, String branch) {
	  transactionsPage.filterReports(startDate, endDate, branch);
  }

  @Then("^user should see \"([^\"]*)\" rows in filter results$")
  public void user_should_see_rows_in_filter_results(String rowCount) {
	  assertEquals(transactionsPage.getRowCount(), Integer.parseInt(rowCount));
  }
  
  @Then("^user should see \"([^\"]*)\" in filter results$")
  public void user_should_see_in_filter_results(String count) {
	  assertEquals(transactionsPage.getResultCount(),Integer.parseInt(count));
  }

  @When("^user exports excel$")
  public void user_exports_excel() {
      transactionsPage.exportReports();
      testWebDriver.sleep(5000);
  }

  @Then("^file should download$")
  public void file_should_download() {
      assertTrue(testWebDriver.isFileDownloaded());
  }

  @Then("^there should be \"([^\"]*)\" transactions in report$")
  public void there_should_be_transactions_in_report(String count) {
	  try {
		assertEquals(testWebDriver.getRowsCountInFile(),Integer.parseInt(count));
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @After
  public void embedScreenshotOnFail(Scenario s) {
      testWebDriver.quitDriver();
  }
  
}
