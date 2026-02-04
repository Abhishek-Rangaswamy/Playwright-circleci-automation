package com.orangehrm.pages;

import com.microsoft.playwright.Page;
import com.orangehrm.actions.ActionHelper;

public class LoginPage extends ActionHelper {

	public LoginPage(Page page) {
		super(page);
	}
	
	@Override
	public void click(String selector) {
		page.waitForSelector(selector);
		page.click(selector);
	}
	
	public void logout(String selector) {
		click(selector);
	}

}
