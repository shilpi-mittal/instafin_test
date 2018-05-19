package org.page.objects;

import Utils.TestWebDriver;

public class PageObjectFactory {
  private static Page instanceOfPage;
  private static LoginPage instanceOfLoginPage;
  private static DashboardPage instanceOfDashboard;
  private static CreateIndividualClientPage instanceOfCreateIndividualClientPage;
  private static ClientDetailsPage instanceOfClientDetailsPage;
  private static TransactionsPage instanceOfTransactionsPage;

  public static Page getPage(TestWebDriver testWebDriver) {
    if(instanceOfPage == null) {
      instanceOfPage = new Page(testWebDriver);
    }
    return instanceOfPage;
  }

  public static LoginPage getLoginPage(TestWebDriver testWebDriver) {
    if(instanceOfLoginPage == null) {
      instanceOfLoginPage = new LoginPage(testWebDriver);
    }
    return instanceOfLoginPage;
  }
  
  public static CreateIndividualClientPage getCreateIndividualClientPage(TestWebDriver testWebDriver) {
	  if(instanceOfCreateIndividualClientPage == null) {
		  instanceOfCreateIndividualClientPage = new CreateIndividualClientPage(testWebDriver);
	  }
	  return instanceOfCreateIndividualClientPage;
  }
  
  public static DashboardPage getDashboard(TestWebDriver testWebDriver) {
	  if(instanceOfDashboard == null) {
		  instanceOfDashboard = new DashboardPage(testWebDriver);
	    }
	    return instanceOfDashboard;
  }
  
  public static ClientDetailsPage getClientDetailsPage(TestWebDriver testWebDriver) {
	  if(instanceOfClientDetailsPage == null) {
		  instanceOfClientDetailsPage = new ClientDetailsPage(testWebDriver);
	  }
	  return instanceOfClientDetailsPage;
  }
  
  public static TransactionsPage getTransactionsPage(TestWebDriver testWebDriver) {
	  if(instanceOfTransactionsPage == null) {
		  instanceOfTransactionsPage = new TransactionsPage(testWebDriver);
	  }
	  return instanceOfTransactionsPage;
  }
}
