package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisteredSessionsPage;
import testBase.BaseClass;

public class TC03_Sessions extends BaseClass {
	//dependsOnMethods = { "testCases.TC01_Login.login" },
	@Test(groups= {"sanity"})
	public void Session() throws InterruptedException {
		HomePage hp=new HomePage(getDriver());
		hp.clickSessionManagement();
		hp.clickRegisteredVin();
		RegisteredSessionsPage sp=new RegisteredSessionsPage(getDriver());
		sp.cf();
		String newcount=sp.sc();
		System.out.println("New Session:"+newcount);
		Assert.assertTrue(newcount!="");
		String completedcount=sp.clickCompletedBookingTab();
		System.out.println("Completed Session:"+completedcount);
		String cancelledcount=sp.clickCancelledBookingTab();
		System.out.println("Cancelled Session:"+cancelledcount);
		
		
	}

}
