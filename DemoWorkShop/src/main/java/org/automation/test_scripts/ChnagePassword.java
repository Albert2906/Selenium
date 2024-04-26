package org.automation.test_scripts;
import java.io.IOException;


import org.automation.element_repository.MyAccountPage;
import org.automation.generic_library.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class ChnagePassword extends BaseTest{
	@Test
	public void verify_User_Is_Able_To_Change_Password() throws IOException
	{
		home_page.getMyAccountButton().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Account", "Account page not displayed"); 
		Reporter.log("Account Page Displayed", true);
		
		MyAccountPage acc_Page = new MyAccountPage(driver);
		
		acc_Page.getChangePasswordLink().click();
		
		acc_Page.getOldPasswordTextField().sendKeys(data.getDataFromPropertiesFile("pwd"));
		acc_Page.getNewPasswordTextField().sendKeys(data.getDataFromPropertiesFile("pwd"));
		acc_Page.getConfirmPasswordTextField().sendKeys(data.getDataFromPropertiesFile("pwd"));
		
		acc_Page.getChangePasswordButton().click();
		
		Assert.assertEquals(acc_Page.getChangePasswordText().getText(), "Password was changed", "verify_User_Is_Able_To_Change_Password is Failed..."); 
		Reporter.log("verify_User_Is_Able_To_Change_Password is Passed...", true);
		
	}
}
