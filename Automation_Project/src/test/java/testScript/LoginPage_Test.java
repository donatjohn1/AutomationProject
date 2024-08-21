package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import constants.Constants;
import pages.Login_Page;
import utilities.ExcelUtilities;

public class LoginPage_Test extends Base {
  @Test(retryAnalyzer = retry.Retry.class)
  @Parameters({"User Name","Password"})
  public void verifyUserIsAbleToLoginUsingValidCredentials(String userNameValue,String passwordValue) throws IOException {
	  //String userNameValue="admin";
	  //String passwordValue="admin";
	  //String userNameValue=ExcelUtilities.getStringData(1,0,"Login_Page");
	  //String passwordValue=ExcelUtilities.getStringData(1,1,"Login_Page");
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  boolean isHomePageIsLoaded=loginPage.isDashboardisLoaded();
	  assertTrue(isHomePageIsLoaded,Constants.ERRORMSGFORLOGIN);
  }
	  @Test(groups= {"Smoke testing"})
	  public void verifyUserIsAbleToLoginUsingValidUsernameInvalidPassword() throws IOException {
		  String userNameValue=ExcelUtilities.getStringData(2,0,"Login_Page");
		  String passwordValue=ExcelUtilities.getStringData(2,1,"Login_Page");
		  Login_Page loginPage=new Login_Page(driver);
		  loginPage.enterUserNameField(userNameValue);
		  loginPage.enterPasswordField(passwordValue);
		  loginPage.clickSubmitButton();
		  boolean isAlertDisplayed=loginPage.isAlertDisplayed();
		  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORLOGIN);
	  }
	  @Test
	  public void verifyUserIsAbleToLoginUsingInvalidUsernameValidPassword() throws IOException {
		  String userNameValue=ExcelUtilities.getStringData(3,0,"Login_Page");
		  String passwordValue=ExcelUtilities.getStringData(3,1,"Login_Page");
		  Login_Page loginPage=new Login_Page(driver);
		  loginPage.enterUserNameField(userNameValue);
		  loginPage.enterPasswordField(passwordValue);
		  loginPage.clickSubmitButton();
		  boolean isAlertDisplayed=loginPage.isAlertDisplayed();
		  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORLOGIN);
		 
	  }
	  @Test
	  public void verifyUserIsAbleToLoginUsinginvalidcredentials() throws IOException {
		  String userNameValue=ExcelUtilities.getStringData(4,0,"Login_Page");
		  String passwordValue=ExcelUtilities.getStringData(4,1,"Login_Page");
		  Login_Page loginPage=new Login_Page(driver);
		  loginPage.enterUserNameField(userNameValue);
		  loginPage.enterPasswordField(passwordValue);
		  loginPage.clickSubmitButton();
		  boolean isAlertDisplayed=loginPage.isAlertDisplayed();
		  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORLOGIN);
	  }
	 
}
