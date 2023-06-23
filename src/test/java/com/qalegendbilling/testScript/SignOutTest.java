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
import com.qalegendbilling.pages.SignOutPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class SignOutTest extends Base{
	SignOutPage signout;
	LoginPage login;
	HomePage home;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test
	public void TC_004_verifySignout() {
		
		
		
		
	}

}
