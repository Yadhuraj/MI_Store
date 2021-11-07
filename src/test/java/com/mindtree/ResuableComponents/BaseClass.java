package com.mindtree.ResuableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.mindtree.Util.ChromeDriverUtil;
import com.mindtree.Util.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	public static Properties prop;
	public static Logger log;
	public static String dateFormat;
	public static ExtentReports report;
	public static ExtentTest test;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	static {
       dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date());
      System.setProperty("currenttime", dateFormat);
      report = new ExtentReports(System.getProperty("user.dir")+"//ExtentReports//"+dateFormat+"_ExtentReport.html"); 
      log =Logger.getLogger(BaseClass.class);
      FileInputStream fis = null;
      try {
		fis = new FileInputStream(System.getProperty("user.dir")+"//TestData//Apace_poi.xlsx");
		workbook = new XSSFWorkbook(fis);
	} catch (IOException e) {
		
		System.out.println("Excel reading interrupted");
	}
      sheet = workbook.getSheetAt(0);
      
  }
	
	public WebDriver Driversetup(WebDriver driver) throws IOException {
	prop = new Properties();
	File file = new File(System.getProperty("user.dir")+"//TestData//config.properties");
	FileInputStream fis = new  FileInputStream(file);
	prop.load(fis);	
	switch(prop.getProperty("browser"))
	{
	case "chrome" :{
		driver = ChromeDriverUtil.ChromeSet(prop);
		System.out.println("The Driver is setup");
		Log.testLoggerInfo(log, "DriverSet");
		break;
		
	}
	default:{
		System.out.println("The Browser does not exist");
		break;
	}
	}
	return driver;
	}
}

