package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagePermissionPage extends BasePage {

	// public WebDriver driver;

	@FindBy(id = "RoleId")
	WebElement permissionDropDown;

	@FindBy(id = "z0__ChildMenues_1__AllowThisMenu")
	WebElement registeredVinCheckBox;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement submitButton;
	
	@FindBy(xpath="//input[@id='z0__ChildMenues_1__AllowThisMenu']")
	WebElement checkbox;

	@FindBy(id = "okButton")
	WebElement okButton;

	@FindBy(xpath = "//span[contains(text(),'Session Management') and @class='mastermenu']")
	WebElement sessionManagement;
	

	
	@FindBy(xpath = "//div[@id='analyticsSubmenu_2']//a[1]//span")
	WebElement sessionManagementMenus;

	public ManagePermissionPage(WebDriver driver) {
		super(driver);
	}

	public void ClickPermissionTab() {
		Select select = new Select(permissionDropDown);
		select.selectByVisibleText("Admin");
	}

	public Boolean clickOnRegisteredVinCheckbox() {
		clickable(registeredVinCheckBox);
		registeredVinCheckBox.click();
		Boolean SelectionStatus=checkbox.isSelected();
		return SelectionStatus;

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
		String rv=sessionManagementMenus.getText();
		System.out.println(rv);
		return rv;
	}
	
	

}
