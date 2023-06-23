package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _userAcntName = "//a[@class='dropdown-toggle']";
	@FindBy(xpath = _userAcntName)
	private WebElement userAcntName;
	private final String _endTourButton = "//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath = _endTourButton)
	private WebElement endTourButton;
	private final String _signOutButton = "//div[@class='pull-right']//a";
	@FindBy(xpath = _signOutButton)
	private WebElement signOutButton;
	private final String _userManagementdrpdwn = "//span[text()='User Management']";
	@FindBy(xpath = _userManagementdrpdwn)
	private WebElement userManagementdrpdwn;
	private final String _UserManagementUsers = "//i[@class='fa fa-user']//following-sibling::span";
	@FindBy(xpath = _UserManagementUsers)
	private WebElement UserManagementUsers;
	private final String _UserManagementRoles = "//i[@class='fa fa-briefcase']//following-sibling::span";
	@FindBy(xpath = _UserManagementUsers)
	private WebElement UserManagementRoles;
	private final String _UserManagementSales = "//i[@class='fa fa-handshake-o']//following-sibling::span";
	@FindBy(xpath = _UserManagementUsers)
	private WebElement UserManagementSales;

	public void clickOnEndTourButton() {
		endTourButton.click();
	}

	public void getUserAcntName() {
		userAcntName.isDisplayed();

	}

	public void clickOnuserAcntName() {
		userAcntName.click();
	}

	public LoginPage clickOnSignout() {
		signOutButton.click();
		return new LoginPage(driver);

	}

	public void clickOnUserManagement() {
		userManagementdrpdwn.click();
		wait.waitForElementToBeVisible(driver, UserManagementSales);
	}

	public boolean usersMenuIsDisplayed() {
		boolean status = UserManagementUsers.isDisplayed();
		return status;
	}

	public boolean roleMenuIsDisplayed() {
		boolean status = UserManagementRoles.isDisplayed();
		return status;
	}

	public boolean salesCommisionMenuIsDisplayed() {
		boolean status = UserManagementSales.isDisplayed();
		return status;
	}

	public AddUsersPage clickOnUserManagementUsers() {
		UserManagementUsers.click();
		return new AddUsersPage(driver);
	}

}
