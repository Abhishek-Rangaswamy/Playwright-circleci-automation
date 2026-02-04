package com.orangehrm.actions;

import com.microsoft.playwright.Page;

public class ActionHelper {

	protected Page page;
	
	public ActionHelper(Page page) {
		this.page = page;
	}
	
	public void launch_url(String URL) {
		page.navigate(URL);
	}
	
	public void click(String selector) {
		page.click(selector);
	}
	
	public void type(String selector, String value) {
		page.fill(selector, value);
	}
	
	public String get_title() {
		return page.title();
	}
	
}
