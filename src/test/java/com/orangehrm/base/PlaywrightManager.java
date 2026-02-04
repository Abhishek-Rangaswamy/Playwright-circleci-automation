package com.orangehrm.base;

import com.microsoft.playwright.Page;

public class PlaywrightManager {

	private static Page page;
	
	public static void setPage(Page p) {
		page = p;
	}
	
	public static Page getPage() {
		return page;
	}
	
}
