package com.orangehrm.stepdefinitions;

import java.util.regex.Pattern;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.orangehrm.pageinitializer.PageInitializer;
import com.orangehrm.reports.ExtentTestManager;
import com.orangehrm.utils.LoadConfigProperties;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LaunchOrangeHRMSteps extends PageInitializer {

	@Given("the user navigates to the OrangeHRM URL")
	public void the_user_navigates_to_the_orange_hrm_url() {
	    actionHepler.launch_url(LoadConfigProperties.getProperty("url"));
	    ExtentTestManager.getTest().info("Navigated to URL: " + page.url());
	}

	@Then("the OrangeHRM login page should be displayed")
	public void the_orange_hrm_login_page_should_be_displayed() {
	    String title = actionHepler.get_title();
	    System.out.println("Page Title: " + title);
	    PlaywrightAssertions.assertThat(page).hasTitle(Pattern.compile("OrangeHRM"));
	    ExtentTestManager.getTest().pass("Login page is displayed with title: " + title);
	}

	
}
