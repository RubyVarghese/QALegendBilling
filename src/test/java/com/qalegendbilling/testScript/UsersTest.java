package com.qalegendbilling.testScript;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationCore.Base;
import com.qalegendbilling.listeners.TestListener;

public class UsersTest extends Base{
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

}
