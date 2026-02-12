package com.orangehrm.hooks;

import com.aventstack.extentreports.ExtentTest;
import com.orangehrm.base.BaseTest;
import com.orangehrm.reports.ExtentManager;
import com.orangehrm.reports.ExtentTestManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest{
	
	@Before
	public static void beforeScenario(Scenario scenario) {
		
		System.out.println("Before Scenario: " + scenario.getName());
		
		ExtentTest extentTest = ExtentManager.getExtentReport().createTest(scenario.getName());
		ExtentTestManager.setTest(extentTest);
		
	}
	
	@After
	public static void afterAll() {
		
	}
	
}
