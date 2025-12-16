package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChargerStatusPage extends BasePage {

	public WebDriver driver;

	// locators
	// @FindBy locator store elements of previous dome if still the grid is
	// refreshed - Promblem - use locator with By

//	By gp = By.xpath("//table[@data-role='selectable']");
//	By al = By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]//a");
//

	@FindBy(xpath = "//h3[contains(@class,'count')]")
	List<WebElement> allCounts;

//	@FindBy(xpath = "//table[@data-role='selectable']")
//	WebElement gridPresence;

	@FindBy(xpath = "//a[contains(text(),'Charger Code')]/preceding-sibling::a[@class='k-grid-filter']/span")
	WebElement chargerCodeFilter;

	@FindBy(xpath = "//input[@title='Value']")
	WebElement chargerCodeValue;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;

	@FindBy(xpath = "//tbody/tr[1]/td[1]/a[1]")
	WebElement activelink;

	// constructor

	public ChargerStatusPage(WebDriver driver) {
		super(driver);
	}

	// action methods

	public void getAllChargerCount() {
		log.info("Getting various charger count");
		System.out.println("Connected count: " + allCounts.get(0).getText());
		System.out.println("Disconnected count: " + allCounts.get(1).getText());
		System.out.println("Error count: " + allCounts.get(2).getText());
		System.out.println("All count: " + allCounts.get(3).getText());
		System.out.println("Deleted count: " + allCounts.get(4).getText());
	}

	public void clickChargerCodeFilter() throws InterruptedException {
		Thread.sleep(3000);
		// visible(gridPresence);
		visible(chargerCodeFilter);
		chargerCodeFilter.click();
		Thread.sleep(2000);
	}

	public void clickChargerCodeFilterTextbox() {
		chargerCodeValue.sendKeys("VKAAFKK0007");
		clickable(submitButton);
		submitButton.click();
		refreshElements();
	}

	public void refreshElements() {
		PageFactory.initElements(driver, this);
	}

	public void clickActiveLink() {
		log.info("Clicking active link");
		clickable(activelink);

		activelink.click();
		log.info("Switching windows");

		switchToWindowByIndex(1);

	}

}
