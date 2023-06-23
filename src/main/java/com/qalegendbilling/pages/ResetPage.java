package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class ResetPage extends TestHelperUtility {
	public WebDriver driver;
	public ResetPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//private final String _email ="email";
	@FindBy(id="email")
	private WebElement emailField;
	@FindBy (xpath="//input[@id='email']/following::span[@class='help-block']//strong")
	private WebElement invalidmsgdisplay;
	@FindBy (xpath="//button[@type='submit']")
	private WebElement resetButton;
	public void  enterInvalidEmailId(String email) {
		page.enterText(emailField, email);
		
	}
	public String getInvalidResetMsg() {
		//wait.setHardWait();
		String invalidmsg=page.getElementText(invalidmsgdisplay);
		return invalidmsg;
	}
	public void resetButtonClick() {
		resetButton.click();
	}

}
