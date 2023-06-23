package com.qalegendbilling.testScript;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import com.qalegendbilling.automationCore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class HomeTest extends Base {
	LoginPage login;
	HomePage home;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority=1,enabled=true,description="TC_004_verifySignout",groups= {"Smoke"})
	public void TC_004_verifySignout() {
		List<ArrayList <String>> data=ExcelUtility.excelDataReader("LoginPage");
		login= new LoginPage(driver);
		home=new HomePage(driver);
		String uname=data.get(1).get(0);
		String psword=data.get(1).get(1);
		login.enterUserCredential(uname, psword);
		login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnuserAcntName();
		home.clickOnSignout();
		String acttitle=login.getLoginPageTitle();
		String expTitle="Login - Demo POS";
		Assert.assertEquals(acttitle, expTitle,ErrorMessage.INVALID_ERROR_MESSAGE);
	}
	@Test
	public void TC_005_verifyUserManagementDropdown() {
		List<ArrayList <String>> data=ExcelUtility.excelDataReader("LoginPage");
		login= new LoginPage(driver);
		home=new HomePage(driver);
		String uname=data.get(1).get(0);
		String psword=data.get(1).get(1);
		login.enterUserCredential(uname, psword);
		login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		boolean userMenuStatus=home.usersMenuIsDisplayed();
		Assert.assertTrue(userMenuStatus,ErrorMessage.INVALID_ERROR_MESSAGE);
		boolean roleMenustatus=home.roleMenuIsDisplayed();
		Assert.assertTrue(roleMenustatus,ErrorMessage.INVALID_ERROR_MESSAGE);
		boolean salesMenustatus=home.salesCommisionMenuIsDisplayed();
		Assert.assertTrue(salesMenustatus,ErrorMessage.INVALID_ERROR_MESSAGE);
		
		
	}
	
	
	

}
