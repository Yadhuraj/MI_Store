package com.mindtree.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.ResuableComponents.BaseClass;
import com.mindtree.ResuableComponents.DriverFunctions;
import com.mindtree.UIStore.LoginPage_UI;
import com.mindtree.Util.ExtentUtility;
import com.mindtree.Util.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class MI_LoginCheck_POM extends LoginPage_UI {

	public MI_LoginCheck_POM(WebDriver driver, Logger logger, ExtentTest test) throws InterruptedException {
		try {
		DriverFunctions.click(driver, login_key);
		Log.testLoggerInfo(logger, "Clicked on Sign -In");
		ExtentUtility.pass(test,  "Clicked on Sign -In");
		}
		catch (Exception e) {
			Log.testLoggerInfo(logger, "Click on Sign -In Interrupted");
			ExtentUtility.fail(test,driver,  "Click on Sign -In Interrupted");
		}
		
	}
	
	public static void login_details(WebDriver driver, Logger logger, ExtentTest test) throws InterruptedException
	{
		try {
			Thread.sleep(3000);
			DriverFunctions.sendkeys(driver,user_input, BaseClass.prop.getProperty("user"));
			Thread.sleep(3000);
			DriverFunctions.sendkeys(driver,pass_input, BaseClass.prop.getProperty("pass"));
			Thread.sleep(3000);
			DriverFunctions.click(driver,login_submit);
			Thread.sleep(3000);
			
			Log.testLoggerInfo(logger, "Crendentials Entered Sucessfully");
			ExtentUtility.pass(test,  "Crendentials Entered Sucessfully");
		}
		catch (Exception e) {
			Log.testLoggerInfo(logger, "Credentials input is interrupted");
			ExtentUtility.fail(test,driver,  "Credentials input is interrupted");
		}
		
		
	}
	
	public static void validate_login(WebDriver driver, Logger logger, ExtentTest test)
	{
		if(driver.findElement(login_confirm).isDisplayed())
		{
			Log.testLoggerInfo(logger, "Logged In Sucessfully");
			ExtentUtility.pass(test,  "Logged In Sucessfully");
		}
		else
		{
			Log.testLoggerInfo(logger, "Login Interrupted");
			ExtentUtility.fail(test,driver,  "Login Interrupted");
		}
	}
}
