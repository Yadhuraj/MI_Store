package com.mindtree.StepDefinitions;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.mindtree.PageObjects.MI_LoginCheck_POM;
import com.mindtree.PageObjects.MI_Search_POM;
import com.mindtree.PageObjects.MI_Title_POM;
import com.mindtree.ResuableComponents.BaseClass;
import com.mindtree.Util.ExtentUtility;
import com.mindtree.Util.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class MI_Home_SD extends BaseClass {
	public static WebDriver driver;

	@Given("^The user lands on the expected url$")
	public void the_user_lands_on_the_expected_url() throws Throwable {
		driver = Driversetup(driver);

	}

	@When("^the title is checked$")
	public void the_title_is_checked() throws Throwable {
		test = report.startTest("Title check");
		new MI_Title_POM(driver, log, test);
		Thread.sleep(3000);

	}

	@Then("^The title is matched$")
	public void the_title_is_matched() throws Throwable {
		Log.testLoggerInfo(log, "The title matched");
		ExtentUtility.pass(test, "The title matched");
	}

	@And("^the landed on expected page$")
	public void the_landed_on_expected_page() throws Throwable {
		Log.testLoggerInfo(log, "Succesfull");
		ExtentUtility.pass(test, "SucessFull");

	}

	@Then("^close the report$")
	public void close_the_report() throws Throwable {
		report.endTest(test);
		
	}
	 


	@Given("^Navigate to the Login page$")
    public void navigate_to_the_login_page() throws Throwable {
	 test = report.startTest("Login_Check");
		new MI_LoginCheck_POM(driver, log, test);
    }
	@Then("Enter username and password")
	public void enter_username_and_password() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		MI_LoginCheck_POM.login_details(driver, log, test);
	}
	@Then("validate the Login")
	public void validate_the_login() {
	    // Write code here that turns the phrase above into concrete actions
		MI_LoginCheck_POM.validate_login(driver, log, test);
	}
	@Then("close")
	public void close() {
	    // Write code here that turns the phrase above into concrete actions
		report.endTest(test);
		
	}

	  @Given("^Click on Search bar$")
	    public void click_on_search_bar() throws Throwable {
		  test = report.startTest("Search Item");
	       MI_Search_POM.search_click(driver, log, test);
	    }

	    @Then("^Enter the Products$")
	    public void enter_the_products() throws Throwable {
	    	 MI_Search_POM.search_enter(driver, log, test);    
	    }

	    @And("^close search$")
	    public void close_search() throws Throwable {
	    	report.endTest(test);
			report.flush();
			report.close();
	    }

	

}
