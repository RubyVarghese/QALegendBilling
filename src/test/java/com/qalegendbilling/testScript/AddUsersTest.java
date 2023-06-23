package com.qalegendbilling.testScript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationCore.Base;
import com.qalegendbilling.constants.ErrorMessage;
import com.qalegendbilling.listeners.TestListener;
import com.qalegendbilling.pages.AddUsersPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;
import com.qalegendbilling.utilities.WaitUtility;

public class AddUsersTest extends Base {
	LoginPage login;
	HomePage home;
	AddUsersPage addUser;
	RandomUtility random;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test
	public void TC_006_verifyUserPage(){
		List<ArrayList <String>> data=ExcelUtility.excelDataReader("LoginPage");
		login= new LoginPage(driver);
		home=new HomePage(driver);
		addUser=new AddUsersPage(driver);
		String uname=data.get(1).get(0);
		String psword=data.get(1).get(1);
		login.enterUserCredential(uname, psword);
		login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		home.clickOnUserManagementUsers();
		addUser.clickOnAddUserButton();
		List<ArrayList <String>> exceldata=ExcelUtility.excelDataReader("AddUserPage");
		String prefix=exceldata.get(1).get(0);
		//String prefix="Mrs";
		String fName=random.getfName();
		String lName=random.getlName();
		String email=random.getRandomEmail();
		//String userName=random.getfName()+random.getlName();
		String password=fName+"@123";
		String confirmPassword=password;
		String salesCommision=exceldata.get(1).get(1);
		addUser.enteraddUserDetails(fName,lName,email,uname,password,confirmPassword);
		addUser.clickOnSaveButton();
			
	}
	@Test
	public void TC_007_verifyUsersfromAddedUsers() throws InterruptedException {
		List<ArrayList <String>> data=ExcelUtility.excelDataReader("LoginPage");
		login= new LoginPage(driver);
		home=new HomePage(driver);
		addUser=new AddUsersPage(driver);
		String uname=data.get(1).get(0);
		String psword=data.get(1).get(1);
		login.enterUserCredential(uname, psword);
		login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		home.clickOnUserManagementUsers();
		String uName=random.getfName()+random.getlName();
		addUser.searchAddedUser(uName);
		Thread.sleep(2000);
		List<ArrayList <String>> errorMsgData=ExcelUtility.excelDataReader("AddUserPage");
		String actmsg=addUser.getErrorMsg();
		String expErrorMsg=errorMsgData.get(1).get(2);
		Assert.assertEquals(actmsg, expErrorMsg,ErrorMessage.INVALID_ERROR_MESSAGE);
		
	}
}
