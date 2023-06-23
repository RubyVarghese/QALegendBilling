package com.qalegendbilling.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtility {
	public void enterText(WebElement element,String text) {
		element.sendKeys(text);
	}
	public String getElementText(WebElement elemenet) {
		String text=elemenet.getText();
		return text;
			
	}
	public void clickOnElemenet(WebElement element) {
		element.click();
	}
	public String getMessage(WebElement element) {
		return element.getText();
	}
	public String getPageTitle(WebDriver driver) {
		String title=driver.getTitle();
		return title;
		
	}
	public void getUserManagementlist(WebElement element) {
		element.isDisplayed();
	}

}
