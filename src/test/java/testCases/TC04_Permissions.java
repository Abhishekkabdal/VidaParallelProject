package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ManagePermissionPage;
import testBase.BaseClass;

public class TC04_Permissions extends BaseClass {
	// dependsOnMethods = { "testCases.TC01_Login.login" },
	@Test(groups= {"Regression","Sanity"})
	public void Permission() throws InterruptedException {
		HomePage hp=new HomePage(getDriver());	
		hp.clickRoleManagement();
		hp.clickManagePermission();
		ManagePermissionPage mp=new ManagePermissionPage(getDriver());
		mp.ClickPermissionTab();
		mp.clickOnRegisteredVinCheckbox();
		mp.clickSubmitButton();
		mp.clickOkButton();
		mp.clickSessionManagement();
		String exp="Registered VINs";	
		String act=mp.clickSessionManagementAndGetMenusName();
		Assert.assertEquals(act, exp, "No registered vin sub menu is present,Role Permission working Fine");
		
	}
	
}
