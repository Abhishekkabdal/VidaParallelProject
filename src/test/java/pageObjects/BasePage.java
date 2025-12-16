package pageObjects;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Logger log;

	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		this.log = LogManager.getLogger(this.getClass());
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		log.info("Initialized Page: " + this.getClass().getSimpleName());
		// applyDefaultZoom();
	}

	// --------------------Page Zoom level -------------------------//
//	private void applyDefaultZoom() {
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//	    js.executeScript("document.body.style.zoom='80%'");
//	}

	protected void waitVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void waitPresence(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected void waitForStaleness(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));
	}

//	protected void  waitForGridToLoad(List<WebElement> element) {
//	    wait.until(ExpectedConditions.visibilityOfAllElements(element));
//	}

	// --------------------Dynamic locator----------------------//

	protected String getTextAfterRefresh(By locator) {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));

		return element.getText();
	}

//	

	// ------------------------------------------------------------//

	protected void visible(WebElement element) {
		waitVisible(element);
	}

	protected void staleness(WebElement element) {
		waitForStaleness(element);
	}

	protected void clickable(WebElement element) {
		waitClickable(element);
	}

//	protected void allDataPresence(List<WebElement> ap) {
//		waitForGridToLoad(ap);
//	}

	protected WebElement presence(By locator) {
		waitPresence(locator);
		return driver.findElement(locator);
	}

	protected void switchToWindowByIndex(int index) {
		ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(index));
	}

}