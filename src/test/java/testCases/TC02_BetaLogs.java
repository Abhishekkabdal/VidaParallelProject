package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ChargerDashboardPage;
import pageObjects.ChargerStatusPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC02_BetaLogs extends BaseClass {
	
	private static final Logger log = LogManager.getLogger(TC02_BetaLogs.class);
// dependsOnMethods = { "testCases.TC01_Login.login" },
	@Test(groups= {"Smoke","Sanity"})
	public void chargerLogs() throws InterruptedException {
		System.out.println("Now you are logged in, Beta logs test can run");
		log.info("================Beta Logs Test started ===================");
		HomePage hp = new HomePage(getDriver());

		hp.clickStationManagement();
		hp.clickChargerStatus();
		log.info("Opening charger status page");
		ChargerStatusPage csp = new ChargerStatusPage(getDriver());
		csp.getAllChargerCount();
		// csp.clickChargerCodeFilter();
		// csp.clickChargerCodeFilterTextbox();
		csp.clickActiveLink();
		ChargerDashboardPage cdp = new ChargerDashboardPage(getDriver());
		Boolean res = cdp.clickOnChargerLogsBeta();
		log.info("Computing result");
		Assert.assertEquals(true, res);
		

	}

}
