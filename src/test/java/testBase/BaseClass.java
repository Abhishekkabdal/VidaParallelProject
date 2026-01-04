package testBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.LoginPage;

public class BaseClass {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	@Parameters({ "browser", "username", "password" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String username, String password) throws MalformedURLException {

		driver.set(createRemoteDriver(browser));

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		getDriver().get("https://charging-dev.vidaworld.com/Account/Login");

		LoginPage lp = new LoginPage(getDriver());
		lp.passLoginId(username);
		lp.passPassword(password);
		lp.clickLogin();

		new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.titleContains("VIDA - Maps"));
	}

	private WebDriver createRemoteDriver(String browser) throws MalformedURLException {

		URL gridUrl = new URL("http://localhost:5555/wd/hub");

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--disable-extensions");
            //options.addArguments("--headless=new");
			//options.addArguments("--window-size=1920,1080");
			//options.setPlatformName("LINUX");
			return new RemoteWebDriver(gridUrl, options);

		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			//options.setPlatformName("LINUX");
			//options.addArguments("--headless");
			return new RemoteWebDriver(gridUrl, options);

		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--disable-extensions");
			//options.setPlatformName("LINUX");
		    //options.addArguments("--headless=new");
			return new RemoteWebDriver(gridUrl, options);

		} else { 
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		getDriver().quit();
		driver.remove();
	}
}
