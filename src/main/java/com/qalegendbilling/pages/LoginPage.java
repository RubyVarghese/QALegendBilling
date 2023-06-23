package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility{
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	private final String _userNameField="username";
	@FindBy (id=_userNameField)
	private WebElement userNameField;
	private final String _passwordField="password";
	@FindBy (id=_passwordField)
	private WebElement passwordField;
	private final String _loginButton="//button[@class='btn btn-primary']";
	@FindBy(xpath=_loginButton)
	private WebElement loginButton;
	private final String _forgotPassword="//a[@class='btn btn-link']";
	@FindBy (xpath=_forgotPassword)
	private WebElement forgotPassword;
	private final String _errorMsg="//span[@class='help-block']//strong";
	@FindBy (xpath=_errorMsg)
	private WebElement errorMsg;
	public void enterUserCredential(String uname, String psword) {
		page.enterText(userNameField, uname);
		page.enterText(passwordField, psword);
		
	}
	public HomePage clickOnLoginButton() {
		loginButton.click();
		return new  HomePage(driver);
	}
	public String getLoginUserName() {
		String loginUser= page.getElementText(userNameField);
		return loginUser;
	}
	public ResetPage clickforgotPassword() {
		forgotPassword.click();
		return new ResetPage(driver);
	}
	public String getErrorMsg() {
		String msg=page.getMessage(errorMsg);
		return msg;
	}
	public String getLoginPageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}

}
