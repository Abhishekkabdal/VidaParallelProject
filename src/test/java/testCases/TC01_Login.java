package testCases;



import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.ConfigUtility;

public class TC01_Login extends BaseClass {

    // ✅ Proper Logger declaration
    private static final Logger log = LogManager.getLogger(TC01_Login.class);

    @Test(groups= {"Smoke"})
    public void login() {

    	LoginPage lp = new LoginPage(getDriver());

    	
     //   LoginPage lp = new LoginPage(driver);
        log.info("Login test started");
        log.trace("Trace level logging");
        log.debug("Debug level logging");
        lp.passLoginId(ConfigUtility.getLoginID());
        lp.passPassword(ConfigUtility.getPassword());
        lp.clickLogin();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("VIDA - Maps"));

        Assert.assertEquals(getDriver().getTitle(), "VIDA - Maps");

        log.info("Login test executed successfully");
    }
}
