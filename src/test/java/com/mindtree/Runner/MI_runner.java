package com.mindtree.Runner;

import org.junit.runner.RunWith;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",
glue= {"com.mindtree.StepDefinitions"},
monochrome = true)
public class MI_runner extends AbstractTestNGCucumberTests{
	


}

