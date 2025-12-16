package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChargerDashboardPage extends BasePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//ul[@role='tablist']//li[5]//a")
	WebElement chargerLogsBeta;
	
	@FindBy(xpath="//td[@role='gridcell']")
	WebElement gridData;
	
	
	
	public ChargerDashboardPage(WebDriver driver) {
		super(driver);
		log.info("Opened charger dashboard page");
	}
	
	
	
	public Boolean clickOnChargerLogsBeta() {
		log.info("Clicking on beta logs tab");
		clickable(chargerLogsBeta);
		chargerLogsBeta.click();
		visible(gridData);
		Boolean gdata=gridData.isDisplayed();
		return gdata;
		
	}
	

}
