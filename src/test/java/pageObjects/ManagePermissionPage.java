package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ManagePermissionPage extends BasePage {

	// public WebDriver driver;

	@FindBy(id = "RoleId")
	WebElement permissionDropDown;

	@FindBy(id = "z0__ChildMenues_1__AllowThisMenu")
	WebElement registeredVinCheckBox;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement submitButton;

	@FindBy(id = "okButton")
	WebElement okButton;

	@FindBy(xpath = "//span[contains(text(),'Session Management') and @class='mastermenu']")
	WebElement sessionManagement;
	
	@FindBy(xpath = "//div[@id='analyticsSubmenu_2']//a//span")
	List<WebElement> sessionManagementMenus; //List<WebElement> allCounts;

	public ManagePermissionPage(WebDriver driver) {
		super(driver);
	}

	public void ClickPermissionTab() {
		Select select = new Select(permissionDropDown);
		select.selectByVisibleText("Admin");
	}

	public void clickOnRegisteredVinCheckbox() {
		clickable(registeredVinCheckBox);
		registeredVinCheckBox.click();

	}

	public void clickSubmitButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(submitButton).perform();
		submitButton.click();
	}

	public void clickOkButton() {
		visible(okButton);
		okButton.click();
		driver.navigate().refresh();

	}
	
	public void clickSessionManagement() {
		sessionManagement.click();
	}
	
	public String clickSessionManagementAndGetMenusName() throws InterruptedException {
		Thread.sleep(2000);
		String rv=sessionManagementMenus.get(0).getText();
		System.out.println(rv);
		return rv;
	}
	
	

}
