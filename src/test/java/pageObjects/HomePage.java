package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public WebDriver driver;
	
	//locators
	
	@FindBy(xpath="//span[text()='Station Management' and @class='mastermenu']")
	WebElement stationManagement;
	
	@FindBy(xpath="//a[@id='Parent_6']//span")
	WebElement chargerStatus;
	
	@FindBy(xpath="//span[contains(text(),'Session Management') and @class='mastermenu']")
	WebElement sessionManagement;
	
	@FindBy(xpath="//div[@id='analyticsSubmenu_2']//a//span[text()='Registered VINs']")
	WebElement registeredVinSession;
	
	@FindBy(xpath="//span[@class='mastermenu'][normalize-space()='Role Management']")
	WebElement roleManagement;
	
	@FindBy(xpath="//a[@id='Parent_12']//span")
	WebElement managePermission;
	
	@FindBy(xpath="//span[@class='mastermenu' and text()='Roaming Network']")
	WebElement RoamingNetwork;
	
	@FindBy(xpath="//div[@id='analyticsSubmenu_21']//span[text()='Session']")
	WebElement Session;
	
	
	
	
	//constructor
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//action methods
	
	public void clickStationManagement() {
		log.info("Navigating to the station management tab");
		clickable(stationManagement);
		stationManagement.click();
		
	}
	
	
	public void clickChargerStatus() {
		log.info("Navigating to the charger status tab ");
		clickable(chargerStatus);
		chargerStatus.click();
	}
	
	public void clickSessionManagement() {
		sessionManagement.click();
	}
	
	public void clickRegisteredVin() {
		registeredVinSession.click();
	}
	
	public void clickRoleManagement() {
		roleManagement.click();
	}
	
	public void clickManagePermission() {
		managePermission.click();
	}
	
	public void clickRoamingSession() throws InterruptedException {
		RoamingNetwork.click();
		Thread.sleep(4000);
		clickable(Session);
		Session.click();	
		}
	
	
}
