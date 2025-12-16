package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisteredSessionsPage extends BasePage {

	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='LoginId']")
	WebElement loginId;
	
	@FindBy(xpath="//a[@id='NewBookings']")
	WebElement bookingNewTab;
	
	@FindBy(xpath="//a[@id='CompletedBookings']")
	WebElement bookingCompletedTab;																																								
	
	@FindBy(xpath="//a[@id='CancelledBookings']")
	WebElement bookingCancelledTab;
	
	@FindBy(xpath="//button[@id='daterange-btn']")
	WebElement calender;
	
	@FindBy(xpath="//li[@data-range-key='Last 30 Days']")
	WebElement calenderLast30days;
	
	@FindBy(xpath="//span[@class='k-pager-info k-label']")
	WebElement sessionCount;
	
	
	public RegisteredSessionsPage(WebDriver driver) {
		super(driver);
	}
	
	public void cf() {
		calender.click();
		calenderLast30days.click();
	}
	
	public String sc() throws InterruptedException {
		visible(sessionCount);
		Thread.sleep(3000);
		String count=sessionCount.getText();
		String n=count.replaceAll(".*of\\s*", "").replaceAll("[^0-9]", "");
		return n;
	}
	
	public String clickCompletedBookingTab() throws InterruptedException {
		bookingCompletedTab.click();
		String a=sc();
		return a;
		
	}
	
	public String clickCancelledBookingTab() throws InterruptedException {
		bookingCancelledTab.click();
		String h=sc();
		return h;
	}
	

}
