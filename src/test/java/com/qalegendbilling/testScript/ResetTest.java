package com.qalegendbilling.testScript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationCore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class ResetTest extends Base {
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	LoginPage login;
	ResetPage reset;
	@Test
	public void TC_003_verifyForgotPassword() {
		login=new LoginPage(driver);
		reset=login.clickforgotPassword();
		List<ArrayList <String>> data=ExcelUtility.excelDataReader("ResetPage");
		String expInvalidMsg=data.get(1).get(0);
		String invalidEmail=RandomUtility.getRandomEmail();
		reset.enterInvalidEmailId(invalidEmail);
		reset.resetButtonClick();
		String actInvalidMsg=reset.getInvalidResetMsg();
		Assert.assertEquals(expInvalidMsg, actInvalidMsg,ErrorMessage.INVALID_ERROR_MESSAGE);
		
		
		
	}

}
