package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.SearchInSubCatagoryList_Page;

public class SearchInSubCatagoryList_Test extends Base{
  @Test(description="verify User Is Able To Search SubCatagory")
  @Parameters({"User Name","Password","Catagory","New SubCatagory"})
  public void verifyUserIsAbleToSearchSubCatagory(String userNameValue,String passwordValue,String categoryValue,String subCatagoryValue) throws IOException {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  SearchInSubCatagoryList_Page search=new SearchInSubCatagoryList_Page(driver);
	  search.openSubCatagoryPage();
	  search.clickSearchSubCatagoryButton();
	  //String categoryValue=ExcelUtilities.getStringData(1,0,"SearchSubCategory");
	  //String subCatagoryValue=ExcelUtilities.getStringData(1,1,"SearchSubCategory");
	  search.selectCatagoryValue(categoryValue);
	  search.enterSubCatagory(subCatagoryValue);
	  search.searchSubCatagory();
	  boolean isSearchDisplayed=search.isSearchResultNotDisplayed();
	  assertTrue(isSearchDisplayed,Constants.SEARCHSUBCATEGORYNOTFOUND);
  }
}
