package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoamingSessionPage extends BasePage {

	@FindBy(xpath = "//button[@id='daterange-btn']")
	WebElement calender;

	@FindBy(xpath = "//li[normalize-space()='Last 30 Days']")
	WebElement lastThirtyDays;

//	@FindBy(xpath = "//button[normalize-space()='Apply']")
//	WebElement applyButton;

	@FindBy(xpath = "//a[normalize-space()='Sessions']")
	WebElement session;

	@FindBy(xpath = "//a[normalize-space()='Start Sessions']")
	WebElement startSession;

	@FindBy(xpath = "//a[normalize-space()='Stop Sessions']")
	WebElement stopSession;

//	@FindBy(xpath = "//span[@class='k-pager-info k-label']")
//	WebElement totalSessionCount;
	
//	@FindBy(xpath = "//tbody[@role='rowgroup']//tr[1]//td")
//	List<WebElement> firstSessionData;
	
	
	
	By totalSessionCount = By.xpath("//span[@class='k-pager-info k-label']");

	
	


	public RoamingSessionPage(WebDriver driver) {
		super(driver);
	}
	
	

	public void calenderFilter() {
		
		calender.click();
		lastThirtyDays.click();
		//applyButton.click();

	}
	

	
	public String getSessionCount() throws InterruptedException {
		Thread.sleep(3000);
	    String allCount= getTextAfterRefresh(totalSessionCount);
	    String n=allCount.replaceAll(".*of\\s*", "").replaceAll("[^0-9]", "");
		return n;
	}
	
	public void clickStartSession() {
		startSession.click();
	}
	
	public void clickStopSession() {
		stopSession.click();
	}
	

//	public List<WebElement> getFirstSessionData() {
//		return firstSessionData;
//	}
	
	
	

	
}
