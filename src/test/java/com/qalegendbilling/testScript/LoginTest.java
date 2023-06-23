package com.qalegendbilling.testScript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import com.qalegendbilling.automationCore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class LoginTest extends Base {
	LoginPage login;
	HomePage home;
	RandomUtility random;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority=1,enabled=true,description="TC_001_verifyUserLoginwithValidCredentials",groups= {"Regression"})
	public void TC_001_verifyUserLoginwithValidCredentials() {
		List<ArrayList <String>> data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(1).get(0);
		String psword=data.get(1).get(1);
		login= new LoginPage(driver);
		home=new HomePage(driver);
		login.enterUserCredential(uname, psword);
		login.clickOnLoginButton();
		home.clickOnEndTourButton();
		//String actAcntUser=home.getUserAcntName();
		//String actUserLogin = login;
		//Assert.assertEquals(actErrorMessage, expErrMessage, ErrorMessages.INVALID_ERROR_MESSAGE);
		//String actUsername= login.getLoginUserName()
	}
	@Test
	public void TC_002_verifyErrorMessageDisplayedForInvalidCredentials() {
		List<ArrayList <String>> data=ExcelUtility.excelDataReader("LoginPage");
		String expErrorMsg=data.get(1).get(2);
		random=new RandomUtility();
		login=new LoginPage(driver);
		String email=random.getRandomEmail();
		String password=random.getPassword();
		login.enterUserCredential(email, password);
		login.clickOnLoginButton();
		String actmsg=login.getErrorMsg();
		Assert.assertEquals(actmsg, expErrorMsg,ErrorMessage.INVALID_ERROR_MESSAGE);
	}
	

}
