package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RoamingSessionPage;
import testBase.BaseClass;

public class TC05_RoamingSession extends BaseClass {
// dependsOnMethods = { "testCases.TC01_Login.login" },
	@Test(groups= {"Smoke","Regression"})
	public void Session() throws InterruptedException {
		HomePage hp = new HomePage(getDriver());
		hp.clickRoamingSession();
		RoamingSessionPage rsp = new RoamingSessionPage(getDriver());
		rsp.calenderFilter();
		//List<WebElement> ap = rsp.getFirstSessionData();
		String sessionCount=rsp.getSessionCount();
		System.out.println("Session= "+sessionCount);
		rsp.clickStartSession();
		String startSessionCount = rsp.getSessionCount();
		System.out.println("Start Session= "+startSessionCount);
		rsp.clickStopSession();
		String stopSessionCount = rsp.getSessionCount();
		System.out.println("Stop Session= "+stopSessionCount);
		
	}

}
