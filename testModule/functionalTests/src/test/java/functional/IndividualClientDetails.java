package functional;
import Utils.TestWebDriver;

public final class IndividualClientDetails {

  public static final String CLIENT_ID = TestWebDriver.getProperty("CLIENT_ID");
  public static final String GENDER = TestWebDriver.getProperty("GENDER");
  public static final String FIRST_NAME = TestWebDriver.getProperty("FIRST_NAME");
  public static final String LAST_NAME = TestWebDriver.getProperty("LAST_NAME");
  public static final String DATE_OF_BIRTH = TestWebDriver.getProperty("DATE_OF_BIRTH");
  public static final String STREET_ADDRESS = TestWebDriver.getProperty("STREET_ADDRESS");
  public static final String CITY = TestWebDriver.getProperty("CITY");
  public static final String COUNTRY = TestWebDriver.getProperty("COUNTRY");
  public static final String POSTAL_ZIP_CODE = TestWebDriver.getProperty("POSTAL_ZIP_CODE");
  public static final String BUSSINESS_PHONE = TestWebDriver.getProperty("BUSSINESS_PHONE");
  public static final String BRANCH = TestWebDriver.getProperty("BRANCH");
  public static final String CREATION_DATE = TestWebDriver.getProperty("CREATION_DATE");
  

  private IndividualClientDetails() {
  }

}