package com.mindtree.PageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mindtree.ResuableComponents.BaseClass;
import com.mindtree.ResuableComponents.DriverFunctions;
import com.mindtree.UIStore.SearchItem_UI;
import com.mindtree.Util.ExcelSheet;
import com.mindtree.Util.ExtentUtility;
import com.mindtree.Util.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class MI_Search_POM extends SearchItem_UI {

	public static void search_click(WebDriver driver, Logger logger, ExtentTest test) {
		try {
			DriverFunctions.click(driver, search_click);
			Log.testLoggerInfo(logger, "Search Bar Clicked");
			ExtentUtility.pass(test, "Search Bar Clicked");
		} catch (Exception e) {
			Log.testLoggerError(logger, "Search bar click interrupted");
			ExtentUtility.fail(test, driver, "Search bar click interrupted");
		}
	}

	public static void search_enter(WebDriver driver, Logger logger, ExtentTest test)
			throws IOException, InterruptedException {
		try {
			for (int i = 0; i < BaseClass.sheet.getPhysicalNumberOfRows(); i++) {
				DriverFunctions.sendkeys(driver, search_click, ExcelSheet.Excelread(i, 0));
				Thread.sleep(3000);
				DriverFunctions.sendkeys(driver, search_click, Keys.ENTER);
				Thread.sleep(3000);
				DriverFunctions.click(driver, item_mobile);
				Thread.sleep(3000);
				DriverFunctions.click(driver, home);
				Thread.sleep(3000);
			}

			Log.testLoggerInfo(logger, "Item Entered");
			ExtentUtility.pass(test, "Item Entered");
		} catch (Exception e) {
			Log.testLoggerError(logger, "Item input interrupted");
			ExtentUtility.fail(test, driver, "Item input interrupted");
		}

	}

}
