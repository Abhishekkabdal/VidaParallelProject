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
		Boolean statusofcheckbox=mp.clickOnRegisteredVinCheckbox();
		
		
		System.out.println(statusofcheckbox);
		mp.clickSubmitButton();
		mp.clickOkButton();
		mp.clickSessionManagement();
		String act=mp.clickSessionManagementAndGetMenusName();
		
		if(statusofcheckbox) {
			System.out.println("Registered Vins tab selected");
			Assert.assertEquals(act,"Registered VINs");
			System.out.println("Registered Vin Tab present, roles permissions working Fine");
		}
		else {
			System.out.println("Registered Vin tab unselected");
			Assert.assertEquals(act,"Un-Registered VINs");
			System.out.println("Un-Registered Vin Tab present, roles permissions working Fine");
		}
		
		
	
		
		//mp.clickSessionManagement();
			
		
		
	}
	
}
