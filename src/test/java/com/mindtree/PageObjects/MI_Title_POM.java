package com.mindtree.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.Util.ExtentUtility;
import com.mindtree.Util.Log;
import com.mindtree.exception.PageObjectRException;
import com.relevantcodes.extentreports.ExtentTest;

public class MI_Title_POM {

	public MI_Title_POM(WebDriver driver, Logger logger, ExtentTest test) {
		try {
			System.out.println(driver.getTitle());
			if (driver.getTitle()
					.equalsIgnoreCase("Xiaomi India | Mobile | TV | Fitness | Smart Home | Lifestyle - Mi Indi")) {
				
				Log.testLoggerInfo(logger, "Navigated to the expected page");
				ExtentUtility.pass(test, "Navigated to the expected page");
			} else {
				throw new PageObjectRException("Did not navigate to the expected page");
			}

		} catch (PageObjectRException e) {
			Log.testLoggerInfo(logger, e.toString());
			ExtentUtility.fail(test, driver,e.toString());
		}

	}

}
