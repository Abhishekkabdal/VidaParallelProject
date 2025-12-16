package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public WebDriver driver;

	// Locators

	@FindBy(xpath = "//input[@id='LoginId']")
	WebElement loginId;

	@FindBy(xpath = "//input[@id='password-field']")
	WebElement password;

	@FindBy(xpath = "//input[@type='button']")
	WebElement loginButton;

	// Constructor

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// ActionMethods

	public void passLoginId(String uid) {
		loginId.sendKeys(uid);
		log.info("Attempting login with userID: " + uid);

	}

	public void passPassword(String pass) {
		password.sendKeys(pass);
		log.info("Attempting login with password: " + pass);

	}

	public void clickLogin() {
		loginButton.click();
		log.info("Attempting login by clicking login button");

	}

}
