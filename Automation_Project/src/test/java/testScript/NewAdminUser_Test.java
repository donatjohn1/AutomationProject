package testScript;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.NewAdminUser_Page;
import utilities.ExcelUtilities;

public class NewAdminUser_Test extends Base{
  @Test(description="Verify wehether user can add new admin User")
  @Parameters({"New User Name","New Password","User Type"})
  public void verifyUserIsAbleToAddNewUser(String uName,String pwd,String uType) throws IOException {
	  String userNameValue=ExcelUtilities.getStringData(1,0,"Login_Page");
	  String passwordValue=ExcelUtilities.getStringData(1,1,"Login_Page");
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  NewAdminUser_Page adminUserPage=new NewAdminUser_Page(driver);
	  adminUserPage.openAdminUserPage();
	  adminUserPage.clickaddNewAdminUserButton();
	  String newUserNameValue=uName;
	  String newPasswordValue=pwd;
	  String newUserTypeValue=uType;
	  //String newUserNameValue=ExcelUtilities.getStringData(1,0,"NewAdminUser");
	  //String newPasswordValue=ExcelUtilities.getStringData(1,1,"NewAdminUser");
	  //String newUserTypeValue=ExcelUtilities.getStringData(1,2,"NewAdminUser");
	  adminUserPage.enterNewUserNameInField(uName);
	  adminUserPage.enterNewPasswordInField(pwd);
	  adminUserPage.selectUserType(uType);
	  adminUserPage.clickSaveButton();
	  boolean isAlertDisplayed=adminUserPage.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,Constants.ALERTMSGFORNEWUSERCREATED);
	    
  }
}
