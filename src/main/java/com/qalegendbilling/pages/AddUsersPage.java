package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class AddUsersPage extends TestHelperUtility {
	public WebDriver driver;
	public AddUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _addUsers="//a[@class='btn btn-block btn-primary']";
	@FindBy (xpath=_addUsers)
	private WebElement addUsers;
	private final String _prefix="//input[@id='surname']";
	@FindBy(xpath=_prefix)
	private WebElement prefix;
	private final String _firstName="//input[@id='first_name']";
	@FindBy (xpath=_firstName)
	private WebElement firstName;
	private final String _lastName="//input[@id='last_name']";
	@FindBy (xpath=_lastName)
	private WebElement lastName;
	private final String _userEmail="//input[@id='email']";
	@FindBy (xpath=_userEmail)
	private WebElement userEmail;
	private final String _uName="//input[@id='username']";
	@FindBy(xpath=_uName)
	private WebElement uName;
	private final String _password="//input[@id='password']";
	@FindBy (xpath=_password)
	private WebElement password;
	private final String _confirmPassword="//input[@id='confirm_password']";
	@FindBy (xpath=_confirmPassword)
	private WebElement confirmPassword;
	private final String _salespercent="//input[@id='cmmsn_percent']";
	@FindBy (xpath=_salespercent)
	private WebElement salespercent;
	private final String _saveButton="//button[@id='submit_user_button']";
	@FindBy (xpath=_saveButton)
	private WebElement saveButton;
	private final String _search="//input[@class='form-control input-sm']";
	@FindBy (xpath=_search)
	private WebElement search;
	private final String _errorMessage="//td[@class='dataTables_empty']";
	@FindBy (xpath=_errorMessage)
	private WebElement errorMessage;
	
	public void clickOnAddUserButton() {
		addUsers.click();
	}
	public void enteraddUserDetails(String fName,String lName,String email,String userName,String psword,String confrmPassword) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		userEmail.sendKeys(email);
		uName.sendKeys(fName);
		password.sendKeys(psword);
		confirmPassword.sendKeys(confrmPassword);
		
	}
	public AddUsersPage clickOnSaveButton() {
		saveButton.click();
		return new AddUsersPage(driver);
	}
	public String searchAddedUser(String uName)  {
		search.sendKeys(uName);
		return uName;
	}
	public String getErrorMsg() {
		String msg=page.getMessage(errorMessage);
		return msg;
	}
	

}
